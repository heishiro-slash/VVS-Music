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

    Token token;

    public InvalidTokenException(Token token) {
        this.token = token;
        System.out.println("Token caducado o inválido: " + token.toString());
    }

}
