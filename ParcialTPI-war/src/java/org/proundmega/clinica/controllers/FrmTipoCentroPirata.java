package org.proundmega.clinica.controllers;

import java.io.Serializable;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.enterprise.context.Conversation;
import javax.enterprise.context.ConversationScoped;
import javax.inject.Inject;
import javax.inject.Named;
import org.primefaces.model.SelectableDataModel;
import sv.ues.edu.tpi2016.clinica.entities.TipoCentro;
import sv.ues.edu.tpi2016.clinica.gateway.TipoCentroFacadeLocal;

@ConversationScoped
public class FrmTipoCentroPirata implements SelectableDataModel<TipoCentro>, Serializable{
    private List<TipoCentro> tipoCentros;
    private TipoCentro tipoSeleccionado;
    private boolean mostrarForm;
    
    @EJB
    private TipoCentroFacadeLocal facade;
    
    @Inject
    private Conversation conversation;
    
    @PostConstruct
    public void init() {
        tipoCentros = facade.findAll();
        tipoSeleccionado = new TipoCentro();
        mostrarForm = false;
        conversation.begin();
    }

    public List<TipoCentro> getTipoCentros() {
        return tipoCentros;
    }

    public TipoCentro getTipoSeleccionado() {
        return tipoSeleccionado;
    }

    public void setTipoCentros(List<TipoCentro> tipoCentros) {
        this.tipoCentros = tipoCentros;
    }

    public void setTipoSeleccionado(TipoCentro tipoSeleccionado) {
        this.tipoSeleccionado = tipoSeleccionado;
    }
    
    @Override
    public Object getRowKey(TipoCentro t) {
        return t.getIdTipoCentro();
    }

    @Override
    public TipoCentro getRowData(String string) {
        int id = Integer.valueOf(string);
        return facade.find(id);
    }
    
    public boolean mostrarFormulario() {
        return mostrarForm;
    }

    public void setMostrarForm(boolean mostrarForm) {
        this.mostrarForm = mostrarForm;
    }
    
    public String guardarCambios() {
        facade.edit(tipoSeleccionado);
        update();
        return "";
    }
    
    public void borrarRegistro(TipoCentro tipoCentro) {
        facade.remove(tipoSeleccionado);
        update();
    }
    
    public void update() {
        tipoCentros = facade.findAll();
    }
}
