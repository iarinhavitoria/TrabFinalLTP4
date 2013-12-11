/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package DataAcess;

import DomainModel.Filial;
import DomainModel.IFilialRepositorio;
import java.util.HashMap;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.Query;

/**
 *
 * @author iara
 */
@Stateless(name = "IFilialRepositorio")
public class FilialDAO
    extends DAOGenerico<Filial>
    implements IFilialRepositorio{
    
    public FilialDAO() {
        super(Filial.class);
    }

    @Override
    public List<Filial> Buscar(Filial obj) {

        String consulta = "select f from Filial f";

        
        String filtro = "";

        
        HashMap<String, Object> parametros = new HashMap<String, Object>();
        
        if (obj != null) {
            if (obj.getIdFilial()!= null) {
                filtro += " f.idfilial=:idfilial ";
                parametros.put("idfilial", obj.getIdFilial());
            }

            if (obj.getCidade()!= null && obj.getCidade().length() > 0) {
                if (filtro.length() > 0) {
                    filtro = filtro + "and";
                }
                filtro += "f.cidade=:cidade";
                parametros.put("cidade", obj.getCidade());
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
