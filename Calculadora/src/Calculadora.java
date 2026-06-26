import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Calculadora extends JFrame {

    private JTextField txtNum1, txtNum2;
    private JLabel lblResultado;

    public Calculadora() {
        setTitle("Calculadora Simples");
        setSize(350, 250);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        getContentPane().setLayout(null);

        getContentPane().setBackground(new Color(255, 228, 235));

        JLabel lblNum1 = new JLabel("Número 1:");
        lblNum1.setBounds(30, 20, 100, 25);
        lblNum1.setForeground(new Color(199, 21, 133));
        getContentPane().add(lblNum1);

        txtNum1 = new JTextField();
        txtNum1.setBounds(120, 20, 150, 25);
        getContentPane().add(txtNum1);

        JLabel lblNum2 = new JLabel("Número 2:");
        lblNum2.setBounds(30, 60, 100, 25);
        lblNum2.setForeground(new Color(199, 21, 133));
        getContentPane().add(lblNum2);

        txtNum2 = new JTextField();
        txtNum2.setBounds(120, 60, 150, 25);
        getContentPane().add(txtNum2);

        JButton btnSomar = new JButton("Somar");
        btnSomar.setBounds(50, 100, 120, 25);
        getContentPane().add(btnSomar);

        JButton btnSubtrair = new JButton("Subtrair");
        btnSubtrair.setBounds(186, 100, 120, 25);
        getContentPane().add(btnSubtrair);

        JButton btnMultiplicar = new JButton("Multiplicar");
        btnMultiplicar.setBounds(50, 130, 120, 25);
        getContentPane().add(btnMultiplicar);

        JButton btnDividir = new JButton("Dividir");
        btnDividir.setBounds(186, 130, 120, 25);
        getContentPane().add(btnDividir);

        lblResultado = new JLabel("Resultado: ");
        lblResultado.setBounds(30, 170, 250, 25);
        lblResultado.setForeground(new Color(139, 0, 139));
        getContentPane().add(lblResultado);

        btnSomar.addActionListener(e -> calcular("+"));
        btnSubtrair.addActionListener(e -> calcular("-"));
        btnMultiplicar.addActionListener(e -> calcular("*"));
        btnDividir.addActionListener(e -> calcular("/"));
    }

    private void calcular(String operacao) {
        if (txtNum1.getText().isEmpty() || txtNum2.getText().isEmpty()) {
            JOptionPane.showMessageDialog(this, "Preencha todos os campos!");
            return;
        }

        try {
            double n1 = Double.parseDouble(txtNum1.getText());
            double n2 = Double.parseDouble(txtNum2.getText());
            double resultado = 0;

            switch (operacao) {
                case "+":
                    resultado = n1 + n2;
                    break;
                case "-":
                    resultado = n1 - n2;
                    break;
                case "*":
                    resultado = n1 * n2;
                    break;
                case "/":
                    if (n2 == 0) {
                        JOptionPane.showMessageDialog(this, "Não é possível dividir por zero!");
                        return;
                    }
                    resultado = n1 / n2;
                    break;
            }

            lblResultado.setText("Resultado: " + resultado);

        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(this, "Digite números válidos!");
        }
    }

    public static void main(String[] args) {
        Calculadora tela = new Calculadora();
        tela.setVisible(true);
    }
}