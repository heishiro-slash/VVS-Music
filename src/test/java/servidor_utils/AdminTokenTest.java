/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servidor_utils;

import servidor_tokens.AdminToken;
import org.junit.After;
import org.junit.AfterClass;
import static org.junit.Assert.assertFalse;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import servidor_tokens.Token;

/**
 *
 * @author Faustino Castro, Victor Blanco y José Miguel del Río
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
     * Test of getInstance method, of class AdminToken. verificar que funciona
     * el getInstance
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
