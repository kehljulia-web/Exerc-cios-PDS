package Classes;

import javax.swing.*;
import java.awt.*;

public class PainelInformacoes extends JPanel {

    public PainelInformacoes() {

        setBackground(new Color(221, 249, 255));
        setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));

        JLabel titulo = new JLabel("Cadastre um administrador");
        titulo.setForeground(new Color(12, 104, 120));
        titulo.setFont(new Font("Arial", Font.BOLD, 20));
        titulo.setAlignmentX(Component.CENTER_ALIGNMENT);

        JLabel subtitulo =
                new JLabel("e gerencie a plataforma com eficiência");
        subtitulo.setFont(new Font("Arial", Font.PLAIN, 11));
        subtitulo.setForeground(new Color(110, 134, 139));

        subtitulo.setAlignmentX(Component.CENTER_ALIGNMENT);

        JLabel imagem = new JLabel(
                new ImageIcon(
                        getClass().getResource("/imagens/Group 5 (1).png")
                )
        );

        imagem.setAlignmentX(Component.CENTER_ALIGNMENT);

        add(Box.createVerticalGlue());
        add(titulo);
        add(Box.createRigidArea(new Dimension(0,10)));
        add(subtitulo);
        add(Box.createRigidArea(new Dimension(0,30)));
        add(imagem);
        add(Box.createVerticalGlue());
    }
}