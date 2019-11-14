/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Interfaces;

import Excepciones.ExcepcionRollback;
import Excepciones.ExcepcionSinRollback;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import javax.ejb.Stateless;

/**
 *
 * Ejb de errores 
 */
@Stateless
public class TransaccionError implements TransaccionErrorLocal {

    // Add business logic below. (Right-click in editor and choose
    // "Insert Code > Add Business Method")
    
    /**
     * excepcion del sistema con rollback  -  tipo de excepcion: nullpointer
     * @throws NullPointerException 
     */
    @Override
    public void excepcionConRollback() throws NullPointerException{
        int [] losValores = null;
        losValores[4] = 100;
    }
    
    /**
     *  Excepcion del sistema sin rollback  -  tipo de excepcion: file not found
     * @throws FileNotFoundException 
     */
    @Override
    public void excepcionSinRollback() throws FileNotFoundException{
        Scanner file = new Scanner(new File("holaaa"));
        if (file.hasNextLine()) {
            String a = file.nextLine();
        }
    }
    
    /**
     * excepcion personalizada   -  tipo de excepcion: ExcepcionRollback
     * @throws ExcepcionRollback 
     */
    @Override
    public void excepcionConRollbackPersonalizada() throws ExcepcionRollback {
        throw new ExcepcionRollback("Excepcion con Rollback");
    }
    
    /**
     * excepcion personbalizada   -  tipo de excepcion: ExcepcionSinRollback
     * @throws ExcepcionSinRollback 
     */
    @Override
    public void excepcionSinRollbackPersonalizada() throws ExcepcionSinRollback{
        throw new ExcepcionSinRollback("Excepcion sin rollback");
    }
}
