/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servidorTest;

import servidor.ServLocal;
import contenido.Anuncios;
import contenido.Contenido;
import servidor.Tokens.AdminToken;
import utils.exceptions.tokens.InvalidTokenException;
import servidor.Tokens.Token;
import java.util.List;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

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
     * Test of obtenerNombre method, of class ServLocal.
     * crear un servidor local y obtener su nombre
     */
    @Test
    public void testObtenerNombre() {
        ServLocal servidor = new ServLocal("Paquito 1");
        
        String nombre = servidor.obtenerNombre();
        
        assertEquals( nombre, "Paquito 1");
      
    }

    /**
     * Test of alta method, of class ServLocal.
     * crear un token, y verificar que se creó, usándolo
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
     * @throws Servidor.Utils.InvalidTokenException
     * eliminar un token (que no es reducir su capacidad, sino borrarlo)
     */
    
    @Test
    public void testBaja() throws InvalidTokenException {
        
        ServLocal servidor = new ServLocal("Paquito 1");
        Token token = servidor.alta();
        servidor.baja(token);

    }

    /**
     *
     * @throws InvalidTokenException
     * intentar dar de baja dos veces un mismo token
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
     */
//    @Test
//    public void testAgregar() throws Exception {
//        ServLocal servidor = new ServLocal("Paquito 1");
//        AdminToken admin = AdminToken.getInstance();
//        Token token =  servidor.alta();
//        Contenido contenido = new Anuncios();
//      
//        servidor.agregar(contenido, admin);
//        List<Contenido> lista = servidor.buscar("PUB", token);
//        assertEquals (lista.size(), 1);
//    }
////
//    /**
//     * Test of eliminar method, of class ServLocal.
//     */
//    @Test
//    public void testEliminar() throws Exception {
//        System.out.println("eliminar");
//        Contenido contenido = null;
//        Token token = null;
//        ServLocal instance = null;
//        instance.eliminar(contenido, token);
//        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
//    }
//
//    /**
//     * Test of buscar method, of class ServLocal.
//     */
//    @Test
//    public void testBuscar() throws Exception {
//        System.out.println("buscar");
//        String subcadena = "";
//        Token token = null;
//        ServLocal instance = null;
//        List<Contenido> expResult = null;
//        List<Contenido> result = instance.buscar(subcadena, token);
//        assertEquals(expResult, result);
//        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
//    }

}
