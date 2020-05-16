package model.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JOptionPane;

import connection.ConnectionFactory;
import model.bean.Endereco;

public class EnderecoDAO {

	public int create(Endereco e) {
		int idEndereco = 0;
		Connection conexao = ConnectionFactory.getConnection();
		PreparedStatement statement = null;
		try {
			String sql = "INSERT INTO endereco(cidade,bairro,rua,complemento,numero) VALUES(?,?,?,?,?)";		
			statement = conexao.prepareStatement(sql, PreparedStatement.RETURN_GENERATED_KEYS);
			statement.setString(1, e.getCidade());
			statement.setString(2, e.getBairro());
			statement.setString(3, e.getRua());
			statement.setString(4, e.getComplemento());
			statement.setInt(5, e.getNumero());
			statement.executeUpdate();
			ResultSet rs = statement.getGeneratedKeys();

			while(rs.next()){
				idEndereco = rs.getInt(1);
			};
			JOptionPane.showMessageDialog(null, "Salvo com sucesso");
		} catch (SQLException ex) {
			JOptionPane.showMessageDialog(null, "Erro na criação e gravação deste endereço no banco de dados");
		} finally {
			ConnectionFactory.closeConnection(conexao, statement);
		}
		return idEndereco;
	}

	public Endereco selectByID (int idcliente) {	 
		String sql = "SELECT idendereco,cidade,bairro,rua,complemento,numero FROM barbershop.endereco as A " +
				"INNER JOIN barbershop.cliente as B on A.idendereco = B.endereco " +
				"where idcliente = " +  Integer.toString(idcliente) + ";";

		Endereco e = new Endereco(); 
		Connection conexao = ConnectionFactory.getConnection();
		PreparedStatement statement = null;
		ResultSet rs = null;	 
		try {
			statement = conexao.prepareStatement(sql);	 
			rs = statement.executeQuery();		 
			while(rs.next()) {	 
				e.setId(rs.getInt("idendereco"));
				e.setComplemento(rs.getString("complemento"));
				e.setBairro(rs.getString("bairro"));
				e.setCidade(rs.getString("cidade"));
				e.setRua(rs.getString("rua"));
				e.setNumero(rs.getInt("numero"));
			}
		} catch (Exception ex) {
			JOptionPane.showMessageDialog(null, "Erro na seleção deste endereço no banco de dados");
		} finally {
			ConnectionFactory.closeConnection(conexao, statement, rs);
		}
		return e;
	}

	public void updateByID(int idEndereco, String cidade, String bairro, String rua, String complemento, int numero) {
		Connection conexao = ConnectionFactory.getConnection();
		PreparedStatement statement = null;
		String sql = "UPDATE barbershop.endereco SET cidade = '" + cidade + "', bairro = '" + bairro + "', rua = '" + rua +
				"', complemento = '" + complemento + "', numero = " + numero + " WHERE idendereco = " + idEndereco + ";";
		try {
			statement = conexao.prepareStatement(sql);
			statement.executeUpdate();
		} catch (SQLException e) {
			JOptionPane.showMessageDialog(null, "Erro na atualização deste endereço no banco de dados");
		} finally {
			ConnectionFactory.closeConnection(conexao, statement);
		}			
	}

}
