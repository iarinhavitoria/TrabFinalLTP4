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
public class Servico implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long IdServico;
    
    private String Nome;
    
    @ManyToOne
    private TipoServico Tipo;

    public Long getIdServico() {
        return IdServico;
    }

    public void setIdServico(Long IdServico) {
        this.IdServico = IdServico;
    }

    public String getNome() {
        return Nome;
    }

    public void setNome(String Nome) {
        this.Nome = Nome;
    }

    public TipoServico getTipo() {
        return Tipo;
    }

    public void setTipo(TipoServico Tipo) {
        this.Tipo = Tipo;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 29 * hash + (this.IdServico != null ? this.IdServico.hashCode() : 0);
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
        final Servico other = (Servico) obj;
        if (this.IdServico != other.IdServico && (this.IdServico == null || !this.IdServico.equals(other.IdServico))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Servico{" + "Nome=" + Nome + '}';
    }
    
    
    
}
