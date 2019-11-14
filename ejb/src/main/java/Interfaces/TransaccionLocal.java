/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Interfaces;

import Excepciones.ExcepcionGenerica;
import javax.ejb.Local;

/**
 *
 * 
 */
@Local
public interface TransaccionLocal {
    
    public void excepcionSinRollback(String nombre, String apellido, String correo) throws ExcepcionGenerica;
    public void excepcionConRollback(String nombre, String apellido, String correo) throws ExcepcionGenerica;
    public void excepcionSinRollbackPersonalizada(String nombre, String apellido, String correo) throws ExcepcionGenerica;
    public void excepcionConRollbackPersonalizada(String nombre, String apellido, String correo) throws ExcepcionGenerica;
}
