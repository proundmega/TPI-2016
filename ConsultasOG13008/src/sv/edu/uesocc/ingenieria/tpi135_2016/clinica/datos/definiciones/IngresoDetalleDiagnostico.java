/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package sv.edu.uesocc.ingenieria.tpi135_2016.clinica.datos.definiciones;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinColumns;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author sakshi
 */
@Entity
@Table(name = "ingreso_detalle_diagnostico", catalog = "clinica", schema = "public")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "IngresoDetalleDiagnostico.findAll", query = "SELECT i FROM IngresoDetalleDiagnostico i"),
    @NamedQuery(name = "IngresoDetalleDiagnostico.findByIdIngresoDetalleDiagnostico", query = "SELECT i FROM IngresoDetalleDiagnostico i WHERE i.idIngresoDetalleDiagnostico = :idIngresoDetalleDiagnostico"),
    @NamedQuery(name = "IngresoDetalleDiagnostico.findByFechaDiagnostico", query = "SELECT i FROM IngresoDetalleDiagnostico i WHERE i.fechaDiagnostico = :fechaDiagnostico"),
    @NamedQuery(name = "IngresoDetalleDiagnostico.findByFechaConfirmacion", query = "SELECT i FROM IngresoDetalleDiagnostico i WHERE i.fechaConfirmacion = :fechaConfirmacion"),
    @NamedQuery(name = "IngresoDetalleDiagnostico.findByArgumento", query = "SELECT i FROM IngresoDetalleDiagnostico i WHERE i.argumento = :argumento"),
    @NamedQuery(name = "IngresoDetalleDiagnostico.findByObservaciones", query = "SELECT i FROM IngresoDetalleDiagnostico i WHERE i.observaciones = :observaciones")})
public class IngresoDetalleDiagnostico implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_ingreso_detalle_diagnostico", nullable = false)
    private Long idIngresoDetalleDiagnostico;
    @Column(name = "fecha_diagnostico")
    @Temporal(TemporalType.DATE)
    private Date fechaDiagnostico;
    @Column(name = "fecha_confirmacion")
    @Temporal(TemporalType.DATE)
    private Date fechaConfirmacion;
    @Column(name = "argumento", length = 2147483647)
    private String argumento;
    @Column(name = "observaciones", length = 2147483647)
    private String observaciones;
    @JoinColumn(name = "id_diagnostico", referencedColumnName = "id_diagnostico")
    @ManyToOne
    private Diagnostico idDiagnostico;
    @JoinColumns({
        @JoinColumn(name = "id_ingreso", referencedColumnName = "id_ingreso"),
        @JoinColumn(name = "id_asignacion_personal_centro_area", referencedColumnName = "id_asignacion_personal_centro_area"),
        @JoinColumn(name = "id_area_centro_espacio", referencedColumnName = "id_area_centro_espacio"),
        @JoinColumn(name = "id_turno", referencedColumnName = "id_turno")})
    @ManyToOne
    private IngresoDetalle ingresoDetalle;

    public IngresoDetalleDiagnostico() {
    }

    public IngresoDetalleDiagnostico(Long idIngresoDetalleDiagnostico) {
        this.idIngresoDetalleDiagnostico = idIngresoDetalleDiagnostico;
    }

    public Long getIdIngresoDetalleDiagnostico() {
        return idIngresoDetalleDiagnostico;
    }

    public void setIdIngresoDetalleDiagnostico(Long idIngresoDetalleDiagnostico) {
        this.idIngresoDetalleDiagnostico = idIngresoDetalleDiagnostico;
    }

    public Date getFechaDiagnostico() {
        return fechaDiagnostico;
    }

    public void setFechaDiagnostico(Date fechaDiagnostico) {
        this.fechaDiagnostico = fechaDiagnostico;
    }

    public Date getFechaConfirmacion() {
        return fechaConfirmacion;
    }

    public void setFechaConfirmacion(Date fechaConfirmacion) {
        this.fechaConfirmacion = fechaConfirmacion;
    }

    public String getArgumento() {
        return argumento;
    }

    public void setArgumento(String argumento) {
        this.argumento = argumento;
    }

    public String getObservaciones() {
        return observaciones;
    }

    public void setObservaciones(String observaciones) {
        this.observaciones = observaciones;
    }

    public Diagnostico getIdDiagnostico() {
        return idDiagnostico;
    }

    public void setIdDiagnostico(Diagnostico idDiagnostico) {
        this.idDiagnostico = idDiagnostico;
    }

    public IngresoDetalle getIngresoDetalle() {
        return ingresoDetalle;
    }

    public void setIngresoDetalle(IngresoDetalle ingresoDetalle) {
        this.ingresoDetalle = ingresoDetalle;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idIngresoDetalleDiagnostico != null ? idIngresoDetalleDiagnostico.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof IngresoDetalleDiagnostico)) {
            return false;
        }
        IngresoDetalleDiagnostico other = (IngresoDetalleDiagnostico) object;
        if ((this.idIngresoDetalleDiagnostico == null && other.idIngresoDetalleDiagnostico != null) || (this.idIngresoDetalleDiagnostico != null && !this.idIngresoDetalleDiagnostico.equals(other.idIngresoDetalleDiagnostico))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "sv.proundmega.clinica.entities.IngresoDetalleDiagnostico[ idIngresoDetalleDiagnostico=" + idIngresoDetalleDiagnostico + " ]";
    }

}
