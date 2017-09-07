/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sv.ues.edu.tpi2016.clinica.gateway;

import java.util.List;
import javax.ejb.Local;
import sv.ues.edu.tpi2016.clinica.entities.MedioContacto;

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
