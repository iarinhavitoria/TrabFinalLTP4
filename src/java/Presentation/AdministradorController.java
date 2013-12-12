/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Presentation;

import DomainModel.Administrador;
import DomainModel.IAdministradorRepositorio;
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
 * @author Rosy
 */
@Named(value = "administradorController")
@SessionScoped
public class AdministradorController {
    Administrador entidade;
    Administrador filtro;
    List<Administrador> lista;
    @EJB
    IAdministradorRepositorio dao;

    /**
* Creates a new instance of AdministradorController
*/
    public AdministradorController() {
        entidade = new Administrador();
        filtro = new Administrador();
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

    public String autenticar(){
        if("adm".equals(entidade.getUsuarioAdmin())){
            if ("1234".equals(entidade.getSenhaAdmin())){
                return "TemplateGeral.xhtml";
            }
        } else {
            exibirMensagem("Dados nao correspondem!");
            return "Login1.xhtml";
        }
        return null;
    }
    
    public void salvar() {
        dao.Salvar(entidade);
        lista = null;
        exibirMensagem("Salvo!");
    }

    public String editar() {
        return "AdministradorEditar.xhtml";
    }

    public String criar() {
        entidade = new Administrador();
        return "AdministradorEditar.xhtml";
    }

    public String apagar() {
        dao.Apagar(entidade);
        lista = null;
        exibirMensagem("Pronto!");
        return "AdministradorListar.xhtml";
    }

    public String filtrar() {
        lista = dao.Buscar(filtro);
        return "AdministradorListar";
    }

    public String voltar() {
        lista =null;
        return "AdministradorListar.xhtml";
    }

    public Administrador getEntidade() {
        return entidade;
    }

    public void setEntidade(Administrador entidade) {
        this.entidade = entidade;
    }

    public List<Administrador> getListagem() {
        if (lista == null) {
            Administrador filtro = new Administrador();
            lista = dao.Buscar(filtro);
        }
        return lista;
    }

    public void setListagem(List<Administrador> listagem) {
        this.lista = listagem;
    }

    public Administrador getFiltro() {
        return filtro;
    }

    public void setFiltro(Administrador filtro) {
        this.filtro = filtro;
    }
    
    

}
