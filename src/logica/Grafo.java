/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package logica;

import org.graphstream.graph.Graph;

/**
 *
 * @author Stefano Boschetti
 * @author Diego De Jesus
 */
public class Grafo {
//  Grafo no dirigido con lista de adyacencia
    public int maxNodos; // Cantidad maxima de ciudades.
    public int numVertices; // Número de vértices del grafo.
    public static float factorEvaporacion = (float) 0.5;
    public ListaVertice listaAdy []; // Array de listas, donde cada lista es un Vertice y sus nodos son Aristas
    public float distanciasSimulacion[][];
    public String recorridosSimulacion[][];
    
    public Grafo (int n) {
        maxNodos = n;
        numVertices = 0;
        listaAdy = new ListaVertice[n];
    }
    
    public void crearVertice (String name) {
        int newId = numVertices;
        if (numVertices + 1 > maxNodos){
                System.out.println ("Error, se supera el número de nodos máximo del grafo");
        }
        else{
            listaAdy[newId]= new ListaVertice(name, newId);
            numVertices += 1;
        }
    }
    
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
    }
    
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
    }
    
    public void eliminarArista(int i, int j) {
        if (j >= numVertices) {
            System.out.println("Error, no existe el vértice en el grafo");
        } else {
            listaAdy[i].delete(j);
            listaAdy[j].delete(i);
        }
    }
    
    public void almacenarPrevFeromonas(){
        for (int i = 0; i < numVertices; i++) {
            for (NodoArista auxNodo = listaAdy[i].first; auxNodo != null; auxNodo = auxNodo.next) {
                auxNodo.prevFeromonas = auxNodo.feromonas;
            }
        }
    }
    
    public void evaporarFeromonas() {
        for (int i = 0; i < numVertices; i++) {
            for (NodoArista auxNodo = listaAdy[i].first; auxNodo != null; auxNodo = auxNodo.next) {
                float evaporacionPrev = auxNodo.prevFeromonas * (1 - factorEvaporacion);
                float nuevasFeromonas = auxNodo.feromonas - auxNodo.prevFeromonas; 
                auxNodo.feromonas = evaporacionPrev + nuevasFeromonas;
            }
        }
    }
    
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
        
    }
    
    public void vaciarGrafo(){
        while(true){
            if(numVertices == 0){
                break;
            }
            eliminarVertice(numVertices-1);
        }
    }
    
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
    }
    
    public void vaciarGraphStream(Graph graph){
        while (true) {
            if (graph.getNodeCount() == 0) {
                break;
            }
            graph.removeNode(graph.getNodeCount() - 1);
        }
    }
    
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
    }
    
    public void print(){
        for(int i = 0; i < numVertices; i++){
            System.out.print(String.format("listaAdy[%d](%s): ", i, listaAdy[i].nombre));
            listaAdy[i].print();
        }
    }
}
