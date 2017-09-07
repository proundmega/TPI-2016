/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sv.ues.edu.tpi2016.clinica.gateway;

import java.util.List;
import javax.ejb.Local;
import sv.ues.edu.tpi2016.clinica.entities.TipoMedioContacto;

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
