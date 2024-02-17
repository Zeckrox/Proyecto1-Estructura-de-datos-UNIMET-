/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package grafos;

/**
 *
 * @author necro
 */
public class Lista {
    public String nombre;
    public Nodo first;
    public Nodo last;
    public int size;
    
    public Lista (String name) {
        nombre = name;
        first = null;
        last = null;
        size = 0;
    }
    
    public void push(int newData, int distancia){
        Nodo newNodo = new Nodo(newData, distancia);
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
                for(Nodo i = first.next; i!= last; i = i.next){
                    if(i.id == toDelete){
                        i.previous.next = i.next;
                        i.next.previous = i.previous;
                        size -= 1;
                        break;
                    }
                }
            }
        }
    }
    
    public boolean contains(int toSearch){
        for(Nodo i = first; i!= null; i = i.next){
            if(i.id == toSearch){
                return true;
            }
        }
        return false;
    }
    
    public void print(){
        for(Nodo i = first; i != null; i = i.next){
            System.out.print(i.id);
            System.out.print("//");
            System.out.print(String.format("%dm",i.distancia) );
            System.out.print(", ");
        }
        System.out.println("");
    }
}
