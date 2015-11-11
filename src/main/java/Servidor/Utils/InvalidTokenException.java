/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Servidor.Utils;

/**
 * Excepcion lanzada cuando un token es invalido o esta caducado.
 * @author JosÃ© Miguel
 */
public class InvalidTokenException extends Exception {

    /**
     * Excepcion para token normal.
     * @param token
     */
    public InvalidTokenException(Token token) {
        System.out.println("Token caducado o invalido: " + token.toString());
    }

    /**
     * Excepcion para un Token de administrador.
     * @param token
     */
    public InvalidTokenException(AdminToken token) {
        System.out.println("Token caducado o invalido: " + token.toString());
    }

}
