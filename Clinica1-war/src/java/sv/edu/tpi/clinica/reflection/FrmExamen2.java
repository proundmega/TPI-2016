/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sv.edu.tpi.clinica.reflection;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.inject.Named;
import javax.faces.view.ViewScoped;
import org.primefaces.model.LazyDataModel;
import org.primefaces.model.SortOrder;
import sv.edu.uesocc.ingenieria.tpi135_2016.clinica.datos.acceso.ExamenFacadeLocal;
import sv.edu.uesocc.ingenieria.tpi135_2016.clinica.datos.definiciones.Examen;

/**
 *
 * @author sakshi
 */
@Named
@ViewScoped
public class FrmExamen2 implements Serializable{
    private LazyDataModel<Examen> modelo;
    private Examen elementoSeleccionado;
    
    @EJB
    private ExamenFacadeLocal examenFacade;
    
    @PostConstruct
    public void init() {
        this.modelo = new LazyDataModel<Examen>() {

            @Override
            public Object getRowKey(Examen object) {
                if (object != null) {
                    return object.getIdExamen();
                }
                return null;
            }

            @Override
            public Examen getRowData(String rowKey) {
                if (rowKey != null && !rowKey.trim().isEmpty() && this.getWrappedData() != null) {
                    try {
                        Long buscado = new Long(rowKey);
                        for (Examen reg : ((List<Examen>) this.getWrappedData())) {
                            if (reg.getIdExamen().compareTo(buscado) == 0) {
                                return reg;
                            }
                        }
                    } catch (Exception ex) {
                        Logger.getLogger(getClass().getName()).log(Level.SEVERE, ex.getMessage(), ex);
                    }
                }
                return null;
            }

            @Override
            public List<Examen> load(int first, int pageSize, String sortField, SortOrder sortOrder, Map<String, Object> filters) {
                List salida = new ArrayList();
                System.out.println(filters);
                try {
                    if (examenFacade != null) {
                        if (filters != null && !filters.isEmpty()) {
                            salida = examenFacade.findByDataFilters(filters, first, pageSize);
                            this.setRowCount(examenFacade.countByDataFilters(filters));
                        } else {
                            salida = examenFacade.findRango(first, pageSize);
                            this.setRowCount(examenFacade.count());
                        }
                    }
                } catch (Exception ex) {
                    Logger.getLogger(getClass().getName()).log(Level.SEVERE, ex.getMessage(), ex);
                }
                return salida;
            }

        };
    }

    public Examen getElementoSeleccionado() {
        return elementoSeleccionado;
    }

    public LazyDataModel<Examen> getModelo() {
        return modelo;
    }
    
}
