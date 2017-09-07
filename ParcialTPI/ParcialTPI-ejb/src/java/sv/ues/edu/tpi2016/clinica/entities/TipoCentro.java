/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sv.ues.edu.tpi2016.clinica.entities;

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
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author VAIO
 */
@Entity
@Table(name = "tipo_centro")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "TipoCentro.findAll", query = "SELECT t FROM TipoCentro t"),
    @NamedQuery(name = "TipoCentro.findByIdTipoCentro", query = "SELECT t FROM TipoCentro t WHERE t.idTipoCentro = :idTipoCentro"),
    @NamedQuery(name = "TipoCentro.findByNombre", query = "SELECT t FROM TipoCentro t WHERE t.nombre = :nombre"),
    @NamedQuery(name = "TipoCentro.findByActivo", query = "SELECT t FROM TipoCentro t WHERE t.activo = :activo"),
    @NamedQuery(name = "TipoCentro.findByObservaciones", query = "SELECT t FROM TipoCentro t WHERE t.observaciones = :observaciones")})
public class TipoCentro implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_tipo_centro")
    private Integer idTipoCentro;
    @Size(max = 255)
    @Column(name = "nombre")
    private String nombre;
    @Column(name = "activo")
    private Boolean activo;
    @Size(max = 2147483647)
    @Column(name = "observaciones")
    private String observaciones;
    @OneToMany(mappedBy = "idTipoCentro")
    private List<Centro> centroList;

    public TipoCentro() {
    }

    public TipoCentro(Integer idTipoCentro) {
        this.idTipoCentro = idTipoCentro;
    }

    public Integer getIdTipoCentro() {
        return idTipoCentro;
    }

    public void setIdTipoCentro(Integer idTipoCentro) {
        this.idTipoCentro = idTipoCentro;
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
    public List<Centro> getCentroList() {
        return centroList;
    }

    public void setCentroList(List<Centro> centroList) {
        this.centroList = centroList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idTipoCentro != null ? idTipoCentro.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TipoCentro)) {
            return false;
        }
        TipoCentro other = (TipoCentro) object;
        if ((this.idTipoCentro == null && other.idTipoCentro != null) || (this.idTipoCentro != null && !this.idTipoCentro.equals(other.idTipoCentro))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "www.ues.edu.sv.local.entities.TipoCentro[ idTipoCentro=" + idTipoCentro + " ]";
    }
    
}
