/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sv.ues.edu.tpi2016.clinica.gateway;

import java.util.List;
import javax.ejb.Local;
import sv.ues.edu.tpi2016.clinica.entities.TipoIngreso;

/**
 *
 * @author sakshi
 */
@Local
public interface TipoIngresoFacadeLocal {

    void create(TipoIngreso tipoIngreso);

    void edit(TipoIngreso tipoIngreso);

    void remove(TipoIngreso tipoIngreso);

    TipoIngreso find(Object id);

    List<TipoIngreso> findAll();

    List<TipoIngreso> findRange(int[] range);

    int count();
    
}
