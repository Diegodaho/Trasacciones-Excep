/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Interfaces;

import Excepciones.ExcepcionRollback;
import Excepciones.ExcepcionSinRollback;
import java.io.FileNotFoundException;
import javax.ejb.Local;

/**
 *
 * 
 */
@Local
public interface TransaccionErrorLocal {
 
     public void excepcionConRollback() throws NullPointerException;
    public void excepcionSinRollback() throws FileNotFoundException;
    public void excepcionConRollbackPersonalizada() throws ExcepcionRollback ;
    public void excepcionSinRollbackPersonalizada() throws ExcepcionSinRollback;
}
