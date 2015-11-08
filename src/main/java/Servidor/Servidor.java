/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Servidor;

import Servidor.Utils.Token;
import Contenido.Contenido;
import Servidor.Utils.ContentNotFoundException;
import Servidor.Utils.InvalidTokenException;
import java.util.List;

/**
 *
 * @author José Miguel
 */
public interface Servidor {
    public String obtenerNombre();
    public Token alta(); //Devuelve un token, podemos formarlo con un timestamp now y el nombre de usuario
    public void baja(Token token) throws InvalidTokenException;
    public void agregar (Contenido contenido, Token token) throws InvalidTokenException;
    public void eliminar (Contenido contenido, Token token) throws InvalidTokenException, ContentNotFoundException;
    public List<Contenido> buscar (String subcadena, Token token) throws InvalidTokenException;
}
