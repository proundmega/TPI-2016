package sv.edu.tpi.clinica.reflection;

import java.lang.annotation.Annotation;
import java.lang.reflect.Field;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;

public class FilterColumn {
    private Class<?> class1;
    
    public FilterColumn(@NotNull Class class1) {
        this.class1 = class1;
        validarSiEsEntinty();
    }
    
    private void validarSiEsEntinty() {
        if(noContieneNotacionEntity()) {
            throw new IllegalArgumentException("Esta clase no es una entity de JPA");
        }
    }
    
    private boolean noContieneNotacionEntity() {
        return !Stream.of(class1.getAnnotations())
                .anyMatch(annotation -> annotation.annotationType() == Entity.class);
    }
    
    public List<Field> getCamposConColumn() {
        Stream<Field> fields = Stream.of(class1.getDeclaredFields());
        return fields.filter(this::contieneNotacionColumn)
                .collect(Collectors.toList());
    }
    
    private boolean contieneNotacionColumn(Field campo) {
        return contieneNotacion(campo, Column.class);
    }
    
    private boolean contieneNotacion(Field campo, Class<?> classTest) {
        return Stream.of(campo.getAnnotations())
                .map(Annotation::annotationType)
                .anyMatch(clazz -> clazz == classTest);
    }
    
    public Field getCampoConId() {
        Stream<Field> fields = Stream.of(class1.getDeclaredFields());
        return fields.filter(this::contieneNotacionId)
                .findFirst()
                .orElseThrow(NullPointerException::new);
    }
    
    private boolean contieneNotacionId(Field campo) {
        return contieneNotacion(campo, Id.class) || contieneNotacion(campo, EmbeddedId.class);
    }
    
}
