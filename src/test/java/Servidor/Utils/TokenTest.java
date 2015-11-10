/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Servidor.Utils;

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
public class TokenTest {
    
    public TokenTest() {
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

    //no creados tests de hashcode ni de tostring, considerados triviales
    
    @Test
    public void testUse() {
        
        Token token = new Token();
        int tamano = token.use();
        
        assertEquals( 9,tamano);
    }
    
      @Test
    public void testEquals() {
        
        Token token1 = new Token();
        Token token2 = new Token();
        
        assertFalse(token1.equals(token2));
    }

}
