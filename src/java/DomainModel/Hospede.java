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
public class Hospede implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long IdHospede;
    
    @ManyToOne
    private CidadeOrigem Cidade;
    
    private String Nome;
    private String CPF;
    private String Telefone;

    public Long getIdHospede() {
        return IdHospede;
    }

    public void setIdHospede(Long IdHospede) {
        this.IdHospede = IdHospede;
    }

    public CidadeOrigem getCidade() {
        return Cidade;
    }

    public void setCidade(CidadeOrigem Cidade) {
        this.Cidade = Cidade;
    }

    public String getNome() {
        return Nome;
    }

    public void setNome(String Nome) {
        this.Nome = Nome;
    }

    public String getCPF() {
        return CPF;
    }

    public void setCPF(String CPF) {
        this.CPF = CPF;
    }

    public String getTelefone() {
        return Telefone;
    }

    public void setTelefone(String Telefone) {
        this.Telefone = Telefone;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 83 * hash + (this.IdHospede != null ? this.IdHospede.hashCode() : 0);
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
        final Hospede other = (Hospede) obj;
        if (this.IdHospede != other.IdHospede && (this.IdHospede == null || !this.IdHospede.equals(other.IdHospede))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Hospede{" + "Nome=" + Nome + '}';
    }
    
    
    
}
