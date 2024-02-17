/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package grafos;

/**
 *
 * @author necro
 */
public class Nodo {
    public int id;
    public int distancia;
    public int feromonas;
    public Nodo next;
    public Nodo previous;
    
    public Nodo (int data, int distance ) {
        id = data;
        distancia = distance;
        next = null;
        previous = null;
    }
}
