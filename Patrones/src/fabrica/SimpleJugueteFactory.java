/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fabrica;

/**
 *
 * @author Ander
 */
public class SimpleJugueteFactory {
    public SimpleJugueteFactory(){
    }
    
    public Juguete createJuguete(String type,/*int numeroSerie,*/double porcentajeFallo){
        Juguete juguete=null;
        
        if (type.equals("Soldado")) {
            juguete = new Soldado(/*numeroSerie,*/porcentajeFallo);
        }
        if (type.equals("Unicornio")) {
            juguete = new Unicornio(/*numeroSerie,*/porcentajeFallo);
        }
        
        return juguete;
    }
}
