package sv.ues.edu.tpi2016.clinica.entities;

import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;
import sv.ues.edu.tpi2016.clinica.entities.AreaCentro;
import sv.ues.edu.tpi2016.clinica.entities.TipoCentro;

@Generated(value="EclipseLink-2.6.1.v20151021-rNA", date="2016-04-04T15:23:57")
@StaticMetamodel(Centro.class)
public class Centro_ { 

    public static volatile SingularAttribute<Centro, Integer> idCentro;
    public static volatile SingularAttribute<Centro, String> latitud;
    public static volatile SingularAttribute<Centro, String> longitud;
    public static volatile SingularAttribute<Centro, Date> fechaInicio;
    public static volatile ListAttribute<Centro, AreaCentro> areaCentroList;
    public static volatile SingularAttribute<Centro, String> observaciones;
    public static volatile SingularAttribute<Centro, TipoCentro> idTipoCentro;
    public static volatile SingularAttribute<Centro, String> nombreOficial;
    public static volatile SingularAttribute<Centro, String> nombreCorto;
    public static volatile SingularAttribute<Centro, Boolean> activo;

}