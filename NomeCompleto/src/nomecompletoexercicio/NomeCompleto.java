package nomecompletoexercicio;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class NomeCompleto extends JFrame {

    private JTextField txtNome, txtSobrenome;
    private JLabel lblResultado;

    public NomeCompleto() {
        setTitle("Gerador de Nome Completo");
        setSize(400, 250);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null); 
        getContentPane().setLayout(null);

        getContentPane().setBackground(new Color(30, 30, 60));

        JLabel lblNome = new JLabel("Nome:");
        lblNome.setBounds(30, 30, 100, 25);
        lblNome.setForeground(Color.WHITE);
        getContentPane().add(lblNome);

        txtNome = new JTextField();
        txtNome.setBounds(120, 30, 200, 25);
        txtNome.setBackground(new Color(255, 255, 255));
        getContentPane().add(txtNome);

        JLabel lblSobrenome = new JLabel("Sobrenome:");
        lblSobrenome.setBounds(30, 70, 100, 25);
        lblSobrenome.setForeground(Color.WHITE);
        getContentPane().add(lblSobrenome);

        txtSobrenome = new JTextField();
        txtSobrenome.setBounds(120, 70, 200, 25);
        txtSobrenome.setBackground(new Color(255, 255, 255));
        getContentPane().add(txtSobrenome);

        JButton btnMostrar = new JButton("Mostrar Nome Completo");
        btnMostrar.setBounds(120, 120, 199, 30);
        btnMostrar.setBackground(new Color(100, 149, 237));
        btnMostrar.setForeground(new Color(0, 0, 0));
        btnMostrar.setFocusPainted(false);
        getContentPane().add(btnMostrar);

        
        lblResultado = new JLabel("Seu nome aparecerá aqui");
        lblResultado.setBounds(130, 161, 300, 25);
        lblResultado.setForeground(Color.YELLOW);
        lblResultado.setFont(new Font("Arial", Font.BOLD, 14));
        getContentPane().add(lblResultado);

        btnMostrar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String nome = txtNome.getText();
                String sobrenome = txtSobrenome.getText();

                String completo = nome + " " + sobrenome;
                lblResultado.setText("Oi " + completo + "!");
            }
        });
    }

    public static void main(String[] args) {
        NomeCompleto tela = new NomeCompleto();
        tela.setVisible(true);
    }
}