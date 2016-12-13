package library.english.dataconnect;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class UsedCounter extends DataConnection{
	private String SQL;
	
	@Override
	protected Connection getConnection() throws ClassNotFoundException, SQLException {
			Class.forName("com.mysql.jdbc.Driver");
			
			return DriverManager.getConnection("jdbc:mysql://localhost/translation?charactorEncoding=utf8","root","u");
	}
	
	public int EnglishWordCounter(String spell)
	{
		int count=0;
		SQL="update English set counter=counter+1 where spell=?";
		
		try
		(
			Connection con=getConnection();
			PreparedStatement ps=con.prepareStatement(SQL);
		){
			ps.setString(1,spell);
			
			count=ps.executeUpdate();
		}
		catch(SQLException e){
			SQLExceptionMessage(e);
		}
		catch(ClassNotFoundException e){
			e.printStackTrace();
		}
		
		return count;
	}
	
	public int EnglishPhraseCounter(String spell)
	{
		int count=0;
		SQL="update Phrase set Ph_counter=Ph_counter+1 where spell=?";
		
		try
		(
			Connection con=getConnection();
			PreparedStatement ps=con.prepareStatement(SQL);
		)
		{
			ps.setString(1,spell);
			
			count=ps.executeUpdate();
		}
		catch(SQLException e)
		{
			SQLExceptionMessage(e);
		}
		catch(ClassNotFoundException e)
		{
			e.printStackTrace();
		}
		
		return count;
	}
}
