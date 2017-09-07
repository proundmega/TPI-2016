package sv.ues.edu.tpi2016.clinica.entities;

import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;
import sv.ues.edu.tpi2016.clinica.entities.Especialidad;
import sv.ues.edu.tpi2016.clinica.entities.Personal;
import sv.ues.edu.tpi2016.clinica.entities.PersonalEspecialidadPK;

@Generated(value="EclipseLink-2.6.1.v20151021-rNA", date="2016-04-04T15:23:57")
@StaticMetamodel(PersonalEspecialidad.class)
public class PersonalEspecialidad_ { 

    public static volatile SingularAttribute<PersonalEspecialidad, Boolean> principal;
    public static volatile SingularAttribute<PersonalEspecialidad, Date> fechaDesde;
    public static volatile SingularAttribute<PersonalEspecialidad, PersonalEspecialidadPK> personalEspecialidadPK;
    public static volatile SingularAttribute<PersonalEspecialidad, Personal> personal;
    public static volatile SingularAttribute<PersonalEspecialidad, Especialidad> especialidad;

}