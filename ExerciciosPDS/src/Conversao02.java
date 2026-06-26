import javax.swing.*;
import java.awt.event.*;
import java.awt.Color;
import java.awt.Font;

public class Conversao02 extends JFrame {

    private JTextField txtFahrenheit;
    private JLabel lblResultado;
    private JButton btnConverter;

    public Conversao02() {
    	getContentPane().setBackground(new Color(255, 255, 164));
        setTitle("Conversão de Temperatura");
        setSize(300, 200);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        getContentPane().setLayout(null);

        JLabel lblF = new JLabel("Fahrenheit:");
        lblF.setBounds(10, 20, 100, 25);
        getContentPane().add(lblF);

        txtFahrenheit = new JTextField();
        txtFahrenheit.setBounds(80, 20, 162, 25);
        getContentPane().add(txtFahrenheit);

        btnConverter = new JButton("Converter");
        btnConverter.setFont(new Font("Gadugi", Font.BOLD | Font.ITALIC, 12));
        btnConverter.setBounds(80, 60, 162, 30);
        getContentPane().add(btnConverter);

        lblResultado = new JLabel("Celsius: ");
        lblResultado.setBounds(10, 106, 200, 25);
        getContentPane().add(lblResultado);

        btnConverter.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                try {
                    double f = Double.parseDouble(txtFahrenheit.getText());
                    double c = Conversao.calcularTemperatura(f);
                    lblResultado.setText("Celsius: " + c);
                } catch (NumberFormatException ex) {
                    lblResultado.setText("Digite um número válido!");
                }
            }
        });
    }

    public static void main(String[] args) {
        Conversao02 tela = new Conversao02();
        tela.setVisible(true);
    }
}
