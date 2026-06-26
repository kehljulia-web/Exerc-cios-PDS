package Classes;

import javax.swing.*;
import java.awt.*;
import net.miginfocom.swing.MigLayout;

public class PainelFormulario extends JPanel {

    public JTextField campoNome;
    public JTextField campoEmail;
    public JTextField campoSenha;
    public JTextField campoConfirmarSenha;
    public JFormattedTextField campoDataNascimento;

    public JCheckBox chkAdministrador;

    public JLabel botaoImagem;

    public PainelFormulario() {

        setBackground(Color.WHITE);

        setLayout(new MigLayout(
                "",
                "[200px][250px]",
                "[50px][50px][50px][50px][50px][50px][50px]"
        ));

        campoNome = new JTextField();
        campoEmail = new JTextField();
        campoSenha = new JTextField();
        campoConfirmarSenha = new JTextField();

        try {
            campoDataNascimento = new JFormattedTextField(
                    new javax.swing.text.MaskFormatter("##/##/####")
            );
        } catch (Exception e) {
            e.printStackTrace();
        }

        chkAdministrador = new JCheckBox("É administrador?");

        add(new JLabel("Nome completo"), "cell 0 0");
        add(campoNome, "cell 1 0,growx");

        add(new JLabel("E-mail"), "cell 0 1");
        add(campoEmail, "cell 1 1,growx");

        add(new JLabel("Senha"), "cell 0 2");
        add(campoSenha, "cell 1 2,growx");

        add(new JLabel("Confirmar senha"), "cell 0 3");
        add(campoConfirmarSenha, "cell 1 3,growx");

        add(new JLabel("Data de nascimento"), "cell 0 4");
        add(campoDataNascimento, "cell 1 4,growx");

        add(new JLabel("Administrador"), "cell 0 5");
        add(chkAdministrador, "cell 1 5");

        botaoImagem = new JLabel(
                new ImageIcon(
                        getClass().getResource("/imagens/Group 4 (2).png")
                )
        );

        botaoImagem.setCursor(
                new Cursor(Cursor.HAND_CURSOR)
        );

        add(new JLabel(""), "cell 0 6");
        add(botaoImagem, "cell 1 6");
    }
}