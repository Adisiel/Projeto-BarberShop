package model.bean;

import java.time.LocalDate;
import java.time.LocalTime;

public class Agendamento {
	
	private int id;
	private String observacao;
	private LocalDate dataAgendamento;
	private LocalTime horarioAgendamento;
	private Servico servico;
	private Cliente cliente;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getObservacao() {
		return observacao;
	}
	public void setObservacao(String observacao) {
		this.observacao = observacao;
	}
	public LocalDate getDataAgendamento() {
		return dataAgendamento;
	}
	public void setDataAgendamento(LocalDate dataAgendamento) {
		this.dataAgendamento = dataAgendamento;
	}
	public Servico getServico() {
		return servico;
	}
	public void setServico(Servico servico) {
		this.servico = servico;
	}
	public Cliente getCliente() {
		return cliente;
	}
	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}
	public LocalTime getHorarioAgendamento() {
		return horarioAgendamento;
	}
	public void setHorarioAgendamento(LocalTime horarioAgendamento) {
		this.horarioAgendamento = horarioAgendamento;
	}
	
}
