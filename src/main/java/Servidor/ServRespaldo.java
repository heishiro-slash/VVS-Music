/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Servidor;

import Contenido.Contenido;
import Servidor.Utils.InvalidTokenException;
import Servidor.Utils.Token;
import java.util.ArrayList;
import java.util.List;

/**
 * Servidor que implementa un servidor de respaldo para las busquedas
 * @author JosÃ© Miguel
 */
public class ServRespaldo extends ServLocal {

    private Servidor respaldo;
    private List<Token> validTokens = new ArrayList();

    /**
     * Constructor
     * @param nombre
     */
    public ServRespaldo(String nombre) {
        super(nombre);
    }

    /**
     * Asigna servidor de respaldo 
     * @param respaldo
     */
    public void setServRespaldo(Servidor respaldo) {
        this.respaldo = respaldo;
    }

    /**
     * Realiza una busqueda entre las canciones  almacenadas en el servidor, si no encuentra ninguna, realizará una búsqueda en el servidor de respaldo.
     * @param subcadena
     * @param token
     * @return
     * @throws InvalidTokenException
     */
    @Override
    public List<Contenido> buscar(String subcadena, Token token) throws InvalidTokenException {
        List<Contenido> lista = super.buscar(subcadena, token);
        if(lista.size()==0){
            lista = respaldo.buscar(subcadena, token);
        }
        return lista;
    }

}
