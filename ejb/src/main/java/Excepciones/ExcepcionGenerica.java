/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Excepciones;

/**
 *
 * Excepcion generica la que conoce la web
 */
public class ExcepcionGenerica extends Exception {

    /**
     * Creates a new instance of <code>ExcepcionGenerica</code> without detail
     * message.
     */
    public ExcepcionGenerica() {
    }

    /**
     * Constructs an instance of <code>ExcepcionGenerica</code> with the
     * specified detail message.
     *
     * @param msg the detail message.
     */
    public ExcepcionGenerica(String msg) {
        super(msg);
    }
}
