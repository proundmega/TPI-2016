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
@Table(name = "examen", catalog = "clinica", schema = "public")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Examen.findAll", query = "SELECT e FROM Examen e"),
    @NamedQuery(name = "Examen.findByIdExamen", query = "SELECT e FROM Examen e WHERE e.idExamen = :idExamen"),
    @NamedQuery(name = "Examen.findByNombre", query = "SELECT e FROM Examen e WHERE e.nombre = :nombre"),
    @NamedQuery(name = "Examen.findByActivo", query = "SELECT e FROM Examen e WHERE e.activo = :activo"),
    @NamedQuery(name = "Examen.findByDescripcion", query = "SELECT e FROM Examen e WHERE e.descripcion = :descripcion"),
    @NamedQuery(name = "Examen.findByObservaciones", query = "SELECT e FROM Examen e WHERE e.observaciones = :observaciones")})
public class Examen implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "id_examen", nullable = false)
    private Long idExamen;
    @Column(name = "nombre", length = 255, nullable = false)
    private String nombre;
    @Column(name = "activo")
    private Boolean activo;
    @Column(name = "descripcion", length = 2147483647)
    private String descripcion;
    @Column(name = "observaciones", length = 2147483647)
    private String observaciones;
    @OneToMany(mappedBy = "idExamen")
    private List<IngresoDetalleExamen> ingresoDetalleExamenList;
    @JoinColumn(name = "id_tipo_examen", referencedColumnName = "id_tipo_examen")
    @ManyToOne
    private TipoExamen idTipoExamen;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "examen")
    private List<DiagnosticoExamen> diagnosticoExamenList;

    public Examen() {
    }

    public Examen(Long idExamen) {
        this.idExamen = idExamen;
    }

    public Long getIdExamen() {
        return idExamen;
    }

    public void setIdExamen(Long idExamen) {
        this.idExamen = idExamen;
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

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getObservaciones() {
        return observaciones;
    }

    public void setObservaciones(String observaciones) {
        this.observaciones = observaciones;
    }

    @XmlTransient
    public List<IngresoDetalleExamen> getIngresoDetalleExamenList() {
        return ingresoDetalleExamenList;
    }

    public void setIngresoDetalleExamenList(List<IngresoDetalleExamen> ingresoDetalleExamenList) {
        this.ingresoDetalleExamenList = ingresoDetalleExamenList;
    }

    public TipoExamen getIdTipoExamen() {
        return idTipoExamen;
    }

    public void setIdTipoExamen(TipoExamen idTipoExamen) {
        this.idTipoExamen = idTipoExamen;
    }

    @XmlTransient
    public List<DiagnosticoExamen> getDiagnosticoExamenList() {
        return diagnosticoExamenList;
    }

    public void setDiagnosticoExamenList(List<DiagnosticoExamen> diagnosticoExamenList) {
        this.diagnosticoExamenList = diagnosticoExamenList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idExamen != null ? idExamen.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Examen)) {
            return false;
        }
        Examen other = (Examen) object;
        if ((this.idExamen == null && other.idExamen != null) || (this.idExamen != null && !this.idExamen.equals(other.idExamen))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "sv.proundmega.clinica.entities.Examen[ idExamen=" + idExamen + " ]";
    }

}
