package model.table;

import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;
import javax.swing.table.AbstractTableModel;

import model.bean.Servico;

public class ServicoTM extends AbstractTableModel{
	private static final long serialVersionUID = 1L;

	private List<Servico> servicos;
	
	public ServicoTM() {
		servicos = new ArrayList<Servico>();
	}

	public ServicoTM(List<Servico> lista) {
		this();
		servicos.addAll(lista);
	}
	
	@Override
	public int getColumnCount() {
		return 3;
	}

	@Override
	public int getRowCount() {
		return servicos.size();
	}
	
	public Class<?> getColumnClass(){
		return String.class;
	}
	
	@Override
	public String getColumnName(int coluna) {
		switch (coluna) {
		case 0:
			return "ID";
		case 1:
			return "Descricao";
		case 2:
			return "Valor";
		default:
			return "";
		}
	}
	
	@Override
	public Object getValueAt(int linha, int coluna) {
		Servico s = servicos.get(linha);
		switch (coluna) {
		case 0:
			return s.getId(); 
		case 1:
			return s.getDescricao(); 
		case 2:
			return s.getValor(); 
		default:
			return null;
		}
	}
	
	@Override
	public boolean isCellEditable(int linha, int coluna) {
		return coluna != 0;
	}
	
	@Override
	public void setValueAt(Object valor, int linha, int coluna) {
		Servico s = servicos.get(linha);
		switch (coluna) {
		case 0:
			s.setId(Integer.parseInt(valor.toString()));
			break;
		case 1:
			s.setDescricao(valor.toString()); 
			break;
		case 2:
			float v = 0;
			try {
				v = Float.parseFloat(valor.toString());
				s.setValor(v); 
				break;
			} catch (NumberFormatException e) {
				JOptionPane.showMessageDialog(null,
                        "Valor inválido. Tente novamente! (Exemplo de formatos com valores válidos: 20.0, 8.50, 10.)",
                        "AVISO",
                        JOptionPane.WARNING_MESSAGE);
				break;
			}
		}
		fireTableDataChanged();
	}
	
	public void adiciona(Servico s) {
		servicos.add(s);
		fireTableRowsInserted(servicos.size() - 1, servicos.size() - 1);
	}
	
	public void remove(int indice) {
		servicos.remove(indice);
		fireTableRowsDeleted(indice, indice);
	}
	
	public int getIndice(Servico s) {
		return servicos.indexOf(s);
	}
	
	public void adicionaLista(List<Servico> lista) {
		int i = servicos.size();
		servicos.addAll(lista);
		fireTableRowsInserted(i, i + lista.size());
	}
	
	public void limpaLista() {
		int i = servicos.size();
		servicos.clear();
		fireTableRowsDeleted(0, i - 1);
	}

}
