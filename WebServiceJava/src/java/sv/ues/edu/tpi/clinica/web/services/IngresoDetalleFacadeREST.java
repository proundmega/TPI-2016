/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package sv.ues.edu.tpi.clinica.web.services;

import java.time.Instant;
import java.util.Date;
import java.util.List;
import javax.annotation.Resource;
import javax.ejb.Stateless;
import javax.ejb.TransactionManagement;
import javax.ejb.TransactionManagementType;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.transaction.HeuristicMixedException;
import javax.transaction.NotSupportedException;
import javax.transaction.RollbackException;
import javax.transaction.SystemException;
import javax.transaction.UserTransaction;
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
import sv.edu.uesocc.ingenieria.tpi135_2016.clinica.datos.definiciones.Ingreso;
import sv.edu.uesocc.ingenieria.tpi135_2016.clinica.datos.definiciones.IngresoDetalle;
import sv.edu.uesocc.ingenieria.tpi135_2016.clinica.datos.definiciones.IngresoDetalleDiagnostico;
import sv.edu.uesocc.ingenieria.tpi135_2016.clinica.datos.definiciones.IngresoDetalleExamen;
import sv.edu.uesocc.ingenieria.tpi135_2016.clinica.datos.definiciones.IngresoDetallePK;

@Stateless
@Path("ingresoDetalle/")
@TransactionManagement(value=TransactionManagementType.BEAN)
public class IngresoDetalleFacadeREST extends AbstractFacade<IngresoDetalle> {
    @PersistenceContext(unitName = "WebServicePU")
    private EntityManager em;
    
    @Inject
    private IngresoDetalleExamenFacadeREST ingresoDetalleExamenFacadeREST;
    
    @Inject
    private IngresoDetalleDiagnosticoFacadeREST ingresoDetalleDiagnosticoFacadeREST;
    
    @Resource
    private UserTransaction userTransaction;

    public IngresoDetalleFacadeREST() {
        super(IngresoDetalle.class);
    }

    @POST
    @Path("{id}")
    @Consumes({"application/xml", "application/json"})
    public IngresoDetalle create(@PathParam("id") Integer id, IngresoDetalle entity) throws Exception {
        userTransaction.begin();
        super.crear(entity);
        userTransaction.commit();
        return super.find(entity.getIngresoDetallePK());
    }

    @PUT
    @Path("{id}/{idAsignacionPersonalCentroArea}/{idAreaCentroEspacio}/{idTurno}/")
    @Produces({"application/xml", "application/json"})
    @Consumes({"application/xml", "application/json"})
    public IngresoDetalle edit(@PathParam("id") Long idIngreso, @PathParam("idAsignacionPersonalCentroArea")
            Long idAsignacionPersonalCentroArea, @PathParam("idAreaCentroEspacio") Long idAreaCentroEspacio, 
            @PathParam("idTurno") Long idTurno, IngresoDetalle entity) throws Exception{
        userTransaction.begin();
        super.editar(entity);
        userTransaction.commit();
        return super.find(entity.getIngresoDetallePK());
    }

    @DELETE
    @Path("{id}/{idAsignacionPersonalCentroArea}/{idAreaCentroEspacio}/{idTurno}/")
    @Produces({"application/xml", "application/json"})
    public void remove(@PathParam("id") Long idIngreso, @PathParam("idAsignacionPersonalCentroArea")
            Long idAsignacionPersonalCentroArea, @PathParam("idAreaCentroEspacio") Long idAreaCentroEspacio, 
            @PathParam("idTurno") Long idTurno) throws Exception{
        
        IngresoDetallePK pk = crearPk(idIngreso, idAsignacionPersonalCentroArea, idAreaCentroEspacio, idTurno);
        IngresoDetalle ingresoDetalle = super.find(pk);
        eliminarEnCascada(ingresoDetalle);
    }
    
    public void eliminarEnCascada(IngresoDetalle ingresoDetalle) throws Exception{
        userTransaction.begin();
        eliminarIngresosDetallesDiagnosticos(ingresoDetalle);
        eliminarIngresoDetallesExamen(ingresoDetalle);
        userTransaction.commit();
        userTransaction.begin();
        super.eliminar(ingresoDetalle);
        userTransaction.commit();
        
    }
    
