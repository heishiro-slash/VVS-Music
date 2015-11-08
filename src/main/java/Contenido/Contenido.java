/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Contenido;

import java.util.List;

/**
 *
 * @author José Miguel
 */
public interface Contenido {
    public String obtenerTitulo();
    public int obtenerDuracion();
    public List<Contenido> obtenerListaReproduccion();
    public List<Contenido> buscar (String subcadena);
    public void agregar (Contenido contenido, Contenido predecesor);
    public void eliminar (Contenido contenido);
}
