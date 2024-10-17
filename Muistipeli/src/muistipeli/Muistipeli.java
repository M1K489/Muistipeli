/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package muistipeli;

/**
 * Sisältää metodit muistipelin pelaamiseen ja tiedon pelaajan käyttämistä arvauksista. Tarjoaa metodit pelin
 * vaikeustason asettamiseen ja pelilauta-luokan metodeja hyödyntäen ja täydentäen korttien sekoittamiseen, kortin
 * kääntämiseen, kortin arvon katsomiseen ja korttiparin parillisuuden tarkastamiseen.
 */
public class Muistipeli {

    /**
     * pelilauta, jolla peli pelataan
     */
    private Pelilauta pelilauta;
    /**
     * pelaajan käyttämien arvausten lkm
     */
    private int arvauksia;
    /**
     * pelaajan katsomien korttien lkm
     */
    private int katsottuja;
    /**
     * pelin vaikeustaso
     */
    private int vaikeustaso;

    /**
     * luo uuden muistipeli-olion
     */
    public Muistipeli() {
        pelilauta = new Pelilauta();
        arvauksia = 0;
        katsottuja = 0;
    }

    /**
     * asettaa pelilaudalle vaikestason mukaisen määrän kortteja
     * @param vaikeustaso pelin vaikaustaso
     */
    public void asetaVaikeustaso(int vaikeustaso) {
        if (vaikeustaso == 1) {
            this.vaikeustaso = 0;
            pelilauta.asetaKortit(16);
        } else if (vaikeustaso == 2) {
            this.vaikeustaso = 1;
            pelilauta.asetaKortit(36);
        } else {
            this.vaikeustaso = 2;
            pelilauta.asetaKortit(64);
        }
    }
    
    /**
     * palauttaa pelin vaikustason
     * @return pelin vaikeustaso
     */
    public int getVaikeustaso() {
        return vaikeustaso;
    }

    /**
     * sekoittaa pelilaudan kortit
     */
    public void sekoitaKortit() {
        pelilauta.sekoitaKortit();
    }

    /**
     * kääntää pelilaudalta ensimmäisen tai toisen kortin
     * @param ekaToka 0, jos käännetään eka kortti, muulloin toka kortti
     * @param j käännettävän kortin indeksi pelilaudalla
     */
    public void kaannaKortti(int ekaToka, int j) {
        if (ekaToka == 0) {
            katsottuja = 1;
            pelilauta.kaannaEka(j);
        } else {
            pelilauta.kaannaToka(j);
        }
    }

    /**
     * palauttaa käännettynä olevan kortin indeksin pelilaudalla
     * @param i 0, jos eka käännetty; 1, jos toka käännetty
     * @return käännetyn kortin indeksi pelilaudalla
     */
    public int kaannetynInd(int i) {
        return pelilauta.getKaanInd(i);
    }

    /**
     * metodi pelilaudalla olevan kortin arvon katsomiseen
     * @param i kortin indeksi pelilaudalla
     * @return kortin arvo
     */
    public int katsoArvo(int i) {
        katsottuja++;
        return pelilauta.katsoArvo(i);
    }

    /**
     * palauttaa katsottujen korttien lkm
     * @return katsottujen korttien lkm
     */
    public int montaKatsottu() {
        return katsottuja;
    }

    /**
     * tarkistaa muodostavatko käännetyt kortit parin ja kasvattaa arvauksien lkm sekä parin tapauksessa nollaa
     * katsottujen korttien lukumäärän
     * @return true, jos pari ja false, jos ei
     */
    public boolean tarkistaPari() {
        arvauksia++;
        boolean onkoPari = pelilauta.onkoPari();
        if (onkoPari) {
            katsottuja = 0;
        }
        return onkoPari;
    }

    /**
     * palauttaa pelilaudalla järjellä olevien parien lkm
     * @return pelilaudalla jäljellä olevien parien lkm
     */
    public int parejaJaljella() {
        return pelilauta.getParienLkm();
    }

    /**
     * laskee löydettyjen parien lkm
     * @return löydettyjen parien lkm
     */
    public int parejaLoydetty() {
        int loydetty = pelilauta.getKorttienLkm()/2 - pelilauta.getParienLkm();
        return loydetty;
    }

    /**
     * tarkistaa jatkuuko peli eli onko laudalla vielä pareja jäljellä
     * @return true, jos pareja jäljellä ja false, jos ei ole
     */
    public boolean peliJatkuu() {
        int pareja = parejaJaljella();
        if (pareja == 0) {
            return false;
        }
        return true;
    }

    /**
     * palauttaa käytettyjen arvausten lkm
     * @return käytettyjen arvausten lkm
     */
    public int getArvauksia() {
        return arvauksia;
    }

    /**
     * tekstiversiota varten oleva esitys
     * @return 
     */
    @Override
    public String toString() {
        return "" + pelilauta + "";
    }
}
