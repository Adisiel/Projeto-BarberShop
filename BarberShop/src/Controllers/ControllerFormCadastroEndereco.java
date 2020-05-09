package Controllers;

import Model.Bean.Endereco;
import Model.DAO.EnderecoDAO;
import View.ViewEndereco;

public class ControllerFormCadastroEndereco {

	private ViewEndereco view;

	public ControllerFormCadastroEndereco(ViewEndereco view) {
		this.view = view;
	}
	
	public Endereco cadastrarEndereco() {
		Endereco end = new Endereco();
		EnderecoDAO eDAO = new EnderecoDAO();
		end.setCidade(view.getTxtCidade().getText());
		end.setBairro(view.getTxtBairro().getText());
		end.setRua(view.getTxtRua().getText());
		end.setComplemento(view.getTxtComplemento().getText());
		end.setNumero(Integer.parseInt(view.getTxtNumero().getText()));
		int idEnderecoCadastrado = eDAO.create(end);
		end.setId(idEnderecoCadastrado);
		return end;
	}
}
