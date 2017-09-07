package sv.ues.edu.tpi2016.clinica.entities;

import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;
import sv.ues.edu.tpi2016.clinica.entities.MedioContacto;
import sv.ues.edu.tpi2016.clinica.entities.Paciente;
import sv.ues.edu.tpi2016.clinica.entities.PacienteMedioContactoPK;

@Generated(value="EclipseLink-2.6.1.v20151021-rNA", date="2016-04-04T15:23:57")
@StaticMetamodel(PacienteMedioContacto.class)
public class PacienteMedioContacto_ { 

    public static volatile SingularAttribute<PacienteMedioContacto, Paciente> paciente;
    public static volatile SingularAttribute<PacienteMedioContacto, String> observaciones;
    public static volatile SingularAttribute<PacienteMedioContacto, MedioContacto> medioContacto;
    public static volatile SingularAttribute<PacienteMedioContacto, PacienteMedioContactoPK> pacienteMedioContactoPK;
    public static volatile SingularAttribute<PacienteMedioContacto, String> medio;

}