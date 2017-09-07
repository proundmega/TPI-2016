/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sv.ues.edu.tpi2016.clinica.gateway;

import java.util.List;
import javax.ejb.embeddable.EJBContainer;
import javax.naming.NamingException;
import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.BeforeClass;
import sv.ues.edu.tpi2016.clinica.entities.TipoCentro;

public class TipoCentroFacadeTest {
    private static EJBContainer container;
    private static TipoCentroFacadeLocal facade;
    
    @BeforeClass
    public static void init() throws NamingException {
        container = javax.ejb.embeddable.EJBContainer.createEJBContainer();
        facade = (TipoCentroFacadeLocal)container.getContext().lookup("java:global/classes/TipoCentroFacade");
    }
    
    @Test
    public void testCantidadAreas() {
        List<TipoCentro> lista = facade.findAll();
        assertEquals(6, lista.size());
    }
    
}
