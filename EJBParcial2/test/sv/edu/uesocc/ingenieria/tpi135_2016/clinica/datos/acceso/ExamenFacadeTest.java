package sv.edu.uesocc.ingenieria.tpi135_2016.clinica.datos.acceso;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.ejb.embeddable.EJBContainer;
import javax.naming.NamingException;
import org.junit.AfterClass;
import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.BeforeClass;
import sv.edu.uesocc.ingenieria.tpi135_2016.clinica.datos.definiciones.Examen;

public class ExamenFacadeTest {
    private static EJBContainer container;
    private ExamenFacadeLocal examenFacade;
    
    @BeforeClass
    public static void init() {
        container = javax.ejb.embeddable.EJBContainer.createEJBContainer();
    }
    
    @Before
    public void setup() throws NamingException {
        examenFacade = (ExamenFacadeLocal)container.getContext().lookup("java:global/classes/ExamenFacade");
    }
    
    @AfterClass
    public static void finish() {
        container.close();
    }
            
    @Test
    public void testFiltrarConUnValor() {
        Map<String, Object> filtros = new HashMap<>();
        filtros.put("idExamen", 2);
        List<Examen> examenes = examenFacade.findByDataFilters(filtros, 0, 10);
        assertEquals(1, examenes.size());
    }
    
    @Test
    public void testFiltrarConDosValoresExactos() {
        Map<String, Object> filtros = new HashMap<>();
        filtros.put("observaciones", "Sun Pharmaceutical Industries Limited");
        filtros.put("nombre", "Rivastigmine Tartrate");
        List<Examen> examenes = examenFacade.findByDataFilters(filtros, 0, 10);
        assertEquals(1, examenes.size());
        assertEquals(9L, examenes.get(0).getIdExamen().longValue());
    }

    @Test
    public void testFiltrarConDosValoresLike() {
        Map<String, Object> filtros = new HashMap<>();
        filtros.put("observaciones", "Sun Pharmaceutical");
        filtros.put("nombre", "Rivasti");
        List<Examen> examenes = examenFacade.findByDataFilters(filtros, 0, 10);
        assertEquals(1, examenes.size());
        assertEquals(9L, examenes.get(0).getIdExamen().longValue());
    }
    
    @Test
    public void testFiltrarTresCampos() {
        Map<String, Object> filtros = new HashMap<>();
        filtros.put("observaciones", "armace");
        filtros.put("nombre", "asti");
        filtros.put("descripcion", "pround");
        List<Examen> examenes = examenFacade.findByDataFilters(filtros, 0, 10);
        assertEquals(1, examenes.size());
        assertEquals(9L, examenes.get(0).getIdExamen().longValue());
    }
    
    @Test
    public void testSiVieneFiltroId() {
        Map<String, Object> filtros = new HashMap<>();
        filtros.put("observaciones", "fx");
        filtros.put("nombre", "a");
        filtros.put("descripcion", "pround");
        filtros.put("idExamen", 95);
        List<Examen> examenes = examenFacade.findByDataFilters(filtros, 0, 10);
        assertEquals(1, examenes.size());
        assertEquals(95L, examenes.get(0).getIdExamen().longValue());
    }
    
    @Test
    public void testFiltradoInsensitivo() {
        Map<String, Object> filtros = new HashMap<>();
        filtros.put("descripcion", "inc");
        List<Examen> examenes = examenFacade.findByDataFilters(filtros, 0, 30);
        assertFalse(examenes.isEmpty());
        assertTrue(examenes.size() > 10);
    }
    
    @Test
    public void orderBy() {
        List<Examen> examenes = examenFacade.findByDataFilters(new HashMap<String, Object>(), 0, 100);
        Examen primero = examenes.get(0);
        for(int i = 1; i < examenes.size(); i++) {
            assertTrue(primero.getNombre().toLowerCase().compareTo(examenes.get(i).getNombre().toLowerCase()) < 0);
        }
    }
    
    @Test
    public void testPaginado() {
        int inicial = 0;
        int tamanioPagina = 5;
        List<Examen> examenes = examenFacade.findByDataFilters(new HashMap<String, Object>(), inicial, tamanioPagina);
        assertEquals(tamanioPagina, examenes.size());
    }
    
    @Test
    public void insertar() {
        Examen examen = new Examen();
        examen.setIdExamen(150L);
        assertTrue(examenFacade.crear(examen));
        assertTrue(examenFacade.eliminar(examen));
    }
    
    @Test
    public void insertarEntityYaExistente() {
        Examen examen = new Examen(10L);
        assertFalse(examenFacade.crear(examen));
    }
    
    @Test
    public void update() {
        Examen examen = examenFacade.find(1L);
        examen.setActivo(Boolean.TRUE);
        assertTrue(examenFacade.editar(examen));
        Examen referencia = examenFacade.find(1L);
        assertEquals(examen.getActivo(), referencia.getActivo());
    }
    
    @Test
    public void testQueryElementoBorrado() {
        long id = 10L;
        Examen examen = examenFacade.find(id);
        try {
            examenFacade.eliminar(examen);
            assertNull(examenFacade.find(id));
        } catch (Exception e) {
            assertTrue(true);
        }
        finally {
            examenFacade.crear(examen);
        }
    }
    
    @Test
    public void testBorrarElementoInborrable() {
        Examen imborrable = examenFacade.find(2L);
        assertFalse(examenFacade.eliminar(imborrable));
    }

}
