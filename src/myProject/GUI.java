package myProject;

import javax.swing.*;
import javax.swing.border.EtchedBorder;
import javax.swing.border.TitledBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

/**
 * This class is used for ...
 * @autor Paola-J Rodriguez-C paola.rodriguez@correounivalle.edu.co
 * @version v.1.0.0 date:21/11/2021
 */
public class GUI extends JFrame {
    private static final String AYUDA = "Bienvenido a Carta mayor \n"
            + "Oprime el botón obtener cartas para iniciar el juego"
            + "\nSi tu carta tiene un numero mayor a la de la máquina, "
            + "\nhabrás ganado. Si sacan el mismo número, se decidirá "
            + "\nla victoria por el tipo de carta, siendo:"
            + "\nOros es mayor que Copas, Copas es mayor que Espadas "
            + "\ny Espadas es mayor que Bastos";

    private Header headerProject;
    private JLabel cartaUser, cartaMachine;
    private JButton obtenerCarta, salir, ayuda;
    private JPanel panelTuCarta, panelCartaMaquina;
    private JTextArea resultado;
    private Escucha escucha;
    private ModelCartaMayor modelCartaMayor;
    private ImageIcon imageCarta;
    private JFrame movimientoVentana;

    /**
     * Constructor of GUI class
     */
    public GUI(){
        initGUI();


        //Default JFrame configuration
        this.setTitle("Carta Mayor");
        this.setUndecorated(true);
        // this.setBackground(new Color(255,255,255,0));
        this.pack();
        this.setResizable(true);
        this.setVisible(true);
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    /**
     * This method is used to set up the default JComponent Configuration,
     * create Listener and control Objects used for the GUI class
     */
    private void initGUI() {
        //Set up JFrame Container's Layout
        this.getContentPane().setLayout(new GridBagLayout());
        GridBagConstraints constraints = new GridBagConstraints();
        movimientoVentana=this;


        //Create Listener Object and Control Object
        escucha = new Escucha();
        modelCartaMayor = new ModelCartaMayor();





        //Set up JComponents
        //titulo
        headerProject = new Header("Mesa de juego carta mayor", Color.red);
        headerProject.setCursor(new Cursor(Cursor.HAND_CURSOR));
        headerProject.addMouseListener(escucha);
        headerProject.addMouseMotionListener(escucha);
        constraints.gridx=0;
        constraints.gridy=0;
        constraints.gridwidth=0;
        constraints.fill=GridBagConstraints.HORIZONTAL;
        this.add(headerProject,constraints); //Change this line if you change JFrame Container's Layout

        //boton de ayuda
        ayuda = new JButton("ayuda");
        ayuda.setCursor(new Cursor(Cursor.HAND_CURSOR));
        ayuda.addActionListener(escucha);
        constraints.gridx=0;
        constraints.gridy=1;
        constraints.gridwidth=1;
        constraints.fill=GridBagConstraints.NONE;
        constraints.anchor=GridBagConstraints.LINE_START;
        add(ayuda, constraints);

        //boton de salir
        salir = new JButton("salir");
        salir.setCursor(new Cursor(Cursor.HAND_CURSOR));
        salir.addActionListener(escucha);
        constraints.gridx=1;
        constraints.gridy=1;
        constraints.gridwidth=1;
        constraints.fill=GridBagConstraints.NONE;
        constraints.anchor=GridBagConstraints.LINE_END;
        add(salir, constraints);

        //cartas
        imageCarta = new ImageIcon(getClass().getResource("/resources/reverso.jpg"));
        cartaUser = new JLabel(imageCarta);
        cartaMachine = new JLabel(imageCarta);

        //Panel de usuario
        panelTuCarta = new JPanel();
        panelTuCarta.setPreferredSize(new Dimension(250, 350));
        panelTuCarta.setBorder(BorderFactory.createTitledBorder(new EtchedBorder(EtchedBorder.LOWERED), "Tu carta", TitledBorder.CENTER, TitledBorder.DEFAULT_POSITION));
        panelTuCarta.add(cartaUser);
        constraints.gridx=0;
        constraints.gridy=2;
        constraints.gridwidth=1;
        constraints.fill=GridBagConstraints.BOTH;
        constraints.anchor=GridBagConstraints.CENTER;
        add(panelTuCarta, constraints);

        //panel de maquina
        panelCartaMaquina = new JPanel();
        panelCartaMaquina.setPreferredSize(new Dimension(250, 350));
        panelCartaMaquina.setBorder(BorderFactory.createTitledBorder(new EtchedBorder(EtchedBorder.LOWERED), "Carta de la maquina", TitledBorder.CENTER, TitledBorder.DEFAULT_POSITION));
        panelCartaMaquina.add(cartaMachine);
        constraints.gridx=1;
        constraints.gridy=2;
        constraints.gridwidth=1;
        constraints.fill=GridBagConstraints.BOTH;
        constraints.anchor=GridBagConstraints.CENTER;
        add(panelCartaMaquina, constraints);

        //boton de lanzar
        obtenerCarta = new JButton("Obtener cartas");
        obtenerCarta.setCursor(new Cursor(Cursor.HAND_CURSOR));
        obtenerCarta.addActionListener(escucha);
        constraints.gridx=0;
        constraints.gridy=3;
        constraints.gridwidth=2;
        constraints.fill=GridBagConstraints.NONE;
        constraints.anchor=GridBagConstraints.CENTER;
        add(obtenerCarta, constraints);

        //mensajes de juego
        resultado = new JTextArea(4, 31);
        resultado.setText("Usa el botón (?) para ver las reglas del juego");
        resultado.setBorder(BorderFactory.createTitledBorder(new EtchedBorder(EtchedBorder.LOWERED), "Mensajes", TitledBorder.CENTER, TitledBorder.DEFAULT_POSITION));
        resultado.setBackground(null);
        resultado.setEditable(false);
        constraints.gridx=0;
        constraints.gridy=4;
        constraints.gridwidth=2;
        constraints.fill=GridBagConstraints.NONE;
        constraints.anchor=GridBagConstraints.CENTER;
        add(resultado, constraints);






    }

    /**
     * Main process of the Java program
     * @param args Object used in order to send input data from command line when
     *             the program is execute by console.
     */
    public static void main(String[] args){
        EventQueue.invokeLater(() -> {
            /*Baraja b = new Baraja();
            b.mostrarBaraja();*/
            GUI miProjectGUI = new GUI();

        });
    }

    /**
     * inner class that extends an Adapter Class or implements Listeners used by GUI class
     */
    private class Escucha extends MouseAdapter implements ActionListener {


        private int x, y;
        @Override
        public void actionPerformed(ActionEvent e) {
            if(e.getSource()==obtenerCarta){
                resultado.setText(null);
                modelCartaMayor.setCartaUser();
                modelCartaMayor.setCartaPc();
                modelCartaMayor.determinarEstadoJuego();
                imageCarta = new ImageIcon(getClass().getResource("/resources/"+modelCartaMayor.getCartaUser().getNumero()+modelCartaMayor.getCartaUser().getPalo()+".jpg"));
                cartaUser.setIcon(imageCarta);
                imageCarta = new ImageIcon(getClass().getResource("/resources/"+modelCartaMayor.getCartaPc().getNumero()+modelCartaMayor.getCartaPc().getPalo()+".jpg"));
                cartaMachine.setIcon(imageCarta);
                resultado.setText(modelCartaMayor.getEstadoToString()[0]);

                modelCartaMayor.barajarModel();

            }else if(e.getSource()==ayuda) {
                JOptionPane.showMessageDialog(null, AYUDA);
            }else{
                System.exit(0);
            }
        }

        public void mousePressed(MouseEvent e) {
            x = e.getX();
            y = e.getY();

        }

        @Override
        public void mouseDragged(MouseEvent e) {
            movimientoVentana.setLocation(movimientoVentana.getLocation().x + e.getX() - x, movimientoVentana.getLocation().y + e.getY() - y);


        }

    }
}
