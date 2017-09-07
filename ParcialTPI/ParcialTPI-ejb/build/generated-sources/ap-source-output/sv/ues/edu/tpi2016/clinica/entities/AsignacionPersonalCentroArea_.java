package sv.ues.edu.tpi2016.clinica.entities;

import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;
import sv.ues.edu.tpi2016.clinica.entities.AreaCentro;
import sv.ues.edu.tpi2016.clinica.entities.AsignacionPersonalCentroAreaEspacio;
import sv.ues.edu.tpi2016.clinica.entities.Personal;

@Generated(value="EclipseLink-2.6.1.v20151021-rNA", date="2016-04-04T15:23:57")
@StaticMetamodel(AsignacionPersonalCentroArea.class)
public class AsignacionPersonalCentroArea_ { 

    public static volatile SingularAttribute<AsignacionPersonalCentroArea, AreaCentro> idAreaCentro;
    public static volatile SingularAttribute<AsignacionPersonalCentroArea, Long> idAsignacionPersonalCentroArea;
    public static volatile SingularAttribute<AsignacionPersonalCentroArea, Date> fechaHasta;
    public static volatile SingularAttribute<AsignacionPersonalCentroArea, Personal> idPersonal;
    public static volatile SingularAttribute<AsignacionPersonalCentroArea, Date> fechaDesde;
    public static volatile ListAttribute<AsignacionPersonalCentroArea, AsignacionPersonalCentroAreaEspacio> asignacionPersonalCentroAreaEspacioList;

}