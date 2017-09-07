/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package sv.edu.uesocc.ingenieria.tpi135_2016.clinica.datos.definiciones;

import java.io.Serializable;
import java.math.BigInteger;
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
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author sakshi
 */
@Entity
@Table(name = "area_centro_espacio", catalog = "clinica", schema = "public")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "AreaCentroEspacio.findAll", query = "SELECT a FROM AreaCentroEspacio a"),
    @NamedQuery(name = "AreaCentroEspacio.findByIdAreaCentroEspacio", query = "SELECT a FROM AreaCentroEspacio a WHERE a.idAreaCentroEspacio = :idAreaCentroEspacio"),
    @NamedQuery(name = "AreaCentroEspacio.findByIdAreaCentroEspacioPadre", query = "SELECT a FROM AreaCentroEspacio a WHERE a.idAreaCentroEspacioPadre = :idAreaCentroEspacioPadre"),
    @NamedQuery(name = "AreaCentroEspacio.findByNombre", query = "SELECT a FROM AreaCentroEspacio a WHERE a.nombre = :nombre"),
    @NamedQuery(name = "AreaCentroEspacio.findByActivo", query = "SELECT a FROM AreaCentroEspacio a WHERE a.activo = :activo")})
public class AreaCentroEspacio implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_area_centro_espacio", nullable = false)
    private Long idAreaCentroEspacio;
    @Column(name = "id_area_centro_espacio_padre")
    private BigInteger idAreaCentroEspacioPadre;
    @Column(name = "nombre", length = 255)
    private String nombre;
    @Column(name = "activo")
    private Boolean activo;
    @JoinColumn(name = "id_area_centro", referencedColumnName = "id_area_centro")
    @ManyToOne
    private AreaCentro idAreaCentro;
    @JoinColumn(name = "id_espacio", referencedColumnName = "id_espacio")
    @ManyToOne
    private Espacio idEspacio;

    public AreaCentroEspacio() {
    }

    public AreaCentroEspacio(Long idAreaCentroEspacio) {
        this.idAreaCentroEspacio = idAreaCentroEspacio;
    }

    public Long getIdAreaCentroEspacio() {
        return idAreaCentroEspacio;
    }

    public void setIdAreaCentroEspacio(Long idAreaCentroEspacio) {
        this.idAreaCentroEspacio = idAreaCentroEspacio;
    }

    public BigInteger getIdAreaCentroEspacioPadre() {
        return idAreaCentroEspacioPadre;
    }

    public void setIdAreaCentroEspacioPadre(BigInteger idAreaCentroEspacioPadre) {
        this.idAreaCentroEspacioPadre = idAreaCentroEspacioPadre;
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

    public AreaCentro getIdAreaCentro() {
        return idAreaCentro;
    }

    public void setIdAreaCentro(AreaCentro idAreaCentro) {
        this.idAreaCentro = idAreaCentro;
    }

    public Espacio getIdEspacio() {
        return idEspacio;
    }

    public void setIdEspacio(Espacio idEspacio) {
        this.idEspacio = idEspacio;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idAreaCentroEspacio != null ? idAreaCentroEspacio.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof AreaCentroEspacio)) {
            return false;
        }
        AreaCentroEspacio other = (AreaCentroEspacio) object;
        if ((this.idAreaCentroEspacio == null && other.idAreaCentroEspacio != null) || (this.idAreaCentroEspacio != null && !this.idAreaCentroEspacio.equals(other.idAreaCentroEspacio))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "sv.proundmega.clinica.entities.AreaCentroEspacio[ idAreaCentroEspacio=" + idAreaCentroEspacio + " ]";
    }

}
