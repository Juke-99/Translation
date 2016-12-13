package lib.english.database;

public abstract class DatabaseConnection {
	protected static com.mysql.jdbc.Connection getConnection()
	{	
		Class.forName("com.mysql.jdbc.Driver");
		
		return DriverManager.getConnection("jdbc:mysql://localhost/translation?charactorEncoding=utf8","root","u");
	}
}
