/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package main;

/**
 *
 * @author Ander
 */
import java.util.*;
import fabrica.*;
import estrategias.*;
import observador.*;

public class Main { //Aqui irá un menu con opciones que irá mostrando en pantalla lo que va sucediendo, simularemos el control del stock desde aqui al igual que la fabricacion

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        int numeroIntroducido = 0;
        Fabrica fabrica = Fabrica.getInstance();
        EstrategiaProduccion festiva = new ProduccionFestiva();
        EstrategiaProduccion normal = new ProduccionFestiva();

        while (numeroIntroducido != 6) {
            Scanner sc = new Scanner(System.in);
            mostrarMenu();
            numeroIntroducido = sc.nextInt();
            switch (numeroIntroducido) {
                case 1:
                    System.out.println("Escriba el tipo de producto que quiere fabricar: Soldado, Unicornio");
                    String producto = sc.next();
                    fabrica.fabricar(producto);
                    break;
                case 2:
                    if (fabrica.getMiEstrategia() instanceof ProduccionFestiva) {
                        System.out.println("Teniamos produccción Festiva, cambiamos a Producción Normal");
                        fabrica.cambiarProduccion(normal);
                    } else {
                        System.out.println("Teniamos produccción Normal, cambiamos a Producción Festiva");
                        fabrica.cambiarProduccion(festiva);
                    }
                    break;
                case 3:
                    System.out.println("Introduzca el nombre de la empresa que quiere introducir");
                    String empresa = sc.next();
                    IObservador subscrita = new Empresa(empresa);
                    fabrica.subscribirse(subscrita);
                    break;
                case 4:
                    System.out.println("Introduzca el nombre de la empresa que quiere borrar");
                    String noempresa = sc.next();
                    IObservador nosubscrita = new Empresa(noempresa);
                    fabrica.desubscribirse(nosubscrita);
                    break;

            }
        }
    }

    public static void mostrarMenu() {
        System.out.println("[1] Producir tanda de juguetes");
        System.out.println("[2] Cambiar tipo de producción entre Normal/Festiva");
        System.out.println("[3] Añadir Empresa al boletin");
        System.out.println("[4] Borrar Empresa del boletin");
        System.out.println("[5] Visualizar socios");
        System.out.println("[6] Salir");
    }
}
