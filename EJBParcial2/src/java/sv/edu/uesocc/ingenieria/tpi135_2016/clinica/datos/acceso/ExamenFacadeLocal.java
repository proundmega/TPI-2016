/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sv.edu.uesocc.ingenieria.tpi135_2016.clinica.datos.acceso;

import java.util.List;
import java.util.Map;
import javax.ejb.Local;
import sv.edu.uesocc.ingenieria.tpi135_2016.clinica.datos.definiciones.Examen;

/**
 *
 * @author sakshi
 */
@Local
public interface ExamenFacadeLocal extends AbstractFacadeInterface<Examen>{

    @Override
    public int countByDataFilters(Map<String, Object> filters);

    @Override
    public List<Examen> findRango(int first, int tamanioPagina);

    @Override
    public List<Examen> findByDataFilters(Map<String, Object> filters, int first, int tamanioPagina);

    @Override
    public int count();

    @Override
    public List<Examen> findRange(int[] range);

    @Override
    public List<Examen> findAll();

    @Override
    public Examen find(Object id);

    @Override
    public boolean eliminar(Examen entity);

    @Override
    public boolean editar(Examen entity);

    @Override
    public boolean crear(Examen entity);

}
