/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Contenido;

import java.util.ArrayList;
import java.util.List;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

public class CancionesTest {

    public CancionesTest() {
    }

    @BeforeClass
    public static void setUpClass() {
    }

    @AfterClass
    public static void tearDownClass() {
    }

    @Before
    public void setUp() {
    }

    @After
    public void tearDown() {
    }

    /**
     * Test of obtenerTitulo method, of class Canciones.
     */
    @Test
    public void testObtenerTitulo() {
        Canciones cancion = new Canciones("cancion1", 10);
        String result = cancion.obtenerTitulo();

        String expResult = "cancion1";
        assertEquals(expResult, result);
    }

    /**
     * Test of obtenerDuracion method, of class Canciones.
     */
    @Test
    public void testObtenerDuracion() {
        Canciones cancion = new Canciones("cancion1", 10);
        int result = cancion.obtenerDuracion();
        int expResult = 10;
        assertEquals(expResult, result);
    }

    /**
     * Test of obtenerListaReproduccion method, of class Canciones.
     */
    @Test
    public void testObtenerListaReproduccion() {
        Canciones cancion = new Canciones("cancion1", 10);

        List<Contenido> result = new ArrayList<Contenido>();;
        result.add(cancion);

        List<Contenido> result2 = cancion.obtenerListaReproduccion();;
        assertEquals(result, result2);
    }

    /**
     * Test of buscar method, of class Canciones.
     */
    @Test
    public void testBuscar() throws Exception {
        Canciones cancion = new Canciones("cancion1", 10);
        List<Contenido> expResult = cancion.buscar("on1");

        assertEquals(expResult, cancion.obtenerListaReproduccion());
    }

    @Test (expected = TitleNotFoundException.class)
    public void testBuscarNotFound() throws TitleNotFoundException {

        Canciones cancion = new Canciones("cancion1", 10);
        List<Contenido> expResult = cancion.buscar("Faustino");
    }
}
