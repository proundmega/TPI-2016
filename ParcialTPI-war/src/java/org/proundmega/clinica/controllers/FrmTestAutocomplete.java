package org.proundmega.clinica.controllers;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.inject.Named;
import javax.enterprise.context.RequestScoped;
import sv.ues.edu.tpi2016.clinica.entities.TipoCentro;
import sv.ues.edu.tpi2016.clinica.gateway.TipoCentroFacadeLocal;

@Named(value = "frmTestAutocomplete")
@RequestScoped
public class FrmTestAutocomplete {
    private TipoCentro tipoCentroSeleccionado;
    private List<TipoCentro> tiposCentro;
    private List<TipoCentro> tiposValidos;
    
    @EJB
    private TipoCentroFacadeLocal facade;
    
    @PostConstruct
    public void init() {
        tiposCentro = facade.findAll();
    }
    
    public List<TipoCentro> getFiltroBasico(String filtro) {
        tiposValidos = new ArrayList<>();
        for(TipoCentro tipoCentro : tiposCentro) {
            if(tipoCentro.getNombre().toLowerCase().startsWith(filtro)) {
                tiposValidos.add(tipoCentro);
            }
        }
        return tiposValidos;
    }

    public TipoCentro getTipoCentroSeleccionado() {
        return tipoCentroSeleccionado;
    }

    public void setTipoCentroSeleccionado(TipoCentro tipoCentroSeleccionado) {
        this.tipoCentroSeleccionado = tipoCentroSeleccionado;
    }

    public List<TipoCentro> getTiposCentro() {
        return tiposCentro;
    }
    
    public void logIngreso() {
        System.out.println(tipoCentroSeleccionado);
    }

    public List<TipoCentro> getTiposValidos() {
        return tiposValidos;
    }

    public void setTiposValidos(List<TipoCentro> tiposValidos) {
        this.tiposValidos = tiposValidos;
    }
    
}
