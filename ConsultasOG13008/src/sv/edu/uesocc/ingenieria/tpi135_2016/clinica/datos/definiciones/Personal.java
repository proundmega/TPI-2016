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
@Table(name = "personal", catalog = "clinica", schema = "public")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Personal.findAll", query = "SELECT p FROM Personal p"),
    @NamedQuery(name = "Personal.findByIdPersonal", query = "SELECT p FROM Personal p WHERE p.idPersonal = :idPersonal"),
    @NamedQuery(name = "Personal.findByNombres", query = "SELECT p FROM Personal p WHERE p.nombres = :nombres"),
    @NamedQuery(name = "Personal.findByApellidos", query = "SELECT p FROM Personal p WHERE p.apellidos = :apellidos"),
    @NamedQuery(name = "Personal.findByDui", query = "SELECT p FROM Personal p WHERE p.dui = :dui"),
    @NamedQuery(name = "Personal.findByFechaIngreso", query = "SELECT p FROM Personal p WHERE p.fechaIngreso = :fechaIngreso")})
public class Personal implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_personal", nullable = false)
    private Long idPersonal;
    @Basic(optional = false)
    @Column(name = "nombres", nullable = false, length = 255)
    private String nombres;
    @Column(name = "apellidos", length = 255)
    private String apellidos;
    @Column(name = "dui", length = 10)
    private String dui;
    @Column(name = "fecha_ingreso")
    @Temporal(TemporalType.DATE)
    private Date fechaIngreso;
    @OneToMany(mappedBy = "idPersonal")
    private List<AsignacionPersonalCentroArea> asignacionPersonalCentroAreaList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "personal")
    private List<PersonalEspecialidad> personalEspecialidadList;

    public Personal() {
    }

    public Personal(Long idPersonal) {
        this.idPersonal = idPersonal;
    }

    public Personal(Long idPersonal, String nombres) {
        this.idPersonal = idPersonal;
        this.nombres = nombres;
    }

    public Long getIdPersonal() {
        return idPersonal;
    }

    public void setIdPersonal(Long idPersonal) {
        this.idPersonal = idPersonal;
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

    public String getDui() {
        return dui;
    }

    public void setDui(String dui) {
        this.dui = dui;
    }

    public Date getFechaIngreso() {
        return fechaIngreso;
    }

    public void setFechaIngreso(Date fechaIngreso) {
        this.fechaIngreso = fechaIngreso;
    }

    @XmlTransient
    public List<AsignacionPersonalCentroArea> getAsignacionPersonalCentroAreaList() {
        return asignacionPersonalCentroAreaList;
    }

    public void setAsignacionPersonalCentroAreaList(List<AsignacionPersonalCentroArea> asignacionPersonalCentroAreaList) {
        this.asignacionPersonalCentroAreaList = asignacionPersonalCentroAreaList;
    }

    @XmlTransient
    public List<PersonalEspecialidad> getPersonalEspecialidadList() {
        return personalEspecialidadList;
    }

    public void setPersonalEspecialidadList(List<PersonalEspecialidad> personalEspecialidadList) {
        this.personalEspecialidadList = personalEspecialidadList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idPersonal != null ? idPersonal.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Personal)) {
            return false;
        }
        Personal other = (Personal) object;
        if ((this.idPersonal == null && other.idPersonal != null) || (this.idPersonal != null && !this.idPersonal.equals(other.idPersonal))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "sv.proundmega.clinica.entities.Personal[ idPersonal=" + idPersonal + " ]";
    }

}
