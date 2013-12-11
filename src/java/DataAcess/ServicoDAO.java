/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package DataAcess;

import DomainModel.IServicoRepositorio;
import DomainModel.Servico;
import java.util.HashMap;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.Query;

/**
 *
 * @author iara
 */
@Stateless(name = "IServicoRepositorio")
public class ServicoDAO 
    extends DAOGenerico<Servico>
    implements IServicoRepositorio{
    public ServicoDAO() {
        super(Servico.class);
    }

    @Override
    public List<Servico> Buscar(Servico obj) {

        String consulta = "select s from Servico s";

        
        String filtro = "";

        
        HashMap<String, Object> parametros = new HashMap<String, Object>();
        
        if (obj != null) {
            if (obj.getIdServico()!= null) {
                filtro += " s.idservico=:idservico ";
                parametros.put("idservico", obj.getIdServico());
            }

            if (obj.getNome()!= null && obj.getNome().length() > 0) {
                if (filtro.length() > 0) {
                    filtro = filtro + "and";
                }
                filtro += "s.nome=:nome";
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
