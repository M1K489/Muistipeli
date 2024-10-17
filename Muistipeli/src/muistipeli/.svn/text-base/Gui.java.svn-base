/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package muistipeli;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.Panel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.Icon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;

/**
 * Graafinen käyttöliittymä muistipelin pelaamiseen
 */
public class Gui extends JFrame implements ActionListener {

    Muistipeli muistipeli;
    Pelitiedot pelitiedot;
    private JButton exitNappula, helppo, keskitaso, vaikea;
    private Panel ylanappulat, alanappulat, laudanKortit;
    private JLabel pisteet, parejaJaljella, parejaLoydetty;
    private ArrayList<JButton> kortit;
    private javax.swing.JMenuBar valikkorivi;
    private javax.swing.JMenu valikko;
    private javax.swing.JMenuItem tietoja, kaannaKaikki;

    /**
     * luo uuden graafisen käyttöliittymän
     * @throws Exception 
     */
    public Gui() throws Exception {
        pelitiedot = new Pelitiedot("pelaajat");

        laudanKortit = new Panel();

        pisteet = new JLabel();
        parejaJaljella = new JLabel();
        parejaLoydetty = new JLabel();

        luoNappulat();
        nappulatPaikoilleen();

        muutaVaikeustaso(1);

        setTitle("Muistipeli");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(750, 750);
        setVisible(true);
    }

    /**
     * luo nappulat, joilla peliin voi vaikuttaa. Esim. vaikeustason valitsemiseen tarvittavat nappulat
     */
    private void luoNappulat() {
        exitNappula = new JButton("Exit");
        exitNappula.setBackground(Color.YELLOW);
        exitNappula.addActionListener(this);
        helppo = new JButton("Helppo");
        helppo.setBackground(Color.YELLOW);
        helppo.addActionListener(this);
        keskitaso = new JButton("Keskitaso");
        keskitaso.setBackground(Color.YELLOW);
        keskitaso.addActionListener(this);
        vaikea = new JButton("Vaikea");
        vaikea.setBackground(Color.YELLOW);
        vaikea.addActionListener(this);

        kaannaKaikki = new JMenuItem("Näytä kortit");
        kaannaKaikki.addActionListener(this);
        tietoja = new JMenuItem("Tietoja");
        tietoja.addActionListener(this);
    }

    /**
     * asettaa luodut nappulat paikoilleen
     */
    private void nappulatPaikoilleen() {
        alanappulat = new Panel();
        alanappulat.add(exitNappula);
        alanappulat.add(pisteet);
        alanappulat.add(parejaJaljella);
        alanappulat.add(parejaLoydetty);
        alanappulat.setLayout(new GridLayout(1, 0));

        valikkorivi = new JMenuBar();
        valikko = new JMenu("Valikko");
        valikko.setBackground(Color.YELLOW);
        valikkorivi.add(valikko);
        valikko.add(kaannaKaikki);
        valikko.add(tietoja);

        ylanappulat = new Panel();
        ylanappulat.add(valikkorivi);
        ylanappulat.add(helppo);
        ylanappulat.add(keskitaso);
        ylanappulat.add(vaikea);
        ylanappulat.setLayout(new GridLayout(1, 0));

        add(ylanappulat, BorderLayout.NORTH);
        add(alanappulat, BorderLayout.SOUTH);
    }

    /**
     * luo annetun määrän JButtoneita vastaamaan pelilaudan kortteja ja asettaa ne kortit-taulukkoon sekä sekoittaa
     * pelilaudan kortit.
     * @param maara luotavien JButtoneitten lkm
     */
    private void luoKortit(int maara) {
        kortit = new ArrayList<JButton>();

        for (int i = 0; i < maara; i++) {
            kortit.add(new JButton());
            kortit.get(i).setBackground(Color.red);
            kortit.get(i).setFont(new Font("Serif", Font.BOLD, 40));
            kortit.get(i).setText("?");
            kortit.get(i).setToolTipText("Käännä kortti klikkaamalla");
            kortit.get(i).addActionListener(this);
        }
        muistipeli.sekoitaKortit();
    }

