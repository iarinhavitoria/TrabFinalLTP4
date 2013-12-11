/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package DataAcess;

import DomainModel.Funcionario;
import DomainModel.IFuncionarioRepositorio;
import java.util.HashMap;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.Query;

/**
 *
 * @author iara
 */
@Stateless(name = "IFuncionarioRepositorio")
public class FuncionarioDAO 
    extends DAOGenerico<Funcionario>
    implements IFuncionarioRepositorio {
    public FuncionarioDAO() {
        super(Funcionario.class);
    }

    @Override
    public List<Funcionario> Buscar(Funcionario obj) {
        // Corpo da consulta
        String consulta = "select f from Funcionario f";

        // A parte where da consulta
        String filtro = "";

        // Guarda a lista de parâmetros da query
        HashMap<String, Object> parametros = new HashMap<String, Object>();

        // Verifica campo por campo os valores que serão filtrados
        if (obj != null) {
            if (obj.getNome() != null && obj.getNome().length() > 0) {
                filtro += " f.nome=:nome ";
                parametros.put("nome", obj.getNome());
            }

            if (obj.getLogin() != null && obj.getLogin().length() > 0) {
                if (filtro.length() > 0) {
                    filtro += " and ";
                }
                filtro += " f.usuario=:usuario ";
                parametros.put("usuario", obj.getLogin());
            }

            if (obj.getIdFuncionario()!= null && obj.getIdFuncionario()> 0) {
                if (filtro.length() > 0) {
                    filtro = filtro + " and ";
                }
                filtro += " f.idfuncionario =:idfuncionario";
                parametros.put("idfuncionario", obj.getIdFuncionario());
            }

            if (obj.getSenha() != null && obj.getSenha().length() > 0) {
                if (filtro.length() > 0) {
                    filtro = filtro + " and ";
                }
                filtro += " f.senha=:senha";
                parametros.put("senha", obj.getSenha());
            }

            if (obj.getFuncao()!= null && obj.getFuncao().toString().length() > 0) {
                if (filtro.length() > 0) {
                    filtro = filtro + " and ";
                }
                filtro += " f.tipo=:tipo ";
                parametros.put("tipo", obj.getFuncao());
            }
            // Se houver filtros, coloca o "where" na consulta
            if (filtro.length() > 0) {
                consulta = consulta + " where " + filtro;
            }
        }

        // Cria a consulta no JPA
        Query query = manager.createQuery(consulta);

        // Aplica os parâmetros da consulta
        for (String par : parametros.keySet()) {
            query.setParameter(par, parametros.get(par));
        }

        // Executa a consulta
        return query.getResultList();

    }
    
    @Override
    public Funcionario fazerLogin(String usuario){
        String consulta = "select f from Funcionario f where f.usuario=:usuario";
                // Cria a consulta no JPA
        Query query = manager.createQuery(consulta);

        // Aplica os parâmetros da consulta
        query.setParameter("usuario", usuario);

        // Executa a consulta
        return (Funcionario)query.getSingleResult();


    }
}
