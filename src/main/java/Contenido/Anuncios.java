/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Contenido;

import Utils.Exceptions.TitleNotFoundException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Faustino Castro, Victor Blanco y José Miguel del Río
 */
public class Anuncios implements Contenido {

    private int duracion;
    private String titulo;
    private List<Contenido> lista;

    /**
     * Crea un anuncio 
     * El titulo y la duración estan predefinidas y tienen como valores PUBLICIDAD y  5 resprectivamente
     */
    public Anuncios() {
        this.duracion = 5;
        this.titulo = "PUBLICIDAD";
        this.lista = new ArrayList<Contenido>();
        lista.add(this);
    }

    /**
     *
     * @return Titulo del anuncio
     */
    @Override
    public String obtenerTitulo() {
        return this.titulo;
    }

    /**
     *
     * @return Duración del anuncio
     */
    @Override
    public int obtenerDuracion() {
        return this.duracion;
    }

    /**
     *
     * @return Lista de reproducción con un solo anuncio en su contenido
     */
    @Override
    public List<Contenido> obtenerListaReproduccion() {
        return lista;
    }

    /**
     *
     * @param subcadena Palabra clave por la que se desea realizar la busqueda
     * @return Lista de contenido con el anuncio que concuerde con la palabra clave
     * @throws TitleNotFoundException Error mostrado en caso de que no haya coincidencia con la palabra clave
     */
    @Override
    public List<Contenido> buscar(String subcadena) throws TitleNotFoundException { 
        if (this.titulo.contains(subcadena.toUpperCase())) {
            return lista;
        } else {
            throw new TitleNotFoundException("Anuncio no encontrado");
        }
    }

    /**
     * Método no disponible
     * @param contenido 
     * @param predecesor
     */
    @Override  //Esto es un metodo vacio
    public void agregar(Contenido contenido, Contenido predecesor) {
    }

    /**
     * Método no disponible
     * @param contenido
     */
    @Override  //Esto es un metodo vacio
    public void eliminar(Contenido contenido) {

    }

}
