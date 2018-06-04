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
import java.util.*;

public class Soldado extends Juguete {

    public Soldado(double porcentajeFallo) {
        Random aleatorio = new Random();
        if (aleatorio.nextDouble() < porcentajeFallo) {
            this.setRoto(true);
        }
        this.setNombre("Soldado");
        this.setPrecio(5);
    }
}
