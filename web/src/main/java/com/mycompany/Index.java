package com.mycompany;

import Excepciones.ExcepcionGenerica;
import Interfaces.TransaccionLocal;
import ejb.UsuarioFacadeLocal;
import entities.Usuario;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ejb.EJB;
import javax.inject.Named;
import javax.enterprise.context.RequestScoped;

/**
 * 
 * clase index, maneja la pagina index.xhtml
 */
@Named(value = "index")
@RequestScoped
public class Index {

    /**
     * ejb de las transacciones
     */
    @EJB
    private TransaccionLocal transaccionlocal;

    /**
     * ejb de usuarios
     */
    @EJB
    private UsuarioFacadeLocal usuarioLocal;

    /**
     * lista de usuarios
     */
    private List<Usuario> users = new ArrayList<Usuario>();
    
    /**
     * Creates a new instance of Index
     */
    public Index() {
    }
    
    /**
     * excepcion del sistema sin rollback
     */
    public void excepcionSinRollback(){
        try {
            transaccionlocal.excepcionSinRollback("Usuario1", "SinRollback", "sinRollback@mail.com");
        } catch (ExcepcionGenerica ex) {
            //Logger.getLogger(Index.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    /**
     * excepcion del sistema con rollback
     */
    public void excepcionConRollback(){
        try {
            transaccionlocal.excepcionConRollback("Usuario2", "conRollback", "ConRollback@mail.com");
        } catch (ExcepcionGenerica ex) {
            //Logger.getLogger(Index.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    /**
     * excepcion sin rollback, dispara la excepcion personalizada
     */
    public void excepcionSinRollbackPersonalizada(){
        try {
            transaccionlocal.excepcionSinRollbackPersonalizada("Usuario3", "sinRollbackPersonalizada", "Per1@mail.com");
        } catch (ExcepcionGenerica ex) {
            //Logger.getLogger(Index.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    /**
     * excepcion con rollback, dispara la excepcion personalizada
     */
    public void excepcionConRollbackPersonalizada(){
        try {
            transaccionlocal.excepcionConRollbackPersonalizada("Usuario4", "conRollbackPersonalizada", "Per2@mail.com");
        } catch (ExcepcionGenerica ex) {
            //Logger.getLogger(Index.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    

    /**
     * @return the transaccionlocal
     */
    public TransaccionLocal getTransaccionlocal() {
        return transaccionlocal;
    }

    /**
     * @param transaccionlocal the transaccionlocal to set
     */
    public void setTransaccionlocal(TransaccionLocal transaccionlocal) {
        this.transaccionlocal = transaccionlocal;
    }

    /**
     * @return the usuarioLocal
     */
    public UsuarioFacadeLocal getUsuarioLocal() {
        return usuarioLocal;
    }

    /**
     * @param usuarioLocal the usuarioLocal to set
     */
    public void setUsuarioLocal(UsuarioFacadeLocal usuarioLocal) {
        this.usuarioLocal = usuarioLocal;
    }

    /**
     * @return the users
     */
    public List<Usuario> getUsers() {
        setUsers(usuarioLocal.findAll());
        return users;
    }

    /**
     * @param users the users to set
     */
    public void setUsers(List<Usuario> users) {
        this.users = users;
    }
    
    
}
