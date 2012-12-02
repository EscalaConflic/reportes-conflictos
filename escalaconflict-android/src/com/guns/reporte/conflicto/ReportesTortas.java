package com.guns.reporte.conflicto;

import java.util.ArrayList;
import java.util.LinkedList;

import org.apache.http.NameValuePair;
import org.apache.http.message.BasicNameValuePair;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Typeface;
import android.os.Bundle;  
import android.util.Log;
import android.view.View;
import android.view.Window;
import android.widget.ArrayAdapter;    
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

public class ReportesTortas extends Activity{
	Spinner periodo;
	Spinner tipochart;
	Spinner indicador;
	SharedPreferences datos;
	Button seguir;
	LinkedList<String> listaTipo = new LinkedList<String>();
	LinkedList<Integer> listaCantidad = new LinkedList<Integer>();
	String MES_CONFLICTO;
	int TIPO_CONSULTA;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.tortas);
		periodo = (Spinner) findViewById(R.id.spinner1);
		tipochart = (Spinner) findViewById(R.id.spinner2);
		//indicador = (Spinner) findViewById(R.id.spinner3);
		
		String[] periodoL =new String[] {"Julio","Agosto","Septiembre"};
		String[] tipochartL =new String[] {"Tipo Torta","Tipo Lineal"};
		String[] indicadorL =new String[] {"Pais-conflictos","Ciudad-N conflictos","Campo de Conflicto","Tipo de Conflicto"};
		ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,
				android.R.layout.simple_spinner_item, periodoL);
		adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
		ArrayAdapter<String> adapter2 = new ArrayAdapter<String>(this,
				android.R.layout.simple_spinner_item, tipochartL);
		adapter2.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
		/*ArrayAdapter<String> adapter3 = new ArrayAdapter<String>(this,
				android.R.layout.simple_spinner_item, indicadorL);
		adapter3.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);*/
		periodo.setAdapter(adapter);
		tipochart.setAdapter(adapter2);
		//indicador.setAdapter(adapter3);
		seguir = (Button) findViewById(R.id.siguiente);
		seguir.setOnClickListener(new View.OnClickListener() {
			public void onClick(View v) {
					switch(periodo.getSelectedItemPosition()+1){
					case 1:
						  MES_CONFLICTO = "a";
						break;
					case 2:
						MES_CONFLICTO = "b";
						break;
					case 3:
						MES_CONFLICTO = "c";
						break;
					}
					//TIPO_CONSULTA = indicador.getSelectedItemPosition()+1;
					
					
					/*if(tipochart.getSelectedItemPosition()+1==1){
                		mandarTorta(1);			
					}else{
						mandarTorta(0);
					}*/
					ArrayList<NameValuePair> pairs = new ArrayList<NameValuePair>();
					pairs.add(new BasicNameValuePair("MES",MES_CONFLICTO));
					//pairs.add(new BasicNameValuePair("TIPO",String.valueOf(TIPO_CONSULTA)));
					JsonParserp jParserp = new JsonParserp();
					JSONArray jArray = jParserp.getJSONFromUrl(pairs, "http://escalaconflict.esentialbc.net/escalaconflict/index.php/graficos/tipomes");
					if(jArray!=null){
						Log.d("entro1", "asd");
                        try{
                        	  Log.d("entro2", String.valueOf(jArray.length()));
                        	for(int i=0;i<jArray.length();i++){
                        		JSONObject json_provdata = jArray.getJSONObject(i);
                        		listaTipo.add(json_provdata.getString("TIPO"));
                        		listaCantidad.add(json_provdata.getInt("CANTIDAD"));
                        		Log.d("entro3", "asd");
                        	}
                        	if(tipochart.getSelectedItemPosition()+1==1){
                        		mandarTorta(1);			
        					}else{
        						mandarTorta(0);
        					}
                        	
                        	
                        }catch(JSONException e){
                        	Log.d("error", e.toString());
                        }
                           //PieChartView torta = new PieChartView(ReportesTortas.this,listaTipo,listaCantidad,TIPO_CONSULTA);
                           
                        }
					
			}
            
              

		});

  
   

	}
   public void mandarTorta(int i){
	   if(i==1){
		   PieChartView torta = new PieChartView(ReportesTortas.this,listaTipo,listaCantidad,TIPO_CONSULTA);
		   setContentView(torta);
	   }else{
		   ViewBarchart torta = new ViewBarchart(ReportesTortas.this,listaTipo,listaCantidad,TIPO_CONSULTA);
		   setContentView(torta);
	   }
	  Log.d(String.valueOf(TIPO_CONSULTA),"tipo de consulta");
		
	  //
		//requestWindowFeature(Window.FEATURE_NO_TITLE);
		
   }
	

}

