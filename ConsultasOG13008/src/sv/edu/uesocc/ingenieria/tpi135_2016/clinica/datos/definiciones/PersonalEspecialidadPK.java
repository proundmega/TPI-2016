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
public class PersonalEspecialidadPK implements Serializable {
    @Basic(optional = false)
    @Column(name = "id_personal", nullable = false)
    private long idPersonal;
    @Basic(optional = false)
    @Column(name = "id_especialidad", nullable = false)
    private int idEspecialidad;

    public PersonalEspecialidadPK() {
    }

    public PersonalEspecialidadPK(long idPersonal, int idEspecialidad) {
        this.idPersonal = idPersonal;
        this.idEspecialidad = idEspecialidad;
    }

    public long getIdPersonal() {
        return idPersonal;
    }

    public void setIdPersonal(long idPersonal) {
        this.idPersonal = idPersonal;
    }

    public int getIdEspecialidad() {
        return idEspecialidad;
    }

    public void setIdEspecialidad(int idEspecialidad) {
        this.idEspecialidad = idEspecialidad;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (int) idPersonal;
        hash += (int) idEspecialidad;
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof PersonalEspecialidadPK)) {
            return false;
        }
        PersonalEspecialidadPK other = (PersonalEspecialidadPK) object;
        if (this.idPersonal != other.idPersonal) {
            return false;
        }
        if (this.idEspecialidad != other.idEspecialidad) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "sv.proundmega.clinica.entities.PersonalEspecialidadPK[ idPersonal=" + idPersonal + ", idEspecialidad=" + idEspecialidad + " ]";
    }

}
