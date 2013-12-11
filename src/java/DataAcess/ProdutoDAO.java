/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package DataAcess;

import DomainModel.IProdutoRepositorio;
import DomainModel.Produto;
import java.util.HashMap;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.Query;

/**
 *
 * @author iara
 */
@Stateless(name = "IProdutoRepositorio")
public class ProdutoDAO 
    extends DAOGenerico<Produto>
    implements IProdutoRepositorio{
    
    public ProdutoDAO() {
        super(Produto.class);
    }

    @Override
    public List<Produto> Buscar(Produto obj) {

        String consulta = "select p from Produto p";

        
        String filtro = "";

        
        HashMap<String, Object> parametros = new HashMap<String, Object>();
        
        if (obj != null) {
            if (obj.getIdProduto()!= null) {
                filtro += " p.idproduto=:idproduto ";
                parametros.put("idproduto", obj.getIdProduto());
            }

            if (obj.getNome()!= null && obj.getNome().length() > 0) {
                if (filtro.length() > 0) {
                    filtro = filtro + "and";
                }
                filtro += "p.nome=:nome";
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
