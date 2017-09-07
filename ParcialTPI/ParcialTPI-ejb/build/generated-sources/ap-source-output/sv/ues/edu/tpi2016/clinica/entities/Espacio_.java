package sv.ues.edu.tpi2016.clinica.entities;

import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;
import sv.ues.edu.tpi2016.clinica.entities.AreaCentroEspacio;
import sv.ues.edu.tpi2016.clinica.entities.TipoEspacio;

@Generated(value="EclipseLink-2.6.1.v20151021-rNA", date="2016-04-04T15:23:57")
@StaticMetamodel(Espacio.class)
public class Espacio_ { 

    public static volatile SingularAttribute<Espacio, Integer> idEspacio;
    public static volatile SingularAttribute<Espacio, String> observaciones;
    public static volatile SingularAttribute<Espacio, TipoEspacio> idTipoEspacio;
    public static volatile SingularAttribute<Espacio, String> nombre;
    public static volatile ListAttribute<Espacio, AreaCentroEspacio> areaCentroEspacioList;
    public static volatile SingularAttribute<Espacio, Boolean> activo;

}