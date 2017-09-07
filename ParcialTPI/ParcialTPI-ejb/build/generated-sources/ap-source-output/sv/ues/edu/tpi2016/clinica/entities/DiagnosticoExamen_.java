package sv.ues.edu.tpi2016.clinica.entities;

import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;
import sv.ues.edu.tpi2016.clinica.entities.Diagnostico;
import sv.ues.edu.tpi2016.clinica.entities.DiagnosticoExamenPK;
import sv.ues.edu.tpi2016.clinica.entities.Examen;

@Generated(value="EclipseLink-2.6.1.v20151021-rNA", date="2016-04-04T15:23:57")
@StaticMetamodel(DiagnosticoExamen.class)
public class DiagnosticoExamen_ { 

    public static volatile SingularAttribute<DiagnosticoExamen, Diagnostico> diagnostico;
    public static volatile SingularAttribute<DiagnosticoExamen, String> observaciones;
    public static volatile SingularAttribute<DiagnosticoExamen, Examen> examen;
    public static volatile SingularAttribute<DiagnosticoExamen, DiagnosticoExamenPK> diagnosticoExamenPK;
    public static volatile SingularAttribute<DiagnosticoExamen, Boolean> obligatorio;

}