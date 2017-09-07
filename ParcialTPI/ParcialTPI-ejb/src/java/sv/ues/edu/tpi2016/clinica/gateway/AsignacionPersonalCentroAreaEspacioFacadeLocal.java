/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sv.ues.edu.tpi2016.clinica.gateway;

import java.util.List;
import javax.ejb.Local;
import sv.ues.edu.tpi2016.clinica.entities.AsignacionPersonalCentroAreaEspacio;

/**
 *
 * @author sakshi
 */
@Local
public interface AsignacionPersonalCentroAreaEspacioFacadeLocal {

    void create(AsignacionPersonalCentroAreaEspacio asignacionPersonalCentroAreaEspacio);

    void edit(AsignacionPersonalCentroAreaEspacio asignacionPersonalCentroAreaEspacio);

    void remove(AsignacionPersonalCentroAreaEspacio asignacionPersonalCentroAreaEspacio);

    AsignacionPersonalCentroAreaEspacio find(Object id);

    List<AsignacionPersonalCentroAreaEspacio> findAll();

    List<AsignacionPersonalCentroAreaEspacio> findRange(int[] range);

    int count();
    
}
