/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package DataAcess;

import DomainModel.Administrador;
import DomainModel.IAdministradorRepositorio;
import java.util.HashMap;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.Query;

/**
 *
 * @author Rosy
 */
@Stateless(name = "IAdministradorRepositorio")
public abstract class AdministradorDAO
        extends DAOGenerico<Administrador>
        implements IAdministradorRepositorio {
    
    public AdministradorDAO() {
        super(Administrador.class);
    }

    
    @Override
    public Administrador fazerLogin(String login){
        String consulta = "select a from Administrador a where a.login=:login";

        Query query = manager.createQuery(consulta);

        query.setParameter("login", login);

        return (Administrador)query.getSingleResult();


    }
}
