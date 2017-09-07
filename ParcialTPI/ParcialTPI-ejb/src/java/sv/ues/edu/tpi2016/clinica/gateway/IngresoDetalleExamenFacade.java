/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package sv.ues.edu.tpi2016.clinica.gateway;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import sv.ues.edu.tpi2016.clinica.entities.IngresoDetalleExamen;

/**
 *
 * @author sakshi
 */
@Stateless
public class IngresoDetalleExamenFacade extends AbstractFacade<IngresoDetalleExamen> implements IngresoDetalleExamenFacadeLocal {
    @PersistenceContext(unitName = "testJPQL")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public IngresoDetalleExamenFacade() {
        super(IngresoDetalleExamen.class);
    }

}
