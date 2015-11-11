/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Servidor;

import Servidor.Utils.Token;
import Contenido.Contenido;
import Servidor.Utils.AdminToken;
import Servidor.Utils.ContentNotFoundException;
import Servidor.Utils.InvalidTokenException;
import java.util.List;

/**
 *
 * @author José Miguel
 */
public interface Servidor {

    /**
     *
     * @return
     */
    public String obtenerNombre();

    /**
     *
     * @return
     */
    public Token alta(); //Devuelve un token, podemos formarlo con un timestamp now y el nombre de usuario

    /**
     *
     * @param token
     * @throws InvalidTokenException
     */
    public void baja(Token token) throws InvalidTokenException;

    /**
     *
     * @param contenido
     * @param token
     * @throws InvalidTokenException
     */
    public void agregar (Contenido contenido, AdminToken token) throws InvalidTokenException;

    /**
     *
     * @param contenido
     * @param token
     * @throws InvalidTokenException
     * @throws ContentNotFoundException
     */
    public void eliminar (Contenido contenido, AdminToken token) throws InvalidTokenException, ContentNotFoundException;

    /**
     *
     * @param subcadena
     * @param token
     * @return
     * @throws InvalidTokenException
     */
    public List<Contenido> buscar (String subcadena, Token token) throws InvalidTokenException;
}
