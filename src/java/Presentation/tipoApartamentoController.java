/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Presentation;

import DomainModel.ITipoApartamentoRepositorio;
import DomainModel.TipoApartamento;
import java.io.Serializable;
import java.util.List;
import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.component.UIComponent;
import javax.faces.component.UIInput;
import javax.faces.context.FacesContext;


/**
 *
 * @author iara
 */

@ManagedBean
@SessionScoped

public class tipoApartamentoController implements Serializable {
    TipoApartamento entidade;
    TipoApartamento filtro;
    List<TipoApartamento> lista;
    @EJB
    ITipoApartamentoRepositorio dao;

    /**
* Creates a new instance of TipoApartamentoController
*/
    public tipoApartamentoController() {
        entidade = new TipoApartamento();
        filtro = new TipoApartamento();
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
        return "TipoApartamentoEditar.xhtml";
    }

    public String criar() {
        entidade = new TipoApartamento();
        return "TipoApartamentoEditar.xhtml";
    }

    public String apagar() {
        dao.Apagar(entidade);
        lista = null;
        exibirMensagem("Pronto!");
        return "TipoApartamentoListar.xhtml";
    }

    public String filtrar() {
        lista = dao.Buscar(filtro);
        return "TipoApartamentoListar";
    }

    public String voltar() {
        lista =null;
        return "TipoApartamentoListar.xhtml";
    }

    public TipoApartamento getEntidade() {
        return entidade;
    }

    public void setEntidade(TipoApartamento entidade) {
        this.entidade = entidade;
    }

    public List<TipoApartamento> getLista() {
        if (lista == null) {
            TipoApartamento filtro = new TipoApartamento();
            lista = dao.Buscar(filtro);
        }
        return lista;
    }

    public void setLista(List<TipoApartamento> listagem) {
        this.lista = listagem;
    }

    public TipoApartamento getFiltro() {
        return filtro;
    }

    public void setFiltro(TipoApartamento filtro) {
        this.filtro = filtro;
    }
}
