/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package sv.edu.uesocc.ingenieria.tpi135_2016.clinica.presentacion.web.paginas.backing;

import org.primefaces.model.LazyDataModel;
import sv.edu.uesocc.ingenieria.tpi135_2016.clinica.datos.acceso.AbstractFacadeInterface;

public abstract class DefaultGenerador<T> {
    protected LazyDataModel<T> modelo;
    protected T registro;
    protected int tamanioPagina = 5;
    protected boolean mostrarDetalle;
    
    public DefaultGenerador() {
        generarModeloTabla();
        generarListas();
        mostrarDetalle = false;
    }
    
    public void generarListas() {
        
    }
    
    public abstract AbstractFacadeInterface<T> getFacade();
    
    public LazyDataModel<T> getModelo() {
        return modelo;
    }
    
    public abstract T crearRegistro();
    
    public abstract T crearNuevo();
    
    public abstract void generarModeloTabla();

    public T getRegistro() {
        return registro;
    }

    public int getTamanioPagina() {
        return tamanioPagina;
    }

    public boolean isMostrarDetalle() {
        return mostrarDetalle;
    }

    public void setRegistro(T registro) {
        this.registro = registro;
    }

    public void setMostrarDetalle(boolean mostrarDetalle) {
        this.mostrarDetalle = mostrarDetalle;
    }
    
    public void crearNuevoRegistro() {
        setMostrarDetalle(true);
        registro = crearNuevo();
    }
    
    public void borrarSeleccionado() {
        if(getFacade().eliminar(registro)){
            System.out.println("Cool borre algo :)");
        }
        else{
            System.out.println("No pude borrar nada");
        }
    }
}

