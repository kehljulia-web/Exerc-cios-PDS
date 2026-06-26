
import javax.swing.*;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Academia extends JFrame {

    private JTextField txtNome;
    private JTextField txtTelefone;
    private JLabel lblResultado;

    private JComboBox<Plano> cbPlano;
    private JComboBox<Duracao> cbDuracao;
    private JComboBox<Frequencia> cbFrequencia;

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

        cbPlano = new JComboBox<>(Plano.values());
        cbPlano.setBounds(119, 135, 200, 22);
        getContentPane().add(cbPlano);

        JLabel lblDuracao = new JLabel("Duração:");
        lblDuracao.setBounds(20, 166, 100, 20);
        getContentPane().add(lblDuracao);

        cbDuracao = new JComboBox<>(Duracao.values());
        cbDuracao.setBounds(119, 166, 200, 22);
        getContentPane().add(cbDuracao);

        JLabel lblFreq = new JLabel("Frequência:");
        lblFreq.setBounds(20, 197, 100, 20);
        getContentPane().add(lblFreq);

        cbFrequencia = new JComboBox<>(Frequencia.values());
        cbFrequencia.setBounds(119, 197, 200, 22);
        getContentPane().add(cbFrequencia);

        JButton btnCalcular = new JButton("Calcular");
        btnCalcular.setBounds(20, 248, 120, 30);
        getContentPane().add(btnCalcular);

        lblResultado = new JLabel("Valor final: ");
        lblResultado.setBounds(182, 253, 250, 20);
        getContentPane().add(lblResultado);

        JLabel lblTitulo = new JLabel("Cadastro de cliente - Academia TREINO FIT");
        lblTitulo.setFont(new Font("Tahoma", Font.BOLD, 20));
        lblTitulo.setBounds(31, 11, 467, 33);
        getContentPane().add(lblTitulo);

        btnCalcular.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                calcular();
            }
        });
    }

    private void calcular() {

        if (txtNome.getText().isEmpty() ||
            txtTelefone.getText().isEmpty()) {

            JOptionPane.showMessageDialog(this,
                    "Preencha seu nome e telefone");
            return;
        }

        Plano plano = (Plano) cbPlano.getSelectedItem();
        Duracao duracao = (Duracao) cbDuracao.getSelectedItem();
        Frequencia frequencia =
                (Frequencia) cbFrequencia.getSelectedItem();

        double valor = PlanoAcademia.calcularValor(
                plano,
                duracao,
                frequencia
        );

        lblResultado.setText(
                "Valor final: R$ " +
                String.format("%.2f", valor)
        );
    }

    public static void main(String[] args) {
        new Academia().setVisible(true);
    }
}