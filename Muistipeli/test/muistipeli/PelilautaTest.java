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
public class PelilautaTest {

    Pelilauta pelilauta;

    public PelilautaTest() {
    }

    @BeforeClass
    public static void setUpClass() throws Exception {
    }

    @AfterClass
    public static void tearDownClass() throws Exception {
    }

    @Before
    public void setUp() {
        pelilauta = new Pelilauta();
        pelilauta.asetaKortit(4);
    }

    @After
    public void tearDown() {
    }

    @Test
    public void asetaKortit() {
        assertEquals(4, pelilauta.getKorttienLkm());        
    }
    
    @Test
    public void getParienLkm() {
        assertEquals(2, pelilauta.getParienLkm());
    }
    
    @Test
    public void kaannetynIndeksiOikein() {
        pelilauta.kaannaEka(2);
        assertEquals(2, pelilauta.getKaanInd(0));
    }
    
    @Test
    public void kaannetynArvoOikein() {
        pelilauta.kaannaToka(2);
        assertEquals(1, pelilauta.getKaanArvo(1));
    }
    
    @Test
    public void katsoArvo() {
        assertEquals(0, pelilauta.katsoArvo(1));
    }
    
    @Test
    public void onPari() {
        pelilauta.kaannaEka(0);
        pelilauta.kaannaToka(1);
        assertTrue(pelilauta.onkoPari());
    }
    
    @Test
    public void eiPari() {
        pelilauta.kaannaEka(0);
        pelilauta.kaannaToka(3);
        assertFalse(pelilauta.onkoPari());
    }

}
