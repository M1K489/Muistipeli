/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package muistipeli;

import java.io.FileNotFoundException;
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
public class PelitiedotTest {
    
    Pelitiedot pelitiedot;
    
    public PelitiedotTest() {
    }

    @BeforeClass
    public static void setUpClass() throws Exception {
    }

    @AfterClass
    public static void tearDownClass() throws Exception {
    }
    
    @Before
    public void setUp() throws FileNotFoundException {
        pelitiedot = new Pelitiedot("pelaajattesti");
    }
    
    @After
    public void tearDown() {
    }

    @Test
    public void onkoPelannut() throws Exception {
        assertFalse(pelitiedot.onkoPelannut("asdfsdafdfasd", 0));
    }
    
     @Test
     public void lisaaPelaaja() throws Exception {
         pelitiedot.lisaaPelaaja("Testi");
         assertTrue(pelitiedot.onkoListalla("Testi"));
     }
     
     @Test
     public void tallennaTiedot() throws Exception {
         pelitiedot.tallennaTiedot("Testi");
         int[] pisteet = pelitiedot.lataaTiedot("Testi");
         assertEquals(0, pisteet[0]);
     }
     
     @Test
     public void tallennaLista() throws Exception {
         pelitiedot.lisaaPelaaja("Alfa");
         pelitiedot.tallennaLista("pelaajattesti");
         pelitiedot.paivitaArvaukset(0, 24);
         pelitiedot.tallennaTiedot("Alfa");
         pelitiedot = new Pelitiedot("pelaajattesti");
         assertTrue(pelitiedot.onkoPelannut("Alfa",0));
     }
     
     @Test
     public void paivitaArvaukset() throws Exception {
         pelitiedot.paivitaArvaukset(2, 999);
         pelitiedot.tallennaTiedot("Testi2");
         int[] pisteet = pelitiedot.lataaTiedot("Testi2");
         assertEquals(999, pisteet[2]);
     }
     
     @Test
     public void eiEnnatysta() throws Exception {
         pelitiedot.lataaTiedot("Testi2");
         pelitiedot.paivitaArvaukset(2, 1500);
         int[] arvaukset = pelitiedot.getArvaukset();
         assertEquals(999, arvaukset[2]);
     }
}
