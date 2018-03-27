/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package observador;

/**
 *
 * @author Ander
 */
public interface ISujeto {
    public void subscribirse(IObservador o);
    public void desubscribirse(IObservador o);
}
