package logica;

/**
 * Esta clase define nuestro Nodo que funcionara como complemento de ListaDoble
 * para almacenar cadenas de texto.
 * 
 * @author: Stefano Boschetti
 * @author: Diego De Jesus
 * @version: 20/02/2024
 */
public class Nodo {
//    Campos de la clase
    public String text;
    public Nodo next;
    public Nodo previous;
    
/**
 * Constructor para el Nodo.
 *
 * @param data Cadena de texto almacenada en el nodo.
 */
    public Nodo (String data ) {
        text = data;
        next = null;
        previous = null;
    }//Cierre del constructor
}//Cierre de la clase
