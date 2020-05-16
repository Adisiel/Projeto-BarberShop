package controller;

import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

import javax.swing.table.AbstractTableModel;

import model.DAO.AgendamentoDAO;
import model.table.AgendamentoTM;
import view.ViewMenuPrincipal;

public class ControllerFormMenuPrincipal {
	
	private ViewMenuPrincipal view;

	public ControllerFormMenuPrincipal (ViewMenuPrincipal view){
		this.view = view;
	}
	
	public void preencherJtable () {
		AgendamentoDAO aDAO = new AgendamentoDAO();
		AbstractTableModel modelo = new AgendamentoTM(aDAO.selectAll());
		view.getTbAgendamento().setModel(modelo);
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
