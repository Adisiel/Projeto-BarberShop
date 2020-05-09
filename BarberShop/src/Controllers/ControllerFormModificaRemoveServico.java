package Controllers;

import javax.swing.table.DefaultTableModel;

import Model.Bean.Servico;

import Model.DAO.ServicoDAO;
import View.ViewModificarRemoverServico;

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
		DefaultTableModel modelo = (DefaultTableModel) view.getTbServicos().getModel();
		modelo.setNumRows(0);
		ServicoDAO sDAO = new ServicoDAO();
		for(Servico s: sDAO.selectAll()) {
			modelo.addRow(new Object[] {
					s.getId(),
					s.getDescricao(),
					s.getValor()
			});
		}
		
	}

	public void removeTabelaServico(int idservico) {
		ServicoDAO sDAO = new ServicoDAO();
		sDAO.removeByID(idservico);
	}

}
