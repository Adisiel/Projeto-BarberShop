package view;


import java.awt.Color;
import java.awt.Cursor;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import controller.ControllerFormCadastroEndereco;
import model.bean.Endereco;

public class ViewEndereco extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField txtCidade;
	private JTextField txtBairro;
	private JTextField txtRua;
	private JTextField txtComplemento;
	private JTextField txtNumero;
	private ControllerFormCadastroEndereco controller;
	private Endereco endereco;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ViewEndereco frame = new ViewEndereco();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 * @param end 
	 */
	public ViewEndereco() {
		this.endereco = new Endereco();
		this.controller = new ControllerFormCadastroEndereco(this);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 566, 368);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lbBairro = new JLabel("Bairro:");
		lbBairro.setForeground(Color.WHITE);
		lbBairro.setBackground(Color.WHITE);
		lbBairro.setFont(new Font("Segoe UI", Font.PLAIN, 18));
		lbBairro.setBounds(56, 70, 67, 23);
		contentPane.add(lbBairro);
		
		JLabel lblRua = new JLabel("Rua:");
		lblRua.setForeground(Color.WHITE);
		lblRua.setBackground(Color.WHITE);
		lblRua.setFont(new Font("Segoe UI", Font.PLAIN, 18));
		lblRua.setBounds(56, 115, 53, 23);
		contentPane.add(lblRua);
		
		JLabel lblNumero = new JLabel("N\u00FAmero:");
		lblNumero.setForeground(Color.WHITE);
		lblNumero.setBackground(Color.WHITE);
		lblNumero.setFont(new Font("Segoe UI", Font.PLAIN, 18));
		lblNumero.setBounds(56, 203, 87, 23);
		contentPane.add(lblNumero);
		
		JLabel lblComplemento = new JLabel("Complemento:");
		lblComplemento.setForeground(Color.WHITE);
		lblComplemento.setBackground(Color.WHITE);
		lblComplemento.setFont(new Font("Segoe UI", Font.PLAIN, 18));
		lblComplemento.setBounds(55, 157, 135, 23);
		contentPane.add(lblComplemento);
		
		JLabel lblCidade = new JLabel("Cidade:");
		lblCidade.setForeground(Color.WHITE);
		lblCidade.setBackground(Color.WHITE);
		lblCidade.setFont(new Font("Segoe UI", Font.PLAIN, 18));
		lblCidade.setBounds(56, 27, 134, 32);
		contentPane.add(lblCidade);
		
		txtCidade = new JTextField();
		txtCidade.setForeground(new Color(178, 34, 34));
		txtCidade.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		txtCidade.setBorder(new EmptyBorder(0, 5, 0, 0));
		txtCidade.setBounds(134, 34, 239, 23);
		contentPane.add(txtCidade);
		txtCidade.setColumns(10);
		
		txtBairro = new JTextField();
		txtBairro.setForeground(new Color(178, 34, 34));
		txtBairro.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		txtBairro.setBorder(new EmptyBorder(0, 5, 0, 0));
		txtBairro.setColumns(10);
		txtBairro.setBounds(117, 73, 234, 23);
		contentPane.add(txtBairro);
		
		txtRua = new JTextField();
		txtRua.setForeground(new Color(178, 34, 34));
		txtRua.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		txtRua.setBorder(new EmptyBorder(0, 5, 0, 0));
		txtRua.setColumns(10);
		txtRua.setBounds(101, 117, 249, 23);
		contentPane.add(txtRua);
		
		txtComplemento = new JTextField();
		txtComplemento.setForeground(new Color(178, 34, 34));
		txtComplemento.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		txtComplemento.setBorder(new EmptyBorder(0, 5, 0, 0));
		txtComplemento.setColumns(10);
		txtComplemento.setBounds(186, 159, 342, 23);
		contentPane.add(txtComplemento);
		
		txtNumero = new JTextField();
		txtNumero.setForeground(new Color(178, 34, 34));
		txtNumero.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		txtNumero.setBorder(new EmptyBorder(0, 5, 0, 0));
		txtNumero.setColumns(10);
		txtNumero.setBounds(140, 205, 76, 23);
		contentPane.add(txtNumero);
		
		JButton btCadastrarEndereco = new JButton("Cadastrar Endere\u00E7o");
		btCadastrarEndereco.setRequestFocusEnabled(false);
		btCadastrarEndereco.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btCadastrarEndereco.setForeground(new Color(255, 255, 255));
		btCadastrarEndereco.setBackground(new Color(178, 34, 34));
		btCadastrarEndereco.setFont(new Font("Segoe UI", Font.PLAIN, 16));
		btCadastrarEndereco.setBorder(null);

		btCadastrarEndereco.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				endereco = controller.cadastrarEndereco();
			}
			
		});
		btCadastrarEndereco.setBounds(66, 269, 200, 32);
		contentPane.add(btCadastrarEndereco);
		
		JButton btCancelar = new JButton("Cancelar");
		btCancelar.setRequestFocusEnabled(false);
		btCancelar.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btCancelar.setForeground(new Color(255, 255, 255));
		btCancelar.setBackground(new Color(178, 34, 34));
		btCancelar.setFont(new Font("Segoe UI", Font.PLAIN, 16));
		btCancelar.setBorder(null);
		btCancelar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		btCancelar.setBounds(313, 269, 175, 32);
		contentPane.add(btCancelar);
		
		JLabel lbFundo = new JLabel("");
		lbFundo.setIcon(new ImageIcon(ViewEndereco.class.getResource("/Imagens/TelaLogin.jpg")));
		lbFundo.setBounds(0, 0, 550, 329);
		contentPane.add(lbFundo);
	}

	public JTextField getTxtCidade() {
		return txtCidade;
	}

	public void setTxtCidade(JTextField txtCidade) {
		this.txtCidade = txtCidade;
	}

	public JTextField getTxtBairro() {
		return txtBairro;
	}

	public void setTxtBairro(JTextField txtBairro) {
		this.txtBairro = txtBairro;
	}

	public JTextField getTxtRua() {
		return txtRua;
	}

	public void setTxtRua(JTextField txtRua) {
		this.txtRua = txtRua;
	}

	public JTextField getTxtComplemento() {
		return txtComplemento;
	}

	public void setTxtComplemento(JTextField txtComplemento) {
		this.txtComplemento = txtComplemento;
	}

	public JTextField getTxtNumero() {
		return txtNumero;
	}

	public void setTxtNumero(JTextField txtNumero) {
		this.txtNumero = txtNumero;
	}

	public Endereco getEndereco() {
		return endereco;
	}

	public void setEndereco(Endereco endereco) {
		this.endereco = endereco;
	}
}
