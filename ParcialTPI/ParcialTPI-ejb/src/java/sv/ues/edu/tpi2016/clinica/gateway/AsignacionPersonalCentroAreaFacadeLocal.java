/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sv.ues.edu.tpi2016.clinica.gateway;

import java.util.List;
import javax.ejb.Local;
import sv.ues.edu.tpi2016.clinica.entities.AsignacionPersonalCentroArea;

/**
 *
 * @author sakshi
 */
@Local
public interface AsignacionPersonalCentroAreaFacadeLocal {

    void create(AsignacionPersonalCentroArea asignacionPersonalCentroArea);

    void edit(AsignacionPersonalCentroArea asignacionPersonalCentroArea);

    void remove(AsignacionPersonalCentroArea asignacionPersonalCentroArea);

    AsignacionPersonalCentroArea find(Object id);

    List<AsignacionPersonalCentroArea> findAll();

    List<AsignacionPersonalCentroArea> findRange(int[] range);

    int count();
    
}
