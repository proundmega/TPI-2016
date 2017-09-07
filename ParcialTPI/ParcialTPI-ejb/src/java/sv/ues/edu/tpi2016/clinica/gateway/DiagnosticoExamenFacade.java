/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package sv.ues.edu.tpi2016.clinica.gateway;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import sv.ues.edu.tpi2016.clinica.entities.DiagnosticoExamen;

/**
 *
 * @author sakshi
 */
@Stateless
public class DiagnosticoExamenFacade extends AbstractFacade<DiagnosticoExamen> implements DiagnosticoExamenFacadeLocal {
    @PersistenceContext(unitName = "testJPQL")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public DiagnosticoExamenFacade() {
        super(DiagnosticoExamen.class);
    }

}
