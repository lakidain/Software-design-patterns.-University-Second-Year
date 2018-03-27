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
public class Llamas implements State{

    public Llamas(){
    }
    
    public String handle() {
        String mensaje= "La fabrica esta en llamas, se para la produccion";
        return mensaje;
    }
    
}
