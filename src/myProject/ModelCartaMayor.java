package myProject;

public class ModelCartaMayor {
        //atributos
        private Baraja baraja; //objeto tipo baraja
        private Carta cartaUser, cartaPc; //dos objetos tipo carta, uno para el usuario otro para el pc
        private int estado, valorDelPalo; //int estado para saber el estado del juego
                                          //int valor de palo para asignar un valor numerico a cada palo
        private String[] estadoToString; //describir cada estado en string

        /**
         * Constructor de la clase ModelCartaMayor
         */
        public ModelCartaMayor(){

                estadoToString = new String[1];
                baraja = new Baraja();

        }

        /**
         * Determina el ganador del juego, basandose en quién tiene la carta de mayor valor
         *
         */
        public void determinarEstadoJuego(){

                if(cartaUser.getNumero() > cartaPc.getNumero()) {
                        estado=1; //gana el usuario
                }else if (cartaUser.getNumero() < cartaPc.getNumero()) {
                        estado=2; //gana el pc
                }else{
                        rondaPalos();
                }
        }

        /**
         * Baraja las cartas antes antes de iniciar la partida
         */
        public void barajarModel () {
                baraja.barajar();
        }


        /**
         * Asigna un valor numerico a cada palo dependiendo de cual sea el palo.(siendo oros el mejor y bastos el peor)
         * @param carta
         * @return valorDelPalo
         */
        public int valorPalo(Carta carta){
                if(carta.getPalo()=="o"){
                        valorDelPalo=4;
                }else if(carta.getPalo()=="c"){
                        valorDelPalo=3;
                }else if (carta.getPalo()=="e"){
                        valorDelPalo=2;
                }else if(carta.getPalo()=="b"){
                        valorDelPalo=1;
                }
                return valorDelPalo;
        }

        /**
         * determina el ganador del juego, con base en el jugador que sacó la carta con un mejor palo,
         * en caso de que el numero de ambas cartas sea el mismo
         *
         */
        public void rondaPalos() {
                if(valorPalo(cartaUser)>valorPalo(cartaPc)) {
                        estado=3; //gana el usuario por palos
                }else{
                        if(valorPalo(cartaUser)<valorPalo(cartaPc)) {
                        estado=4; //gana el pc por palos
                        }
                }
        }

        /**
         * Establece un mensaje de texto en el area asignada, con el palo y valor de la carta de la maquina y el usuario,
         * ademas de un mensaje con base en el resultado de la partida.
         * @return estadoToString
         */

        public String[] getEstadoToString() {
                switch (estado) {
                        case 1: estadoToString[0] = "tu carta fue: "+cartaUser.getNumero()+cartaUser.getPalo()+
                                                    "\nLa carta de la maquina fue: "+cartaPc.getNumero()+cartaPc.getPalo()+
                                                    "\nEl numero de tu carta fue mayor, ganaste!!";
                                break;
                        case 2: estadoToString[0] = "tu carta fue: "+cartaUser.getNumero()+cartaUser.getPalo()+
                                                    "\nLa carta de la maquina fue: "+cartaPc.getNumero()+cartaUser.getPalo()+
                                                    "\nEl numero de la carta de la maquina fue mayor, perdiste!!";
                                break;
                        case 3: estadoToString[0] = "tu carta fue: "+cartaUser.getNumero()+cartaUser.getPalo()+
                                                    "\nLa carta de la maquina fue: "+cartaPc.getNumero()+cartaPc.getPalo()+
                                                    "\nTú y la maquina obtuvieron el mismo numero de carta "+
                                                    "\npero tu palo era de mayor valor, ganaste!! k pro";
                                break;
                        case 4: estadoToString[0] = "tu carta fue: "+cartaUser.getNumero()+cartaUser.getPalo()+
                                                    "\nLa carta de la maquina fue: "+cartaPc.getNumero()+cartaPc.getPalo()+
                                                    "\nTú y la maquina obtuvieron el mismo numero de carta "+
                                                    "\npero su palo era de mayor valor, perdiste :c";
                                break;

                }
                return estadoToString;
        }


        /**
         * obtener la carta del usuario
         * @return cartaUser
         */
        public Carta getCartaUser() {
                return cartaUser;
        }

        /**
         * obtener la carta del pc
         * @return cartaPc
         */
        public Carta getCartaPc() {
                return cartaPc;
        }




        /**instancia y establece la carta del usuario que se usará durante toda la ronda
         * asi no se crean cartas distintas, sino cada vez que se da a obtener carta usa la misma*/
        public void setCartaUser() {

                cartaUser = baraja.obtenerCarta(0);
        }

        /**instancia y establece la carta del pc que se usará durante toda la ronda
         * asi no se crean cartas distintas, sino cada vez que se da a obtener carta usa la misma*/
        public void setCartaPc() {
                cartaPc = baraja.obtenerCarta(1);
        }



}

