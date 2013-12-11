/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package DataAcess;

import DomainModel.ITipoServicoRepositorio;
import DomainModel.TipoServico;
import java.util.HashMap;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.Query;

/**
 *
 * @author iara
 */
@Stateless(name = "ITipoServicoRepositorio")
public class TipoServicoDAO 
        extends DAOGenerico<TipoServico>
        implements ITipoServicoRepositorio {
    
    public TipoServicoDAO() {
        super(TipoServico.class);
    }

    @Override
    public List<TipoServico> Buscar(TipoServico obj) {

        String consulta = "select ts from TipoServico ts";

        
        String filtro = "";

        
        HashMap<String, Object> parametros = new HashMap<String, Object>();
        
        if (obj != null) {
            if (obj.getIdTipoServico()!= null) {
                filtro += " ts.idtiposervico=:idtiposervico ";
                parametros.put("idtiposervico", obj.getIdTipoServico());
            }

            if (obj.getNome()!= null && obj.getNome().length() > 0) {
                if (filtro.length() > 0) {
                    filtro = filtro + "and";
                }
                filtro += "ts.nome=:nome";
                parametros.put("nome", obj.getNome());
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
