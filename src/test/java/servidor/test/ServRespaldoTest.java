package servidor.test;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import servidor.ServRespaldo;
import org.junit.After;
import org.junit.AfterClass;

import static org.junit.Assert.assertEquals;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

/**
 *Java Doc.
 * @author Faustino Castro, Victor Blanco y José Miguel del Río
 */
public class ServRespaldoTest {

  /**
   *Java Doc.
   */
  public ServRespaldoTest() {
  }

  /**
   *Java Doc.
   */
  @BeforeClass
  public static void setUpClass() {
  }

  /**
   *Java Doc.
   */
  @AfterClass
  public static void tearDownClass() {
  }

  /**
   *Java Doc.
   */
  @Before
  public void setUp() {
  }

  /**
   *Java Doc.
   */
  @After
  public void tearDown() {
  }

  /**
   * Test of setServRespaldo method, of class ServRespaldo. crear un servidor de.
   * respaldo y obtener su nombre
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
//        ServRespaldo servidor = new ServRespaldo("Torre");
//        ServLocal local = new ServLocal("tino");
//        Token token = local.alta();
//        //servidor.setServRespaldo(local);
//        List<Contenido> lista = servidor.buscar("cho", null);
//        //assertEquals(lista, 0);
//    }
}
