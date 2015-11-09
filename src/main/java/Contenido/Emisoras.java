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
public class Emisoras implements Contenido {

    private List<Contenido> lista;
    private String titulo;
    private int duracion;

    public Emisoras(String tit) {
        this.titulo = tit;
        this.duracion = 0;
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
        return this.lista;
    }

    @Override
    public List<Contenido> buscar(String subcadena) throws TitleNotFoundException {

        List<Contenido> listaContenido = new ArrayList();
        
        for (Contenido contenido : lista) {
            if (contenido.obtenerTitulo().contains(subcadena)) {
                listaContenido.add(contenido);
            }

        }

        if (listaContenido.isEmpty()) { // si no ha encontrado ninguna coincidencia
            throw new TitleNotFoundException("No se han econtrado coincidencias en la emisora");
        }
        return listaContenido;
    }

    @Override
    public void agregar(Contenido contenido, Contenido predecesor) throws ContentEmisoraNotFoundException {
        int indice;

        if (lista.isEmpty()) {
            lista.add(contenido);
        } else {
            if (predecesor == null) {
                throw new ContentEmisoraNotFoundException("Falta Predecesor");
            }
        }

        indice = lista.indexOf(predecesor);
        if (indice != -1) {
            duracion = duracion + contenido.obtenerDuracion();
            lista.add(indice++, contenido);
        } else {
            throw new ContentEmisoraNotFoundException("Predecesor no encontrado ");
        }

    }

    @Override
    public void eliminar(Contenido contenido) throws ContentEmisoraNotFoundException {
        if (lista.remove(contenido)) {
            duracion = duracion - contenido.obtenerDuracion();
        } else {
            throw new ContentEmisoraNotFoundException("No se ha podido eliminar el contenido");
        }
    }

}
