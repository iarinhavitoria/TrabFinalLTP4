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
public class ServicosUtilizados {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long IdServicosUtilizados;
    
    @Temporal(javax.persistence.TemporalType.DATE)
    private Date DataConsumo;
    
    @ManyToOne
    private Servico Servico;
    
    @ManyToOne
    private Hospede Hospede;
    
    @ManyToOne
    private Apartamento Apartamento;

    public Long getIdServicosUtilizados() {
        return IdServicosUtilizados;
    }

    public void setIdServicosUtilizados(Long IdServicosUtilizados) {
        this.IdServicosUtilizados = IdServicosUtilizados;
    }

    public Date getDataConsumo() {
        return DataConsumo;
    }

    public void setDataConsumo(Date DataConsumo) {
        this.DataConsumo = DataConsumo;
    }

    public Servico getServico() {
        return Servico;
    }

    public void setServico(Servico Servico) {
        this.Servico = Servico;
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
        int hash = 5;
        hash = 83 * hash + (this.IdServicosUtilizados != null ? this.IdServicosUtilizados.hashCode() : 0);
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
        final ServicosUtilizados other = (ServicosUtilizados) obj;
        if (this.IdServicosUtilizados != other.IdServicosUtilizados && (this.IdServicosUtilizados == null || !this.IdServicosUtilizados.equals(other.IdServicosUtilizados))) {
            return false;
        }
        return true;
    }
    
    
}
