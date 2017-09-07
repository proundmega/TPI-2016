/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sv.ues.edu.tpi2016.clinica.entities;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author VAIO
 */
@Entity
@Table(name = "personal_especialidad")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "PersonalEspecialidad.findAll", query = "SELECT p FROM PersonalEspecialidad p"),
    @NamedQuery(name = "PersonalEspecialidad.findByIdPersonal", query = "SELECT p FROM PersonalEspecialidad p WHERE p.personalEspecialidadPK.idPersonal = :idPersonal"),
    @NamedQuery(name = "PersonalEspecialidad.findByIdEspecialidad", query = "SELECT p FROM PersonalEspecialidad p WHERE p.personalEspecialidadPK.idEspecialidad = :idEspecialidad"),
    @NamedQuery(name = "PersonalEspecialidad.findByFechaDesde", query = "SELECT p FROM PersonalEspecialidad p WHERE p.fechaDesde = :fechaDesde"),
    @NamedQuery(name = "PersonalEspecialidad.findByPrincipal", query = "SELECT p FROM PersonalEspecialidad p WHERE p.principal = :principal")})
public class PersonalEspecialidad implements Serializable {

    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected PersonalEspecialidadPK personalEspecialidadPK;
    @Column(name = "fecha_desde")
    @Temporal(TemporalType.DATE)
    private Date fechaDesde;
    @Column(name = "principal")
    private Boolean principal;
    @JoinColumn(name = "id_personal", referencedColumnName = "id_personal", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Personal personal;
    @JoinColumn(name = "id_especialidad", referencedColumnName = "id_especialidad", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Especialidad especialidad;

    public PersonalEspecialidad() {
    }

    public PersonalEspecialidad(PersonalEspecialidadPK personalEspecialidadPK) {
        this.personalEspecialidadPK = personalEspecialidadPK;
    }

    public PersonalEspecialidad(long idPersonal, int idEspecialidad) {
        this.personalEspecialidadPK = new PersonalEspecialidadPK(idPersonal, idEspecialidad);
    }

    public PersonalEspecialidadPK getPersonalEspecialidadPK() {
        return personalEspecialidadPK;
    }

    public void setPersonalEspecialidadPK(PersonalEspecialidadPK personalEspecialidadPK) {
        this.personalEspecialidadPK = personalEspecialidadPK;
    }

    public Date getFechaDesde() {
        return fechaDesde;
    }

    public void setFechaDesde(Date fechaDesde) {
        this.fechaDesde = fechaDesde;
    }

    public Boolean getPrincipal() {
        return principal;
    }

    public void setPrincipal(Boolean principal) {
        this.principal = principal;
    }

    public Personal getPersonal() {
        return personal;
    }

    public void setPersonal(Personal personal) {
        this.personal = personal;
    }

    public Especialidad getEspecialidad() {
        return especialidad;
    }

    public void setEspecialidad(Especialidad especialidad) {
        this.especialidad = especialidad;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (personalEspecialidadPK != null ? personalEspecialidadPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof PersonalEspecialidad)) {
            return false;
        }
        PersonalEspecialidad other = (PersonalEspecialidad) object;
        if ((this.personalEspecialidadPK == null && other.personalEspecialidadPK != null) || (this.personalEspecialidadPK != null && !this.personalEspecialidadPK.equals(other.personalEspecialidadPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "www.ues.edu.sv.local.entities.PersonalEspecialidad[ personalEspecialidadPK=" + personalEspecialidadPK + " ]";
    }
    
}
