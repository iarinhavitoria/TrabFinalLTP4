/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package DataAcess;

import DomainModel.Funcao;
import DomainModel.IFuncaoRepositorio;
import java.util.HashMap;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.Query;

/**
 *
 * @author iara
 */
@Stateless(name = "IFuncaoRepositorio")
public class FuncaoDAO 
        extends DAOGenerico<Funcao>
        implements IFuncaoRepositorio {
    

    public FuncaoDAO() {
        super(Funcao.class);
    }

    @Override
    public List<Funcao> Buscar(Funcao obj) {

        String consulta = "select f from Funcao f";

        
        String filtro = "";

        
        HashMap<String, Object> parametros = new HashMap<String, Object>();
        
        if (obj != null) {
            if (obj.getIdFuncao()!= null) {
                filtro += " f.idfuncao=:idfuncao ";
                parametros.put("idfuncao", obj.getIdFuncao());
            }

            if (obj.getNome()!= null && obj.getNome().length() > 0) {
                if (filtro.length() > 0) {
                    filtro = filtro + "and";
                }
                filtro += "f.nome=:nome";
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
