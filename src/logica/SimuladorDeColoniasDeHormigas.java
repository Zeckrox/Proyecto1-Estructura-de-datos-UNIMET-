package logica;
import GUI.VentanaInicial;
import org.graphstream.graph.Graph;
import org.graphstream.graph.implementations.SingleGraph;

/**
 * Esta clase inicializa nuestro programa crea un estado inicial para los grafo
 * e inicializa la ventana donde se visualizara el programa. 
 * 
 * @author: Stefano Boschetti
 * @author: Diego De Jesus
 * @version: 20/02/2024
 */
public class SimuladorDeColoniasDeHormigas {

/**
 * Método main del programa.
 * 
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
}//Cierre de la clase
