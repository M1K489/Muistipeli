/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package muistipeli;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * Pelitietojen lukemiseen ja tallentamiseen tarvittavat metodit. Sisältää pelaaja-listan, joka luetaan tiedostosta
 * ja pelin loputtua päivitetty lista tallennetaan samaan tiedostoon. Tarjoaa metodit uuden pelaajan lisäämiseen
 * listalle, listan tallennuksen sekä keinon tarkistaa onko pelaaja pelannut ennen. Mahdollistaa myös yksittäisen
 * pelaajan tietojen tallentamisen pelaajan omaan tiedostoon sekä tietojen lukemisen tästä tiedostosta.
 */
public class Pelitiedot {

    /**
     * lista pelaajista
     */
    private ArrayList<String> pelaajat = new ArrayList<String>();
    /**
     * pelaajan käyttämät arvaukset eri vaikeustasoilla
     */
    private int[] arvaukset = {0, 0, 0};

    /**
     * lisää pelaajan pelaaja-listalle
     * @param nimi lisättävän pelaajan nimi
     */
    public void lisaaPelaaja(String nimi) {
        pelaajat.add(nimi);
    }

    /**
     * tarkistaa löytyykö pelaajan nimi pelaajat-listalta. (Testausta varten)
     * @param nimi pelaajan nimi
     * @return true, jos pelaaja on listalla, false muulloin
     */
    public boolean onkoListalla(String nimi) {
        if (pelaajat.contains(nimi)) {
            return true;
        }
        return false;
    }
    
    /**
     * palauttaa arvaukset-taulukon. (Testausta varten)
     * @return arvaukset-taulukko
     */
    public int[] getArvaukset() {
        return arvaukset;
    }

    /**
     * tarkistaa onko pelaaja pelannut peliä aiemmin valitulla vaikeustasolla
     * @param nimi pelaajan nimi
     * @param taso valittu vaikeustaso
     * @return true, jos on pelannut ja false muulloin
     * @throws Exception poikkeus, jos pelaajan nimellä varustettua .txt-tiedostoa ei löydy
     */
    public boolean onkoPelannut(String nimi, int taso) throws Exception {
        if (pelaajat.contains(nimi)) {
            arvaukset = lataaTiedot(nimi);
            if (arvaukset[taso] > 0) {
                return true;
            }
        }
        return false;
    }

    /**
     * päivittää pelaajan käyttämät arvaukset arvaukset-listaan
     * @param taso vaikeustaso, jolla peli pelattiin eli taulukon indeksi 0-2
     * @param pisteet = pelaajan käyttämät arvaukset valitulla vaikeustasolla
     */
    public void paivitaArvaukset(int taso, int pisteet) {
        if (arvaukset[taso] == 0 || pisteet < arvaukset[taso]) {
            arvaukset[taso] = pisteet;
        }
    }

    /**
     * tallentaa pelaajan arvaukset eri vaikeustasoilla pelaajan nimellä varustettuun tiedostoon
     * @param nimi pelaajan nimi
     * @throws Exception poikkeus, jos tiedostoon kirjoittaminen ei onnistu
     */
    public void tallennaTiedot(String nimi) throws Exception {
        PrintWriter tiedosto = new PrintWriter(new File("" + nimi + ".txt"));
        for (int pisteet : arvaukset) {
            tiedosto.println(pisteet);
        }
        tiedosto.close();
    }

    /**
     * tallentaa pelaajat-listan nimet tiedostoon
     * @throws Exception poikkeus, jos tiedostoon kirjoittaminen ei onnistu
     */
    public void tallennaLista(String lista) throws Exception {
        PrintWriter tiedosto = new PrintWriter(new File("" + lista + ".txt"));
        for (String nimi : pelaajat) {
            tiedosto.println(nimi);
        }
        tiedosto.close();
    }

    /**
     * lataa pelaajan tiedot ja palauttaa taulukon pelaajan arvauksista eri vaikeustasoilla
     * @param nimi pelaajan nimi
     * @return taulukko pelaajan arvauksista eri vaikeustasoilla
     * @throws Exception poikkeus, jos pelaajan nimellä varustettua .txt-tiedostoa ei löydy
     */
    public int[] lataaTiedot(String nimi) throws Exception {
        Scanner tiedosto = new Scanner(new File("" + nimi + ".txt"));
        for (int i = 0; i < 3; i++) {
            arvaukset[i] = tiedosto.nextInt();
        }
        return arvaukset;
    }

    /**
     * luo uuden pelitiedot olennon ja yrittää ladata pelaajat-listan tiedostosta pelaajat-taulukkoon. Jos tiedostoa
     * ei löydy, luodaan uusi pelaajat-tiedosto.
     * @throws FileNotFoundException poikkeus, jos pelaajat listan sisältävää tiedostoa ei löydy
     */
    public Pelitiedot(String lista) throws FileNotFoundException {
        try {
            Scanner tiedosto = new Scanner(new File("" + lista + ".txt"));
            while (tiedosto.hasNextLine()) {
                String sana = tiedosto.nextLine();
                pelaajat.add(sana);
            }
        } catch (FileNotFoundException ex) {
            PrintWriter tiedosto = new PrintWriter(new File("" + lista + ".txt"));
        }

    }
}
