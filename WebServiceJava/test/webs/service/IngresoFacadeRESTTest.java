/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package webs.service;

import sv.ues.edu.tpi.clinica.web.services.IngresoFacadeREST;
import java.util.Date;
import java.util.List;
import javax.ejb.embeddable.EJBContainer;
import javax.naming.NamingException;
import org.junit.AfterClass;
import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.BeforeClass;
import sv.edu.uesocc.ingenieria.tpi135_2016.clinica.datos.definiciones.Ingreso;

/**
 *
 * @author sakshi
 */
public class IngresoFacadeRESTTest {
    private static EJBContainer container;
    private IngresoFacadeREST ingresoFacade;
    
    @BeforeClass
    public static void intiContenedor() {
        container = javax.ejb.embeddable.EJBContainer.createEJBContainer();
    }
    
    @Before
    public void crearRest() throws NamingException {
        ingresoFacade = (IngresoFacadeREST)container.getContext().lookup("java:global/classes/IngresoFacadeREST");
    }
    
    @AfterClass
    public static void limpiarContenedor() {
        container.close();
    }
    
    @Test
    public void testEditar() throws Exception {
        
        Long idTest = 10L;
        Date fechaIngresoNueva = new Date(); 
        
        Ingreso ingresoSeleccionado = ingresoFacade.find(idTest);
        Date fechaIngresoVieja = ingresoSeleccionado.getFechaIngreso();
        assertFalse(fechaIngresoNueva.equals(fechaIngresoVieja));
        
        ingresoSeleccionado.setFechaIngreso(fechaIngresoNueva);
        ingresoFacade.editar(ingresoSeleccionado);
        
        assertEquals(fechaIngresoNueva, ingresoSeleccionado.getFechaIngreso());
    }

    @Test
    public void borrarElementoQueTieneVariasDependencias() {
        Long idIngreso = 100L;
        Ingreso ingresoTest = ingresoFacade.find(idIngreso);
        ingresoFacade.eliminar(ingresoTest);
        assertTrue(ingresoFacade.find(idIngreso) == null);
        
        ingresoFacade.crear(ingresoTest);
    }
}
