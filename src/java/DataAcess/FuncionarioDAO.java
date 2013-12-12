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
public class FuncionarioDAO extends DAOGenerico<Funcionario> implements IFuncionarioRepositorio {
    public FuncionarioDAO() {
        super(Funcionario.class);
    }

    @Override
    public List<Funcionario> Buscar(Funcionario obj) {
        // Corpo da consulta
        String consulta = "select * from Funcionario f";

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

            if (obj.getIdFuncionario()!= null && obj.getIdFuncionario()> 0) {
                if (filtro.length() > 0) {
                    filtro = filtro + " and ";
                }
                filtro += " f.idfuncionario =:idfuncionario";
                parametros.put("idfuncionario", obj.getIdFuncionario());
            }

            if (obj.getCPF()!= null && obj.getCPF().length() > 0) {
                
                filtro += " AND f.cpf like '%"+obj.getCPF()+"%'";
                
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
    public boolean Apagar(Funcionario obj) {
        
        try {
            Query query = manager.createQuery("Update Funcionario f.idfuncionario =:idfuncionario");
            query.setParameter("id", obj.getIdFuncionario());
            query.executeUpdate();
            
            return true;

        } catch (Exception ex) {
            ex.printStackTrace();

            return false;
        }
        
    }

    @Override
    public Funcionario fazerLogin(String login) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    

          
    
    
}
