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
public class EmisorasTest {
    
    public EmisorasTest() {
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
     * Test of obtenerTitulo method, of class Emisoras.
     */
    @Test
    public void testObtenerTitulo() {
       Emisoras emisora = new Emisoras("Radio FIC");
        String result = emisora.obtenerTitulo();

        String expResult = "Radio FIC";
        assertEquals(expResult, result);
    }

    /**
     * Test of obtenerDuracion method, of class Emisoras.
     */
    @Test
    public void testObtenerDuracion() {
       Emisoras emisora = new Emisoras("Radio FIC");
        int result = emisora.obtenerDuracion();

        int expResult = 0;
        assertEquals(expResult, result);
    }


       /**
     * Test of obtenerListaReproduccion method, of class Canciones.
     */
    @Test
    public void testObtenerListaReproduccion() {
       Emisoras emisora = new Emisoras("Radio FIC");

         List<Contenido> result = emisora.obtenerListaReproduccion();;
        List<Contenido> result2 = new ArrayList<Contenido>();;
        assertEquals(result, result2);
    }


    /**
     * Test of agregar method, of class Emisoras.
     */
    @Test   //añado un contenido a la lista vacia
    public void testAgregarAListaVacia() throws Exception {
      
        Emisoras emisora = new Emisoras("Radio FIC");
        Contenido contenido = new Anuncios();
        
        emisora.agregar(contenido, null);

        List<Contenido> result = emisora.obtenerListaReproduccion();;
        int tam = result.size();
        
        assertEquals(tam, 1);
    }

     @Test( expected = ContentEmisoraNotFoundException.class)
     //con una lista no vacia, intento añadir un contenido pasandole un predecesor nulo
    public void testAgregarPredecesorNulo() throws Exception {
        
        Emisoras emisora = new Emisoras("Radio FIC");
        Contenido contenido = new Anuncios();
        
        emisora.agregar(contenido, null);
      
        emisora.agregar(contenido, null);

    }
    
      @Test // con una lista no vacia, agrego un contenido
    public void testAgregarVarios() throws Exception {
        
        Emisoras emisora = new Emisoras("Radio FIC");
        Contenido contenido = new Anuncios();
        
        emisora.agregar(contenido, null);
      
        Contenido contenido2 = new Anuncios();

        emisora.agregar(contenido2, contenido);
        
        List<Contenido> result = emisora.obtenerListaReproduccion();;
        int tam = result.size();
        
        assertEquals(tam, 2);

    }
    
    
    @Test( expected = ContentEmisoraNotFoundException.class)
    //con una lista no vacia, agrego un contenido pasandole un predecesor no valido (y no nulo)
    public void testAgregarNoPredecesor() throws Exception {
        
        Emisoras emisora = new Emisoras("Radio FIC");      
        Contenido contenido = new Anuncios();
        emisora.agregar(contenido, null);

        Contenido contenido2 = new Anuncios();

        Contenido contenido3 = new Anuncios();
        emisora.agregar(contenido3, contenido2);

    }
    
    @Test
    public void testEliminarOk() throws ContentEmisoraNotFoundException{
        Emisoras emisora = new Emisoras("Radio FIC");      
        Contenido contenido = new Anuncios();
        emisora.agregar(contenido, null);
        
        emisora.eliminar(contenido);
        List<Contenido> result = emisora.obtenerListaReproduccion();;
        int tam = result.size();
        
        assertEquals(tam, 0);
        
    }
    
      @Test
    public void testEliminarOkDuracion() throws ContentEmisoraNotFoundException{
        Emisoras emisora = new Emisoras("Radio FIC");      
        Contenido contenido = new Anuncios();
        emisora.agregar(contenido, null);
        int duracionContenido = contenido.obtenerDuracion();
        int duracionAntes = emisora.obtenerDuracion();
        emisora.eliminar(contenido);
        int duracionDespues = emisora.obtenerDuracion();
       
        assertTrue(duracionAntes == duracionContenido+duracionDespues);
        
    }
    
     @Test (expected = ContentEmisoraNotFoundException.class)
    public void testEliminarNulo() throws ContentEmisoraNotFoundException{
        Emisoras emisora = new Emisoras("Radio FIC");      
        Contenido contenido = new Anuncios();
        emisora.agregar(contenido, null);
        
        emisora.eliminar(null);
       
    }
    
      @Test (expected = ContentEmisoraNotFoundException.class)
    public void testEliminarNoExiste() throws ContentEmisoraNotFoundException{
        Emisoras emisora = new Emisoras("Radio FIC");      
        Contenido contenido = new Anuncios();
        
        emisora.eliminar(contenido);
       
    }

   
    /**
     * Test of buscar method, of class Emisoras.
     */
    @Test (expected = TitleNotFoundException.class)
    public void testBuscarEnVacia() throws Exception {
        
        Emisoras emisora = new Emisoras("Radio FIC");      
        List<Contenido> result = emisora.buscar("nada");
        
    }

     @Test (expected = TitleNotFoundException.class)
    public void testBuscarNoExiste() throws Exception {
        
        Emisoras emisora = new Emisoras("Radio FIC");   
        Contenido contenido = new Anuncios();
        emisora.agregar(contenido, null);
        
        List<Contenido> result = emisora.buscar("nada");
        
    }
    
     @Test
    public void testBuscarOk() throws Exception {
        
        Emisoras emisora = new Emisoras("Radio FIC");   
        Contenido contenido = new Anuncios();
        emisora.agregar(contenido, null);
        
        Contenido contenido2 = new Anuncios();
        emisora.agregar(contenido2, contenido);
        
        List<Contenido> result = emisora.buscar("PUBLICIDAD");
        int tam = result.size();
        
        assertEquals(tam, 2);
        
        
    }
}
