

package com.guns.reporte.conflicto;
import java.util.LinkedList;

import org.afree.chart.ChartFactory;
import org.afree.chart.AFreeChart;
import org.afree.chart.axis.CategoryAxis;
import org.afree.chart.axis.CategoryLabelPositions;
import org.afree.chart.axis.NumberAxis;
import org.afree.chart.plot.CategoryPlot;
import org.afree.chart.plot.PlotOrientation;
import org.afree.chart.renderer.category.BarRenderer;
import org.afree.data.category.CategoryDataset;
import org.afree.data.category.DefaultCategoryDataset;
import org.afree.graphics.GradientColor;
import org.afree.graphics.SolidColor;
import android.content.Context;
import android.graphics.Color;

/**
* BarChartDemo01View
*/
public class ViewBarchart extends DemoView {

/**
 * constructor
 * @param context
 */
	private String titulo;	
	private String x="nulo";
	private String y="nulo";
public ViewBarchart(Context context,LinkedList<String> a,LinkedList<Integer> b,int tipo) {
    super(context);
    
	      titulo = "Coonflicto - Cantidad";
	      x = "Conflicto";
	      y = "Cantidad";
	
    CategoryDataset dataset = createDataset(a,b,tipo);
    AFreeChart chart = createChart(dataset,x,y,titulo);

    setChart(chart);
}

/**
 * Returns a sample dataset.
 *
 * @return The dataset.
 */
private static CategoryDataset createDataset(LinkedList<String> a,LinkedList<Integer> b,int tipo) {

    // row keys...
	 switch(tipo){
  	default:
  		DefaultCategoryDataset dataset = new DefaultCategoryDataset();
  		 while(!a.isEmpty()){
  			dataset.addValue(b.remove(), a.remove(), "");
	     }
  		 /*String series1 = "La Paz";
  		 String series2 = "Oruro";
  		 String series3 = "Sucre";
  		String series4 = "Potosi";
  		 String series5 = "Santa Cruz";
  		 String series6 = "Cochabamba";
  		 String series7 = "Tarija";
  		 String series8 = "Pando";
  		 String series9 = "Beni";
  		String category1 = "";   
  		

  	    
  	  dataset.addValue(1.0, series2, category1);
  	dataset.addValue(1.0, series3, category1);
  	dataset.addValue(1.0, series4, category1);
  	dataset.addValue(1.0, series5, category1);
  	dataset.addValue(1.0, series6, category1);
  	dataset.addValue(1.0, series7, category1);
  	dataset.addValue(1.0, series8, category1);
  	dataset.addValue(1.0, series9, category1);*/
  	 return dataset;
  		
	 }
	
	
    
    

    // create the dataset...
    
  

   /* dataset.addValue(5.0, series2, category1);
    dataset.addValue(7.0, series2, category2);
    dataset.addValue(6.0, series2, category3);
    dataset.addValue(8.0, series2, category4);
    dataset.addValue(4.0, series2, category5);

    dataset.addValue(4.0, series3, category1);
    dataset.addValue(3.0, series3, category2);
    dataset.addValue(2.0, series3, category3);
    dataset.addValue(3.0, series3, category4);
    dataset.addValue(6.0, series3, category5);*/

   

}

/**
 * Creates a sample chart.
 *
 * @param dataset  the dataset.
 *
 * @return The chart.
 */
private static AFreeChart createChart(CategoryDataset dataset,String x,String y,String titulo) {

    // create the chart...
    AFreeChart chart = ChartFactory.createBarChart(
        titulo,      // chart title
        x,               // domain axis label
        y,                  // range axis label
        dataset,                  // data
        PlotOrientation.VERTICAL, // orientation
        true,                     // include legend
        true,                     // tooltips?
        false                     // URLs?
    );

    // NOW DO SOME OPTIONAL CUSTOMISATION OF THE CHART...

    // set the background color for the chart...
    chart.setBackgroundPaintType(new SolidColor(Color.WHITE));

    // get a reference to the plot for further customisation...
    CategoryPlot plot = (CategoryPlot) chart.getPlot();

    // set the range axis to display integers only...
    NumberAxis rangeAxis = (NumberAxis) plot.getRangeAxis();
    rangeAxis.setStandardTickUnits(NumberAxis.createIntegerTickUnits());

    // disable bar outlines...
    BarRenderer renderer = (BarRenderer) plot.getRenderer();
    renderer.setDrawBarOutline(false);

    // set up gradient paints for series...
    GradientColor gp0 = new GradientColor(Color.BLUE, Color.rgb(0, 0, 64));
    GradientColor gp1 = new GradientColor(Color.GREEN, Color.rgb(0, 64, 0));
    GradientColor gp2 = new GradientColor(Color.RED, Color.rgb(64, 0, 0));
    renderer.setSeriesPaintType(0, gp0);
    renderer.setSeriesPaintType(1, gp1);
    renderer.setSeriesPaintType(2, gp2);

    CategoryAxis domainAxis = plot.getDomainAxis();
    domainAxis.setCategoryLabelPositions(
            CategoryLabelPositions.createUpRotationLabelPositions(
                    Math.PI / 6.0));
    // OPTIONAL CUSTOMISATION COMPLETED.

    return chart;

}
}


