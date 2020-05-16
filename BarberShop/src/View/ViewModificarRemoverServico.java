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
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableCellRenderer;

import controller.ControllerFormModificaRemoveServico;
import model.table.ServicoTM;

public class ViewModificarRemoverServico extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTable tbServicos;
	private int linhaServicoSelecionada; 
	private ControllerFormModificaRemoveServico controller;
	private ServicoTM modelo;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ViewModificarRemoverServico frame = new ViewModificarRemoverServico();
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
	public ViewModificarRemoverServico() {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		controller = new ControllerFormModificaRemoveServico(this);
		setBounds(100, 100, 706, 417);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btRemoverServico = new JButton("Remover");
		btRemoverServico.setRequestFocusEnabled(false);
		btRemoverServico.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btRemoverServico.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int idservico = (int) tbServicos.getValueAt(getLinhaServicoSelecionada(), 0);
				controller.removeTabelaServico(idservico);
				controller.preencherJtable();
			}
		});
		btRemoverServico.setForeground(new Color(224, 255, 255));
		btRemoverServico.setFont(new Font("Segoe UI Symbol", Font.PLAIN, 15));
		btRemoverServico.setFocusPainted(false);
		btRemoverServico.setBorderPainted(false);
		btRemoverServico.setBorder(null);
		btRemoverServico.setBackground(new Color(178, 34, 34));
		btRemoverServico.setBounds(96, 320, 231, 34);
		contentPane.add(btRemoverServico);
		
		JButton btModificarServico = new JButton("Modificar ");
		btModificarServico.setRequestFocusEnabled(false);
		btModificarServico.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btModificarServico.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int idservico = (int) tbServicos.getValueAt(getLinhaServicoSelecionada(), 0);
				String descricao = (String) tbServicos.getValueAt(getLinhaServicoSelecionada(), 1);
				Float valor = (Float) tbServicos.getValueAt(getLinhaServicoSelecionada(), 2);
				controller.updateTabelaAgendamento(idservico, descricao, valor);
				controller.preencherJtable();
			}
		});
		btModificarServico.setForeground(new Color(224, 255, 255));
		btModificarServico.setFont(new Font("Segoe UI Symbol", Font.PLAIN, 15));
		btModificarServico.setFocusPainted(false);
		btModificarServico.setBorderPainted(false);
		btModificarServico.setBorder(null);
		btModificarServico.setBackground(new Color(178, 34, 34));
		btModificarServico.setBounds(361, 320, 231, 34);
		contentPane.add(btModificarServico);
		
		tbServicos = new JTable();
		tbServicos.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				linhaServicoSelecionada = tbServicos.getSelectedRow();
			}
		});
		tbServicos.setBorder(new EmptyBorder(0, 0, 0, 0));
		modelo = new ServicoTM();
		tbServicos.setModel(modelo);
		tbServicos.getColumnModel().getColumn(0).setPreferredWidth(90);
		tbServicos.getColumnModel().getColumn(1).setPreferredWidth(225);
		tbServicos.getColumnModel().getColumn(2).setPreferredWidth(112);
		tbServicos.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		tbServicos.setFillsViewportHeight(true);
		tbServicos.setShowGrid(false);
		tbServicos.setBounds(78, 84, 528, 210);
		tbServicos.setAutoCreateColumnsFromModel(false);
		DefaultTableCellRenderer centro = new DefaultTableCellRenderer();		
		centro.setHorizontalAlignment(SwingConstants.CENTER);
		tbServicos.getColumnModel().getColumn(0).setCellRenderer(centro);
		tbServicos.getColumnModel().getColumn(2).setCellRenderer(centro);
		JScrollPane scrollPane = new JScrollPane(tbServicos);
		scrollPane.setBorder(new EmptyBorder(0, 0, 0, 0));
		scrollPane.setBounds(78, 34, 528, 259);
		contentPane.add(scrollPane);
		
		JLabel lbFundo = new JLabel("");
		lbFundo.setIcon(new ImageIcon(ViewModificarRemoverServico.class.getResource("/Imagens/TelaLogin.jpg")));
		lbFundo.setBounds(0, 0, 690, 378);
		contentPane.add(lbFundo);
		inicializar();
	}

	public JTable getTbServicos() {
		return tbServicos;
	}

	public void setTbServicos(JTable tbServicos) {
		this.tbServicos = tbServicos;
	}

	public int getLinhaServicoSelecionada() {
		return linhaServicoSelecionada;
	}

	public void setLinhaServicoSelecionada(int linhaServicoSelecionada) {
		this.linhaServicoSelecionada = linhaServicoSelecionada;
	}
	
	public void inicializar() {
		controller.preencherJtable();
	}
	
}
