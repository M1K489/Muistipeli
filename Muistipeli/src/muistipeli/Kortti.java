/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package muistipeli;

/**
 * Pelilaudan kortti. Sisältää kortin tunnusnumeron, tiedon siitä, onko kortti käännetty ja metodit
 * kortin arvon palauttamiseen ja kortin kääntämiseen.
 */
public class Kortti {

    /**
     * kortin arvo/tunnusnumero, jolla kortit erotetaan toisistaan
     */
    private int arvo;

    /**
     * true, jos kortti on käännetty ja false, jos korttia ei ole käännetty. Tällä hetkellä tarpeellinen vain
     * tekstiversiossa
     */
    private boolean onkokaannetty;
    
    /**
     * luo uuden kortin
     * @param arvo kortin tunnusnumero
     */
    public Kortti(int arvo) {
        this.arvo = arvo;
        onkokaannetty = false;
    }

    /**
     * palauttaa kortin tunnusnumeron
     * @return kortin tunnusnumero
     */
    public int getArvo() {
        return arvo;
    }

    /**
     * kertoo onko kortti käännetty. Tällä hetkellä tarpeellinen vain tekstiversiossa
     * @return true, jos kortti on käännetty ja false, jos korttia ei ole käännetty
     */
    public boolean onkoKaannetty() {
        return onkokaannetty;

    }
    
    /**
     * kääntää kortin näkyviin. Tällä hetkellä tarpeellinen vain tekstiversiossa
     */
    public void kaannaNäkyviin() {
        onkokaannetty = true;
    }
    
    /**
     * kääntää kortin pois näkyvistä. Tällä hetkellä tarpeellinen vain tekstiversiossa
     */
    public void kaannaPois() {
        onkokaannetty = false;
    }
    
    /**
     * tekstiversiota varten oleva esitys
     * @return
     */
    @Override
     public String toString() {
        if (onkokaannetty == false) {
            return "?";
        } else {
            return "" +arvo +"";
        }
    }
}