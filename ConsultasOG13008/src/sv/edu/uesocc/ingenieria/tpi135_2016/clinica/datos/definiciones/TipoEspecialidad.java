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
@Table(name = "tipo_especialidad", catalog = "clinica", schema = "public")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "TipoEspecialidad.findAll", query = "SELECT t FROM TipoEspecialidad t"),
    @NamedQuery(name = "TipoEspecialidad.findByIdTipoEspecialidad", query = "SELECT t FROM TipoEspecialidad t WHERE t.idTipoEspecialidad = :idTipoEspecialidad"),
    @NamedQuery(name = "TipoEspecialidad.findByNombre", query = "SELECT t FROM TipoEspecialidad t WHERE t.nombre = :nombre"),
    @NamedQuery(name = "TipoEspecialidad.findByObservaciones", query = "SELECT t FROM TipoEspecialidad t WHERE t.observaciones = :observaciones"),
    @NamedQuery(name = "TipoEspecialidad.findByActivo", query = "SELECT t FROM TipoEspecialidad t WHERE t.activo = :activo")})
public class TipoEspecialidad implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_tipo_especialidad", nullable = false)
    private Integer idTipoEspecialidad;
    @Basic(optional = false)
    @Column(name = "nombre", nullable = false, length = 255)
    private String nombre;
    @Column(name = "observaciones", length = 2147483647)
    private String observaciones;
    @Column(name = "activo")
    private Boolean activo;
    @OneToMany(mappedBy = "idTipoEspecialidad")
    private List<Especialidad> especialidadList;

    public TipoEspecialidad() {
    }

    public TipoEspecialidad(Integer idTipoEspecialidad) {
        this.idTipoEspecialidad = idTipoEspecialidad;
    }

    public TipoEspecialidad(Integer idTipoEspecialidad, String nombre) {
        this.idTipoEspecialidad = idTipoEspecialidad;
        this.nombre = nombre;
    }

    public Integer getIdTipoEspecialidad() {
        return idTipoEspecialidad;
    }

    public void setIdTipoEspecialidad(Integer idTipoEspecialidad) {
        this.idTipoEspecialidad = idTipoEspecialidad;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getObservaciones() {
        return observaciones;
    }

    public void setObservaciones(String observaciones) {
        this.observaciones = observaciones;
    }

    public Boolean getActivo() {
        return activo;
    }

    public void setActivo(Boolean activo) {
        this.activo = activo;
    }

    @XmlTransient
    public List<Especialidad> getEspecialidadList() {
        return especialidadList;
    }

    public void setEspecialidadList(List<Especialidad> especialidadList) {
        this.especialidadList = especialidadList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idTipoEspecialidad != null ? idTipoEspecialidad.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TipoEspecialidad)) {
            return false;
        }
        TipoEspecialidad other = (TipoEspecialidad) object;
        if ((this.idTipoEspecialidad == null && other.idTipoEspecialidad != null) || (this.idTipoEspecialidad != null && !this.idTipoEspecialidad.equals(other.idTipoEspecialidad))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "sv.proundmega.clinica.entities.TipoEspecialidad[ idTipoEspecialidad=" + idTipoEspecialidad + " ]";
    }

}
