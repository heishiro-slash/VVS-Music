/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Servidor;

import Contenido.Contenido;
import Servidor.Utils.Token;
import java.util.List;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author alfa1
 */
public class ServRespaldoTest {
    
    /**
     *
     */
    public ServRespaldoTest() {
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
     * Test of setServRespaldo method, of class ServRespaldo.
     * crear un servidor de respaldo y obtener su nombre
     */
    @Test
    public void testSetServRespaldo() {
        ServRespaldo servidor = new ServRespaldo("Torre");
        servidor.setServRespaldo(servidor);
        
        String nombre = servidor.obtenerNombre();
        
        assertEquals(nombre, "Torre");

    }

    /**
     * Test of buscar method, of class ServRespaldo.
     */
//    @Test
//    public void testBuscar() throws Exception {
//        System.out.println("buscar");
//        String subcadena = "";
//        Token token = null;
//        ServRespaldo instance = null;
//        List<Contenido> expResult = null;
//        List<Contenido> result = instance.buscar(subcadena, token);
//        assertEquals(expResult, result);
//        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
//    }

}
