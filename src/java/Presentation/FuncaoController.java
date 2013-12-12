/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Presentation;

import DomainModel.Funcao;
import DomainModel.IFuncaoRepositorio;
import java.io.IOException;
import java.io.Serializable;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.component.UIComponent;
import javax.faces.component.UIInput;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;
//import javax.inject.Named;


/**
 *
 * @author iara
 */
//@Named(value = "funcaoController")
@ManagedBean
@SessionScoped
public class FuncaoController implements Serializable {
    Funcao entidade;
    Funcao filtro;
    List<Funcao> lista;
    @EJB
    IFuncaoRepositorio dao;

    /**
* Creates a new instance of FuncaoController
*/
    public FuncaoController() {
        entidade = new Funcao();
        filtro = new Funcao();
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
    
    public void XLS(java.awt.event.ActionEvent actionEvent) throws JRException, IOException {
        Connection conn;
        String arquivo = FacesContext.getCurrentInstance().getExternalContext().getRealPath("/relatorio/Funcoes Cadastradas.jasper");
        try {

            Class.forName("org.apache.derby.jdbc.ClientDriver");
            conn = DriverManager.getConnection("jdbc:derby://localhost:1527/TrabalhoFinal [adm em ADM]");
            java.sql.Statement sql = conn.createStatement();
            ResultSet rs = sql.executeQuery("     \"ADM\".\"FUNCAO\" FUNCAO" +
                    "SELECT\n" +
                    "     FUNCAO.\"IDFUNCAO\" AS FUNCAO_IDFUNCAO,\n" +
                    "     FUNCAO.\"HORASSEMANAIS\" AS FUNCAO_HORASSEMANAIS,\n" +
                    "     FUNCAO.\"NOME\" AS FUNCAO_NOME\n" +
                    "FROM\n");
            JRDataSource ds = new JRResultSetDataSource(rs);
            JasperPrint jasperPrint = JasperFillManager.fillReport(arquivo, null, ds);

         ttpServletResponse httpServletResponse = (HttpServletResponse)     FacesContext.getCurrentInstance().getExternalContext().getResponse();
        httpServletResponse.addHeader("Content-disposition", "attachment; filename= relatorioController.XLS");
        ServletOutputStream servletOutputStream = httpServletResponse.getOutputStream();
        //JasperExportManager.exportReportToPdfStream(jasperPrint, servletOutputStream);
        JRXlsExporter xls = new JRXlsExporter();
        xls.setParameter(JRExporterParameter.JASPER_PRINT, jasperPrint);
        xls.setParameter(JRExporterParameter.OUTPUT_STREAM, servletOutputStream);
        xls.exportReport();
        FacesContext.getCurrentInstance().responseComplete();
 
            
            
        } catch (JRException ex) {
            Logger.getLogger(RelatorioController.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(RelatorioController.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(RelatorioController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    }

    public void salvar() {
        dao.Salvar(entidade);
        lista = null;
        exibirMensagem("Salvo!");
    }

    public String editar() {
        return "FuncaoCadastrar1.xhtml";
    }

    public String criar() {
        entidade = new Funcao();
        return "FuncaoCadastrar1.xhtml";
    }

    public String apagar() {
        dao.Apagar(entidade);
        lista = null;
        exibirMensagem("Pronto!");
        return "FuncaoListar.xhtml";
    }

    public String filtrar() {
        lista = dao.Buscar(filtro);
        return "FuncaoListar";
    }

    public String voltar() {
        lista =null;
        return "TelaPrincipal.xhtml";
    }

    public Funcao getEntidade() {
        return entidade;
    }

    public void setEntidade(Funcao entidade) {
        this.entidade = entidade;
    }

    public List<Funcao> getListagem() {
        if (lista == null) {
            Funcao filtro = new Funcao();
            lista = dao.Buscar(filtro);
        }
        return lista;
    }

    public void setListagem(List<Funcao> listagem) {
        this.lista = listagem;
    }

    public Funcao getFiltro() {
        return filtro;
    }

    public void setFiltro(Funcao filtro) {
        this.filtro = filtro;
    }
    
}
