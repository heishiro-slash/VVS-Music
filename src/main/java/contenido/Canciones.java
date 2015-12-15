package contenido;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import utils.exceptions.contenido.TitleNotFoundException;

import java.util.ArrayList;
import java.util.List;

/**
 *Java Doc.
 * @author Faustino Castro, Victor Blanco y José Miguel del Río
 */
public class Canciones implements Contenido {

  private String titulo;
  private int duracion;

  /**
   *Java Doc.
   * @param tit Titulo de la canción
   * @param dur Duración de la canción
   */
  public Canciones(String tit, int dur) {
    this.titulo = tit;
    this.duracion = dur;
  }

  /**
   *Java Doc.
   * @return Titulo de la canción
   */
  @Override
  public String obtenerTitulo() {
    return this.titulo;
  }

  /**
   *Java Doc.
   * @return Duración de la canción
   */
  @Override
  public int obtenerDuracion() {
    return this.duracion;
  }

  /**
   *Java Doc.
   * @return Lista de reproducción con una sola canción en su contenido
   */
  @Override
  public List<Contenido> obtenerListaReproduccion() {
    List<Contenido> lista = new ArrayList<Contenido>();
    lista.add(this);
    return lista;
  }

  /**
   *Java Doc.
   * @param subcadena Palabra clave por la que se desea realizar la busqueda
   * @return Lista de contenido con la canción que concuerda con la palabra
   * clave
   * @throws TitleNotFoundException Error mostrado en caso de que no haya
   * coincidencia con la palabra clave
   */
  @Override
  public List<Contenido> buscar(String subcadena) throws TitleNotFoundException {
    List<Contenido> lista = new ArrayList<Contenido>();

    if (this.titulo.contains(subcadena)) {
      lista.add(this);
      return lista;
    } else {
      throw new TitleNotFoundException("Cancion no encontrada");
    }
  }

  /**
   *Java Doc.
   *
   * @param contenido lo que agregas
   * @param predecesor lo que está antes
   */
  @Override  //Esto es un metodo vacio
  public void agregar(Contenido contenido, Contenido predecesor) {
  }

  /**
   * Método no disponible.
   *
   * @param contenido elimina un contenido
   */
  @Override  //Esto es un metodo vacio
  public void eliminar(Contenido contenido) {
  }

}
