/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servidor_test;

import servidor.ServLocal;
import contenido.Anuncios;
import contenido.Canciones;
import contenido.Contenido;
import servidor_tokens.AdminToken;
import utils_exceptions_tokens.InvalidTokenException;
import servidor_tokens.Token;
import java.util.List;
import org.junit.After;
import org.junit.AfterClass;
import static org.junit.Assert.assertEquals;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import utils_exceptions_contenido.ContentNotFoundException;

/**
 *
 * @author Faustino Castro, Victor Blanco y José Miguel del Río
 */
public class ServLocalTest {

    /**
     *
     */
    public ServLocalTest() {
    }

    /**
     *
     */
    @BeforeClass
    public static void setUpClass() {
    }

    /**
     *
     */
    @AfterClass
    public static void tearDownClass() {
    }

    /**
     *
     */
    @Before
    public void setUp() {
    }

    /**
     *
     */
    @After
    public void tearDown() {
    }

    /**
     * Test of obtenerNombre method, of class ServLocal. crear un servidor local
     * y obtener su nombre
     */
    @Test
    public void testObtenerNombre() {
        ServLocal servidor = new ServLocal("Paquito 1");

        String nombre = servidor.obtenerNombre();

        assertEquals(nombre, "Paquito 1");

    }

    /**
     * Test of alta method, of class ServLocal. crear un token, y verificar que
     * se creó, usándolo
     *
     */
    @Test
    public void testAlta() {
        ServLocal servidor = new ServLocal("Paquito 1");
        Token token = servidor.alta();

        token.use();;
    }

    /**
     * Test of baja method, of class ServLocal.
     *
     * @throws utils_exceptions_tokens.InvalidTokenException
     */
    @Test
    public void testBaja() throws InvalidTokenException {

        ServLocal servidor = new ServLocal("Paquito 1");
        Token token = servidor.alta();
        servidor.baja(token);

    }

    /**
     *
     * @throws InvalidTokenException intentar dar de baja dos veces un mismo
     * token
     */
    @Test(expected = InvalidTokenException.class)
    public void testBajaError() throws InvalidTokenException {

        ServLocal servidor = new ServLocal("Paquito 1");
        Token token = servidor.alta();
        servidor.baja(token);
        servidor.baja(token);

    }

    /**
     * Test of agregar method, of class ServLocal.
     * @throws java.lang.Exception
     */
    @Test
    public void testAgregar() throws Exception {
        ServLocal servidor = new ServLocal("Paquito 1");
        AdminToken admin = AdminToken.getInstance();
        Token token = servidor.alta();
        Contenido contenido = new Canciones("Paquito el chocolatero", 3);
        Contenido contenido2 = new Anuncios();

        servidor.agregar(contenido, admin);
        servidor.agregar(contenido2, admin);
        List<Contenido> lista = servidor.buscar("cho", token);
        assertEquals(lista.size(), 1);
    }

    // nunca se da el caso de agregar con un token invalido
//    @Test(expected = InvalidTokenException.class)
//    public void testAgregarError() throws InvalidTokenException {
//
//        ServLocal servidor = new ServLocal("Paquito 1");
//        AdminToken admin = AdminToken.getInstance();
//        AdminToken admin2 = null;
//        Token token = servidor.alta();
//        Contenido contenido = new Canciones("Paquito el chocolatero", 3);
//        servidor.agregar(contenido, admin2);
//
//    }
    /**
     * Test of eliminar method, of class ServLocal.
     * @throws java.lang.Exception
     */
    @Test
    public void testEliminar() throws Exception {

        ServLocal servidor = new ServLocal("Paquito 2");
        AdminToken admin = AdminToken.getInstance();
        Token token = servidor.alta();
        Contenido contenido = new Canciones("Paquito el chocolatero", 3);
        Contenido contenido2 = new Anuncios();

        servidor.agregar(contenido, admin);
        servidor.agregar(contenido2, admin);

        servidor.eliminar(contenido, admin);
        servidor.eliminar(contenido2, admin);
        List<Contenido> lista = servidor.buscar("cho", token);
        assertEquals(lista.size(), 0);
    }

    /**
     *
     * @throws ContentNotFoundException
     * @throws InvalidTokenException
     */
    @Test(expected = ContentNotFoundException.class)
    public void testEliminarContenidoNotExist() throws
            ContentNotFoundException, InvalidTokenException {

        ServLocal servidor = new ServLocal("Paquito 2");
        AdminToken admin = AdminToken.getInstance();
        Token token = servidor.alta();
        Contenido contenido = new Canciones("Paquito el chocolatero", 3);

        servidor.eliminar(contenido, admin);

    }

    /**
     * Test of buscar method, of class ServLocal.
     * @throws java.lang.Exception
     */
    @Test
    public void testBuscar() throws Exception {
        ServLocal servidor = new ServLocal("Paquito 1");
        AdminToken admin = AdminToken.getInstance();
        Contenido contenido = new Canciones("Paquito el chocolatero", 3);
        Contenido contenido2 = new Canciones("Paquito el chocolatero2", 1);
        Contenido contenido3 = new Canciones("Paquito el chocolatero3", 5);
        Contenido contenido4 = new Canciones("Paquito el chocolatero4", 3);
        Contenido contenido5 = new Anuncios();
        Contenido contenido6 = new Anuncios();
        servidor.agregar(contenido, admin);
        servidor.agregar(contenido2, admin);
        servidor.agregar(contenido3, admin);
        servidor.agregar(contenido4, admin);
        servidor.agregar(contenido5, admin);
        servidor.agregar(contenido6, admin);
        List<Contenido> lista = servidor.buscar("cho", null);
        assertEquals(lista.size(), 6);
    }

    /**
     *
     * @throws InvalidTokenException
     */
    @Test(expected = InvalidTokenException.class)
    public void testBuscarTokenUseFinish() throws InvalidTokenException {
        ServLocal servidor = new ServLocal("Paquito 1");
        AdminToken admin = AdminToken.getInstance();
        Token token = servidor.alta();
        Contenido contenido = new Canciones("Paquito el chocolatero", 3);

        servidor.agregar(contenido, admin);
        for (int i = 0; i < 11; i++) {
            servidor.buscar("cho", token);
        }

    }

    /**
     *
     * @throws InvalidTokenException
     */
    public void testBuscarPubl() throws InvalidTokenException {
        ServLocal servidor = new ServLocal("Paquito 1");
        AdminToken admin = AdminToken.getInstance();
        Token token = servidor.alta();
        Contenido contenido = new Canciones("Paquito el chocolatero", 3);

        servidor.agregar(contenido, admin);
        for (int i = 0; i < 11; i++) {
            servidor.buscar("cho", null);
        }

    }
}
