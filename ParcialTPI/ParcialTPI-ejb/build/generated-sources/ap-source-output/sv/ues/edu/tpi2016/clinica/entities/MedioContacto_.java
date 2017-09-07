package sv.ues.edu.tpi2016.clinica.entities;

import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;
import sv.ues.edu.tpi2016.clinica.entities.PacienteMedioContacto;
import sv.ues.edu.tpi2016.clinica.entities.TipoMedioContacto;

@Generated(value="EclipseLink-2.6.1.v20151021-rNA", date="2016-04-04T15:23:57")
@StaticMetamodel(MedioContacto.class)
public class MedioContacto_ { 

    public static volatile SingularAttribute<MedioContacto, TipoMedioContacto> idTipoMedioContacto;
    public static volatile ListAttribute<MedioContacto, PacienteMedioContacto> pacienteMedioContactoList;
    public static volatile SingularAttribute<MedioContacto, String> nombre;
    public static volatile SingularAttribute<MedioContacto, Integer> idMedioContacto;

}