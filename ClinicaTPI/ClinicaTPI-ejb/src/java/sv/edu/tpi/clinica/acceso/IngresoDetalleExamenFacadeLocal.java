/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sv.edu.tpi.clinica.acceso;

import java.util.List;
import javax.ejb.Local;
import sv.edu.uesocc.ingenieria.tpi135_2016.clinica.datos.definiciones.IngresoDetalleExamen;

/**
 *
 * @author sakshi
 */
@Local
public interface IngresoDetalleExamenFacadeLocal {

    void create(IngresoDetalleExamen ingresoDetalleExamen);

    void edit(IngresoDetalleExamen ingresoDetalleExamen);

    void remove(IngresoDetalleExamen ingresoDetalleExamen);

    IngresoDetalleExamen find(Object id);

    List<IngresoDetalleExamen> findAll();

    List<IngresoDetalleExamen> findRange(int[] range);

    int count();
    
}
