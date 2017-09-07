package org.proundmega.clinica.mvc;

import java.util.List;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.view.ViewScoped;
import javax.inject.Named;
import sv.ues.edu.tpi2016.clinica.entities.TipoCentro;
import sv.ues.edu.tpi2016.clinica.gateway.TipoCentroFacadeLocal;

@Named
@ViewScoped
public class FrmTipoCentro extends BaseController<TipoCentro>{
    
    @EJB
    private TipoCentroFacadeLocal facade;
    
    @PostConstruct
    public void init() {
        modelo = new BasiLazyDataModel();
        elementoSeleccionado = new TipoCentro();
    }

    @Override
    protected Object getIdObjeto(TipoCentro objeto) {
        return objeto.getIdTipoCentro();
    }

    @Override
    protected int getCountObjetos() {
        return facade.count();
    }

    @Override
    protected List<TipoCentro> findRange(int[] range) {
        return facade.findRange(range);
    }

    @Override
    protected boolean isKeyOf(Integer key, TipoCentro object) {
        return object.getIdTipoCentro().equals(key);
    }
    
    public void printSeleccionado() {
        System.out.println("Hola mundo: " + getElementoSeleccionado());
    }
}
