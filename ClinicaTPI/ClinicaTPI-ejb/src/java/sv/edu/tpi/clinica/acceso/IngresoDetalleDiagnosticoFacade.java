/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package sv.edu.tpi.clinica.acceso;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import sv.edu.uesocc.ingenieria.tpi135_2016.clinica.datos.definiciones.IngresoDetalleDiagnostico;

/**
 *
 * @author sakshi
 */
@Stateless
public class IngresoDetalleDiagnosticoFacade extends AbstractFacade<IngresoDetalleDiagnostico> implements IngresoDetalleDiagnosticoFacadeLocal {
    @PersistenceContext(unitName = "ClinicaTPI-ejbPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public IngresoDetalleDiagnosticoFacade() {
        super(IngresoDetalleDiagnostico.class);
    }

}
