package trans.lang.diagram;

import java.awt.Font;
import java.io.File;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartUtilities;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.StandardChartTheme;
import org.jfree.chart.axis.CategoryAxis;
import org.jfree.chart.axis.CategoryLabelPositions;
import org.jfree.chart.axis.NumberAxis;
import org.jfree.chart.plot.CategoryPlot;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.chart.renderer.category.BarRenderer;
import org.jfree.data.category.DefaultCategoryDataset;

import trans.lang.en.DatabaseConnection;

public class DiagramA extends DatabaseConnection{
	public static void main(String[] args) throws SQLException, ClassNotFoundException{
		
		String spell;
		int counter;
		String sql="select spell,counter from English where spell like ?";
		DefaultCategoryDataset dataset = new DefaultCategoryDataset();
		ChartFactory.setChartTheme(StandardChartTheme.createLegacyTheme());
		
		try(Connection con=DatabaseConnection.getConnection();)
		{
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
	
		// （2）JFreeChartオブジェクトの生成
		JFreeChart chart = ChartFactory.createBarChart("英単語使用頻度表","スぺル", "使用回数", dataset, PlotOrientation.VERTICAL, true,true, false);
		chart.getCategoryPlot().getDomainAxis().setTickLabelFont(new Font(Font.DIALOG, Font.ITALIC, 20));
		
		final CategoryPlot plot = chart.getCategoryPlot();
		final NumberAxis rangeAxis = (NumberAxis) plot.getRangeAxis();
		final CategoryAxis domainAxis = plot.getDomainAxis();
		BarRenderer renderer = (BarRenderer)plot.getRenderer();
		renderer.setItemMargin(0.6);
		
		rangeAxis.setStandardTickUnits(NumberAxis.createIntegerTickUnits());
		domainAxis.setCategoryLabelPositions(CategoryLabelPositions.createUpRotationLabelPositions(Math.PI / 4.0));
		
		// （3）グラフの出力
		File outputFile = new File("./WebContent/Image/SampleBarChart.png");
		try{
			ChartUtilities.saveChartAsPNG(outputFile, chart, 1000, 1000);
		}
		catch(IOException ioEx){
			ioEx.printStackTrace();
		}
	}
}
