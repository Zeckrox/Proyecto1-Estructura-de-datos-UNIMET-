/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package grafos;

/**
 *
 * @author Stefano
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
        myGrafo.crearArista(0,1,75);
        myGrafo.crearArista(1,4,100);
        myGrafo.crearArista(4,2,23);
        myGrafo.crearArista(2,3,50);
        myGrafo.print();
        myGrafo.inicializarValores(0,3);
        Hormiga myHormiga = new Hormiga(1,3,4,myGrafo);
        myHormiga.viajar();
    }
}
