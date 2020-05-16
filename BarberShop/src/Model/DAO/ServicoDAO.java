package model.DAO;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;

import connection.ConnectionFactory;
import model.bean.Servico;


public class ServicoDAO {


	public void create (Servico servico) {
		Connection conexao = ConnectionFactory.getConnection();
		PreparedStatement statement = null;
		try {
			String sql = "INSERT INTO servico(descricao,valor) VALUES(?,?)";		
			statement = conexao.prepareStatement(sql);
			statement.setString(1, servico.getDescricao());
			statement.setFloat(2, servico.getValor());
			statement.executeUpdate();
			JOptionPane.showMessageDialog(null, "Salvo com sucesso");
		} catch (SQLException ex) {
			JOptionPane.showMessageDialog(null, "Erro na criação e gravação deste serviço no banco de dados");
		} finally {
			ConnectionFactory.closeConnection(conexao, statement);
		}
	}

	public List<Servico> selectAll () {	 
		String sql = "SELECT * FROM servico";
		List<Servico> servicos = new ArrayList<Servico>();	 
		Connection conexao = ConnectionFactory.getConnection();
		PreparedStatement statement = null;
		ResultSet rs = null;	 
		try {
			statement = conexao.prepareStatement(sql);	 
			rs = statement.executeQuery();		 
			while(rs.next()) {	 
				Servico s = new Servico();
				s.setId(rs.getInt("idservico"));
				s.setDescricao(rs.getString("descricao"));
				s.setValor(rs.getFloat("valor"));
				servicos.add(s);
			}
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "Erro na seleção de todos os serviços no banco de dados");
		} finally {
			ConnectionFactory.closeConnection(conexao, statement, rs);
		}
		return servicos;
	}

	public Servico selectByNome (String nomeServico) {	 
		String sql = "select * from barbershop.servico where descricao = '" + nomeServico + "';";
		Servico s = new Servico();	 
		Connection conexao = ConnectionFactory.getConnection();
		PreparedStatement statement = null;
		ResultSet rs = null;	 
		try {
			statement = conexao.prepareStatement(sql);	 
			rs = statement.executeQuery();		 
			while(rs.next()) {	 
				s.setId(rs.getInt("idservico"));
				s.setDescricao(rs.getString("descricao"));
				s.setValor(rs.getFloat("valor"));
				break;
			}
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "Erro na seleção deste serviço no banco de dados");
		} finally {
			ConnectionFactory.closeConnection(conexao, statement, rs);
		}
		return s;
	}

	public Servico selectByID (int idAgendamento) {	 
		String sql = "SELECT idservico, descricao, valor FROM barbershop.servico as A " +
				"INNER JOIN barbershop.agendamento as B on A.idservico = B.servico " +
				"where idagendamento = " +  Integer.toString(idAgendamento) + ";";   

		Servico s = new Servico(); 
		Connection conexao = ConnectionFactory.getConnection();
		PreparedStatement statement = null;
		ResultSet rs = null;	 
		try {
			statement = conexao.prepareStatement(sql);	 
			rs = statement.executeQuery();		 
			while(rs.next()) {	 
				s.setId(rs.getInt("idservico"));
				s.setDescricao(rs.getString("descricao"));
				s.setValor(rs.getInt("valor"));
			}
		} catch (Exception ex) {
			JOptionPane.showMessageDialog(null, "Erro na seleção deste serviço no banco de dados");
		} finally {
			ConnectionFactory.closeConnection(conexao, statement, rs);
		}
		return s;
	}

	public void removeByID(int idServico) {
		Connection conexao = ConnectionFactory.getConnection();
		PreparedStatement statement = null;
		String sql = "DELETE FROM barbershop.servico WHERE idservico = " + idServico + ";";
		try {
			statement = conexao.prepareStatement(sql);
			statement.executeUpdate();
			JOptionPane.showMessageDialog(null, "Deletado com sucesso");
		} catch (SQLException e) {
			JOptionPane.showMessageDialog(null, "Erro na remoção deste serviço no banco de dados");;
		} finally {
			ConnectionFactory.closeConnection(conexao, statement);
		}	
	}

	public void updateByID(int idservico, String descricao, Float valor) {
		Connection conexao = ConnectionFactory.getConnection();
		PreparedStatement statement = null;
		String sql = "UPDATE barbershop.servico SET descricao = '" + descricao + "', valor = " + valor + 
				" WHERE idservico = " + idservico + ";";
		try {
			statement = conexao.prepareStatement(sql);
			statement.executeUpdate();
			JOptionPane.showMessageDialog(null, "Modificado com sucesso");
		} catch (SQLException e) {
			JOptionPane.showMessageDialog(null, "Erro na atualização deste serviço no banco de dados");
		} finally {
			ConnectionFactory.closeConnection(conexao, statement);
		}		
	}
	
}

