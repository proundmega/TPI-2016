package sv.ues.edu.tpi2016.clinica.entities;

import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;
import sv.ues.edu.tpi2016.clinica.entities.Examen;
import sv.ues.edu.tpi2016.clinica.entities.IngresoDetalle;

@Generated(value="EclipseLink-2.6.1.v20151021-rNA", date="2016-04-04T15:23:57")
@StaticMetamodel(IngresoDetalleExamen.class)
public class IngresoDetalleExamen_ { 

    public static volatile SingularAttribute<IngresoDetalleExamen, Date> horaRealizacion;
    public static volatile SingularAttribute<IngresoDetalleExamen, Examen> idExamen;
    public static volatile SingularAttribute<IngresoDetalleExamen, Date> fechaRealizacion;
    public static volatile SingularAttribute<IngresoDetalleExamen, IngresoDetalle> ingresoDetalle;
    public static volatile SingularAttribute<IngresoDetalleExamen, Date> fechaOrden;
    public static volatile SingularAttribute<IngresoDetalleExamen, Long> idIngresoDetalleExamen;

}