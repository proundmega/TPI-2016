using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using ParcialTPI.vistas.Conexion;
using ParcialTPI.vistas.Mapeo;

namespace ParcialTPI.vistas.Controladores
{

    public abstract class AbstractPaginadoRest<T> : AbstractPaginado<T> where T : new()
    {
        protected AbstractClienteRest<T> clienteRest;
        private Boolean hayFiltrado; 

        public AbstractPaginadoRest(AbstractClienteRest<T> clienteRest) : base()
        {
            this.clienteRest = clienteRest;
            listaValoresActuales = clienteRest.FindAllDatos();
            actualizarConteo();
            hayFiltrado = false;
        }

        protected override void actualizarConteo()
        {
            setCantidadTotal(listaValoresActuales.Count);
        }

        public override List<T> GetListaDatos()
        {

            var listaPaginado = new List<T>();
            var listaFiltrada = FiltrarListaDatos();
            setCantidadTotal(listaFiltrada.Count);

            if(hayFiltrado) {
                hayFiltrado = false;
                setValorInicial(0);
            }

            for (int i = getValorInicial(); HayValorSiguiente(i); i++)
            {
                listaPaginado.Add(listaFiltrada.ElementAt(i));
            }

            return listaPaginado;
        }

        private Boolean HayValorSiguiente(int i)
        {
            return i < getValorInicial() + TAMANIO_PAGINADO && i < getCantidadTotal();
        }

        protected void NotificarAplicacionFiltro()
        {
            this.hayFiltrado = true;
        }

        protected abstract List<T> FiltrarListaDatos();

    }

    class ExamenController : AbstractPaginadoRest<Examen>
    {
        private Examen examenSeleccionado;
        private Boolean haySeleccion;
        private String filtro;

        public ExamenController()
            : base(new ExamenRest())
        {
            haySeleccion = false;
            filtro = "";
        }

        public ExamenController(Examen examen)
            : base(new ExamenRest())
        {
            haySeleccion = false;
            if (examen != null)
            {
                setValorInicial(examen.idExamen - 1);
            }
            else
            {
                setValorInicial(0);
            }
            this.examenSeleccionado = examen;
        }

        public Boolean HaySeleccion()
        {
            return haySeleccion;
        }

        public Examen GetExamenSeleccionado()
        {
            return examenSeleccionado;
        }

        public void RegistrarSeleccion(int id)
        {
            foreach (var examen in listaValoresActuales)
            {
                if (examen.idExamen == id)
                {
                    examenSeleccionado = examen;
                    haySeleccion = true;
                }
            }
        }

        protected override List<Examen> FiltrarListaDatos()
        {
            return listaValoresActuales
                .Where(e => e.nombre.ToLower().Contains(filtro))
                .ToList();
        }

        public void addFiltroNombreExamen(String filtro)
        {
            this.filtro = filtro;
        }
    }

    public class IngresoDetalleController : AbstractPaginadoRest<IngresoDetalle>
    {
        private IngresoDetalle ingresoSeleccionado;
        private Boolean haySeleccion;
        private String paciente;

        public IngresoDetalleController()
            : base(new IngresoDetalleRest())
        {
            haySeleccion = false;
            paciente = "";
        }

        public IngresoDetalleController(IngresoDetalle ingresoDetalle)
            : base(new IngresoDetalleRest())
        {
            this.ingresoSeleccionado = ingresoDetalle;
            haySeleccion = false;
        }

        public Boolean HaySeleccion()
        {
            return haySeleccion;
        }

        public IngresoDetalle GetIngresoDetalleSeleccionado()
        {
            return ingresoSeleccionado;
        }

        public void RegistrarSeleccion(IngresoDetallePK pk)
        {
            foreach (var ingreso in listaValoresActuales)
            {
                if (ingreso.ingresoDetallePK.Equals(pk))
                {
                    ingresoSeleccionado = ingreso;
                    haySeleccion = true;
                }
            }
        }

        protected override List<IngresoDetalle> FiltrarListaDatos()
        {
            return listaValoresActuales
                    .Where(id => id.ingreso.idPaciente.getNombreYApellido()
                        .ToLower().Contains(paciente))
                    .ToList();
        }

        public void addFiltroNombrePaciente(String filtro)
        {
            this.paciente = filtro;
        }
    }
}
