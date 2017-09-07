package sv.ues.edu.tpi2016.clinica.entities;

import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;
import sv.ues.edu.tpi2016.clinica.entities.Espacio;

@Generated(value="EclipseLink-2.6.1.v20151021-rNA", date="2016-04-04T15:23:57")
@StaticMetamodel(TipoEspacio.class)
public class TipoEspacio_ { 

    public static volatile SingularAttribute<TipoEspacio, String> observaciones;
    public static volatile SingularAttribute<TipoEspacio, Integer> idTipoEspacio;
    public static volatile ListAttribute<TipoEspacio, Espacio> espacioList;
    public static volatile SingularAttribute<TipoEspacio, String> nombre;
    public static volatile SingularAttribute<TipoEspacio, Boolean> activo;

}