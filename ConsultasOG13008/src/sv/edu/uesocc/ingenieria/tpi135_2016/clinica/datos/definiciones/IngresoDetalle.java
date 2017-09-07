/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package sv.edu.uesocc.ingenieria.tpi135_2016.clinica.datos.definiciones;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.JoinColumns;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author sakshi
 */
@Entity
@Table(name = "ingreso_detalle", catalog = "clinica", schema = "public")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "IngresoDetalle.findAll", query = "SELECT i FROM IngresoDetalle i"),
    @NamedQuery(name = "IngresoDetalle.findByIdIngreso", query = "SELECT i FROM IngresoDetalle i WHERE i.ingresoDetallePK.idIngreso = :idIngreso"),
    @NamedQuery(name = "IngresoDetalle.findByIdAsignacionPersonalCentroArea", query = "SELECT i FROM IngresoDetalle i WHERE i.ingresoDetallePK.idAsignacionPersonalCentroArea = :idAsignacionPersonalCentroArea"),
    @NamedQuery(name = "IngresoDetalle.findByIdAreaCentroEspacio", query = "SELECT i FROM IngresoDetalle i WHERE i.ingresoDetallePK.idAreaCentroEspacio = :idAreaCentroEspacio"),
    @NamedQuery(name = "IngresoDetalle.findByIdTurno", query = "SELECT i FROM IngresoDetalle i WHERE i.ingresoDetallePK.idTurno = :idTurno"),
    @NamedQuery(name = "IngresoDetalle.findByFechaDetalle", query = "SELECT i FROM IngresoDetalle i WHERE i.fechaDetalle = :fechaDetalle"),
    @NamedQuery(name = "IngresoDetalle.findByHoraDetalle", query = "SELECT i FROM IngresoDetalle i WHERE i.horaDetalle = :horaDetalle"),
    @NamedQuery(name = "IngresoDetalle.findByObservaciones", query = "SELECT i FROM IngresoDetalle i WHERE i.observaciones = :observaciones")})
public class IngresoDetalle implements Serializable {
    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected IngresoDetallePK ingresoDetallePK;
    @Column(name = "fecha_detalle")
    @Temporal(TemporalType.DATE)
    private Date fechaDetalle;
    @Column(name = "hora_detalle")
    @Temporal(TemporalType.TIME)
    private Date horaDetalle;
    @Column(name = "observaciones", length = 2147483647)
    private String observaciones;
    @JoinColumns({
        @JoinColumn(name = "id_asignacion_personal_centro_area", referencedColumnName = "id_asignacion_personal_centro_area", nullable = false, insertable = false, updatable = false),
        @JoinColumn(name = "id_area_centro_espacio", referencedColumnName = "id_area_centro_espacio", nullable = false, insertable = false, updatable = false),
        @JoinColumn(name = "id_turno", referencedColumnName = "id_turno", nullable = false, insertable = false, updatable = false)})
    @ManyToOne(optional = false)
    private AsignacionPersonalCentroAreaEspacio asignacionPersonalCentroAreaEspacio;
    @JoinColumn(name = "id_ingreso", referencedColumnName = "id_ingreso", nullable = false, insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Ingreso ingreso;
    @OneToMany(mappedBy = "ingresoDetalle")
    private List<IngresoDetalleExamen> ingresoDetalleExamenList;
    @OneToMany(mappedBy = "ingresoDetalle")
    private List<IngresoDetalleDiagnostico> ingresoDetalleDiagnosticoList;

    public IngresoDetalle() {
    }

    public IngresoDetalle(IngresoDetallePK ingresoDetallePK) {
        this.ingresoDetallePK = ingresoDetallePK;
    }

    public IngresoDetalle(long idIngreso, long idAsignacionPersonalCentroArea, long idAreaCentroEspacio, long idTurno) {
        this.ingresoDetallePK = new IngresoDetallePK(idIngreso, idAsignacionPersonalCentroArea, idAreaCentroEspacio, idTurno);
    }

    public IngresoDetallePK getIngresoDetallePK() {
        return ingresoDetallePK;
    }

    public void setIngresoDetallePK(IngresoDetallePK ingresoDetallePK) {
        this.ingresoDetallePK = ingresoDetallePK;
    }

    public Date getFechaDetalle() {
        return fechaDetalle;
    }

    public void setFechaDetalle(Date fechaDetalle) {
        this.fechaDetalle = fechaDetalle;
    }

    public Date getHoraDetalle() {
        return horaDetalle;
    }

    public void setHoraDetalle(Date horaDetalle) {
        this.horaDetalle = horaDetalle;
    }

    public String getObservaciones() {
        return observaciones;
    }

    public void setObservaciones(String observaciones) {
        this.observaciones = observaciones;
    }

    public AsignacionPersonalCentroAreaEspacio getAsignacionPersonalCentroAreaEspacio() {
        return asignacionPersonalCentroAreaEspacio;
    }

    public void setAsignacionPersonalCentroAreaEspacio(AsignacionPersonalCentroAreaEspacio asignacionPersonalCentroAreaEspacio) {
        this.asignacionPersonalCentroAreaEspacio = asignacionPersonalCentroAreaEspacio;
    }

    public Ingreso getIngreso() {
        return ingreso;
    }

    public void setIngreso(Ingreso ingreso) {
        this.ingreso = ingreso;
    }

    @XmlTransient
    public List<IngresoDetalleExamen> getIngresoDetalleExamenList() {
        return ingresoDetalleExamenList;
    }

    public void setIngresoDetalleExamenList(List<IngresoDetalleExamen> ingresoDetalleExamenList) {
        this.ingresoDetalleExamenList = ingresoDetalleExamenList;
    }

    @XmlTransient
    public List<IngresoDetalleDiagnostico> getIngresoDetalleDiagnosticoList() {
        return ingresoDetalleDiagnosticoList;
    }

    public void setIngresoDetalleDiagnosticoList(List<IngresoDetalleDiagnostico> ingresoDetalleDiagnosticoList) {
        this.ingresoDetalleDiagnosticoList = ingresoDetalleDiagnosticoList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (ingresoDetallePK != null ? ingresoDetallePK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof IngresoDetalle)) {
            return false;
        }
        IngresoDetalle other = (IngresoDetalle) object;
        if ((this.ingresoDetallePK == null && other.ingresoDetallePK != null) || (this.ingresoDetallePK != null && !this.ingresoDetallePK.equals(other.ingresoDetallePK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "sv.proundmega.clinica.entities.IngresoDetalle[ ingresoDetallePK=" + ingresoDetallePK + " ]";
    }

}
