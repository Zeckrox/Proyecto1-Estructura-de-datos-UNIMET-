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
public class NodoArista {
    public int id;
    public int distancia;
    public float prevFeromonas;
    public float feromonas;
    public NodoArista next;
    public NodoArista previous;
    
    public NodoArista (int data, int distance ) {
        id = data;
        distancia = distance;
        next = null;
        previous = null;
    }
}
