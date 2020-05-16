package model.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;

import connection.ConnectionFactory;
import model.bean.Usuario;

public class UsuarioDAO {

	public List<Usuario> selectAll () {	 
		String sql = "SELECT * FROM usuario";
		List<Usuario> usuarios = new ArrayList<Usuario>();	 
		Connection conexao = ConnectionFactory.getConnection();
		PreparedStatement statement = null;
		ResultSet rs = null;	 
		try {
			statement = conexao.prepareStatement(sql);	 
			rs = statement.executeQuery();		 
			while(rs.next()) {	 
				Usuario u = new Usuario();
				u.setId(rs.getInt("idusuario"));
				u.setNome(rs.getString("nome"));
				u.setUser(rs.getString("user"));
				u.setPassword(rs.getString("password"));
				usuarios.add(u);
			}
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "Erro na seleção de todos os usuários no banco de dados");
		} finally {
			ConnectionFactory.closeConnection(conexao, statement, rs);
		}
		return usuarios;
	}

}
