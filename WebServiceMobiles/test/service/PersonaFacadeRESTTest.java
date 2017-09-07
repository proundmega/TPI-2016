package service;

import data.Carrera;
import data.Color;
import data.Persona;
import data.Sexo;
import java.util.ArrayList;
import java.util.List;
import javax.ejb.embeddable.EJBContainer;
import javax.naming.NamingException;
import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class PersonaFacadeRESTTest {
    private static EJBContainer container;
    private PersonaFacadeREST rest;
    
    @BeforeClass
    public static void initContenedor() {
        container = EJBContainer.createEJBContainer();
    }
    
    @Before
    public void setuUpRest() throws NamingException {
        rest = (PersonaFacadeREST)container.getContext().lookup("java:global/classes/PersonaFacadeREST");
    }
    
    @Test
    public void ingresarDatos() {
        List<Persona> personas = getPersonasAAlmacenar();
        for (Persona persona : personas) {
            rest.create(persona);
        }
    }
    
    private List<Persona> getPersonasAAlmacenar() {
        List<Persona> personas = new ArrayList<>();
        personas.add(crearPersona("OG134009", "Vansi", "olivares", "0998-2211"));
        personas.add(crearPersona("12345677", "Olims", "Cansandar", "2453-0982"));
        personas.add(crearPersona("9876122", "Lama", "Lisandro", "0998-8211"));
        personas.add(crearPersona("XD0001", "Chamuco", "Calvino", "0987-6512"));
        
        return personas;
    } 
    
    private Persona crearPersona(String idPersona, String nombre, String apellido, String telefono) {
        Persona persona = new Persona();
        persona.setIdPersona(idPersona);
        persona.setApellido(apellido);
        persona.setNombre(nombre);
        persona.setTefelono(telefono);
        persona.setCarrera(Carrera.SISTEMAS);
        persona.setSexo(Sexo.MASCULINO);
        persona.setColor(Color.AZUL);
        
        return persona;
    }
    
}
