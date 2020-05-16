package controller;

import javax.swing.JOptionPane;

import model.DAO.EnderecoDAO;
import model.bean.Endereco;
import view.ViewEndereco;

public class ControllerFormCadastroEndereco {

	private ViewEndereco view;

	public ControllerFormCadastroEndereco(ViewEndereco view) {
		this.view = view;
	}

	public Endereco cadastrarEndereco() {
		Endereco end = new Endereco();
		EnderecoDAO eDAO = new EnderecoDAO();
		try {
			end.setCidade(view.getTxtCidade().getText());
			end.setBairro(view.getTxtBairro().getText());
			end.setRua(view.getTxtRua().getText());
			end.setComplemento(view.getTxtComplemento().getText());
			end.setNumero(Integer.parseInt(view.getTxtNumero().getText()));
			int idEnderecoCadastrado = eDAO.create(end);
			end.setId(idEnderecoCadastrado);
			view.dispose();
		}  catch (NumberFormatException ex) {
			JOptionPane.showMessageDialog(null,
					"Digite um número válido. Tente novamente!",
					"AVISO",
					JOptionPane.WARNING_MESSAGE);
		}

		return end;
	}
}
