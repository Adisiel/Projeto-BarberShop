package view;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.ListSelectionModel;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableCellRenderer;

import controller.ControllerFormModificaRemoveCliente;
import model.table.ClienteTM;

public class ViewModificaRemoverCliente extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTable tbCliente;
	private int linhaClienteSelecionada;
	private ControllerFormModificaRemoveCliente controller;
	private ClienteTM modelo;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ViewModificaRemoverCliente frame = new ViewModificaRemoverCliente();
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
	public ViewModificaRemoverCliente() {
		controller = new ControllerFormModificaRemoveCliente(this);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 1041, 467);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btModificarCliente = new JButton("Remover");
		btModificarCliente.setRequestFocusEnabled(false);
		btModificarCliente.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btModificarCliente.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				int idCliente = (int) tbCliente.getValueAt(getLinhaClienteSelecionada(), 0);
				controller.removerTabelaCliente(idCliente);
				controller.preencherJtable();
			}
		});
		btModificarCliente.setBounds(276, 367, 231, 34);
		btModificarCliente.setForeground(new Color(224, 255, 255));
		btModificarCliente.setFont(new Font("Segoe UI Symbol", Font.PLAIN, 15));
		btModificarCliente.setFocusPainted(false);
		btModificarCliente.setBorderPainted(false);
		btModificarCliente.setBorder(null);
		btModificarCliente.setBackground(new Color(178, 34, 34));
		contentPane.add(btModificarCliente);
		
		JButton btRemoverCliente = new JButton("Modificar");
		btRemoverCliente.setRequestFocusEnabled(false);
		btRemoverCliente.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btRemoverCliente.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int idcliente = (int) tbCliente.getValueAt(getLinhaClienteSelecionada(), 0);
				String nome = (String) tbCliente.getValueAt(getLinhaClienteSelecionada(), 1);
				String telefone = (String) tbCliente.getValueAt(getLinhaClienteSelecionada(), 4);
				String email = (String) tbCliente.getValueAt(getLinhaClienteSelecionada(), 5);	
				String data = (String) tbCliente.getValueAt(getLinhaClienteSelecionada(), 6);	
				String cidade = (String) tbCliente.getValueAt(getLinhaClienteSelecionada(), 7);	
				String bairro = (String) tbCliente.getValueAt(getLinhaClienteSelecionada(), 8);	
				String rua = (String) tbCliente.getValueAt(getLinhaClienteSelecionada(), 9);	
				String complemento = (String) tbCliente.getValueAt(getLinhaClienteSelecionada(), 10);	
				int numero = (int) tbCliente.getValueAt(getLinhaClienteSelecionada(), 11);	
				controller.updateTabelaAgendamento(idcliente, nome, telefone, email, data, cidade, bairro, rua, complemento, numero);
				controller.preencherJtable();
			}
		});
		btRemoverCliente.setBounds(541, 367, 231, 34);
		btRemoverCliente.setForeground(new Color(224, 255, 255));
		btRemoverCliente.setFont(new Font("Segoe UI Symbol", Font.PLAIN, 15));
		btRemoverCliente.setFocusPainted(false);
		btRemoverCliente.setBorderPainted(false);
		btRemoverCliente.setBorder(null);
		btRemoverCliente.setBackground(new Color(178, 34, 34));
		contentPane.add(btRemoverCliente);
		
		tbCliente = new JTable();
		tbCliente.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				linhaClienteSelecionada = tbCliente.getSelectedRow();
			}
		});
		tbCliente.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		tbCliente.setRowMargin(0);
		tbCliente.setRowHeight(25);
		tbCliente.setCursor(Cursor.getPredefinedCursor(Cursor.DEFAULT_CURSOR));
		tbCliente.setShowGrid(false);
		tbCliente.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		tbCliente.setFillsViewportHeight(true);
		modelo = new ClienteTM();
		tbCliente.setModel(modelo);
		tbCliente.getColumnModel().getColumn(0).setPreferredWidth(81);
		tbCliente.getColumnModel().getColumn(1).setPreferredWidth(81);
		tbCliente.getColumnModel().getColumn(2).setPreferredWidth(79);
		tbCliente.getColumnModel().getColumn(3).setPreferredWidth(79);
		tbCliente.getColumnModel().getColumn(4).setPreferredWidth(84);
		tbCliente.getColumnModel().getColumn(5).setPreferredWidth(82);
		tbCliente.getColumnModel().getColumn(6).setPreferredWidth(115);
		tbCliente.getColumnModel().getColumn(7).setPreferredWidth(79);
		tbCliente.getColumnModel().getColumn(8).setPreferredWidth(81);
		tbCliente.getColumnModel().getColumn(9).setPreferredWidth(84);
		tbCliente.getColumnModel().getColumn(10).setPreferredWidth(88);
		tbCliente.setAutoCreateColumnsFromModel(false);
		DefaultTableCellRenderer centro = new DefaultTableCellRenderer();		
		centro.setHorizontalAlignment(SwingConstants.CENTER);
		tbCliente.getColumnModel().getColumn(0).setCellRenderer(centro);
		tbCliente.getColumnModel().getColumn(6).setCellRenderer(centro);
		tbCliente.getColumnModel().getColumn(11).setCellRenderer(centro);
		tbCliente.setBounds(36, 26, 756, 216);
		
		JScrollPane scrollPane = new JScrollPane(tbCliente);
		scrollPane.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		scrollPane.setBorder(new EmptyBorder(0, 0, 0, 0));
		scrollPane.setBounds(10, 46, 1005, 299);
		contentPane.add(scrollPane);
		
		JLabel lbFundo = new JLabel("");
		lbFundo.setBounds(0, 0, 1025, 428);
		lbFundo.setIcon(new ImageIcon(ViewModificaRemoverCliente.class.getResource("/Imagens/TelaLogin.jpg")));
		contentPane.add(lbFundo);
		inicializar();
	}

	public JTable getTbCliente() {
		return tbCliente;
	}

	public void setTbCliente(JTable tbCliente) {
		this.tbCliente = tbCliente;
	}

	public int getLinhaClienteSelecionada() {
		return linhaClienteSelecionada;
	}

	public void setLinhaClienteSelecionada(int linhaClienteSelecionada) {
		this.linhaClienteSelecionada = linhaClienteSelecionada;
	}
	
	public void inicializar() {
		controller.preencherJtable();
	}
	
}
