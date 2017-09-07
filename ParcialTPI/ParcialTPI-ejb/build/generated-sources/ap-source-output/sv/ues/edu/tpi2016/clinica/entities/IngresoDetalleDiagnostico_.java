package sv.ues.edu.tpi2016.clinica.entities;

import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;
import sv.ues.edu.tpi2016.clinica.entities.Diagnostico;
import sv.ues.edu.tpi2016.clinica.entities.IngresoDetalle;

@Generated(value="EclipseLink-2.6.1.v20151021-rNA", date="2016-04-04T15:23:57")
@StaticMetamodel(IngresoDetalleDiagnostico.class)
public class IngresoDetalleDiagnostico_ { 

    public static volatile SingularAttribute<IngresoDetalleDiagnostico, Date> fechaConfirmacion;
    public static volatile SingularAttribute<IngresoDetalleDiagnostico, IngresoDetalle> ingresoDetalle;
    public static volatile SingularAttribute<IngresoDetalleDiagnostico, Diagnostico> idDiagnostico;
    public static volatile SingularAttribute<IngresoDetalleDiagnostico, String> observaciones;
    public static volatile SingularAttribute<IngresoDetalleDiagnostico, Long> idIngresoDetalleDiagnostico;
    public static volatile SingularAttribute<IngresoDetalleDiagnostico, Date> fechaDiagnostico;
    public static volatile SingularAttribute<IngresoDetalleDiagnostico, String> argumento;

}