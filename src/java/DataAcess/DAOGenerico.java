/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package DataAcess;

import DomainModel.IRepositorio;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author iara
 */
public abstract class DAOGenerico<T> implements IRepositorio<T> {
    @PersistenceContext(name="TrabalhoFinalLTP4PU")
    protected EntityManager manager;
    private Class tipo;
    public DAOGenerico (Class t) {
        tipo = t;
    }
    
   

 
    @Override
    public boolean Salvar(T obj) {
        try{
            //salva o objeto
            manager.merge(obj);
            return true;
        }catch (Exception ex){
        System.out.println(ex.getMessage());
        return false;
        }
    }
    
          
    
    @Override
    public T Abrir(Long id) {
        try {
            T obj = (T) manager.find(tipo, id);
            return obj;
            //abrir
        } catch (Exception ex) {
            return null;
        }
    }
    
    
    @Override
      public abstract List<T> Buscar(T obj);

    @Override
    public boolean Apagar(T obj) {
        try {
            manager.remove(manager.merge(obj));
            return true;
        } catch (Exception ex) {
            return false;
        }
    }
    
}
