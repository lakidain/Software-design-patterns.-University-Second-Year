/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package statepattern;

/**
 *
 * @author UPO
 */
public class STATEPATTERN {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        State state = new StateB();
        Context c = new Context();
        c.setState(state);
        c.request();
    }
    
}
