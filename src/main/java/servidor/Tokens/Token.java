/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servidor.Tokens;

import java.util.Objects;
import java.util.UUID;

/**
 * Clase usada para la conexion
 * @author Faustino Castro, Victor Blanco y José Miguel del Río
 */
public class Token {
    private int caducidad;
    private final String uuid;    
  
    /**
     *Constructor
     */
    public Token(){
        caducidad = 10;
        uuid = UUID.randomUUID().toString();
    }

    /**
     * Funcion que contea la caducidad del token
     * @return El numero de busquedas que aun quedan 
     */
    public int use(){
        caducidad = caducidad-1 ;
        return caducidad;
    }

    /**
     * Funcion que pasa a String el token
     * @return Id del token
     */
    @Override
    public String toString() {
        return "Token{" + "uuid=" + uuid + '}';
    }

    /**
     * Funcion que devuelve el Hash del token
     * @return Int del Hash
     */
    @Override
    public int hashCode() {
        int hash = 7;
        hash = 37 * hash + Objects.hashCode(this.uuid);
        return hash;
    }

    /**
     * Comparador de tokens
     * @param obj
     * @return bool
     */
    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Token other = (Token) obj;
        if (!Objects.equals(this.uuid, other.uuid)) {
            return false;
        }
        return true;
    }

}
