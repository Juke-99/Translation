package library.english.dataconnect;

import java.sql.Connection;
import java.sql.SQLException;

public abstract class DataConnection {

	protected abstract Connection getConnection() throws ClassNotFoundException, SQLException;
	
	protected void SQLExceptionMessage(SQLException e) {
		System.out.println("------SQL分が間違っています。以下を参照------");
		e.printStackTrace();
		System.out.println("--------------------------------------");
	}
}
