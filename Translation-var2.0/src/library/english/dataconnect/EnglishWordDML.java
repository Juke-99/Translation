package library.english.dataconnect;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class EnglishWordDML extends DataConnection implements DataSQLDML{

	private String SQL;
	
	@Override
	public Connection getConnection(){
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
		String[] word = spell.split("[ 　]+", 0);
		String spe,mean,pert;
		SQL="select spell,meaning,pert_of_speechname from English en inner join pert_of_speech pos on en.pert_of_speechid=pos.pert_of_speechid where en.spell like ?";
		ArrayList<English> list=new ArrayList<English>();
		
		try
		(
			Connection con=getConnection();
		){
			if(word.length>1)
			{
				for(int j=1;j<word.length;j++)
				{
					SQL+=" or spell like ?";
				}
			}
			
			PreparedStatement ps=con.prepareStatement(SQL);
			
			for(int i=0;i<word.length;i++)
			{
				ps.setString(i+1,word[i]);
			}
			
			ResultSet rs=ps.executeQuery();
			
			while(rs.next())
			{
				spe=rs.getString("spell");
				mean=rs.getString("meaning");
				pert=rs.getString("pert_of_speechname");
				
				list.add(new English(spe,mean,pert));
			}
		}
		catch(SQLException e){
			e.printStackTrace();
		}
		
		return list;
	}

	@Override
	public int insert(String spell, String meaning, int pert) {
		int count=0;
		SQL="insert into English(spell,meaning,pert_of_speechid) values(?,?,?)";
		
		try(
			Connection connection=getConnection();
			PreparedStatement ps=connection.prepareStatement(SQL);
		){
			ps.setString(1,spell);
			ps.setString(2,meaning);
			ps.setInt(3,pert);
			
			count=ps.executeUpdate();
		}
		catch(SQLException e){
			SQLExceptionMessage(e);
		}
		
		return count;
	}

	@Override
	public int update(String spell, String meaning, int pert) {
		int count=0;
		SQL="update English en inner join pert_of_speech pos on en.pert_of_speechid=pos.pert_of_speechid set meaning=?,en.pert_of_speechid=? where spell=? and en.pert_of_speechid=?";
		
		try
		(
			Connection con=getConnection();
			PreparedStatement ps=con.prepareStatement(SQL);
		){
			ps.setString(1,meaning);
			ps.setInt(2,pert);
			ps.setString(3,spell);
			ps.setInt(4,pert);
			
			count=ps.executeUpdate();
		}
		catch(SQLException e){
			SQLExceptionMessage(e);
		}
		
		return count;
	}

	@Override
	public int delete(String spell) {
		int count=0;
		SQL="delete from English where spell=?";
		
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
		
		return count;
	}

	@Override
	public ArrayList<EnglishPhrase> selectPhrase(String spell) {
		// TODO 自動生成されたメソッド・スタブ
		return null;
	}
}
