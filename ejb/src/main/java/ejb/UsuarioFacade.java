/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejb;

import entities.Usuario;
import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;
import javax.ejb.TransactionAttributeType;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * Session bean Usuario
 */
@Stateless
public class UsuarioFacade extends AbstractFacade<Usuario> implements UsuarioFacadeLocal {
    /**
     * unidad de persistencia
     */
    @PersistenceContext(unitName = "com.mycompany_ejb_ejb_1.0-SNAPSHOTPU")
    private EntityManager em;

    /**
     * entity amnager
     * @return 
     */
    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    /**
     * constructor
     */
    public UsuarioFacade() {
        super(Usuario.class);
    }

    /**
     * agregar usuario
     * @param nombre
     * @param apellido
     * @param correo 
     */
    @Override
    @TransactionAttribute(TransactionAttributeType.REQUIRED)
    public void agregarUsuario(String nombre, String apellido, String correo) {
        Usuario user = new Usuario(nombre, apellido, correo);
        em.persist(user);
    }
}
