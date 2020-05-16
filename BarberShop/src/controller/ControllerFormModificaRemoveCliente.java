package controller;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import javax.swing.table.AbstractTableModel;

import model.DAO.ClienteDAO;
import model.table.ClienteTM;
import view.ViewModificaRemoverCliente;

public class ControllerFormModificaRemoveCliente {
	
	private ViewModificaRemoverCliente view;
	
	public ControllerFormModificaRemoveCliente(ViewModificaRemoverCliente view) {
		 this.view = view;
	}
	
	public void preencherJtable () {
		ClienteDAO cDAO = new ClienteDAO();
		AbstractTableModel modelo = new ClienteTM(cDAO.selectAll());
		view.getTbCliente().setModel(modelo);
	}

	public void removerTabelaCliente(int idCliente) {
		ClienteDAO cDAO = new ClienteDAO();
		cDAO.removeByID(idCliente);		
	}

	public void updateTabelaAgendamento(int idcliente, String nome, String telefone, String email, String data,
			String cidade, String bairro, String rua, String complemento, int numero) {
		ClienteDAO cDAO = new ClienteDAO();
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
		LocalDate date = LocalDate.parse(data, formatter);
		cDAO.updateByID(idcliente, nome, telefone, email, date, cidade, bairro, rua, complemento, numero);
	}
	
}
