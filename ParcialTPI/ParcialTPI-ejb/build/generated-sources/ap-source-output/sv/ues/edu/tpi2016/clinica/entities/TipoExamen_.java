package sv.ues.edu.tpi2016.clinica.entities;

import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;
import sv.ues.edu.tpi2016.clinica.entities.Examen;

@Generated(value="EclipseLink-2.6.1.v20151021-rNA", date="2016-04-04T15:23:57")
@StaticMetamodel(TipoExamen.class)
public class TipoExamen_ { 

    public static volatile ListAttribute<TipoExamen, Examen> examenList;
    public static volatile SingularAttribute<TipoExamen, String> observaciones;
    public static volatile SingularAttribute<TipoExamen, Integer> idTipoExamen;
    public static volatile SingularAttribute<TipoExamen, String> nombre;
    public static volatile SingularAttribute<TipoExamen, Boolean> activo;

}