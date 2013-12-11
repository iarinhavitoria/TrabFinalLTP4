/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package DomainModel;

import java.util.Date;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Temporal;

/**
 *
 * @author iara
 */
@Entity
public class ProdutosConsumidos {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long IdProdutosConsumidos;
    
    //private double ValorTotal;
    
    @Temporal(javax.persistence.TemporalType.DATE)
    private Date DataConsumo;
    
    @ManyToOne
    private Produto Produto;
    
    @ManyToOne
    private Hospede Hospede;
    
    @ManyToOne
    private Apartamento Apartamento;

    public Long getIdProdutosConsumidos() {
        return IdProdutosConsumidos;
    }

    public void setIdProdutosConsumidos(Long IdProdutosConsumidos) {
        this.IdProdutosConsumidos = IdProdutosConsumidos;
    }

    public Date getDataConsumo() {
        return DataConsumo;
    }

    public void setDataConsumo(Date DataConsumo) {
        this.DataConsumo = DataConsumo;
    }

    public Produto getProduto() {
        return Produto;
    }

    public void setProduto(Produto Produto) {
        this.Produto = Produto;
    }

    public Hospede getHospede() {
        return Hospede;
    }

    public void setHospede(Hospede Hospede) {
        this.Hospede = Hospede;
    }

    public Apartamento getApartamento() {
        return Apartamento;
    }

    public void setApartamento(Apartamento Apartamento) {
        this.Apartamento = Apartamento;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 17 * hash + (this.IdProdutosConsumidos != null ? this.IdProdutosConsumidos.hashCode() : 0);
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
        final ProdutosConsumidos other = (ProdutosConsumidos) obj;
        if (this.IdProdutosConsumidos != other.IdProdutosConsumidos && (this.IdProdutosConsumidos == null || !this.IdProdutosConsumidos.equals(other.IdProdutosConsumidos))) {
            return false;
        }
        return true;
    }
    
    
    
}
