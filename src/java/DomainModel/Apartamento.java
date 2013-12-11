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
public class Apartamento implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long IdApartamento;
    
    @ManyToOne
    private TipoApartamento Tipo;
    
    @ManyToOne
    private Filial Filial;

    public Long getIdApartamento() {
        return IdApartamento;
    }

    public void setIdApartamento(Long IdApartamento) {
        this.IdApartamento = IdApartamento;
    }

    public TipoApartamento getTipo() {
        return Tipo;
    }

    public void setTipo(TipoApartamento Tipo) {
        this.Tipo = Tipo;
    }

    public Filial getFilial() {
        return Filial;
    }

    public void setFilial(Filial Filial) {
        this.Filial = Filial;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 53 * hash + (this.IdApartamento != null ? this.IdApartamento.hashCode() : 0);
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
        final Apartamento other = (Apartamento) obj;
        if (this.IdApartamento != other.IdApartamento && (this.IdApartamento == null || !this.IdApartamento.equals(other.IdApartamento))) {
            return false;
        }
        return true;
    }
    
    
}
