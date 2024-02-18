/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package logica;
import java.util.Random;

/**
 * @author Stefano Boschetti
 * @author Diego De Jesus
 */
public class Hormiga {
    public static int nido;
    public static int comida;
    public static int gradoImportanciaFeromona = 1;
    public static int gradoVisibilidadCiudad = 2;
    public static int aprendizaje = 1;
    public final int constanteQ = 1;
    public static int cantidadCiudades;
    public static int ciudadesVisitadas[];
    public static int cantidadVisitadas;
    public static Grafo grafo;
    public static int ubicacion;
    
    public Hormiga(int nest, int food, int cities, Grafo grafoPadre, int importanciaFeromona, int visibilidadCiudad){
        nido = nest;
        ubicacion = nest;
        comida = food;
        cantidadCiudades = cities;
        ciudadesVisitadas = new int[cities];
        ciudadesVisitadas[0] = nest;
        cantidadVisitadas = 1;
        grafo = grafoPadre;
        gradoImportanciaFeromona = importanciaFeromona;
        gradoVisibilidadCiudad = visibilidadCiudad;
    }
    
    private boolean seVisito(int idCiudad){
        for(int i = 0; i < cantidadVisitadas; i++){
            if(ciudadesVisitadas[i] == idCiudad ){
                return true;
            }
        }
        return false;
    }
    
    private int ciudadesValidas(ListaVertice ciudadInicial) {
        int arrSize = 0;
        for (NodoArista auxNodo = ciudadInicial.first; auxNodo != null; auxNodo = auxNodo.next) {
            if(!seVisito(auxNodo.id)){
                arrSize++;
            }
        }
        return arrSize;
    }
    
    private void actualizarFeromonas(NodoArista caminoActualizar){
        float incremento = (float) constanteQ / caminoActualizar.distancia;
        caminoActualizar.feromonas += incremento;
    }
    
    private boolean viaje(){
        Random rand = new Random();
//        Ciudades disponibles para viajar.
        NodoArista proxCiudades[] = new NodoArista[ciudadesValidas(grafo.listaAdy[ubicacion])];
//        Probabilidad de viajar a las ciudades disponibles.
        float probViajar[] = new float[proxCiudades.length];
//        TODO
        float numProb[] = new float[proxCiudades.length];
//        proxCiudades[i] es el Nodo/Arista/Ciudad y probViajar[i] equivale a su probabilidad de viajar.


        NodoArista auxNodo = grafo.listaAdy[ubicacion].first;
        int i = 0;
//        Se realiza un bucle para ubicar las ciudades no visitadas a las cuales la hormiga podra viajar.
        while(true){
            if (auxNodo == null){
                break;
            }
            if(!seVisito(auxNodo.id)){
                proxCiudades[i] = auxNodo;
                i++;
            }
            auxNodo = auxNodo.next;
        }
        
//        Si no existen posibles ciudades la hormiga llego a una calle ciega, retornamos verdadero.
        if ( proxCiudades.length == 0 ){
            return true;
        }
        
//        Si solo existe una posible ciudad la hormiga viajara a ella.
        if ( proxCiudades.length == 1 ){
            actualizarFeromonas(proxCiudades[0]);
            ubicacion = proxCiudades[0].id;
            ciudadesVisitadas[cantidadVisitadas] = ubicacion;
            cantidadVisitadas += 1;
        }
        
//        Si no, se calcula la probabilidad de viajar a cada una.
        else{
            for (int j = 0; j < proxCiudades.length; j++){
                float numerador = 0;
                float denominador = 0;
                float nA = (float) Math.pow(proxCiudades[j].feromonas, gradoImportanciaFeromona);
                float nB = (float) Math.pow((float)aprendizaje / proxCiudades[j].distancia , gradoVisibilidadCiudad);
                numerador += nA*nB;
                
                for (int index = 0; index < proxCiudades.length; index++){
                    if(j != index){
                        float dA = (float) Math.pow(proxCiudades[index].feromonas, gradoImportanciaFeromona);
                        float dB = (float) Math.pow((float)aprendizaje / proxCiudades[index].distancia , gradoVisibilidadCiudad);
                        denominador += dA*dB;
                    }
                    
                }
                probViajar[j] = numerador/denominador;
            }
            
//            Calculamos el numero en base al cual generaremos un numero aleatorio.
            float numeroMaxAleatorio = 0;
            for (int index = 0; index < probViajar.length; index++) {
                numeroMaxAleatorio += probViajar[index];
                numProb[index] += numeroMaxAleatorio;
            }

//            Generamos el numero aleatorio y seleccionamos un camino.
            float numAleatorio = rand.nextFloat(numeroMaxAleatorio);
            int caminoSeleccionado = 99;
            for (int index = 0; index < numProb.length; index++) {
                if (index == 0 && numAleatorio <= numProb[index]) {
                    caminoSeleccionado = index;
                } else if (numAleatorio <= numProb[index] && numAleatorio > numProb[index - 1]) {
                    caminoSeleccionado = index;
                }
            }
            
//            Se modifica la posicion de la hormiga y se actualizan las ciudades visitadas y feromonas.
            actualizarFeromonas(proxCiudades[caminoSeleccionado]);
            ubicacion = proxCiudades[caminoSeleccionado].id;
            ciudadesVisitadas[cantidadVisitadas] = ubicacion;
            cantidadVisitadas += 1;
        }
        
//        Si la ubicacion es la comida retornamos verdadero.
        return ubicacion == comida;
    }

    public void buscarComida(){
        while(true){
            if (viaje()==true){
                ciudadesVisitadas = new int[cantidadCiudades];
                ciudadesVisitadas[0] = nido;
                cantidadVisitadas = 1;
                ubicacion = nido;
                System.out.println("Se completo un ciclo!");
                break;
            }
        }
    }
}
