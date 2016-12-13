package trans.lang.en;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.StandardChartTheme;
import org.jfree.data.category.DefaultCategoryDataset;

public class DiagramAsetdata extends DatabaseConnection{
	
	public DefaultCategoryDataset DIagramAsetdata() throws SQLException, ClassNotFoundException{
		String spell;
		int counter;
		String sql="select spell,counter from English where spell like ?";
		DefaultCategoryDataset dataset = new DefaultCategoryDataset();
		ChartFactory.setChartTheme(StandardChartTheme.createLegacyTheme());
		
		try(Connection con=DatabaseConnection.getConnection();){
			
			PreparedStatement ps=con.prepareStatement(sql);
			
			ps.setString(1,"a%");
			ResultSet rs=ps.executeQuery();
			
			while(rs.next())
			{
				spell=rs.getString("spell");
				counter=rs.getInt("counter");
				
				dataset.addValue(counter,"回数",spell);
			}
		}
		
		return dataset;
	}
}
