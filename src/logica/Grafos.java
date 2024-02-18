/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package logica;

/**
 *
 * @author Stefano Boschetti
 * @author Diego De Jesus
 */
public class Grafos {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Grafo myGrafo = new Grafo(20);
        myGrafo.crearVertice("Caracas");
        myGrafo.crearVertice("Valencia");
        myGrafo.crearVertice("Barquisimeto");
        myGrafo.crearVertice("Cumanare");
        myGrafo.crearVertice("Cagua");
        myGrafo.crearArista(0,1,800);
        myGrafo.crearArista(0,2,500);
        myGrafo.crearArista(1,4,800);
        myGrafo.crearArista(4,3,700);
        myGrafo.print();
        
        myGrafo.iniciarSimulacion(0, 3, 1, 2, 1, 2, (float)0.5);
        
    }
}
