package logica;
import java.util.Random;

/**
 * Esta clase crea una Hormiga que usará para recorrer las ListasVertices 
 * a través de sus NodosAristas y así realizar una simulación.
 * 
 * @author: Stefano Boschetti
 * @author: Diego De Jesus
 * @version: 20/02/2024
 */
public class Hormiga {
//    Campos de la clase
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
    public static String recorrido = "";
    public static float distanciaRecorrida = 0;
    
    
/**
 * Constructor para la Hormiga.
 *
 * @param nest Número identificador de la ListaVertice de donde partira la Hormiga, es decir su nido. 
 * @param food Número identificador de la ListaVertice que busca llegar la Hormiga, es decir la comida.
 * @param cities Cantidad de ciudades/ListasVertices en el Grafo.
 * @param grafoPadre Grafo donde se realizara la simulación.
 * @param importanciaFeromona Valor del grado de importancia de la feromona (α).
 * @param visibilidadCiudad Valor del grado de visibilidad de las ciudades (β).
 */
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
        recorrido = Integer.toString(nest)+ "→";
    }//Cierre del constructor
    
    
/**
 * Método que devuelve Verdadero si la Hormiga visitó una Ciudad dada.
 * 
 * @param idCiudad Número identificador de la ciudad a evaluar.
 * @return Devuelve Verdadero si la Hormiga visito la ciudad o Falso si
 * no se visito.
 */
    private boolean seVisito(int idCiudad){
        for(int i = 0; i < cantidadVisitadas; i++){
            if(ciudadesVisitadas[i] == idCiudad ){
                return true;
            }
        }
        return false;
    }//Cierre del método
    
    
/**
 * Método que devuelve la cantidad de ciudades que puede visitar la Hormiga desde un Vertice.
 *
 * @param ciudades Ciudad o Vertice de la que se evaluaran sus aristas adyacentes.
 * @return Cantidad de ciudades que pueden ser visitadas por la Hormiga.
 */
    private int ciudadesValidas(ListaVertice ciudades) {
        int arrSize = 0;
        for (NodoArista auxNodo = ciudades.first; auxNodo != null; auxNodo = auxNodo.next) {
            if(!seVisito(auxNodo.id)){
                arrSize++;
            }
        }
        return arrSize;
    }//Cierre del método
    
    
/**
 * Método que actualiza las feromonas de un Camino o Arista trás el paso de la Hormiga.
 *
 * @param caminoActualizar NodoArista a actualizar.
 */
    private void actualizarFeromonas(NodoArista caminoActualizar){
        float incremento = (float) constanteQ / caminoActualizar.distancia;
        caminoActualizar.feromonas += incremento;
    }//Cierre del método
    
    
/**
 * Método que utiliza un algoritmo para de manera probabilistica desplazar
 * la Hormiga a la arista disponible más óptima, retorna Verdadero si la Hormiga
 * se desplazó hasta la comida o llego a una calle ciega.
 *
 * @return Devuelve Verdadero si la Hormiga se desplazo a la comida o
 * se encuentra en una calle ciega y devuelve Falso si se desplazo a 
 * cualquier otro Vertice.
 */
    private boolean viaje(){
        Random rand = new Random();
//        Ciudades disponibles para viajar.
        NodoArista proxCiudades[] = new NodoArista[ciudadesValidas(grafo.listaAdy[ubicacion])];
//        Probabilidad de viajar a las ciudades disponibles.
        float probViajar[] = new float[proxCiudades.length];
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
            recorrido += Integer.toString(proxCiudades[0].id)+ "→";
            distanciaRecorrida += proxCiudades[0].distancia;
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
            recorrido += Integer.toString(proxCiudades[caminoSeleccionado].id)+ "→";
            distanciaRecorrida += proxCiudades[caminoSeleccionado].distancia;
            ciudadesVisitadas[cantidadVisitadas] = ubicacion;
            cantidadVisitadas += 1;
        }
        
//        Si la ubicacion es la comida retornamos verdadero.
        return ubicacion == comida;
    }//Cierre del método

    
/**
 * Método que realiza un ciclo de la simulación, movilizando la Hormiga
 * de vertice en vertice hasta llegar a la comida o una calle ciega.
 *
 * @return Devuelve un arreglo con el recorrido que realizo la Hormiga y el
 * total de distancia recorrida.
 */
    public String[] buscarComida(){
        while(true){
            if (viaje()==true){
                String auxArr[] = new String[2];
                auxArr[0] = recorrido.substring(0, recorrido.length()-1);
                auxArr[1] = Float.toString(distanciaRecorrida);
                ciudadesVisitadas = new int[cantidadCiudades];
                ciudadesVisitadas[0] = nido;
                cantidadVisitadas = 1;
                ubicacion = nido;
                recorrido = Integer.toString(nido)+ "→";
                distanciaRecorrida = 0;
                return auxArr;
            }
        }
    }//Cierre del método
}//Cierre de la clase
