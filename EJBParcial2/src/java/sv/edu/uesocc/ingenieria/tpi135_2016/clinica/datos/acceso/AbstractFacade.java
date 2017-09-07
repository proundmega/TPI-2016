/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sv.edu.uesocc.ingenieria.tpi135_2016.clinica.datos.acceso;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import javax.persistence.EntityManager;
import javax.transaction.UserTransaction;
import org.jboss.logging.Logger;
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

    protected abstract UserTransaction getTransaccion();
    
    protected abstract EntityManager getEntityManager();

    public boolean crear(T entity) {
        try {
            UserTransaction transaccion = getTransaccion();
            transaccion.begin();
            getEntityManager().persist(entity);
            transaccion.commit();
            return true;
        } catch (Exception e) {
            Logger.getLogger(AbstractFacade.class).log(Logger.Level.FATAL, e);
            return false;
        }
    }
    
    public boolean editar(T entity) {
        try {
            UserTransaction transaccion = getTransaccion();
            transaccion.begin();
            getEntityManager().merge(entity);
            transaccion.commit();
            return true;
        } catch (Exception e) {
            Logger.getLogger(AbstractFacade.class).log(Logger.Level.FATAL, e);
            return false;
        }
    }

    public boolean eliminar(T entity) {
        try {
            UserTransaction transaccion = getTransaccion();
            transaccion.begin();
            getEntityManager().remove(getEntityManager().merge(entity));
            transaccion.commit();
            return true;
        } catch (Exception e) {
            Logger.getLogger(AbstractFacade.class).log(Logger.Level.FATAL, e);
            return false;
        }
    }

    public T find(Object id) {
        return getEntityManager().find(entityClass, id);
    }

    public List<T> findAll() {
        javax.persistence.criteria.CriteriaQuery cq = getEntityManager().getCriteriaBuilder().createQuery();
        cq.select(cq.from(entityClass));
        return getEntityManager().createQuery(cq).getResultList();
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
        return findRange(getLimites(first, tamanioPagina));
    }

    private int[] getLimites(int first, int pageSize) {
        return new int[]{first, pageSize + first};
    }

    public List<T> findByDataFilters(Map<String, Object> filters, int first, int tamanioPagina) {
        try {
            CriteriaQueryBuilder<T> builder = new CriteriaQueryBuilder<>(entityClass, getEntityManager());
            builder.setCampoOrderBy(getCampoOrderBy());
            return builder.findByDataFilters(filters, first, tamanioPagina);
        } catch (Exception e) {
            Logger.getLogger(AbstractFacade.class).log(Logger.Level.FATAL, e);
            return new ArrayList<>();
        }
    }

    public int countByDataFilters(Map<String, Object> filters) {
        try {
            CriteriaQueryBuilder<T> builder = new CriteriaQueryBuilder<>(entityClass, getEntityManager());
            builder.setCampoOrderBy(getCampoOrderBy());
            return builder.countByDataFilters(filters);
        } catch (Exception e) {
            Logger.getLogger(AbstractFacade.class).log(Logger.Level.FATAL, e);
            return 0;
        }
    }

    public abstract boolean esNumero(String campo);

    public abstract String getCampoId();

    public abstract String getCampoOrderBy();
}
