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

    /**
     *
     * @return
     */
    public String obtenerTitulo();

    /**
     *
     * @return
     */
    public int obtenerDuracion();

    /**
     *
     * @return
     */
    public List<Contenido> obtenerListaReproduccion();

    /**
     *
     * @param subcadena
     * @return
     * @throws TitleNotFoundException
     */
    public List<Contenido> buscar (String subcadena)throws TitleNotFoundException;

    /**
     *
     * @param contenido
     * @param predecesor
     * @throws ContentEmisoraNotFoundException
     */
    public void agregar (Contenido contenido, Contenido predecesor) throws ContentEmisoraNotFoundException;

    /**
     *
     * @param contenido
     * @throws ContentEmisoraNotFoundException
     */
    public void eliminar (Contenido contenido) throws ContentEmisoraNotFoundException;
}
