using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using RestSharp;
using TareaTPI.Excepciones;
using System.Net;
using ParcialTPI.vistas.Mapeo;

namespace ParcialTPI.vistas.Conexion
{
    public abstract class AbstractClienteRest<T> where T : new()
    {
        public const String baseURL = "http://localhost:8080/clinica/rest/";

        protected RestClient crearClienteRest()
        {
            return new RestClient(baseURL);
        }

        protected RestRequest crearRequest(Method metodo)
        {
            return new RestRequest(getDireccionRequest(), metodo);
        }

        protected abstract String getDireccionRequest();

        protected RestRequest crearRequest(Method metodo, String urlExtra)
        {
            return new RestRequest(getDireccionRequest() + urlExtra, metodo);
        }

        public List<T> FindAllDatos()
        {
            var clienteRest = crearClienteRest();
            var request = crearRequest(Method.GET);
            IRestResponse<List<T>> respuesta = clienteRest.Execute<List<T>>(request);
            validarPeticionHTTP(respuesta);
            return respuesta.Data;
        }

        public int GetConteoDatos()
        {
            var clienteRest = crearClienteRest();
            var request = crearRequest(Method.GET, "count/");

            IRestResponse<int> respuesta = clienteRest.Execute<int>(request);

            return respuesta.Data;
        }

        public List<T> FindDatosByPaginado(int valorInicial, int cantidadPaginado)
        {
            var clienteRest = crearClienteRest();
            var request = crearRequest(Method.GET, "{inicial}/{paginado}");
            request.AddParameter("inicial", valorInicial, ParameterType.UrlSegment);
            request.AddParameter("paginado", cantidadPaginado, ParameterType.UrlSegment);

            IRestResponse<List<T>> respuesta = clienteRest.Execute<List<T>>(request);

            validarPeticionHTTP(respuesta);

            return respuesta.Data;
        }

        public T FindDatoById(int id)
        {
            var clienteRest = crearClienteRest();
            var request = crearRequest(Method.GET, "{id}/");
            request.AddParameter("id", id, ParameterType.UrlSegment);

            IRestResponse<T> respuesta = clienteRest.Execute<T>(request);
            validarPeticionHTTP(respuesta);
            return respuesta.Data;
        }

        protected void validarPeticionHTTP(IRestResponse respuesta)
        {
            if (!esRespuestaValida(respuesta.StatusCode))
            {
                String mensaje = string.Format("Codigo http: {0}\n"
                    + "Mensaje: {1}", respuesta.StatusCode.ToString(), respuesta.StatusDescription);

                throw new NetworkConnectionException("Hubo problemas al conectarse al servicio REST... \n"
                    + mensaje);
            }
        }

        protected Boolean esRespuestaValida(HttpStatusCode codigo)
        {
            return codigo.Equals(HttpStatusCode.OK) ||
                codigo.Equals(HttpStatusCode.Created) || codigo.Equals(HttpStatusCode.NoContent);
        }

    }

    public class ExamenRest : AbstractClienteRest<Examen>
    {

        protected override string getDireccionRequest()
        {
            return "examen/";
        }

    }

    public class IngresoDetalleRest : AbstractClienteRest<IngresoDetalle>
    {

        protected override string getDireccionRequest()
        {
            return "ingresoDetalle/";
        }

    }
}
