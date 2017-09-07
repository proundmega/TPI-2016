/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package sv.edu.uesocc.ingenieria.tpi135_2016.clinica.datos.definiciones;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Embeddable;

/**
 *
 * @author sakshi
 */
@Embeddable
public class PacienteMedioContactoPK implements Serializable {
    @Basic(optional = false)
    @Column(name = "id_paciente", nullable = false)
    private long idPaciente;
    @Basic(optional = false)
    @Column(name = "id_medio_contacto", nullable = false)
    private int idMedioContacto;

    public PacienteMedioContactoPK() {
    }

    public PacienteMedioContactoPK(long idPaciente, int idMedioContacto) {
        this.idPaciente = idPaciente;
        this.idMedioContacto = idMedioContacto;
    }

    public long getIdPaciente() {
        return idPaciente;
    }

    public void setIdPaciente(long idPaciente) {
        this.idPaciente = idPaciente;
    }

    public int getIdMedioContacto() {
        return idMedioContacto;
    }

    public void setIdMedioContacto(int idMedioContacto) {
        this.idMedioContacto = idMedioContacto;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (int) idPaciente;
        hash += (int) idMedioContacto;
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof PacienteMedioContactoPK)) {
            return false;
        }
        PacienteMedioContactoPK other = (PacienteMedioContactoPK) object;
        if (this.idPaciente != other.idPaciente) {
            return false;
        }
        if (this.idMedioContacto != other.idMedioContacto) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "sv.proundmega.clinica.entities.PacienteMedioContactoPK[ idPaciente=" + idPaciente + ", idMedioContacto=" + idMedioContacto + " ]";
    }

}
