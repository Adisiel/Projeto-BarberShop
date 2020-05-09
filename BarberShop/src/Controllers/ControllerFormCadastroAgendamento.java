package Controllers;

import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

import javax.swing.DefaultComboBoxModel;

import Model.Bean.Agendamento;
import Model.Bean.Cliente;
import Model.Bean.Servico;
import Model.DAO.AgendamentoDAO;
import Model.DAO.ClienteDAO;
import Model.DAO.ServicoDAO;
import View.ViewAgendamento;

public class ControllerFormCadastroAgendamento {
	
	ViewAgendamento view;
	
	public ControllerFormCadastroAgendamento(ViewAgendamento view) {
		this.view = view;
	} 
	
	public Agendamento cadastrarAgendamento(Servico s, Cliente c) {
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
		LocalDate data = LocalDate.parse(view.getTxtDataMarcada().getText(), formatter);
		DateTimeFormatter formatterTime = DateTimeFormatter.ofPattern("H:mm");
		LocalTime time = LocalTime.parse(view.getTxtHorarioMarcado().getText(), formatterTime);
		Agendamento a = new Agendamento();
		AgendamentoDAO aDAO= new AgendamentoDAO();
		a.setCliente(c);
		a.setDataAgendamento(data);
		a.setObservacao(view.getTxtObservacao().getText());
		a.setServico(s);
		a.setHorarioAgendamento(time);
		aDAO.create(a);
		return a;
	}
	
	public void preencherServicos() {
		ServicoDAO servicos = new ServicoDAO();
		DefaultComboBoxModel<Servico> cbModel = (DefaultComboBoxModel<Servico>) view.getCbServico().getModel();
		for (Servico s: servicos.selectAll()) {
			cbModel.addElement(s);
		}
	}
	
	public void preencherClientes() {
		ClienteDAO cliente = new ClienteDAO();
		DefaultComboBoxModel<Cliente> cbModel = (DefaultComboBoxModel<Cliente>) view.getCbCliente().getModel();
		for (Cliente c: cliente.selectAll()) {
			cbModel.addElement(c);
		}
	}
	
	public String preencherValorServico(String nomeServico) {
		ServicoDAO servicos = new ServicoDAO();
		for (Servico s: servicos.selectAll()) {
			if (s.getDescricao().equals(nomeServico)) {
				return String.valueOf(s.getValor());
			}
		}
		return "";
	}	
	
	public Cliente buscaClientePorNome(String nomeCliente) {
		Cliente c = new Cliente();
		ClienteDAO cDAO = new ClienteDAO();
		c = cDAO.selectByNome(nomeCliente);
		return c;
	}
	
	public Servico buscaServicoPorNome(String nomeCliente) {
		Servico s = new Servico();
		ServicoDAO sDAO = new ServicoDAO();
		s = sDAO.selectByNome(nomeCliente);
		return s;
	}
}
