/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sv.ues.edu.tpi2016.clinica.gateway;

import java.util.List;
import javax.ejb.Local;
import sv.ues.edu.tpi2016.clinica.entities.TipoCentro;

/**
 *
 * @author sakshi
 */
@Local
public interface TipoCentroFacadeLocal {

    void create(TipoCentro tipoCentro);

    void edit(TipoCentro tipoCentro);

    void remove(TipoCentro tipoCentro);

    TipoCentro find(Object id);

    List<TipoCentro> findAll();

    List<TipoCentro> findRange(int[] range);

    int count();
    
}
