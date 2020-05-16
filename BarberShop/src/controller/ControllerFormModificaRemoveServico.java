package controller;

import javax.swing.table.AbstractTableModel;

import model.DAO.ServicoDAO;
import model.table.ServicoTM;
import view.ViewModificarRemoverServico;

public class ControllerFormModificaRemoveServico {
	private ViewModificarRemoverServico view;
	
	public ControllerFormModificaRemoveServico(ViewModificarRemoverServico view) {
		this.view = view;
	}

	public void updateTabelaAgendamento(int idservico, String descricao, Float valor) {
		ServicoDAO sDAO = new ServicoDAO();
		sDAO.updateByID(idservico, descricao, valor);
	}

	public void preencherJtable() {
		ServicoDAO sDAO = new ServicoDAO();
		AbstractTableModel modelo = new ServicoTM(sDAO.selectAll());
		view.getTbServicos().setModel(modelo);
	}

	public void removeTabelaServico(int idservico) {
		ServicoDAO sDAO = new ServicoDAO();
		sDAO.removeByID(idservico);
	}

}
