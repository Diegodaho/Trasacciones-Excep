/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Interfaces;

import Excepciones.ExcepcionGenerica;
import Excepciones.ExcepcionRollback;
import Excepciones.ExcepcionSinRollback;
import ejb.UsuarioFacade;
import ejb.UsuarioFacadeLocal;
import java.io.FileNotFoundException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;
import javax.ejb.TransactionAttributeType;

/**
 *
 * ejb de transacciones - al que se conectan desde la web
 */
@Stateless
public class Transaccion implements TransaccionLocal {
    
    /**
     * ejb de usuarios
     */
    @EJB
    UsuarioFacadeLocal usuarioLocal;
    /**
     * ejb del ejb de errores
     */
    @EJB
    TransaccionErrorLocal transaccionErrorLocal;
    
    /**
     *  excepcion sin rollback
     * @param nombre
     * @param apellido
     * @param correo
     * @throws ExcepcionGenerica 
     */
    @Override
    @TransactionAttribute(TransactionAttributeType.REQUIRED)
    public void excepcionSinRollback(String nombre, String apellido, String correo) throws ExcepcionGenerica{
        try {
            usuarioLocal.agregarUsuario(nombre, apellido, correo);
            transaccionErrorLocal.excepcionSinRollback();
        } catch (FileNotFoundException ex) {
            //Logger.getLogger(Transaccion.class.getName()).log(Level.SEVERE, null, ex);
            throw new ExcepcionGenerica("Error al realizar la operacion - File not found");
        }
        
    }
    
    /**
     * excepcion con rollback
     * @param nombre
     * @param apellido
     * @param correo
     * @throws ExcepcionGenerica 
     */
    @Override
    @TransactionAttribute(TransactionAttributeType.REQUIRED)
    public void excepcionConRollback(String nombre, String apellido, String correo) throws ExcepcionGenerica{
        try {
            usuarioLocal.agregarUsuario(nombre, apellido, correo);
            transaccionErrorLocal.excepcionConRollback();
        } catch (NullPointerException ex) {
            //Logger.getLogger(Transaccion.class.getName()).log(Level.SEVERE, null, ex);
            throw new ExcepcionGenerica("Error al realizar la operacion - nullPointer");
        }
    }
    
    /**
     * excepcion personalizada sin rollback
     * @param nombre
     * @param apellido
     * @param correo
     * @throws ExcepcionGenerica 
     */
    @Override
    @TransactionAttribute(TransactionAttributeType.REQUIRED)
    public void excepcionSinRollbackPersonalizada(String nombre, String apellido, String correo) throws ExcepcionGenerica{
        try {
            usuarioLocal.agregarUsuario(nombre, apellido, correo);
            transaccionErrorLocal.excepcionSinRollbackPersonalizada();
        } catch (ExcepcionSinRollback ex) {
            //Logger.getLogger(Transaccion.class.getName()).log(Level.SEVERE, null, ex);
            throw new ExcepcionGenerica("Error al realizar la operacion -no  se realizara Rollback");
        }
    }
    
    /**
     * excepcion personlizada con rollback
     * @param nombre
     * @param apellido
     * @param correo
     * @throws ExcepcionGenerica 
     */
    @Override
    @TransactionAttribute(TransactionAttributeType.REQUIRED)
    public void excepcionConRollbackPersonalizada(String nombre, String apellido, String correo) throws ExcepcionGenerica{
        try {
            usuarioLocal.agregarUsuario(nombre, apellido, correo);
            transaccionErrorLocal.excepcionConRollbackPersonalizada();
        } catch (ExcepcionRollback ex) {
            //Logger.getLogger(Transaccion.class.getName()).log(Level.SEVERE, null, ex);
            throw new ExcepcionGenerica("Error al realizar la operacion - se realizara Rollback");
        }
    }
    
}
