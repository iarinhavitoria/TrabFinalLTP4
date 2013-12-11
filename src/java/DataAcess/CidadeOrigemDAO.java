/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package DataAcess;

import DomainModel.CidadeOrigem;
import DomainModel.ICidadeOrigemRepositorio;
import java.util.HashMap;
import java.util.List;
import javax.ejb.Stateless;
import javax.faces.bean.ManagedBean;
import javax.persistence.Query;

/**
 *
 * @author iara
 */
@Stateless
(name = "ICidadeOrigemRepositorio")
public class CidadeOrigemDAO 
    extends DAOGenerico<CidadeOrigem>
    implements ICidadeOrigemRepositorio {
    
    public CidadeOrigemDAO() {
        super(CidadeOrigem.class);
    }

    @Override
    public List<CidadeOrigem> Buscar(CidadeOrigem obj) {

        String consulta = "select co from CidadeOrigem co";

        
        String filtro = "";

        
        HashMap<String, Object> parametros = new HashMap<String, Object>();
        
        if (obj != null) {
            if (obj.getIdCidadeOrigem()!= null) {
                filtro += " co.idcidadeorigem=:idcidadeorigem ";
                parametros.put("idcidadeorigem", obj.getIdCidadeOrigem());
            }

            if (obj.getNome()!= null && obj.getNome().length() > 0) {
                if (filtro.length() > 0) {
                    filtro = filtro + "and";
                }
                filtro += "co.nome=:nome";
                parametros.put("nome", obj.getNome());
            }
            
            if (obj.getEstado()!= null && obj.getEstado().length() > 0) {
                if (filtro.length() > 0) {
                    filtro = filtro + "and";
                }
                filtro += "co.estado=:estado";
                parametros.put("estado", obj.getNome());
            }
            
            if (filtro.length() > 0) {
                consulta = consulta + " where " + filtro;
            }
        }

        
        Query query = manager.createQuery(consulta);

        for (String par : parametros.keySet()) {
            query.setParameter(par, parametros.get(par));
        }

        
        return query.getResultList();
    }

    
    
}
