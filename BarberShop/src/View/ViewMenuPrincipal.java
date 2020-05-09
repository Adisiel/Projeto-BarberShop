package View;

import java.awt.Color;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.Font;


import javax.swing.JTable;
import javax.swing.SwingConstants;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Cursor;

import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;

import Controllers.ControllerFormMenuPrincipal;
import javax.swing.JScrollPane;
import javax.swing.ListSelectionModel;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class ViewMenuPrincipal extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTable tbAgendamento;
	private ControllerFormMenuPrincipal controller;
	private int linhaAgendamentoSelecionada; 
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ViewMenuPrincipal frame = new ViewMenuPrincipal();
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
	@SuppressWarnings("serial")
	public ViewMenuPrincipal() {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		this.linhaAgendamentoSelecionada = 0;
		this.controller = new ControllerFormMenuPrincipal(this);
		setBounds(100, 100, 1000, 627);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JPanel pnJTable = new JPanel();
		pnJTable.setBounds(228, 135, 746, 314);
		pnJTable.setBackground(new Color(255, 255, 255, 80));
		contentPane.add(pnJTable);
		pnJTable.setLayout(null);

		tbAgendamento = new JTable();
		tbAgendamento.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				linhaAgendamentoSelecionada = tbAgendamento.getSelectedRow();
			}
		});
		tbAgendamento.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		tbAgendamento.setRowHeight(25);
		tbAgendamento.setFillsViewportHeight(true);
		tbAgendamento.setShowGrid(false);
		tbAgendamento.setBorder(new EmptyBorder(0, 0, 0, 0));
		tbAgendamento.setRowMargin(0);
		tbAgendamento.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		tbAgendamento.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"ID", "Cliente", "Servi\u00E7o", "Valor", "Data Marcada", "Hor\u00E1rio Marcado", "Observa\u00E7\u00E3o"
			}
		) {
			@SuppressWarnings("rawtypes")
			Class[] columnTypes = new Class[] {
				Integer.class, String.class, String.class, Float.class, String.class, String.class, String.class
			};
			@SuppressWarnings({ "rawtypes", "unchecked" })
			public Class getColumnClass(int columnIndex) {
				return columnTypes[columnIndex];
			}
		});
		tbAgendamento.getColumnModel().getColumn(0).setPreferredWidth(56);
		tbAgendamento.getColumnModel().getColumn(1).setPreferredWidth(101);
		tbAgendamento.getColumnModel().getColumn(2).setPreferredWidth(107);
		tbAgendamento.getColumnModel().getColumn(3).setPreferredWidth(84);
		tbAgendamento.getColumnModel().getColumn(4).setPreferredWidth(115);
		tbAgendamento.getColumnModel().getColumn(5).setPreferredWidth(120);
		tbAgendamento.getColumnModel().getColumn(6).setPreferredWidth(106);
		DefaultTableCellRenderer centro = new DefaultTableCellRenderer();		
		centro.setHorizontalAlignment(SwingConstants.CENTER);
		tbAgendamento.getColumnModel().getColumn(0).setCellRenderer(centro);
		tbAgendamento.getColumnModel().getColumn(3).setCellRenderer(centro);
		tbAgendamento.getColumnModel().getColumn(4).setCellRenderer(centro);
		tbAgendamento.getColumnModel().getColumn(5).setCellRenderer(centro);
		tbAgendamento.setBounds(10, 11, 726, 265);
		
		JScrollPane scrollPane = new JScrollPane(tbAgendamento);
		scrollPane.setBorder(new EmptyBorder(0, 0, 0, 0));
		scrollPane.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		scrollPane.setBounds(10, 11, 726, 292);
		pnJTable.add(scrollPane);

		JPanel pnMenu = new JPanel();
		pnMenu.setBounds(0, 0, 218, 588);
		pnMenu.setBackground(new Color(255, 255, 255, 80));
		contentPane.add(pnMenu);
		pnMenu.setLayout(null);
		
		JButton btCadastrarAgendamento = new JButton("Cadastrar Agendamento");
		btCadastrarAgendamento.setRequestFocusEnabled(false);
		btCadastrarAgendamento.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new ViewAgendamento().setVisible(true);
			}
		});
		btCadastrarAgendamento.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btCadastrarAgendamento.setFocusPainted(false);
		btCadastrarAgendamento.setBorderPainted(false);
		btCadastrarAgendamento.setForeground(new Color(224, 255, 255));
		btCadastrarAgendamento.setFont(new Font("Segoe UI Symbol", Font.PLAIN, 15));
		btCadastrarAgendamento.setBorder(null);
		btCadastrarAgendamento.setBounds(0, 182, 218, 42);
		btCadastrarAgendamento.setBackground(new Color(178, 34, 34));
		pnMenu.add(btCadastrarAgendamento);
		
		JButton btCadastrarServico = new JButton("Cadastrar Servi\u00E7o");
		btCadastrarServico.setRequestFocusEnabled(false);
		btCadastrarServico.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new ViewServico().setVisible(true);
			}
		});
		btCadastrarServico.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btCadastrarServico.setForeground(new Color(224, 255, 255));
		btCadastrarServico.setFont(new Font("Segoe UI Symbol", Font.PLAIN, 15));
		btCadastrarServico.setFocusPainted(false);
		btCadastrarServico.setBorderPainted(false);
		btCadastrarServico.setBorder(null);
		btCadastrarServico.setBackground(new Color(178, 34, 34));
		btCadastrarServico.setBounds(0, 111, 218, 42);
		pnMenu.add(btCadastrarServico);
		
		JButton btCadastrarCliente = new JButton("Cadastrar Cliente");
		btCadastrarCliente.setRequestFocusEnabled(false);
		btCadastrarCliente.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btCadastrarCliente.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new ViewCliente().setVisible(true);
			}
		});
		btCadastrarCliente.setForeground(new Color(224, 255, 255));
		btCadastrarCliente.setFont(new Font("Segoe UI Symbol", Font.PLAIN, 15));
		btCadastrarCliente.setFocusPainted(false);
		btCadastrarCliente.setBorderPainted(false);
		btCadastrarCliente.setBorder(null);
		btCadastrarCliente.setBackground(new Color(178, 34, 34));
		btCadastrarCliente.setBounds(0, 39, 218, 42);
		pnMenu.add(btCadastrarCliente);
		
		JButton btModificicarCliente = new JButton("Modificar/Remover Cliente");
		btModificicarCliente.setRequestFocusEnabled(false);
		btModificicarCliente.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btModificicarCliente.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				new ViewModificaRemoverCliente().setVisible(true);
			}
		});
		btModificicarCliente.setForeground(new Color(224, 255, 255));
		btModificicarCliente.setFont(new Font("Segoe UI Symbol", Font.PLAIN, 15));
		btModificicarCliente.setFocusPainted(false);
		btModificicarCliente.setBorderPainted(false);
		btModificicarCliente.setBorder(null);
		btModificicarCliente.setBackground(new Color(178, 34, 34));
		btModificicarCliente.setBounds(0, 250, 218, 42);
		pnMenu.add(btModificicarCliente);
		
		JButton btModificarServico = new JButton("Modificar/Remover Servi\u00E7o");
		btModificarServico.setRequestFocusEnabled(false);
		btModificarServico.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btModificarServico.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new ViewModificarRemoverServico().setVisible(true);
			}
		});
		btModificarServico.setForeground(new Color(224, 255, 255));
		btModificarServico.setFont(new Font("Segoe UI Symbol", Font.PLAIN, 15));
		btModificarServico.setFocusPainted(false);
		btModificarServico.setBorderPainted(false);
		btModificarServico.setBorder(null);
		btModificarServico.setBackground(new Color(178, 34, 34));
		btModificarServico.setBounds(0, 319, 218, 42);
		pnMenu.add(btModificarServico);
		
		JButton btnSairDoPrograma = new JButton("Sair do BarberShop");
		btnSairDoPrograma.setRequestFocusEnabled(false);
		btnSairDoPrograma.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnSairDoPrograma.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		btnSairDoPrograma.setForeground(new Color(224, 255, 255));
		btnSairDoPrograma.setFont(new Font("Segoe UI Symbol", Font.PLAIN, 15));
		btnSairDoPrograma.setFocusPainted(false);
		btnSairDoPrograma.setBorderPainted(false);
		btnSairDoPrograma.setBorder(null);
		btnSairDoPrograma.setBackground(new Color(178, 34, 34));
		btnSairDoPrograma.setBounds(0, 485, 218, 42);
		pnMenu.add(btnSairDoPrograma);
		
		JButton btAtualizarAgendamento = new JButton("Atualizar Agendamento");
		btAtualizarAgendamento.setRequestFocusEnabled(false);
		btAtualizarAgendamento.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btAtualizarAgendamento.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				controller.preencherJtable();
			}
		});
		btAtualizarAgendamento.setForeground(new Color(224, 255, 255));
		btAtualizarAgendamento.setFont(new Font("Segoe UI Symbol", Font.PLAIN, 15));
		btAtualizarAgendamento.setFocusPainted(false);
		btAtualizarAgendamento.setBorderPainted(false);
		btAtualizarAgendamento.setBorder(null);
		btAtualizarAgendamento.setBackground(new Color(178, 34, 34));
		btAtualizarAgendamento.setBounds(501, 90, 231, 34);
		contentPane.add(btAtualizarAgendamento);
		
		JButton btRemoverAgendamento = new JButton("Remover Agendamento");
		btRemoverAgendamento.setRequestFocusEnabled(false);
		btRemoverAgendamento.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btRemoverAgendamento.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				int idAgendamento = (int) tbAgendamento.getValueAt(getLinhaAgendamentoSelecionada(), 0);
				controller.removerTabelaAgendamento(idAgendamento);
				controller.preencherJtable();
			}
		});
		btRemoverAgendamento.setForeground(new Color(224, 255, 255));
		btRemoverAgendamento.setFont(new Font("Segoe UI Symbol", Font.PLAIN, 15));
		btRemoverAgendamento.setFocusPainted(false);
		btRemoverAgendamento.setBorderPainted(false);
		btRemoverAgendamento.setBorder(null);
		btRemoverAgendamento.setBackground(new Color(178, 34, 34));
		btRemoverAgendamento.setBounds(363, 477, 231, 34);
		contentPane.add(btRemoverAgendamento);
		
		JButton btModificarAgendamento = new JButton("Modificar Agendamento");
		btModificarAgendamento.setRequestFocusEnabled(false);
		btModificarAgendamento.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btModificarAgendamento.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				int idagendamento = (int) tbAgendamento.getValueAt(getLinhaAgendamentoSelecionada(), 0);
				String observacao = (String) tbAgendamento.getValueAt(getLinhaAgendamentoSelecionada(), 6);
				String data = (String) tbAgendamento.getValueAt(getLinhaAgendamentoSelecionada(), 4);
				String horario = (String) tbAgendamento.getValueAt(getLinhaAgendamentoSelecionada(), 5);			
				controller.updateTabelaAgendamento(idagendamento, observacao, data, horario);
				controller.preencherJtable();
			}
		});
		btModificarAgendamento.setForeground(new Color(224, 255, 255));
		btModificarAgendamento.setFont(new Font("Segoe UI Symbol", Font.PLAIN, 15));
		btModificarAgendamento.setFocusPainted(false);
		btModificarAgendamento.setBorderPainted(false);
		btModificarAgendamento.setBorder(null);
		btModificarAgendamento.setBackground(new Color(178, 34, 34));
		btModificarAgendamento.setBounds(628, 477, 231, 34);
		contentPane.add(btModificarAgendamento);
		
		JLabel lbFundo = new JLabel("");
		lbFundo.setIcon(new ImageIcon(ViewMenuPrincipal.class.getResource("/Imagens/TelaLogin.jpg")));
		lbFundo.setBounds(0, 0, 984, 588);
		contentPane.add(lbFundo);
		inicializar();
	}

	public JTable getTbAgendamento() {
		return tbAgendamento;
	}

	public void setTbAgendamento(JTable tbAgendamento) {
		this.tbAgendamento = tbAgendamento;
	}
	
	public int getLinhaAgendamentoSelecionada() {
		return linhaAgendamentoSelecionada;
	}

	public void setLinhaAgendamentoSelecionada(int linhaAgendamentoSelecionada) {
		this.linhaAgendamentoSelecionada = linhaAgendamentoSelecionada;
	}

	public void inicializar() {
		controller.preencherJtable();
	}
}
