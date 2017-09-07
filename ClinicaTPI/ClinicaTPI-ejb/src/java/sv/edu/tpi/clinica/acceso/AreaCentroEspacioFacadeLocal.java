/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sv.edu.tpi.clinica.acceso;

import java.util.List;
import javax.ejb.Local;
import sv.edu.uesocc.ingenieria.tpi135_2016.clinica.datos.definiciones.AreaCentroEspacio;

/**
 *
 * @author sakshi
 */
@Local
public interface AreaCentroEspacioFacadeLocal {

    void create(AreaCentroEspacio areaCentroEspacio);

    void edit(AreaCentroEspacio areaCentroEspacio);

    void remove(AreaCentroEspacio areaCentroEspacio);

    AreaCentroEspacio find(Object id);

    List<AreaCentroEspacio> findAll();

    List<AreaCentroEspacio> findRange(int[] range);

    int count();
    
}
