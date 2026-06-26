
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.Font;

public class Academia extends JFrame {

    private JTextField txtNome;
    private JTextField txtTelefone;
    private JLabel lblResultado;

    private JRadioButton rbBasico, rbIntermediario, rbPremium;
    private JRadioButton rbMensal, rbSemestral, rbAnual;
    private JRadioButton rb2x, rb3x, rb5x;

    public Academia() {
        setSize(500, 350);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        getContentPane().setLayout(null);

        JLabel lblNome = new JLabel("Nome:");
        lblNome.setBounds(20, 55, 100, 20);
        getContentPane().add(lblNome);

        txtNome = new JTextField();
        txtNome.setBounds(89, 55, 331, 20);
        getContentPane().add(txtNome);

        JLabel lblTelefone = new JLabel("Telefone:");
        lblTelefone.setBounds(20, 86, 100, 20);
        getContentPane().add(lblTelefone);

        txtTelefone = new JTextField();
        txtTelefone.setBounds(89, 86, 331, 20);
        getContentPane().add(txtTelefone);

        JLabel lblPlano = new JLabel("Plano:");
        lblPlano.setBounds(20, 135, 100, 20);
        getContentPane().add(lblPlano);

        rbBasico = new JRadioButton("Básico");
        rbIntermediario = new JRadioButton("Intermediário");
        rbPremium = new JRadioButton("Premium");

        rbBasico.setBounds(119, 135, 71, 20);
        rbIntermediario.setBounds(203, 135, 115, 20);
        rbPremium.setBounds(320, 135, 100, 20);

        ButtonGroup grupoPlano = new ButtonGroup();
        grupoPlano.add(rbBasico);
        grupoPlano.add(rbIntermediario);
        grupoPlano.add(rbPremium);

        getContentPane().add(rbBasico);
        getContentPane().add(rbIntermediario);
        getContentPane().add(rbPremium);

        JLabel lblDuracao = new JLabel("Duração:");
        lblDuracao.setBounds(20, 166, 100, 20);
        getContentPane().add(lblDuracao);

        rbMensal = new JRadioButton("Mensal");
        rbSemestral = new JRadioButton("Semestral");
        rbAnual = new JRadioButton("Anual");

        rbMensal.setBounds(119, 166, 71, 20);
        rbSemestral.setBounds(203, 166, 115, 20);
        rbAnual.setBounds(320, 166, 100, 20);

        ButtonGroup grupoDuracao = new ButtonGroup();
        grupoDuracao.add(rbMensal);
        grupoDuracao.add(rbSemestral);
        grupoDuracao.add(rbAnual);

        getContentPane().add(rbMensal);
        getContentPane().add(rbSemestral);
        getContentPane().add(rbAnual);

        JLabel lblFreq = new JLabel("Frequência:");
        lblFreq.setBounds(20, 197, 100, 20);
        getContentPane().add(lblFreq);

        rb2x = new JRadioButton("2x");
        rb3x = new JRadioButton("3x");
        rb5x = new JRadioButton("5x");

        rb2x.setBounds(119, 197, 60, 20);
        rb3x.setBounds(203, 197, 60, 20);
        rb5x.setBounds(320, 197, 60, 20);

        ButtonGroup grupoFreq = new ButtonGroup();
        grupoFreq.add(rb2x);
        grupoFreq.add(rb3x);
        grupoFreq.add(rb5x);

        getContentPane().add(rb2x);
        getContentPane().add(rb3x);
        getContentPane().add(rb5x);

        JButton btnCalcular = new JButton("Calcular");
        btnCalcular.setBounds(20, 248, 120, 30);
        getContentPane().add(btnCalcular);

        lblResultado = new JLabel("Valor final: ");
        lblResultado.setBounds(182, 253, 250, 20);
        getContentPane().add(lblResultado);
        
        JLabel lblNewLabel = new JLabel("Cadastro de cliente - Academia TREINO FIT");
        lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 20));
        lblNewLabel.setBounds(31, 11, 467, 33);
        getContentPane().add(lblNewLabel);

        btnCalcular.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                calcular();
            }
        });
    }

    private void calcular() {

        if (txtNome.getText().isEmpty() || txtTelefone.getText().isEmpty()) {
            JOptionPane.showMessageDialog(this, "Preencha seu nome e telefone");
            return;
        }

        String plano = null;
        if (rbBasico.isSelected()) plano = "Básico";
        if (rbIntermediario.isSelected()) plano = "Intermediário";
        if (rbPremium.isSelected()) plano = "Premium";

        String duracao = null;
        if (rbMensal.isSelected()) duracao = "Mensal";
        if (rbSemestral.isSelected()) duracao = "Semestral";
        if (rbAnual.isSelected()) duracao = "Anual";

        String frequencia = null;
        if (rb2x.isSelected()) frequencia = "2x";
        if (rb3x.isSelected()) frequencia = "3x";
        if (rb5x.isSelected()) frequencia = "5x";

        if (plano == null || duracao == null || frequencia == null) {
            JOptionPane.showMessageDialog(this, "Selecione todas as opções!");
            return;
        }

        double valor = PlanoAcademia.calcularValor(plano, duracao, frequencia);
        lblResultado.setText("Valor final: R$ " + String.format("%.2f", valor));
    }

    public static void main(String[] args) {
        new Academia().setVisible(true);
    }
}