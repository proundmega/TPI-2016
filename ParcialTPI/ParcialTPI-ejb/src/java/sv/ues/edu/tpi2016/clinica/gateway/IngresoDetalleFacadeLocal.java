/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sv.ues.edu.tpi2016.clinica.gateway;

import java.util.List;
import javax.ejb.Local;
import sv.ues.edu.tpi2016.clinica.entities.IngresoDetalle;

/**
 *
 * @author sakshi
 */
@Local
public interface IngresoDetalleFacadeLocal {

    void create(IngresoDetalle ingresoDetalle);

    void edit(IngresoDetalle ingresoDetalle);

    void remove(IngresoDetalle ingresoDetalle);

    IngresoDetalle find(Object id);

    List<IngresoDetalle> findAll();

    List<IngresoDetalle> findRange(int[] range);

    int count();
    
}
