/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package state;

import fabrica.Fabrica;
import java.util.Random;

/**
 *
 * @author Ander
 */
public class Normal implements State {

    public Normal() {
        System.out.println("La fabrica se encuentra en estado normal, puede producir");
    }

    public void handle(String producto) {
        Fabrica fabrica = Fabrica.getInstance();
        fabrica.addJuguetes(producto);

        enLlamas(fabrica);
        String aviso = "Tenemos una producción de " + fabrica.getJuguetesSize() 
                + ".De los cuales tenemos:" + fabrica.getModelos() +
                ", pueden pasar a comprarlos cuando deseen";
        fabrica.notificarSubscriptores(aviso);

    }

    public void enLlamas(Fabrica fabrica) {
        Random dado = new Random();
        State estado = new Llamas();

        if (dado.nextDouble() < 0.90) {
            fabrica.cambiarEstado(estado);
        }
    }

}
