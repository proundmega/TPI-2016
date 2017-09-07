using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using TareaTPI.Mapeo;
using TareaTPI.Excepciones;

namespace TareaTPI.Vistas
{

    public abstract class AbstractPaginadoController<T> where T: new()
    {
        private int cantidadActual;
        public const int TAMANIO_PAGINADO = 8;
        private int valorInicial;
        protected AbstractClienteRest<T> clienteRest;
        protected List<T> listaValoresActuales;

        public AbstractPaginadoController(AbstractClienteRest<T> clienteRest)
        {
            this.clienteRest = clienteRest;
            valorInicial = 0;
            actualizarConteo();
        }

        protected void actualizarConteo()
        {
            cantidadActual = clienteRest.GetConteoDatos();
        }

        protected void setValorInicial(int valorInicial)
        {
            this.valorInicial = valorInicial;
        }

        protected int getValorInicial()
        {
            return valorInicial;
        }

        public void notificarPaginadoHaciaAdelante()
        {
            if (hayPaginadoHaciaAdelante())
            {
                valorInicial += TAMANIO_PAGINADO;
            }
        }

        public void notificarPaginadoHaciaAtras()
        {
            if (hayPaginadoHaciaAtras())
            {
                valorInicial -= TAMANIO_PAGINADO;
            }
            if(paginadoHaciaAtrasNoDaCero() && !hayPaginadoHaciaAtras()) {
                valorInicial = 0;
            }

        }

        public Boolean hayPaginadoHaciaAdelante()
        {
            return valorInicial + TAMANIO_PAGINADO < cantidadActual;
        }

        public Boolean hayPaginadoHaciaAtras()
        {
            return valorInicial - TAMANIO_PAGINADO >= 0;
        }

        private Boolean paginadoHaciaAtrasNoDaCero()
        {
            return valorInicial > 0;
        }

        public List<T> GetListaDatos()
        {
            listaValoresActuales = clienteRest.FindDatosByPaginado(getValorInicial(), TAMANIO_PAGINADO);
            if (listaValoresActuales.Count != 0)
            {
                return listaValoresActuales;
            }
            else
            {
                notificarPaginadoHaciaAtras();
                listaValoresActuales = clienteRest.FindDatosByPaginado(getValorInicial(), TAMANIO_PAGINADO);
                return listaValoresActuales;
            }
        }

        public int getCantidadTotal()
        {
            return cantidadActual;
        }

    }


    class IngresoController : AbstractPaginadoController<Ingreso>
    {

        private Paciente pacienteSeleccionado;
        private IngresoClienteRest ingresoClienteRest;
        private TipoAccion tipoAccionIngreso;

        public IngresoController() : base(new IngresoClienteRest()) {
            ingresoClienteRest = (IngresoClienteRest) clienteRest;
            tipoAccionIngreso = TipoAccion.NULA;
        }

        public Ingreso getIngresoById(String idIngreso)
        {
            int id = int.Parse(idIngreso);
            foreach(var ingreso in listaValoresActuales) {
                if(ingreso.idIngreso == id) {
                    return ingreso;
                }
            }
            throw new ApplicationException("Se ha buscado un ingreso por un id que no existe");

        }

        public void registrarPacienteSeleccionado(Paciente pacienteSeleccionado) {
            this.pacienteSeleccionado = pacienteSeleccionado;
        }

        public Paciente GetPacienteSeleccionado()
        {
            return pacienteSeleccionado;
        }

        public void notificarModificacion()
        {
            tipoAccionIngreso = TipoAccion.MODIFICAR;
        }

        public void notificarInsercion()
        {
            tipoAccionIngreso = TipoAccion.INSERTAR;
        }

        public void notificarAccionCancelada()
        {
            tipoAccionIngreso = TipoAccion.NULA;
        }

        public List<TipoIngreso> getTiposIngreso()
        {
            TipoIngresoClienteRest clienteRest = new TipoIngresoClienteRest();
            return clienteRest.FindAllDatos();
        }

        public TipoIngreso getTipoIngresoByNombre(String nombreTipoIngreso)
        {
            TipoIngresoClienteRest clienteRest = new TipoIngresoClienteRest();
            var lista = clienteRest.FindAllDatos();
            foreach (var tipo in lista)
            {
                if (tipo.nombre.Equals(nombreTipoIngreso)) return tipo;
            }
            throw new InvalidOperationException("No se pudo encontrar el tipo centro especificado");
        }

        public Boolean seEstaModificando()
        {
            return tipoAccionIngreso == TipoAccion.MODIFICAR;
        }

        public Boolean eliminar(int idIngreso)
        {
            return ingresoClienteRest.Eliminar(idIngreso);
        }

