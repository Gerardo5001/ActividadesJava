import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Random;

public class deck extends JFrame implements ActionListener {

    private JTextArea pantalla;
    private JTextArea opcion;
    private JTextArea resultado;
    private JButton btn_shuffle;
    private JButton btn_head;
    private JButton btn_pick;
    private JButton btn_hand;
    private JPanel window;
    ArrayList<card> hand = new ArrayList();

    public static void main(String[]args){
        deck frame = new deck();
    }

    public deck(){

        int numCarta=1;
        while (numCarta < 53){
            card carta = new card();
            if(numCarta==1){
                carta.setPalo("Trebol");
                carta.setColor("Negro");
                carta.setValor("A");
                hand.add(carta);
            }
            else if(numCarta < 11){
                carta.setPalo("Trebol");
                carta.setColor("Negro");
                carta.setValor(String.valueOf(numCarta));
                hand.add(carta);
            }
            else if(numCarta==11){
                carta.setPalo("Trebol");
                carta.setColor("Negro");
                carta.setValor("J");
                hand.add(carta);
            }
            else if(numCarta==12){
                carta.setPalo("Trebol");
                carta.setColor("Negro");
                carta.setValor("Q");
                hand.add(carta);
            }
            else if(numCarta==13){
                carta.setPalo("Trebol");
                carta.setColor("Negro");
                carta.setValor("K");
                hand.add(carta);
            }
            else if(numCarta==14){
                carta.setPalo("Corazon");
                carta.setColor("Rojo");
                carta.setValor("A");
                hand.add(carta);
            }
            else if(numCarta>14 && numCarta<24){
                carta.setPalo("Corazon");
                carta.setColor("Rojo");
                carta.setValor(String.valueOf(numCarta-13));
                hand.add(carta);
            }
            else if(numCarta==24){
                carta.setPalo("Corazon");
                carta.setColor("Rojo");
                carta.setValor("J");
                hand.add(carta);
            }
            else if(numCarta==25){
                carta.setPalo("Corazon");
                carta.setColor("Rojo");
                carta.setValor("Q");
                hand.add(carta);
            }
            else if(numCarta==26){
                carta.setPalo("Corazon");
                carta.setColor("Rojo");
                carta.setValor("K");
                hand.add(carta);
            }
            else if(numCarta==27){
                carta.setPalo("Pica");
                carta.setColor("Negro");
                carta.setValor("A");
                hand.add(carta);
            }
            else if(numCarta>27 && numCarta<37){
                carta.setPalo("Pica");
                carta.setColor("Negro");
                carta.setValor(String.valueOf(numCarta-26));
                hand.add(carta);
            }
            else if(numCarta==37){
                carta.setPalo("Pica");
                carta.setColor("Negro");
                carta.setValor("J");
                hand.add(carta);
            }
            else if(numCarta==38){
                carta.setPalo("Pica");
                carta.setColor("Negro");
                carta.setValor("Q");
                hand.add(carta);
            }
            else if(numCarta==39){
                carta.setPalo("Pica");
                carta.setColor("Negro");
                carta.setValor("K");
                hand.add(carta);
            }
            else if(numCarta==40){
                carta.setPalo("Diamante");
                carta.setColor("Rojo");
                carta.setValor("A");
                hand.add(carta);
            }
            else if(numCarta>40 && numCarta<50){
                carta.setPalo("Diamante");
                carta.setColor("Rojo");
                carta.setValor(String.valueOf(numCarta-39));
                hand.add(carta);
            }
            else if(numCarta==50){
                carta.setPalo("Diamante");
                carta.setColor("Rojo");
                carta.setValor("J");
                hand.add(carta);
            }
            else if(numCarta==51){
                carta.setPalo("Diamante");
                carta.setColor("Rojo");
                carta.setValor("Q");
                hand.add(carta);
            }
            else if(numCarta==52){
                carta.setPalo("Diamante");
                carta.setColor("Rojo");
                carta.setValor("K");
                hand.add(carta);
            }
            numCarta++;
        } // Se iniciaiza el deck con 52 cartas

        setDefaultCloseOperation(EXIT_ON_CLOSE);

        window = new JPanel();
        window.setLayout(null);

        pantalla =new JTextArea("");
        pantalla.setBounds(100,1,400,125);
        window.add(pantalla);

        opcion = new JTextArea("");
        opcion.setBounds(150,150,150,25);
        window.add(opcion);

        btn_shuffle = new JButton("Aceptar");
        btn_shuffle.setBounds(300,150,150,25);
        btn_shuffle.addActionListener(this);
        window.add(btn_shuffle);

        resultado = new JTextArea("");
        resultado.setBounds(0,200,600,100);
        window.add(resultado);
        /*
        btn_hand = new JButton("Eliminar 5 cartas");
        btn_hand.setBounds(150,110,150,50);
        btn_hand.addActionListener(this);
        window.add(btn_hand);

        btn_pick = new JButton("Elimnar aleatorio");
        btn_pick.setBounds(300,110,150,50);
        btn_pick.addActionListener(this);
        window.add(btn_pick);

        btn_head = new JButton("Eliminar siguiente");
        btn_head.setBounds(450,110,150,50);
        btn_head.addActionListener(this);
        window.add(btn_head);
        */
        add(window);
        setSize(600,400);
        setVisible(true);

        showMenu();
    }

