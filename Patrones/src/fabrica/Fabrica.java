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
public class Fabrica implements ISujeto {  //Para poder apicar el patron Singleton con la factoria vamos a tener que meterle atributos porque si no con hacerla static bastaria, llamariamos a los metodos y se acabo

    private State estado;
    private ArrayList<Juguete> juguetes;
    private SimpleJugueteFactory factoria;
    private ArrayList<IObservador> subscriptores;
    private EstrategiaProduccion miEstrategia;
    private static Fabrica instancia;

    protected Fabrica() {
        this.juguetes = new ArrayList();
        this.subscriptores = new ArrayList();
        this.factoria = new SimpleJugueteFactory();
        this.miEstrategia = new ProduccionNormal();
        this.estado = new Normal();
    }

    public EstrategiaProduccion getMiEstrategia() {
        return this.miEstrategia;
    }

    public static Fabrica getInstance() { //Fabrica.getInstance()patron singleton, no podemos dejarlo como static porque entonces no podriamos acceder a los atributos de la clase
        if (instancia == null) {
            instancia = new Fabrica();
        }

        return instancia;
    }

    public void fabricar(String producto) {
        if (this.estado instanceof Llamas) {
            System.out.println("No puede producir con la fabrica en llamas! ¿Quiere llamar a los bomberos? Pulse 1 para llamarlos, otro numero para no llamarlos, la Navidad depende de usted :D");
            Scanner sc = new Scanner(System.in);
            int respuesta = sc.nextInt();
            if (respuesta == 1) {
                bomberos();
                System.out.println("Gracias por llamar a los bomberos, has salvado la Navidad :D");
            }
        } else {
            Random dado = new Random();
            juguetes.addAll(miEstrategia.producir(producto));
            if (dado.nextDouble() < 0.01) {
                this.estado = new Llamas();
            }
            String aviso = "Tenemos una producción de " + juguetes.size() + " pueden pasar a comprarlos cuando deseen";
            notificarSubscriptores(aviso);
        }
        System.out.println(this.estado.handle());
    }

    public void bomberos() {
        this.estado = new Normal();
        System.out.println("Los bomberos se han encargado de la emergencia, puede continuar la producción");
    }

    public void cambiarProduccion(EstrategiaProduccion estrategy) {
        this.miEstrategia = estrategy;
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
    public void listarSocios(){
        Iterator it = subscriptores.iterator();
        int c = 0;
        if (!subscriptores.isEmpty()) {
            System.out.println("Listado de empresas:");
            while (it.hasNext()) {
                Empresa aux = (Empresa) it.next();
                System.out.print("\t" + aux.getNombre());
                if (c > 3) {
                    System.out.println("");
                }

            }
        } else {
            System.out.println("No hay empresas Subscriptas");
        }
    }

    public void notificarSubscriptores(String aviso) {
        int i;

        for (i = 0; i < this.subscriptores.size(); i++) {
            this.subscriptores.get(i).update(aviso);
        }
    }
}
