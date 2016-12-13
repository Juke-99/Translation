package trans.lang.en;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartFrame;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.category.CategoryDataset;
import org.jfree.data.jdbc.JDBCCategoryDataset;

import com.mysql.jdbc.Connection;

public class JDBCConnect {
	
	CategoryDataset categoryDataset;
	JFreeChart chart;
	Connection con;
	
	//private Connection getConnection() throws ClassNotFoundException,SQLException
	//{	
		static{try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}}
		
		//return DriverManager.getConnection("jdbc:mysql://localhost/translation?charactorEncoding=utf8","root","u");
	//}
	
	public JDBCConnect() throws ClassNotFoundException, SQLException{
		categoryDataset=new JDBCCategoryDataset(con,"select spell,counter from English");
	}
	
	void initChart(){
		chart= ChartFactory.createBarChart("蜊倩ｪ樔ｽｿ逕ｨ蝗樊焚","蜊倩ｪ�","菴ｿ逕ｨ蝗樊焚",categoryDataset, PlotOrientation.VERTICAL,true, true, true);
	}
	
	void display(){
		ChartFrame frame = new ChartFrame ("Using of Word", chart);
		frame.setSize(500, 500);
		frame.setVisible(true);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
}
