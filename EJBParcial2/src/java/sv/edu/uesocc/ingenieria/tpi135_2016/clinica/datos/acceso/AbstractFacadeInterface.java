/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sv.edu.uesocc.ingenieria.tpi135_2016.clinica.datos.acceso;

import java.util.List;
import java.util.Map;

/**
 *
 * @author sakshi
 */
public interface AbstractFacadeInterface<T> {
    
    boolean crear(T entity);

    boolean editar(T entity);

    boolean eliminar(T entity);

    T find(Object id);

    List<T> findAll();

    List<T> findRange(int[] range);

    int count();
    
    public List<T> findByDataFilters(Map<String, Object> filters, int first, int tamanioPagina);
    
    public List<T> findRango(int first, int tamanioPagina);
    
    public int countByDataFilters(Map<String, Object> filters);
    
    public String getCampoOrderBy();
}
