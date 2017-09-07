package sv.edu.tpi.clinica.visual.controller;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.view.ViewScoped;
import javax.inject.Named;
import sv.edu.tpi.clinica.acceso.BaseFacade;
import sv.edu.tpi.clinica.acceso.TipoCentroFacadeLocal;
import sv.edu.uesocc.ingenieria.tpi135_2016.clinica.datos.definiciones.TipoCentro;

@Named
@ViewScoped
public class TipoCentroController extends BaseController<TipoCentro>{

    @EJB
    private TipoCentroFacadeLocal tipoCentroFacade;
    
    @Override
    @PostConstruct
    public void init() {
        super.init();
    }
    
    @Override
    protected BaseFacade getFacade() {
        return tipoCentroFacade;
    }

    @Override
    protected Class<TipoCentro> getClassBase() {
        return TipoCentro.class;
    }

}
