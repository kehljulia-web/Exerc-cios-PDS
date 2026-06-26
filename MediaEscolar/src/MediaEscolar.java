import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class MediaEscolar extends JFrame {

    private JTextField txtNome, txtNota1, txtNota2;
    private JLabel lblResultado;

    public MediaEscolar() {
        setTitle("Média do Aluno");
        setSize(400, 280);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        getContentPane().setLayout(null);

        getContentPane().setBackground(new Color(25, 118, 210));

        JLabel lblNome = new JLabel("Nome:");
        lblNome.setBounds(40, 30, 100, 25);
        lblNome.setForeground(Color.WHITE);
        lblNome.setFont(new Font("Arial", Font.BOLD, 13));
        getContentPane().add(lblNome);

        txtNome = new JTextField();
        txtNome.setBounds(140, 30, 180, 25);
        getContentPane().add(txtNome);

      
        JLabel lblNota1 = new JLabel("Nota 1:");
        lblNota1.setBounds(40, 70, 100, 25);
        lblNota1.setForeground(Color.YELLOW);
        lblNota1.setFont(new Font("Arial", Font.BOLD, 13));
        getContentPane().add(lblNota1);

        txtNota1 = new JTextField();
        txtNota1.setBounds(140, 70, 180, 25);
        getContentPane().add(txtNota1);

      
        JLabel lblNota2 = new JLabel("Nota 2:");
        lblNota2.setBounds(40, 110, 100, 25);
        lblNota2.setForeground(Color.YELLOW);
        lblNota2.setFont(new Font("Arial", Font.BOLD, 13));
        getContentPane().add(lblNota2);

        txtNota2 = new JTextField();
        txtNota2.setBounds(140, 110, 180, 25);
        getContentPane().add(txtNota2);

        JButton btnCalcular = new JButton("Calcular Média");
        btnCalcular.setBounds(40, 159, 280, 30);
        btnCalcular.setBackground(new Color(255, 193, 7)); 
        btnCalcular.setForeground(Color.BLACK);
        btnCalcular.setFont(new Font("Arial", Font.BOLD, 12));
        btnCalcular.setFocusPainted(false);
        getContentPane().add(btnCalcular);

     
        lblResultado = new JLabel("Resultado: ");
        lblResultado.setBounds(40, 200, 320, 25);
        lblResultado.setForeground(Color.WHITE);
        lblResultado.setFont(new Font("Arial", Font.BOLD, 14));
        getContentPane().add(lblResultado);

      
        btnCalcular.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                try {
                    String nome = txtNome.getText();
                    double n1 = Double.parseDouble(txtNota1.getText());
                    double n2 = Double.parseDouble(txtNota2.getText());

                    double media = (n1 + n2) / 2;
                    String situacao;

                    if (media >= 7) {
                        situacao = "Aprovado";
                    } else {
                        situacao = "Reprovado";
                    }

                    lblResultado.setText("Aluno: " + nome +
                            " | Média: " + media +
                            " | Situação: " + situacao);

                } catch (NumberFormatException ex) {
                    JOptionPane.showMessageDialog(null, "Digite notas válidas!");
                }
            }
        });
    }

    public static void main(String[] args) {
        MediaEscolar tela = new MediaEscolar();
        tela.setVisible(true);
    }
}