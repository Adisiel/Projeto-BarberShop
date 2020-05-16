package model.DAO;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;

import connection.ConnectionFactory;
import model.bean.Cliente;

public class ClienteDAO {

	public void create(Cliente c) {
		Connection conexao = ConnectionFactory.getConnection();
		PreparedStatement statement = null;

		Date data = Date.valueOf(c.getData_nascimento());
		
		try { 
			String sql = "INSERT INTO cliente(nome,cpf,email,rg,telefone,data_nascimento,endereco) VALUES(?,?,?,?,?,?,?)";		
			statement = conexao.prepareStatement(sql);
			statement.setString(1, c.getNome());
			statement.setString(2, c.getCpf());
			statement.setString(3, c.getEmail());
			statement.setString(4, c.getRg());
			statement.setString(5, c.getTelefone());
			statement.setDate(6, data);
			statement.setInt(7, c.getEndereco().getId());
			statement.executeUpdate();
			JOptionPane.showMessageDialog(null, "Salvo com sucesso");
		} catch (SQLException ex) {
			JOptionPane.showMessageDialog(null, "Erro na criação e gravação deste cliente no banco de dados");
		} finally {
			ConnectionFactory.closeConnection(conexao, statement);
		}
	}

	public List<Cliente> selectAll () {	 
		EnderecoDAO endDAO = new EnderecoDAO();
		String sql = "SELECT * FROM cliente";
		List<Cliente> clientes = new ArrayList<Cliente>();	 
		Connection conexao = ConnectionFactory.getConnection();
		PreparedStatement statement = null;
		ResultSet rs = null;	 
		try {
			statement = conexao.prepareStatement(sql);	 
			rs = statement.executeQuery();		 
			while(rs.next()) {	 
				Cliente c = new Cliente();
				c.setId(rs.getInt("idcliente"));
				c.setCpf(rs.getString("cpf"));
				LocalDate date = rs.getDate("data_nascimento").toLocalDate();
				c.setData_nascimento(date);
				c.setEmail(rs.getString("email"));
				c.setNome(rs.getString("nome"));
				c.setTelefone(rs.getString("telefone"));
				c.setRg(rs.getString("rg"));				
				c.setEndereco(endDAO.selectByID(c.getId()));
				clientes.add(c);
			}
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "Erro na seleção de todos os clientes no banco de dados");
		} finally {
			ConnectionFactory.closeConnection(conexao, statement, rs);
		}
		return clientes;
	}

	public Cliente selectByNome (String nomeCliente) {	 
		EnderecoDAO endDAO = new EnderecoDAO();
		String sql = "select * from barbershop.cliente where nome = '" + nomeCliente + "';";
		Cliente c = new Cliente();	 
		Connection conexao = ConnectionFactory.getConnection();
		PreparedStatement statement = null;
		ResultSet rs = null;	 
		try {
			statement = conexao.prepareStatement(sql);	 
			rs = statement.executeQuery();		 
			while(rs.next()) {	 
				c.setId(rs.getInt("idcliente"));
				c.setCpf(rs.getString("cpf"));
				Date d = rs.getDate("data_nascimento");
				LocalDate data = d.toLocalDate();
				c.setData_nascimento(data);
				c.setEmail(rs.getString("email"));
				c.setTelefone(rs.getString("telefone"));
				c.setNome(rs.getString("nome"));
				c.setRg(rs.getString("rg"));				
				c.setEndereco(endDAO.selectByID(c.getId()));
				break;
			}
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "Erro na seleção deste cliente no banco de dados");
		} finally {
			ConnectionFactory.closeConnection(conexao, statement, rs);
		}
		return c;
	}

	public Cliente selectByID (int idAgendamento) {
		
		String sql = "SELECT idcliente, nome, cpf, email, rg, telefone, data_nascimento, endereco FROM barbershop.cliente as A " +
				"INNER JOIN barbershop.agendamento as B on A.idcliente = B.cliente " +
				"where idagendamento = " + Integer.toString(idAgendamento) + ";";
		Cliente c = new Cliente(); 
		EnderecoDAO endDAO = new EnderecoDAO();
		Connection conexao = ConnectionFactory.getConnection();
		PreparedStatement statement = null;
		ResultSet rs = null;	 
		try {
			statement = conexao.prepareStatement(sql);	 
			rs = statement.executeQuery();		 
			while(rs.next()) {	 
				c.setId(rs.getInt("idcliente"));
				c.setNome(rs.getString("nome"));
				c.setCpf(rs.getString("cpf"));
				Date d = rs.getDate("data_nascimento");
				LocalDate date = d.toLocalDate();
				c.setData_nascimento(date);
				c.setEmail(rs.getString("email"));
				c.setRg(rs.getString("rg"));
				c.setTelefone(rs.getString("telefone"));
				c.setEndereco(endDAO.selectByID(c.getId()));
			}
		} catch (Exception ex) {
			JOptionPane.showMessageDialog(null, "Erro na remoção deste cliente no banco de dados");
		} finally {
			ConnectionFactory.closeConnection(conexao, statement, rs);
		}
		return c;
	}
		
	public void removeByID(int idCliente) {
		Connection conexao = ConnectionFactory.getConnection();
		PreparedStatement statement = null;
		String sql = "DELETE FROM barbershop.cliente WHERE idcliente = " + idCliente + ";";
		try {
			statement = conexao.prepareStatement(sql);
			statement.executeUpdate();
			JOptionPane.showMessageDialog(null, "Deletado com sucesso");
		} catch (SQLException e) {
			JOptionPane.showMessageDialog(null, "Erro na seleção deste cliente no banco de dados");
		} finally {
			ConnectionFactory.closeConnection(conexao, statement);
		}	
	}
	
	public void updateByID(int idCliente, String nome, String telefone, String email, LocalDate data, String cidade, 
			String bairro, String rua, String complemento, int numero) {
		EnderecoDAO eDAO = new EnderecoDAO();
		Connection conexao = ConnectionFactory.getConnection();
		PreparedStatement statement = null;
		Date d = Date.valueOf(data);
		String sql = "UPDATE barbershop.cliente SET nome = '" + nome + "', data_nascimento = DATE('" + d +
				"'), email = '" + email + "', telefone = '" + telefone + "' WHERE idcliente = " + idCliente + ";";
		try {
			statement = conexao.prepareStatement(sql);
			statement.executeUpdate();
			eDAO.updateByID(eDAO.selectByID(idCliente).getId(), cidade, bairro, rua, complemento, numero);
			JOptionPane.showMessageDialog(null, "Modificado com sucesso");
		} catch (SQLException e) {
			JOptionPane.showMessageDialog(null, "Erro na atualização deste cliente no banco de dados");
		} finally {
			ConnectionFactory.closeConnection(conexao, statement);
		}		
	}
	
}
