/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sv.ues.edu.tpi2016.clinica.gateway;

import java.util.List;
import javax.ejb.Local;
import sv.ues.edu.tpi2016.clinica.entities.PersonalEspecialidad;

/**
 *
 * @author sakshi
 */
@Local
public interface PersonalEspecialidadFacadeLocal {

    void create(PersonalEspecialidad personalEspecialidad);

    void edit(PersonalEspecialidad personalEspecialidad);

    void remove(PersonalEspecialidad personalEspecialidad);

    PersonalEspecialidad find(Object id);

    List<PersonalEspecialidad> findAll();

    List<PersonalEspecialidad> findRange(int[] range);

    int count();
    
}
