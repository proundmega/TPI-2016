/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package sv.edu.uesocc.ingenieria.tpi135_2016.clinica.datos.definiciones;

import java.io.Serializable;
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
@Table(name = "diagnostico_examen", catalog = "clinica", schema = "public")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "DiagnosticoExamen.findAll", query = "SELECT d FROM DiagnosticoExamen d"),
    @NamedQuery(name = "DiagnosticoExamen.findByIdDiagnostico", query = "SELECT d FROM DiagnosticoExamen d WHERE d.diagnosticoExamenPK.idDiagnostico = :idDiagnostico"),
    @NamedQuery(name = "DiagnosticoExamen.findByIdExamen", query = "SELECT d FROM DiagnosticoExamen d WHERE d.diagnosticoExamenPK.idExamen = :idExamen"),
    @NamedQuery(name = "DiagnosticoExamen.findByObligatorio", query = "SELECT d FROM DiagnosticoExamen d WHERE d.obligatorio = :obligatorio"),
    @NamedQuery(name = "DiagnosticoExamen.findByObservaciones", query = "SELECT d FROM DiagnosticoExamen d WHERE d.observaciones = :observaciones")})
public class DiagnosticoExamen implements Serializable {
    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected DiagnosticoExamenPK diagnosticoExamenPK;
    @Column(name = "obligatorio")
    private Boolean obligatorio;
    @Column(name = "observaciones", length = 2147483647)
    private String observaciones;
    @JoinColumn(name = "id_diagnostico", referencedColumnName = "id_diagnostico", nullable = false, insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Diagnostico diagnostico;
    @JoinColumn(name = "id_examen", referencedColumnName = "id_examen", nullable = false, insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Examen examen;

    public DiagnosticoExamen() {
    }

    public DiagnosticoExamen(DiagnosticoExamenPK diagnosticoExamenPK) {
        this.diagnosticoExamenPK = diagnosticoExamenPK;
    }

    public DiagnosticoExamen(long idDiagnostico, long idExamen) {
        this.diagnosticoExamenPK = new DiagnosticoExamenPK(idDiagnostico, idExamen);
    }

    public DiagnosticoExamenPK getDiagnosticoExamenPK() {
        return diagnosticoExamenPK;
    }

    public void setDiagnosticoExamenPK(DiagnosticoExamenPK diagnosticoExamenPK) {
        this.diagnosticoExamenPK = diagnosticoExamenPK;
    }

    public Boolean getObligatorio() {
        return obligatorio;
    }

    public void setObligatorio(Boolean obligatorio) {
        this.obligatorio = obligatorio;
    }

    public String getObservaciones() {
        return observaciones;
    }

    public void setObservaciones(String observaciones) {
        this.observaciones = observaciones;
    }

    public Diagnostico getDiagnostico() {
        return diagnostico;
    }

    public void setDiagnostico(Diagnostico diagnostico) {
        this.diagnostico = diagnostico;
    }

    public Examen getExamen() {
        return examen;
    }

    public void setExamen(Examen examen) {
        this.examen = examen;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (diagnosticoExamenPK != null ? diagnosticoExamenPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof DiagnosticoExamen)) {
            return false;
        }
        DiagnosticoExamen other = (DiagnosticoExamen) object;
        if ((this.diagnosticoExamenPK == null && other.diagnosticoExamenPK != null) || (this.diagnosticoExamenPK != null && !this.diagnosticoExamenPK.equals(other.diagnosticoExamenPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "sv.proundmega.clinica.entities.DiagnosticoExamen[ diagnosticoExamenPK=" + diagnosticoExamenPK + " ]";
    }

}
