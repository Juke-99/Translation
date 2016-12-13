package library.english.dataconnect;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class EnglishPhraseWordDML extends DataConnection implements DataSQLDML{

	private String SQL;
	
	@Override
	protected Connection getConnection() throws ClassNotFoundException, SQLException {
		try {
			Class.forName("com.mysql.jdbc.Driver");
			
			return DriverManager.getConnection("jdbc:mysql://localhost/translation?charactorEncoding=utf8","root","u");
		}
		catch (ClassNotFoundException e) {
			e.printStackTrace();
			return null;
		}
		catch (SQLException e) {
			e.printStackTrace();
			return null;
		}
	}
	
	@Override
	public ArrayList<English> select(String spell) {
		// TODO 自動生成されたメソッド・スタブ
		return null;
	}

	@Override
	public ArrayList<EnglishPhrase> selectPhrase(String spell) {
		String spe,mean;
		SQL="select spell,meaning from phrase where spell like ?";
		ArrayList<EnglishPhrase> list=new ArrayList<EnglishPhrase>();
		
		try
		(
			Connection con=getConnection();
			PreparedStatement ps=con.prepareStatement(SQL);
		){
			ps.setString(1,spell+"%");
			ResultSet rs=ps.executeQuery();
			
			while(rs.next())
			{
				spe=rs.getString("spell");
				mean=rs.getString("meaning");
				
				list.add(new EnglishPhrase(spe,mean));
			}
		}
		catch(SQLException e){
			e.printStackTrace();
		}
		catch (ClassNotFoundException e){
			e.printStackTrace();
		}
		
		return list;
	}

	@Override
	public int insert(String spell, String meaning, int pert) {
		int count=0;
		SQL="insert into Phrase(spell,meaning) values(?,?)";
		
		try
		(
			Connection con=getConnection();
			PreparedStatement ps=con.prepareStatement(SQL);
		){
			ps.setString(1,spell);
			ps.setString(2,meaning);
			
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

	@Override
	public int update(String spell, String meaning, int pert) {
		// TODO 自動生成されたメソッド・スタブ
		return 0;
	}

	@Override
	public int delete(String spell) {
		// TODO 自動生成されたメソッド・スタブ
		return 0;
	}
}
