/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sv.ues.edu.tpi2016.clinica.entities;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.validation.constraints.NotNull;

/**
 *
 * @author VAIO
 */
@Embeddable
public class DiagnosticoExamenPK implements Serializable {

    @Basic(optional = false)
    @NotNull
    @Column(name = "id_diagnostico")
    private long idDiagnostico;
    @Basic(optional = false)
    @NotNull
    @Column(name = "id_examen")
    private long idExamen;

    public DiagnosticoExamenPK() {
    }

    public DiagnosticoExamenPK(long idDiagnostico, long idExamen) {
        this.idDiagnostico = idDiagnostico;
        this.idExamen = idExamen;
    }

    public long getIdDiagnostico() {
        return idDiagnostico;
    }

    public void setIdDiagnostico(long idDiagnostico) {
        this.idDiagnostico = idDiagnostico;
    }

    public long getIdExamen() {
        return idExamen;
    }

    public void setIdExamen(long idExamen) {
        this.idExamen = idExamen;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (int) idDiagnostico;
        hash += (int) idExamen;
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof DiagnosticoExamenPK)) {
            return false;
        }
        DiagnosticoExamenPK other = (DiagnosticoExamenPK) object;
        if (this.idDiagnostico != other.idDiagnostico) {
            return false;
        }
        if (this.idExamen != other.idExamen) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "www.ues.edu.sv.local.entities.DiagnosticoExamenPK[ idDiagnostico=" + idDiagnostico + ", idExamen=" + idExamen + " ]";
    }
    
}
