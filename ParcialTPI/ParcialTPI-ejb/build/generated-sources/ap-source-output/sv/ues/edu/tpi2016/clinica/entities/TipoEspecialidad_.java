package sv.ues.edu.tpi2016.clinica.entities;

import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;
import sv.ues.edu.tpi2016.clinica.entities.Especialidad;

@Generated(value="EclipseLink-2.6.1.v20151021-rNA", date="2016-04-04T15:23:57")
@StaticMetamodel(TipoEspecialidad.class)
public class TipoEspecialidad_ { 

    public static volatile SingularAttribute<TipoEspecialidad, String> observaciones;
    public static volatile SingularAttribute<TipoEspecialidad, String> nombre;
    public static volatile SingularAttribute<TipoEspecialidad, Integer> idTipoEspecialidad;
    public static volatile SingularAttribute<TipoEspecialidad, Boolean> activo;
    public static volatile ListAttribute<TipoEspecialidad, Especialidad> especialidadList;

}