package servidor;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import servidor.tokens.Token;
import contenido.Contenido;
import servidor.tokens.AdminToken;
import utils.exceptions.contenido.ContentNotFoundException;
import utils.exceptions.tokens.InvalidTokenException;
import java.util.List;

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
   * @param token
   * @throws InvalidTokenException
   */
  public void baja(Token token) throws InvalidTokenException;

  /**
   * Un administrador puede agregar contenido al servidor.
   *
   * @param contenido
   * @param token
   * @throws InvalidTokenException
   */
  public void agregar(Contenido contenido, AdminToken token) throws InvalidTokenException;

  /**
   * Un administrador puede eliminar contenido del servidor.
   *
   * @param contenido
   * @param token
   * @throws InvalidTokenException
   * @throws ContentNotFoundException
   */
  public void eliminar(Contenido contenido, AdminToken token) throws
          InvalidTokenException, ContentNotFoundException;

  /**
   * realiza una búsqueda entre las canciones del servidor.
   *
   * @param subcadena
   * @param token
   * @return
   * @throws InvalidTokenException
   */
  public List<Contenido> buscar(String subcadena, Token token) throws InvalidTokenException;
}
