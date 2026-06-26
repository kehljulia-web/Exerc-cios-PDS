import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Combustivel02 extends JFrame {

    private JTextField txtPreco, txtValor;
    private JLabel lblResultado;

    public Combustivel02() {
        setTitle("Cálculo de Combustível");
        setSize(400, 250);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(null);

        getContentPane().setBackground(new Color(200, 255, 200));
        JLabel lblPreco = new JLabel("Preço por litro:");
        lblPreco.setBounds(30, 30, 150, 25);
        lblPreco.setForeground(new Color(0, 100, 0)); 
        add(lblPreco);

        txtPreco = new JTextField();
        txtPreco.setBounds(180, 30, 150, 25);
        add(txtPreco);

        JLabel lblValor = new JLabel("Valor a pagar:");
        lblValor.setBounds(30, 70, 150, 25);
        lblValor.setForeground(new Color(0, 100, 0));
        add(lblValor);

        txtValor = new JTextField();
        txtValor.setBounds(180, 70, 150, 25);
        add(txtValor);


        JButton btnCalcular = new JButton("Calcular Litros");
        btnCalcular.setBounds(110, 110, 160, 30);
        btnCalcular.setBackground(new Color(144, 238, 144)); 
        btnCalcular.setForeground(new Color(0, 100, 0));
        btnCalcular.setFocusPainted(false);
        add(btnCalcular);

        lblResultado = new JLabel("Litros: ");
        lblResultado.setBounds(30, 160, 300, 25);
        lblResultado.setForeground(new Color(0, 100, 0));
        lblResultado.setFont(new Font("Arial", Font.BOLD, 14));
        add(lblResultado);


        btnCalcular.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                try {
                    double preco = Double.parseDouble(txtPreco.getText());
                    double valor = Double.parseDouble(txtValor.getText());

                    double litros = Combustivel.calcularLitros(preco, valor);

                    lblResultado.setText("Litros possíveis: " + litros);

                } catch (NumberFormatException ex) {
                    lblResultado.setText("Digite valores válidos!");
                }
            }
        });
    }

    public static void main(String[] args) {
        Combustivel02 tela = new  Combustivel02();
        tela.setVisible(true);
    }
}