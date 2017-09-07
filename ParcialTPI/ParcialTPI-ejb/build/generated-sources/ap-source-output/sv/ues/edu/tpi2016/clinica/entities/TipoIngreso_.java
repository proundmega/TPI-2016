package sv.ues.edu.tpi2016.clinica.entities;

import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;
import sv.ues.edu.tpi2016.clinica.entities.Ingreso;

@Generated(value="EclipseLink-2.6.1.v20151021-rNA", date="2016-04-04T15:23:57")
@StaticMetamodel(TipoIngreso.class)
public class TipoIngreso_ { 

    public static volatile ListAttribute<TipoIngreso, Ingreso> ingresoList;
    public static volatile SingularAttribute<TipoIngreso, String> observaciones;
    public static volatile SingularAttribute<TipoIngreso, String> nombre;
    public static volatile SingularAttribute<TipoIngreso, Integer> idTipoIngreso;
    public static volatile SingularAttribute<TipoIngreso, Boolean> activo;

}