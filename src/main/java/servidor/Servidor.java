package servidor;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import contenido.Contenido;


import servidor.tokens.AdminToken;
import servidor.tokens.Token;

import java.util.List;

import utils.exceptions.contenido.ContentNotFoundException;
import utils.exceptions.tokens.InvalidTokenException;

/**
 * Interfaz del servidor.
 *
 * @author Faustino Castro, Victor Blanco y José Miguel del Río
 */
public interface Servidor {

  /**
   * Devuelve el nombre del servidor.
   *
   * @return Nombre
   */
  public String obtenerNombre();

  /**
   * Devuelve un token nuevo válido.
   *
   * @return Token
   */
  public Token alta();

  public Token alta(Token token);

  /**
   * Da de baja un token existente, lanza la excepcion si no lo encuentra.
   *
   * @param token contenido que das de baja
   * @throws InvalidTokenException  si el contenido no existe
   */
  public void baja(Token token) throws InvalidTokenException;

  /**
   * Un administrador puede agregar contenido al servidor.
   *
   * @param contenido contenido que agregas
   * @param token adminToken
   * @throws InvalidTokenException token no valido
   */
  public void agregar(Contenido contenido, AdminToken token) throws InvalidTokenException;

  /**
   * Un administrador puede eliminar contenido del servidor.
   *
   * @param contenido contenido que le pasas
   * @param token el adminToken
   * @throws InvalidTokenException si no se pudo aliminar
   * @throws ContentNotFoundException si no se encontro el contenido
   */
  public void eliminar(Contenido contenido, AdminToken token) throws
          InvalidTokenException, ContentNotFoundException;

  /**
   * realiza una búsqueda entre las canciones del servidor.
   *
   * @param subcadena por la que buscas
   * @param token el token necesario
   * @return devolvemos una lista de contenido 
   * @throws InvalidTokenException caso de error
   */
  public List<Contenido> buscar(String subcadena, Token token) throws InvalidTokenException;
}
