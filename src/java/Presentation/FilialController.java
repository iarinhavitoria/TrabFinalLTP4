/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Presentation;

import DomainModel.Filial;
import DomainModel.IFilialRepositorio;
import java.io.Serializable;
import java.util.List;
import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.component.UIComponent;
import javax.faces.component.UIInput;
import javax.faces.context.FacesContext;
import javax.inject.Named;

/**
 *
 * @author iara
 */
@ManagedBean
@SessionScoped
@Named(value = "filialController")

public class FilialController implements Serializable{
    Filial entidade;
    Filial filtro;
    List<Filial> lista;
    @EJB
    IFilialRepositorio dao;

    /**
* Creates a new instance of FilialController
*/
    public FilialController() {
        entidade = new Filial();
        filtro = new Filial();
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
        return "FilialEditar.xhtml";
    }

    public String criar() {
        entidade = new Filial();
        return "FilialEditar.xhtml";
    }

    public String apagar() {
        dao.Apagar(entidade);
        lista = null;
        exibirMensagem("Pronto!");
        return "FilialListar.xhtml";
    }

    public String filtrar() {
        lista = dao.Buscar(filtro);
        return "FilialListar";
    }

    public String voltar() {
        lista =null;
        return "FilialListar.xhtml";
    }

    public Filial getEntidade() {
        return entidade;
    }

    public void setEntidade(Filial entidade) {
        this.entidade = entidade;
    }

    public List<Filial> getListagem() {
        if (lista == null) {
            Filial filtro = new Filial();
            lista = dao.Buscar(filtro);
        }
        return lista;
    }

    public void setListagem(List<Filial> listagem) {
        this.lista = listagem;
    }

    public Filial getFiltro() {
        return filtro;
    }

    public void setFiltro(Filial filtro) {
        this.filtro = filtro;
    }
    
    
}
