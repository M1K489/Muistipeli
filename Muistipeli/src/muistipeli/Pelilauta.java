/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package muistipeli;

import java.util.ArrayList;
import java.util.Collections;

/**
 * Sisältää taulukon kortti-olioita ja tiedon pelilaudan korttiparien ja korttien määrästä sekä käännettyinä olevien
 * korttien indekseistä ja arvoista. Tarjoaa metodit mm. korttien asettamiseen pelilaudalle, korttien sekoittamiseen
 * käännettyjen korttien parillisuuden tarkistamiseen, korttien kääntämiseen sekä kortin arvon katsomiseen.
 */
public class Pelilauta {

    /**
     * pelilaudalla jäljellä olevien parien lukumäärä
     */
    private int parit;
    /**
     * taulokko pelilaudan korteista
     */
    private ArrayList<Kortti> kortit;
    /**
     * taulukko käännettyina olevien korttien indekseistä kortit-taulukossa
     */
    private int[] kaanInd;
    /**
     * taulukko käännettyinä olevien korttien arvoista
     */
    private int[] kaanArvo;

    /**
     * luo uuden pelilauta-olion
     */
    public Pelilauta() {
        kortit = new ArrayList<Kortti>();
        kaanInd = new int[2];
        kaanArvo = new int[2];

    }

    /**
     * asettaa kortit-taulukkoon annetun määrän kortteja
     * @param maara kortit-taulukkoon asetettavien korttien lkm
     */
    public void asetaKortit(int maara) {
        parit = maara / 2;
        for (int i = 0; i < maara / 2; i++) {
            kortit.add(new Kortti(i));
            kortit.add(new Kortti(i));
        }
    }

    /**
     * sekoittaa pelilaudan kortit
     */
    public void sekoitaKortit() {
        Collections.shuffle(kortit);
    }

    /**
     * tarkistaa muodostavatko kaksi käännettynä olevaa korttia parin
     * @return true, jos ovat pari ja false, jos eivät ole
     */
    public boolean onkoPari() {
        if (kaanArvo[0] == kaanArvo[1]) {
            parit--;
            return true;
        }
        kortit.get(kaanInd[0]).kaannaPois();
        kortit.get(kaanInd[1]).kaannaPois();
        return false;
    }

    /**
     * palauttaa pelilaudalla olevien parien lkm
     * @return pelilaudalla olevien parien lkm
     */
    public int getParienLkm() {
        return parit;
    }

    /**
     * palauttaa pelilaudalla olevien kaikkien korttien lkm
     * @return pelilaudan kaikkien korttien lkm
     */
    public int getKorttienLkm() {
        return kortit.size();
    }

    /**
     * kääntää ensimmäisen kortin. Asettaa kortin indeksin käänInd-taulukon ekaksi arvoksi ja kortin arvon
     * käänArvo-taulukon ekaksi arvoksi
     * @param i käännetyn kortin indeksi
     */
    public void kaannaEka(int i) {
        kaanInd[0] = i;
        kortit.get(i).kaannaNäkyviin();
        kaanArvo[0] = kortit.get(i).getArvo();
    }

    /**
     * kääntää toisen kortin.
     * @see Pelilauta#kaannaEka(int) 
     * @param i käännetyn kortin indeksi
     */
    public void kaannaToka(int i) {
        kaanInd[1] = i;
        kortit.get(i).kaannaNäkyviin();
        kaanArvo[1] = kortit.get(i).getArvo();
    }

    /**
     * palauttaa käänInd-taulukosta käännettynä olevan kortin indeksin kortit-taulokossa
     * @param i kortin indeksi käänInd-taulukossa
     * @return kortin indeksi pelilauta-taulukossa
     */
    public int getKaanInd(int i) {
        return kaanInd[i];
    }

    /**
     * palauttaa käänArvo-taulukosta käännettynä olevan kortin arvon. (Testausta varten)
     * @param i kortin indeksi käänArvo-taulukossa
     * @return kortin arvo
     */
    public int getKaanArvo(int i) {
        return kaanArvo[i];
    }

    /**
     * metodi kortit-taulokossa indeksillä i olevan kortin arvon katsomiseen
     * @param i kortin indeksi kortit-taulukossa
     * @return kortin arvo
     */
    public int katsoArvo(int i) {
        return kortit.get(i).getArvo();
    }

    /**
     * tekstiversiota varten oleva esitys
     * @return 
     */
    @Override
    public String toString() {
        return "" + kortit + "";
    }
}
