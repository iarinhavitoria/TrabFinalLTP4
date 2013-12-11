/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package DomainModel;

import java.io.Serializable;
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
public class Hospedagem implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long IdHospedagem;
    
    @ManyToOne
    private Hospede hospede;
    
    @ManyToOne
    private Filial filial;
    
    private String MotivoViagem;

    @Temporal(javax.persistence.TemporalType.DATE)
    private Date DataEntrada;

    public Long getIdHospedagem() {
        return IdHospedagem;
    }

    public void setIdHospedagem(Long IdHospedagem) {
        this.IdHospedagem = IdHospedagem;
    }

    public Hospede getHospede() {
        return hospede;
    }

    public void setHospede(Hospede hospede) {
        this.hospede = hospede;
    }

    public Filial getFilial() {
        return filial;
    }

    public void setFilial(Filial filial) {
        this.filial = filial;
    }

    public String getMotivoViagem() {
        return MotivoViagem;
    }

    public void setMotivoViagem(String MotivoViagem) {
        this.MotivoViagem = MotivoViagem;
    }

    public Date getDataEntrada() {
        return DataEntrada;
    }

    public void setDataEntrada(Date DataEntrada) {
        this.DataEntrada = DataEntrada;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 83 * hash + (this.IdHospedagem != null ? this.IdHospedagem.hashCode() : 0);
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
        final Hospedagem other = (Hospedagem) obj;
        if (this.IdHospedagem != other.IdHospedagem && (this.IdHospedagem == null || !this.IdHospedagem.equals(other.IdHospedagem))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Hospedagem{" + "MotivoViagem=" + MotivoViagem + '}';
    }
    
    
    
}
