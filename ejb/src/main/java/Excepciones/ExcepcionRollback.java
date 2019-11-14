/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Excepciones;

import javax.ejb.ApplicationException;

/**
 *
 * excepcion con rollback activo
 */
@ApplicationException(rollback = true)
public class ExcepcionRollback extends Exception {

    /**
     * Creates a new instance of <code>ExcepcionRollback</code> without detail
     * message.
     */
    public ExcepcionRollback() {
    }

    /**
     * Constructs an instance of <code>ExcepcionRollback</code> with the
     * specified detail message.
     *
     * @param msg the detail message.
     */
    public ExcepcionRollback(String msg) {
        super(msg);
    }
}
