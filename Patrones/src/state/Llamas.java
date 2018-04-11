/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package state;

import fabrica.Fabrica;
import java.util.Scanner;

/**
 *
 * @author Ander
 */
public class Llamas implements State {
    
    public Llamas() {
    }
    
    public void handle(String producto) {   //podriamos pasarlo como referencia la fabrica haciendo un this desde fabrica, pero como tenemos un singleton es lo mismo y le damos uso al patron
        Fabrica fabrica = Fabrica.getInstance();
        
        System.out.println("No puede producir con la fabrica en llamas! ¿Quiere llamar a los bomberos? Pulse 1 para llamarlos, otro numero para no llamarlos, la Navidad depende de usted :D");
        Scanner sc = new Scanner(System.in);
        int respuesta = sc.nextInt();
        if (respuesta == 1) {
            bomberos(fabrica);
            System.out.println("Gracias por llamar a los bomberos, has salvado la Navidad :D");
        }
        //System.out.print("La fabrica esta en llamas, se para la produccion");
    }
    
    public void bomberos(Fabrica fabrica) {    //lo ponemos aqui porque si queremos borrar el estado llamas no tendria sentido tener esta funcion en la fabrica, no pintaria nada
        State normal = new Normal();
        fabrica.cambiarEstado(normal);
        System.out.println("Los bomberos se han encargado de la emergencia, puede continuar la producción");
    }
}
