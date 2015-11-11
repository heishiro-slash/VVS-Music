/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Contenido;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Faustino Castro, Victor Blanco y José Miguel del Río
 */
public class Canciones  implements Contenido{
    
    private String titulo;
    private int duracion;
    private List<Contenido> lista;
    
    /**
     *
     * @param tit Titulo de la canción
     * @param dur Duración de la canción
     */
    public Canciones(String tit,int dur) {
        this.titulo=tit;
        this.duracion=dur;
        this.lista = new ArrayList<Contenido>();
        lista.add(this);
    }
    
    /**
     *
     * @return Titulo de la canción
     */
    @Override
    public String obtenerTitulo() {
          return this.titulo;
    }

    /**
     *
     * @return Duración de la canción
     */
    @Override
    public int obtenerDuracion() {
        return this.duracion;
    }

    /**
     *
     * @return Lista de reproducción con una sola canción en su contenido
     */
    @Override
    public List<Contenido> obtenerListaReproduccion() {
        return lista;
    }

    /**
     *
     * @param subcadena Palabra clave por la que se desea realizar la busqueda
     * @return Lista de contenido con la canción que concuerda con la palabra clave
     * @throws TitleNotFoundException Error mostrado en caso de que no haya coincidencia con la palabra clave
     */
    @Override
    public List<Contenido> buscar(String subcadena) throws TitleNotFoundException {
        if (this.titulo.contains(subcadena)){
            return lista;
        }else {
           throw new TitleNotFoundException("Cancion no encontrada");
        }
    }

    /**
     * Método no disponible
     * @param contenido 
     * @param predecesor
     */
    @Override  //Esto es un metodo vacio
    public void agregar(Contenido contenido, Contenido predecesor) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    /**
     * Método no disponible
     * @param contenido 
     */
    @Override  //Esto es un metodo vacio
    public void eliminar(Contenido contenido) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
