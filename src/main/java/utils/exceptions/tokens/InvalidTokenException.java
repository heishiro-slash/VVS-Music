package utils.exceptions.tokens;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import servidor.tokens.AdminToken;
import servidor.tokens.Token;

/**
 * Excepcion lanzada cuando un token es invalido o esta caducado.
 *
 * @author Faustino Castro, Victor Blanco y José Miguel del Río
 */
public class InvalidTokenException extends Exception {

  /**
   * Excepcion para token normal.
   *
   * @param token el token
   */
  public InvalidTokenException(Token token) {
    System.out.println("Token caducado o invalido: " + token.toString());
  }

  /**
   * Excepcion para un Token de administrador.
   *
   * @param token el token
   */
  public InvalidTokenException(AdminToken token) {
    System.out.println("Token caducado o invalido: " + token.toString());
  }

}
