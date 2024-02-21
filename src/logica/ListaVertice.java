package logica;

/**
 * Esta clase es una estructura de dato de tipo Lista Doblemente Enlazada,
 * que funciona como Vertice o Ciudad en el Grafo.
 * 
 * @author: Stefano Boschetti
 * @author: Diego De Jesus
 * @version: 20/02/2024
 */
public class ListaVertice {
//    Campos de la clase
    public int id;
    public String nombre;
    public NodoArista first;
    public NodoArista last;
    public int size;
    
    
/**
 * Constructor para la ListaDoble.
     * @param name Nombre que recibira la ListaVertice o ciudad.
     * @param identifier Número identificador de la ListaVertice o ciudad.
 */
    public ListaVertice (String name, int identifier) {
        id = identifier;
        nombre = name;
        first = null;
        last = null;
        size = 0;
    }//Cierre del constructor
    
    
/**
 * Método que inserta un nuevo NodoArista al final de la ListaVertice.
 *
 * @param newData Número identificador del NodoArista al que se dirige la Arista. 
 * @param distancia Distancia entre este NodoArista y el indicado en newData.
 */
    public void push(int newData, float distancia){
        NodoArista newNodo = new NodoArista(newData, distancia);
        if(size==0){
            first = newNodo;
            last = newNodo;
        }
        else if(first==last){
            first.next = newNodo;
            newNodo.previous = first;
            last = newNodo;
        }
        else{
            last.next = newNodo;
            newNodo.previous = last;
            last = newNodo;
        }
        size += 1;
    }//Cierre del método

    
/**
 * Método que elimina un NodoArista de la ListaVertuce dado un identificador.
 *
 * @param toDelete Número identificador contenido dentro del NodoArista.id a
 * eliminar.
 */
    public void delete(int toDelete){
        if (size != 0){
            if(first == last){
                if(first.id == toDelete){
                    first = null;
                    last = null;
                    size -= 1; 
                }
            }
            else if (first.id == toDelete){
                
                first = first.next;
                first.previous = null;
                size -= 1;
            }
            else if (last.id == toDelete){
                last = last.previous;
                last.next = null;
                size -= 1;
            }
            else{
                for(NodoArista i = first.next; i!= last; i = i.next){
                    if(i.id == toDelete){
                        i.previous.next = i.next;
                        i.next.previous = i.previous;
                        size -= 1;
                        break;
                    }
                }
            }
        }
    }//Cierre del método
    
    
/**
 * Método que devuelve Verdadero si encuentra el NodoArista que contiene
 * el número identificador dado.
 *
 * @param toSearch Número identificador del NodoArista a buscar.
 * @return Devuelve Verdadero si se encuentra un NodoArista o Falso si
 * no se encuentra.
 */
    public boolean contains(int toSearch){
        for(NodoArista i = first; i!= null; i = i.next){
            if(i.id == toSearch){
                return true;
            }
        }
        return false;
    }//Cierre del método
    
    
/**
 * Método que imprime de forma visual el contenido de todos los NodoArista en la
 * lista.
 */
    public void print(){
        for(NodoArista i = first; i != null; i = i.next){
            System.out.print(i.id);
            System.out.print("//");
            System.out.print(String.format("%fm",i.distancia) );
            System.out.print(", ");
        }
        System.out.println("");
    }//Cierre del método
}//Cierre de la clase
