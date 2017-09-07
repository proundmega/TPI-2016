package sv.ues.edu.tpi2016.clinica.entities;

import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;
import sv.ues.edu.tpi2016.clinica.entities.DiagnosticoExamen;
import sv.ues.edu.tpi2016.clinica.entities.IngresoDetalleExamen;
import sv.ues.edu.tpi2016.clinica.entities.TipoExamen;

@Generated(value="EclipseLink-2.6.1.v20151021-rNA", date="2016-04-04T15:23:57")
@StaticMetamodel(Examen.class)
public class Examen_ { 

    public static volatile SingularAttribute<Examen, String> descripcion;
    public static volatile SingularAttribute<Examen, Long> idExamen;
    public static volatile ListAttribute<Examen, DiagnosticoExamen> diagnosticoExamenList;
    public static volatile ListAttribute<Examen, IngresoDetalleExamen> ingresoDetalleExamenList;
    public static volatile SingularAttribute<Examen, String> observaciones;
    public static volatile SingularAttribute<Examen, TipoExamen> idTipoExamen;
    public static volatile SingularAttribute<Examen, String> nombre;
    public static volatile SingularAttribute<Examen, Boolean> activo;

}