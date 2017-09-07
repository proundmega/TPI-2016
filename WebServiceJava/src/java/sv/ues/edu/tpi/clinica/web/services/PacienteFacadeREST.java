/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package sv.ues.edu.tpi.clinica.web.services;

import java.util.List;
import javax.annotation.Resource;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.UserTransaction;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import sv.edu.uesocc.ingenieria.tpi135_2016.clinica.datos.definiciones.Paciente;

/**
 *
 * @author sakshi
 */
@Stateless
@Path("paciente/")
public class PacienteFacadeREST extends AbstractFacade<Paciente> {
    @PersistenceContext(unitName = "WebServicePU")
    private EntityManager em;

    public PacienteFacadeREST() {
        super(Paciente.class);
    }

    @POST
    @Consumes({"application/xml", "application/json"})
    public void create(Paciente entity) {
        super.crear(entity);
    }

    @PUT
    @Path("{id}")
    @Consumes({"application/xml", "application/json"})
    public void edit(@PathParam("id") Long id, Paciente entity) {
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
    public Paciente find(@PathParam("id") Long id) {
        return super.find(id);
    }

    @GET
    @Override
    @Produces({"application/xml", "application/json"})
    public List<Paciente> findAll() {
        return super.findAll();
    }

    @GET
    @Path("{inicial}/{paginado}")
    @Produces({"application/xml", "application/json"})
    public List<Paciente> findRange(@PathParam("inicial") Integer first, @PathParam("paginado") Integer tamanioPagina) {
        return super.findRango(first, tamanioPagina);
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
