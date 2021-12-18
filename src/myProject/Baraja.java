package myProject;


import java.util.Random;

/**
 * This class is used for ...
 * @autor Santiago Casañas Tabares 2025301 - Jesus Adrian Peña Güetio 2025513
 * santiago.casanas@correounivalle.edu.co - jesus.guetio@correounivalle.edu.co
 * @version v.1.0.0 date:18/12/2021
 */

public class Baraja {
    //atributes
    private Carta cartas[]; //array de cartas
    private int cartaAElegir; //posicion dada para escoger una carta
    private Random random; //objeto randomizador
    private static final int NUM_CARTAS=40; //declaración de tamaño del arra de cartas

    //metodos


    /**
     * constructor de la clase Baraja
     */
    public Baraja() {
        cartas = new Carta[NUM_CARTAS];
        random = new Random();
        crearBaraja();
        barajar();
    }

    /**
     * metodo para crear la baraja, asignando 10 numeros (1, 10) a cada palo del mazo, que son 4 (oros, copas, espadas, bastos)
     *
     */
    public void crearBaraja() {
        String[] palos = Carta.PALOS; //para llamar al array de palos

        for (int i=0; i< palos.length ;i++) { //for para los palos

            for (int j=0;j< Carta.LIMITE_CARTA_PALOS;j++) { //for para los numeros

                if( !( j==7 || j==8 )) { //en caso de no ser 7 ni 8
                    if(j>=9){ //si es mayor o igual a 9
                        cartas[((i * (Carta.LIMITE_CARTA_PALOS-2)) + (j-2))] = new Carta(j + 1, palos[i]); //coge la posicion del array de palos y lo multiplica
                                                                                                                  //por el limite de cartas por palo(12) menos dos, porque
                                                                                                                  //al final son 10 cartas, luego se le suma la posicion de j
                                                                                                                  // menos 2, para así ponerlo en la posicion correcta sin saltarse
                                                                                                                  // posiciones. Posteriormente se crea la carta con el j y el i
                    }else{
                        cartas[((i * (Carta.LIMITE_CARTA_PALOS-2)) + j)] = new Carta(j + 1, palos[i]); //coge la posicion del array de palos y lo multiplica
                                                                                                             //por el limite de cartas por palo(12) menos dos, porque
                                                                                                             //al final son 10 cartas, luego se le suma la posicion de j,
                                                                                                             //para así ponerlo en la posicion correcta sin saltarse
                                                                                                             // posiciones. Posteriormente se crea la carta con el j y el i
                    }

                }
            }
        }
    }

    /**
     * metodo que sirve para aleatorizar o barajar la baraja de cartas, escogiendo una posicion aleatoria entre 0 y 40,
     * y posicionando la carta escogida en esa posicion al azar, asi con cada una de las 40 cartas
     */
    public void barajar() {
        int posicionAleatoria = 0;
        Carta c; //variable para guardar la carta de la posicion del for

        for (int i=0; i<cartas.length ;i++) {
            posicionAleatoria = random.nextInt(40); //se escoge una posicion aleatoria

            c = cartas[i];//se guarda la carta de la posicion i del for en c, dejando i vacio
            cartas[i] = cartas[posicionAleatoria];//se guarda la carta de la posicion aleatoria en i, dejando aleatoria vacio
            cartas[posicionAleatoria] = c;//se pasa la carta c en posicion aleatoria, dejando c vacio de nuevo
        }
    }

    /**
     * metodo para obtener una clase especifica del mazo
     * @return carta
     */
    public Carta obtenerCarta(int cartica) {

        cartaAElegir = cartica;

        Carta c = cartas[cartaAElegir];

        return c;
    }


}
