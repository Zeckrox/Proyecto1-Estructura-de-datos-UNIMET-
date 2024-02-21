package logica;
import org.graphstream.graph.Graph;

/**
 * Esta clase define nuestra estructura de dato Grafo, 
 * se trata de un grafo no dirigo implementado con lista de adyacencias.
 * 
 * @author: Stefano Boschetti
 * @author: Diego De Jesus
 * @version: 20/02/2024
 */


public class Grafo {
//    Campos de la clase
    public int maxNodos; // Cantidad maxima de ciudades.
    public int numVertices; // Cantidad de ciudades.
    public static float factorEvaporacion;
    public ListaVertice listaAdy []; // Array de listas, donde cada lista es un Vertice y sus nodos son Aristas
    public float distanciasSimulacion[][];
    public String recorridosSimulacion[][];
    
    
/**
 * Constructor para el Grafo.
 *
 * @param n Indica la cantidad maxima de nodos/ciudades que tendrá el grafo.
 */
    public Grafo (int n) {
        maxNodos = n;
        numVertices = 0;
        listaAdy = new ListaVertice[n];
        factorEvaporacion = (float) 0.5;
    }//Cierre del constructor
    
    
/**
 * Método que crea un NodoVertice y lo almacena dentro de listaAdy,
 * arreglo donde se almacenan nuestros Vertices.
 *
 * @param name Nombre referencial que recibira el nodo/ciudad.
 */
    public void crearVertice (String name) {
        int newId = numVertices;
        if (numVertices + 1 > maxNodos){
                System.out.println ("Error, se supera el número de nodos máximo del grafo");
        }
        else{
            listaAdy[newId]= new ListaVertice(name, newId);
            numVertices += 1;
        }
    }//Cierre del método
    
    
/**
 * Método que elimina un NodoVertice a partir de su identificador.
 *
 * @param id Numero entero identificador del NodoVertice a eliminar.
 */
    public void eliminarVertice (int id){
       for(NodoArista auxNodo = listaAdy[id].first; auxNodo != null; auxNodo = auxNodo.next){
           eliminarArista(id,auxNodo.id);
       }
       for(int i = id; i < numVertices; i++){
           listaAdy[i] = listaAdy[i+1];
       }
       numVertices--;
       
       for(int j = 0; j < numVertices; j++){
           for(NodoArista tempNode = listaAdy[j].first; tempNode != null; tempNode = tempNode.next){
               if(tempNode.id > id){
                   tempNode.id--;
               }
           }
       }
    }//Cierre del método
   
    
/**
 * Método que crea una Arista entre dos Vertices dados.
 *
 * @param i Identificador del primer Vertice.
 * @param j Identificador del segundo Vertice.
 * @param distancia Distancia entre ambos Vertices.
 */
    public void crearArista (int i, int j, float distancia) {
        if (i >= numVertices){
            System.out.println ("Error, no existe el vértice en el grafo");
        }
        else {
            if (!listaAdy[i].contains(j) && !listaAdy[j].contains(i)){
                listaAdy[i].push(j, distancia);
                listaAdy[j].push(i, distancia);
            }  
        }
    }//Cierre del método
   
    
/**
 * Método que elimina una Arista entre dos Vertices dados.
 *
 * @param i Identificador del primer Vertice.
 * @param j Identificador del segundo Vertice.
 */
    public void eliminarArista(int i, int j) {
        if (j >= numVertices) {
            System.out.println("Error, no existe el vértice en el grafo");
        } else {
            listaAdy[i].delete(j);
            listaAdy[j].delete(i);
        }
    }//Cierre del método
    
    
/**
 * Método que almacena el valor de las feromonas en prevFeromonas.
 */
    public void almacenarPrevFeromonas(){
        for (int i = 0; i < numVertices; i++) {
            for (NodoArista auxNodo = listaAdy[i].first; auxNodo != null; auxNodo = auxNodo.next) {
                auxNodo.prevFeromonas = auxNodo.feromonas;
            }
        }
    }//Cierre del método
    
    
/**
 * Método que actualiza el valor de feromonas en todos los Vertices.
 */
    public void evaporarFeromonas() {
        for (int i = 0; i < numVertices; i++) {
            for (NodoArista auxNodo = listaAdy[i].first; auxNodo != null; auxNodo = auxNodo.next) {
                float evaporacionPrev = auxNodo.prevFeromonas * (1 - factorEvaporacion);
                float nuevasFeromonas = auxNodo.feromonas - auxNodo.prevFeromonas;
                auxNodo.feromonas = evaporacionPrev + nuevasFeromonas;
            }
        }
    }//Cierre del método
    
    
/**
 * Método que inicia una nueva simulacion replicando un algoritmo de 
 * optimización basado en el comportamiento de colonias de hormigas.
 * 
 * @param nido Posición del NodoVertice del cual parten las hormigas.
 * @param comida Posición del NodoVertice al cual buscaran llegar las hormigas.
 * @param cantidadCiclos Cantidad de ciclos que ocurriran en la simulación.
 * @param cantidadHormigas Cantidad de hormigas que formaran parte de la simulación.
 * @param importanciaFeromona Valor del grado de importancia de la feromona (α).
 * @param visibilidadCiudad Valor del grado de visibilidad de las ciudades (β).
 * @param factEvaporacion Valor del factor de evaporacion de las feromonas (ρ).
 */
    public void iniciarSimulacion(int nido, int comida, int cantidadCiclos, int cantidadHormigas,
            int importanciaFeromona, int visibilidadCiudad, float factEvaporacion){
//        Se cambia el factor de evaporación.
          factorEvaporacion = factEvaporacion;
//        Se inicializan el valor inicial de feromonas (t) en los caminos (t=1/m Donde m es la cantidad de ciudades)
        for(int i = 0; i < numVertices; i++){
            for(NodoArista j = listaAdy[i].first; j != null; j = j.next){
                j.feromonas = (float) 1 / numVertices;
            }
        }
//        Se generan las hormigas y se realizan los respectivos ciclos.
        distanciasSimulacion = new float[cantidadCiclos][cantidadHormigas];
        recorridosSimulacion = new String[cantidadCiclos][cantidadHormigas];
        for(int i = 0; i < cantidadCiclos; i++){
            almacenarPrevFeromonas();
            Hormiga auxHormiga = new Hormiga(nido, comida, numVertices, this, importanciaFeromona, visibilidadCiudad);
            for(int j = 0; j < cantidadHormigas; j++){
                String[] auxArr = auxHormiga.buscarComida();
                recorridosSimulacion[i][j] = auxArr[0];
                distanciasSimulacion[i][j] = Float.parseFloat(auxArr[1]);
            }
            evaporarFeromonas();
        }
    }//Cierre del método
    
    
/**
 * Método que elimina todas las Aristas y Vertices del Grafo.
 */
    public void vaciarGrafo(){
        while(true){
            if(numVertices == 0){
                break;
            }
            eliminarVertice(numVertices-1);
        }
    }//Cierre del método
    
    
/**
 * Método que replica el Grafo actual en una objeto graficable 
 * por la libreria GraphStream.
 * 
 * @param graph Grafo de GraphStream que se busca sustituir.
 */
    public void copiarEnGraphStream(Graph graph){
        for (int i = 0; i < numVertices; i++) {
            graph.addNode(String.format("(%d)", i) + listaAdy[i].nombre)
                    .setAttribute("ui.label", String.format("(%d)", i) + listaAdy[i].nombre);
        }
        for (int j = 0; j < numVertices; j++) {
            for (NodoArista auxNode = listaAdy[j].first; auxNode != null; auxNode = auxNode.next) {
                String from = String.format("(%d)", j) + listaAdy[j].nombre;
                String to = String.format("(%d)", auxNode.id) + listaAdy[auxNode.id].nombre;
                if (!graph.getNode(from).hasEdgeBetween(to)) {
                    graph.addEdge(from + to, from, to).setAttribute("ui.label", auxNode.distancia);
                }
            }
        }
    }//Cierre del método
    
    
/**
 * Método que elimina todas las Aristas y Vertices de un grafo 
 * de la libreria GraphStream.
 *
 * @param graph Grafo de GraphStream que se busca vaciar.
 */
    public void vaciarGraphStream(Graph graph){
        while (true) {
            if (graph.getNodeCount() == 0) {
                break;
            }
            graph.removeNode(graph.getNodeCount() - 1);
        }
    }//Cierre del método
    
    
/**
 * Método que devuelve el recorrido más frecuentados 
 * en un ciclo o simulación.
 *
 * @param recorridos Arreglo de recorridos a evaluar.
 * @return Nodo que contiene el recorrido más frecuentado.
 */
    public Nodo recorridoMasFrecuente(String[] recorridos){
        ListaDoble posiblesRecorridos = new ListaDoble();
//        Se analizan todos los posible recorridos
        for (int i = 0; i < recorridos.length; i++) {
            if (!posiblesRecorridos.contains(recorridos[i])) {
                posiblesRecorridos.push(recorridos[i]);
            }
        }
//        Y se buscan las ocurrencias de estos caminos para determinar el mas optimo.
        int ocurrencias[] = new int[posiblesRecorridos.size];
        for (int i = 0; i < recorridos.length; i++) {
            Nodo auxNodo = posiblesRecorridos.first;
            for (int j = 0; j < ocurrencias.length; j++) {
                if (auxNodo.text.equals(recorridos[i])) {
                    ocurrencias[j]++;
                }
                auxNodo = auxNodo.next;
            }
        }
//        Se almacena la posicion con mayor ocurrencias
        int caminoOptimo = -1;
        for (int index = 0; index < ocurrencias.length; index++) {
            if (caminoOptimo == -1) {
                caminoOptimo = index;
            } else if (ocurrencias[index] > ocurrencias[caminoOptimo]) {
                caminoOptimo = index;
            }
        }
//        Y ahora se busca en los posibles caminos el valor del camino optimo.
        Nodo caminoIdeal = posiblesRecorridos.first;
        for (int indice = 0; indice != caminoOptimo; indice++) {
            caminoIdeal = caminoIdeal.next;
        }
        return caminoIdeal;
    }//Cierre del método


/**
 * Método que imprime de forma visual el estado del Grafo
 * en la consola del sistema.
 */    
    public void print(){
        for(int i = 0; i < numVertices; i++){
            System.out.print(String.format("listaAdy[%d](%s): ", i, listaAdy[i].nombre));
            listaAdy[i].print();
        }
    }//Cierre del método
}//Cierre de la clase
