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
public class Produto implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long IdProduto;
    private String Nome;
    private double Preco;

    public Long getIdProduto() {
        return IdProduto;
    }

    public void setIdProduto(Long IdProduto) {
        this.IdProduto = IdProduto;
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
        int hash = 3;
        hash = 97 * hash + (this.IdProduto != null ? this.IdProduto.hashCode() : 0);
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
        final Produto other = (Produto) obj;
        if (this.IdProduto != other.IdProduto && (this.IdProduto == null || !this.IdProduto.equals(other.IdProduto))) {
            return false;
        }
        return true;
    }

    

    @Override
    public String toString() {
        return "Produto{" + "Nome=" + Nome + '}';
    }
    
    
}
