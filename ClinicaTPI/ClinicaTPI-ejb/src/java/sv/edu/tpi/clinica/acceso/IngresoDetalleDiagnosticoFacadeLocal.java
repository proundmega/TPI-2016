/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sv.edu.tpi.clinica.acceso;

import java.util.List;
import javax.ejb.Local;
import sv.edu.uesocc.ingenieria.tpi135_2016.clinica.datos.definiciones.IngresoDetalleDiagnostico;

/**
 *
 * @author sakshi
 */
@Local
public interface IngresoDetalleDiagnosticoFacadeLocal {

    void create(IngresoDetalleDiagnostico ingresoDetalleDiagnostico);

    void edit(IngresoDetalleDiagnostico ingresoDetalleDiagnostico);

    void remove(IngresoDetalleDiagnostico ingresoDetalleDiagnostico);

    IngresoDetalleDiagnostico find(Object id);

    List<IngresoDetalleDiagnostico> findAll();

    List<IngresoDetalleDiagnostico> findRange(int[] range);

    int count();
    
}
