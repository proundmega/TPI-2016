/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sv.edu.uesocc.ingenieria.tpi135_2016.clinica.datos.acceso;

import java.util.List;
import java.util.Map;
import javax.ejb.Local;
import sv.edu.uesocc.ingenieria.tpi135_2016.clinica.datos.definiciones.TipoExamen;

/**
 *
 * @author sakshi
 */
@Local
public interface TipoExamenFacadeLocal extends AbstractFacadeInterface<TipoExamen>{

    @Override
    public int countByDataFilters(Map<String, Object> filters);

    @Override
    public List<TipoExamen> findRango(int first, int tamanioPagina);

    @Override
    public List<TipoExamen> findByDataFilters(Map<String, Object> filters, int first, int tamanioPagina);

    @Override
    public int count();

    @Override
    public List<TipoExamen> findRange(int[] range);

    @Override
    public List<TipoExamen> findAll();

    @Override
    public TipoExamen find(Object id);

    @Override
    public boolean eliminar(TipoExamen entity);

    @Override
    public boolean editar(TipoExamen entity);

    @Override
    public boolean crear(TipoExamen entity);

}
