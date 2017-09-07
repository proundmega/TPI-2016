package sv.ues.edu.tpi.clinica.web.services;

import java.util.HashSet;
import java.util.Set;
import javax.ws.rs.ApplicationPath;
import javax.ws.rs.core.Application;

@ApplicationPath("tpi")
public class AplicationContext extends Application{

    @Override
    public Set<Class<?>> getClasses() {
        Set<Class<?>> setClasses = new HashSet<>();
        setClasses.add(IngresoDetalleFacadeREST.class);
        setClasses.add(IngresoFacadeREST.class);
        setClasses.add(PacienteFacadeREST.class);
        setClasses.add(TipoCentroFacadeREST.class);
        setClasses.add(TipoIngresoFacadeREST.class);
        setClasses.add(AsignacionPersonalCentroAreaEspacioFacadeREST.class);
        return setClasses;
    }
    
    
    
}
