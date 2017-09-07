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
@Table(name = "medio_contacto", catalog = "clinica", schema = "public")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "MedioContacto.findAll", query = "SELECT m FROM MedioContacto m"),
    @NamedQuery(name = "MedioContacto.findByIdMedioContacto", query = "SELECT m FROM MedioContacto m WHERE m.idMedioContacto = :idMedioContacto"),
    @NamedQuery(name = "MedioContacto.findByNombre", query = "SELECT m FROM MedioContacto m WHERE m.nombre = :nombre")})
public class MedioContacto implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_medio_contacto", nullable = false)
    private Integer idMedioContacto;
    @Column(name = "nombre", length = 255)
    private String nombre;
    @JoinColumn(name = "id_tipo_medio_contacto", referencedColumnName = "id_tipo_medio_contacto")
    @ManyToOne
    private TipoMedioContacto idTipoMedioContacto;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "medioContacto")
    private List<PacienteMedioContacto> pacienteMedioContactoList;

    public MedioContacto() {
    }

    public MedioContacto(Integer idMedioContacto) {
        this.idMedioContacto = idMedioContacto;
    }

    public Integer getIdMedioContacto() {
        return idMedioContacto;
    }

    public void setIdMedioContacto(Integer idMedioContacto) {
        this.idMedioContacto = idMedioContacto;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public TipoMedioContacto getIdTipoMedioContacto() {
        return idTipoMedioContacto;
    }

    public void setIdTipoMedioContacto(TipoMedioContacto idTipoMedioContacto) {
        this.idTipoMedioContacto = idTipoMedioContacto;
    }

    @XmlTransient
    public List<PacienteMedioContacto> getPacienteMedioContactoList() {
        return pacienteMedioContactoList;
    }

    public void setPacienteMedioContactoList(List<PacienteMedioContacto> pacienteMedioContactoList) {
        this.pacienteMedioContactoList = pacienteMedioContactoList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idMedioContacto != null ? idMedioContacto.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof MedioContacto)) {
            return false;
        }
        MedioContacto other = (MedioContacto) object;
        if ((this.idMedioContacto == null && other.idMedioContacto != null) || (this.idMedioContacto != null && !this.idMedioContacto.equals(other.idMedioContacto))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "sv.proundmega.clinica.entities.MedioContacto[ idMedioContacto=" + idMedioContacto + " ]";
    }

}
