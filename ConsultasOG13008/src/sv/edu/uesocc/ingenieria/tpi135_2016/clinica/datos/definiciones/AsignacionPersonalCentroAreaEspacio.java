/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package sv.edu.uesocc.ingenieria.tpi135_2016.clinica.datos.definiciones;

import java.io.Serializable;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author sakshi
 */
@Entity
@Table(name = "asignacion_personal_centro_area_espacio", catalog = "clinica", schema = "public")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "AsignacionPersonalCentroAreaEspacio.findAll", query = "SELECT a FROM AsignacionPersonalCentroAreaEspacio a"),
    @NamedQuery(name = "AsignacionPersonalCentroAreaEspacio.findByIdAsignacionPersonalCentroArea", query = "SELECT a FROM AsignacionPersonalCentroAreaEspacio a WHERE a.asignacionPersonalCentroAreaEspacioPK.idAsignacionPersonalCentroArea = :idAsignacionPersonalCentroArea"),
    @NamedQuery(name = "AsignacionPersonalCentroAreaEspacio.findByIdAreaCentroEspacio", query = "SELECT a FROM AsignacionPersonalCentroAreaEspacio a WHERE a.asignacionPersonalCentroAreaEspacioPK.idAreaCentroEspacio = :idAreaCentroEspacio"),
    @NamedQuery(name = "AsignacionPersonalCentroAreaEspacio.findByIdTurno", query = "SELECT a FROM AsignacionPersonalCentroAreaEspacio a WHERE a.asignacionPersonalCentroAreaEspacioPK.idTurno = :idTurno"),
    @NamedQuery(name = "AsignacionPersonalCentroAreaEspacio.findByObservaciones", query = "SELECT a FROM AsignacionPersonalCentroAreaEspacio a WHERE a.observaciones = :observaciones")})
public class AsignacionPersonalCentroAreaEspacio implements Serializable {
    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected AsignacionPersonalCentroAreaEspacioPK asignacionPersonalCentroAreaEspacioPK;
    @Column(name = "observaciones", length = 2147483647)
    private String observaciones;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "asignacionPersonalCentroAreaEspacio")
    private List<IngresoDetalle> ingresoDetalleList;
    @JoinColumn(name = "id_asignacion_personal_centro_area", referencedColumnName = "id_asignacion_personal_centro_area", nullable = false, insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private AsignacionPersonalCentroArea asignacionPersonalCentroArea;

    public AsignacionPersonalCentroAreaEspacio() {
    }

    public AsignacionPersonalCentroAreaEspacio(AsignacionPersonalCentroAreaEspacioPK asignacionPersonalCentroAreaEspacioPK) {
        this.asignacionPersonalCentroAreaEspacioPK = asignacionPersonalCentroAreaEspacioPK;
    }

    public AsignacionPersonalCentroAreaEspacio(long idAsignacionPersonalCentroArea, long idAreaCentroEspacio, long idTurno) {
        this.asignacionPersonalCentroAreaEspacioPK = new AsignacionPersonalCentroAreaEspacioPK(idAsignacionPersonalCentroArea, idAreaCentroEspacio, idTurno);
    }

    public AsignacionPersonalCentroAreaEspacioPK getAsignacionPersonalCentroAreaEspacioPK() {
        return asignacionPersonalCentroAreaEspacioPK;
    }

    public void setAsignacionPersonalCentroAreaEspacioPK(AsignacionPersonalCentroAreaEspacioPK asignacionPersonalCentroAreaEspacioPK) {
        this.asignacionPersonalCentroAreaEspacioPK = asignacionPersonalCentroAreaEspacioPK;
    }

    public String getObservaciones() {
        return observaciones;
    }

    public void setObservaciones(String observaciones) {
        this.observaciones = observaciones;
    }

    @XmlTransient
    public List<IngresoDetalle> getIngresoDetalleList() {
        return ingresoDetalleList;
    }

    public void setIngresoDetalleList(List<IngresoDetalle> ingresoDetalleList) {
        this.ingresoDetalleList = ingresoDetalleList;
    }

    public AsignacionPersonalCentroArea getAsignacionPersonalCentroArea() {
        return asignacionPersonalCentroArea;
    }

    public void setAsignacionPersonalCentroArea(AsignacionPersonalCentroArea asignacionPersonalCentroArea) {
        this.asignacionPersonalCentroArea = asignacionPersonalCentroArea;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (asignacionPersonalCentroAreaEspacioPK != null ? asignacionPersonalCentroAreaEspacioPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof AsignacionPersonalCentroAreaEspacio)) {
            return false;
        }
        AsignacionPersonalCentroAreaEspacio other = (AsignacionPersonalCentroAreaEspacio) object;
        if ((this.asignacionPersonalCentroAreaEspacioPK == null && other.asignacionPersonalCentroAreaEspacioPK != null) || (this.asignacionPersonalCentroAreaEspacioPK != null && !this.asignacionPersonalCentroAreaEspacioPK.equals(other.asignacionPersonalCentroAreaEspacioPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "sv.proundmega.clinica.entities.AsignacionPersonalCentroAreaEspacio[ asignacionPersonalCentroAreaEspacioPK=" + asignacionPersonalCentroAreaEspacioPK + " ]";
    }

}
