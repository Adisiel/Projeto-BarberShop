package Connection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class ConnectionFactory {
	// Configurar para seu servidor MySQL
	private static final String URL = "";
	private static final String USER = "";
	private static final String PASSWORD = "";
	
	
	public static Connection getConnection() {
        try {
            return DriverManager.getConnection(URL, USER, PASSWORD);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
	
	public static void closeConnection(Connection conexao) {
		try {
			if (conexao != null) {
				conexao.close();
			}
		} catch (SQLException e) {
			throw new RuntimeException(e);
        }
    }
	
	public static void closeConnection(Connection conexao, PreparedStatement statement) {
		closeConnection(conexao);		
		try {
			if (statement != null) {
				statement.close();
			}
		} catch (SQLException e) {
			throw new RuntimeException(e);
        }
    }
	
	public static void closeConnection(Connection conexao, PreparedStatement statement, ResultSet result) {
		closeConnection(conexao, statement);		
		try {
			if (result != null) {
				result.close();
			}
		} catch (SQLException e) {
			throw new RuntimeException(e);
        }
	}
}
