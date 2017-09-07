/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package sv.edu.uesocc.ingenieria.tpi135_2016.clinica.datos.definiciones;

import java.io.Serializable;
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
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author sakshi
 */
@Entity
@Table(name = "area_centro", catalog = "clinica", schema = "public")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "AreaCentro.findAll", query = "SELECT a FROM AreaCentro a"),
    @NamedQuery(name = "AreaCentro.findByIdAreaCentro", query = "SELECT a FROM AreaCentro a WHERE a.idAreaCentro = :idAreaCentro"),
    @NamedQuery(name = "AreaCentro.findByNombre", query = "SELECT a FROM AreaCentro a WHERE a.nombre = :nombre"),
    @NamedQuery(name = "AreaCentro.findByActivo", query = "SELECT a FROM AreaCentro a WHERE a.activo = :activo")})
public class AreaCentro implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_area_centro", nullable = false)
    private Long idAreaCentro;
    @Column(name = "nombre", length = 255)
    private String nombre;
    @Column(name = "activo")
    private Boolean activo;
    @JoinColumn(name = "id_area", referencedColumnName = "id_area")
    @ManyToOne
    private Area idArea;
    @JoinColumn(name = "id_centro", referencedColumnName = "id_centro")
    @ManyToOne
    private Centro idCentro;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idAreaCentro")
    private List<AsignacionPersonalCentroArea> asignacionPersonalCentroAreaList;
    @OneToMany(mappedBy = "idAreaCentro")
    private List<AreaCentroEspacio> areaCentroEspacioList;

    public AreaCentro() {
    }

    public AreaCentro(Long idAreaCentro) {
        this.idAreaCentro = idAreaCentro;
    }

    public Long getIdAreaCentro() {
        return idAreaCentro;
    }

    public void setIdAreaCentro(Long idAreaCentro) {
        this.idAreaCentro = idAreaCentro;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Boolean getActivo() {
        return activo;
    }

    public void setActivo(Boolean activo) {
        this.activo = activo;
    }

    public Area getIdArea() {
        return idArea;
    }

    public void setIdArea(Area idArea) {
        this.idArea = idArea;
    }

    public Centro getIdCentro() {
        return idCentro;
    }

    public void setIdCentro(Centro idCentro) {
        this.idCentro = idCentro;
    }

    @XmlTransient
    public List<AsignacionPersonalCentroArea> getAsignacionPersonalCentroAreaList() {
        return asignacionPersonalCentroAreaList;
    }

    public void setAsignacionPersonalCentroAreaList(List<AsignacionPersonalCentroArea> asignacionPersonalCentroAreaList) {
        this.asignacionPersonalCentroAreaList = asignacionPersonalCentroAreaList;
    }

    @XmlTransient
    public List<AreaCentroEspacio> getAreaCentroEspacioList() {
        return areaCentroEspacioList;
    }

    public void setAreaCentroEspacioList(List<AreaCentroEspacio> areaCentroEspacioList) {
        this.areaCentroEspacioList = areaCentroEspacioList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idAreaCentro != null ? idAreaCentro.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof AreaCentro)) {
            return false;
        }
        AreaCentro other = (AreaCentro) object;
        if ((this.idAreaCentro == null && other.idAreaCentro != null) || (this.idAreaCentro != null && !this.idAreaCentro.equals(other.idAreaCentro))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "sv.proundmega.clinica.entities.AreaCentro[ idAreaCentro=" + idAreaCentro + " ]";
    }

}
