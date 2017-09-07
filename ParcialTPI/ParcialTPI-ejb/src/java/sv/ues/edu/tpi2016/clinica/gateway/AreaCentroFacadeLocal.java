/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sv.ues.edu.tpi2016.clinica.gateway;

import java.util.List;
import javax.ejb.Local;
import sv.ues.edu.tpi2016.clinica.entities.AreaCentro;

/**
 *
 * @author sakshi
 */
@Local
public interface AreaCentroFacadeLocal {

    void create(AreaCentro areaCentro);

    void edit(AreaCentro areaCentro);

    void remove(AreaCentro areaCentro);

    AreaCentro find(Object id);

    List<AreaCentro> findAll();

    List<AreaCentro> findRange(int[] range);

    int count();
    
}
