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
 *
 * @author José Miguel
 */
public class ServRespaldo extends ServLocal {

    private ServRespaldo respaldo;
    private List<Token> validTokens = new ArrayList();

    public ServRespaldo(String nombre) {
        super(nombre);
    }

    public void setServRespaldo(ServRespaldo respaldo) {
        this.respaldo = respaldo;
    }

    @Override
    public List<Contenido> buscar(String subcadena, Token token) throws InvalidTokenException {
        List<Contenido> lista = super.buscar(subcadena, token);
        if(lista.size()==0){
            lista = respaldo.buscar(subcadena, token);
        }
        return lista;
    }

}
