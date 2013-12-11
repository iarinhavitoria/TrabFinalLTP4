/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Presentation;

import DomainModel.Funcao;
import DomainModel.IFuncaoRepositorio;
import java.io.Serializable;
import javax.ejb.EJB;
import javax.faces.bean.SessionScoped;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.inject.Named;

/**
 *
 * @author Rosy
 */
@Named(value = "funcaoConverter")
@SessionScoped
public class FuncaoConverter implements Serializable, Converter {

    @EJB
    IFuncaoRepositorio dao;

    public FuncaoConverter() {
    }

    @Override
    public Object getAsObject(FacesContext context, UIComponent component, String value) {
        if (value == null || value.trim().equals("")) {
            return null;
        } else {
            Long id = Long.parseLong(value);
            return dao.Abrir(id);
        }
    }

    @Override
    public String getAsString(FacesContext context, UIComponent component, Object value) {
        if (value == null || value.toString().equals("")) {
            return "";
        } else {
            Funcao f = (Funcao) value;
            return f.getIdFuncao().toString();
        }
    }
}

    

