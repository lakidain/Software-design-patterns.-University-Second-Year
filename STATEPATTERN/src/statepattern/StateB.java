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
public class StateB implements State{

    @Override
    public void handle() {
        System.out.println("Estado B");
    }
    
}
