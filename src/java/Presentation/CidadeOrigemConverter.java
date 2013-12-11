/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Presentation;

import DataAcess.CidadeOrigemDAO;
import java.io.Serializable;
import javax.ejb.EJB;
import javax.ejb.Local;
import javax.faces.bean.SessionScoped;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.inject.Named;

/**
 *
 * @author Rosy
 */

@Named(value = "cidadeOrigemConverter")
@SessionScoped
public class CidadeOrigemConverter implements Serializable, Converter {
    @EJB
    CidadeOrigemDAO daoCidadeOrigem;
    private Object daoLocal;

    /**
     * Creates a new instance of LocalConverter
     */
    public CidadeOrigemConverter() {
    }

    @Override
    public Object getAsObject(FacesContext context, UIComponent component, String value) {
        if (value == null || value.trim().equals("")) {
            return null;
        } else {
            Long id = Long.parseLong(value);
            return daoCidadeOrigem.Abrir(id);
        }
    }

    @Override
    public String getAsString(FacesContext context, UIComponent component, Object value) {
        if (value == null || value.toString().equals("")) {
            return "";
        } else {
            Local l = (Local) value;
            return l.getClass().toString();
        }
    }
}
