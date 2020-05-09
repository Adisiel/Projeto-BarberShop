package Controllers;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import javax.swing.table.DefaultTableModel;

import Model.Bean.Cliente;
import Model.DAO.ClienteDAO;
import View.ViewModificaRemoverCliente;

public class ControllerFormModificaRemoveCliente {
	
	private ViewModificaRemoverCliente view;
	
	public ControllerFormModificaRemoveCliente(ViewModificaRemoverCliente view) {
		 this.view = view;
	}
	
	public void preencherJtable () {
		DefaultTableModel modelo = (DefaultTableModel) view.getTbCliente().getModel();
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
		modelo.setNumRows(0);
		ClienteDAO cDAO = new ClienteDAO();
		for(Cliente c: cDAO.selectAll()) {
			String date = c.getData_nascimento().format(formatter);
			modelo.addRow(new Object[] {
					c.getId(),
					c.getNome(),
					c.getCpf(),
					c.getRg(),
					c.getTelefone(),
					c.getEmail(),
					date,
					c.getEndereco().getCidade(),
					c.getEndereco().getBairro(),
					c.getEndereco().getRua(),
					c.getEndereco().getComplemento(),
					c.getEndereco().getNumero()
			});
		}
		
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
