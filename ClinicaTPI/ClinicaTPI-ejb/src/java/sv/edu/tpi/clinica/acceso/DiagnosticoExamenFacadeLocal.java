/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sv.edu.tpi.clinica.acceso;

import java.util.List;
import javax.ejb.Local;
import sv.edu.uesocc.ingenieria.tpi135_2016.clinica.datos.definiciones.DiagnosticoExamen;

/**
 *
 * @author sakshi
 */
@Local
public interface DiagnosticoExamenFacadeLocal {

    void create(DiagnosticoExamen diagnosticoExamen);

    void edit(DiagnosticoExamen diagnosticoExamen);

    void remove(DiagnosticoExamen diagnosticoExamen);

    DiagnosticoExamen find(Object id);

    List<DiagnosticoExamen> findAll();

    List<DiagnosticoExamen> findRange(int[] range);

    int count();
    
}
