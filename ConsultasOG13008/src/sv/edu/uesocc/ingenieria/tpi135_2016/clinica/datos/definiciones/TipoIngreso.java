/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package sv.edu.uesocc.ingenieria.tpi135_2016.clinica.datos.definiciones;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
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
@Table(name = "tipo_ingreso", catalog = "clinica", schema = "public")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "TipoIngreso.findAll", query = "SELECT t FROM TipoIngreso t"),
    @NamedQuery(name = "TipoIngreso.findByIdTipoIngreso", query = "SELECT t FROM TipoIngreso t WHERE t.idTipoIngreso = :idTipoIngreso"),
    @NamedQuery(name = "TipoIngreso.findByNombre", query = "SELECT t FROM TipoIngreso t WHERE t.nombre = :nombre"),
    @NamedQuery(name = "TipoIngreso.findByActivo", query = "SELECT t FROM TipoIngreso t WHERE t.activo = :activo"),
    @NamedQuery(name = "TipoIngreso.findByObservaciones", query = "SELECT t FROM TipoIngreso t WHERE t.observaciones = :observaciones")})
public class TipoIngreso implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_tipo_ingreso", nullable = false)
    private Integer idTipoIngreso;
    @Column(name = "nombre", length = 255)
    private String nombre;
    @Column(name = "activo")
    private Boolean activo;
    @Column(name = "observaciones", length = 2147483647)
    private String observaciones;
    @OneToMany(mappedBy = "idTipoIngreso")
    private List<Ingreso> ingresoList;

    public TipoIngreso() {
    }

    public TipoIngreso(Integer idTipoIngreso) {
        this.idTipoIngreso = idTipoIngreso;
    }

    public Integer getIdTipoIngreso() {
        return idTipoIngreso;
    }

    public void setIdTipoIngreso(Integer idTipoIngreso) {
        this.idTipoIngreso = idTipoIngreso;
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

    public String getObservaciones() {
        return observaciones;
    }

    public void setObservaciones(String observaciones) {
        this.observaciones = observaciones;
    }

    @XmlTransient
    public List<Ingreso> getIngresoList() {
        return ingresoList;
    }

    public void setIngresoList(List<Ingreso> ingresoList) {
        this.ingresoList = ingresoList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idTipoIngreso != null ? idTipoIngreso.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TipoIngreso)) {
            return false;
        }
        TipoIngreso other = (TipoIngreso) object;
        if ((this.idTipoIngreso == null && other.idTipoIngreso != null) || (this.idTipoIngreso != null && !this.idTipoIngreso.equals(other.idTipoIngreso))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "sv.proundmega.clinica.entities.TipoIngreso[ idTipoIngreso=" + idTipoIngreso + " ]";
    }

}
