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

/**
 *
 * @author iara
 */
@Entity
public class TipoApartamento implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long IdTipoApartamento;
    private String Nome;
    private double Preco;
    private String Observacao;

    public Long getIdTipoApartamento() {
        return IdTipoApartamento;
    }

    public void setIdTipoApartamento(Long IdTipoApartamento) {
        this.IdTipoApartamento = IdTipoApartamento;
    }

    public String getNome() {
        return Nome;
    }

    public void setNome(String Nome) {
        this.Nome = Nome;
    }

    public double getPreco() {
        return Preco;
    }

    public void setPreco(double Preco) {
        this.Preco = Preco;
    }

    public String getObservacao() {
        return Observacao;
    }

    public void setObservacao(String Observacao) {
        this.Observacao = Observacao;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 79 * hash + (this.IdTipoApartamento != null ? this.IdTipoApartamento.hashCode() : 0);
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
        final TipoApartamento other = (TipoApartamento) obj;
        if (this.IdTipoApartamento != other.IdTipoApartamento && (this.IdTipoApartamento == null || !this.IdTipoApartamento.equals(other.IdTipoApartamento))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "TipoApartamento{" + "Nome=" + Nome + ", Observacao=" + Observacao + '}';
    }

    
    
}
