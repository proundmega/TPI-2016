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
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author VAIO
 */
@Entity
@Table(name = "centro")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Centro.findAll", query = "SELECT c FROM Centro c"),
    @NamedQuery(name = "Centro.findByIdCentro", query = "SELECT c FROM Centro c WHERE c.idCentro = :idCentro"),
    @NamedQuery(name = "Centro.findByNombreCorto", query = "SELECT c FROM Centro c WHERE c.nombreCorto = :nombreCorto"),
    @NamedQuery(name = "Centro.findByNombreOficial", query = "SELECT c FROM Centro c WHERE c.nombreOficial = :nombreOficial"),
    @NamedQuery(name = "Centro.findByLatitud", query = "SELECT c FROM Centro c WHERE c.latitud = :latitud"),
    @NamedQuery(name = "Centro.findByLongitud", query = "SELECT c FROM Centro c WHERE c.longitud = :longitud"),
    @NamedQuery(name = "Centro.findByFechaInicio", query = "SELECT c FROM Centro c WHERE c.fechaInicio = :fechaInicio"),
    @NamedQuery(name = "Centro.findByActivo", query = "SELECT c FROM Centro c WHERE c.activo = :activo"),
    @NamedQuery(name = "Centro.findByObservaciones", query = "SELECT c FROM Centro c WHERE c.observaciones = :observaciones")})
public class Centro implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_centro")
    private Integer idCentro;
    @Size(max = 155)
    @Column(name = "nombre_corto")
    private String nombreCorto;
    @Size(max = 255)
    @Column(name = "nombre_oficial")
    private String nombreOficial;
    @Size(max = 255)
    @Column(name = "latitud")
    private String latitud;
    @Size(max = 255)
    @Column(name = "longitud")
    private String longitud;
    @Column(name = "fecha_inicio")
    @Temporal(TemporalType.DATE)
    private Date fechaInicio;
    @Column(name = "activo")
    private Boolean activo;
    @Size(max = 2147483647)
    @Column(name = "observaciones")
    private String observaciones;
    @OneToMany(mappedBy = "idCentro")
    private List<AreaCentro> areaCentroList;
    @JoinColumn(name = "id_tipo_centro", referencedColumnName = "id_tipo_centro")
    @ManyToOne
    private TipoCentro idTipoCentro;

    public Centro() {
    }

    public Centro(Integer idCentro) {
        this.idCentro = idCentro;
    }

    public Integer getIdCentro() {
        return idCentro;
    }

    public void setIdCentro(Integer idCentro) {
        this.idCentro = idCentro;
    }

    public String getNombreCorto() {
        return nombreCorto;
    }

    public void setNombreCorto(String nombreCorto) {
        this.nombreCorto = nombreCorto;
    }

    public String getNombreOficial() {
        return nombreOficial;
    }

    public void setNombreOficial(String nombreOficial) {
        this.nombreOficial = nombreOficial;
    }

    public String getLatitud() {
        return latitud;
    }

    public void setLatitud(String latitud) {
        this.latitud = latitud;
    }

    public String getLongitud() {
        return longitud;
    }

    public void setLongitud(String longitud) {
        this.longitud = longitud;
    }

    public Date getFechaInicio() {
        return fechaInicio;
    }

    public void setFechaInicio(Date fechaInicio) {
        this.fechaInicio = fechaInicio;
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
    public List<AreaCentro> getAreaCentroList() {
        return areaCentroList;
    }

    public void setAreaCentroList(List<AreaCentro> areaCentroList) {
        this.areaCentroList = areaCentroList;
    }

    public TipoCentro getIdTipoCentro() {
        return idTipoCentro;
    }

    public void setIdTipoCentro(TipoCentro idTipoCentro) {
        this.idTipoCentro = idTipoCentro;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idCentro != null ? idCentro.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Centro)) {
            return false;
        }
        Centro other = (Centro) object;
        if ((this.idCentro == null && other.idCentro != null) || (this.idCentro != null && !this.idCentro.equals(other.idCentro))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "www.ues.edu.sv.local.entities.Centro[ idCentro=" + idCentro + " ]";
    }
    
}
