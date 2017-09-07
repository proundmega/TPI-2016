package sv.edu.tpi.clinica.reflection;

import java.io.Serializable;
import java.util.List;
import java.util.Map;
import javax.validation.constraints.NotNull;
import org.primefaces.model.LazyDataModel;
import sv.edu.uesocc.ingenieria.tpi135_2016.clinica.datos.acceso.AbstractFacadeInterface;

public abstract class BaseController<T> implements Serializable {
    private T elementoSeleccionado;
    private LazyDataModel<T> modelo;
    private boolean mostrar;
    private List<String> propiedadesTabla;
    private EntityMapper<T> entityMapper;
    
    public BaseController() {
    }

    public void init() {
        modelo = new BasicLazyDataModel(this);
        mostrar = false;
        prepararMetaData();
    }
    
    private void prepararMetaData() {
        Class<T> clazz = getClassBase();
        entityMapper = new EntityMapper<>(clazz);
        propiedadesTabla = crearPropiedades();
    }
    
    protected abstract Class<T> getClassBase();

    protected List<String> crearPropiedades() {
        return entityMapper.getListaPropiedadesConNotacionColumn();
    }
    
    public T getElementoSeleccionado() {
        return elementoSeleccionado;
    }

    public void setElementoSeleccionado(T elementoSeleccionado) {
        this.elementoSeleccionado = elementoSeleccionado;
    }

    public LazyDataModel<T> getModelo() {
        return modelo;
    }

    public Object getIdObjeto(@NotNull T objeto) {
        return entityMapper.getIdObjeto(objeto);
    }

    protected boolean isIdDelObjeto(String key, T object) {
        return entityMapper.isIdDelObjeto(key, object);
    }

    protected abstract AbstractFacadeInterface getFacade();

    protected int getCountObjetos() {
        return getFacade().count();
    }

    protected List<T> findRange(int[] range) {
        return getFacade().findRange(range);
    }

    public Object getPropiedad(@NotNull T objeto, @NotNull String propiedad) {
        return entityMapper.getPropiedad(objeto, propiedad);
    }

    public void mostrarObjectoSeleccionado() {
        System.out.println(elementoSeleccionado);
        mostrar = true;
    }

    public List<String> getPropiedadesTabla() {
        return propiedadesTabla;
    }

    public boolean isMostrar() {
        return mostrar;
    }

    public void crearNuevoObjeto() {
        elementoSeleccionado = entityMapper.nuevaInstanciaEntity();
        mostrarObjectoSeleccionado();
    }
    
    public int getCountObjetosFiltrados(Map<String, Object> filters) {
        return getFacade().countByDataFilters(filters);
    }
    
    public List<T> getListaFiltrada(int first, int pageSize, Map<String, Object> filters) {
        return getFacade().findByDataFilters(filters, first, pageSize);
    }
}
