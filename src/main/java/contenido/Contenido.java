package contenido;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import utils.exceptions.contenido.ContentEmisoraNotFoundException;
import utils.exceptions.contenido.TitleNotFoundException;

import java.util.List;

/**
 *Java Doc.
 * @author Faustino Castro, Victor Blanco y José Miguel del Río
 */
public interface Contenido {

  /**
   *Java Doc.
   * @return Nombre del titulo del contenido
   */
  public String obtenerTitulo();

  /**
   *Java Doc.
   * @return Duracion del contenido
   */
  public int obtenerDuracion();

  /**
   *Java Doc.
   * @return Lista de reproducción con el contenido
   */
  public List<Contenido> obtenerListaReproduccion();

  /**
   *Java Doc.
   * @param subcadena Palabra clave por la que se desea realizar la busqueda
   * @return Lista de contenido con los elementos que concuerden con la palabra
      * clave
   * @throws TitleNotFoundException Error mostrado cuando no encuentra el
       * contenido
   */
  public List<Contenido> buscar(String subcadena) throws TitleNotFoundException;

  /**
   *Java Doc.
   * @param contenido Elemento que se desea añadir a la lista de reproducción
   * @param predecesor Elemento a partir del cual se desea añadir el contenido
   * @throws ContentEmisoraNotFoundException Contenido no encontrado en la
   * emisora
   */
  public void agregar(Contenido contenido, Contenido predecesor)
          throws ContentEmisoraNotFoundException;

  /**
   *Java Doc.
   * @param contenido Elemento que se desea quitar de la lista de reproducción
   * @throws ContentEmisoraNotFoundException Contenido no encontrado en la
   * emisora
   */
  public void eliminar(Contenido contenido) throws ContentEmisoraNotFoundException;
}
