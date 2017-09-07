package sv.ues.edu.tpi2016.clinica.entities;

import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;
import sv.ues.edu.tpi2016.clinica.entities.MedioContacto;

@Generated(value="EclipseLink-2.6.1.v20151021-rNA", date="2016-04-04T15:23:57")
@StaticMetamodel(TipoMedioContacto.class)
public class TipoMedioContacto_ { 

    public static volatile SingularAttribute<TipoMedioContacto, Integer> idTipoMedioContacto;
    public static volatile SingularAttribute<TipoMedioContacto, String> expresionRegular;
    public static volatile ListAttribute<TipoMedioContacto, MedioContacto> medioContactoList;
    public static volatile SingularAttribute<TipoMedioContacto, String> nombre;

}