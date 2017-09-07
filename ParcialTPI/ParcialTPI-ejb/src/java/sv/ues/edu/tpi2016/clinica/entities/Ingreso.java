/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sv.ues.edu.tpi2016.clinica.entities;

import java.io.Serializable;
import java.util.Date;
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
@Table(name = "ingreso")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Ingreso.findAll", query = "SELECT i FROM Ingreso i"),
    @NamedQuery(name = "Ingreso.findByIdIngreso", query = "SELECT i FROM Ingreso i WHERE i.idIngreso = :idIngreso"),
    @NamedQuery(name = "Ingreso.findByFechaIngreso", query = "SELECT i FROM Ingreso i WHERE i.fechaIngreso = :fechaIngreso"),
    @NamedQuery(name = "Ingreso.findByHoraIngreso", query = "SELECT i FROM Ingreso i WHERE i.horaIngreso = :horaIngreso"),
    @NamedQuery(name = "Ingreso.findByFechaEgreso", query = "SELECT i FROM Ingreso i WHERE i.fechaEgreso = :fechaEgreso"),
    @NamedQuery(name = "Ingreso.findByHoraEgreso", query = "SELECT i FROM Ingreso i WHERE i.horaEgreso = :horaEgreso"),
    @NamedQuery(name = "Ingreso.findByObservaciones", query = "SELECT i FROM Ingreso i WHERE i.observaciones = :observaciones")})
public class Ingreso implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_ingreso")
    private Long idIngreso;
    @Column(name = "fecha_ingreso")
    @Temporal(TemporalType.DATE)
    private Date fechaIngreso;
    @Column(name = "hora_ingreso")
    @Temporal(TemporalType.TIME)
    private Date horaIngreso;
    @Column(name = "fecha_egreso")
    @Temporal(TemporalType.DATE)
    private Date fechaEgreso;
    @Column(name = "hora_egreso")
    @Temporal(TemporalType.TIME)
    private Date horaEgreso;
    @Size(max = 2147483647)
    @Column(name = "observaciones")
    private String observaciones;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "ingreso")
    private List<IngresoDetalle> ingresoDetalleList;
    @JoinColumn(name = "id_tipo_ingreso", referencedColumnName = "id_tipo_ingreso")
    @ManyToOne
    private TipoIngreso idTipoIngreso;
    @JoinColumn(name = "id_paciente", referencedColumnName = "id_paciente")
    @ManyToOne
    private Paciente idPaciente;

    public Ingreso() {
    }

    public Ingreso(Long idIngreso) {
        this.idIngreso = idIngreso;
    }

    public Long getIdIngreso() {
        return idIngreso;
    }

    public void setIdIngreso(Long idIngreso) {
        this.idIngreso = idIngreso;
    }

    public Date getFechaIngreso() {
        return fechaIngreso;
    }

    public void setFechaIngreso(Date fechaIngreso) {
        this.fechaIngreso = fechaIngreso;
    }

    public Date getHoraIngreso() {
        return horaIngreso;
    }

    public void setHoraIngreso(Date horaIngreso) {
        this.horaIngreso = horaIngreso;
    }

    public Date getFechaEgreso() {
        return fechaEgreso;
    }

    public void setFechaEgreso(Date fechaEgreso) {
        this.fechaEgreso = fechaEgreso;
    }

    public Date getHoraEgreso() {
        return horaEgreso;
    }

    public void setHoraEgreso(Date horaEgreso) {
        this.horaEgreso = horaEgreso;
    }

    public String getObservaciones() {
        return observaciones;
    }

    public void setObservaciones(String observaciones) {
        this.observaciones = observaciones;
    }

    @XmlTransient
    public List<IngresoDetalle> getIngresoDetalleList() {
        return ingresoDetalleList;
    }

    public void setIngresoDetalleList(List<IngresoDetalle> ingresoDetalleList) {
        this.ingresoDetalleList = ingresoDetalleList;
    }

    public TipoIngreso getIdTipoIngreso() {
        return idTipoIngreso;
    }

    public void setIdTipoIngreso(TipoIngreso idTipoIngreso) {
        this.idTipoIngreso = idTipoIngreso;
    }

    public Paciente getIdPaciente() {
        return idPaciente;
    }

    public void setIdPaciente(Paciente idPaciente) {
        this.idPaciente = idPaciente;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idIngreso != null ? idIngreso.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Ingreso)) {
            return false;
        }
        Ingreso other = (Ingreso) object;
        if ((this.idIngreso == null && other.idIngreso != null) || (this.idIngreso != null && !this.idIngreso.equals(other.idIngreso))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "www.ues.edu.sv.local.entities.Ingreso[ idIngreso=" + idIngreso + " ]";
    }
    
}
