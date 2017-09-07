/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sv.ues.edu.tpi2016.clinica.entities;

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
 * @author VAIO
 */
@Entity
@Table(name = "ingreso_detalle_examen")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "IngresoDetalleExamen.findAll", query = "SELECT i FROM IngresoDetalleExamen i"),
    @NamedQuery(name = "IngresoDetalleExamen.findByFechaRealizacion", query = "SELECT i FROM IngresoDetalleExamen i WHERE i.fechaRealizacion = :fechaRealizacion"),
    @NamedQuery(name = "IngresoDetalleExamen.findByFechaOrden", query = "SELECT i FROM IngresoDetalleExamen i WHERE i.fechaOrden = :fechaOrden"),
    @NamedQuery(name = "IngresoDetalleExamen.findByHoraRealizacion", query = "SELECT i FROM IngresoDetalleExamen i WHERE i.horaRealizacion = :horaRealizacion"),
    @NamedQuery(name = "IngresoDetalleExamen.findByIdIngresoDetalleExamen", query = "SELECT i FROM IngresoDetalleExamen i WHERE i.idIngresoDetalleExamen = :idIngresoDetalleExamen")})
public class IngresoDetalleExamen implements Serializable {

    private static final long serialVersionUID = 1L;
    @Column(name = "fecha_realizacion")
    @Temporal(TemporalType.DATE)
    private Date fechaRealizacion;
    @Column(name = "fecha_orden")
    @Temporal(TemporalType.DATE)
    private Date fechaOrden;
    @Column(name = "hora_realizacion")
    @Temporal(TemporalType.TIME)
    private Date horaRealizacion;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_ingreso_detalle_examen")
    private Long idIngresoDetalleExamen;
    @JoinColumns({
        @JoinColumn(name = "id_ingreso", referencedColumnName = "id_ingreso"),
        @JoinColumn(name = "id_asignacion_personal_centro_area", referencedColumnName = "id_asignacion_personal_centro_area"),
        @JoinColumn(name = "id_area_centro_espacio", referencedColumnName = "id_area_centro_espacio"),
        @JoinColumn(name = "id_turno", referencedColumnName = "id_turno")})
    @ManyToOne
    private IngresoDetalle ingresoDetalle;
    @JoinColumn(name = "id_examen", referencedColumnName = "id_examen")
    @ManyToOne
    private Examen idExamen;

    public IngresoDetalleExamen() {
    }

    public IngresoDetalleExamen(Long idIngresoDetalleExamen) {
        this.idIngresoDetalleExamen = idIngresoDetalleExamen;
    }

    public Date getFechaRealizacion() {
        return fechaRealizacion;
    }

    public void setFechaRealizacion(Date fechaRealizacion) {
        this.fechaRealizacion = fechaRealizacion;
    }

    public Date getFechaOrden() {
        return fechaOrden;
    }

    public void setFechaOrden(Date fechaOrden) {
        this.fechaOrden = fechaOrden;
    }

    public Date getHoraRealizacion() {
        return horaRealizacion;
    }

    public void setHoraRealizacion(Date horaRealizacion) {
        this.horaRealizacion = horaRealizacion;
    }

    public Long getIdIngresoDetalleExamen() {
        return idIngresoDetalleExamen;
    }

    public void setIdIngresoDetalleExamen(Long idIngresoDetalleExamen) {
        this.idIngresoDetalleExamen = idIngresoDetalleExamen;
    }

    public IngresoDetalle getIngresoDetalle() {
        return ingresoDetalle;
    }

    public void setIngresoDetalle(IngresoDetalle ingresoDetalle) {
        this.ingresoDetalle = ingresoDetalle;
    }

    public Examen getIdExamen() {
        return idExamen;
    }

    public void setIdExamen(Examen idExamen) {
        this.idExamen = idExamen;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idIngresoDetalleExamen != null ? idIngresoDetalleExamen.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof IngresoDetalleExamen)) {
            return false;
        }
        IngresoDetalleExamen other = (IngresoDetalleExamen) object;
        if ((this.idIngresoDetalleExamen == null && other.idIngresoDetalleExamen != null) || (this.idIngresoDetalleExamen != null && !this.idIngresoDetalleExamen.equals(other.idIngresoDetalleExamen))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "www.ues.edu.sv.local.entities.IngresoDetalleExamen[ idIngresoDetalleExamen=" + idIngresoDetalleExamen + " ]";
    }
    
}
