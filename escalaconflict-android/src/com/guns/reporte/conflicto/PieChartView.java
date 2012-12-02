package com.guns.reporte.conflicto;

import java.util.LinkedList;

import org.afree.chart.AFreeChart;
import org.afree.chart.ChartFactory;
import org.afree.chart.plot.PiePlot;
import org.afree.chart.title.TextTitle;
import org.afree.data.general.DefaultPieDataset;
import org.afree.data.general.PieDataset;
import org.afree.graphics.geom.Font;

import android.content.Context;
import android.graphics.Typeface;

public class PieChartView extends DemoView {

    /**
     * constructor
     * @param context
     */
private String titulo;	
    public PieChartView(Context context,LinkedList<String> a,LinkedList<Integer> b,int tipo) {
        super(context);
        
    		 titulo = "Tipo Conflicto";
    	
        final PieDataset dataset = createDataset(a,b,tipo);
        final AFreeChart chart = createChart(dataset,titulo);

        setChart(chart);
    }

    /**
     * Creates a sample dataset.
     * @return a sample dataset.
     */
    private static PieDataset createDataset(LinkedList<String> a,LinkedList<Integer> b,int tipo) {
    	DefaultPieDataset dataset = new DefaultPieDataset();
    	     while(!a.isEmpty()){
    	    	 dataset.setValue(a.remove(),b.remove());
    	     }
     		
            /*dataset.setValue("La Paz", new Double(5.2));
            dataset.setValue("Oruro", new Double(2.0));
            dataset.setValue("Santa Cruz", new Double(7.5));
            dataset.setValue("Beni", new Double(17.5));
            dataset.setValue("Pando", new Double(11.0));
            dataset.setValue("Potosi", new Double(19.4));
            dataset.setValue("Sucre", new Double(19.4));
            dataset.setValue("Tarija", new Double(19.4));
            dataset.setValue("Pando", new Double(19.4));    */  
     		
     		
     	
     	
        
        return dataset;
    }

    /**
     * Creates a chart.
     * @param dataset the dataset.
     * @return a chart.
     */
    private static AFreeChart createChart(PieDataset dataset,String a) {

        AFreeChart chart = ChartFactory.createPieChart(
                        a, // chart title
                dataset, // data
                true, // include legend
                true,
                false);
        TextTitle title = chart.getTitle();
        title.setToolTipText("A title tooltip!");
        PiePlot plot = (PiePlot) chart.getPlot();
        plot.setLabelFont(new Font("SansSerif", Typeface.NORMAL, 12));
        plot.setNoDataMessage("No data available");
        plot.setCircular(false);
        plot.setLabelGap(0.02);
        return chart;

    }
}

