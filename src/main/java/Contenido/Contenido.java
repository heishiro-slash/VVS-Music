/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Contenido;

import Utils.Exceptions.ContentEmisoraNotFoundException;
import Utils.Exceptions.TitleNotFoundException;
import java.util.List;

/**
 *
 * @author Faustino Castro, Victor Blanco y José Miguel del Río
 */
public interface Contenido {

    /**
     *
     * @return Nombre del titulo del contenido
     */
    public String obtenerTitulo();

    /**
     *
     * @return Duracion del contenido
     */
    public int obtenerDuracion();

    /**
     *
     * @return Lista de reproducción con el contenido
     */
    public List<Contenido> obtenerListaReproduccion();

    /**
     *
     * @param subcadena Palabra clave por la que se desea realizar la busqueda
     * @return Lista de contenido con los elementos que concuerden con la palabra clave
     * @throws TitleNotFoundException Error mostrado cuando no encuentra el contenido
     */
    public List<Contenido> buscar (String subcadena)throws TitleNotFoundException;

    /**
     *
     * @param contenido Elemento que se desea añadir a la lista de reproducción
     * @param predecesor Elemento a partir del cual se desea añadir el contenido
     * @throws ContentEmisoraNotFoundException Contenido no encontrado en la emisora
     */
    public void agregar (Contenido contenido, Contenido predecesor) throws ContentEmisoraNotFoundException;

    /**
     *
     * @param contenido Elemento que se desea quitar de la lista de reproducción
     * @throws ContentEmisoraNotFoundException Contenido no encontrado en la emisora
     */
    public void eliminar (Contenido contenido) throws ContentEmisoraNotFoundException;
}
