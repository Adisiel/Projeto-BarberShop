package Controllers;

import Model.Bean.Servico;
import Model.DAO.ServicoDAO;
import View.ViewServico;

public class ControllerFormCadastroServico {
	ViewServico view;
	
	public ControllerFormCadastroServico (ViewServico view) {
		this.view = view;
	}
	
	public Servico cadastrarServico() {
		Servico s = new Servico();
		ServicoDAO sDAO = new ServicoDAO();
		s.setDescricao(view.getTxtDescricao().getText());
		s.setValor(Float.parseFloat(view.getTxtValor().getText()));
		sDAO.create(s);
		return s;
	}
	
}
