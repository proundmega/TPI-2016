/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sv.ues.edu.tpi2016.clinica.entities;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author VAIO
 */
@Entity
@Table(name = "paciente_medio_contacto")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "PacienteMedioContacto.findAll", query = "SELECT p FROM PacienteMedioContacto p"),
    @NamedQuery(name = "PacienteMedioContacto.findByIdPaciente", query = "SELECT p FROM PacienteMedioContacto p WHERE p.pacienteMedioContactoPK.idPaciente = :idPaciente"),
    @NamedQuery(name = "PacienteMedioContacto.findByIdMedioContacto", query = "SELECT p FROM PacienteMedioContacto p WHERE p.pacienteMedioContactoPK.idMedioContacto = :idMedioContacto"),
    @NamedQuery(name = "PacienteMedioContacto.findByMedio", query = "SELECT p FROM PacienteMedioContacto p WHERE p.medio = :medio"),
    @NamedQuery(name = "PacienteMedioContacto.findByObservaciones", query = "SELECT p FROM PacienteMedioContacto p WHERE p.observaciones = :observaciones")})
public class PacienteMedioContacto implements Serializable {

    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected PacienteMedioContactoPK pacienteMedioContactoPK;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 2147483647)
    @Column(name = "medio")
    private String medio;
    @Size(max = 2147483647)
    @Column(name = "observaciones")
    private String observaciones;
    @JoinColumn(name = "id_paciente", referencedColumnName = "id_paciente", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Paciente paciente;
    @JoinColumn(name = "id_medio_contacto", referencedColumnName = "id_medio_contacto", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private MedioContacto medioContacto;

    public PacienteMedioContacto() {
    }

    public PacienteMedioContacto(PacienteMedioContactoPK pacienteMedioContactoPK) {
        this.pacienteMedioContactoPK = pacienteMedioContactoPK;
    }

    public PacienteMedioContacto(PacienteMedioContactoPK pacienteMedioContactoPK, String medio) {
        this.pacienteMedioContactoPK = pacienteMedioContactoPK;
        this.medio = medio;
    }

    public PacienteMedioContacto(long idPaciente, int idMedioContacto) {
        this.pacienteMedioContactoPK = new PacienteMedioContactoPK(idPaciente, idMedioContacto);
    }

    public PacienteMedioContactoPK getPacienteMedioContactoPK() {
        return pacienteMedioContactoPK;
    }

    public void setPacienteMedioContactoPK(PacienteMedioContactoPK pacienteMedioContactoPK) {
        this.pacienteMedioContactoPK = pacienteMedioContactoPK;
    }

    public String getMedio() {
        return medio;
    }

    public void setMedio(String medio) {
        this.medio = medio;
    }

    public String getObservaciones() {
        return observaciones;
    }

    public void setObservaciones(String observaciones) {
        this.observaciones = observaciones;
    }

    public Paciente getPaciente() {
        return paciente;
    }

    public void setPaciente(Paciente paciente) {
        this.paciente = paciente;
    }

    public MedioContacto getMedioContacto() {
        return medioContacto;
    }

    public void setMedioContacto(MedioContacto medioContacto) {
        this.medioContacto = medioContacto;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (pacienteMedioContactoPK != null ? pacienteMedioContactoPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof PacienteMedioContacto)) {
            return false;
        }
        PacienteMedioContacto other = (PacienteMedioContacto) object;
        if ((this.pacienteMedioContactoPK == null && other.pacienteMedioContactoPK != null) || (this.pacienteMedioContactoPK != null && !this.pacienteMedioContactoPK.equals(other.pacienteMedioContactoPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "www.ues.edu.sv.local.entities.PacienteMedioContacto[ pacienteMedioContactoPK=" + pacienteMedioContactoPK + " ]";
    }
    
}
