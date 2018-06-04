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
import java.util.Random;

public class Unicornio extends Juguete {

    public Unicornio(double porcentajeFallo) {
        Random aleatorio = new Random();
        if (aleatorio.nextDouble() < porcentajeFallo) {
            this.setRoto(true);
        }
        this.setNombre("Unicornio");
        this.setPrecio(10);
    }
}
