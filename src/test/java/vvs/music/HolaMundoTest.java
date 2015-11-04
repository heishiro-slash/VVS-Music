/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vvs.music;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author jmrio
 */
public class HolaMundoTest {
    
    public HolaMundoTest() {
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
     * Test of printing method, of class HolaMundo.
     */
    @org.junit.Test
    public void testPrinting() {
        HolaMundo test = new HolaMundo();
        String result = "Hola Mundo";
        assertEquals(result, test.printing());
    }
    
}
