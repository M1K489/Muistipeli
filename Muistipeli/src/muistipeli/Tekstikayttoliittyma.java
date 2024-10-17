/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package muistipeli;

import java.util.Scanner;

/**
 * Tekstikäyttöliittymä muistipelin ydintoiminnallisuuksien testaamiseen. Mahdollistaa muistipelin pelaamisen
 * komentorivillä, mutta ohjeet ovat minimaallisia eikä virheellisiin syötteisiin ole varauduttu mitenkään...
 * 
 */
public class Tekstikayttoliittyma {

    private static Scanner lukija = new Scanner(System.in);
    private static Muistipeli muistipeli;
    private static Pelitiedot pelitiedot;

    private static void peli() {
        while (muistipeli.peliJatkuu()) {
            System.out.print("Valitse 1. kortti: ");
            int indeksi1 = lukija.nextInt();
            muistipeli.kaannaKortti(0, indeksi1);
            tulostaPeli();
            System.out.print("Valitse 2. kortti: ");
            int indeksi2 = lukija.nextInt();
            muistipeli.kaannaKortti(1, indeksi2);
            tulostaPeli();
            if (muistipeli.tarkistaPari()) {
                System.out.println("Löysit parin!");
            }
            tulostaPeli();
        }
    }

    private static void tarkistaPelaaja(String nimi) throws Exception {
        if (pelitiedot.onkoPelannut(nimi, muistipeli.getVaikeustaso())) {
            int[] arvaukset = pelitiedot.lataaTiedot(nimi);
            for (int i = 0; i < 3; i++) {
                System.out.println("Viimeksi tarvitsit " + arvaukset[i] + " arvausta vaikeustasolla " + (i + 1) + ".");
            }
        } else {
            pelitiedot.lisaaPelaaja(nimi);
        }
        pelitiedot.tallennaLista("pelaajat");
    }

    private static void tulostaPeli() {
        System.out.println(muistipeli);
    }

    private static void vaikeustasonValinta(int taso) {
        muistipeli.asetaVaikeustaso(taso);
        muistipeli.sekoitaKortit();
        tulostaPeli();
    }

    public static void main(String[] args) throws Exception {
        muistipeli = new Muistipeli();
        pelitiedot = new Pelitiedot("pelaajat");

        System.out.print("Anna nimesi: ");
        String nimi = lukija.nextLine();
        tarkistaPelaaja(nimi);

        System.out.println("Valitse vaikeustaso: \n1.helppo\n2.keskitaso\n3.vaikea");
        int taso = lukija.nextInt();
        vaikeustasonValinta(taso);

        peli();

        System.out.println("Peli ohi!");
        pelitiedot.paivitaArvaukset(taso - 1, muistipeli.getArvauksia());
        pelitiedot.tallennaTiedot(nimi);

    }
}