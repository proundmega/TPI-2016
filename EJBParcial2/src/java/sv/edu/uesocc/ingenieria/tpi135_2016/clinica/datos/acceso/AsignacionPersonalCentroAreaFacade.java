/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package sv.edu.uesocc.ingenieria.tpi135_2016.clinica.datos.acceso;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.UserTransaction;
import sv.edu.uesocc.ingenieria.tpi135_2016.clinica.datos.definiciones.AsignacionPersonalCentroArea;

/**
 *
 * @author sakshi
 */
@Stateless
public class AsignacionPersonalCentroAreaFacade extends AbstractFacade<AsignacionPersonalCentroArea> implements AsignacionPersonalCentroAreaFacadeLocal {
    @PersistenceContext(unitName = "EJBParcial2PU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public AsignacionPersonalCentroAreaFacade() {
        super(AsignacionPersonalCentroArea.class);
    }

    @Override
    protected UserTransaction getTransaccion() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean esNumero(String campo) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String getCampoId() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String getCampoOrderBy() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void create(AsignacionPersonalCentroArea asignacionPersonalCentroArea) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void edit(AsignacionPersonalCentroArea asignacionPersonalCentroArea) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void remove(AsignacionPersonalCentroArea asignacionPersonalCentroArea) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
