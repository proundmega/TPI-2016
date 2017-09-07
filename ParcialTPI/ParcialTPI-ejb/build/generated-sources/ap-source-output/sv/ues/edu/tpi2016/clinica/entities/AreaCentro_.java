package sv.ues.edu.tpi2016.clinica.entities;

import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;
import sv.ues.edu.tpi2016.clinica.entities.Area;
import sv.ues.edu.tpi2016.clinica.entities.AreaCentroEspacio;
import sv.ues.edu.tpi2016.clinica.entities.AsignacionPersonalCentroArea;
import sv.ues.edu.tpi2016.clinica.entities.Centro;

@Generated(value="EclipseLink-2.6.1.v20151021-rNA", date="2016-04-04T15:23:57")
@StaticMetamodel(AreaCentro.class)
public class AreaCentro_ { 

    public static volatile SingularAttribute<AreaCentro, Long> idAreaCentro;
    public static volatile SingularAttribute<AreaCentro, Centro> idCentro;
    public static volatile SingularAttribute<AreaCentro, Area> idArea;
    public static volatile ListAttribute<AreaCentro, AsignacionPersonalCentroArea> asignacionPersonalCentroAreaList;
    public static volatile SingularAttribute<AreaCentro, String> nombre;
    public static volatile ListAttribute<AreaCentro, AreaCentroEspacio> areaCentroEspacioList;
    public static volatile SingularAttribute<AreaCentro, Boolean> activo;

}