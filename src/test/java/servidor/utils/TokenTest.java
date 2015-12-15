package servidor.utils;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import servidor.tokens.Token;
import org.junit.After;
import org.junit.AfterClass;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import servidor.tokens.AdminToken;

/**Java Doc.
 *
 * @author Faustino Castro, Victor Blanco y José Miguel del Río
 */
public class TokenTest {

  /**Java Doc.
   *
   */
  public TokenTest() {
  }

  /**Java Doc.
   *
   */
  @BeforeClass
  public static void setUpClass() {
  }

  /**Java Doc.
   *
   */
  @AfterClass
  public static void tearDownClass() {
  }

  /**Java Doc.
   *
   */
  @Before
  public void setUp() {
  }

  /**Java Doc.
   *
   */
  @After
  public void tearDown() {
  }

  //no creados tests de hashcode ni de toString, considerados triviales
  
  
  /**Java Doc.
   * crear un token, usarlo y verificar que se redujo la caducidad
   */
  @Test
  public void testUse() {

    Token token = new Token();
    int tamano = token.use();

    assertEquals(9, tamano);
  }

  /**Java Doc.
   * crear dos tokens, y verificar que el equals los diferencia
   */
  @Test
  public void testEquals() {

    Token token1 = new Token();
    Token token2 = new Token();
    AdminToken admin = AdminToken.getInstance();
    assertFalse(token1.equals(token2));
    assertFalse(token1.equals(null));
    assertFalse(token1.equals(admin));
  }

  @Test
  public void testHashcode() {

    Token token1 = new Token();
    Token token2 = new Token();
    assertFalse(token1.hashCode() == token2.hashCode());
  }

}
