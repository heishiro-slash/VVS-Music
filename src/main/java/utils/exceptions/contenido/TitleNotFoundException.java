package utils.exceptions.contenido;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *Java Doc.
 * @author Faustino Castro, Victor Blanco y José Miguel del Río
 */
public class TitleNotFoundException extends Exception {

  /**
   *Java Doc.
   * @param message Mensaje que se mostrará indicando el error concreto que se
   * produjo
   */
  public TitleNotFoundException(String message) {
    super(message);
  }
}
