/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package state;

/**
 *
 * @author Ander
 */
public class Normal implements State {

    public Normal(){
    }
    
    public String handle() {
        String mensaje= "La fabrica funciona con normalidad";
        return mensaje;
    }
    
}
