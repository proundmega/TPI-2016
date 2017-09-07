/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sv.ues.edu.tpi2016.clinica.gateway;

import java.util.List;
import javax.ejb.Local;
import sv.ues.edu.tpi2016.clinica.entities.IngresoDetalleDiagnostico;

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