    /**
     * poistaa pelilaudalta kaikki entiset kortit, asettaa pisteet, jäljellä olevat parit ja löydetyt parit
     * alkutilaan sekä asettaa kortit-taulukon JButtonit pelilaudalle
     */
    private void kortitLaudalle() {
        laudanKortit.removeAll();
        paivitaPisteetJaParit();
        int koko = (int) Math.sqrt(kortit.size());
        laudanKortit.setLayout(new GridLayout(koko, koko));

        for (int i = 0; i < kortit.size(); i++) {
            laudanKortit.add(kortit.get(i));
        }
        add(laudanKortit, BorderLayout.CENTER);
        setVisible(true);
    }

    /**
     * päivittää pisteet, jäljellä olevat parit sekä löydetyt parit vastaamaan pelin tilannetta
     */
    private void paivitaPisteetJaParit() {
        pisteet.setText("Arvauksia: " + muistipeli.getArvauksia() + "");
        parejaJaljella.setText("Pareja jäljellä: " + muistipeli.parejaJaljella());
        parejaLoydetty.setText("Pareja löydetty: " + muistipeli.parejaLoydetty());
    }

    /**
     * kääntää pelilaudan kortin näkyviin eli lataa kortin arvoa vastaavan kuvan tiedostosta, skaalaa kuvan vastaamaan
     * JButtonin kokoa pelilaudalla, asettaa tämän kuvan JButtonin kuvakkeeksi ja estää JButtonin uudelleen klikkaamisen
     * @param i korttia vastaavan JButtonin indeksi
     */
    private void korttiNakyviin(int i) {
        int arvo = muistipeli.katsoArvo(i);
        int korkeus = kortit.get(i).getHeight();
        int leveys = kortit.get(i).getWidth();

        ImageIcon isokuvake = new ImageIcon(getClass().getResource("/muistipeli/kuvat/" + arvo + ".jpg"));
        Image isokuva = isokuvake.getImage();
        Image sopivakuva = isokuva.getScaledInstance(leveys, korkeus, java.awt.Image.SCALE_SMOOTH);
        Icon sopivakuvake = new ImageIcon(sopivakuva);

        kortit.get(i).setIcon(sopivakuvake);
        kortit.get(i).setDisabledIcon(sopivakuvake);
        kortit.get(i).setText("");
        kortit.get(i).setToolTipText(null);
        kortit.get(i).setEnabled(false);
    }

    /**
     * kääntää pelilaudan kortin piiloon eli asettaa korttia vastaavan JButtonin klikattavaksi ja piilottaa kortin
     * arvoa vastaavan kuvan
     * @param i korttia vastaavan JButtonin indeksi
     */
    private void korttiPiiloon(int i) {
        kortit.get(muistipeli.kaannetynInd(i)).setEnabled(true);
        kortit.get(muistipeli.kaannetynInd(i)).setIcon(null);
        kortit.get(muistipeli.kaannetynInd(i)).setText("?");
        kortit.get(muistipeli.kaannetynInd(i)).setToolTipText("Käännä kortti klikkaamalla");
    }

    /**
     * lukitsee löydetyn parin eli estää parin kortteja vastaavien JButtoneiden klikkaamisen ja poistaa 
     * DisabledIconin, jolloin lukitun nappulan kuvakkeeksi tulee automaattisesti harmaa versio kortin arvoa 
     * vastaavasta kuvasta
     */
    private void pariLukkoon() {
        kortit.get(muistipeli.kaannetynInd(0)).setDisabledIcon(null);
        kortit.get(muistipeli.kaannetynInd(0)).setEnabled(false);
        kortit.get(muistipeli.kaannetynInd(1)).setDisabledIcon(null);
        kortit.get(muistipeli.kaannetynInd(1)).setEnabled(false);
    }

    /**
     * kysyy pelaajan nimeä ja tarkistaa onko pelaaja pelannut peliä ennen. Jos on, lataa pelaajan ennätyspisteet tiedostota
     * ja näyttää pelaajan saamat pisteet sekä ennätyspisteet pelatulla vaikeustasolla. Jos pelaaja ei ole pelannut
     * ennen, näytetään vain pelaajan saamat pisteet. Lopuksi tallennetaan pelaajat-lista ja päivitetään pelaajan
     * ennätyspisteet.
     * @throws Exception mahdollinen poikkeus tiedostojen käsittelyssä
     */
    private void pelinTiedot() throws Exception {
        String nimi = JOptionPane.showInputDialog("Anna nimesi:");
        int vaikeustaso = muistipeli.getVaikeustaso();
        boolean onkoPelannut = pelitiedot.onkoPelannut(nimi, vaikeustaso);

        if (onkoPelannut) {
            int[] arvaukset = pelitiedot.lataaTiedot(nimi);
            JOptionPane.showMessageDialog(null, "Käytit " + muistipeli.getArvauksia() + " arvausta.\nEnnätyksesi tällä vaikeustasolla on " + arvaukset[vaikeustaso] + " arvausta.");
        } else {
            pelitiedot.lisaaPelaaja(nimi);
            JOptionPane.showMessageDialog(null, "Käytit " + muistipeli.getArvauksia() + " arvausta.");
        }
        pelitiedot.tallennaLista("pelaajat");
        pelitiedot.paivitaArvaukset(vaikeustaso, muistipeli.getArvauksia());
        pelitiedot.tallennaTiedot(nimi);
    }