    public void shuffle(){
        //El método deberá imprimir en pantalla el siguiente mensaje: Se mezcló el Deck.
        resultado.setText("Se mezclo el Deck.");
    }
    public void head(){
        if(hand.size()==0){
            resultado.setText("No hay mas cartas para eliminar");
        }
        else {
            String palo = hand.get(0).getPalo();
            String color = hand.get(0).getColor();
            String valor = hand.get(0).getValor();
            hand.remove(0);
            //El método deberá imprimir en pantalla un mensaje con el siguiente formato:
            //{Palo},{Color},{Valor} //Quedan {número de cartas en deck}
            resultado.setText(palo + ", " + color + ", " + valor + "\nQuedan " + hand.size() + " cartas");
        }
    }
    public  void pick(){ //seleccionar una carta al azar, la carta deberá removerse del deck. El método deberá imprimir en pantalla un mensaje con el siguiente formato:
        if(hand.size()==0){
            resultado.setText("No hay mas cartas para eliminar");
        }
        else {
            Random index = new Random();
            int valorIn = index.nextInt(hand.size());
            String palo = hand.get(valorIn).getPalo();
            String color = hand.get(valorIn).getColor();
            String valor = hand.get(valorIn).getValor();
            hand.remove(valorIn);
            resultado.setText(palo + ", " + color + ", " + valor + "\nQuedan " + hand.size() + " cartas");
            //{Palo},{Color},{Valor}
            //Quedan {número de cartas en deck}
        }
    }
    public ArrayList<card> hand_(){
        ArrayList<card> mano = new ArrayList<>();
        if(hand.size()<6){
            resultado.setText("Ya no hay cartas disponibles para esta opcion.");
        }
        else {
            for (int i = 0; i < 5; i++) {
                card carta = new card();
                carta.setPalo(hand.get(i).getPalo());
                carta.setColor(hand.get(i).getColor());
                carta.setValor(hand.get(i).getValor());
                mano.add(carta);
                hand.remove(i);
            }
            resultado.setText(mano.get(0).getPalo() + ", " + mano.get(0).getColor() + ", " + mano.get(0).getValor() + "\n" +
                    mano.get(1).getPalo() + ", " + mano.get(1).getColor() + ", " + mano.get(1).getValor() + "\n" +
                    mano.get(2).getPalo() + ", " + mano.get(2).getColor() + ", " + mano.get(2).getValor() + "\n" +
                    mano.get(3).getPalo() + ", " + mano.get(3).getColor() + ", " + mano.get(3).getValor() + "\n" +
                    mano.get(4).getPalo() + ", " + mano.get(4).getColor() + ", " + mano.get(4).getValor() + "\nQuedan " + hand.size() + " cartas");

        }
        return mano;
    }
    public void showMenu(){
        pantalla.setText("Bienvenido a Poker!\n" +
                "Selecciona una opción:\n" +
                "1 Mezclar deck\n" +
                "2 Sacar una carta\n" +
                "3 Carta al azar\n" +
                "4 Generar una mano de 5 cartas\n" +
                "0 Salir");
    }



    @Override
    public void actionPerformed(ActionEvent e)
    {
        int op = Integer.parseInt(opcion.getText().toString());

        switch (op){
            case 1:
                shuffle();
                break;
            case 2:
                head();
                break;
            case 3:
                pick();
                break;
            case 4:
                hand_();
                break;
            case 0:
                System.exit(0);
                break;
            default:
                pantalla.setText("Bienvenido a Poker!\n" +
                        "Selecciona una opción:\n" +
                        "1 Mezclar deck\n" +
                        "2 Sacar una carta\n" +
                        "3 Carta al azar\n" +
                        "4 Generar una mano de 5 cartas\n" +
                        "0 Salir" + "\nElija una opcion valida");

        }
    }
}