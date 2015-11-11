/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Servidor.Utils;

import Contenido.Contenido;

/**
 *
 * @author José Miguel
 */
public class ContentNotFoundException  extends Exception {

    Contenido contenido;

    /**
     *
     * @param contenido
     */
    public ContentNotFoundException(Contenido contenido) {
        this.contenido = contenido;
        System.out.println("Contenido no encontrado: " + contenido.obtenerTitulo());
    }
    
}
