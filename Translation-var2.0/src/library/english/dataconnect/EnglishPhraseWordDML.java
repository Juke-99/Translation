package library.english.dataconnect;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class EnglishPhraseWordDML extends DataConnection implements DataSQLDML {

	private String sql;
	
	@Override
	protected Connection getConnection() {
		try {
			Class.forName("com.mysql.jdbc.Driver");
			
			return DriverManager.getConnection("jdbc:mysql://localhost/translation?charactorEncoding=utf8", "root", "u");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
			return null;
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}
	}

	public ArrayList<EnglishPhrase> selectPhrase(String spell) {
		String spe, mean;
		sql = "SELECT spell,meaning FROM phrase WHERE spell LIKE ?";
		ArrayList<EnglishPhrase> list = new ArrayList<EnglishPhrase>();
		
		try(
			Connection con = getConnection();
			PreparedStatement ps = con.prepareStatement(sql);
		){
			ps.setString(1, spell + "%");
			ResultSet rs = ps.executeQuery();
			
			while(rs.next()) {
				spe = rs.getString("spell");
				mean = rs.getString("meaning");
				
				list.add(new EnglishPhrase(spe,mean));
			}
		} catch(SQLException e) {
			e.printStackTrace();
		}
		
		return list;
	}

	@Override
	public int insert(String spell, String meaning, int pert) {
		int count = 0;
		sql="INSERT INTO Phrase(spell,meaning) VALUES(?,?)";
		
		try	(
			Connection con = getConnection();
			PreparedStatement ps = con.prepareStatement(sql);
		){
			ps.setString(1, spell);
			ps.setString(2, meaning);
			
			count = ps.executeUpdate();
		} catch(SQLException e) {
			SQLExceptionMessage(e);
		}
		
		return count;
	}

	@Override
	public int update(String spell, String meaning, int pert_of) {
		int count=0;
		sql = "UPDATE English en INNER JOIN pert_of_speech pos ON en.pert_of_speechid=pos.pert_of_speechid SET meaning=?,en.pert_of_speechid=? WHERE spell=? AND en.pert_of_speechid=?";
		
		try(
			Connection con = getConnection();
			PreparedStatement ps = con.prepareStatement(sql);
		){
			ps.setString(1, meaning);
			ps.setInt(2, pert_of);
			ps.setString(3, spell);
			ps.setInt(4, pert_of);
			
			count = ps.executeUpdate();
		} catch(SQLException e) {
			e.printStackTrace();
		}
		
		return count;
	}

	@Override
	public int delete(String spell) {
		int count=0;
		sql = "DELETE FROM English WHERE spell=?";
		
		try	(
			Connection con=getConnection();
			PreparedStatement ps=con.prepareStatement(sql);
		){
			ps.setString(1,spell);
			
			count=ps.executeUpdate();
		} catch(SQLException e)	{
			e.printStackTrace();
		}
		
		return count;
	}
}
