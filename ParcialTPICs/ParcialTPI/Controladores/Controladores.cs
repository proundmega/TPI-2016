using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using ParcialTPI.vistas.Conexion;
using ParcialTPI.vistas.Mapeo;

namespace ParcialTPI.vistas.Controladores
{
    public abstract class AbstractPaginado<T> where T : new()
    {
        private int cantidadActual;
        public const int TAMANIO_PAGINADO = 8;
        private int valorInicial;
        protected List<T> listaValoresActuales;

        public AbstractPaginado()
        {
            valorInicial = 0;
            listaValoresActuales = new List<T>();
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
            if (paginadoHaciaAtrasNoDaCero() && !hayPaginadoHaciaAtras())
            {
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

        public int getCantidadTotal()
        {
            return cantidadActual;
        }

        protected void setCantidadTotal(int cantidadTotal)
        {
            this.cantidadActual = cantidadTotal;
        }

        protected abstract void actualizarConteo();

        public abstract List<T> GetListaDatos();
    }

    class IngresoDetalleExamenController : AbstractPaginado<IngresoDetalleExamen>, INotificador
    {
        private IngresoDetalleWebSocket webSocket;
        private INotificadorUI notificadorUI;
        private List<IngresoDetalleExamen> datos;
        private Examen examenSeleccionado;
        private IngresoDetalle ingresoDetalleSeleccionado;
        private TipoMensaje tipoMensajeSeleccionado;
        private Boolean esperandoRespuesta;
        private Boolean filtrando;
        private String apellido;
        private String nombreExamen;

        public IngresoDetalleExamenController(INotificadorUI notificadorUI) : base()
        {
            this.notificadorUI = notificadorUI;
            webSocket = new IngresoDetalleWebSocket(this);
            esperandoRespuesta = false;
            apellido = "";
            nombreExamen = "";
            filtrando = false;
        }

        protected override void actualizarConteo()
        {
            setCantidadTotal(datos.Count);
        }

        public override List<IngresoDetalleExamen> GetListaDatos()
        {
                listaValoresActuales = new List<IngresoDetalleExamen>();

                var datosFiltrados = GetListaConFiltros();
                setCantidadTotal(datosFiltrados.Count);

                if(filtrando) {
                    filtrando = false;
                    setValorInicial(0);
                }

                for (int i = getValorInicial(); HayValorSiguiente(i); i++)
                {
                    listaValoresActuales.Add(datosFiltrados.ElementAt(i));
                }

                return listaValoresActuales;
        }

        private List<IngresoDetalleExamen> GetListaConFiltros()
        {
                return datos
                    .Where(ide => ide.ingresoDetalle.ingreso.idPaciente.getNombreYApellido()
                        .ToLower().Contains(apellido))
                    .Where(ide => ide.idExamen.nombre.ToLower().Contains(nombreExamen))
                    .ToList();
        }

        private Boolean HayValorSiguiente(int i)
        {
            return i < getValorInicial() + TAMANIO_PAGINADO && i < getCantidadTotal();
        }

        public void NotificarConexionAbierta(List<IngresoDetalleExamen> datos)
        {
            this.datos = datos;
            actualizarConteo();
            notificadorUI.NotificarConexionAbierta();
        }

        public void NotificarErrorEnConexion()
        {
            notificadorUI.NotificarErrorEnConexion();
        }

        public void NotificarCambioEnLosDatos(DAOIngresoDetalleExamen dao)
        {
            TipoMensaje tipoMensaje = TipoMensaje.GetTipoMensajeFromString(dao.opcion);
            String mensaje = tipoMensaje.actualizarDatos(datos, dao, esperandoRespuesta);
            actualizarConteo();
            notificadorUI.NotificarCambiosEnDatos(mensaje);
            esperandoRespuesta = false;
        }

        public IngresoDetalleExamen GetDatoById(int valorSeleccionado)
        {
            foreach(var ide in datos) {
                if(ide.idIngresoDetalleExamen == valorSeleccionado) {
                    return ide;
                }
            }
            throw new ApplicationException("Se ha pedido el id " + valorSeleccionado + " que no esta guardado...");
        }

        public void RegistrarSeleccionExamen(Examen examen)
        {
            this.examenSeleccionado = examen;
        }

        public void RegistrarSeleccionIngresoDetalle(IngresoDetalle ingresoDetalle)
        {
            this.ingresoDetalleSeleccionado = ingresoDetalle;
        }

        public Examen GetExamenSeleccionado()
        {
            return examenSeleccionado;
        }

        public IngresoDetalle GetIngresoDetalleSeleccionado()
        {
            return ingresoDetalleSeleccionado;
        }

        public void EnviarMensaje(IngresoDetalleExamen ide)
        {
            if (tipoMensajeSeleccionado != null)
            {
                DAOIngresoDetalleExamen dao = new DAOIngresoDetalleExamen();
                dao.ingresoDetalleExamen = ide;
                dao.opcion = tipoMensajeSeleccionado.getAccion();
                webSocket.enviarMensaje(dao);
                esperandoRespuesta = true;
            }
            else
            {
                throw new ApplicationException("Intentas que envie un mensaje cuando no he resgitrado accion alguna");
            }
        }

        public void RegistrarModificacion()
        {
            tipoMensajeSeleccionado = TipoMensaje.crearModificar();
        }

        public void RegistrarInsercion()
        {
            tipoMensajeSeleccionado = TipoMensaje.crearInsertar();
        }

        public void CancelarAccionGuardada()
        {
            tipoMensajeSeleccionado = null;
        }

        public void RegistrarEliminacion()
        {
            tipoMensajeSeleccionado = TipoMensaje.crearEliminacion();
        }

        public void addFiltroApellido(String apellido)
        {
            this.apellido = apellido;
            this.filtrando = true;
        }

        public void addFiltroNombreExamen(String nombreExamen)
        {
            this.nombreExamen = nombreExamen;
        }
    }

    public interface INotificadorUI
    {
        void NotificarConexionAbierta();
        void NotificarCambiosEnDatos(String mensaje);
        void NotificarErrorEnConexion();
    }

}
