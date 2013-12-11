/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Presentation;

import DomainModel.Apartamento;
import DomainModel.IApartamentoRepositorio;
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
@Named(value = "apartamentoController")
@ManagedBean
@SessionScoped
public class ApartamentoController implements Serializable{
    Apartamento entidade;
    Apartamento filtro;
    List<Apartamento> lista;
    @EJB
    IApartamentoRepositorio dao;

    /**
* Creates a new instance of ApartamentoController
*/
    public ApartamentoController() {
        entidade = new Apartamento();
        filtro = new Apartamento();
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
        return "ApartamentoEditar.xhtml";
    }

    public String criar() {
        entidade = new Apartamento();
        return "ApartamentoEditar.xhtml";
    }

    public String apagar() {
        dao.Apagar(entidade);
        lista = null;
        exibirMensagem("Pronto!");
        return "ApartamentoListar.xhtml";
    }

    public String filtrar() {
        lista = dao.Buscar(filtro);
        return "ApartamentoListar";
    }

    public String voltar() {
        lista =null;
        return "ApartamentoListar.xhtml";
    }

    public Apartamento getEntidade() {
        return entidade;
    }

    public void setEntidade(Apartamento entidade) {
        this.entidade = entidade;
    }

    public List<Apartamento> getListagem() {
        if (lista == null) {
            Apartamento filtro = new Apartamento();
            lista = dao.Buscar(filtro);
        }
        return lista;
    }

    public void setListagem(List<Apartamento> listagem) {
        this.lista = listagem;
    }

    public Apartamento getFiltro() {
        return filtro;
    }

    public void setFiltro(Apartamento filtro) {
        this.filtro = filtro;
    }
    
    
}
