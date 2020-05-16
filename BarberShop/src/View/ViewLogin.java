package view;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import controller.ControllerFormLogin;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.ImageIcon;
import java.awt.Color;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.JPasswordField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Cursor;

public class ViewLogin extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField textUsuario;
	private JPasswordField textSenha;
	private ControllerFormLogin controller;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ViewLogin frame = new ViewLogin();
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
	public ViewLogin() {
		controller = new ControllerFormLogin(this);
		setAutoRequestFocus(false);
		setLocationByPlatform(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 706, 525);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		textUsuario = new JTextField();
		textUsuario.setForeground(new Color(178, 34, 34));
		textUsuario.setBorder(null);
		textUsuario.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		textUsuario.setHorizontalAlignment(SwingConstants.CENTER);
		textUsuario.setBounds(240, 208, 240, 31);
		contentPane.add(textUsuario);
		textUsuario.setColumns(10);
		
		textSenha = new JPasswordField();
		textSenha.setForeground(new Color(178, 34, 34));
		textSenha.setBorder(null);
		textSenha.setHorizontalAlignment(SwingConstants.CENTER);
		textSenha.setBounds(240, 307, 240, 31);
		contentPane.add(textSenha);
		
		JLabel lblBemVindo = new JLabel("Bem Vindo ao Sistema BarberShop");
		lblBemVindo.setBackground(new Color(178, 34, 34));
		lblBemVindo.setHorizontalTextPosition(SwingConstants.CENTER);
		lblBemVindo.setHorizontalAlignment(SwingConstants.CENTER);
		lblBemVindo.setForeground(new Color(255, 255, 255));
		lblBemVindo.setFont(new Font("Franklin Gothic Demi", Font.BOLD, 33));
		lblBemVindo.setBounds(52, 34, 593, 82);
		contentPane.add(lblBemVindo);
		
		JLabel lbUsuario = new JLabel("Usu\u00E1rio");
		lbUsuario.setForeground(Color.WHITE);
		lbUsuario.setFont(new Font("Segoe UI", Font.PLAIN, 22));
		lbUsuario.setBounds(316, 162, 101, 24);
		contentPane.add(lbUsuario);
		
		JLabel lbSenha = new JLabel("Senha");
		lbSenha.setForeground(Color.WHITE);
		lbSenha.setFont(new Font("Segoe UI", Font.PLAIN, 22));
		lbSenha.setBounds(323, 272, 71, 24);
		contentPane.add(lbSenha);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(178, 34, 34));
		panel.setBounds(52, 34, 593, 82);
		contentPane.add(panel);
		
		JButton btLogin = new JButton("Login");
		btLogin.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btLogin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				boolean autenticado = controller.autenticacao();
				if (autenticado) {
					new ViewMenuPrincipal().setVisible(true);
					dispose();
				} else {
					JOptionPane.showMessageDialog(null, "Senha ou Usuário errado!");
				}
			}
		});
		btLogin.setForeground(new Color(224, 255, 255));
		btLogin.setFont(new Font("Segoe UI Symbol", Font.PLAIN, 15));
		btLogin.setFocusPainted(false);
		btLogin.setBorderPainted(false);
		btLogin.setBorder(null);
		btLogin.setBackground(new Color(178, 34, 34));
		btLogin.setBounds(250, 392, 218, 42);
		contentPane.add(btLogin);
		
		JLabel lbFundo = new JLabel("");
		lbFundo.setBorder(new EmptyBorder(1, 0, 0, 0));
		lbFundo.setHorizontalTextPosition(SwingConstants.CENTER);
		lbFundo.setHorizontalAlignment(SwingConstants.CENTER);
		lbFundo.setOpaque(true);
		lbFundo.setForeground(new Color(0, 0, 0));
		lbFundo.setIcon(new ImageIcon("C:\\Users\\Adisiel Alem\u00E3o\\Documents\\EclipseProjects\\BarberShop\\src\\Imagens\\TelaLogin.jpg"));
		lbFundo.setBounds(0, 0, 691, 489);
		contentPane.add(lbFundo);
	}

	public JTextField getTextUsuario() {
		return textUsuario;
	}

	public void setTextUsuario(JTextField textUsuario) {
		this.textUsuario = textUsuario;
	}

	public JPasswordField getTextSenha() {
		return textSenha;
	}

	public void setTextSenha(JPasswordField textSenha) {
		this.textSenha = textSenha;
	}
	
}
