/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servidor;

import contenido.Anuncios;
import servidor.Tokens.Token;
import contenido.Contenido;
import servidor.Tokens.AdminToken;
import utils.exceptions.contenido.ContentNotFoundException;
import utils.exceptions.tokens.InvalidTokenException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * Servidor básico
 *
 * @author Faustino Castro, Victor Blanco y José Miguel del Río
 */
public class ServLocal implements Servidor {

    private final String nombre;
    private final AdminToken admin = AdminToken.getInstance();
    private List<Contenido> catalogo = new ArrayList<Contenido>();
    private List<Contenido> publicidad = new ArrayList<Contenido>();
    private List<Token> validTokens = new ArrayList<Token>();

    /**
     * Constructor
     *
     * @param nombre
     */
    public ServLocal(String nombre) {
        this.nombre = nombre;

    }

    /**
     * Devuelve el nombre del servidor
     *
     * @return nombre
     */
    @Override
    public String obtenerNombre() {
        return nombre;
    }

    /**
     * Devuelve un token nuevo válido. Añade este token a la lista de tokens
     * válidos.
     *
     * @return
     */
    @Override
    public Token alta() {
        Token token = new Token();
        validTokens.add(token);
        return token;
    }

    /**
     * Elimina un token valido de la lista de tokens
     *
     * @param token
     * @throws InvalidTokenException
     */
    @Override
    public void baja(Token token) throws InvalidTokenException {
        if (validTokens.contains(token)) {
            validTokens.remove(token);
        } else {
            throw new InvalidTokenException(token);
        }
    }

    /**
     * Con un token de aministrador, permite añadir contenido al servidor
     * Diferencia entre anuncios y el resto del contenido
     *
     * @param contenido
     * @param token
     * @throws InvalidTokenException
     */
    @Override
    public void agregar(Contenido contenido, AdminToken token) throws InvalidTokenException {
        if (token.equals(admin)) {
            if (!(contenido instanceof Anuncios)) {
                if (!catalogo.contains(contenido)) {
                    catalogo.add(contenido);
                }
            } else {
                if (!publicidad.contains(contenido)) {
                    publicidad.add(contenido);
                }
            }
        } else {
            throw new InvalidTokenException(token);
        }

    }

    /**
     * Con un token de aministrador, permite eliminar contenido del servidor
     * Diferencia entre anuncios y el resto del contenido
     * @param contenido
     * @param token
     * @throws InvalidTokenException
     * @throws ContentNotFoundException
     */
    @Override
    public void eliminar(Contenido contenido, AdminToken token) throws InvalidTokenException, ContentNotFoundException {
        if (token.equals(admin)) {
            if (catalogo.contains(contenido)) {
                catalogo.remove(contenido);
            } else {
                if (publicidad.contains(contenido)) {
                    publicidad.remove(contenido);
                } else {
                    throw new ContentNotFoundException(contenido);
                }
            }
        } else {
            throw new InvalidTokenException(token);
        }

    }

    /**
     * Realiza una búsqueda en el servidor de contenido. Si el token es nulo añadira un anuncio al inicio y otro cada 3 contenidos.
     * Si el token es valido devuelve la lista sin anuncios y al finalizar la búsqueda disminuira el numero de usos restantes del token
     * @param subcadena
     * @param token
     * @return
     * @throws InvalidTokenException
     */
    @Override
    public List<Contenido> buscar(String subcadena, Token token) throws InvalidTokenException {
        Random rnd = new Random();
        int counter = 3;
        List<Contenido> lista = new ArrayList<Contenido>();
        if (token == null) {
            if (publicidad.size() > 0) {
                lista.add(publicidad.get((int) (rnd.nextDouble() * lista.size())));
            }
            for (Contenido contenido : catalogo) {
                if (counter == 0) {
                    lista.add(publicidad.get((int) (rnd.nextDouble() * lista.size())));
                    counter = 3;
                }
                if (contenido.obtenerTitulo().contains(subcadena)) {
                    lista.add(contenido);
                    counter--;
                }
            }
        } else if (validTokens.contains(token)) {
            for (Contenido contenido : catalogo) {
                if (contenido.obtenerTitulo().contains(subcadena)) {
                    lista.add(contenido);
                }
            }
            if(token.use()==0){
                baja(token);
            }
        } else {
            throw new InvalidTokenException(token);
        }
        return lista;
    }

}
