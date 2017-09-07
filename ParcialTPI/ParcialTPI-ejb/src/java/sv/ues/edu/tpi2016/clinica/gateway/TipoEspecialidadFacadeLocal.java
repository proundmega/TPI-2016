/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sv.ues.edu.tpi2016.clinica.gateway;

import java.util.List;
import javax.ejb.Local;
import sv.ues.edu.tpi2016.clinica.entities.TipoEspecialidad;

/**
 *
 * @author sakshi
 */
@Local
public interface TipoEspecialidadFacadeLocal {

    void create(TipoEspecialidad tipoEspecialidad);

    void edit(TipoEspecialidad tipoEspecialidad);

    void remove(TipoEspecialidad tipoEspecialidad);

    TipoEspecialidad find(Object id);

    List<TipoEspecialidad> findAll();

    List<TipoEspecialidad> findRange(int[] range);

    int count();
    
}
