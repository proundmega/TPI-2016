package org.proundmega.clinica.mvc;

import java.io.Serializable;
import java.util.List;
import java.util.Map;
import org.primefaces.model.LazyDataModel;
import org.primefaces.model.SortOrder;

public abstract class BaseController<T> implements Serializable{
    protected T elementoSeleccionado;
    protected LazyDataModel<T> modelo;

    public T getElementoSeleccionado() {
        return elementoSeleccionado;
    }

    public void setElementoSeleccionado(T elementoSeleccionado) {
        this.elementoSeleccionado = elementoSeleccionado;
    }

    public LazyDataModel<T> getModelo() {
        return modelo;
    }
    
    protected abstract Object getIdObjeto(T objeto);
    
    protected abstract int getCountObjetos();
    
    protected abstract List<T> findRange(int[] range);
    
    protected abstract boolean isKeyOf(Integer key, T object);
    
    protected class BasiLazyDataModel extends LazyDataModel<T>{
            @Override
            public Object getRowKey(T object) {
                return getIdObjeto(object);
            }

            @Override
            public List<T> load(int first, int pageSize, String sortField, SortOrder sortOrder, Map<String, Object> filters) {
                System.out.println(filters);
                this.setRowCount(getCountObjetos());
                return findRange(getLimites(first, pageSize));
            }
            
            private int[] getLimites(int first, int pageSize) {
                return new int[]{first, pageSize + first};
            }

            @Override
            public T getRowData(String rowKey) {
                List<T> lista = (List<T>)this.getWrappedData();
                return lista.stream()
                        .filter(object -> isKeyOf(new Integer(rowKey), object))
                        .findFirst()
                        .orElseThrow(NullPointerException::new);
            }
            
            
    }
}
