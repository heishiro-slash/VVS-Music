/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Servidor;

import Contenido.Contenido;

/**
 *
 * @author José Miguel
 */
public interface Servidor {
    public String obtenerNombre();
    public String alta(); //Devuelve un token, podemos formarlo con un timestamp now y el nombre de usuario
    public void baja(String token);
    public void agregar (Contenido contenido, String token);
    public void eliminar (Contenido contenido, String token);
    public void buscar (String subcadena, String token);
}
