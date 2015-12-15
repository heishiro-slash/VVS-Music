package servidor.utils;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import static org.junit.Assert.assertFalse;


import servidor.tokens.AdminToken;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import servidor.tokens.Token;

/**
 *Java Doc.
 * @author Faustino Castro, Victor Blanco y José Miguel del Río
 */
public class AdminTokenTest {

  /**
   *Java Doc.
   */
  public AdminTokenTest() {
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
   * Test of getInstance method, of class AdminToken. verificar que funciona el.
   * getInstance
   */
  @Test
  public void testGetInstance() {
    AdminToken admin = AdminToken.getInstance();
    System.out.println(AdminToken.getInstance().toString());
    assertFalse(admin == null);

  }

  @Test
  public void testGetUuid() {
    // AdminToken admin = AdminToken.getInstance();
    String uuid = AdminToken.getUuid();

  }

  @Test
  public void testEquals() {

    AdminToken admin = AdminToken.getInstance();
    assertFalse(admin.equals(null));
    Token token = new Token();
    assertFalse(admin.equals(token));

  }
}
