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
public abstract class Juguete {  //Para poder aplicar el patron factoria
    private int precio;
    private String nombre;
    private boolean roto;
    //private int numSerie;
    
    public int getPrecio(){
        return this.precio;
    }
    
    public String getNombre(){
        return this.nombre;
    }
    
    public void setPrecio(int precio){
        this.precio=precio;
    }
    
    public void setRoto(boolean roto){
        this.roto=roto;
    }
    public boolean isRoto(){
        return this.roto;
    }
    
    /*public int getNumeroSerie(){
        return this.numSerie;
    }
    
    public void setNumeroSerie(int numeroSerie){
        this.numSerie=numeroSerie;
    }*/
}
