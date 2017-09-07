/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sv.ues.edu.tpi2016.clinica.entities;

import java.util.List;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author sakshi
 */
public class TipoCentroTest {
    
    public TipoCentroTest() {
    }

    /**
     * Test of getIdTipoCentro method, of class TipoCentro.
     */
    @Test
    public void testGetIdTipoCentro() {
        TipoCentro instance = new TipoCentro();
        Integer expResult = null;
        Integer result = instance.getIdTipoCentro();
        assertEquals(expResult, result);
    }

    /**
     * Test of setIdTipoCentro method, of class TipoCentro.
     */
    @Test
    public void testSetIdTipoCentro() {
        System.out.println("setIdTipoCentro");
        Integer idTipoCentro = null;
        TipoCentro instance = new TipoCentro();
        instance.setIdTipoCentro(idTipoCentro);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getNombre method, of class TipoCentro.
     */
    @Test
    public void testGetNombre() {
        System.out.println("getNombre");
        TipoCentro instance = new TipoCentro();
        String expResult = "";
        String result = instance.getNombre();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setNombre method, of class TipoCentro.
     */
    @Test
    public void testSetNombre() {
        System.out.println("setNombre");
        String nombre = "";
        TipoCentro instance = new TipoCentro();
        instance.setNombre(nombre);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getActivo method, of class TipoCentro.
     */
    @Test
    public void testGetActivo() {
        System.out.println("getActivo");
        TipoCentro instance = new TipoCentro();
        Boolean expResult = null;
        Boolean result = instance.getActivo();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setActivo method, of class TipoCentro.
     */
    @Test
    public void testSetActivo() {
        System.out.println("setActivo");
        Boolean activo = null;
        TipoCentro instance = new TipoCentro();
        instance.setActivo(activo);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getObservaciones method, of class TipoCentro.
     */
    @Test
    public void testGetObservaciones() {
        System.out.println("getObservaciones");
        TipoCentro instance = new TipoCentro();
        String expResult = "";
        String result = instance.getObservaciones();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setObservaciones method, of class TipoCentro.
     */
    @Test
    public void testSetObservaciones() {
        System.out.println("setObservaciones");
        String observaciones = "";
        TipoCentro instance = new TipoCentro();
        instance.setObservaciones(observaciones);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getCentroList method, of class TipoCentro.
     */
    @Test
    public void testGetCentroList() {
        System.out.println("getCentroList");
        TipoCentro instance = new TipoCentro();
        List<Centro> expResult = null;
        List<Centro> result = instance.getCentroList();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setCentroList method, of class TipoCentro.
     */
    @Test
    public void testSetCentroList() {
        System.out.println("setCentroList");
        List<Centro> centroList = null;
        TipoCentro instance = new TipoCentro();
        instance.setCentroList(centroList);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of hashCode method, of class TipoCentro.
     */
    @Test
    public void testHashCode() {
        System.out.println("hashCode");
        TipoCentro instance = new TipoCentro();
        int expResult = 0;
        int result = instance.hashCode();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of equals method, of class TipoCentro.
     */
    @Test
    public void testEquals() {
        System.out.println("equals");
        Object object = null;
        TipoCentro instance = new TipoCentro();
        boolean expResult = false;
        boolean result = instance.equals(object);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of toString method, of class TipoCentro.
     */
    @Test
    public void testToString() {
        System.out.println("toString");
        TipoCentro instance = new TipoCentro();
        String expResult = "";
        String result = instance.toString();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
