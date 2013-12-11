/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Presentation;

import DomainModel.ITipoServicoRepositorio;
import DomainModel.TipoServico;
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
@Named(value = "tipoServicoController")
@SessionScoped
public class tipoServicoController implements Serializable {
    TipoServico entidade;
    TipoServico filtro;
    List<TipoServico> lista;
    @EJB
    ITipoServicoRepositorio dao;

    /**
* Creates a new instance of TipoServicoController
*/
    public tipoServicoController() {
        entidade = new TipoServico();
        filtro = new TipoServico();
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
        return "TipoServicoEditar.xhtml";
    }

    public String criar() {
        entidade = new TipoServico();
        return "TipoServicoEditar.xhtml";
    }

    public String apagar() {
        dao.Apagar(entidade);
        lista = null;
        exibirMensagem("Pronto!");
        return "TipoServicoListar.xhtml";
    }

    public String filtrar() {
        lista = dao.Buscar(filtro);
        return "TipoServicoListar";
    }

    public String voltar() {
        lista =null;
        return "TipoServicoListar.xhtml";
    }

    public TipoServico getEntidade() {
        return entidade;
    }

    public void setEntidade(TipoServico entidade) {
        this.entidade = entidade;
    }

    public List<TipoServico> getLista() {
        if (lista == null) {
            TipoServico filtro = new TipoServico();
            lista = dao.Buscar(filtro);
        }
        return lista;
    }

    public void setLista(List<TipoServico> listagem) {
        this.lista = listagem;
    }

    public TipoServico getFiltro() {
        return filtro;
    }

    public void setFiltro(TipoServico filtro) {
        this.filtro = filtro;
    }
}