        public Ingreso EjecutarAccion(Ingreso ingreso)
        {
            switch(tipoAccionIngreso) {
                case TipoAccion.INSERTAR:
                    Ingreso ingresoNuevo = ingresoClienteRest.Insertar(ingreso);
                    actualizarConteo();
                    return ingresoNuevo;
                    break;

                case TipoAccion.MODIFICAR:
                    return ingresoClienteRest.Modificar(ingreso);
                    break;

                default:
                    break;
            }
            return ingresoClienteRest.Modificar(ingreso);
        }
 
    }

    enum TipoAccion
    {
        MODIFICAR,
        INSERTAR,
        ELIMINAR,
        NULA

    }


    class PacienteController : AbstractPaginadoController<Paciente>
    {

        private Paciente pacienteSeleccionado;
        private Boolean haySeleccion;

        public PacienteController() : base(new PacienteClienteRest()) {
            haySeleccion = false;
        }

        public void setPacienteSeleccionado(Paciente paciente) {
            if (paciente != null)
            {
                setValorInicial(paciente.idPaciente - 1);
            }
            else
            {
                setValorInicial(0);
            }
            this.pacienteSeleccionado = paciente;
        }

        public Paciente getPacienteSeleccionado()
        {
            return pacienteSeleccionado;
        }

        public void registrarSeleccion(int idPaciente)
        {
            foreach(var valor in listaValoresActuales) {
                if(valor.idPaciente == idPaciente) {
                    haySeleccion = true;
                    this.pacienteSeleccionado = valor;
                }
            }
            
        }

        public Boolean seSeleccionoPaciente()
        {
            return haySeleccion;
        }

    }


    class IngresoDetalleController
    {
        private Ingreso ingresoSeleccionado;
        private IngresoDetalleClienteRest clienteRest;
        private List<IngresoDetalle> ingresosDetalleList;
        private AsignacionPersonalCentroAreaEspacio asignacionPersonal;
        private TipoAccion tipoAcccion;

        public IngresoDetalleController(Ingreso ingresoSeleccionado)
        {
            this.ingresoSeleccionado = ingresoSeleccionado;
            clienteRest = new IngresoDetalleClienteRest();
            tipoAcccion = TipoAccion.NULA;
        }

        public List<IngresoDetalle> GetIngresosDetalle()
        {
            ingresosDetalleList = clienteRest.FindListaIngresosByIngresoId(ingresoSeleccionado.idIngreso.Value);
            return ingresosDetalleList;
        }

        public IngresoDetalle GetIngresoDetalleById(IngresoDetallePK idIngresoDetalle)
        {
            foreach(var ingresoDetalle in ingresosDetalleList){
                if(ingresoDetalle.ingresoDetallePK.Equals(idIngresoDetalle)) {
                    return ingresoDetalle;
                }
            }
            throw new ArgumentException("Esta id de ingreso detalle no existe");
        }

        public void registrarAsignacionSeleccionada(AsignacionPersonalCentroAreaEspacio asignacionPersonal)
        {
            this.asignacionPersonal = asignacionPersonal;
        }

        public AsignacionPersonalCentroAreaEspacioPK GetPkAsignacionSeleccionada()
        {
            if (asignacionPersonal.asignacionPersonalCentroAreaEspacioPK != null)
            {
                return asignacionPersonal.asignacionPersonalCentroAreaEspacioPK;
            }
            else
            {
                throw new ApplicationException("Se busca la asignacion de personal que no existe");
            }
        }

        public int getIdIngreso()
        {
            return ingresoSeleccionado.idIngreso.Value;
        }

        public IngresoDetalle modificar(IngresoDetalle ingresoDetalle)
        {
            return clienteRest.Modificar(ingresoDetalle);
        }

        public AsignacionPersonalCentroAreaEspacio getAsignacionSeleccionada()
        {
            return asignacionPersonal;
        }

        public Ingreso getIngresoSeleccionado()
        {
            return ingresoSeleccionado;
        }

        public void notificarModificacion()
        {
            tipoAcccion = TipoAccion.MODIFICAR;
        }

        public void notificarInsercion()
        {
            tipoAcccion = TipoAccion.INSERTAR;
        }

        public Boolean seEstaModificando()
        {
            return tipoAcccion == TipoAccion.MODIFICAR;
        }

        public Boolean seEstaInsertando()
        {
            return tipoAcccion == TipoAccion.INSERTAR;
        }

        public IngresoDetalle Insertar(IngresoDetalle ingresoDetalle)
        {
            return clienteRest.Insertar(ingresoDetalle);
        }

        public Boolean Eliminar(IngresoDetallePK pk)
        {
            return clienteRest.Eliminar(pk);
        }

        public void notificarAccionCancelada()
        {
            tipoAcccion = TipoAccion.NULA;
        }
    }


}
