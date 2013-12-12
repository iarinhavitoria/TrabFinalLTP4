/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Presentation;

import DomainModel.Administrador;
import DomainModel.IAdministradorRepositorio;
import java.io.Serializable;
import java.util.Enumeration;
import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
//import javax.inject.Named;
import javax.servlet.http.HttpSession;

/**
 *
 * @author Rosy
 */
//@Named(value = "autenticacaoController")
@ManagedBean
@SessionScoped
public class AutenticacaoController implements Serializable {

    /**
     * Creates a new instance of AutenticacaoController
     */
    public AutenticacaoController() {
    
    }
    @EJB
    IAdministradorRepositorio dao;
    private String login, senha;
    Administrador usuario;

    
    public void Mensagem(String msg) {
        FacesContext context = FacesContext.getCurrentInstance();
        context.addMessage(null, new FacesMessage(msg));
    }
    
    public String validar() {
        try {
        usuario = dao.fazerLogin(login);

        if (usuario == null) {
            Mensagem("Dados não correspondem");
            return "Login1.xhtml";
        } else {
            if (senha.equals(usuario.getSenhaAdmin())) {

                HttpSession session;

                FacesContext ctx = FacesContext.getCurrentInstance();
                session = (HttpSession) ctx.getExternalContext().getSession(false);
                session.setAttribute("usuarioAutenticado", usuario);

                return "TelaPrincipal.xhtml";
            } else {
                Mensagem("Dados não correspondem");
                return "Login1.xhtml";
            }
        }
        } catch(Exception ex){
            Mensagem("Dados não correspondem");
            return "Login1.xhtml";
        }

    }
    
    public String autenticar(){
        if(login=="adm" && senha=="1234"){
            return "TelaPrincipal.xhtml";
        } else {
            return "Login1.xhtml";
        }
    }

    public String logout() {
        HttpSession session;

        FacesContext ctx = FacesContext.getCurrentInstance();
        session = (HttpSession) ctx.getExternalContext().getSession(false);
        session.setAttribute("usuarioAutenticado", null);

       // AppendLog("Logout");
        
        Enumeration<String> vals = session.getAttributeNames(); 
        
        while(vals.hasMoreElements()){
            session.removeAttribute(vals.nextElement());
        }

        return "Login1.xhtml";

    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public Administrador getUsuario() {
        return usuario;
    }

    public void setUsuario(Administrador usuario) {
        this.usuario = usuario;
    }
    
}
