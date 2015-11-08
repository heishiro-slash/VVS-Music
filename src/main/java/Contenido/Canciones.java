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
public class Canciones  implements Contenido{
    
    private String titulo;
    private int duracion;
    private List<Contenido> lista;
    
    public Canciones(String tit,int dur) {
        this.titulo=tit;
        this.duracion=dur;
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
        lista.add(new Canciones(titulo,duracion));
        return lista;
    }

    @Override
    public List<Contenido> buscar(String subcadena) throws TitleNotFoundException {
        if (this.titulo.contains(subcadena)){
            lista.add(new Canciones(titulo,duracion)); 
            return lista;
        }else {
           throw new TitleNotFoundException("Cancion no encontrada");
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