    /**
     * muuttaa pelin vaikeustason annetun syötteen mukaiseksi
     * @param i vaikeustaso 1-3
     */
    private void muutaVaikeustaso(int i) {
        muistipeli = new Muistipeli();
        muistipeli.asetaVaikeustaso(i);
        if (i == 1) {
            luoKortit(16);
        } else if (i == 2) {
            luoKortit(36);
        } else {
            luoKortit(64);
        }
        kortitLaudalle();
    }

    /**
     * kääntää kaikki pelilaudan kortit näkyviin
     */
    private void naytaKortit() {
        for (int i = 0; i < kortit.size(); i++) {
            korttiNakyviin(i);
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {        
        if (exitNappula == e.getSource()) {
            System.exit(0);
        }
        if (helppo == e.getSource()) {
            muutaVaikeustaso(1);
        }
        if (keskitaso == e.getSource()) {
            muutaVaikeustaso(2);
        }
        if (vaikea == e.getSource()) {
            muutaVaikeustaso(3);
        }
        paivitaKortti(e);

        if (tietoja == e.getSource()) {
            JOptionPane.showMessageDialog(null, "Muistipeli\nCopyright 2011 Mika Ylisirniö\nmika.ylisirnio@helsinki.fi", "Tietoja...", 1);
        }
        if (kaannaKaikki == e.getSource()) {
            naytaKortit();
        }
    }

    /**
     * ilmoittaa pelin olevan ohi ja yrittää tallentaa pelin tiedot kutsumalla pelintiedot()-metodia. Virhetilanteessa
     * antaa ilmoituksen virheestä tiedostojen käsittelyssä.
     */
    private void peliLapi() {
        JOptionPane.showMessageDialog(null, "Läpäisit pelin!");
        try {
            pelinTiedot();
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, "Virhe tiedostojen käsittelyssä!", "Virhe!", 0);
        }
    }

    /**
     * käy läpi kortit-taulukon JButtonit ja jos jotain niistä painetaan, kääntää painettua nappulaa vastaavan
     * kortin näkyviin. Jos katsottuja kortteja on yksi, käännetään ensimmäinen kortti ja jos katsottuja kortteja
     * on kaksi käännetään toinen kortti ja tarkistetaan ovatko kortit pari. Parin tapauksessa lukitaan nappulat.
     * Jos kortit eivät ole pari, annetaan pelaajan katsoa kolmas kortti, jonka jälkeen piilotetaan kaksi aiempaa
     * korttia ja asetetaan kolmas katsottu kortti ensimmäiseksi käännetyksi kortiksi.
     * @param e nappulan painaminen
     */
    private void paivitaKortti(ActionEvent e) {
        for (int i = 0; i < kortit.size(); i++) {
            if (kortit.get(i) == e.getSource()) {
                korttiNakyviin(i);

                if (muistipeli.montaKatsottu() == 1) {
                    muistipeli.kaannaKortti(0, i);
                }
                if (muistipeli.montaKatsottu() == 2) {
                    muistipeli.kaannaKortti(1, i);
                    if (muistipeli.tarkistaPari()) {
                        pariLukkoon();
                    }
                    paivitaPisteetJaParit();
                }
                if (muistipeli.montaKatsottu() == 3) {
                    korttiPiiloon(0);
                    korttiPiiloon(1);

                    muistipeli.kaannaKortti(0, i);
                }
                if (!muistipeli.peliJatkuu()) {
                    peliLapi();
                }
            }
        }
    }

    public static void main(String[] args) throws Exception {
        new Gui();
    }
}
