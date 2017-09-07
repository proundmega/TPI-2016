/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sv.ues.edu.tpi2016.clinica.gateway;

import java.util.List;
import javax.ejb.Local;
import sv.ues.edu.tpi2016.clinica.entities.Centro;

/**
 *
 * @author sakshi
 */
@Local
public interface CentroFacadeLocal {

    void create(Centro centro);

    void edit(Centro centro);

    void remove(Centro centro);

    Centro find(Object id);

    List<Centro> findAll();

    List<Centro> findRange(int[] range);

    int count();
    
}
