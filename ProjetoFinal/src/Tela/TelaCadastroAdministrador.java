package Tela;

import javax.swing.*;
import java.awt.*;

import Classes.PainelInformacoes;
import Classes.PainelFormulario;

public class TelaCadastroAdministrador extends JFrame {

    private DefaultListModel<String> listaModel;
    private JList<String> lista;

    public TelaCadastroAdministrador() {

        setTitle("Cadastro de Administrador");
        setSize(900, 600);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        PainelInformacoes painelInfo = new PainelInformacoes();
        PainelFormulario painelForm = new PainelFormulario();

        JSplitPane split = new JSplitPane(
                JSplitPane.HORIZONTAL_SPLIT,
                painelInfo,
                painelForm
        );

        split.setDividerSize(0);

        listaModel = new DefaultListModel<>();
        lista = new JList<>(listaModel);

        JScrollPane scroll = new JScrollPane(lista);

        JButton editar = new JButton("Editar");
        JButton excluir = new JButton("Excluir");

        JPanel botoes = new JPanel();
        botoes.add(editar);
        botoes.add(excluir);

        JPanel listaPanel = new JPanel(new BorderLayout());
        listaPanel.setBorder(
                BorderFactory.createTitledBorder(
                        "Administradores cadastrados"
                )
        );

        listaPanel.add(scroll, BorderLayout.CENTER);
        listaPanel.add(botoes, BorderLayout.SOUTH);

        add(split, BorderLayout.CENTER);
        add(listaPanel, BorderLayout.SOUTH);

        painelForm.botaoImagem.addMouseListener(
                new java.awt.event.MouseAdapter() {

                    @Override
                    public void mouseClicked(
                            java.awt.event.MouseEvent e) {

                        String nome = painelForm.campoNome.getText();
                        String email = painelForm.campoEmail.getText();
                        String senha = painelForm.campoSenha.getText();
                        String confirmar = painelForm.campoConfirmarSenha.getText();
                        String data = painelForm.campoDataNascimento.getText();

                        boolean administrador =
                                painelForm.chkAdministrador.isSelected();

                        if (nome.isEmpty()
                                || email.isEmpty()
                                || senha.isEmpty()
                                || confirmar.isEmpty()
                                || data.isEmpty()) {

                            JOptionPane.showMessageDialog(
                                    null,
                                    "Preencha todos os campos!"
                            );
                            return;
                        }

                        if (!administrador) {
                            JOptionPane.showMessageDialog(
                                    null,
                                    "Você deve marcar a opção Administrador!"
                            );
                            return;
                        }

                        if (!senha.equals(confirmar)) {
                            JOptionPane.showMessageDialog(
                                    null,
                                    "As senhas não coincidem!"
                            );
                            return;
                        }

                        listaModel.addElement(
                                nome + " | "
                                        + email + " | "
                                        + data + " | Administrador: "
                                        + administrador
                        );

                        JOptionPane.showMessageDialog(
                                null,
                                "Administrador cadastrado com sucesso!"
                        );

                        painelForm.campoNome.setText("");
                        painelForm.campoEmail.setText("");
                        painelForm.campoSenha.setText("");
                        painelForm.campoConfirmarSenha.setText("");
                        painelForm.campoDataNascimento.setText("");
                        painelForm.chkAdministrador.setSelected(false);
                    }
                });

        // EDITAR
        editar.addActionListener(e -> {

            int i = lista.getSelectedIndex();

            if (i == -1) {
                JOptionPane.showMessageDialog(
                        null,
                        "Selecione um administrador para editar."
                );
                return;
            }

            String dados = listaModel.getElementAt(i);

            String[] partes = dados.split("\\|");

            painelForm.campoNome.setText(
                    partes[0].trim()
            );

            painelForm.campoEmail.setText(
                    partes[1].trim()
            );

            painelForm.campoDataNascimento.setText(
                    partes[2].trim()
            );

            if (partes.length > 3) {
                painelForm.chkAdministrador.setSelected(
                        partes[3].contains("true")
                );
            }

            listaModel.remove(i);

            JOptionPane.showMessageDialog(
                    null,
                    "Dados carregados para edição.\nAltere os campos e clique em cadastrar novamente."
            );
        });

        // EXCLUIR
        excluir.addActionListener(e -> {

            int i = lista.getSelectedIndex();

            if (i == -1) {
                JOptionPane.showMessageDialog(
                        null,
                        "Selecione um administrador para excluir."
                );
                return;
            }

            int resposta = JOptionPane.showConfirmDialog(
                    null,
                    "Deseja realmente excluir este administrador?",
                    "Confirmação",
                    JOptionPane.YES_NO_OPTION
            );

            if (resposta == JOptionPane.YES_OPTION) {
                listaModel.remove(i);

                JOptionPane.showMessageDialog(
                        null,
                        "Administrador excluído com sucesso!"
                );
            }
        });
    }

    public static void main(String[] args) {

        SwingUtilities.invokeLater(() ->
                new TelaCadastroAdministrador().setVisible(true)
        );
    }
}