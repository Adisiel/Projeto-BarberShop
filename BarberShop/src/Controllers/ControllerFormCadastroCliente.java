package Controllers;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import Model.Bean.Cliente;
import Model.Bean.Endereco;
import Model.DAO.ClienteDAO;
import View.ViewCliente;

public class ControllerFormCadastroCliente {
	

	private ViewCliente viewCliente;

	public ControllerFormCadastroCliente(ViewCliente viewCliente) {
		this.viewCliente = viewCliente;
	}
	
	public Cliente cadastrarCliente(Endereco endereco) {
	DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
	LocalDate date = LocalDate.parse(viewCliente.getTxtData().getText(), formatter);
	Cliente c = new Cliente();
	ClienteDAO cDAO = new ClienteDAO();
	c.setCpf(viewCliente.getTxtCPF().getText());
	c.setData_nascimento(date);
	c.setEmail(viewCliente.getTxtEmail().getText());
	c.setNome(viewCliente.getTxtNome().getText());
	c.setRg(viewCliente.getTxtRG().getText());
	c.setTelefone(viewCliente.getTxtTelefone().getText());
	c.setEndereco(endereco);
	cDAO.create(c);
	return c;
	}
	
}