    private void eliminarIngresosDetallesDiagnosticos(IngresoDetalle ingresoDetalle) {
        if(ingresoDetalle.getIngresoDetalleDiagnosticoList() != null) {
            for(IngresoDetalleDiagnostico idd : ingresoDetalle.getIngresoDetalleDiagnosticoList()) {
                ingresoDetalleDiagnosticoFacadeREST.eliminar(idd);
            }
        }
    }
    
    private void eliminarIngresoDetallesExamen(IngresoDetalle ingresoDetalle) {
        if(ingresoDetalle.getIngresoDetalleExamenList() != null) {
            for(IngresoDetalleExamen ide : ingresoDetalle.getIngresoDetalleExamenList()) {
                ingresoDetalleExamenFacadeREST.eliminar(ide);
            }
        }
    }

    @GET
    @Path("{id}")
    @Produces({"application/xml", "application/json"})
    public List<IngresoDetalle> find(@PathParam("id") Integer id) {
        TypedQuery<IngresoDetalle> query = getEntityManager().createNamedQuery("IngresoDetalle.findByIdIngreso", IngresoDetalle.class);
        query.setParameter("idIngreso", id);
        return query.getResultList();
    }
    
    @GET
    @Path("{id}/{idAsignacionPersonalCentroArea}/{idAreaCentroEspacio}/{idTurno}/")
    @Produces({"application/xml", "application/json"})
    public IngresoDetalle findAllByIngresoId(@PathParam("id") Long idIngreso, @PathParam("idAsignacionPersonalCentroArea")
            Long idAsignacionPersonalCentroArea, @PathParam("idAreaCentroEspacio") Long idAreaCentroEspacio, 
            @PathParam("idTurno") Long idTurno) {
        
        IngresoDetallePK pk = crearPk(idIngreso, idAsignacionPersonalCentroArea, idAreaCentroEspacio, idTurno);
        return super.find(pk);
    }
    
    private IngresoDetallePK crearPk(Long idIngreso, Long idAsignacionPersonalCentroArea,  Long idAreaCentroEspacio,  Long idTurno) {
        IngresoDetallePK pk = new IngresoDetallePK(idIngreso, idAsignacionPersonalCentroArea, idAreaCentroEspacio, idTurno);
        return pk;
    }

    @GET
    @Override
    @Produces({"application/xml", "application/json"})
    public List<IngresoDetalle> findAll() {
        return super.findAll();
    }
    
    @Inject
    private AsignacionPersonalCentroAreaEspacioFacadeREST areaEspacioFacadeREST;
    
    @Inject
    private IngresoFacadeREST ingresoFacadeREST;

    private void injectarValor() {
        List<AsignacionPersonalCentroAreaEspacio> findAll = areaEspacioFacadeREST.findAll();
        Ingreso ingreso = ingresoFacadeREST.find(2L);
        
        AsignacionPersonalCentroAreaEspacio seleccion = findAll.get(8);
        
        IngresoDetalle ingresoDetalle = new IngresoDetalle();
        
        AsignacionPersonalCentroAreaEspacioPK areaEspacioPK = seleccion.getAsignacionPersonalCentroAreaEspacioPK();
        
        IngresoDetallePK pk = new IngresoDetallePK();
        pk.setIdAreaCentroEspacio(areaEspacioPK.getIdAreaCentroEspacio());
        pk.setIdAsignacionPersonalCentroArea(areaEspacioPK.getIdAsignacionPersonalCentroArea());
        pk.setIdIngreso(ingreso.getIdIngreso());
        pk.setIdTurno(areaEspacioPK.getIdTurno());
        ingresoDetalle.setIngresoDetallePK(pk);
        
        ingresoDetalle.setObservaciones("Hola mundo X2!!!");
        ingresoDetalle.setFechaDetalle(Date.from(Instant.now()));
        
        this.crear(ingresoDetalle);
        
        ingresoFacadeREST.editar(ingreso);
    }
    
    @GET
    @Path("{from}/{to}")
    @Produces({"application/xml", "application/json"})
    public List<IngresoDetalle> findRange(@PathParam("from") Integer from, @PathParam("to") Integer to) {
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
