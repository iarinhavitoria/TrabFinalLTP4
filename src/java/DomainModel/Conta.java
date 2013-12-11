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
public class Conta implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long IdConta;
    
    private double ValorTotal;
    
    @ManyToOne
    private Hospede Hospede;
    
    @ManyToOne
    private Hospedagem Hospedagem;
    
    @ManyToOne
    private ServicosUtilizados ServicosUtilizados;
    
    @ManyToOne
    private ProdutosConsumidos ProdutosConsumidos;
    
    @ManyToOne
    private Funcionario Funcionario;

    public Long getIdConta() {
        return IdConta;
    }

    public void setIdConta(Long IdConta) {
        this.IdConta = IdConta;
    }

    public double getValorTotal() {
        return ValorTotal;
    }

    public void setValorTotal(double ValorTotal) {
        this.ValorTotal = ValorTotal;
    }

    public Hospede getHospede() {
        return Hospede;
    }

    public void setHospede(Hospede Hospede) {
        this.Hospede = Hospede;
    }

    public Hospedagem getHospedagem() {
        return Hospedagem;
    }

    public void setHospedagem(Hospedagem Hospedagem) {
        this.Hospedagem = Hospedagem;
    }

    public ServicosUtilizados getServicosUtilizados() {
        return ServicosUtilizados;
    }

    public void setServicosUtilizados(ServicosUtilizados ServicosUtilizados) {
        this.ServicosUtilizados = ServicosUtilizados;
    }

    public ProdutosConsumidos getProdutosConsumidos() {
        return ProdutosConsumidos;
    }

    public void setProdutosConsumidos(ProdutosConsumidos ProdutosConsumidos) {
        this.ProdutosConsumidos = ProdutosConsumidos;
    }

    public Funcionario getFuncionario() {
        return Funcionario;
    }

    public void setFuncionario(Funcionario Funcionario) {
        this.Funcionario = Funcionario;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 13 * hash + (this.IdConta != null ? this.IdConta.hashCode() : 0);
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
        final Conta other = (Conta) obj;
        if (this.IdConta != other.IdConta && (this.IdConta == null || !this.IdConta.equals(other.IdConta))) {
            return false;
        }
        return true;
    }
    
    
    
    

}
