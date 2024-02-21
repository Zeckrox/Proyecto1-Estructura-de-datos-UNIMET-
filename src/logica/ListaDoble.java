package logica;

/**
 * Esta clase es una estructura de dato de tipo Lista Doblemente Enlazada.
 * 
 * @author: Stefano Boschetti
 * @author: Diego De Jesus
 * @version: 20/02/2024
 */
public class ListaDoble {
//    Campos de la clase
    public Nodo first;
    public Nodo last;
    public int size;

/**
 * Constructor para la ListaDoble.
 */
    public ListaDoble () {
        first = null;
        last = null;
        size = 0;
    }//Cierre del constructor
    
    
/**
 * Método que inserta un nuevo Nodo al final de la lista.
 *
 * @param newData Cadena de texto que se usará para crear el Nodo a insertar.
 */
    public void push(String newData){
        Nodo newNodo = new Nodo(newData);
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
 * Método que elimina un Nodo de la lista dada una cadena de texto.
 *
 * @param toDelete Cadena de texto contenida dentro del Nodo.text a eliminar.
 */    
    public void delete(String toDelete){
        if (size != 0){
            if(first == last){
                if(first.text.equals(toDelete)){
                    first = null;
                    last = null;
                    size -= 1; 
                }
            }
            else if (first.text.equals(toDelete)){
                
                first = first.next;
                first.previous = null;
                size -= 1;
            }
            else if (last.text.equals(toDelete)){
                last = last.previous;
                last.next = null;
                size -= 1;
            }
            else{
                for(Nodo i = first.next; i!= last; i = i.next){
                    if(i.text.equals(toDelete)){
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
 * Método que devuelve Verdadero si encuentra el Nodo
 * que contiene la cadena de texto dada.
 *
 * @param toSearch Cadena de texto a buscar.
 * @return Devuelve Verdadero si se encuentra la cadena de texto
 * o Falso si no se encuentra.
 */
    public boolean contains(String toSearch){
        for(Nodo i = first; i!= null; i = i.next){
            if(i.text.equals(toSearch)){
                return true;
            }
        }
        return false;
    }//Cierre del método
    
    
/**
 * Método que imprime de forma visual el contenido de todos los Nodos en la lista.
 */
    public void print(){
        for(Nodo i = first; i != null; i = i.next){
            System.out.println(i.text);
        }
    }//Cierre del método
}//Cierre de la clase
