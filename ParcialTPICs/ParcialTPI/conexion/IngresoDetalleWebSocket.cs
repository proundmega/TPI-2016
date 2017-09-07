using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using WebSocketSharp;
using ParcialTPI.vistas.Mapeo;
using Newtonsoft.Json;
using TareaTPI.Excepciones;
using System.Timers;

namespace ParcialTPI.vistas.Conexion
{
    public class IngresoDetalleWebSocket  
    {
        public const String url = "ws://localhost:8080/clinica/ingresoDetalleExamen";

        private WebSocket webSocket;
        private INotificador notificador;
        private Timer timer;

        public IngresoDetalleWebSocket(INotificador notificador)
        {
            this.notificador = notificador;
            crearTimer();
            prepararWebSocket();
        }

        private void crearTimer()
        {
            timer = new Timer();
            timer.Interval = 10 * 1000;
            timer.Elapsed += timer_Elapsed;
        }

        private void prepararWebSocket()
        {
            webSocket = new WebSocket(url);
            webSocket.OnMessage += (sender, e) =>
                manejarOnMessaje(sender, e);

            webSocket.OnError += (sender, e) =>
                webSocket_OnError(sender, e);

            webSocket.OnClose += webSocket_OnClose ;

            webSocket.Connect();
        }

        private void webSocket_OnError(object sender, ErrorEventArgs e)
        {
            notificador.NotificarErrorEnConexion();
            timer.Start();
        }

        private void timer_Elapsed(object sender, ElapsedEventArgs e)
        {
            prepararWebSocket();
        }

        private void manejarOnMessaje(object sender, MessageEventArgs e)
        {
            timer.Stop();
            if (seSerializaALista(e.Data))
            {
                List<IngresoDetalleExamen> lista = desserializarListaIngresoDetalleExamen(e.Data);
                notificador.NotificarConexionAbierta(lista);
            }
            else if(seSerializaANotificacion(e.Data)) {
                DAOIngresoDetalleExamen dao = deserializarDAOIngresoDetalle(e.Data);
                notificador.NotificarCambioEnLosDatos(dao);
            }
            else
            {
                throw new ApplicationException("Se me ha enviado un tipo de respuesta no esperada");
            }
        }

        private void webSocket_OnClose(object sender, CloseEventArgs e)
        {
            timer.Start();
        }

        private Boolean seSerializaALista(String data)
        {
            try
            {
                List<IngresoDetalleExamen> lista = desserializarListaIngresoDetalleExamen(data);
                return true;
            }

            catch(Exception ex) {
                return false;
            }
        }

        private List<IngresoDetalleExamen> desserializarListaIngresoDetalleExamen(String data)
        {
            return JsonConvert.DeserializeObject<List<IngresoDetalleExamen>>(data);
        }

        public void enviarMensaje(DAOIngresoDetalleExamen ide)
        {
            String mensajeResultante = JsonConvert.SerializeObject(ide);
            if (webSocket.IsAlive)
            {
                webSocket.Send(mensajeResultante);
            }
            else
            {
                notificador.NotificarErrorEnConexion();
            }
        }

        private Boolean seSerializaANotificacion(String data)
        {
            try
            {
                deserializarDAOIngresoDetalle(data);
                return true;
            }
            catch(Exception ex) {
                return false;
            }
        }

        private DAOIngresoDetalleExamen deserializarDAOIngresoDetalle(String data)
        {
            return JsonConvert.DeserializeObject<DAOIngresoDetalleExamen>(data);
        }
    }

    public interface INotificador {
        void NotificarConexionAbierta(List<IngresoDetalleExamen> datos);
        void NotificarCambioEnLosDatos(DAOIngresoDetalleExamen dao);
        void NotificarErrorEnConexion();
    }

}
