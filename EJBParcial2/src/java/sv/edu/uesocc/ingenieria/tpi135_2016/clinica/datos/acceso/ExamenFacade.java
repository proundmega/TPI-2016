/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package sv.edu.uesocc.ingenieria.tpi135_2016.clinica.datos.acceso;

import javax.annotation.Resource;
import javax.ejb.Stateless;
import javax.ejb.TransactionManagement;
import javax.ejb.TransactionManagementType;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.UserTransaction;
import sv.edu.uesocc.ingenieria.tpi135_2016.clinica.datos.definiciones.Examen;

/**
 *
 * @author sakshi
 */
@Stateless
@TransactionManagement(value=TransactionManagementType.BEAN)
public class ExamenFacade extends AbstractFacade<Examen> implements ExamenFacadeLocal {
    @PersistenceContext(unitName = "EJBParcial2PU")
    private EntityManager em;

    @Resource
    private UserTransaction userTransaction;
    
    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public ExamenFacade() {
        super(Examen.class);
    }

    @Override
    public boolean esNumero(String campo) {
        return campo.equals("idExamen");
    }

    @Override
    public String getCampoId() {
        return "idExamen";
    }

    @Override
    public String getCampoOrderBy() {
        return "nombre";
    }

    @Override
    protected UserTransaction getTransaccion() {
        return userTransaction;
    }

    
}
