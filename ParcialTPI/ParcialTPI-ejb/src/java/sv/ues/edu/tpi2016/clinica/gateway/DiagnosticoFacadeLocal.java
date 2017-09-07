/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sv.ues.edu.tpi2016.clinica.gateway;

import java.util.List;
import javax.ejb.Local;
import sv.ues.edu.tpi2016.clinica.entities.Diagnostico;

/**
 *
 * @author sakshi
 */
@Local
public interface DiagnosticoFacadeLocal {

    void create(Diagnostico diagnostico);

    void edit(Diagnostico diagnostico);

    void remove(Diagnostico diagnostico);

    Diagnostico find(Object id);

    List<Diagnostico> findAll();

    List<Diagnostico> findRange(int[] range);

    int count();
    
}
