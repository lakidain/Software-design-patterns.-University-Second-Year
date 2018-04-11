/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package estrategias;

/**
 *
 * @author Ander
 */
import fabrica.*;
import java.util.*;

public class ProduccionFestiva implements EstrategiaProduccion {    //Necesitamos de esta estrategia para poder cambiar en tiempo real cuando se acerca una festividad

    private int cantidadProduccion;
    private double porcentajeFallo;

    public ProduccionFestiva() {
        this.cantidadProduccion = 20;
        this.porcentajeFallo = 0.10;
    }

    public ArrayList<Juguete> producir(String modelo) {
        ArrayList<Juguete> juguetes = new ArrayList();
        SimpleJugueteFactory factoria = new SimpleJugueteFactory();
        int numRotos = 0;

        for (int i = 0; i < cantidadProduccion; i++) {
            Juguete aux = factoria.createJuguete(modelo, porcentajeFallo);
            if (aux.isRoto()) {
                numRotos++;
            } else {
                juguetes.add(aux);
            }
        }
        if (numRotos > 0) {
            System.out.print("Se han roto: " + numRotos + " juguetes\n");
        }
        return juguetes;
    }
}
