/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package sv.edu.uesocc.ingenieria.tpi135_2016.clinica.datos.definiciones;

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
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author sakshi
 */
@Entity
@Table(name = "paciente_medio_contacto", catalog = "clinica", schema = "public")
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
    @Column(name = "medio", nullable = false, length = 2147483647)
    private String medio;
    @Column(name = "observaciones", length = 2147483647)
    private String observaciones;
    @JoinColumn(name = "id_medio_contacto", referencedColumnName = "id_medio_contacto", nullable = false, insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private MedioContacto medioContacto;
    @JoinColumn(name = "id_paciente", referencedColumnName = "id_paciente", nullable = false, insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Paciente paciente;

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

    public MedioContacto getMedioContacto() {
        return medioContacto;
    }

    public void setMedioContacto(MedioContacto medioContacto) {
        this.medioContacto = medioContacto;
    }

    public Paciente getPaciente() {
        return paciente;
    }

    public void setPaciente(Paciente paciente) {
        this.paciente = paciente;
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
        return "sv.proundmega.clinica.entities.PacienteMedioContacto[ pacienteMedioContactoPK=" + pacienteMedioContactoPK + " ]";
    }

}
