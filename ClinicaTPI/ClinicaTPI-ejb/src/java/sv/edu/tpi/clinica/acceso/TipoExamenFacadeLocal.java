/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sv.edu.tpi.clinica.acceso;

import java.util.List;
import javax.ejb.Local;
import sv.edu.uesocc.ingenieria.tpi135_2016.clinica.datos.definiciones.TipoExamen;

/**
 *
 * @author sakshi
 */
@Local
public interface TipoExamenFacadeLocal {

    void create(TipoExamen tipoExamen);

    void edit(TipoExamen tipoExamen);

    void remove(TipoExamen tipoExamen);

    TipoExamen find(Object id);

    List<TipoExamen> findAll();

    List<TipoExamen> findRange(int[] range);

    int count();
    
}
