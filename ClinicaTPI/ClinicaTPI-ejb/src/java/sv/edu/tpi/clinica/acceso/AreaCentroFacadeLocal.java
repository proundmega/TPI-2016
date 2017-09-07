/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sv.edu.tpi.clinica.acceso;

import java.util.List;
import javax.ejb.Local;
import sv.edu.uesocc.ingenieria.tpi135_2016.clinica.datos.definiciones.AreaCentro;

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
