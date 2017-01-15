package library.english.dataconnect;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class UsedCounter extends DataConnection{
	private String sql;
	
	@Override
	protected Connection getConnection() throws ClassNotFoundException, SQLException {
			Class.forName("com.mysql.jdbc.Driver");
			
			return DriverManager.getConnection("jdbc:mysql://localhost/translation?charactorEncoding=utf8", "root", "u");
	}
	
	public int EnglishWordCounter(String spell) {
		int count = 0;
		sql = "UPDATE English SET counter=counter+1 WHERE spell=?";
		
		try (
			Connection con=getConnection();
			PreparedStatement ps=con.prepareStatement(sql);
		){
			ps.setString(1, spell);
			
			count = ps.executeUpdate();
		}
		catch(SQLException e){
			SQLExceptionMessage(e);
		}
		catch(ClassNotFoundException e){
			e.printStackTrace();
		}
		
		return count;
	}
	
	public int EnglishPhraseCounter(String spell) {
		int count = 0;
		sql = "UPDATE Phrase SET Ph_counter=Ph_counter+1 WHERE spell=?";
		
		try(
			Connection con = getConnection();
			PreparedStatement ps = con.prepareStatement(sql);
		){
			ps.setString(1, spell);
			
			count=ps.executeUpdate();
		} catch(SQLException e)	{
			SQLExceptionMessage(e);
		} catch(ClassNotFoundException e) {
			e.printStackTrace();
		}
		
		return count;
	}
}
