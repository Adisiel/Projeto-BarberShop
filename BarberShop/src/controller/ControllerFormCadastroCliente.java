package controller;

import java.time.DateTimeException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import javax.swing.JOptionPane;

import model.DAO.ClienteDAO;
import model.bean.Cliente;
import model.bean.Endereco;
import view.ViewCliente;

public class ControllerFormCadastroCliente {
	

	private ViewCliente view;

	public ControllerFormCadastroCliente(ViewCliente viewCliente) {
		this.view = viewCliente;
	}
	
	public Cliente cadastrarCliente(Endereco endereco) {
		Cliente c = new Cliente();
		ClienteDAO cDAO = new ClienteDAO();
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
		LocalDate date = null;
		try {
			date = LocalDate.parse(view.getTxtData().getText(), formatter);
			c.setData_nascimento(date);
			c.setCpf(view.getTxtCPF().getText());
			c.setData_nascimento(date);
			c.setEmail(view.getTxtEmail().getText());
			c.setNome(view.getTxtNome().getText());
			c.setRg(view.getTxtRG().getText());
			c.setTelefone(view.getTxtTelefone().getText());
			c.setEndereco(endereco);
			cDAO.create(c);
			view.dispose();
		} catch (DateTimeException ex) {
			JOptionPane.showMessageDialog(null,
					"Data inválida. Tente novamente!",
					"AVISO",
					JOptionPane.WARNING_MESSAGE);
		} 
		return c;
	}
	
}
