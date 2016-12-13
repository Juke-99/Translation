package trans.lang.en;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class EnglishDataAccess {
	
	private Connection getConnection() throws ClassNotFoundException,SQLException
	{	
		Class.forName("com.mysql.jdbc.Driver");
		
		return DriverManager.getConnection("jdbc:mysql://localhost/translation?charactorEncoding=utf8","root","u");
	}
	
	public int insert(String spell,String imi,int pert)
	{
		int count=0;
		
		try(
			Connection con=getConnection();
			PreparedStatement ps=con.prepareStatement("insert into English(spell,meaning,pert_of_speechid) values(?,?,?)");
		){
			ps.setString(1,spell);
			ps.setString(2,imi);
			ps.setInt(3,pert);
			
			count=ps.executeUpdate();
		}
		catch(SQLException e){
			e.printStackTrace();
		}
		catch(ClassNotFoundException e){
			e.printStackTrace();
		}
		
		return count;
	}
	
	public int insertPhrase(String spell,String imi)
	{
		int count=0;
		
		try
		(
			Connection con=getConnection();
			PreparedStatement ps=con.prepareStatement("insert into Phrase(spell,meaning) values(?,?)");
		)
		{
			ps.setString(1,spell);
			ps.setString(2,imi);
			
			count=ps.executeUpdate();
		}
		catch(SQLException e)
		{
			e.printStackTrace();
		}
		catch(ClassNotFoundException e)
		{
			e.printStackTrace();
		}
		
		return count;
	}
	
	public int update(String spell,String meaning,int pert_of)
	{
		int count=0;
		
		try
		(
			Connection con=getConnection();
			PreparedStatement ps=con.prepareStatement("update English en inner join pert_of_speech pos on en.pert_of_speechid=pos.pert_of_speechid set meaning=?,en.pert_of_speechid=? where spell=? and en.pert_of_speechid=?");
		)
		{
			ps.setString(1,meaning);
			ps.setInt(2,pert_of);
			ps.setString(3,spell);
			ps.setInt(4,pert_of);
			
			count=ps.executeUpdate();
		}
		catch(SQLException e)
		{
			e.printStackTrace();
		}
		catch(ClassNotFoundException e)
		{
			e.printStackTrace();
		}
		
		return count;
	}
	
	public int spellCounterEn(String spell)
	{
		int count=0;
		
		try
		(
			Connection con=getConnection();
			PreparedStatement ps=con.prepareStatement("update English set counter=counter+1 where spell=?");
		)
		{
			ps.setString(1,spell);
			
			count=ps.executeUpdate();
		}
		catch(SQLException e)
		{
			e.printStackTrace();
		}
		catch(ClassNotFoundException e)
		{
			e.printStackTrace();
		}
		
		return count;
	}
	
	public int spellCounterPh(String spell)
	{
		int count=0;
		
		try
		(
			Connection con=getConnection();
			PreparedStatement ps=con.prepareStatement("update Phrase set Ph_counter=Ph_counter+1 where spell=?");
		)
		{
			ps.setString(1,spell);
			
			count=ps.executeUpdate();
		}
		catch(SQLException e)
		{
			e.printStackTrace();
		}
		catch(ClassNotFoundException e)
		{
			e.printStackTrace();
		}
		
		return count;
	}
	
	public int delete(String spell)
	{
		int count=0;
		
		try
		(
			Connection con=getConnection();
			PreparedStatement ps=con.prepareStatement("delete from English where spell=?")	;
		)
		{
			ps.setString(1,spell);
			
			count=ps.executeUpdate();
		}
		catch(SQLException e)
		{
			e.printStackTrace();
		}
		catch(ClassNotFoundException e)
		{
			e.printStackTrace();
		}
		
		return count;
	}
	
	public ArrayList<English> select(String spell)
	{
		String[] word = spell.split("[ 　]+", 0);
		String spe,mean,pert;
		String sql="select spell,meaning,pert_of_speechname from English en inner join pert_of_speech pos on en.pert_of_speechid=pos.pert_of_speechid where en.spell like ?";
		ArrayList<English> list=new ArrayList<English>();
		
		try
		(
			Connection con=getConnection();
		)
		{
			if(word.length>1)
			{
				for(int j=1;j<word.length;j++)
				{
					sql+=" or spell like ?";
				}
			}
			
			PreparedStatement ps=con.prepareStatement(sql);
			
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
		catch(SQLException e)
		{
			e.printStackTrace();
		}
		catch (ClassNotFoundException e1) 
		{
			// TODO 自動生成された catch ブロック
			e1.printStackTrace();
		}
		
		return list;
	}
	
	public ArrayList<EnglishPhrase> selectPhrase(String spell)
	{
		String spe,mean;
		String sql="select spell,meaning from phrase where spell like ?";
		ArrayList<EnglishPhrase> list=new ArrayList<EnglishPhrase>();
		
		try
		(
			Connection con=getConnection();
			PreparedStatement ps=con.prepareStatement(sql);
		)
		{
			ps.setString(1,spell+"%");
			ResultSet rs=ps.executeQuery();
			
			while(rs.next())
			{
				spe=rs.getString("spell");
				mean=rs.getString("meaning");
				
				list.add(new EnglishPhrase(spe,mean));
			}
		}
		catch(SQLException e)
		{
			e.printStackTrace();
		}
		catch (ClassNotFoundException e1) 
		{
			// TODO 自動生成された catch ブロック
			e1.printStackTrace();
		}
		
		return list;
	}
	
	public ArrayList<Count> selectcount()
	{
		int count;
		String sql="select spell,counter from English where spell like ?";
		ArrayList<Count> list=new ArrayList<Count>();
		
		try
		(
			Connection con=getConnection();
		)
		{
			
			PreparedStatement ps=con.prepareStatement(sql);
			ps.setString(1,"a%");
			
			ResultSet rs=ps.executeQuery();
			
			while(rs.next())
			{
				count=rs.getInt("counter");
				
				list.add(new Count(count));
			}
		}
		catch(SQLException e)
		{
			e.printStackTrace();
		}
		catch (ClassNotFoundException e1) 
		{
			// TODO 自動生成された catch ブロック
			e1.printStackTrace();
		}
		
		return list;
	}
}
