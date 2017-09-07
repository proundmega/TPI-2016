/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sv.ues.edu.tpi2016.clinica.entities;

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
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
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
 * @author VAIO
 */
@Entity
@Table(name = "asignacion_personal_centro_area")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "AsignacionPersonalCentroArea.findAll", query = "SELECT a FROM AsignacionPersonalCentroArea a"),
    @NamedQuery(name = "AsignacionPersonalCentroArea.findByIdAsignacionPersonalCentroArea", query = "SELECT a FROM AsignacionPersonalCentroArea a WHERE a.idAsignacionPersonalCentroArea = :idAsignacionPersonalCentroArea"),
    @NamedQuery(name = "AsignacionPersonalCentroArea.findByFechaDesde", query = "SELECT a FROM AsignacionPersonalCentroArea a WHERE a.fechaDesde = :fechaDesde"),
    @NamedQuery(name = "AsignacionPersonalCentroArea.findByFechaHasta", query = "SELECT a FROM AsignacionPersonalCentroArea a WHERE a.fechaHasta = :fechaHasta")})
public class AsignacionPersonalCentroArea implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_asignacion_personal_centro_area")
    private Long idAsignacionPersonalCentroArea;
    @Column(name = "fecha_desde")
    @Temporal(TemporalType.DATE)
    private Date fechaDesde;
    @Column(name = "fecha_hasta")
    @Temporal(TemporalType.DATE)
    private Date fechaHasta;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "asignacionPersonalCentroArea")
    private List<AsignacionPersonalCentroAreaEspacio> asignacionPersonalCentroAreaEspacioList;
    @JoinColumn(name = "id_personal", referencedColumnName = "id_personal")
    @ManyToOne
    private Personal idPersonal;
    @JoinColumn(name = "id_area_centro", referencedColumnName = "id_area_centro")
    @ManyToOne(optional = false)
    private AreaCentro idAreaCentro;

    public AsignacionPersonalCentroArea() {
    }

    public AsignacionPersonalCentroArea(Long idAsignacionPersonalCentroArea) {
        this.idAsignacionPersonalCentroArea = idAsignacionPersonalCentroArea;
    }

    public Long getIdAsignacionPersonalCentroArea() {
        return idAsignacionPersonalCentroArea;
    }

    public void setIdAsignacionPersonalCentroArea(Long idAsignacionPersonalCentroArea) {
        this.idAsignacionPersonalCentroArea = idAsignacionPersonalCentroArea;
    }

    public Date getFechaDesde() {
        return fechaDesde;
    }

    public void setFechaDesde(Date fechaDesde) {
        this.fechaDesde = fechaDesde;
    }

    public Date getFechaHasta() {
        return fechaHasta;
    }

    public void setFechaHasta(Date fechaHasta) {
        this.fechaHasta = fechaHasta;
    }

    @XmlTransient
    public List<AsignacionPersonalCentroAreaEspacio> getAsignacionPersonalCentroAreaEspacioList() {
        return asignacionPersonalCentroAreaEspacioList;
    }

    public void setAsignacionPersonalCentroAreaEspacioList(List<AsignacionPersonalCentroAreaEspacio> asignacionPersonalCentroAreaEspacioList) {
        this.asignacionPersonalCentroAreaEspacioList = asignacionPersonalCentroAreaEspacioList;
    }

    public Personal getIdPersonal() {
        return idPersonal;
    }

    public void setIdPersonal(Personal idPersonal) {
        this.idPersonal = idPersonal;
    }

    public AreaCentro getIdAreaCentro() {
        return idAreaCentro;
    }

    public void setIdAreaCentro(AreaCentro idAreaCentro) {
        this.idAreaCentro = idAreaCentro;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idAsignacionPersonalCentroArea != null ? idAsignacionPersonalCentroArea.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof AsignacionPersonalCentroArea)) {
            return false;
        }
        AsignacionPersonalCentroArea other = (AsignacionPersonalCentroArea) object;
        if ((this.idAsignacionPersonalCentroArea == null && other.idAsignacionPersonalCentroArea != null) || (this.idAsignacionPersonalCentroArea != null && !this.idAsignacionPersonalCentroArea.equals(other.idAsignacionPersonalCentroArea))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "www.ues.edu.sv.local.entities.AsignacionPersonalCentroArea[ idAsignacionPersonalCentroArea=" + idAsignacionPersonalCentroArea + " ]";
    }
    
}
