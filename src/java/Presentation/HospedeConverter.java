/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Presentation;

import DomainModel.Hospede;
import DomainModel.IHospedeRepositorio;
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
@Named(value = "hospedeConverter")
@SessionScoped
public class HospedeConverter implements Serializable, Converter {

    @EJB
    IHospedeRepositorio dao;

    public HospedeConverter() {
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
            Hospede h = (Hospede) value;
            return h.getIdHospede().toString();
        }
    }

    public IHospedeRepositorio getDao() {
        return dao;
    }

    public void setDao(IHospedeRepositorio dao) {
        this.dao = dao;
    }
}

    

