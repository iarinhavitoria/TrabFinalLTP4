/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package DataAcess;


import DomainModel.ITipoApartamentoRepositorio;
import DomainModel.TipoApartamento;
import java.util.HashMap;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.Query;

/**
 *
 * @author iara
 */
@Stateless(name = "ITipoApartamentoRepositorio")
public class TipoApartamentoDAO 
        extends DAOGenerico<TipoApartamento>
        implements ITipoApartamentoRepositorio {

    public TipoApartamentoDAO() {
        super(TipoApartamento.class);
    }

    @Override
    public List<TipoApartamento> Buscar(TipoApartamento obj) {

        String consulta = "select ta from TipoApartamento ta";

        
        String filtro = "";

        
        HashMap<String, Object> parametros = new HashMap<String, Object>();
        
        if (obj != null) {
            if (obj.getIdTipoApartamento()!= null) {
                filtro += " ta.idtipoapartamento=:idtipoapartamento ";
                parametros.put("idtipoapartamento", obj.getIdTipoApartamento());
            }

            if (obj.getNome()!= null && obj.getNome().length() > 0) {
                if (filtro.length() > 0) {
                    filtro = filtro + "and";
                }
                filtro += "ta.nome=:nome";
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
