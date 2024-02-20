/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package logica;
import GUI.VentanaInicial;
import org.graphstream.graph.Graph;
import org.graphstream.graph.implementations.SingleGraph;
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
        System.setProperty("org.graphstream.ui", "swing");
//        Nuestro grafo inicial.
        Grafo myGrafo = new Grafo(20);
        myGrafo.crearVertice("Caracas");
        myGrafo.crearVertice("Valencia");
        myGrafo.crearVertice("Barquisimeto");
        myGrafo.crearVertice("Cumanare");
        myGrafo.crearVertice("Cagua");
        myGrafo.crearArista(0,1,(float)80.5);
        myGrafo.crearArista(0,2,(float)78.3);
        myGrafo.crearArista(2,4,(float)50.2);
        myGrafo.crearArista(1,3,(float)45.9);
        myGrafo.crearArista(3,4,(float)20.1);
//        Generamos el grafo para visualizar.
        Graph graph = new SingleGraph("Simulacion");
        myGrafo.copiarEnGraphStream(graph);
        
//        Iniciamos la ventana principal de programa.
        VentanaInicial myVentana = new VentanaInicial(myGrafo, graph);
        myVentana.setVisible(true);
        myVentana.setLocationRelativeTo(null);
        
    }
}
