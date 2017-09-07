/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sv.ues.edu.tpi.clinica.web.services;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import javax.persistence.EntityManager;
import org.jboss.logging.Logger;
import org.proundmega.jpa.queries.Condiciones;
import org.proundmega.jpa.queries.CriteriaQueryBuilder;

/**
 *
 * @author sakshi
 */
public abstract class AbstractFacade<T> {

    public Class<T> entityClass;

    public AbstractFacade(Class<T> entityClass) {
        this.entityClass = entityClass;
    }

    protected abstract EntityManager getEntityManager();

    public void crear(T entity) {
        getEntityManager().persist(entity);
    }

    public void editar(T entity) {
        getEntityManager().merge(entity);
    }

    public void eliminar(T entity) {
        getEntityManager().remove(getEntityManager().merge(entity));
    }

    public T find(Object id) {
        return getEntityManager().find(entityClass, id);
    }

    public List<T> findAll() {
        Condiciones<T> condiciones = new Condiciones<>(entityClass);
        CriteriaQueryBuilder<T> builder = new CriteriaQueryBuilder<>(entityClass, getEntityManager());
        builder.setCampoOrderBy(getCampoOrderBy());
        return builder.findByDataFilters(condiciones, 0, 10000);
        
//        javax.persistence.criteria.CriteriaQuery cq = getEntityManager().getCriteriaBuilder().createQuery();
//        cq.select(cq.from(entityClass));
//        return getEntityManager().createQuery(cq).getResultList();
    }

    public List<T> findRange(int[] range) {
        javax.persistence.criteria.CriteriaQuery cq = getEntityManager().getCriteriaBuilder().createQuery();
        cq.select(cq.from(entityClass));
        javax.persistence.Query q = getEntityManager().createQuery(cq);
        q.setMaxResults(range[1] - range[0] + 1);
        q.setFirstResult(range[0]);
        return q.getResultList();
    }

    public int count() {
        javax.persistence.criteria.CriteriaQuery cq = getEntityManager().getCriteriaBuilder().createQuery();
        javax.persistence.criteria.Root<T> rt = cq.from(entityClass);
        cq.select(getEntityManager().getCriteriaBuilder().count(rt));
        javax.persistence.Query q = getEntityManager().createQuery(cq);
        return ((Long) q.getSingleResult()).intValue();
    }

    public List<T> findRango(int first, int tamanioPagina) {
        Condiciones<T> condiciones = new Condiciones<>(entityClass);
        CriteriaQueryBuilder<T> builder = new CriteriaQueryBuilder<>(entityClass, getEntityManager());
        builder.setCampoOrderBy(getCampoOrderBy());
        return builder.findByDataFilters(condiciones, first, tamanioPagina);
    }

    private int[] getLimites(int first, int pageSize) {
        return new int[]{first, pageSize + first - 1};
    }

    public String getCampoOrderBy() {
        return null;
    }
    
}
