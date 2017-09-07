/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package sv.ues.edu.tpi2016.clinica.gateway;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import sv.ues.edu.tpi2016.clinica.entities.AsignacionPersonalCentroAreaEspacio;

/**
 *
 * @author sakshi
 */
@Stateless
public class AsignacionPersonalCentroAreaEspacioFacade extends AbstractFacade<AsignacionPersonalCentroAreaEspacio> implements AsignacionPersonalCentroAreaEspacioFacadeLocal {
    @PersistenceContext(unitName = "testJPQL")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public AsignacionPersonalCentroAreaEspacioFacade() {
        super(AsignacionPersonalCentroAreaEspacio.class);
    }

}
