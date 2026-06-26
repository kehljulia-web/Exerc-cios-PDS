import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

public class RetanguloTela extends JFrame {

    JLabel lblBase = new JLabel("Base:");
    JTextField txtBase = new JTextField(10);

    JLabel lblAltura = new JLabel("Altura:");
    JTextField txtAltura = new JTextField(10);

    JButton btnCalcular = new JButton("Calcular");

    JLabel lblArea = new JLabel("Área: ");
    JLabel lblPerimetro = new JLabel("Perímetro: ");

    public RetanguloTela() {

        setTitle("Cálculo do Retângulo");
        setSize(300,220);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        getContentPane().setLayout(null);
        lblBase.setBounds(10, 28, 27, 14);

        getContentPane().add(lblBase);
        txtBase.setBounds(49, 25, 86, 20);
        getContentPane().add(txtBase);
        lblAltura.setBounds(10, 84, 33, 14);

        getContentPane().add(lblAltura);
        txtAltura.setBounds(49, 81, 86, 20);
        getContentPane().add(txtAltura);
        btnCalcular.setBounds(161, 128, 71, 23);

        getContentPane().add(btnCalcular);
        lblArea.setBounds(333, 9, 30, 14);

        getContentPane().add(lblArea);
        lblPerimetro.setBounds(368, 9, 53, 14);
        getContentPane().add(lblPerimetro);

        btnCalcular.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {

                double base = Double.parseDouble(txtBase.getText());
                double altura = Double.parseDouble(txtAltura.getText());

                Retangulo r = new Retangulo(base, altura);

                lblArea.setText("Área: " + r.calcularArea());

                lblPerimetro.setText("Perímetro: " + r.calcularPerimetro());

            }

        });

        setVisible(true);

    }

    public static void main(String[] args) {

        new RetanguloTela();

    }

}