package Controllers;

import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

import javax.swing.table.DefaultTableModel;

import Model.Bean.Agendamento;
import Model.DAO.AgendamentoDAO;
import View.ViewMenuPrincipal;

public class ControllerFormMenuPrincipal {
	
	private ViewMenuPrincipal view;

	public ControllerFormMenuPrincipal (ViewMenuPrincipal view){
		this.view = view;
	}
	
	public void preencherJtable () {
		DefaultTableModel modelo = (DefaultTableModel) view.getTbAgendamento().getModel();
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
		DateTimeFormatter formatterHorario = DateTimeFormatter.ofPattern("H:mm");
		modelo.setNumRows(0);
		AgendamentoDAO aDAO = new AgendamentoDAO();
		for(Agendamento a: aDAO.selectAll()) {
			String date = a.getDataAgendamento().format(formatter);
			String time = a.getHorarioAgendamento().format(formatterHorario);
			modelo.addRow(new Object[] {
					a.getId(),
					a.getCliente().getNome(),
					a.getServico().getDescricao(),
					a.getServico().getValor(),
					date,
					time,
					a.getObservacao()			
			});
		}
	}

	public void removerTabelaAgendamento(int idAgendamento) {
		AgendamentoDAO aDAO = new AgendamentoDAO();
		aDAO.removeByID(idAgendamento);
	}

	public void updateTabelaAgendamento(int idAgendamento, String observacao, String data, String horario) {
		AgendamentoDAO aDAO = new AgendamentoDAO();
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
		DateTimeFormatter formatterHorario = DateTimeFormatter.ofPattern("H:mm");
		LocalDate date = LocalDate.parse(data, formatter);
		LocalTime time = LocalTime.parse(horario, formatterHorario);
		aDAO.updateByID(idAgendamento, observacao, date, time);
	}
}
