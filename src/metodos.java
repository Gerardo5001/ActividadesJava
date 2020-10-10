import org.omg.PortableInterceptor.INACTIVE;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class metodos extends JFrame implements ActionListener{

    private JLabel instruccion;
    private JTextField valorIntro;
    private JButton boton;
    private JTextArea resultadoUno;
    private JTextArea resultadoDos;
    private JPanel window;

    public metodos() {
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        instruccion = new JLabel("Ingresa un valor: ");
        instruccion.setBounds(200,1,500,20);

        valorIntro = new JTextField();
        valorIntro.setBounds(200,40,100,20);

        boton = new JButton("Calcular");
        boton.addActionListener(this);
        boton.setBounds(200,65,100,20);

        resultadoUno = new JTextArea("");
        resultadoUno.setBounds(1,90,500,100);

        resultadoDos= new JTextArea("");
        resultadoDos.setBounds(1,200,500,100);

        window = new JPanel();
        window.setLayout(null);

        window.add(instruccion);
        window.add(valorIntro);
        window.add(boton);
        window.add(resultadoUno);
        window.add(resultadoDos);

        add(window);
        setSize(500,400);
        setVisible(true );
    }

    public static void main(String []args){

        metodos frame = new metodos();
    }


    @Override
    public void actionPerformed(ActionEvent e) {
        resultadoUno.setText("Numeros primos:\n"+calculaPrimos(valorIntro.getText()).toString());
        resultadoDos.setText("Serie de Fibonacci:\n"+metodoFibonacci(valorIntro.getText()).toString());
    }

    public ArrayList<Integer> calculaPrimos(String valor){
        int numero = Integer.parseInt(valor);
        ArrayList<Integer> serieNumeros = new ArrayList<>();
        int dividendos;
        for(int i=0; i<numero+1; i++) {
            dividendos=0;
            for(int x=1; x<numero+1; x++){
                if(i%x ==0){
                    dividendos++;
                }
            }
            if(dividendos==2)
                serieNumeros.add(i);
        }
        return serieNumeros;
    }
    public ArrayList<Integer> metodoFibonacci(String valor){
        int numero = Integer.parseInt(valor);
        int valor1=0, valor2=1, valor3;
        ArrayList<Integer> serieNumeros = new ArrayList<>(1);

        for(int i = 0; i<numero; i++){
            if(i==0) {
                serieNumeros.add(i);
                valor1 = 0;
            }
            else if(i==1) {
                serieNumeros.add(i);
                valor2 = 1;
            }
            else {
                valor3 = valor1+valor2;
                serieNumeros.add(valor3);
                valor1=valor2;
                valor2=valor3;
            }
        }
        return serieNumeros;
    }
}
