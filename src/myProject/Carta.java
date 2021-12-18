package myProject;

import java.util.Random;

public class Carta {

    //attributes
    private int numero;
    private String palo;

    public static final String[] PALOS = {"b", "c", "e", "o"};
    public static final int LIMITE_CARTA_PALOS = 12;

    public Carta(int numero, String palo) {
        this.numero = numero;
        this.palo = palo;
    }


    /**
     *Method that generate the rute of image
     * @return rute of image
     */
    public String toString() {

        return numero+palo;
    }


    public int getNumero() {
        return numero;
    }

    public String getPalo() {
        return palo;
    }
}
