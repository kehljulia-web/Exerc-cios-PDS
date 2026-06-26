package imagens;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class TelaCadastroAdministrador extends JFrame {

    private JTextField campoNome, campoEmail;
    private JPasswordField campoSenha, campoConfirmarSenha;
    private JFormattedTextField campoDataNascimento;

    private DefaultListModel<String> listaAdministradoresModel;
    private JList<String> listaAdministradores;

    public TelaCadastroAdministrador() {

        setTitle("Cadastro de Administrador");
        setSize(900, 600);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        JPanel painelPrincipal = new JPanel(new BorderLayout());

        // painel principal
        JPanel painelCentral = new JPanel(new BorderLayout());

        // lado esquerdo do painel
        JPanel painelInformacoes = new JPanel();
        painelInformacoes.setBackground(new Color(221, 249, 255));
        painelInformacoes.setLayout(new BoxLayout(painelInformacoes, BoxLayout.Y_AXIS));

        JLabel titulo = new JLabel("Cadastre um administrador");
        titulo.setFont(new Font("Arial", Font.BOLD, 20));
        titulo.setAlignmentX(Component.CENTER_ALIGNMENT);

        JLabel subtitulo = new JLabel("e gerencie a plataforma com eficiência");
        subtitulo.setAlignmentX(Component.CENTER_ALIGNMENT);

        JLabel imagem = new JLabel(new ImageIcon(
                TelaCadastroAdministrador.class.getResource("/imagens/Group 5 (1).png")
        ));
        imagem.setAlignmentX(Component.CENTER_ALIGNMENT);

        painelInformacoes.add(Box.createVerticalGlue());
        painelInformacoes.add(titulo);
        painelInformacoes.add(Box.createRigidArea(new Dimension(0, 10)));
        painelInformacoes.add(subtitulo);
        painelInformacoes.add(Box.createRigidArea(new Dimension(0, 30)));
        painelInformacoes.add(imagem);
        painelInformacoes.add(Box.createVerticalGlue());

        // lado direito com formulario
        JPanel painelFormulario = new JPanel(new GridBagLayout());
        painelFormulario.setBackground(Color.WHITE);

        campoNome = new JTextField(15);
        campoEmail = new JTextField(15);
        campoSenha = new JPasswordField(15);
        campoConfirmarSenha = new JPasswordField(15);

        campoSenha.setEchoChar((char) 0);
        campoConfirmarSenha.setEchoChar((char) 0);

        try {
            campoDataNascimento = new JFormattedTextField(
                    new javax.swing.text.MaskFormatter("##/##/####"));
        } catch (Exception e) {}

        int linha = 0;
        Insets espacamento = new Insets(8, 8, 8, 8);

        painelFormulario.add(new JLabel("Nome completo"), criarLabel(0, linha, espacamento));
        painelFormulario.add(campoNome, criarCampo(1, linha++, espacamento));

        painelFormulario.add(new JLabel("E-mail"), criarLabel(0, linha, espacamento));
        painelFormulario.add(campoEmail, criarCampo(1, linha++, espacamento));

        painelFormulario.add(new JLabel("Senha"), criarLabel(0, linha, espacamento));
        painelFormulario.add(campoSenha, criarCampo(1, linha++, espacamento));

        painelFormulario.add(new JLabel("Confirmar senha"), criarLabel(0, linha, espacamento));
        painelFormulario.add(campoConfirmarSenha, criarCampo(1, linha++, espacamento));

        painelFormulario.add(new JLabel("Data de nascimento"), criarLabel(0, linha, espacamento));
        painelFormulario.add(campoDataNascimento, criarCampo(1, linha++, espacamento));

       // botao importado do figma
        JLabel botaoImagem = new JLabel(new ImageIcon(
                TelaCadastroAdministrador.class.getResource("/imagens/Group 4 (2).png")
        ));
        botaoImagem.setCursor(new Cursor(Cursor.HAND_CURSOR));

        botaoImagem.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent e) {
                cadastrarAdministrador();
            }
        });

        GridBagConstraints configBotao = new GridBagConstraints();
        configBotao.gridx = 0;
        configBotao.gridy = linha;
        configBotao.gridwidth = 2;
        configBotao.insets = new Insets(15, 8, 8, 8);

        painelFormulario.add(botaoImagem, configBotao);

        JSplitPane divisao = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT,
                painelInformacoes, painelFormulario);

        divisao.setResizeWeight(0.5); 
        divisao.setDividerSize(0); 

        painelCentral.add(divisao, BorderLayout.CENTER);

        listaAdministradoresModel = new DefaultListModel<>();
        listaAdministradores = new JList<>(listaAdministradoresModel);

        JScrollPane scroll = new JScrollPane(listaAdministradores);

        JButton botaoEditar = new JButton("Editar");
        JButton botaoExcluir = new JButton("Excluir");

        JPanel painelBotoes = new JPanel();
        painelBotoes.add(botaoEditar);
        painelBotoes.add(botaoExcluir);

        JPanel painelLista = new JPanel(new BorderLayout());
        painelLista.setBorder(BorderFactory.createTitledBorder("Administradores cadastrados"));
        painelLista.add(scroll, BorderLayout.CENTER);
        painelLista.add(painelBotoes, BorderLayout.SOUTH);

        painelPrincipal.add(painelCentral, BorderLayout.CENTER);
        painelPrincipal.add(painelLista, BorderLayout.SOUTH);

        add(painelPrincipal);

        // ações
        botaoEditar.addActionListener(e -> {
            int i = listaAdministradores.getSelectedIndex();
            if (i != -1) {
                String[] dados = listaAdministradoresModel.get(i).split(" \\| ");
                campoNome.setText(dados[0]);
                campoEmail.setText(dados[1]);
                campoDataNascimento.setText(dados[2]);
                listaAdministradoresModel.remove(i);
            }
        });

        botaoExcluir.addActionListener(e -> {
            int i = listaAdministradores.getSelectedIndex();
            if (i != -1) {
                listaAdministradoresModel.remove(i);
            }
        });
    }

    private GridBagConstraints criarLabel(int coluna, int linha, Insets espaco) {
        GridBagConstraints c = new GridBagConstraints();
        c.gridx = coluna;
        c.gridy = linha;
        c.insets = espaco;
        return c;
    }

    private GridBagConstraints criarCampo(int coluna, int linha, Insets espaco) {
        GridBagConstraints c = criarLabel(coluna, linha, espaco);
        c.fill = GridBagConstraints.HORIZONTAL;
        c.weightx = 1;
        return c;
    }

    private void cadastrarAdministrador() {

        String nome = campoNome.getText();
        String email = campoEmail.getText();
        String senha = new String(campoSenha.getPassword());
        String confirmar = new String(campoConfirmarSenha.getPassword());
        String data = campoDataNascimento.getText();

        if (nome.isEmpty() || email.isEmpty() || senha.isEmpty() || data.contains(" ")) {
            JOptionPane.showMessageDialog(this, "Preencha todos os campos!");
            return;
        }

        if (!senha.equals(confirmar)) {
            JOptionPane.showMessageDialog(this, "As senhas não coincidem!");
            return;
        }

        listaAdministradoresModel.addElement(nome + " | " + email + " | " + data);

        //  menagem de confirmação
        JOptionPane.showMessageDialog(this,
                "Administrador cadastrado com sucesso!\n\nNome: " + nome,
                "Sucesso",
                JOptionPane.INFORMATION_MESSAGE);

        campoNome.setText("");
        campoEmail.setText("");
        campoSenha.setText("");
        campoConfirmarSenha.setText("");
        campoDataNascimento.setText("");
    }

    public static void main(String[] args) {
        new TelaCadastroAdministrador().setVisible(true);
    }
}
       