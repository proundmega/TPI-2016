package sv.ues.edu.tpi2016.clinica.entities;

import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;
import sv.ues.edu.tpi2016.clinica.entities.Ingreso;
import sv.ues.edu.tpi2016.clinica.entities.PacienteMedioContacto;

@Generated(value="EclipseLink-2.6.1.v20151021-rNA", date="2016-04-04T15:23:57")
@StaticMetamodel(Paciente.class)
public class Paciente_ { 

    public static volatile SingularAttribute<Paciente, Long> idPaciente;
    public static volatile SingularAttribute<Paciente, String> apellidos;
    public static volatile ListAttribute<Paciente, Ingreso> ingresoList;
    public static volatile ListAttribute<Paciente, PacienteMedioContacto> pacienteMedioContactoList;
    public static volatile SingularAttribute<Paciente, Date> fechaDefuncion;
    public static volatile SingularAttribute<Paciente, Date> fechaNacimiento;
    public static volatile SingularAttribute<Paciente, String> observaciones;
    public static volatile SingularAttribute<Paciente, String> nombres;

}