/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package estrategias;

import fabrica.Juguete;

/**
 *
 * @author Ander
 */
import java.util.*;
import fabrica.*;

public class ProduccionNormal implements EstrategiaProduccion{ //Esta estrategia será la estandar
    private int cantidadProduccion;
    private double porcentajeFallo;
    
    public ProduccionNormal(){
        this.cantidadProduccion=10;
        this.porcentajeFallo=0.05;
    }
    
    public int getCantidadProduccion(){
        System.out.print("Hemos cambiado la produccion a Normal");
        return this.cantidadProduccion;
    }
    
    public ArrayList<Juguete> producir(String modelo) {
        ArrayList<Juguete> juguetes = new ArrayList();
        SimpleJugueteFactory factoria = new SimpleJugueteFactory();

        for (int i = 0; i < cantidadProduccion; i++) {
            Juguete aux = factoria.createJuguete(modelo, porcentajeFallo);
            juguetes.add(aux);
        }
        return juguetes;
    }
    
}
