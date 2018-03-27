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

public interface EstrategiaProduccion {
    public ArrayList<Juguete> producir(String modelo);
}
