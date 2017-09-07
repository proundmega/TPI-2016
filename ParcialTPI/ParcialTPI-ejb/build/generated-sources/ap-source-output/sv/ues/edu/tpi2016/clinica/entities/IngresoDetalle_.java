package sv.ues.edu.tpi2016.clinica.entities;

import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;
import sv.ues.edu.tpi2016.clinica.entities.AsignacionPersonalCentroAreaEspacio;
import sv.ues.edu.tpi2016.clinica.entities.Ingreso;
import sv.ues.edu.tpi2016.clinica.entities.IngresoDetalleDiagnostico;
import sv.ues.edu.tpi2016.clinica.entities.IngresoDetalleExamen;
import sv.ues.edu.tpi2016.clinica.entities.IngresoDetallePK;

@Generated(value="EclipseLink-2.6.1.v20151021-rNA", date="2016-04-04T15:23:57")
@StaticMetamodel(IngresoDetalle.class)
public class IngresoDetalle_ { 

    public static volatile SingularAttribute<IngresoDetalle, AsignacionPersonalCentroAreaEspacio> asignacionPersonalCentroAreaEspacio;
    public static volatile ListAttribute<IngresoDetalle, IngresoDetalleDiagnostico> ingresoDetalleDiagnosticoList;
    public static volatile SingularAttribute<IngresoDetalle, Date> fechaDetalle;
    public static volatile SingularAttribute<IngresoDetalle, Ingreso> ingreso;
    public static volatile ListAttribute<IngresoDetalle, IngresoDetalleExamen> ingresoDetalleExamenList;
    public static volatile SingularAttribute<IngresoDetalle, String> observaciones;
    public static volatile SingularAttribute<IngresoDetalle, Date> horaDetalle;
    public static volatile SingularAttribute<IngresoDetalle, IngresoDetallePK> ingresoDetallePK;

}