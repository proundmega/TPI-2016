/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sv.ues.edu.tpi2016.clinica.entities;

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
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author VAIO
 */
@Entity
@Table(name = "ingreso_detalle")
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
    @Size(max = 2147483647)
    @Column(name = "observaciones")
    private String observaciones;
    @JoinColumn(name = "id_ingreso", referencedColumnName = "id_ingreso", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Ingreso ingreso;
    @JoinColumns({
        @JoinColumn(name = "id_asignacion_personal_centro_area", referencedColumnName = "id_asignacion_personal_centro_area", insertable = false, updatable = false),
        @JoinColumn(name = "id_area_centro_espacio", referencedColumnName = "id_area_centro_espacio", insertable = false, updatable = false),
        @JoinColumn(name = "id_turno", referencedColumnName = "id_turno", insertable = false, updatable = false)})
    @ManyToOne(optional = false)
    private AsignacionPersonalCentroAreaEspacio asignacionPersonalCentroAreaEspacio;
    @OneToMany(mappedBy = "ingresoDetalle")
    private List<IngresoDetalleDiagnostico> ingresoDetalleDiagnosticoList;
    @OneToMany(mappedBy = "ingresoDetalle")
    private List<IngresoDetalleExamen> ingresoDetalleExamenList;

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

    public Ingreso getIngreso() {
        return ingreso;
    }

    public void setIngreso(Ingreso ingreso) {
        this.ingreso = ingreso;
    }

    public AsignacionPersonalCentroAreaEspacio getAsignacionPersonalCentroAreaEspacio() {
        return asignacionPersonalCentroAreaEspacio;
    }

    public void setAsignacionPersonalCentroAreaEspacio(AsignacionPersonalCentroAreaEspacio asignacionPersonalCentroAreaEspacio) {
        this.asignacionPersonalCentroAreaEspacio = asignacionPersonalCentroAreaEspacio;
    }

    @XmlTransient
    public List<IngresoDetalleDiagnostico> getIngresoDetalleDiagnosticoList() {
        return ingresoDetalleDiagnosticoList;
    }

    public void setIngresoDetalleDiagnosticoList(List<IngresoDetalleDiagnostico> ingresoDetalleDiagnosticoList) {
        this.ingresoDetalleDiagnosticoList = ingresoDetalleDiagnosticoList;
    }

    @XmlTransient
    public List<IngresoDetalleExamen> getIngresoDetalleExamenList() {
        return ingresoDetalleExamenList;
    }

    public void setIngresoDetalleExamenList(List<IngresoDetalleExamen> ingresoDetalleExamenList) {
        this.ingresoDetalleExamenList = ingresoDetalleExamenList;
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
        return "www.ues.edu.sv.local.entities.IngresoDetalle[ ingresoDetallePK=" + ingresoDetallePK + " ]";
    }
    
}
