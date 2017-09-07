/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package sv.ues.edu.tpi.clinica.web.services;

import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.PathSegment;
import sv.edu.uesocc.ingenieria.tpi135_2016.clinica.datos.definiciones.AsignacionPersonalCentroAreaEspacio;
import sv.edu.uesocc.ingenieria.tpi135_2016.clinica.datos.definiciones.AsignacionPersonalCentroAreaEspacioPK;

/**
 *
 * @author sakshi
 */
@Stateless
@Path("asignacionpersonalcentroareaespacio/")
public class AsignacionPersonalCentroAreaEspacioFacadeREST extends AbstractFacade<AsignacionPersonalCentroAreaEspacio> {
    @PersistenceContext(unitName = "WebServicePU")
    private EntityManager em;

    private AsignacionPersonalCentroAreaEspacioPK getPrimaryKey(PathSegment pathSegment) {
        /*
         * pathSemgent represents a URI path segment and any associated matrix parameters.
         * URI path part is supposed to be in form of 'somePath;idAsignacionPersonalCentroArea=idAsignacionPersonalCentroAreaValue;idAreaCentroEspacio=idAreaCentroEspacioValue;idTurno=idTurnoValue'.
         * Here 'somePath' is a result of getPath() method invocation and
         * it is ignored in the following code.
         * Matrix parameters are used as field names to build a primary key instance.
         */
        sv.edu.uesocc.ingenieria.tpi135_2016.clinica.datos.definiciones.AsignacionPersonalCentroAreaEspacioPK key = new sv.edu.uesocc.ingenieria.tpi135_2016.clinica.datos.definiciones.AsignacionPersonalCentroAreaEspacioPK();
        javax.ws.rs.core.MultivaluedMap<String, String> map = pathSegment.getMatrixParameters();
        java.util.List<String> idAsignacionPersonalCentroArea = map.get("idAsignacionPersonalCentroArea");
        if (idAsignacionPersonalCentroArea != null && !idAsignacionPersonalCentroArea.isEmpty()) {
            key.setIdAsignacionPersonalCentroArea(new java.lang.Long(idAsignacionPersonalCentroArea.get(0)));
        }
        java.util.List<String> idAreaCentroEspacio = map.get("idAreaCentroEspacio");
        if (idAreaCentroEspacio != null && !idAreaCentroEspacio.isEmpty()) {
            key.setIdAreaCentroEspacio(new java.lang.Long(idAreaCentroEspacio.get(0)));
        }
        java.util.List<String> idTurno = map.get("idTurno");
        if (idTurno != null && !idTurno.isEmpty()) {
            key.setIdTurno(new java.lang.Long(idTurno.get(0)));
        }
        return key;
    }

    public AsignacionPersonalCentroAreaEspacioFacadeREST() {
        super(AsignacionPersonalCentroAreaEspacio.class);
    }

    @POST
    @Consumes({"application/xml", "application/json"})
    public void create(AsignacionPersonalCentroAreaEspacio entity) {
        super.crear(entity);
    }

    @PUT
    @Path("{id}")
    @Consumes({"application/xml", "application/json"})
    public void edit(@PathParam("id") PathSegment id, AsignacionPersonalCentroAreaEspacio entity) {
        super.editar(entity);
    }

    @DELETE
    @Path("{id}")
    public void remove(@PathParam("id") PathSegment id) {
        sv.edu.uesocc.ingenieria.tpi135_2016.clinica.datos.definiciones.AsignacionPersonalCentroAreaEspacioPK key = getPrimaryKey(id);
        super.eliminar(super.find(key));
    }

    @GET
    @Path("{id}")
    @Produces({"application/xml", "application/json"})
    public AsignacionPersonalCentroAreaEspacio find(@PathParam("id") PathSegment id) {
        sv.edu.uesocc.ingenieria.tpi135_2016.clinica.datos.definiciones.AsignacionPersonalCentroAreaEspacioPK key = getPrimaryKey(id);
        return super.find(key);
    }

    @GET
    @Override
    @Produces({"application/xml", "application/json"})
    public List<AsignacionPersonalCentroAreaEspacio> findAll() {
        return super.findAll();
    }

    @GET
    @Path("{from}/{to}")
    @Produces({"application/xml", "application/json"})
    public List<AsignacionPersonalCentroAreaEspacio> findRange(@PathParam("from") Integer valorInicial, @PathParam("to") Integer tamanioPagina) {
        return super.findRango(valorInicial, tamanioPagina);
    }

    @GET
    @Path("count")
    @Produces({"application/xml", "application/json"})
    public String countREST() {
        return String.valueOf(super.count());
    }

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

}
