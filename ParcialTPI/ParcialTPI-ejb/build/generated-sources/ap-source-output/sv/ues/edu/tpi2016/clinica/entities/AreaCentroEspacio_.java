package sv.ues.edu.tpi2016.clinica.entities;

import java.math.BigInteger;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;
import sv.ues.edu.tpi2016.clinica.entities.AreaCentro;
import sv.ues.edu.tpi2016.clinica.entities.Espacio;

@Generated(value="EclipseLink-2.6.1.v20151021-rNA", date="2016-04-04T15:23:57")
@StaticMetamodel(AreaCentroEspacio.class)
public class AreaCentroEspacio_ { 

    public static volatile SingularAttribute<AreaCentroEspacio, AreaCentro> idAreaCentro;
    public static volatile SingularAttribute<AreaCentroEspacio, BigInteger> idAreaCentroEspacioPadre;
    public static volatile SingularAttribute<AreaCentroEspacio, Espacio> idEspacio;
    public static volatile SingularAttribute<AreaCentroEspacio, Long> idAreaCentroEspacio;
    public static volatile SingularAttribute<AreaCentroEspacio, String> nombre;
    public static volatile SingularAttribute<AreaCentroEspacio, Boolean> activo;

}