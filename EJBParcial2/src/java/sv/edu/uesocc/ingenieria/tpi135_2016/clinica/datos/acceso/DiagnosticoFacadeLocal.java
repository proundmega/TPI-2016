/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sv.edu.uesocc.ingenieria.tpi135_2016.clinica.datos.acceso;

import java.util.List;
import javax.ejb.Local;
import sv.edu.uesocc.ingenieria.tpi135_2016.clinica.datos.definiciones.Diagnostico;

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
