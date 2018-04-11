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
    //Patron factoria
    
    public Juguete createJuguete(String type,double porcentajeFallo){
        Juguete juguete=null;
        
        if (type.equals("Soldado")) {
            juguete = new Soldado(porcentajeFallo);
        }
        if (type.equals("Unicornio")) {
            juguete = new Unicornio(porcentajeFallo);
        }
        
        return juguete;
    }
}
