/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package grafos;

/**
 *
 * @author Diego
 */
public class Hormiga {
    public static int nido;
    public static int comida;
    public static int cantidadCiclos = 100;
    public static int gradoImportanciaFeromona = 1;
    public static int gradoVisibilidadCiudad = 2;
    public static int cantidadCiudades;
    public static int ciudadesVisitadas[];
    public static Grafo grafo;
    public static int ubicacion;
    
    public Hormiga(int nest, int food, int cities, Grafo grafoPadre){
        nido = nest;
        ubicacion = nest;
        comida = food;
        cantidadCiudades = cities;
        ciudadesVisitadas = new int[cities];
        ciudadesVisitadas[0] = nest;
        grafo = grafoPadre;
    }
    
    public boolean seVisito(int idCiudad){
        for(int i = 0; i < cantidadCiudades; i++){
            if(ciudadesVisitadas[i] == idCiudad ){
                return true;
            }
        }
        return false;
    }
    
    public int ciudadesValidas(ListaVertice ciudadInicial) {
        int arrSize = 0;
        for (NodoArista auxNodo = ciudadInicial.first; auxNodo != null; auxNodo = auxNodo.next) {
            if(!seVisito(auxNodo.id)){
                arrSize++;
            }
        }
        return arrSize;
    }
    
    public boolean viajar(){
        int proxCiudades[] = new int[ciudadesValidas(grafo.listaAdy[ubicacion])];
        int proxDistancia[] = new int[ciudadesValidas(grafo.listaAdy[ubicacion])];
        
        NodoArista auxNodo = grafo.listaAdy[ubicacion].first;
        int i = 0;
        while(true){
            if (auxNodo == null){
                break;
            }
            if(!seVisito(auxNodo.id)){
                proxCiudades[i] = auxNodo.id;
                proxDistancia[i] = auxNodo.distancia;
                i++;
            }
            auxNodo = auxNodo.next;
            
        }
        if (proxCiudades.length == 1){
            ubicacion = proxCiudades[0];
        }
        System.out.println(ubicacion);
        return false;
    }
}
