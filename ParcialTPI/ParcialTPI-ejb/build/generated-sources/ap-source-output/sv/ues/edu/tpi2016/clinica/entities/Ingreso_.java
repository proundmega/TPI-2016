package sv.ues.edu.tpi2016.clinica.entities;

import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;
import sv.ues.edu.tpi2016.clinica.entities.IngresoDetalle;
import sv.ues.edu.tpi2016.clinica.entities.Paciente;
import sv.ues.edu.tpi2016.clinica.entities.TipoIngreso;

@Generated(value="EclipseLink-2.6.1.v20151021-rNA", date="2016-04-04T15:23:57")
@StaticMetamodel(Ingreso.class)
public class Ingreso_ { 

    public static volatile SingularAttribute<Ingreso, Paciente> idPaciente;
    public static volatile SingularAttribute<Ingreso, Date> fechaIngreso;
    public static volatile SingularAttribute<Ingreso, Date> horaIngreso;
    public static volatile SingularAttribute<Ingreso, Date> horaEgreso;
    public static volatile SingularAttribute<Ingreso, Long> idIngreso;
    public static volatile SingularAttribute<Ingreso, String> observaciones;
    public static volatile SingularAttribute<Ingreso, Date> fechaEgreso;
    public static volatile ListAttribute<Ingreso, IngresoDetalle> ingresoDetalleList;
    public static volatile SingularAttribute<Ingreso, TipoIngreso> idTipoIngreso;

}