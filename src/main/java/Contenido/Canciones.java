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
 * @author alfa1
 */
public class Canciones  implements Contenido{
    
    private String titulo;
    private int duracion;
    private List<Contenido> lista;
    
    /**
     *
     * @param tit
     * @param dur
     */
    public Canciones(String tit,int dur) {
        this.titulo=tit;
        this.duracion=dur;
        this.lista = new ArrayList<Contenido>();
        lista.add(this);
    }
    
    /**
     *
     * @return
     */
    @Override
    public String obtenerTitulo() {
          return this.titulo;
    }

    /**
     *
     * @return
     */
    @Override
    public int obtenerDuracion() {
        return this.duracion;
    }

    /**
     *
     * @return
     */
    @Override
    public List<Contenido> obtenerListaReproduccion() {
        return lista;
    }

    /**
     *
     * @param subcadena
     * @return
     * @throws TitleNotFoundException
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
     *
     * @param contenido
     * @param predecesor
     */
    @Override  //Esto es un metodo vacio
    public void agregar(Contenido contenido, Contenido predecesor) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    /**
     *
     * @param contenido
     */
    @Override  //Esto es un metodo vacio
    public void eliminar(Contenido contenido) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
