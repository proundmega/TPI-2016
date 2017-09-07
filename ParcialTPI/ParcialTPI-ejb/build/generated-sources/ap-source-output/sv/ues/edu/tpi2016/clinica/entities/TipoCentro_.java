package sv.ues.edu.tpi2016.clinica.entities;

import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;
import sv.ues.edu.tpi2016.clinica.entities.Centro;

@Generated(value="EclipseLink-2.6.1.v20151021-rNA", date="2016-04-04T15:23:57")
@StaticMetamodel(TipoCentro.class)
public class TipoCentro_ { 

    public static volatile ListAttribute<TipoCentro, Centro> centroList;
    public static volatile SingularAttribute<TipoCentro, Integer> idTipoCentro;
    public static volatile SingularAttribute<TipoCentro, String> observaciones;
    public static volatile SingularAttribute<TipoCentro, String> nombre;
    public static volatile SingularAttribute<TipoCentro, Boolean> activo;

}