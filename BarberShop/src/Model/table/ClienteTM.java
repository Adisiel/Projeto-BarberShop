package model.table;

import java.time.DateTimeException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;
import javax.swing.table.AbstractTableModel;

import model.bean.Cliente;
import model.bean.Endereco;

public class ClienteTM extends AbstractTableModel{

	private static final long serialVersionUID = 1L;

	private List<Cliente> clientes;
	
	public ClienteTM() {
		clientes = new ArrayList<Cliente>();
	}

	public ClienteTM(List<Cliente> lista) {
		this();
		clientes.addAll(lista);
	}
	
	@Override
	public int getColumnCount() {
		return 12;
	}

	@Override
	public int getRowCount() {
		return clientes.size();
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
			return "Nome";
		case 2:
			return "CPF";
		case 3:
			return "RG";
		case 4:
			return "Telefone";
		case 5:
			return "Email";
		case 6:
			return "Data De Nascimento";
		case 7:
			return "Bairro";
		case 8:
			return "Cidade";
		case 9:
			return "Rua";
		case 10:
			return "Complemento";
		case 11:
			return "Número";
		default:
			return "";
		}
	}
	
	@Override
	public Object getValueAt(int linha, int coluna) {
		Cliente c = clientes.get(linha);
		switch (coluna) {
		case 0:
			return c.getId(); 
		case 1:
			return c.getNome(); 
		case 2:
			return c.getCpf(); 
		case 3:
			return c.getRg(); 
		case 4:
			return c.getTelefone(); 
		case 5:
			return c.getEmail(); 
		case 6:
			DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
			String data =  formatter.format(c.getData_nascimento());
			return data; 
		case 7:
			return c.getEndereco().getBairro(); 
		case 8:
			return c.getEndereco().getCidade(); 
		case 9:
			return c.getEndereco().getRua(); 
		case 10:
			return c.getEndereco().getComplemento(); 
		case 11:
			return c.getEndereco().getNumero(); 
		default:
			return null;
		}
	}
	
	@Override
	public boolean isCellEditable(int linha, int coluna) {
		return (coluna == 0 || coluna == 2 || coluna == 3) ? false : true ;
	}
	
	@Override
	public void setValueAt(Object valor, int linha, int coluna) {
		Cliente c = clientes.get(linha);
		Endereco e = c.getEndereco();
		switch (coluna) {
		case 0:
			c.setId(Integer.parseInt(valor.toString()));
			break;
		case 1:
			c.setNome(valor.toString()); 
			break;
		case 2:
			c.setCpf(valor.toString()); 
			break;
		case 3:
			c.setRg(valor.toString()); 
			break;
		case 4:
			c.setTelefone(valor.toString()); 
			break;
		case 5:
			c.setEmail(valor.toString()); 
			break;
		case 6:
			DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
			LocalDate data = null;
			try {
				data = LocalDate.parse(valor.toString(), formatter);
				c.setData_nascimento(data);
				break;
			} catch (DateTimeException ex) {
				JOptionPane.showMessageDialog(null,
                        "Data inválida. Tente novamente!",
                        "AVISO",
                        JOptionPane.WARNING_MESSAGE);
				break;
			} 
		case 7:
			e.setBairro(valor.toString());
			break;
		case 8:
			e.setCidade(valor.toString());
			break;
		case 9:
			e.setRua(valor.toString());
			break;
		case 10:
			e.setComplemento(valor.toString()); 
			break;
		case 11:
			int numero = 0;
			try {
				numero = Integer.parseInt(valor.toString());
				e.setNumero(numero); 
			} catch (NumberFormatException ex) {
				JOptionPane.showMessageDialog(null,
						"Digite um número válido. Tente novamente!",
						"AVISO",
						JOptionPane.WARNING_MESSAGE);
			}

		}
		fireTableDataChanged();
	}
	
	public void adiciona(Cliente c) {
		clientes.add(c);
		fireTableRowsInserted(clientes.size() - 1, clientes.size() - 1);
	}
	
	public void remove(int indice) {
		clientes.remove(indice);
		fireTableRowsDeleted(indice, indice);
	}
	
	public int getIndice(Cliente c) {
		return clientes.indexOf(c);
	}
	
	public void adicionaLista(List<Cliente> lista) {
		int i = clientes.size();
		clientes.addAll(lista);
		fireTableRowsInserted(i, i + lista.size());
	}
	
	public void limpaLista() {
		int i = clientes.size();
		clientes.clear();
		fireTableRowsDeleted(0, i - 1);
	}
	
}
