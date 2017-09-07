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
@Table(name = "diagnostico", catalog = "clinica", schema = "public")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Diagnostico.findAll", query = "SELECT d FROM Diagnostico d"),
    @NamedQuery(name = "Diagnostico.findByIdDiagnostico", query = "SELECT d FROM Diagnostico d WHERE d.idDiagnostico = :idDiagnostico"),
    @NamedQuery(name = "Diagnostico.findByNombre", query = "SELECT d FROM Diagnostico d WHERE d.nombre = :nombre"),
    @NamedQuery(name = "Diagnostico.findByActivo", query = "SELECT d FROM Diagnostico d WHERE d.activo = :activo"),
    @NamedQuery(name = "Diagnostico.findByObservaciones", query = "SELECT d FROM Diagnostico d WHERE d.observaciones = :observaciones")})
public class Diagnostico implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_diagnostico", nullable = false)
    private Long idDiagnostico;
    @Column(name = "nombre", length = 255)
    private String nombre;
    @Column(name = "activo")
    private Boolean activo;
    @Column(name = "observaciones", length = 2147483647)
    private String observaciones;
    @OneToMany(mappedBy = "idDiagnostico")
    private List<IngresoDetalleDiagnostico> ingresoDetalleDiagnosticoList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "diagnostico")
    private List<DiagnosticoExamen> diagnosticoExamenList;

    public Diagnostico() {
    }

    public Diagnostico(Long idDiagnostico) {
        this.idDiagnostico = idDiagnostico;
    }

    public Long getIdDiagnostico() {
        return idDiagnostico;
    }

    public void setIdDiagnostico(Long idDiagnostico) {
        this.idDiagnostico = idDiagnostico;
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
    public List<IngresoDetalleDiagnostico> getIngresoDetalleDiagnosticoList() {
        return ingresoDetalleDiagnosticoList;
    }

    public void setIngresoDetalleDiagnosticoList(List<IngresoDetalleDiagnostico> ingresoDetalleDiagnosticoList) {
        this.ingresoDetalleDiagnosticoList = ingresoDetalleDiagnosticoList;
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
        hash += (idDiagnostico != null ? idDiagnostico.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Diagnostico)) {
            return false;
        }
        Diagnostico other = (Diagnostico) object;
        if ((this.idDiagnostico == null && other.idDiagnostico != null) || (this.idDiagnostico != null && !this.idDiagnostico.equals(other.idDiagnostico))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "sv.proundmega.clinica.entities.Diagnostico[ idDiagnostico=" + idDiagnostico + " ]";
    }

}
