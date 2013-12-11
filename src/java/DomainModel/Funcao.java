/*
 * To change this template, choose Tools | Templates
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
 * @author Iara
 */
@Entity
public class Funcao implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long IdFuncao;    
    private String Nome;
    private int HorasSemanais;

    public Long getIdFuncao() {
        return IdFuncao;
    }

    public void setIdFuncao(Long IdFuncao) {
        this.IdFuncao = IdFuncao;
    }

    public String getNome() {
        return Nome;
    }

    public void setNome(String Nome) {
        this.Nome = Nome;
    }

    public int getHorasSemanais() {
        return HorasSemanais;
    }

    public void setHorasSemanais(int HorasSemanais) {
        this.HorasSemanais = HorasSemanais;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 79 * hash + (this.IdFuncao != null ? this.IdFuncao.hashCode() : 0);
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
        final Funcao other = (Funcao) obj;
        if (this.IdFuncao != other.IdFuncao && (this.IdFuncao == null || !this.IdFuncao.equals(other.IdFuncao))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Funcao{" + "Nome=" + Nome + '}';
    }
    
    
    
    
}
