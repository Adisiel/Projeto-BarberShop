package View;


import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import Controllers.ControllerFormCadastroAgendamento;
import Model.Bean.Cliente;
import Model.Bean.Servico;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.ImageIcon;
import javax.swing.JComboBox;
import java.awt.Font;
import java.awt.Color;
import javax.swing.JTextField;
import java.awt.event.ItemListener;
import java.text.ParseException;
import java.awt.event.ItemEvent;
import javax.swing.SwingConstants;
import javax.swing.JButton;
import javax.swing.border.LineBorder;
import javax.swing.text.DefaultFormatterFactory;
import javax.swing.text.MaskFormatter;

import java.awt.Cursor;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JTextArea;
import javax.swing.JFormattedTextField;

public class ViewAgendamento extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JComboBox<Servico> cbServico;
	private JComboBox<Cliente> cbCliente;
	private ControllerFormCadastroAgendamento controller;
	private JTextField txtValor;
	private JTextArea txtObservacao;
	private JFormattedTextField txtHorarioMarcado;
	private JFormattedTextField txtDataMarcada;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ViewAgendamento frame = new ViewAgendamento();
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
	public ViewAgendamento() {
		this.controller = new ControllerFormCadastroAgendamento(this);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 1010, 576);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btCadastrarAgendamento = new JButton("Cadastrar Agendamento");
		btCadastrarAgendamento.setRequestFocusEnabled(false);
		btCadastrarAgendamento.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Servico servico = controller.buscaServicoPorNome(cbServico.getSelectedItem().toString());
				Cliente cliente = controller.buscaClientePorNome(cbCliente.getSelectedItem().toString());			
				controller.cadastrarAgendamento(servico, cliente);			
				dispose();
			}
		});
		btCadastrarAgendamento.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btCadastrarAgendamento.setHorizontalTextPosition(SwingConstants.CENTER);
		btCadastrarAgendamento.setForeground(Color.WHITE);
		btCadastrarAgendamento.setFont(new Font("Segoe UI", Font.PLAIN, 18));
		btCadastrarAgendamento.setBorderPainted(false);
		btCadastrarAgendamento.setBorder(null);
		btCadastrarAgendamento.setBackground(new Color(178, 34, 34));
		btCadastrarAgendamento.setBounds(165, 445, 269, 37);
		contentPane.add(btCadastrarAgendamento);
		
		JButton btnCancelar = new JButton("Cancelar");
		btnCancelar.setRequestFocusEnabled(false);
		btnCancelar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				dispose();
			}
		});
		btnCancelar.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnCancelar.setHorizontalTextPosition(SwingConstants.CENTER);
		btnCancelar.setForeground(Color.WHITE);
		btnCancelar.setFont(new Font("Segoe UI", Font.PLAIN, 18));
		btnCancelar.setBorderPainted(false);
		btnCancelar.setBorder(null);
		btnCancelar.setBackground(new Color(178, 34, 34));
		btnCancelar.setBounds(558, 445, 269, 37);
		contentPane.add(btnCancelar);
		
		JLabel lbSelecionarServico = new JLabel("Selecionar Servi\u00E7o:");
		lbSelecionarServico.setBounds(64, 36, 158, 19);
		contentPane.add(lbSelecionarServico);
		lbSelecionarServico.setForeground(Color.WHITE);
		lbSelecionarServico.setFont(new Font("Segoe UI", Font.PLAIN, 18));
		
		JLabel lbSelecionarCliente = new JLabel("Selecionar Cliente:");
		lbSelecionarCliente.setBounds(64, 114, 158, 19);
		contentPane.add(lbSelecionarCliente);
		lbSelecionarCliente.setForeground(Color.WHITE);
		lbSelecionarCliente.setFont(new Font("Segoe UI", Font.PLAIN, 18));
		
		cbServico = new JComboBox<Servico>();
		cbServico.setBounds(232, 33, 235, 28);
		contentPane.add(cbServico);
		cbServico.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		cbServico.setBorder(new LineBorder(new Color(178, 34, 34)));
		cbServico.setFocusable(false);
		cbServico.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent arg0) {				
				String valor = controller.preencherValorServico(cbServico.getSelectedItem().toString());
				txtValor.setText(valor);
			}
		});
		cbServico.setForeground(new Color(178, 34, 34));
		cbServico.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		cbServico.setBackground(new Color(255, 255, 255));
		
		cbCliente = new JComboBox<Cliente>();
		cbCliente.setBounds(232, 111, 235, 28);
		contentPane.add(cbCliente);
		cbCliente.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		cbCliente.setBorder(new LineBorder(new Color(178, 34, 34)));
		cbCliente.setFocusable(false);
		cbCliente.setForeground(new Color(178, 34, 34));
		cbCliente.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		cbCliente.setBackground(new Color(255, 255, 255));
		
		JLabel lbValor = new JLabel("Valor:");
		lbValor.setBounds(64, 354, 50, 19);
		contentPane.add(lbValor);
		lbValor.setForeground(Color.WHITE);
		lbValor.setFont(new Font("Segoe UI", Font.PLAIN, 18));
		
		txtValor = new JTextField();
		txtValor.setBounds(124, 352, 125, 26);
		contentPane.add(txtValor);
		txtValor.setEditable(false);
		txtValor.setForeground(new Color(178, 34, 34));
		txtValor.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		txtValor.setColumns(10);
		txtValor.setBorder(new EmptyBorder(0, 5, 0, 0));
		
		txtDataMarcada = new JFormattedTextField();
		txtDataMarcada.setForeground(new Color(178, 34, 34));
		txtDataMarcada.setBorder(new EmptyBorder(0, 5, 0, 0));
		txtDataMarcada.setBounds(232, 195, 125, 28);
		try {
			txtDataMarcada.setFormatterFactory(new DefaultFormatterFactory(new MaskFormatter("##/##/####")));
		} catch (ParseException e) {
			JOptionPane.showMessageDialog(null, "Digite a data corretamente!");
		}
		contentPane.add(txtDataMarcada);
		
		JLabel lbDataMarcada = new JLabel("Data de Realiza\u00E7\u00E3o:");
		lbDataMarcada.setBounds(64, 195, 166, 19);
		contentPane.add(lbDataMarcada);
		lbDataMarcada.setForeground(Color.WHITE);
		lbDataMarcada.setFont(new Font("Segoe UI", Font.PLAIN, 18));
		
		JLabel lbObservacao = new JLabel("Observa\u00E7\u00E3o:");
		lbObservacao.setForeground(Color.WHITE);
		lbObservacao.setFont(new Font("Segoe UI", Font.PLAIN, 18));
		lbObservacao.setBounds(541, 32, 166, 19);
		contentPane.add(lbObservacao);
		
		JLabel lbHorarioMarcado = new JLabel("Hor\u00E1rio da Realiza\u00E7\u00E3o:");
		lbHorarioMarcado.setForeground(Color.WHITE);
		lbHorarioMarcado.setFont(new Font("Segoe UI", Font.PLAIN, 18));
		lbHorarioMarcado.setBounds(62, 276, 187, 19);
		contentPane.add(lbHorarioMarcado);
		
		txtObservacao = new JTextArea();
		txtObservacao.setLineWrap(true);
		txtObservacao.setBorder(new EmptyBorder(5, 5, 0, 0));
		txtObservacao.setForeground(new Color(128, 0, 0));
		txtObservacao.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		txtObservacao.setBounds(541, 62, 390, 233);
		contentPane.add(txtObservacao);
		
		txtHorarioMarcado = new JFormattedTextField();
		txtHorarioMarcado.setForeground(new Color(178, 34, 34));
		txtHorarioMarcado.setBorder(new EmptyBorder(0, 5, 0, 0));
		txtHorarioMarcado.setBounds(251, 275, 73, 28);
		try {
			txtHorarioMarcado.setFormatterFactory(new DefaultFormatterFactory(new MaskFormatter("##:##")));
		} catch (ParseException e) {
			JOptionPane.showMessageDialog(null, "Digite o horário corretamente!");
		}
		contentPane.add(txtHorarioMarcado);
		
		JLabel lbFundo = new JLabel("");
		lbFundo.setVerticalTextPosition(SwingConstants.TOP);
		lbFundo.setVerticalAlignment(SwingConstants.BOTTOM);
		lbFundo.setIcon(new ImageIcon(ViewAgendamento.class.getResource("/Imagens/TelaLogin.jpg")));
		lbFundo.setBounds(0, 0, 994, 537);
		contentPane.add(lbFundo);
		
		inicializacao();
	}

	public JComboBox<Servico> getCbServico() {
		return cbServico;
	}

	public void setCbServico(JComboBox<Servico> cbServico) {
		this.cbServico = cbServico;
	}

	public JComboBox<Cliente> getCbCliente() {
		return cbCliente;
	}

	public void setCbCliente(JComboBox<Cliente> cbCliente) {
		this.cbCliente = cbCliente;
	}

	public JTextField getTxtValor() {
		return txtValor;
	}

	public void setTxtValor(JTextField txtValor) {
		this.txtValor = txtValor;
	}

	public JTextArea getTxtObservacao() {
		return txtObservacao;
	}

	public void setTxtObservacao(JTextArea txtObservacao) {
		this.txtObservacao = txtObservacao;
	}

	public JFormattedTextField getTxtHorarioMarcado() {
		return txtHorarioMarcado;
	}

	public void setTxtHorarioMarcado(JFormattedTextField txtHorarioMarcado) {
		this.txtHorarioMarcado = txtHorarioMarcado;
	}

	public JFormattedTextField getTxtDataMarcada() {
		return txtDataMarcada;
	}

	public void setTxtDataMarcada(JFormattedTextField txtDataMarcada) {
		this.txtDataMarcada = txtDataMarcada;
	}

	public void inicializacao() {
		controller.preencherServicos();
		controller.preencherClientes();
	}
}
