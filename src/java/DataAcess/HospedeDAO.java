/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package DataAcess;

import DomainModel.Hospede;
import DomainModel.IHospedeRepositorio;
import java.util.HashMap;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.Query;

/**
 *
 * @author iara
 */
@Stateless(name = "IHospedeRepositorio")
public class HospedeDAO
    extends DAOGenerico<Hospede>
    implements IHospedeRepositorio{
    
    public HospedeDAO() {
        super(Hospede.class);
    }

    @Override
    public List<Hospede> Buscar(Hospede obj) {

        String consulta = "select h from Hospede h";

        
        String filtro = "";

        
        HashMap<String, Object> parametros = new HashMap<String, Object>();
        
        if (obj != null) {
            if (obj.getIdHospede()!= null) {
                filtro += " h.idhospede=:idhospede ";
                parametros.put("idhospede", obj.getIdHospede());
            }

            if (obj.getNome()!= null && obj.getNome().length() > 0) {
                if (filtro.length() > 0) {
                    filtro = filtro + "and";
                }
                filtro += "h.nome=:nome";
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
