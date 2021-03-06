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
public class IngresoDetallePK implements Serializable {
    @Basic(optional = false)
    @Column(name = "id_ingreso", nullable = false)
    private long idIngreso;
    @Basic(optional = false)
    @Column(name = "id_asignacion_personal_centro_area", nullable = false)
    private long idAsignacionPersonalCentroArea;
    @Basic(optional = false)
    @Column(name = "id_area_centro_espacio", nullable = false)
    private long idAreaCentroEspacio;
    @Basic(optional = false)
    @Column(name = "id_turno", nullable = false)
    private long idTurno;

    public IngresoDetallePK() {
    }

    public IngresoDetallePK(long idIngreso, long idAsignacionPersonalCentroArea, long idAreaCentroEspacio, long idTurno) {
        this.idIngreso = idIngreso;
        this.idAsignacionPersonalCentroArea = idAsignacionPersonalCentroArea;
        this.idAreaCentroEspacio = idAreaCentroEspacio;
        this.idTurno = idTurno;
    }

    public long getIdIngreso() {
        return idIngreso;
    }

    public void setIdIngreso(long idIngreso) {
        this.idIngreso = idIngreso;
    }

    public long getIdAsignacionPersonalCentroArea() {
        return idAsignacionPersonalCentroArea;
    }

    public void setIdAsignacionPersonalCentroArea(long idAsignacionPersonalCentroArea) {
        this.idAsignacionPersonalCentroArea = idAsignacionPersonalCentroArea;
    }

    public long getIdAreaCentroEspacio() {
        return idAreaCentroEspacio;
    }

    public void setIdAreaCentroEspacio(long idAreaCentroEspacio) {
        this.idAreaCentroEspacio = idAreaCentroEspacio;
    }

    public long getIdTurno() {
        return idTurno;
    }

    public void setIdTurno(long idTurno) {
        this.idTurno = idTurno;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (int) idIngreso;
        hash += (int) idAsignacionPersonalCentroArea;
        hash += (int) idAreaCentroEspacio;
        hash += (int) idTurno;
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof IngresoDetallePK)) {
            return false;
        }
        IngresoDetallePK other = (IngresoDetallePK) object;
        if (this.idIngreso != other.idIngreso) {
            return false;
        }
        if (this.idAsignacionPersonalCentroArea != other.idAsignacionPersonalCentroArea) {
            return false;
        }
        if (this.idAreaCentroEspacio != other.idAreaCentroEspacio) {
            return false;
        }
        if (this.idTurno != other.idTurno) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "sv.proundmega.clinica.entities.IngresoDetallePK[ idIngreso=" + idIngreso + ", idAsignacionPersonalCentroArea=" + idAsignacionPersonalCentroArea + ", idAreaCentroEspacio=" + idAreaCentroEspacio + ", idTurno=" + idTurno + " ]";
    }

}
