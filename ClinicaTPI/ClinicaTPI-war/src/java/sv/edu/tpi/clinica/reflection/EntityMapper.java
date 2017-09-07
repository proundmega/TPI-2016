package sv.edu.tpi.clinica.reflection;

import java.lang.reflect.Field;
import java.util.HashMap;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.stream.Collectors;
import javax.validation.constraints.NotNull;
import sv.edu.tpi.clinica.visual.controller.BaseController;

public class EntityMapper<T> {
    private final Class<T> clazz;
    private Field campoId;
    private final FilterColumn filterColumn;

    public EntityMapper(Class<T> clazz) {
        this.clazz = clazz;
        filterColumn = new FilterColumn(clazz);
        prepararCampoId();
    }
    
    private void prepararCampoId() {
        campoId = filterColumn.getCampoConId();
        campoId.setAccessible(true);
    }
    
    public List<String> getListaPropiedadesConNotacionColumn() {
        return filterColumn
                .getCamposConColumn()
                .stream()
                .map(Field::getName)
                .collect(Collectors.toList());
    }
    
    public Object getPropiedad(@NotNull T objeto, @NotNull String propiedad) {
        try {
            
            Field declaredField = clazz.getDeclaredField(propiedad);
            declaredField.setAccessible(true);
            return declaredField.get(objeto);
            
        } catch (NoSuchFieldException | SecurityException | IllegalArgumentException | IllegalAccessException ex) {
            Logger.getLogger(EntityMapper.class.getName()).log(Level.SEVERE, null, ex);
            
            throw new UnsupportedOperationException("No pude acceder a la propiedad "
                    + propiedad + " del objeto " + objeto, ex);
        }
    }
    
    public Object getIdObjeto(@NotNull T objeto) {
        try {
            
            return campoId.get(objeto);
            
        } catch (IllegalArgumentException | IllegalAccessException ex) {
            
            Logger.getLogger(BaseController.class.getName()).log(Level.SEVERE, null, ex);
            throw new UnsupportedOperationException("No se pudo obtener el id del objeto", ex);
            
        }
    }
    
    public T nuevaInstanciaEntity() {
        try {
            
            return clazz.newInstance();
            
        } catch (InstantiationException | IllegalAccessException ex) {
            
            Logger.getLogger(EntityMapper.class.getName()).log(Level.SEVERE, null, ex);
            throw new UnsupportedOperationException("No se pudo crear una instancia de la clase " + clazz.getName(), ex);
            
        }
    }
    
    public boolean isIdDelObjeto(String key, T object) {
        return getIdObjeto(object).toString().equals(key);
    }
}
