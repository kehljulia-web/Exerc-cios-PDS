package view;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import net.miginfocom.swing.MigLayout;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import model.Pessoa;
import model.PessoaTableModel;

import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.awt.event.ActionEvent;

public class JanelaPessoa extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField txtNome;
	private JTextField txtCPF;
	private JTable table;
	
	private JButton btnAdicionar;
	private JButton btnRemover;
	private JButton btnVisualizar;
	private JTextField txtIdade;
	private JTextField txtEmail;
	private JLabel lblNewLabel_2;
	private JLabel lblNewLabel_3;

	public JanelaPessoa() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 556, 466);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new MigLayout("", "[31px][86px][23px][86px][32px][86px][28px][86px][77px][75px][77px][452px]", "[402px]"));
		
		JLabel lblNewLabel = new JLabel("Nome:");
		contentPane.add(lblNewLabel, "cell 0 0,alignx left,aligny center");
		
		txtNome = new JTextField();
		contentPane.add(txtNome, "cell 1 0,alignx left,aligny center");
		txtNome.setColumns(10);
		
		JLabel lblNewLabel_1 = new JLabel("CPF:");
		contentPane.add(lblNewLabel_1, "cell 2 0,alignx left,aligny center");
		
		txtCPF = new JTextField();
		contentPane.add(txtCPF, "cell 3 0,alignx left,aligny center");
		txtCPF.setColumns(10);
		
		lblNewLabel_2 = new JLabel("Idade:");
		contentPane.add(lblNewLabel_2, "cell 4 0,alignx left,aligny center");
		
		txtIdade = new JTextField();
		contentPane.add(txtIdade, "cell 5 0,alignx left,aligny center");
		txtIdade.setColumns(10);
		
		lblNewLabel_3 = new JLabel("Email:");
		contentPane.add(lblNewLabel_3, "cell 6 0,alignx left,aligny center");
		
		txtEmail = new JTextField();
		contentPane.add(txtEmail, "cell 7 0,alignx left,aligny center");
		txtEmail.setColumns(10);
		
		btnAdicionar = new JButton("Adicionar");
		
		contentPane.add(btnAdicionar, "cell 8 0,alignx left,aligny center");
		
		btnRemover = new JButton("Remover");
		
		contentPane.add(btnRemover, "cell 9 0,alignx left,aligny center");
		
		btnVisualizar = new JButton("Visualizar");
		
		contentPane.add(btnVisualizar, "cell 10 0,alignx left,aligny center");
		
		JScrollPane scrollPane = new JScrollPane();
		contentPane.add(scrollPane, "cell 11 0,alignx left,aligny top");
		
		table = new JTable();
		scrollPane.setViewportView(table);

	}

	public JTextField getTxtNome() {
		return txtNome;
	}

	public JTextField getTxtCPF() {
		return txtCPF;
	}

	public JTable getTable() {
		return table;
	}

	public JButton getBtnAdicionar() {
		return btnAdicionar;
	}

	public JButton getBtnRemover() {
		return btnRemover;
	}
	
	public JButton getBtnVisualizar() {
		return btnVisualizar;
	}
	
	public JTextField getTxtIdade() {
		return txtIdade;
	}

	public JTextField getTxtEmail() {
		return txtEmail;
	}
}
