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
public class Administrador implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long IdAdministrador;
    
    private String UsuarioAdmin;
    private String SenhaAdmin;
    
    @ManyToOne
    private Funcionario Funcionario;

    public Long getIdAdministrador() {
        return IdAdministrador;
    }

    public void setIdAdministrador(Long IdAdministrador) {
        this.IdAdministrador = IdAdministrador;
    }

    public Funcionario getFuncionario() {
        return Funcionario;
    }

    public void setFuncionario(Funcionario Funcionario) {
        this.Funcionario = Funcionario;
    }

    public String getUsuarioAdmin() {
        return UsuarioAdmin;
    }

    public void setUsuarioAdmin(String UsuarioAdmin) {
        this.UsuarioAdmin = UsuarioAdmin;
    }

    public String getSenhaAdmin() {
        return SenhaAdmin;
    }

    public void setSenhaAdmin(String SenhaAdmin) {
        this.SenhaAdmin = SenhaAdmin;
    }
    
    
    
    
}
