/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package muistipeli;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Miguel
 */
public class KorttiTest {

    Kortti kortti;

    public KorttiTest() {
    }

    @BeforeClass
    public static void setUpClass() throws Exception {
    }

    @AfterClass
    public static void tearDownClass() throws Exception {
    }

    @Before
    public void setUp() {
        kortti = new Kortti(0);
    }

    @After
    public void tearDown() {
    }
    
    @Test
    public void getArvo() {
        assertEquals(0,kortti.getArvo());
    }
    
    @Test
    public void kaannaNakyviin() {
        kortti.kaannaNäkyviin();
        assertTrue(kortti.onkoKaannetty());
    }
    
    @Test
    public void piilotaNakyvista() {
        kortti.kaannaNäkyviin();
        kortti.kaannaPois();
        assertFalse(kortti.onkoKaannetty());
    }
}
