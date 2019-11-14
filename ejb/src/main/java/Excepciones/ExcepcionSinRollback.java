/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Excepciones;

import javax.ejb.ApplicationException;

/**
 *
 * excepcion con rollback desactivado
 */
@ApplicationException(rollback = false)
public class ExcepcionSinRollback extends Exception {

    /**
     * Creates a new instance of <code>ExcepcionSinRollback</code> without
     * detail message.
     */
    public ExcepcionSinRollback() {
    }

    /**
     * Constructs an instance of <code>ExcepcionSinRollback</code> with the
     * specified detail message.
     *
     * @param msg the detail message.
     */
    public ExcepcionSinRollback(String msg) {
        super(msg);
    }
}
