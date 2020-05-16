package model.table;

import java.time.DateTimeException;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;
import javax.swing.table.AbstractTableModel;

import model.bean.Agendamento;
import model.bean.Cliente;
import model.bean.Servico;

public class AgendamentoTM extends AbstractTableModel {
	private static final long serialVersionUID = 1L;

	private List<Agendamento> agendamentos;
	
	public AgendamentoTM() {
		agendamentos = new ArrayList<Agendamento>();
	}

	public AgendamentoTM(List<Agendamento> lista) {
		this();
		agendamentos.addAll(lista);
	}
	
	@Override
	public int getColumnCount() {
		return 7;
	}

	@Override
	public int getRowCount() {
		return agendamentos.size();
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
			return "Cliente";
		case 2:
			return "Serviço";
		case 3:
			return "Valor";
		case 4:
			return "Data Marcada";
		case 5:
			return "Horário Marcado";
		case 6:
			return "Observação";
		default:
			return "";
		}
	}
	
	@Override
	public Object getValueAt(int linha, int coluna) {
		Agendamento a = agendamentos.get(linha);
		switch (coluna) {
		case 0:
			return a.getId(); 
		case 1:
			return a.getCliente().getNome(); 
		case 2:
			return a.getServico().getDescricao();
		case 3:
			return a.getServico().getValor();
		case 4:
			DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
			String data =  formatter.format(a.getDataAgendamento());
			return data;
		case 5:
			DateTimeFormatter formatterHorario = DateTimeFormatter.ofPattern("H:mm");
			String horario =  formatterHorario.format(a.getHorarioAgendamento());
			return horario;
		case 6:
			return a.getObservacao();
		default:
			return null;
		}
	}
	
	@Override
	public boolean isCellEditable(int linha, int coluna) {
		return (coluna == 0 || coluna == 1 || coluna == 2 || coluna == 3) ? false: true;	
	}
	
	@Override
	public void setValueAt(Object valor, int linha, int coluna) {
		Agendamento a = agendamentos.get(linha);
		Cliente c = a.getCliente();
		Servico s = a.getServico();
		switch (coluna) {
		case 0:
			a.setId(Integer.parseInt(valor.toString()));
			break;
		case 1:
			c.setNome(valor.toString()); 
			break;
		case 2:
			s.setDescricao(valor.toString());
			break;
		case 3:
			s.setValor(Float.parseFloat(valor.toString()));
			break;
		case 4:
			DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
			LocalDate data = null;
			try {
				data = LocalDate.parse(valor.toString(), formatter);
				a.setDataAgendamento(data);
				break;
			} catch (DateTimeException e) {
				JOptionPane.showMessageDialog(null,
                        "Data inválida. Tente novamente!",
                        "AVISO",
                        JOptionPane.WARNING_MESSAGE);
				break;
			} 
		case 5:
			DateTimeFormatter formatterHorario = DateTimeFormatter.ofPattern("H:mm");
			LocalTime horario = null;
			try {
				horario = LocalTime.parse(valor.toString(), formatterHorario);
				a.setHorarioAgendamento(horario); 
				break;
			} catch (DateTimeException e) {
				JOptionPane.showMessageDialog(null,
                        "Horário inválido. Tente novamente!",
                        "AVISO",
                        JOptionPane.WARNING_MESSAGE);
				break;			
			}
		case 6:
			a.setObservacao(valor.toString());
			break;
		}
		fireTableDataChanged();
	}
	
	public void adiciona(Agendamento a) {
		agendamentos.add(a);
		fireTableRowsInserted(agendamentos.size() - 1, agendamentos.size() - 1);
	}
	
	public void remove(int indice) {
		agendamentos.remove(indice);
		fireTableRowsDeleted(indice, indice);
	}
	
	public int getIndice(Agendamento a) {
		return agendamentos.indexOf(a);
	}
	
	public void adicionaLista(List<Agendamento> lista) {
		int i = agendamentos.size();
		agendamentos.addAll(lista);
		fireTableRowsInserted(i, i + lista.size());
	}
	
	public void limpaLista() {
		int i = agendamentos.size();
		agendamentos.clear();
		fireTableRowsDeleted(0, i - 1);
	}


}
