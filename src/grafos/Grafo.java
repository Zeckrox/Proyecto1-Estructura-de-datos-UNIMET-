/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package grafos;

/**
 *
 * @author Stefano
 */
public class Grafo {
//  Grafo no dirigido con lista de adyacencia
    int maxNodos; // Tamaño máximo de la tabla.
    int numVertices; // Número de vértices del grafo.
    Lista listaAdy []; // Vector de listas de adyacencias del grafo.
    
    public Grafo (int n) {
        maxNodos = n;
        numVertices = 0;
        listaAdy = new Lista[n];
    }
    
    public void crearVertice (String name) {
        int newId = numVertices;
        if (numVertices + 1 > maxNodos){
                System.out.println ("Error, se supera el número de nodos máximo del grafo");
        }
        else{
            listaAdy[newId]= new Lista(name);
            numVertices += 1;
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
    
    public void print(){
        for(int i = 0; i < numVertices; i++){
            System.out.print(String.format("listaAdy[%d](%s): ", i, listaAdy[i].nombre));
            listaAdy[i].print();
        }
    }
}
