import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Restaurante02 extends JFrame {

    private JTextField txtPeso, txtValorQuilo;
    private JLabel lblResultado;

    public Restaurante02() {
        setTitle("Fomelândia 🍽️");
        setSize(400, 260);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(null);
   
        getContentPane().setBackground(new Color(120, 0, 0));

        JLabel lblPeso = new JLabel("Peso (kg):");
        lblPeso.setBounds(40, 30, 120, 25);
        lblPeso.setForeground(Color.YELLOW);
        lblPeso.setFont(new Font("Arial", Font.BOLD, 13));
        add(lblPeso);

        txtPeso = new JTextField();
        txtPeso.setBounds(160, 30, 150, 25);
        txtPeso.setBackground(new Color(255, 230, 230));
        add(txtPeso);

        JLabel lblValor = new JLabel("Valor por kg:");
        lblValor.setBounds(40, 70, 120, 25);
        lblValor.setForeground(Color.ORANGE);
        lblValor.setFont(new Font("Arial", Font.BOLD, 13));
        add(lblValor);

        txtValorQuilo = new JTextField("9.95"); 
        txtValorQuilo.setBounds(160, 70, 150, 25);
        txtValorQuilo.setBackground(new Color(255, 230, 230));
        add(txtValorQuilo);

        JButton btnCalcular = new JButton("Calcular Total");
        btnCalcular.setBounds(110, 110, 160, 30);
        btnCalcular.setBackground(new Color(255, 140, 0));
        btnCalcular.setForeground(Color.BLACK);
        btnCalcular.setFont(new Font("Arial", Font.BOLD, 12));
        btnCalcular.setFocusPainted(false);
        add(btnCalcular);

        lblResultado = new JLabel("Total a pagar: ");
        lblResultado.setBounds(40, 160, 300, 25);
        lblResultado.setForeground(Color.GREEN);
        lblResultado.setFont(new Font("Arial", Font.BOLD, 15));
        add(lblResultado);

  
        btnCalcular.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                try {
                    double peso = Double.parseDouble(txtPeso.getText());
                    double valorQuilo = Double.parseDouble(txtValorQuilo.getText());

                    double total = Restaurante.calcularTotal(peso, valorQuilo);

                    lblResultado.setText("Total a pagar: R$ " + total);

                } catch (NumberFormatException ex) {
                    lblResultado.setText("Digite valores válidos!");
                }
            }
        });
    }

    public static void main(String[] args) {
    	Restaurante02 tela = new Restaurante02();
        tela.setVisible(true);
    }
}