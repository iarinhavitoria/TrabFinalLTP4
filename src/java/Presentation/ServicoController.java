/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Presentation;

import DomainModel.IServicoRepositorio;
import DomainModel.Servico;
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
@Named(value = "servicoController")
@SessionScoped

public class ServicoController implements Serializable {
    Servico entidade;
    Servico filtro;
    List<Servico> lista;
    @EJB
    IServicoRepositorio dao;

    /**
* Creates a new instance of ServicoController
*/
    public ServicoController() {
        entidade = new Servico();
        filtro = new Servico();
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
        return "ServicoCadastrar.xhtml";
    }

    public String criar() {
        entidade = new Servico();
        return "ServicoCadastrar.xhtml";
    }

    public String apagar() {
        dao.Apagar(entidade);
        lista = null;
        exibirMensagem("Pronto!");
        return "ServicoListar.xhtml";
    }

    public String filtrar() {
        lista = dao.Buscar(filtro);
        return "ServicoListar";
    }

    public String voltar() {
        lista =null;
        return "ServicoListar.xhtml";
    }

    public Servico getEntidade() {
        return entidade;
    }

    public void setEntidade(Servico entidade) {
        this.entidade = entidade;
    }

    public List<Servico> getLista() {
        if (lista == null) {
            Servico filtro = new Servico();
            lista = dao.Buscar(filtro);
        }
        return lista;
    }

    public void setLista(List<Servico> lista) {
        this.lista = lista;
    }

    public Servico getFiltro() {
        return filtro;
    }

    public void setFiltro(Servico filtro) {
        this.filtro = filtro;
    }
}
