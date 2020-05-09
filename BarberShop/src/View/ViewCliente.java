package View;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.text.DefaultFormatterFactory;
import javax.swing.text.MaskFormatter;

import Controllers.ControllerFormCadastroCliente;
import Model.Bean.Endereco;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.ImageIcon;
import java.awt.Color;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.SwingConstants;
import java.awt.event.ActionListener;
import java.text.ParseException;
import java.awt.event.ActionEvent;
import java.awt.Cursor;
import javax.swing.JFormattedTextField;

public class ViewCliente extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField txtNome;
	private JTextField txtRG;
	private JTextField txtCPF;
	private JTextField txtEmail;
	private JFormattedTextField txtData;
	private JFormattedTextField txtTelefone;
	private ViewEndereco viewEndereco;
	private Endereco endereco;
	private ControllerFormCadastroCliente controller;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ViewCliente frame = new ViewCliente();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public ViewCliente() {
		this.controller = new ControllerFormCadastroCliente(this);
		this.endereco = new Endereco();
		this.viewEndereco = new ViewEndereco();
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 708, 438);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		txtNome = new JTextField();
		txtNome.setForeground(new Color(178, 34, 34));
		txtNome.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		txtNome.setBorder(new EmptyBorder(0, 5, 0, 0));
		txtNome.setBounds(109, 34, 324, 26);
		contentPane.add(txtNome);
		txtNome.setColumns(10);
		
		txtRG = new JTextField();
		txtRG.setForeground(new Color(178, 34, 34));
		txtRG.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		txtRG.setColumns(10);
		txtRG.setBorder(new EmptyBorder(0, 5, 0, 0));
		txtRG.setBounds(81, 73, 324, 26);
		contentPane.add(txtRG);
		
		txtCPF = new JTextField();
		txtCPF.setForeground(new Color(178, 34, 34));
		txtCPF.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		txtCPF.setColumns(10);
		txtCPF.setBorder(new EmptyBorder(0, 5, 0, 0));
		txtCPF.setBounds(88, 123, 317, 26);
		contentPane.add(txtCPF);
		
		txtEmail = new JTextField();
		txtEmail.setForeground(new Color(178, 34, 34));
		txtEmail.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		txtEmail.setColumns(10);
		txtEmail.setBorder(new EmptyBorder(0, 5, 0, 0));
		txtEmail.setBounds(96, 171, 324, 26);
		contentPane.add(txtEmail);
		
		JButton btCadastrarCliente = new JButton("Cadastrar ");
		btCadastrarCliente.setRequestFocusEnabled(false);
		btCadastrarCliente.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btCadastrarCliente.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				endereco = viewEndereco.getEndereco();
				controller.cadastrarCliente(endereco);
				dispose(); 
			}
		});
		
		txtData = new JFormattedTextField();
		txtData.setForeground(new Color(178, 34, 34));
		txtData.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		txtData.setBorder(new EmptyBorder(0, 5, 0, 0));
		txtData.setBounds(213, 266, 84, 26);	
		try {
			txtData.setFormatterFactory(new DefaultFormatterFactory(new MaskFormatter("##/##/####")));
		} catch (ParseException e) {
			JOptionPane.showMessageDialog(null, "Digite a data corretamente!");
		}
		contentPane.add(txtData);
		
		txtTelefone = new JFormattedTextField();
		txtTelefone.setForeground(new Color(178, 34, 34));
		txtTelefone.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		txtTelefone.setBorder(new EmptyBorder(0, 5, 0, 0));
		txtTelefone.setBounds(123, 217, 226, 26);
		try {
			txtTelefone.setFormatterFactory(new DefaultFormatterFactory(new MaskFormatter("(##)#####-####")));
		} catch (ParseException e) {
			JOptionPane.showMessageDialog(null, "Digite o telefone corretamente!");
		}
		contentPane.add(txtTelefone);
		btCadastrarCliente.setHorizontalTextPosition(SwingConstants.CENTER);
		btCadastrarCliente.setForeground(new Color(255, 255, 255));
		btCadastrarCliente.setFont(new Font("Segoe UI", Font.PLAIN, 18));
		btCadastrarCliente.setBorderPainted(false);
		btCadastrarCliente.setBorder(null);
		btCadastrarCliente.setBackground(new Color(178, 34, 34));
		btCadastrarCliente.setBounds(364, 323, 269, 37);
		contentPane.add(btCadastrarCliente);
		
		JButton btPreencherEndereco = new JButton("Preencher Endereco");
		btPreencherEndereco.setRequestFocusEnabled(false);
		btPreencherEndereco.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btPreencherEndereco.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				viewEndereco.setVisible(true);
			}
		});
		btPreencherEndereco.setHorizontalTextPosition(SwingConstants.CENTER);
		btPreencherEndereco.setForeground(Color.WHITE);
		btPreencherEndereco.setFont(new Font("Segoe UI", Font.PLAIN, 18));
		btPreencherEndereco.setBorderPainted(false);
		btPreencherEndereco.setBorder(null);
		btPreencherEndereco.setBackground(new Color(178, 34, 34));
		btPreencherEndereco.setBounds(42, 323, 269, 37);
		contentPane.add(btPreencherEndereco);
		
		JLabel lbNome = new JLabel("Nome:");
		lbNome.setForeground(new Color(255, 255, 255));
		lbNome.setFont(new Font("Segoe UI", Font.PLAIN, 18));
		lbNome.setBounds(39, 34, 60, 19);
		contentPane.add(lbNome);
		
		JLabel lbRG = new JLabel("RG:");
		lbRG.setForeground(new Color(255, 255, 255));
		lbRG.setFont(new Font("Segoe UI", Font.PLAIN, 18));
		lbRG.setBounds(39, 73, 60, 19);
		contentPane.add(lbRG);
		
		JLabel lbCPF = new JLabel("CPF:");
		lbCPF.setForeground(new Color(255, 255, 255));
		lbCPF.setFont(new Font("Segoe UI", Font.PLAIN, 18));
		lbCPF.setBounds(39, 123, 46, 19);
		contentPane.add(lbCPF);
		
		JLabel lbEmail = new JLabel("Email:");
		lbEmail.setForeground(new Color(255, 255, 255));
		lbEmail.setFont(new Font("Segoe UI", Font.PLAIN, 18));
		lbEmail.setBounds(39, 171, 60, 19);
		contentPane.add(lbEmail);
		
		JLabel lbTelefone = new JLabel("Telefone:");
		lbTelefone.setForeground(new Color(255, 255, 255));
		lbTelefone.setFont(new Font("Segoe UI", Font.PLAIN, 18));
		lbTelefone.setBounds(39, 217, 79, 19);
		contentPane.add(lbTelefone);
		
		JLabel lbDataNascimento = new JLabel("Data de Nascimento:");
		lbDataNascimento.setForeground(new Color(255, 255, 255));
		lbDataNascimento.setFont(new Font("Segoe UI", Font.PLAIN, 18));
		lbDataNascimento.setBounds(39, 266, 176, 19);
		contentPane.add(lbDataNascimento);
		
		JLabel label = new JLabel("");
		label.setIcon(new ImageIcon(ViewCliente.class.getResource("/Imagens/TelaLogin.jpg")));
		label.setBounds(0, 0, 692, 399);
		contentPane.add(label);
	}

	public JTextField getTxtNome() {
		return txtNome;
	}

	public void setTxtNome(JTextField txtNome) {
		this.txtNome = txtNome;
	}

	public JTextField getTxtRG() {
		return txtRG;
	}

	public void setTxtRG(JTextField txtRG) {
		this.txtRG = txtRG;
	}

	public JTextField getTxtCPF() {
		return txtCPF;
	}

	public void setTxtCPF(JTextField txtCPF) {
		this.txtCPF = txtCPF;
	}

	public JTextField getTxtEmail() {
		return txtEmail;
	}

	public void setTxtEmail(JTextField txtEmail) {
		this.txtEmail = txtEmail;
	}

	public Endereco getEndereco() {
		return endereco;
	}

	public void setEndereco(Endereco endereco) {
		this.endereco = endereco;
	}

	public JFormattedTextField getTxtData() {
		return txtData;
	}

	public void setTxtData(JFormattedTextField txtData) {
		this.txtData = txtData;
	}

	public JFormattedTextField getTxtTelefone() {
		return txtTelefone;
	}

	public void setTxtTelefone(JFormattedTextField txtTelefone) {
		this.txtTelefone = txtTelefone;
	}
	
}
