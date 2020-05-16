package controller;

import java.time.DateTimeException;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JOptionPane;

import model.DAO.AgendamentoDAO;
import model.DAO.ClienteDAO;
import model.DAO.ServicoDAO;
import model.bean.Agendamento;
import model.bean.Cliente;
import model.bean.Servico;
import view.ViewAgendamento;

public class ControllerFormCadastroAgendamento {

	ViewAgendamento view;

	public ControllerFormCadastroAgendamento(ViewAgendamento view) {
		this.view = view;
	} 

	public Agendamento cadastrarAgendamento(Servico s, Cliente c) {
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
		DateTimeFormatter formatterTime = DateTimeFormatter.ofPattern("H:mm");
		Agendamento a = new Agendamento();
		AgendamentoDAO aDAO= new AgendamentoDAO();
		try {
			LocalDate data = LocalDate.parse(view.getTxtDataMarcada().getText(), formatter);
			LocalTime time = LocalTime.parse(view.getTxtHorarioMarcado().getText(), formatterTime);
			a.setCliente(c);
			a.setDataAgendamento(data);
			a.setObservacao(view.getTxtObservacao().getText());
			a.setServico(s);
			a.setHorarioAgendamento(time);
			aDAO.create(a);
			view.dispose();
		} catch (DateTimeException e) {
			JOptionPane.showMessageDialog(null,
					"Data ou Horário inválido. Tente novamente!",
					"AVISO",
					JOptionPane.WARNING_MESSAGE);		
		} 
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
