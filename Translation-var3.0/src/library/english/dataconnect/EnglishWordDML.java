package library.english.dataconnect;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class EnglishWordDML extends DataConnection implements DataSQLDML {

	private String sql;
	
	@Override
	public Connection getConnection() {
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

	public ArrayList<English> select(String spell) {
		String[] word = spell.split("[ 　]+", 0);
		String spe, mean, pert;
		sql = "SELECT spell,meaning,pert_of_speechname FROM English en INNER JOIN pert_of_speech pos ON en.pert_of_speechid=pos.pert_of_speechid WHERE en.spell LIKE ? OR en.meaning LIKE ?";
		ArrayList<English> list=new ArrayList<English>();
		
		try	(
			Connection con = getConnection();
		){
			if(word.length > 1) {
				for(int j = 1; j < word.length; j++) {
					sql += " OR en.spell LIKE ? OR en.meaning LIKE ?";
				}
			}
			
			PreparedStatement ps = con.prepareStatement(sql);
			
			for(int i = 0; i < word.length; i=+2)
			{
				ps.setString(i + 1, word[i]);
				ps.setString(i + 2, word[i]);
			}
			
			ResultSet rs = ps.executeQuery();
			
			while(rs.next())
			{
				spe=rs.getString("spell");
				mean=rs.getString("meaning");
				pert=rs.getString("pert_of_speechname");
				
				list.add(new English(spe, mean, pert));
			}
		}
		catch(SQLException e){
			e.printStackTrace();
		}
		
		return list;
	}

	@Override
	public int insert(String spell, String meaning, int pert) {
		int count = 0;
		sql = "INSERT INTO English(spell,meaning,pert_of_speechid) VALUES(?,?,?)";
		
		try(
			Connection connection=getConnection();
			PreparedStatement ps=connection.prepareStatement(sql);
		){
			ps.setString(1, spell);
			ps.setString(2, meaning);
			ps.setInt(3, pert);
			
			count = ps.executeUpdate();
		} catch(SQLException e) {
			SQLExceptionMessage(e);
		}
		
		return count;
	}

	@Override
	public int update(String spell, String meaning, int pert) {
		int count = 0;
		sql = "UPDATE English en INNER JOIN pert_of_speech pos ON en.pert_of_speechid=pos.pert_of_speechid SET meaning=?,en.pert_of_speechid=? WHERE spell=? AND en.pert_of_speechid=?";
		
		try (
			Connection con = getConnection();
			PreparedStatement ps = con.prepareStatement(sql);
		){
			ps.setString(1, meaning);
			ps.setInt(2, pert);
			ps.setString(3, spell);
			ps.setInt(4, pert);
			
			count = ps.executeUpdate();
		} catch(SQLException e){
			SQLExceptionMessage(e);
		}
		
		return count;
	}

	@Override
	public int delete(String spell) {
		int count = 0;
		sql = "DELETE FROM English WHERE spell=?";
		
		try (
			Connection con = getConnection();
			PreparedStatement ps = con.prepareStatement(sql);
		){
			ps.setString(1, spell);
			
			count = ps.executeUpdate();
		} catch(SQLException e){
			SQLExceptionMessage(e);
		}
		
		return count;
	}
}
