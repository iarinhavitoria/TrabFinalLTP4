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
public class TipoServico implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long IdTipoServico;
    private String Nome;
    private double Preco;

    public Long getIdTipoServico() {
        return IdTipoServico;
    }

    public void setIdTipoServico(Long IdTipoServico) {
        this.IdTipoServico = IdTipoServico;
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

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 53 * hash + (this.IdTipoServico != null ? this.IdTipoServico.hashCode() : 0);
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
        final TipoServico other = (TipoServico) obj;
        if (this.IdTipoServico != other.IdTipoServico && (this.IdTipoServico == null || !this.IdTipoServico.equals(other.IdTipoServico))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "TipoServico{" + "Nome=" + Nome + '}';
    }
    
    
}
