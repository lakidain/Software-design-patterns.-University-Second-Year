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
import observador.*;
import estrategias.*;
import java.util.*;
import state.*;

//Patron factoria
public class Fabrica implements ISujeto {

    /*Para poder apicar el patron Singleton con la factoria vamos a tener que
    meterle atributos porque si no con hacerla static bastaria, llamariamos a 
    los metodos y se acabo
     */

    private State estado;
    private ArrayList<Juguete> juguetes;
    private ArrayList<IObservador> subscriptores;
    private EstrategiaProduccion miEstrategia;
    private static Fabrica instancia;

    protected Fabrica() {
        this.juguetes = new ArrayList();
        this.subscriptores = new ArrayList();
        this.miEstrategia = new ProduccionNormal();
        this.estado = new Normal();
    }

    public EstrategiaProduccion getMiEstrategia() {
        return this.miEstrategia;
    }

    public static Fabrica getInstance() {
        /*Fabrica.getInstance()patron singleton, no podemos dejarlo como static
        porque entonces no podriamos acceder a los atributos de la clase
         */
        if (instancia == null) {
            instancia = new Fabrica();
        }

        return instancia;
    }

    public void addJuguetes(String producto) {
        juguetes.addAll(miEstrategia.producir(producto));
    }

    public int getJuguetesSize() {
        return juguetes.size();
    }

    public void fabricar(String producto) {
        this.estado.handle(producto);
    }

    public void cambiarProduccion(EstrategiaProduccion estrategy) {
        this.miEstrategia = estrategy;
    }

    public void cambiarEstado(State estado) {
        this.estado = estado;
    }

    public void listarSocios() {
        Iterator it = subscriptores.iterator();
        int c = 1;
        if (!subscriptores.isEmpty()) {
            System.out.println("Listado de empresas:");
            while (it.hasNext()) {
                Empresa aux = (Empresa) it.next();
                System.out.print("\t" + aux.getNombre());
                if (c % 3 == 0) {
                    System.out.println();
                }
                c++;

            }
            System.out.println();
        } else {
            System.out.println("No hay empresas Subscriptas");
        }
    }

    public void subscribirse(IObservador o) {
        Iterator iterador = this.subscriptores.iterator();
        boolean encontrado = false;
        Empresa ao = (Empresa) o;

        while (iterador.hasNext()) {
            Empresa comparar = (Empresa) iterador.next();
            if (comparar.equals(ao)) {
                encontrado = true;
            }
        }

        if (encontrado == false) {
            this.subscriptores.add(o);
        }
    }

    public String getModelos() {
        ArrayList<Juguete> modelo = new ArrayList(this.juguetes);
        ArrayList numeroModelos = new ArrayList();
        String mensaje = "";

        Collections.sort(modelo);

        int contador = 1;

        if (modelo.get(0) != null) {
            String aux = modelo.get(0).getNombre();

            for (int i = 1; i < modelo.size(); i++) {
                if (modelo.get(i).getNombre().equals(aux)) {
                    contador++;
                } else {
                    mensaje = mensaje + " Modelo: " + aux + " Stock: " + contador;
                    aux = modelo.get(i).getNombre();
                    contador = 1;
                }
            }
            mensaje = mensaje + " Modelo: " + aux + " Stock: " + contador;
        } else {
            mensaje = mensaje + "\nNo tenemos produccion disponible.";
        }

        return mensaje;
    }

    public void desubscribirse(IObservador o) {
        Iterator iterador = this.subscriptores.iterator();
        Empresa ao = (Empresa) o;

        while (iterador.hasNext()) {
            Empresa comparar = (Empresa) iterador.next();
            if (comparar.equals(ao)) {
                iterador.remove();
            }
        }
    }

    public void notificarSubscriptores(String aviso) {
        int i;

        for (i = 0; i < this.subscriptores.size(); i++) {
            this.subscriptores.get(i).update(aviso);
        }
    }
}
