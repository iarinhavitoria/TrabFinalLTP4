/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Presentation;

import DomainModel.CidadeOrigem;
import DomainModel.ICidadeOrigemRepositorio;
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
@Named(value = "cidadeOrigemController")
@ManagedBean
@SessionScoped
public class CidadeOrigemController implements Serializable{
    CidadeOrigem entidade;
    CidadeOrigem filtro;
    List<CidadeOrigem> lista;
    @EJB
    ICidadeOrigemRepositorio dao;

    /**
* Creates a new instance of CidadeOrigemController
*/
    public CidadeOrigemController() {
        entidade = new CidadeOrigem();
        filtro = new CidadeOrigem();
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
        return "CidadeOrigem.xhtml";
    }

    public String criar() {
        entidade = new CidadeOrigem();
        return "CidadeOrigem.xhtml";
    }

    public String apagar() {
        dao.Apagar(entidade);
        lista = null;
        exibirMensagem("Pronto!");
        return "CidadeOrigemListar.xhtml";
    }

    public String filtrar() {
        lista = dao.Buscar(filtro);
        return "CidadeOrigemListar";
    }

    public String voltar() {
        lista =null;
        return "CidadeOrigemListar.xhtml";
    }

    public CidadeOrigem getEntidade() {
        return entidade;
    }

    public void setEntidade(CidadeOrigem entidade) {
        this.entidade = entidade;
    }

    public List<CidadeOrigem> getLista() {
        if (lista == null) {
            CidadeOrigem filtro = new CidadeOrigem();
            lista = dao.Buscar(filtro);
        }
        return lista;
    }

    public void setLista(List<CidadeOrigem> listagem) {
        this.lista = listagem;
    }

    public CidadeOrigem getFiltro() {
        return filtro;
    }

    public void setFiltro(CidadeOrigem filtro) {
        this.filtro = filtro;
    }
    
    
}
