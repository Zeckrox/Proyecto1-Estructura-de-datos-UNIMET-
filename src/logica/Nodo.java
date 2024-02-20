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
public class Nodo {
    public String text;
    public Nodo next;
    public Nodo previous;
    
    public Nodo (String data ) {
        text = data;
        next = null;
        previous = null;
    }
}
