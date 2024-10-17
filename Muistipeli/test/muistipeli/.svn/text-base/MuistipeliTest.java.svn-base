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
public class MuistipeliTest {

    Muistipeli muistipeli;

    public MuistipeliTest() {
    }

    @BeforeClass
    public static void setUpClass() throws Exception {
    }

    @AfterClass
    public static void tearDownClass() throws Exception {
    }

    @Before
    public void setUp() {
        muistipeli = new Muistipeli();
        muistipeli.asetaVaikeustaso(3);
    }

    @After
    public void tearDown() {
    }

    @Test
    public void helppo() {
        muistipeli = new Muistipeli();
        muistipeli.asetaVaikeustaso(1);
        assertEquals(1, muistipeli.katsoArvo(3));
    }
    
    @Test
    public void keskitaso() {
        muistipeli = new Muistipeli();
        muistipeli.asetaVaikeustaso(2);
        assertEquals(3, muistipeli.katsoArvo(7));
    }
    
    @Test
    public void getVaikeustaso() {
        assertEquals(2, muistipeli.getVaikeustaso());
    }

    @Test
    public void kaannetaanEka() {
        muistipeli.kaannaKortti(0, 3);
        assertEquals(3, muistipeli.kaannetynInd(0));
    }
    
    @Test
    public void kaannetaanToka() {
        muistipeli.kaannaKortti(1, 15);
        assertEquals(15, muistipeli.kaannetynInd(1));
    }
    
    @Test
    public void arvauksetKasvaa() {
        muistipeli.tarkistaPari();
        assertEquals(1, muistipeli.getArvauksia());
    }
    
    @Test
    public void katsotutKasvaa() {
        muistipeli.katsoArvo(1);
        assertEquals(1, muistipeli.montaKatsottu());
    }
    
    @Test
    public void onPari() {
        muistipeli.kaannaKortti(0, 0);
        muistipeli.kaannaKortti(1, 1);
        assertTrue(muistipeli.tarkistaPari());
    }

    @Test
    public void eiPari() {
        muistipeli.kaannaKortti(0, 1);
        muistipeli.kaannaKortti(1, 7);
        assertFalse(muistipeli.tarkistaPari());
    }
    
    @Test
    public void parejaJaljella() {
        muistipeli.kaannaKortti(0, 1);
        muistipeli.kaannaKortti(1, 1);
        muistipeli.tarkistaPari();
        assertEquals(31, muistipeli.parejaJaljella());
    }
    
    @Test
    public void parejaLoydetty() {
        muistipeli.kaannaKortti(0, 1);
        muistipeli.kaannaKortti(1, 1);
        muistipeli.tarkistaPari();
        muistipeli.kaannaKortti(0, 2);
        muistipeli.kaannaKortti(1, 3);
        muistipeli.tarkistaPari();
        assertEquals(2, muistipeli.parejaLoydetty());
    }
    
    @Test
    public void peliEiJatku() {
        muistipeli = new Muistipeli();
        assertFalse(muistipeli.peliJatkuu());
    }

    @Test
    public void peliJatkuu() {
        assertTrue(muistipeli.peliJatkuu());
    }
}
