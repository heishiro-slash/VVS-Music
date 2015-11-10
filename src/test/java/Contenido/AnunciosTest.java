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

/**
 *
 * @author alfa1
 */
public class AnunciosTest {

    public AnunciosTest() {
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

    @Test
    public void testObtenerTitulo() {
        Anuncios anuncio = new Anuncios();
        String result = anuncio.obtenerTitulo();

        String expResult = "PUBLICIDAD";
        assertEquals(expResult, result);

    }

    @Test
    public void testObtenerDuracion() {
        Anuncios anuncio = new Anuncios();
        int result = anuncio.obtenerDuracion();
        int expResult = 5;
        assertEquals(expResult, result);

    }

    /**
     * Test of obtenerListaReproduccion method, of class Anuncios.
     */
    @Test
    public void testObtenerListaReproduccion() {
        Anuncios anuncio = new Anuncios();

        List<Contenido> result = new ArrayList<Contenido>();;
        result.add(anuncio);

        List<Contenido> result2 = anuncio.obtenerListaReproduccion();;
        assertEquals(result, result2);

    }

    @Test
    public void testBuscar() throws Exception {

        Anuncios anuncio = new Anuncios();
        List<Contenido> expResult = anuncio.buscar("ub");

        assertEquals(expResult, anuncio.obtenerListaReproduccion());

    }
}
