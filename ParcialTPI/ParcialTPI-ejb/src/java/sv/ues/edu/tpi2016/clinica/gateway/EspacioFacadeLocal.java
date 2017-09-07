/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sv.ues.edu.tpi2016.clinica.gateway;

import java.util.List;
import javax.ejb.Local;
import sv.ues.edu.tpi2016.clinica.entities.Espacio;

/**
 *
 * @author sakshi
 */
@Local
public interface EspacioFacadeLocal {

    void create(Espacio espacio);

    void edit(Espacio espacio);

    void remove(Espacio espacio);

    Espacio find(Object id);

    List<Espacio> findAll();

    List<Espacio> findRange(int[] range);

    int count();
    
}
