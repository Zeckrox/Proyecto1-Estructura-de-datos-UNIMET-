/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package logica;

/**
 *
 * @author Stefano Boschetti
 * @author Diego De Jesus
 */
public class ListaDoble {
    public Nodo first;
    public Nodo last;
    public int size;
    
    public ListaDoble () {
        first = null;
        last = null;
        size = 0;
    }
    
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
    }
    
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
    }
    
    public boolean contains(String toSearch){
        for(Nodo i = first; i!= null; i = i.next){
            if(i.text.equals(toSearch)){
                return true;
            }
        }
        return false;
    }
    
    public void print(){
        for(Nodo i = first; i != null; i = i.next){
            System.out.println(i.text);
        }
    }
}
