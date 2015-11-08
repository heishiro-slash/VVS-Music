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
 * @author José Miguel
 */
public class Anuncios implements Contenido {

    private int duracion;
    private String titulo;
    private List<Contenido> lista;

    public Anuncios() {
        this.duracion = 5;
        this.titulo = "PUBLICIDAD";
        this.lista = new ArrayList();
    }

    @Override
    public String obtenerTitulo() {
        return this.titulo;
    }

    @Override
    public int obtenerDuracion() {
        return this.duracion;
    }

    @Override
    public List<Contenido> obtenerListaReproduccion() {
        lista.add(new Anuncios());
        return lista;
    }

    @Override
    public List<Contenido> buscar(String subcadena) throws TitleNotFoundException { 
        if (this.titulo.contains(subcadena)) {
            lista.add(new Canciones(titulo, duracion));
            return lista;
        } else {
            throw new TitleNotFoundException("Anuncio no encontrado");
        }
    }

    @Override  //Esto es un metodo vacio
    public void agregar(Contenido contenido, Contenido predecesor) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override  //Esto es un metodo vacio
    public void eliminar(Contenido contenido) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
