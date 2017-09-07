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
import sv.edu.uesocc.ingenieria.tpi135_2016.clinica.datos.definiciones.IngresoDetalleDiagnostico;

/**
 *
 * @author sakshi
 */
@Stateless
@Path("sv.edu.uesocc.ingenieria.tpi135_2016.clinica.datos.definiciones.ingresodetallediagnostico")
public class IngresoDetalleDiagnosticoFacadeREST extends AbstractFacade<IngresoDetalleDiagnostico> {
    @PersistenceContext(unitName = "WebServicePU")
    private EntityManager em;

    public IngresoDetalleDiagnosticoFacadeREST() {
        super(IngresoDetalleDiagnostico.class);
    }

    @POST
    @Consumes({"application/xml", "application/json"})
    public void create(IngresoDetalleDiagnostico entity) {
        super.crear(entity);
    }

    @PUT
    @Path("{id}")
    @Consumes({"application/xml", "application/json"})
    public void edit(@PathParam("id") Long id, IngresoDetalleDiagnostico entity) {
        super.editar(entity);
    }

    @DELETE
    @Path("{id}")
    public void remove(@PathParam("id") Long id) {
        super.eliminar(super.find(id));
    }

    @GET
    @Path("{id}")
    @Produces({"application/xml", "application/json"})
    public IngresoDetalleDiagnostico find(@PathParam("id") Long id) {
        return super.find(id);
    }

    @GET
    @Override
    @Produces({"application/xml", "application/json"})
    public List<IngresoDetalleDiagnostico> findAll() {
        return super.findAll();
    }

    @GET
    @Path("{from}/{to}")
    @Produces({"application/xml", "application/json"})
    public List<IngresoDetalleDiagnostico> findRange(@PathParam("from") Integer from, @PathParam("to") Integer to) {
        return super.findRange(new int[]{from, to});
    }

    @GET
    @Path("count")
    @Produces("text/plain")
    public String countREST() {
        return String.valueOf(super.count());
    }

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

}
