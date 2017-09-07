/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sv.ues.edu.tpi2016.clinica.gateway;

import java.util.List;
import javax.ejb.Local;
import sv.ues.edu.tpi2016.clinica.entities.PacienteMedioContacto;

/**
 *
 * @author sakshi
 */
@Local
public interface PacienteMedioContactoFacadeLocal {

    void create(PacienteMedioContacto pacienteMedioContacto);

    void edit(PacienteMedioContacto pacienteMedioContacto);

    void remove(PacienteMedioContacto pacienteMedioContacto);

    PacienteMedioContacto find(Object id);

    List<PacienteMedioContacto> findAll();

    List<PacienteMedioContacto> findRange(int[] range);

    int count();
    
}
