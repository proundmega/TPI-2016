/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package sv.edu.tpi.clinica.acceso;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import sv.edu.uesocc.ingenieria.tpi135_2016.clinica.datos.definiciones.IngresoDetalleExamen;

/**
 *
 * @author sakshi
 */
@Stateless
public class IngresoDetalleExamenFacade extends AbstractFacade<IngresoDetalleExamen> implements IngresoDetalleExamenFacadeLocal {
    @PersistenceContext(unitName = "ClinicaTPI-ejbPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public IngresoDetalleExamenFacade() {
        super(IngresoDetalleExamen.class);
    }

}
