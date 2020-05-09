package Connection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class ConnectionFactory {
	private static final String URL = "jdbc:mysql://localhost:3306/barbershop?useTimezone=true&serverTimezone=UTC&useSSL=false";
	private static final String USER = "root";
	private static final String PASSWORD = "Paraquedas10!";
	
	
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
