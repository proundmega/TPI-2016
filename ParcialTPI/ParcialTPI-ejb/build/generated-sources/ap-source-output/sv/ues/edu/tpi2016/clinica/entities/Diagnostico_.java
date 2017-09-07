package sv.ues.edu.tpi2016.clinica.entities;

import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;
import sv.ues.edu.tpi2016.clinica.entities.DiagnosticoExamen;
import sv.ues.edu.tpi2016.clinica.entities.IngresoDetalleDiagnostico;

@Generated(value="EclipseLink-2.6.1.v20151021-rNA", date="2016-04-04T15:23:57")
@StaticMetamodel(Diagnostico.class)
public class Diagnostico_ { 

    public static volatile ListAttribute<Diagnostico, IngresoDetalleDiagnostico> ingresoDetalleDiagnosticoList;
    public static volatile ListAttribute<Diagnostico, DiagnosticoExamen> diagnosticoExamenList;
    public static volatile SingularAttribute<Diagnostico, Long> idDiagnostico;
    public static volatile SingularAttribute<Diagnostico, String> observaciones;
    public static volatile SingularAttribute<Diagnostico, String> nombre;
    public static volatile SingularAttribute<Diagnostico, Boolean> activo;

}