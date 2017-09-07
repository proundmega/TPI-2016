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
@Table(name = "especialidad", catalog = "clinica", schema = "public")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Especialidad.findAll", query = "SELECT e FROM Especialidad e"),
    @NamedQuery(name = "Especialidad.findByNombre", query = "SELECT e FROM Especialidad e WHERE e.nombre = :nombre"),
    @NamedQuery(name = "Especialidad.findByActivo", query = "SELECT e FROM Especialidad e WHERE e.activo = :activo"),
    @NamedQuery(name = "Especialidad.findByObservaciones", query = "SELECT e FROM Especialidad e WHERE e.observaciones = :observaciones"),
    @NamedQuery(name = "Especialidad.findByIdEspecialidad", query = "SELECT e FROM Especialidad e WHERE e.idEspecialidad = :idEspecialidad")})
public class Especialidad implements Serializable {
    private static final long serialVersionUID = 1L;
    @Basic(optional = false)
    @Column(name = "nombre", nullable = false, length = 255)
    private String nombre;
    @Column(name = "activo")
    private Boolean activo;
    @Column(name = "observaciones", length = 2147483647)
    private String observaciones;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_especialidad", nullable = false)
    private Integer idEspecialidad;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "especialidad")
    private List<PersonalEspecialidad> personalEspecialidadList;
    @JoinColumn(name = "id_tipo_especialidad", referencedColumnName = "id_tipo_especialidad")
    @ManyToOne
    private TipoEspecialidad idTipoEspecialidad;

    public Especialidad() {
    }

    public Especialidad(Integer idEspecialidad) {
        this.idEspecialidad = idEspecialidad;
    }

    public Especialidad(Integer idEspecialidad, String nombre) {
        this.idEspecialidad = idEspecialidad;
        this.nombre = nombre;
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

    public Integer getIdEspecialidad() {
        return idEspecialidad;
    }

    public void setIdEspecialidad(Integer idEspecialidad) {
        this.idEspecialidad = idEspecialidad;
    }

    @XmlTransient
    public List<PersonalEspecialidad> getPersonalEspecialidadList() {
        return personalEspecialidadList;
    }

    public void setPersonalEspecialidadList(List<PersonalEspecialidad> personalEspecialidadList) {
        this.personalEspecialidadList = personalEspecialidadList;
    }

    public TipoEspecialidad getIdTipoEspecialidad() {
        return idTipoEspecialidad;
    }

    public void setIdTipoEspecialidad(TipoEspecialidad idTipoEspecialidad) {
        this.idTipoEspecialidad = idTipoEspecialidad;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idEspecialidad != null ? idEspecialidad.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Especialidad)) {
            return false;
        }
        Especialidad other = (Especialidad) object;
        if ((this.idEspecialidad == null && other.idEspecialidad != null) || (this.idEspecialidad != null && !this.idEspecialidad.equals(other.idEspecialidad))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "sv.proundmega.clinica.entities.Especialidad[ idEspecialidad=" + idEspecialidad + " ]";
    }

}
