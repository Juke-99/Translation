package library.english.dataconnect;

import java.util.ArrayList;

public interface DataSQLDML {
	
	public ArrayList<English> select(String spell);
	public ArrayList<EnglishPhrase> selectPhrase(String spell);
	public int insert(String spell,String meaning,int pert);
	public int update(String spell,String meaning,int pert);
	public int delete(String spell);
}
