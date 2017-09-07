/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package sv.ues.edu.tpi2016.clinica.gateway;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import sv.ues.edu.tpi2016.clinica.entities.IngresoDetalleDiagnostico;

/**
 *
 * @author sakshi
 */
@Stateless
public class IngresoDetalleDiagnosticoFacade extends AbstractFacade<IngresoDetalleDiagnostico> implements IngresoDetalleDiagnosticoFacadeLocal {
    @PersistenceContext(unitName = "testJPQL")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public IngresoDetalleDiagnosticoFacade() {
        super(IngresoDetalleDiagnostico.class);
    }

}
