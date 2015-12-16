/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package testautomation;

import contenido.Anuncios;
import contenido.Canciones;
import contenido.Contenido;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.graphwalker.core.condition.EdgeCoverage;
import org.graphwalker.core.condition.ReachedEdge;
import org.graphwalker.core.condition.TimeDuration;
import org.graphwalker.core.generator.AStarPath;
import org.graphwalker.core.generator.RandomPath;
import org.graphwalker.core.machine.ExecutionContext;
import org.graphwalker.java.test.TestBuilder;
import static org.junit.Assert.assertTrue;
import org.junit.Test;
import servidor.ServLocal;
import servidor.tokens.AdminToken;
import servidor.tokens.Token;
import utils.exceptions.tokens.InvalidTokenException;

/**
 *
 * @author José Miguel
 */
public class SimpleTest extends ExecutionContext implements VVSMusic {
    
    public final static Path MODEL_PATH = Paths.get("testautomation/VVSMusic.graphml");
    Token token = null;
    ServLocal servidor = null;
    List<Contenido> lista = new ArrayList();
    @Override
    public void Ready(){
        servidor = new ServLocal("FIC");
        AdminToken admin = AdminToken.getInstance();
        Contenido contenido1 = new Canciones("Paquito el chocolatero", 3);
        Contenido contenido2 = new Canciones("We will Rock You", 1);
        Contenido contenido3 = new Canciones("Smooth Criminal", 5);
        Contenido contenido4 = new Canciones("TNT", 3);
        Contenido contenido5 = new Anuncios();
        Contenido contenido6 = new Anuncios();
        try {
            servidor.agregar(contenido1, admin);
            servidor.agregar(contenido2, admin);
            servidor.agregar(contenido3, admin);
            servidor.agregar(contenido4, admin);
            servidor.agregar(contenido5, admin);
            servidor.agregar(contenido6, admin);
        } catch (InvalidTokenException ex) {
            Logger.getLogger(SimpleTest.class.getName()).log(Level.SEVERE, null, ex);
        }
        System.out.println("Servidor Listo");
    }
    
    @Override
    public void v_SearchWithoutToken() {
        try {
            lista=servidor.buscar("cho", null);
            assertTrue(lista.size()==2);
            System.out.println("Busqueda realizada con el String 'cho'");
        } catch (InvalidTokenException ex) {
            Logger.getLogger(SimpleTest.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public void e_get_songs_with_publicity() {
        Contenido c0 = lista.get(0);
        Contenido c1 = lista.get(1);
        assertTrue(c0 instanceof Anuncios);
        assertTrue(c1 instanceof Canciones);
        System.out.println("Obtenida una lista con 1 anuncio y una cancion");
    }

    @Override
    public void e_search_song_with_token() {
        assertTrue(token.getCaducidad()>0);
        System.out.println("Realizando búsqueda con token.");
    }

    @Override
    public void e_start_the_program() {
        System.out.println("Iniciado el programa");
    }

    @Override
    public void e_get_token() {
        token = servidor.alta();
        System.out.println("Obtenido Token");
    }

    @Override
    public void v_SearchWithToken() {
        try {
            lista=servidor.buscar("cho", token);
            assertTrue(lista.size()==1);
            System.out.println("Busqueda realizada con el String 'cho' y un token");
        } catch (InvalidTokenException ex) {
            Logger.getLogger(SimpleTest.class.getName()).log(Level.SEVERE, null, ex);
        }    
    }

    @Override
    public void e_token_expired() {
        System.out.println("Token caducado");
    }

    @Override
    public void e_get_songs() {
        Contenido c0 = lista.get(0);
        assertTrue(c0 instanceof Canciones);
        System.out.println("Obtenida una lista con una cancion");
    }

    @Override
    public void v_LoggedIn() {
        System.out.println("De alta en el sistema, quedan "+token.getCaducidad()+" usos");
    }

    @Override
    public void e_search_song() {
        System.out.println("Realizando búsqueda sin token.");
    } 
    
    @Test
    public void runSmokeTest() {
        new TestBuilder()
            .setModel(MODEL_PATH)
            .setContext(new SimpleTest())
            .setPathGenerator(new AStarPath(new ReachedEdge("e_token_expired"))) // xeramos un test que pase por este vertice
            .setStart("e_start_the_program") // primeira chamada
            .execute();
    }

    @Test
    public void runFunctionalTest() {
        new TestBuilder()
            .setModel(MODEL_PATH)
            .setContext(new SimpleTest())
            .setPathGenerator(new RandomPath(new EdgeCoverage(100))) // xera tantos test como sexan necesarios para pasar alomenos unha vez por cada transición
            .setStart("e_start_the_program") // primeira chamada
            .execute();
    }

 //   @Test
    public void runStabilityTest() {
        new TestBuilder()
            .setModel(MODEL_PATH)
            .setContext(new SimpleTest())
            .setPathGenerator(new RandomPath(new TimeDuration(3, TimeUnit.MINUTES))) // atravesamos aleatoriamente o grafo durante 3 minutos
            .setStart("e_start_the_program") // primeira chamada
            .execute();
    }
}
