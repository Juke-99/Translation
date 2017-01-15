package library.english.dataconnect;

public interface DataSQLDML {
	
	public int insert(String spell, String meaning, int pert);
	public int update(String spell, String meaning, int pert);
	public int delete(String spell);
}
