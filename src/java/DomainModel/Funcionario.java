/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package DomainModel;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

/**
 *
 * @author iara
 */
@Entity
public class Funcionario implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long IdFuncionario;
    
    @ManyToOne
    private Funcao funcao;
    
    private String Nome;
    private String CPF;
    private String Login;
    private String Senha;

    public Long getIdFuncionario() {
        return IdFuncionario;
    }

    public void setIdFuncionario(Long IdFuncionario) {
        this.IdFuncionario = IdFuncionario;
    }

    

    public Funcao getFuncao() {
        return funcao;
    }

    public void setFuncao(Funcao funcao) {
        this.funcao = funcao;
    }

    public String getNome() {
        return Nome;
    }

    public void setNome(String Nome) {
        this.Nome = Nome;
    }

    public String getCPF() {
        return CPF;
    }

    public void setCPF(String CPF) {
        this.CPF = CPF;
    }

    public String getLogin() {
        return Login;
    }

    public void setLogin(String Login) {
        this.Login = Login;
    }

    public String getSenha() {
        return Senha;
    }

    public void setSenha(String Senha) {
        this.Senha = Senha;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 17 * hash + (this.IdFuncionario != null ? this.IdFuncionario.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Funcionario other = (Funcionario) obj;
        if (this.IdFuncionario != other.IdFuncionario && (this.IdFuncionario == null || !this.IdFuncionario.equals(other.IdFuncionario))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Funcionario{" + "Nome=" + Nome + '}';
    }
    
    
    
}
