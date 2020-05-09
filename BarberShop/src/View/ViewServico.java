package View;


import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import Controllers.ControllerFormCadastroServico;

import javax.swing.JLabel;
import javax.swing.ImageIcon;
import java.awt.Font;
import java.awt.Color;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.SwingConstants;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class ViewServico extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField txtDescricao;
	private JTextField txtValor;
	private ControllerFormCadastroServico controller;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ViewServico frame = new ViewServico();
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
	public ViewServico() {
		this.controller = new ControllerFormCadastroServico(this);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 517, 312);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btCadastrarServico = new JButton("Cadastrar Servi\u00E7o");
		btCadastrarServico.setRequestFocusEnabled(false);
		btCadastrarServico.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				controller.cadastrarServico();
				dispose();
			}
		});
		btCadastrarServico.setHorizontalTextPosition(SwingConstants.CENTER);
		btCadastrarServico.setForeground(Color.WHITE);
		btCadastrarServico.setFont(new Font("Segoe UI", Font.PLAIN, 18));
		btCadastrarServico.setBorderPainted(false);
		btCadastrarServico.setBorder(null);
		btCadastrarServico.setBackground(new Color(178, 34, 34));
		btCadastrarServico.setBounds(36, 161, 201, 37);
		contentPane.add(btCadastrarServico);
		
		JButton btCancelar = new JButton("Cancelar");
		btCancelar.setRequestFocusEnabled(false);
		btCancelar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				dispose();
			}
		});
		btCancelar.setHorizontalTextPosition(SwingConstants.CENTER);
		btCancelar.setForeground(Color.WHITE);
		btCancelar.setFont(new Font("Segoe UI", Font.PLAIN, 18));
		btCancelar.setBorderPainted(false);
		btCancelar.setBorder(null);
		btCancelar.setBackground(new Color(178, 34, 34));
		btCancelar.setBounds(284, 161, 172, 37);
		contentPane.add(btCancelar);
		
		JLabel lbDescricao = new JLabel("Descricao:");
		lbDescricao.setForeground(Color.WHITE);
		lbDescricao.setFont(new Font("Segoe UI", Font.PLAIN, 18));
		lbDescricao.setBounds(36, 42, 85, 19);
		contentPane.add(lbDescricao);
		
		txtDescricao = new JTextField();
		txtDescricao.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		txtDescricao.setColumns(10);
		txtDescricao.setBorder(new EmptyBorder(0, 5, 0, 0));
		txtDescricao.setBounds(132, 40, 324, 26);
		contentPane.add(txtDescricao);
		
		JLabel lbValor = new JLabel("Valor:");
		lbValor.setForeground(Color.WHITE);
		lbValor.setFont(new Font("Segoe UI", Font.PLAIN, 18));
		lbValor.setBounds(36, 81, 60, 19);
		contentPane.add(lbValor);
		
		txtValor = new JTextField();
		txtValor.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		txtValor.setColumns(10);
		txtValor.setBorder(new EmptyBorder(0, 5, 0, 0));
		txtValor.setBounds(95, 79, 324, 26);
		contentPane.add(txtValor);
		
		JLabel lbFundo = new JLabel("");
		lbFundo.setIcon(new ImageIcon(ViewServico.class.getResource("/Imagens/TelaLogin.jpg")));
		lbFundo.setBounds(0, 0, 568, 342);
		contentPane.add(lbFundo);
	}

	public JTextField getTxtDescricao() {
		return txtDescricao;
	}

	public void setTxtDescricao(JTextField txtDescricao) {
		this.txtDescricao = txtDescricao;
	}

	public JTextField getTxtValor() {
		return txtValor;
	}

	public void setTxtValor(JTextField txtValor) {
		this.txtValor = txtValor;
	}
	
}
