package sv.ues.edu.tpi2016.clinica.entities;

import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;
import sv.ues.edu.tpi2016.clinica.entities.AsignacionPersonalCentroArea;
import sv.ues.edu.tpi2016.clinica.entities.AsignacionPersonalCentroAreaEspacioPK;
import sv.ues.edu.tpi2016.clinica.entities.IngresoDetalle;

@Generated(value="EclipseLink-2.6.1.v20151021-rNA", date="2016-04-04T15:23:57")
@StaticMetamodel(AsignacionPersonalCentroAreaEspacio.class)
public class AsignacionPersonalCentroAreaEspacio_ { 

    public static volatile SingularAttribute<AsignacionPersonalCentroAreaEspacio, String> observaciones;
    public static volatile SingularAttribute<AsignacionPersonalCentroAreaEspacio, AsignacionPersonalCentroArea> asignacionPersonalCentroArea;
    public static volatile SingularAttribute<AsignacionPersonalCentroAreaEspacio, AsignacionPersonalCentroAreaEspacioPK> asignacionPersonalCentroAreaEspacioPK;
    public static volatile ListAttribute<AsignacionPersonalCentroAreaEspacio, IngresoDetalle> ingresoDetalleList;

}