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
@Table(name = "espacio", catalog = "clinica", schema = "public")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Espacio.findAll", query = "SELECT e FROM Espacio e"),
    @NamedQuery(name = "Espacio.findByIdEspacio", query = "SELECT e FROM Espacio e WHERE e.idEspacio = :idEspacio"),
    @NamedQuery(name = "Espacio.findByNombre", query = "SELECT e FROM Espacio e WHERE e.nombre = :nombre"),
    @NamedQuery(name = "Espacio.findByActivo", query = "SELECT e FROM Espacio e WHERE e.activo = :activo"),
    @NamedQuery(name = "Espacio.findByObservaciones", query = "SELECT e FROM Espacio e WHERE e.observaciones = :observaciones")})
public class Espacio implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_espacio", nullable = false)
    private Integer idEspacio;
    @Basic(optional = false)
    @Column(name = "nombre", nullable = false, length = 255)
    private String nombre;
    @Column(name = "activo")
    private Boolean activo;
    @Column(name = "observaciones", length = 2147483647)
    private String observaciones;
    @JoinColumn(name = "id_tipo_espacio", referencedColumnName = "id_tipo_espacio")
    @ManyToOne
    private TipoEspacio idTipoEspacio;
    @OneToMany(mappedBy = "idEspacio")
    private List<AreaCentroEspacio> areaCentroEspacioList;

    public Espacio() {
    }

    public Espacio(Integer idEspacio) {
        this.idEspacio = idEspacio;
    }

    public Espacio(Integer idEspacio, String nombre) {
        this.idEspacio = idEspacio;
        this.nombre = nombre;
    }

    public Integer getIdEspacio() {
        return idEspacio;
    }

    public void setIdEspacio(Integer idEspacio) {
        this.idEspacio = idEspacio;
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

    public TipoEspacio getIdTipoEspacio() {
        return idTipoEspacio;
    }

    public void setIdTipoEspacio(TipoEspacio idTipoEspacio) {
        this.idTipoEspacio = idTipoEspacio;
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
        hash += (idEspacio != null ? idEspacio.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Espacio)) {
            return false;
        }
        Espacio other = (Espacio) object;
        if ((this.idEspacio == null && other.idEspacio != null) || (this.idEspacio != null && !this.idEspacio.equals(other.idEspacio))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "sv.proundmega.clinica.entities.Espacio[ idEspacio=" + idEspacio + " ]";
    }

}
