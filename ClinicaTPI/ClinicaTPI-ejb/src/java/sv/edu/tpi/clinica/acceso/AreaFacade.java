/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package sv.edu.tpi.clinica.acceso;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import sv.edu.uesocc.ingenieria.tpi135_2016.clinica.datos.definiciones.Area;

/**
 *
 * @author sakshi
 */
@Stateless
public class AreaFacade extends AbstractFacade<Area> implements AreaFacadeLocal {
    @PersistenceContext(unitName = "ClinicaTPI-ejbPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public AreaFacade() {
        super(Area.class);
    }

}
