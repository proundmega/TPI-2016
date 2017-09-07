/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sv.edu.tpi.clinica.acceso;

import java.util.List;
import javax.ejb.Local;
import sv.edu.uesocc.ingenieria.tpi135_2016.clinica.datos.definiciones.TipoCentro;

/**
 *
 * @author sakshi
 */
@Local
public interface TipoCentroFacadeLocal extends BaseFacade<TipoCentro>{

    @Override
    void create(TipoCentro tipoCentro);

    @Override
    void edit(TipoCentro tipoCentro);

    @Override
    void remove(TipoCentro tipoCentro);

    @Override
    TipoCentro find(Object id);

    @Override
    List<TipoCentro> findAll();

    @Override
    List<TipoCentro> findRange(int[] range);

    @Override
    int count();
    
}
