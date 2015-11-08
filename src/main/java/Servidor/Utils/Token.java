/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Servidor.Utils;

import java.util.Objects;
import java.util.UUID;

/**
 *
 * @author José Miguel
 */
public class Token {
    private int caducidad;
    private final String uuid;    
  
    public Token(){
        caducidad = 10;
        uuid = UUID.randomUUID().toString();
    }
    public int use(){
        caducidad = caducidad --;
        return caducidad;
    }

    @Override
    public String toString() {
        return "Token{" + "uuid=" + uuid + '}';
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 37 * hash + Objects.hashCode(this.uuid);
        return hash;
    }

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
