package sv.ues.edu.tpi2016.clinica.entities;

import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;
import sv.ues.edu.tpi2016.clinica.entities.AreaCentro;

@Generated(value="EclipseLink-2.6.1.v20151021-rNA", date="2016-04-04T15:23:57")
@StaticMetamodel(Area.class)
public class Area_ { 

    public static volatile SingularAttribute<Area, Integer> idArea;
    public static volatile ListAttribute<Area, AreaCentro> areaCentroList;
    public static volatile SingularAttribute<Area, String> observaciones;
    public static volatile SingularAttribute<Area, String> nombre;
    public static volatile SingularAttribute<Area, Boolean> activo;

}