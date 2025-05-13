/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package data;

import java.util.ArrayList;

/**
 *
 * @author Carlos D.HD
 */
public class Afeccion {
    
    /*ATRIBUTOS*/
    protected int gravedad; //Nivel de gravedad del 1 al 10
    protected String tipo; //Enfermedad, alergia...
    protected String nombre;
    protected ArrayList<String> sintomas;
    protected ArrayList<String> tratamientos;
    
    /*CONSTRUCTORES*/
    public Afeccion() {
    }

    public Afeccion(int gravedad, String tipo, String nombre, ArrayList<String> sintomas, ArrayList<String> tratamientos) {
        this.gravedad = gravedad;
        this.tipo = tipo;
        this.nombre = nombre;
        this.sintomas = sintomas;
        this.tratamientos = tratamientos;
    }
    
    /*GETTERS Y SETTERS*/
    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public ArrayList<String> getSintomas() {
        return sintomas;
    }

    public void setSintomas(ArrayList<String> sintomas) {
        this.sintomas = sintomas;
    }

    public int getGravedad() {
        return gravedad;
    }

    public void setGravedad(int gravedad) {
        this.gravedad = gravedad;
    }

    public ArrayList<String> getTratamientos() {
        return tratamientos;
    }

    public void setTratamientos(ArrayList<String> tratamientos) {
        this.tratamientos = tratamientos;
    }

    /*M�TODOS*/
    
    /**
     * �ste m�todo sirve para a�adir un sintoma(String) al ArrayList de sintomas.
     * 
     * @param sintoma Es el par�metro de tipo String el cual tiene el valor del
     *                              s�ntoma que se a�adir� al ArrayList.
     */
    public void aniadirSintoma(String sintoma) {
        if (!sintoma.trim().isEmpty()) {
            sintomas.add(sintoma);
        } else {
            System.out.println("El s�ntoma no puede estar vac�o.");
        }
    }
    
    /**
     * �ste m�todo sirve para a�adir un tratamiento(String) al ArrayList de tratamientos.
     * 
     * @param tratamiento Es el par�metro de tipo String el cual tiene el valor del
     *                                   tratamiento que se a�adir� al ArrayList.
     */

    public void aniadirTratamiento(String tratamiento) {
        if (!tratamiento.trim().isEmpty()) {
            sintomas.add(tratamiento);
        } else {
            System.out.println("El tratamiento no puede estar vac�o.");
        }
    }

}
