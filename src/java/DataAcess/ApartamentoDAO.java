/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package DataAcess;

import DomainModel.Apartamento;
import DomainModel.IApartamentoRepositorio;
import java.util.HashMap;
import java.util.List;
import javax.persistence.Query;

/**
 *
 * @author iara
 */
public class ApartamentoDAO 
    extends DAOGenerico<Apartamento>
    implements IApartamentoRepositorio{
    public ApartamentoDAO() {
        super(Apartamento.class);
    }

    @Override
    public List<Apartamento> Buscar(Apartamento obj) {

        String consulta = "select ap from Apartamento ap";

        String filtro = "";

        HashMap<String, Object> parametros = new HashMap<String, Object>();

        if (obj.getTipo()!= null) {
            if (filtro.length() > 0) {
                filtro = filtro + " and ";
            }
            filtro = " ap.tipo =: tipo";
            parametros.put("tipo", obj.getTipo());
        }

        if (obj.getFilial()!= null) {
            if (filtro.length() > 0) {
                filtro = filtro + " and ";
            }
            filtro = " ap.filial =: filial";
            parametros.put("filial", obj.getFilial());
        }


        if (obj.getIdApartamento()!= null) {
            if (filtro.length() > 0) {
                filtro = filtro + " and ";
            }
            filtro = " ap.idapartamento =: idapartamento";
            parametros.put("idapartamento", obj.getIdApartamento());
        }

        if (filtro.length() > 0) {
            consulta = consulta + " where " + filtro;
        }

        Query query = manager.createQuery(consulta);

        for (String par : parametros.keySet()) {
            query.setParameter(par, parametros.get(par));
        }

        return query.getResultList();

    }
}
