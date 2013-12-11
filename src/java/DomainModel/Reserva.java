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
public class Reserva implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long IdReserva;
    
    @ManyToOne
    private Hospede Hospede;
    
    @ManyToOne
    private Apartamento Apartamento;
    
    @ManyToOne
    private Filial Filial;

    public Long getIdReserva() {
        return IdReserva;
    }

    public void setIdReserva(Long IdReserva) {
        this.IdReserva = IdReserva;
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

    public Filial getFilial() {
        return Filial;
    }

    public void setFilial(Filial Filial) {
        this.Filial = Filial;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 53 * hash + (this.IdReserva != null ? this.IdReserva.hashCode() : 0);
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
        final Reserva other = (Reserva) obj;
        if (this.IdReserva != other.IdReserva && (this.IdReserva == null || !this.IdReserva.equals(other.IdReserva))) {
            return false;
        }
        return true;
    }
    
    
}
