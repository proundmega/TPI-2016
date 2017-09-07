package sv.ues.edu.tpi.clinica.web.services;

import java.util.List;
import javax.ejb.Stateless;
import javax.inject.Inject;
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
import sv.edu.uesocc.ingenieria.tpi135_2016.clinica.datos.definiciones.Ingreso;
import sv.edu.uesocc.ingenieria.tpi135_2016.clinica.datos.definiciones.IngresoDetalle;

@Stateless
@Path("ingreso/")
public class IngresoFacadeREST extends AbstractFacade<Ingreso> {
    @PersistenceContext(unitName = "WebServicePU")
    private EntityManager em;

    @Inject
    private IngresoDetalleFacadeREST ingresoDetalleFacadeREST; 
    
    public IngresoFacadeREST() {
        super(Ingreso.class);
    }

    @POST
    @Consumes({"application/xml", "application/json"})
    public Ingreso create(Ingreso entity) {
        try {
            super.crear(entity);
            return entity;
        } catch (Exception e) {
            return null;
        }
    }

    @PUT
    @Path("{id}")
    @Consumes({"application/xml", "application/json"})
    public Ingreso edit(@PathParam("id") Long id, Ingreso entity) {
        super.editar(entity);
        return entity;
    }

    @DELETE
    @Path("{id}")
    public void remove(@PathParam("id") Long id) throws Exception {
        Ingreso ingreso = super.find(id);
        if(ingreso != null) {
            eliminarIngresosDetalles(ingreso);
            super.eliminar(ingreso);
        }
        else{
            throw new IllegalArgumentException("El id ingresada no existe");
        }
        
    }
    
    private void eliminarIngresosDetalles(Ingreso ingreso) throws Exception {
        if(ingreso.getIngresoDetalleList() != null) {
            List<IngresoDetalle> ingresosDetalles = ingreso.getIngresoDetalleList();
            
            for(IngresoDetalle ingresoDetalle : ingresosDetalles) {
                ingresoDetalleFacadeREST.eliminarEnCascada(ingresoDetalle);
            }
        }
        
        
    }
    
    @GET
    @Path("{id}")
    @Produces({"application/xml", "application/json"})
    public Ingreso find(@PathParam("id") Long id) {
        return super.find(id);
    }

    @GET
    @Override
    @Produces({"application/xml", "application/json"})
    public List<Ingreso> findAll() {
        return super.findAll();
    }

    @GET
    @Path("{inicial}/{paginado}")
    @Produces({"application/xml", "application/json"})
    public List<Ingreso> findRange(@PathParam("inicial") Integer valorInicial, @PathParam("paginado") Integer tamanioPagina) {
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

    @Override
    public String getCampoOrderBy() {
        return "idIngreso";
    }
    
    
}
