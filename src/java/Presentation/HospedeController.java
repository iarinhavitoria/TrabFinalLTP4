/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Presentation;

import DomainModel.Hospede;
import DomainModel.IHospedeRepositorio;
import java.io.Serializable;
import java.util.List;
import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.bean.SessionScoped;
import javax.faces.component.UIComponent;
import javax.faces.component.UIInput;
import javax.faces.context.FacesContext;
import javax.inject.Named;

/**
 *
 * @author iara
 */
@Named(value = "hospedeController")
@SessionScoped
public class HospedeController implements Serializable{
    Hospede entidade;
    Hospede filtro;
    List<Hospede> lista;
    @EJB
    IHospedeRepositorio dao;

    /**
* Creates a new instance of HospedeController
*/
    public HospedeController() {
        entidade = new Hospede();
        filtro = new Hospede();
    }

    public void validarEspacoEmBranco(FacesContext contexto, UIComponent componente, Object valor) {
        String valorString = (String) valor;
        if (valorString.trim().equals("")) {
            ((UIInput) componente).setValid(false);
            String mensagem = componente.getAttributes().get("label")
                    + ":Não é permitido espaço em branco. ";
            FacesMessage facesMessage = new FacesMessage(FacesMessage.SEVERITY_ERROR, mensagem, mensagem);
            contexto.addMessage(componente.getClientId(contexto), facesMessage);
        }

    }

    public void exibirMensagem(String msg) {
        FacesContext context = FacesContext.getCurrentInstance();
        context.addMessage(null, new FacesMessage(msg));
    }

    public void salvar() {
        dao.Salvar(entidade);
        lista = null;
        exibirMensagem("Salvo!");
    }

    public String editar() {
        return "HospedeCadastrar.xhtml";
    }

    public String criar() {
        entidade = new Hospede();
        return "HospedeCadastrar.xhtml";
    }

    public String apagar() {
        dao.Apagar(entidade);
        lista = null;
        exibirMensagem("Pronto!");
        return "HospedeListar.xhtml";
    }

    public String filtrar() {
        lista = dao.Buscar(filtro);
        return "HospedeListar";
    }

    public String voltar() {
        lista =null;
        return "HospedeListar.xhtml";
    }

    public Hospede getEntidade() {
        return entidade;
    }

    public void setEntidade(Hospede entidade) {
        this.entidade = entidade;
    }

    public List<Hospede> getListagem() {
        if (lista == null) {
            Hospede filtro = new Hospede();
            lista = dao.Buscar(filtro);
        }
        return lista;
    }

    public void setListagem(List<Hospede> listagem) {
        this.lista = listagem;
    }

    public Hospede getFiltro() {
        return filtro;
    }

    public void setFiltro(Hospede filtro) {
        this.filtro = filtro;
    }
    
}
