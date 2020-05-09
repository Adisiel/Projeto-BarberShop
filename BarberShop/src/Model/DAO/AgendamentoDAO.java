package Model.DAO;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Time;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;

import Connection.ConnectionFactory;
import Model.Bean.Agendamento;

public class AgendamentoDAO {

	public void create(Agendamento a) {
		Connection conexao = ConnectionFactory.getConnection();
		PreparedStatement statement = null;
		Date data = Date.valueOf(a.getDataAgendamento());
		Time time = Time.valueOf(a.getHorarioAgendamento());
		try {
			String sql = "INSERT INTO agendamento(observacao,data_agendamento,horario_agendamento,servico,cliente) VALUES(?,?,?,?,?)";		
			statement = conexao.prepareStatement(sql, PreparedStatement.RETURN_GENERATED_KEYS);
			statement.setString(1, a.getObservacao());
			statement.setDate(2, data);
			statement.setTime(3, time);
			statement.setInt(4, a.getServico().getId());
			statement.setInt(5, a.getCliente().getId());
			statement.executeUpdate();

			JOptionPane.showMessageDialog(null, "Salvo com sucesso");
		} catch (SQLException ex) {
			JOptionPane.showMessageDialog(null, "Erro na criação e gravação deste endereço no banco de dados");
		} finally {
			ConnectionFactory.closeConnection(conexao, statement);
		}
	}

	public List<Agendamento> selectAll () {	 
		ClienteDAO cDAO = new ClienteDAO();
		ServicoDAO sDAO = new ServicoDAO();
		String sql = "SELECT * FROM agendamento";
		List<Agendamento> agendamentos = new ArrayList<Agendamento>();	 
		Connection conexao = ConnectionFactory.getConnection();
		PreparedStatement statement = null;
		ResultSet rs = null;	 
		try {
			statement = conexao.prepareStatement(sql);	 
			rs = statement.executeQuery();		 
			while(rs.next()) {	 
				Agendamento a = new Agendamento();
				a.setId(rs.getInt("idagendamento"));
				a.setCliente(cDAO.selectByID(a.getId()));
				a.setServico(sDAO.selectByID(a.getId()));
				Date d = rs.getDate("data_agendamento");
				LocalDate data = d.toLocalDate();
				a.setDataAgendamento(data);
				Time t = rs.getTime("horario_agendamento");
				LocalTime time = t.toLocalTime();
				a.setHorarioAgendamento(time);
				a.setObservacao(rs.getString("observacao"));
				agendamentos.add(a);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			ConnectionFactory.closeConnection(conexao, statement, rs);
		}
		return agendamentos;
	}

	public void removeByID(int idAgendamento) {
		Connection conexao = ConnectionFactory.getConnection();
		PreparedStatement statement = null;
		String sql = "DELETE FROM barbershop.agendamento WHERE idagendamento = " + idAgendamento + ";";
		try {
			statement = conexao.prepareStatement(sql);
			statement.executeUpdate();
			JOptionPane.showMessageDialog(null, "Deletado com sucesso");
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			ConnectionFactory.closeConnection(conexao, statement);
		}	
	}

	public void updateByID(int idAgendamento, String observacao, LocalDate data, LocalTime horario) {
		Connection conexao = ConnectionFactory.getConnection();
		PreparedStatement statement = null;
		Date d = Date.valueOf(data);
		Time t = Time.valueOf(horario.plusMinutes(180));
		String sql = "UPDATE barbershop.agendamento SET observacao = '" + observacao + "', data_agendamento = DATE('" + d +
				"'), horario_agendamento = TIME('" + t + "') WHERE idagendamento = " + idAgendamento + ";";
		try {
			statement = conexao.prepareStatement(sql);
			statement.executeUpdate();
			JOptionPane.showMessageDialog(null, "Modificado com sucesso");
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			ConnectionFactory.closeConnection(conexao, statement);
		}	
	}

}
