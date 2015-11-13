/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Servidor.Utils;

import Servidor.Tokens.AdminToken;
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
public class AdminTokenTest {
    
    /**
     *
     */
    public AdminTokenTest() {
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
     * Test of getInstance method, of class AdminToken.
     * verificar que funciona el getInstance
     */
    @Test
    public void testGetInstance() {
        AdminToken admin = AdminToken.getInstance();

        assertFalse( admin == null);
      
    }

   


}
