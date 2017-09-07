/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package sv.edu.uesocc.ingenieria.tpi135_2016.clinica.datos.definiciones;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author sakshi
 */
@Entity
@Table(name = "paciente", catalog = "clinica", schema = "public")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Paciente.findAll", query = "SELECT p FROM Paciente p"),
    @NamedQuery(name = "Paciente.findByIdPaciente", query = "SELECT p FROM Paciente p WHERE p.idPaciente = :idPaciente"),
    @NamedQuery(name = "Paciente.findByNombres", query = "SELECT p FROM Paciente p WHERE p.nombres = :nombres"),
    @NamedQuery(name = "Paciente.findByApellidos", query = "SELECT p FROM Paciente p WHERE p.apellidos = :apellidos"),
    @NamedQuery(name = "Paciente.findByFechaNacimiento", query = "SELECT p FROM Paciente p WHERE p.fechaNacimiento = :fechaNacimiento"),
    @NamedQuery(name = "Paciente.findByFechaDefuncion", query = "SELECT p FROM Paciente p WHERE p.fechaDefuncion = :fechaDefuncion"),
    @NamedQuery(name = "Paciente.findByObservaciones", query = "SELECT p FROM Paciente p WHERE p.observaciones = :observaciones"),
    @NamedQuery(name = "Paciente.findCronologiaDiagnosticos", query = "SELECT d.nombre, ldd.fechaDiagnostico, ps.nombres, ps.apellidos, c.nombreCorto\n" +
                                    "FROM Paciente p\n" +
                                    "JOIN p.ingresoList l1,\n" +
                                    "    l1.ingresoDetalleList l2,\n" +
                                    "    l2.ingresoDetalleDiagnosticoList ldd,\n" +
                                    "    ldd.idDiagnostico d,\n" +
                                    "    l2.asignacionPersonalCentroAreaEspacio l3,\n" +
                                    "    l3.asignacionPersonalCentroArea l4,\n" +
                                    "    l4.idAreaCentro l5,\n" +
                                    "    l5.idCentro c,\n" +
                                    "    l4.idPersonal ps\n" +
                                    "WHERE p.idPaciente = :idPaciente"),
    
    @NamedQuery(name = "Paciente.DiagnosticadosConAPeroNoConB", query = "SELECT DISTINCT p\n" +
                                    "FROM Paciente p\n" +
                                    "JOIN p.ingresoList l1,\n" +
                                    "    l1.ingresoDetalleList l2,\n" +
                                    "    l2.ingresoDetalleDiagnosticoList l3,\n" +
                                    "    l3.idDiagnostico d\n" +
                                    "WHERE p NOT IN(\n" +
                                    "    SELECT p\n" +
                                    "    FROM Paciente p\n" +
                                    "    JOIN p.ingresoList l1,\n" +
                                    "        l1.ingresoDetalleList l2,\n" +
                                    "        l2.ingresoDetalleDiagnosticoList l3,\n" +
                                    "        l3.idDiagnostico d\n" +
                                    "        WHERE d.nombre = :nombreDiagnosticoB\n" +
                                    ")\n" +
                                    "AND d.nombre = :nombreDiagnosticoA")})
public class Paciente implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_paciente", nullable = false)
    private Long idPaciente;
    @Column(name = "nombres", length = 255)
    private String nombres;
    @Column(name = "apellidos", length = 255)
    private String apellidos;
    @Column(name = "fecha_nacimiento")
    @Temporal(TemporalType.DATE)
    private Date fechaNacimiento;
    @Column(name = "fecha_defuncion")
    @Temporal(TemporalType.DATE)
    private Date fechaDefuncion;
    @Column(name = "observaciones", length = 2147483647)
    private String observaciones;
    @OneToMany(mappedBy = "idPaciente")
    private List<Ingreso> ingresoList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "paciente")
    private List<PacienteMedioContacto> pacienteMedioContactoList;

    public Paciente() {
    }

    public Paciente(Long idPaciente) {
        this.idPaciente = idPaciente;
    }

    public Long getIdPaciente() {
        return idPaciente;
    }

    public void setIdPaciente(Long idPaciente) {
        this.idPaciente = idPaciente;
    }

    public String getNombres() {
        return nombres;
    }

    public void setNombres(String nombres) {
        this.nombres = nombres;
    }

    public String getApellidos() {
        return apellidos;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    public Date getFechaNacimiento() {
        return fechaNacimiento;
    }

    public void setFechaNacimiento(Date fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }

    public Date getFechaDefuncion() {
        return fechaDefuncion;
    }

    public void setFechaDefuncion(Date fechaDefuncion) {
        this.fechaDefuncion = fechaDefuncion;
    }

    public String getObservaciones() {
        return observaciones;
    }

    public void setObservaciones(String observaciones) {
        this.observaciones = observaciones;
    }

    @XmlTransient
    public List<Ingreso> getIngresoList() {
        return ingresoList;
    }

    public void setIngresoList(List<Ingreso> ingresoList) {
        this.ingresoList = ingresoList;
    }

    @XmlTransient
    public List<PacienteMedioContacto> getPacienteMedioContactoList() {
        return pacienteMedioContactoList;
    }

    public void setPacienteMedioContactoList(List<PacienteMedioContacto> pacienteMedioContactoList) {
        this.pacienteMedioContactoList = pacienteMedioContactoList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idPaciente != null ? idPaciente.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Paciente)) {
            return false;
        }
        Paciente other = (Paciente) object;
        if ((this.idPaciente == null && other.idPaciente != null) || (this.idPaciente != null && !this.idPaciente.equals(other.idPaciente))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "sv.proundmega.clinica.entities.Paciente[ idPaciente=" + idPaciente + " ]";
    }

}
