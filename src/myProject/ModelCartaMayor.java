package myProject;

public class ModelCartaMayor {
        //private Carta carta1, carta2;
        private Baraja baraja;
        private Carta cartaUser, cartaPc;
        private int estado, valorDelPalo;
        private String[] estadoToString;

        public ModelCartaMayor(){

                estadoToString = new String[1];
                baraja = new Baraja();

        }

        public void determinarEstadoJuego(){

                if(cartaUser.getNumero() > cartaPc.getNumero()) {
                        estado=1; //gana el usuario
                }else if (cartaUser.getNumero() < cartaPc.getNumero()) {
                        estado=2; //gana el pc
                }else{
                        rondaPalos();
                }
        }

        public void barajarModel () {
                baraja.barajar();
        }


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


        public void rondaPalos() {
                if(valorPalo(cartaUser)>valorPalo(cartaPc)) {
                        estado=3; //gana el usuario por palos
                }else{
                        if(valorPalo(cartaUser)<valorPalo(cartaPc)) {
                        estado=4; //gana el pc por palos
                        }
                }
        }


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


        //obtener la carta del usuario
        public Carta getCartaUser() {
                return cartaUser;
        }

        public Carta getCartaPc() {
                return cartaPc;
        }




        /**instancia y establece la carta que se usará durante toda la ronda
         * asi no se crean cartas distintas, sino cada vez que se da a obtener carta usa la misma*/
        public void setCartaUser() {
                cartaUser = baraja.obtenerCarta(0);
        }

        public void setCartaPc() {
                cartaPc = baraja.obtenerCarta(1);
        }


        public void mostrarBaraja() {
                 baraja.mostrarBaraja();
                }
        }

