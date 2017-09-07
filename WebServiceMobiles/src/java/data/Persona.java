package data;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Id;
import javax.xml.bind.annotation.XmlRootElement;

@Entity
@XmlRootElement
public class Persona implements Serializable{
    
    @Id
    @Column
    private String idPersona;
    
    @Column
    private String nombre;
    
    @Column
    private String apellido;
    
    @Column
    private String tefelono;
    
    @Column
    @Enumerated(EnumType.STRING)
    private Sexo sexo;
    
    @Column
    @Enumerated(EnumType.STRING)
    private Color color;
    
    @Column
    @Enumerated(EnumType.STRING)
    private Carrera carrera;

    public String getIdPersona() {
        return idPersona;
    }

    public void setIdPersona(String idPersona) {
        this.idPersona = idPersona;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getTefelono() {
        return tefelono;
    }

    public void setTefelono(String tefelono) {
        this.tefelono = tefelono;
    }

    public Sexo getSexo() {
        return sexo;
    }

    public void setSexo(Sexo sexo) {
        this.sexo = sexo;
    }

    public Color getColor() {
        return color;
    }

    public void setColor(Color color) {
        this.color = color;
    }

    public Carrera getCarrera() {
        return carrera;
    }

    public void setCarrera(Carrera carrera) {
        this.carrera = carrera;
    }

    @Override
    public String toString() {
        return "Persona{" +
                "idPersona='" + idPersona + '\'' +
                ", nombre='" + nombre + '\'' +
                ", apellido='" + apellido + '\'' +
                ", tefelono='" + tefelono + '\'' +
                ", sexo=" + sexo +
                ", color=" + color +
                ", carrera=" + carrera +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Persona persona = (Persona) o;

        if (!idPersona.equals(persona.idPersona)) return false;
        if (nombre != null ? !nombre.equals(persona.nombre) : persona.nombre != null) return false;
        if (apellido != null ? !apellido.equals(persona.apellido) : persona.apellido != null)
            return false;
        if (tefelono != null ? !tefelono.equals(persona.tefelono) : persona.tefelono != null)
            return false;
        if (sexo != persona.sexo) return false;
        if (color != persona.color) return false;
        return carrera == persona.carrera;

    }

    @Override
    public int hashCode() {
        int result = idPersona.hashCode();
        result = 31 * result + (nombre != null ? nombre.hashCode() : 0);
        result = 31 * result + (apellido != null ? apellido.hashCode() : 0);
        result = 31 * result + (tefelono != null ? tefelono.hashCode() : 0);
        result = 31 * result + (sexo != null ? sexo.hashCode() : 0);
        result = 31 * result + (color != null ? color.hashCode() : 0);
        result = 31 * result + (carrera != null ? carrera.hashCode() : 0);
        return result;
    }
}
