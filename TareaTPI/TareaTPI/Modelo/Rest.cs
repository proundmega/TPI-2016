using TareaTPI.Mapeo;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using RestSharp;
using System.Net;
using System.IO;

namespace TareaTPI.Excepciones
{

    public abstract class AbstractClienteRest<T> where T : new() {
        public const String baseURL = "http://localhost:8080/WebService/tpi/";

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

        public List<T> FindAllDatos() {
            var clienteRest = crearClienteRest();
            var request = crearRequest(Method.GET);
            IRestResponse<List<T>> responseTipo = clienteRest.Execute<List<T>>(request);
            return responseTipo.Data;
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



    public class IngresoClienteRest : AbstractClienteRest<Ingreso>
    {
        
        protected override string getDireccionRequest()
        {
            return "ingreso/";
        }

        public Ingreso Modificar(Ingreso ingreso)
        {
            var clienteRest = crearClienteRest();
            var request = crearRequest(Method.PUT, "{id}/");

            request.AddParameter("id", ingreso.idIngreso, ParameterType.UrlSegment);

            var json = request.JsonSerializer.Serialize(ingreso);
            request.AddParameter("application/json; charset=utf-8", json, ParameterType.RequestBody);

            IRestResponse<Ingreso> respuesta = clienteRest.Execute<Ingreso>(request);
            validarPeticionHTTP(respuesta);

            return respuesta.Data;
        }

        public Ingreso Insertar(Ingreso ingreso)
        {
            var clienteRest = crearClienteRest();
            var request = crearRequest(Method.POST);

            var json = request.JsonSerializer.Serialize(ingreso);
            request.AddParameter("application/json; charset=utf-8", json, ParameterType.RequestBody);

            IRestResponse<Ingreso> respuesta = clienteRest.Execute<Ingreso>(request);
            validarPeticionHTTP(respuesta);

            return respuesta.Data;
        }

        public Boolean Eliminar(int id)
        {
            var clienteRest = crearClienteRest();
            var request = crearRequest(Method.DELETE, "{id}/");
            request.AddParameter("id", id, ParameterType.UrlSegment);
            IRestResponse respuesta = clienteRest.Execute(request);

            if (esRespuestaValida(respuesta.StatusCode))
            {
                return true;
            }
            else
            {
                return false;
            }

        }
    }

    public class PacienteClienteRest : AbstractClienteRest<Paciente> {

        protected override string getDireccionRequest()
        {
            return "paciente/";
        }
    }

    public class TipoIngresoClienteRest : AbstractClienteRest<TipoIngreso>
    {

        protected override string getDireccionRequest()
        {
            return "tipoingreso/";
        }

    }

    public class IngresoDetalleClienteRest : AbstractClienteRest<IngresoDetalle>
    {

        protected override string getDireccionRequest()
        {
            return "ingresoDetalle/";
        }

        public List<IngresoDetalle> FindListaIngresosByIngresoId(int id)
        {
            var clienteRest = crearClienteRest();
            var request = crearRequest(Method.GET, "{id}/");
            request.AddParameter("id", id, ParameterType.UrlSegment);

            IRestResponse<List<IngresoDetalle>> respuesta = clienteRest.Execute<List<IngresoDetalle>>(request);
            validarPeticionHTTP(respuesta);
            return respuesta.Data;
        }

        public IngresoDetalle findByIdIngresoDetalle(IngresoDetallePK pk)
        {
            var clienteRest = crearClienteRest();
            var request = crearRequestConMetodoYPk(pk, Method.GET);

            IRestResponse<IngresoDetalle> respuesta = clienteRest.Execute<IngresoDetalle>(request);
            validarPeticionHTTP(respuesta);
            return respuesta.Data;
        }

        private RestRequest crearRequestConMetodoYPk(IngresoDetallePK pk, Method method)
        {
            var request = crearRequest(method, "{idIngreso}/{idAsignacionPersonal}/{idAreaCentro}/{idTurno}");

            request.AddParameter("idIngreso", pk.idIngreso, ParameterType.UrlSegment);
            request.AddParameter("idAsignacionPersonal", pk.idAsignacionPersonalCentroArea, ParameterType.UrlSegment);
            request.AddParameter("idAreaCentro", pk.idAreaCentroEspacio, ParameterType.UrlSegment);
            request.AddParameter("idTurno", pk.idTurno, ParameterType.UrlSegment);

            return request;
        }

        public IngresoDetalle Modificar(IngresoDetalle ingresoDetalle)
        {
            var clienteRest = crearClienteRest();
            var request = crearRequestConMetodoYPk(ingresoDetalle.ingresoDetallePK, Method.PUT);

            var json = request.JsonSerializer.Serialize(ingresoDetalle);
            request.AddParameter("application/json; charset=utf-8", json, ParameterType.RequestBody);

            IRestResponse<IngresoDetalle> respuesta = clienteRest.Execute<IngresoDetalle>(request);
            validarPeticionHTTP(respuesta);

            return respuesta.Data;
        }

        public IngresoDetalle Insertar(IngresoDetalle ingresoDetalle)
        {
            var clienteRest = crearClienteRest();
            var request = crearRequest(Method.POST, "{id}/");
            request.AddParameter("id", ingresoDetalle.ingreso.idIngreso, ParameterType.UrlSegment);

            var json = request.JsonSerializer.Serialize(ingresoDetalle);
            request.AddParameter("application/json; charset=utf-8", json, ParameterType.RequestBody);

            IRestResponse<IngresoDetalle> respuesta = clienteRest.Execute<IngresoDetalle>(request);
            validarPeticionHTTP(respuesta);
            return respuesta.Data;
        }

        public bool Eliminar(IngresoDetallePK pk)
        {
            var clienteRest = crearClienteRest();
            var request = crearRequestConMetodoYPk(pk, Method.DELETE);

            try
            {
                IRestResponse respuesta = clienteRest.Execute(request);
                validarPeticionHTTP(respuesta);
                return true;
            }
            catch (NetworkConnectionException ex)
            {
                return false;
            }
        }
    }

    public class AsignacionPersonalClienteRest : AbstractClienteRest<AsignacionPersonalCentroAreaEspacio>
    {

        protected override string getDireccionRequest()
        {
            return "asignacionpersonalcentroareaespacio/";
        }
    
    }
}
