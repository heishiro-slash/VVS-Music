/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package utils.Exceptions;

import contenido.Contenido;

/**
 * Excepcion lanzada cuando la busqueda de un contenido no da ningun resultado.
 * @author Faustino Castro, Victor Blanco y José Miguel del Río
 */
public class ContentNotFoundException  extends Exception {

    Contenido contenido;

    /**
     * Constructor
     * @param contenido
     */
    public ContentNotFoundException(Contenido contenido) {
        this.contenido = contenido;
        System.out.println("Contenido no encontrado: " + contenido.obtenerTitulo());
    }
    
}
