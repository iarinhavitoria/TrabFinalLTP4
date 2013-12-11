/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Presentation;

import DomainModel.IProdutoRepositorio;
import DomainModel.Produto;
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

public class ProdutoController implements Serializable{
    Produto entidade;
    Produto filtro;
    List<Produto> lista;
    @EJB
    IProdutoRepositorio dao;

    /**
* Creates a new instance of ProdutoController
*/
    public ProdutoController() {
        entidade = new Produto();
        filtro = new Produto();
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

    public List<Produto> autoCompletar(String tmp){
        Produto c = new Produto();
        c.setIdProduto(Long.parseLong(tmp));
        return dao.Buscar(c);
    }
    
    
    public String editar() {
        return "ProdutoEditar.xhtml";
    }

    public String criar() {
        entidade = new Produto();
        return "ProdutoEditar.xhtml";
    }

    public String apagar() {
        dao.Apagar(entidade);
        lista = null;
        exibirMensagem("Pronto!");
        return "ProdutoListar.xhtml";
    }

    public String filtrar() {
        lista = dao.Buscar(filtro);
        return "ProdutoListar";
    }

    public String voltar() {
        lista =null;
        return "ProdutoListar.xhtml";
    }

    public Produto getEntidade() {
        return entidade;
    }

    public void setEntidade(Produto entidade) {
        this.entidade = entidade;
    }

    public List<Produto> getListagem() {
        if (lista == null) {
            Produto filtro = new Produto();
            lista = dao.Buscar(filtro);
        }
        return lista;
    }

    public void setListagem(List<Produto> listagem) {
        this.lista = listagem;
    }

    public Produto getFiltro() {
        return filtro;
    }

    public void setFiltro(Produto filtro) {
        this.filtro = filtro;
    }
    
}
