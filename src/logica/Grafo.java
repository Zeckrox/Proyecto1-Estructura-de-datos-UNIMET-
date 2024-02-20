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
public class Grafo {
//  Grafo no dirigido con lista de adyacencia
    public int maxNodos; // Cantidad maxima de ciudades.
    public int numVertices; // Número de vértices del grafo.
    public static float factorEvaporacion = (float) 0.5;
    public ListaVertice listaAdy []; // Array de listas, donde cada lista es un Vertice y sus nodos son Aristas
    public int distanciasSimulacion[][];
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
    
    public void crearArista (int i, int j, int distancia) {
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
    
    public void evaporarFeromonas() {
        for (int i = 0; i < numVertices; i++) {
            for (NodoArista auxNodo = listaAdy[i].first; auxNodo != null; auxNodo = auxNodo.next) {
                auxNodo.feromonas = auxNodo.feromonas * (1 - factorEvaporacion);
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
        distanciasSimulacion = new int[cantidadCiclos][cantidadHormigas];
        recorridosSimulacion = new String[cantidadCiclos][cantidadHormigas];
        for(int i = 0; i < cantidadCiclos; i++){
            Hormiga auxHormiga = new Hormiga(nido, comida, numVertices, this, importanciaFeromona, visibilidadCiudad);
            for(int j = 0; j < cantidadHormigas; j++){
                String[] auxArr = auxHormiga.buscarComida();
                recorridosSimulacion[i][j] = auxArr[0];
                distanciasSimulacion[i][j] = Integer.parseInt(auxArr[1]);
            }
            evaporarFeromonas();
        }
        
    }
    
    public void print(){
        for(int i = 0; i < numVertices; i++){
            System.out.print(String.format("listaAdy[%d](%s): ", i, listaAdy[i].nombre));
            listaAdy[i].print();
        }
    }
}
