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
public class AdminToken {
    private static AdminToken admin = null;
    private static String uuid; 
    private AdminToken(){
        uuid = UUID.randomUUID().toString();
    }
    public static AdminToken getInstance(){
        if(admin == null){
            admin = new AdminToken();
        }
        return admin;
    }
    public static String getUUID(){
        return uuid;
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
        final AdminToken other = (AdminToken) obj;
        if (!Objects.equals(this.uuid, other.uuid)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "AdminToken{" + uuid + '}';
    }
    
}
