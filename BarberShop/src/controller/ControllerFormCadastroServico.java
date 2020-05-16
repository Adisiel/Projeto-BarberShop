package controller;

import javax.swing.JOptionPane;

import model.DAO.ServicoDAO;
import model.bean.Servico;
import view.ViewServico;

public class ControllerFormCadastroServico {
	ViewServico view;

	public ControllerFormCadastroServico (ViewServico view) {
		this.view = view;
	}

	public Servico cadastrarServico() {
		Servico s = new Servico();
		ServicoDAO sDAO = new ServicoDAO();
		try {
			s.setDescricao(view.getTxtDescricao().getText());
			s.setValor(Float.parseFloat(view.getTxtValor().getText()));
			sDAO.create(s);
			view.dispose();
		} catch (NumberFormatException ex) {
			JOptionPane.showMessageDialog(null,
					"Valor inválido. Tente novamente! (Exemplo de formatos com valores válidos: 20.0, 8.50, 10.)",
					"AVISO",
					JOptionPane.WARNING_MESSAGE);
		}
		return s;
	}

}
