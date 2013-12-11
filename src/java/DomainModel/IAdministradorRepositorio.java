/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package DomainModel;

import javax.ejb.Remote;

/**
 *
 * @author Rosy
 */
@Remote
public interface IAdministradorRepositorio extends IRepositorio<Administrador> {
    public Administrador fazerLogin(String login);
}
