/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sv.edu.uesocc.ingenieria.tpi135_2016.clinica.datos.acceso;

import java.util.List;
import java.util.Map;
import javax.ejb.Local;
import sv.edu.uesocc.ingenieria.tpi135_2016.clinica.datos.definiciones.TipoEspecialidad;

/**
 *
 * @author sakshi
 */
@Local
public interface TipoEspecialidadFacadeLocal extends AbstractFacadeInterface<TipoEspecialidad>{

    @Override
    public boolean eliminar(TipoEspecialidad entity);

    @Override
    public boolean editar(TipoEspecialidad entity);

    @Override
    public boolean crear(TipoEspecialidad entity);

    @Override
    TipoEspecialidad find(Object id);

    @Override
    List<TipoEspecialidad> findAll();

    @Override
    List<TipoEspecialidad> findRange(int[] range);

    @Override
    int count();

    @Override
    public int countByDataFilters(Map<String, Object> filters);

    @Override
    public List<TipoEspecialidad> findRango(int first, int tamanioPagina);

    @Override
    public List<TipoEspecialidad> findByDataFilters(Map<String, Object> filters, int first, int tamanioPagina);
    
}
