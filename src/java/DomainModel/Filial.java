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
public class Filial implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long IdFilial;
    private String Cidade;
    private String Estado;

    public Long getIdFilial() {
        return IdFilial;
    }

    public void setIdFilial(Long IdFilial) {
        this.IdFilial = IdFilial;
    }

    public String getCidade() {
        return Cidade;
    }

    public void setCidade(String Cidade) {
        this.Cidade = Cidade;
    }

    public String getEstado() {
        return Estado;
    }

    public void setEstado(String Estado) {
        this.Estado = Estado;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 43 * hash + (this.IdFilial != null ? this.IdFilial.hashCode() : 0);
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
        final Filial other = (Filial) obj;
        if (this.IdFilial != other.IdFilial && (this.IdFilial == null || !this.IdFilial.equals(other.IdFilial))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Filial{" + "Cidade=" + Cidade + ", Estado=" + Estado + '}';
    }
    
    
}
