package logica;

/**
 * Esta clase define nuestro NodoArista que funcionara como ciudad de nuestra
 * simulación.
 * 
 * @author: Stefano Boschetti
 * @author: Diego De Jesus
 * @version: 20/02/2024
 */
public class NodoArista {
    public int id;
    public float distancia;
    public float prevFeromonas;
    public float feromonas;
    public NodoArista next;
    public NodoArista previous;
    
    
/**
 * Constructor para el NodoArista.
 *
 * @param data Identificador del segundo NodoVertice de la Arista.
 * @param distance Distancia entre ambos Vertices.
 */
    public NodoArista (int data, float distance ) {
        id = data;
        distancia = distance;
        next = null;
        previous = null;
    }//Cierre del constructor
}//Cierre de la clase
