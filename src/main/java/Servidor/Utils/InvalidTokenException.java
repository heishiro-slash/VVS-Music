/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Servidor.Utils;

/**
 *
 * @author José Miguel
 */
public class InvalidTokenException extends Exception {

    /**
     *
     * @param token
     */
    public InvalidTokenException(Token token) {
        System.out.println("Token caducado o inválido: " + token.toString());
    }

    /**
     *
     * @param token
     */
    public InvalidTokenException(AdminToken token) {
        System.out.println("Token caducado o inválido: " + token.toString());
    }

}
