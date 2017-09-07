package sv.ues.edu.tpi2016.clinica.entities;

import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;
import sv.ues.edu.tpi2016.clinica.entities.AsignacionPersonalCentroArea;
import sv.ues.edu.tpi2016.clinica.entities.PersonalEspecialidad;

@Generated(value="EclipseLink-2.6.1.v20151021-rNA", date="2016-04-04T15:23:57")
@StaticMetamodel(Personal.class)
public class Personal_ { 

    public static volatile SingularAttribute<Personal, String> apellidos;
    public static volatile SingularAttribute<Personal, Date> fechaIngreso;
    public static volatile SingularAttribute<Personal, Long> idPersonal;
    public static volatile ListAttribute<Personal, AsignacionPersonalCentroArea> asignacionPersonalCentroAreaList;
    public static volatile SingularAttribute<Personal, String> dui;
    public static volatile ListAttribute<Personal, PersonalEspecialidad> personalEspecialidadList;
    public static volatile SingularAttribute<Personal, String> nombres;

}