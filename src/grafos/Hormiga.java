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
    public static int cantidadHormigas = 10;
    public static int cantidadCiclos = 100;
    public static int gradoImportanciaFeromona = 1;
    public static int gradoVisibilidadCiudad = 2;
    public static int cantidadCiudades;
    public static int ciudadesVisitadas[];
    
    public Hormiga(int ciudades){
        cantidadCiudades = ciudades;
        ciudadesVisitadas = new int[ciudades];
    }
    
    public boolean viajar(){
        
    }
}
