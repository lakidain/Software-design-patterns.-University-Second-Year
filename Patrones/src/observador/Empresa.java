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
public class Empresa implements IObservador {  
//Clase creada para el patrón observador notificaremos a las empresas cuando se produzca nuevo stock

    private String nombre;

    public Empresa(String nombreEmpresa) {
        this.nombre = nombreEmpresa;
    }

    public void update(String aviso) {
        System.out.println("La empresa " + this.nombre + " ha recibido el aviso: " + aviso); 
    }

    public String getNombre() {
        return this.nombre;
    }

    public boolean equals(Empresa o) {
        if (this.nombre.equals(o.getNombre())) {
            return true;
        } else {
            return false;
        }
    }

}
