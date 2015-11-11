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
 * @authors: Víctor Blanco, Faustino Castro, Jose Del Río
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

    /**
     *Caso base: obtener el titulo de un anuncio previamente creado.
     */
    @Test
    public void testObtenerTitulo() {
        Anuncios anuncio = new Anuncios();
        String result = anuncio.obtenerTitulo();

        String expResult = "PUBLICIDAD";
        assertEquals(expResult, result);

    }

    /**
    *Caso base: obtener la duracion de un anuncio previamente creado
     */
    @Test
    public void testObtenerDuracion() {
        Anuncios anuncio = new Anuncios();
        int result = anuncio.obtenerDuracion();
        int expResult = 5;
        assertEquals(expResult, result);

    }

    /**
    *Caso base: obtener la lista de reproduccion de un anuncio previamente creado
     */
    @Test
    public void testObtenerListaReproduccion() {
        Anuncios anuncio = new Anuncios();

        List<Contenido> result = new ArrayList<Contenido>();;
        result.add(anuncio);

        List<Contenido> result2 = anuncio.obtenerListaReproduccion();;
        assertEquals(result, result2);

    }

    /**
     *
     * @throws TitleNotFoundException
     * Buscar un anuncio previamente creado

     */
    @Test
    public void testBuscar() throws TitleNotFoundException {

        Anuncios anuncio = new Anuncios();
        List<Contenido> expResult = anuncio.buscar("ub");

        assertEquals(expResult, anuncio.obtenerListaReproduccion());

    }
    
    /**
     *
     * @throws TitleNotFoundException
     * Buscar un anuncio que no existe
     */
    @Test (expected = TitleNotFoundException.class)
    public void testBuscarNotFound() throws TitleNotFoundException {

        Anuncios anuncio = new Anuncios();
        List<Contenido> expResult = anuncio.buscar("Paquito");

    }
}
