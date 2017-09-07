/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sv.edu.tpi.clinica.acceso;

import java.util.List;
import javax.ejb.Local;
import sv.edu.uesocc.ingenieria.tpi135_2016.clinica.datos.definiciones.TipoMedioContacto;

/**
 *
 * @author sakshi
 */
@Local
public interface TipoMedioContactoFacadeLocal {

    void create(TipoMedioContacto tipoMedioContacto);

    void edit(TipoMedioContacto tipoMedioContacto);

    void remove(TipoMedioContacto tipoMedioContacto);

    TipoMedioContacto find(Object id);

    List<TipoMedioContacto> findAll();

    List<TipoMedioContacto> findRange(int[] range);

    int count();
    
}
