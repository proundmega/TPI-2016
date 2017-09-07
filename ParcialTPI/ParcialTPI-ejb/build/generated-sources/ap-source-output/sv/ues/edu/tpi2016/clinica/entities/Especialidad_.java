package sv.ues.edu.tpi2016.clinica.entities;

import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;
import sv.ues.edu.tpi2016.clinica.entities.PersonalEspecialidad;
import sv.ues.edu.tpi2016.clinica.entities.TipoEspecialidad;

@Generated(value="EclipseLink-2.6.1.v20151021-rNA", date="2016-04-04T15:23:57")
@StaticMetamodel(Especialidad.class)
public class Especialidad_ { 

    public static volatile SingularAttribute<Especialidad, String> observaciones;
    public static volatile ListAttribute<Especialidad, PersonalEspecialidad> personalEspecialidadList;
    public static volatile SingularAttribute<Especialidad, Integer> idEspecialidad;
    public static volatile SingularAttribute<Especialidad, String> nombre;
    public static volatile SingularAttribute<Especialidad, Boolean> activo;
    public static volatile SingularAttribute<Especialidad, TipoEspecialidad> idTipoEspecialidad;

}