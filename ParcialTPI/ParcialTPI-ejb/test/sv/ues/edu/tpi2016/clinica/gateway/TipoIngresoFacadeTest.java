/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sv.ues.edu.tpi2016.clinica.gateway;

import java.util.List;
import javax.ejb.embeddable.EJBContainer;
import org.junit.Test;
import static org.junit.Assert.*;
import sv.ues.edu.tpi2016.clinica.entities.TipoIngreso;

/**
 *
 * @author sakshi
 */
public class TipoIngresoFacadeTest {
    
    public TipoIngresoFacadeTest() {
    }

    /**
     * Test of create method, of class TipoIngresoFacade.
     */
    @Test
    public void testCreate() throws Exception {
        System.out.println("create");
        TipoIngreso entity = null;
        EJBContainer container = javax.ejb.embeddable.EJBContainer.createEJBContainer();
        TipoIngresoFacadeLocal instance = (TipoIngresoFacadeLocal)container.getContext().lookup("java:global/classes/TipoIngresoFacade");
        instance.create(entity);
        container.close();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of edit method, of class TipoIngresoFacade.
     */
    @Test
    public void testEdit() throws Exception {
        System.out.println("edit");
        TipoIngreso entity = null;
        EJBContainer container = javax.ejb.embeddable.EJBContainer.createEJBContainer();
        TipoIngresoFacadeLocal instance = (TipoIngresoFacadeLocal)container.getContext().lookup("java:global/classes/TipoIngresoFacade");
        instance.edit(entity);
        container.close();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of remove method, of class TipoIngresoFacade.
     */
    @Test
    public void testRemove() throws Exception {
        System.out.println("remove");
        TipoIngreso entity = null;
        EJBContainer container = javax.ejb.embeddable.EJBContainer.createEJBContainer();
        TipoIngresoFacadeLocal instance = (TipoIngresoFacadeLocal)container.getContext().lookup("java:global/classes/TipoIngresoFacade");
        instance.remove(entity);
        container.close();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of find method, of class TipoIngresoFacade.
     */
    @Test
    public void testFind() throws Exception {
        System.out.println("find");
        Object id = null;
        EJBContainer container = javax.ejb.embeddable.EJBContainer.createEJBContainer();
        TipoIngresoFacadeLocal instance = (TipoIngresoFacadeLocal)container.getContext().lookup("java:global/classes/TipoIngresoFacade");
        TipoIngreso expResult = null;
        TipoIngreso result = instance.find(id);
        assertEquals(expResult, result);
        container.close();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of findAll method, of class TipoIngresoFacade.
     */
    @Test
    public void testFindAll() throws Exception {
        System.out.println("findAll");
        EJBContainer container = javax.ejb.embeddable.EJBContainer.createEJBContainer();
        TipoIngresoFacadeLocal instance = (TipoIngresoFacadeLocal)container.getContext().lookup("java:global/classes/TipoIngresoFacade");
        List<TipoIngreso> expResult = null;
        List<TipoIngreso> result = instance.findAll();
        assertEquals(expResult, result);
        container.close();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of findRange method, of class TipoIngresoFacade.
     */
    @Test
    public void testFindRange() throws Exception {
        System.out.println("findRange");
        int[] range = null;
        EJBContainer container = javax.ejb.embeddable.EJBContainer.createEJBContainer();
        TipoIngresoFacadeLocal instance = (TipoIngresoFacadeLocal)container.getContext().lookup("java:global/classes/TipoIngresoFacade");
        List<TipoIngreso> expResult = null;
        List<TipoIngreso> result = instance.findRange(range);
        assertEquals(expResult, result);
        container.close();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of count method, of class TipoIngresoFacade.
     */
    @Test
    public void testCount() throws Exception {
        System.out.println("count");
        EJBContainer container = javax.ejb.embeddable.EJBContainer.createEJBContainer();
        TipoIngresoFacadeLocal instance = (TipoIngresoFacadeLocal)container.getContext().lookup("java:global/classes/TipoIngresoFacade");
        int expResult = 0;
        int result = instance.count();
        assertEquals(expResult, result);
        container.close();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
