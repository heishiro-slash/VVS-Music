package contenido;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import utils.exceptions.contenido.ContentEmisoraNotFoundException;
import utils.exceptions.contenido.TitleNotFoundException;
import java.util.ArrayList;
import java.util.List;
import org.junit.After;
import org.junit.AfterClass;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

/**
 *
 * @authors: Víctor Blanco, Faustino Castro, Jose Del Río.
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
   * Test of obtenerTitulo method, of class Emisoras. Crear una emisora y
   * obtener su titulo
   */
  @Test
  public void testObtenerTitulo() {
    Emisoras emisora = new Emisoras("Radio FIC");
    String result = emisora.obtenerTitulo();

    String expResult = "Radio FIC";
    assertEquals(expResult, result);
  }

  /**
   * Test of obtenerDuracion method, of class Emisoras. Crear una emisora y
   * obtener su duracion
   */
  @Test
  public void testObtenerDuracion() {
    Emisoras emisora = new Emisoras("Radio FIC");
    int result = emisora.obtenerDuracion();

    int expResult = 0;
    assertEquals(expResult, result);
  }

  /**
   * Test of obtenerListaReproduccion method, of class Canciones. crear una
   * emisora y obtener su lista de reproduccion
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
   *
   * @throws java.lang.Exception Agregar un contenido a la lista de contenido de
   * una emisora
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

  /**
   *
   * @throws Exception con una lista no vacia, intento añadir un contenido.
   * pasandole un predecesor nulo
   *
   */
  @Test(expected = ContentEmisoraNotFoundException.class)
  public void testAgregarPredecesorNulo() throws Exception {

    Emisoras emisora = new Emisoras("Radio FIC");
    Contenido contenido = new Anuncios();

    emisora.agregar(contenido, null);

    emisora.agregar(contenido, null);

  }

  /**
   *
   * @throws Exception con una lista no vacia, agrego un contenido.
   */
  @Test
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

  /**
   *
   * @throws Exception con una lista no vacia, agrego un contenido pasandole un.
   * predecesor no valido (y no nulo)
   *
   */
  @Test(expected = ContentEmisoraNotFoundException.class)
  public void testAgregarNoPredecesor() throws Exception {

    Emisoras emisora = new Emisoras("Radio FIC");
    Contenido contenido = new Anuncios();
    emisora.agregar(contenido, null);

    Contenido contenido2 = new Anuncios();

    Contenido contenido3 = new Anuncios();
    emisora.agregar(contenido3, contenido2);

  }

  /**
   *
   * @throws ContentEmisoraNotFoundException Añadir un contenido a la emisora y.
   * eliminarlo
   */
  @Test
  public void testEliminarOk() throws ContentEmisoraNotFoundException {
    Emisoras emisora = new Emisoras("Radio FIC");
    Contenido contenido = new Anuncios();
    emisora.agregar(contenido, null);

    emisora.eliminar(contenido);
    List<Contenido> result = emisora.obtenerListaReproduccion();;
    int tam = result.size();

    assertEquals(tam, 0);

  }

  /**
   *
   * @throws ContentEmisoraNotFoundException Añadir un contenido a la emisora y.
   * eliminarlo, verificando que la duracion queda correctamente modificada
   */
  @Test
  public void testEliminarOkDuracion() throws ContentEmisoraNotFoundException {
    Emisoras emisora = new Emisoras("Radio FIC");
    Contenido contenido = new Anuncios();
    emisora.agregar(contenido, null);
    int duracionContenido = contenido.obtenerDuracion();
    int duracionAntes = emisora.obtenerDuracion();
    emisora.eliminar(contenido);
    int duracionDespues = emisora.obtenerDuracion();

    assertTrue(duracionAntes == duracionContenido + duracionDespues);

  }

  /**
   *
   * @throws ContentEmisoraNotFoundException intenta elimiar de la lista de.
   * contenidos de la emisora, un contenido nulo
   */
  @Test(expected = ContentEmisoraNotFoundException.class)
  public void testEliminarNulo() throws ContentEmisoraNotFoundException {
    Emisoras emisora = new Emisoras("Radio FIC");
    Contenido contenido = new Anuncios();
    emisora.agregar(contenido, null);

    emisora.eliminar(null);

  }

  /**Java Doc.
   *Java Doc.
   * @throws ContentEmisoraNotFoundException intenta elimiar de la lista de
   * contenidos de la emisora, un contenido que no existe
   */
  @Test(expected = ContentEmisoraNotFoundException.class)
  public void testEliminarNoExiste() throws ContentEmisoraNotFoundException {
    Emisoras emisora = new Emisoras("Radio FIC");
    Contenido contenido = new Anuncios();

    emisora.eliminar(contenido);

  }

  /**
   * Test of buscar method, of class Emisoras.
   *
   * @throws java.lang.Exception busca un elemento en la lista de contenido
   * VACIA
   */
  @Test(expected = TitleNotFoundException.class)
  public void testBuscarEnVacia() throws Exception {

    Emisoras emisora = new Emisoras("Radio FIC");
    List<Contenido> result = emisora.buscar("nada");

  }

  /**
   *
   * @throws Exception busca un elemento que no existe en la lista de contenido.
   */
  @Test(expected = TitleNotFoundException.class)
  public void testBuscarNoExiste() throws Exception {

    Emisoras emisora = new Emisoras("Radio FIC");
    Contenido contenido = new Anuncios();
    emisora.agregar(contenido, null);

    List<Contenido> result = emisora.buscar("nada");

  }

  /**
   *
   * @throws Exception Busca un contenido en una lista con varios contenidos.
   * insertados
   */
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
