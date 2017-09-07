package sv.edu.uesocc.ingenieria.tpi135_2016.clinica.datos.acceso;

import java.util.List;
import java.util.Map;
import javax.ejb.Local;
import sv.edu.uesocc.ingenieria.tpi135_2016.clinica.datos.definiciones.Especialidad;

@Local
public interface EspecialidadFacadeLocal extends AbstractFacadeInterface<Especialidad>{

    @Override
    public boolean eliminar(Especialidad entity);

    @Override
    public boolean editar(Especialidad entity);

    @Override
    public boolean crear(Especialidad entity);

    @Override
    Especialidad find(Object id);

    @Override
    List<Especialidad> findAll();

    @Override
    List<Especialidad> findRange(int[] range);

    @Override
    int count();

    @Override
    public List<Especialidad> findRango(int first, int tamanioPagina);

    @Override
    public List<Especialidad> findByDataFilters(Map<String, Object> filters, int first, int tamanioPagina);

    @Override
    public int countByDataFilters(Map<String, Object> filters);

}
