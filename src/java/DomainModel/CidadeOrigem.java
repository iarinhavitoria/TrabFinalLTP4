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
public class CidadeOrigem implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long IdCidadeOrigem;    
    private String Nome;
    private String Estado;

    public Long getIdCidadeOrigem() {
        return IdCidadeOrigem;
    }

    public void setIdCidadeOrigem(Long IdCidadeOrigem) {
        this.IdCidadeOrigem = IdCidadeOrigem;
    }

    public String getNome() {
        return Nome;
    }

    public void setNome(String Nome) {
        this.Nome = Nome;
    }

    public String getEstado() {
        return Estado;
    }

    public void setEstado(String Estado) {
        this.Estado = Estado;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 97 * hash + (this.IdCidadeOrigem != null ? this.IdCidadeOrigem.hashCode() : 0);
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
        final CidadeOrigem other = (CidadeOrigem) obj;
        if (this.IdCidadeOrigem != other.IdCidadeOrigem && (this.IdCidadeOrigem == null || !this.IdCidadeOrigem.equals(other.IdCidadeOrigem))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "CidadeOrigem{" + "Nome=" + Nome + ", Estado=" + Estado + '}';
    }
    
    
}
