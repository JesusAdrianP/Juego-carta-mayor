package myProject;

/**
 * This class is used for ...
 * @autor Santiago Casañas Tabares 2025301 - Jesus Adrian Peña Güetio 2025513
 * santiago.casanas@correounivalle.edu.co - jesus.guetio@correounivalle.edu.co
 * @version v.1.0.0 date:18/12/2021
 */

public class Carta {

    //attributes
    private int numero; //numero asignado a la carta
    private String palo; //palo que tendrá la carta

    public static final String[] PALOS = {"b", "c", "e", "o"}; //palos disponibles para jugar en el programa
                                                               //bastos: b, copas: c, oros: o, espadas: e

    public static final int LIMITE_CARTA_PALOS = 12; // mayor valor de carta que puede obtener un palo

    /**
     * constructor de la carta
     * @param numero
     * @param palo
     */
    public Carta(int numero, String palo) {
        this.numero = numero;
        this.palo = palo;
    }

    /**
     * metodo para obtener el numero de la carta
     * @return numero
     */
    public int getNumero() {
        return numero;
    }

    /**
     * metodo para obtener el palo de la carta
     * @return palo
     */
    public String getPalo() {
        return palo;
    }
}
