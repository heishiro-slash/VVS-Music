package contenido;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import utils.exceptions.contenido.ContentEmisoraNotFoundException;
import utils.exceptions.contenido.TitleNotFoundException;

import java.util.ArrayList;
import java.util.List;

/**
 *Java Doc.
 * @author Faustino Castro, Victor Blanco y José Miguel del Río
 */
public class Emisoras implements Contenido {

  private List<Contenido> lista;
  private String titulo;
  private int duracion;

  /**
   * Se crea una emisora.
   *
   * @param tit Titulo de la emisora
   */
  public Emisoras(String tit) {
    this.titulo = tit;
    this.duracion = 0;
    this.lista = new ArrayList<Contenido>();

  }

  /**
   *Java Doc.
   * @return Titulo de la emisora
   */
  @Override
  public String obtenerTitulo() {
    return this.titulo;
  }

  /**
   *
   * @return Duración de la emisora. La duración es la suma de todas las
   * duraciones que contenga la lista de dicha emisora
   */
  @Override
  public int obtenerDuracion() {
    return this.duracion;
  }

  /**
   *
   * @return Lista de reproducción con los anuncios o canciones que previamente
   * se han añadido a la lista.
   */
  @Override
  public List<Contenido> obtenerListaReproduccion() {
    return this.lista;
  }

  /**
   *
   * @param subcadena Palabra clave por la que se desea realizar la busqueda
   * @return Lista de contenido los anuncios o canciones que concuerde con la
   * palabra clave
   * @throws TitleNotFoundException Error mostrado en caso de que no haya
   * coincidencia con la palabra clave o la lista esté sin contenido.
   */
  @Override
  public List<Contenido> buscar(String subcadena) throws TitleNotFoundException {

    if (lista.isEmpty()) {
      throw new TitleNotFoundException("Lista sin contenidos");
    }

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

  /**
   *
   * @param contenido Elemento que se desea añadir a la lista de reproducción
   * @param predecesor Elemento a partir del cual se desea añadir el contenido
   * @throws ContentEmisoraNotFoundException Error mostrado en caso de ausencia
   * de predecesor o de que no sea valido.
   */
  @Override
  public void agregar(Contenido contenido, Contenido predecesor) throws
          ContentEmisoraNotFoundException {
    int indice;

    if (lista.isEmpty()) {
      lista.add(contenido);
    } else {
      if (predecesor == null) {
        throw new ContentEmisoraNotFoundException("Falta Predecesor");
      }

      indice = lista.indexOf(predecesor);
      if (indice != -1) {
        duracion = duracion + contenido.obtenerDuracion();
        lista.add(indice++, contenido);
      } else {
        throw new ContentEmisoraNotFoundException("Predecesor no encontrado ");
      }
    }
  }

  /**
   *
   * @param contenido Elemento que se desea eliminar de la lista de reproducción
   * @throws ContentEmisoraNotFoundException Error mostrado en caso de contenido
   * no existente.
   */
  @Override
  public void eliminar(Contenido contenido) throws ContentEmisoraNotFoundException {
    if (lista.remove(contenido)) {
      duracion = duracion - contenido.obtenerDuracion();
    } else {
      throw new ContentEmisoraNotFoundException("No se ha podido eliminar el contenido");
    }
  }

}
