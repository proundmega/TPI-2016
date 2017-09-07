/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sv.edu.tpi.clinica.acceso;

import java.util.List;
import javax.ejb.Local;
import sv.edu.uesocc.ingenieria.tpi135_2016.clinica.datos.definiciones.MedioContacto;

/**
 *
 * @author sakshi
 */
@Local
public interface MedioContactoFacadeLocal {

    void create(MedioContacto medioContacto);

    void edit(MedioContacto medioContacto);

    void remove(MedioContacto medioContacto);

    MedioContacto find(Object id);

    List<MedioContacto> findAll();

    List<MedioContacto> findRange(int[] range);

    int count();
    
}
