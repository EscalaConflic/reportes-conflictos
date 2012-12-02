package com.guns.reporte.conflicto;

import java.util.ArrayList;
import java.util.HashMap;

import org.apache.http.NameValuePair;
import org.apache.http.message.BasicNameValuePair;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.SimpleAdapter;
import android.widget.Spinner;
import android.widget.SpinnerAdapter;
import android.widget.Toast;

public class reporte extends Activity{
	Spinner campoConflicto;
	Spinner tipoConflicto;
	Button seguir;
	Spinner campo1;
	Spinner campo2;
	EditText campo4;
	SharedPreferences datos;
	private EditText campo3;  
	
//	public final String urldemandantes= "http://192.168.2.100/escalaconflict/conflicto/getDemandante";
	public final String urldemandantes= "http://escalaconflict.esentialbc.net/escalaconflict/conflicto/getDemandante";
	public final String urldemandandado= "http://escalaconflict.esentialbc.net/escalaconflict/conflicto/getDemandado";
	//192.168.2.100/escalaconflict/conflicto/getDemandado
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.admin);
		campoConflicto = (Spinner) findViewById(R.id.spinner1);
		//seguir = (Button) findViewById(R.id.seguir);
		campo1 = (Spinner) findViewById(R.id.spinner2);
		campo2 = (Spinner) findViewById(R.id.spinner3); 
		campo3 = (EditText) findViewById(R.id.editText3);
		campo4 = (EditText) findViewById(R.id.editText4);
		String[] listaCampo =new String[] {"Prestacion de servicios publicos","Medidas economicas","Laboral/Salarial","Seguridad Ciudadana",
				"Vivienda","Tierra","Gestion del espacio Urbano","Gestion Administrativa","Leyes/Medidas Legales","Cuestinomamiento","Incumplimiento de Convenios",
				"Limites Politico/ADministrativo","Ideologico/Politico","Recursos Naturales y Medio Ambiente","Derechos Humanos","Valores,Creencias,Identidad","Otro"};

		ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,
				android.R.layout.simple_spinner_item, listaCampo);
		adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
		campoConflicto.setAdapter(adapter);
		//get the list of demandantes
		ArrayList<NameValuePair> spinnerValuePairs = new ArrayList<NameValuePair>();
		ArrayList<HashMap<String, String>> jsonprovList = new ArrayList<HashMap<String, String>>();
		spinnerValuePairs.add(new BasicNameValuePair("prov","prov"));
		JsonParserp jParser = new JsonParserp();
		// getting JSON string from URL of suppliers
		JSONArray jprovArray = jParser.getJSONFromUrl(spinnerValuePairs, urldemandantes);
		if(jprovArray != null){
			try {
				for(int i = 0; i < jprovArray.length() ; i++){
					JSONObject json_provdata = jprovArray.getJSONObject(i);
					String id = json_provdata.getString("id");
					String nombre = json_provdata.getString("sde_nombre");
				
					// creating new HashMap
					HashMap<String, String> provmap = new HashMap<String, String>();
					provmap.put("sdo_nombre",nombre);
					
					jsonprovList.add(provmap);
				}
				SpinnerAdapter sadapter = new SimpleAdapter(reporte.this, jsonprovList, R.layout.itemview, new String[]{"sdo_nombre"}, new int [] {R.id.spinnertxtview} );
				campo1.setAdapter(sadapter);

			}
			catch(JSONException e){
				Log.e("log_tag", "Error parsing data "+e.toString());
			}

		}
	
// get list of demandados
		ArrayList<NameValuePair> spinnerValuePairs1 = new ArrayList<NameValuePair>();
		ArrayList<HashMap<String, String>> jsonprovList1 = new ArrayList<HashMap<String, String>>();
		spinnerValuePairs.add(new BasicNameValuePair("prov","prov"));
		JsonParserp jParser1 = new JsonParserp();
		// getting JSON string from URL of suppliers
		JSONArray jprovArray1 = jParser1.getJSONFromUrl(spinnerValuePairs1, urldemandandado);
		if(jprovArray1 != null){   
			try {
				for(int i = 0; i < jprovArray1.length() ; i++){
					JSONObject json_provdata = jprovArray1.getJSONObject(i);
					String id = json_provdata.getString("id");
					String nombre = json_provdata.getString("sdo_nombre");
				
					// creating new HashMap
					HashMap<String, String> provmap = new HashMap<String, String>();
					provmap.put("sdo_nombre",nombre);
					
					jsonprovList1.add(provmap);
				}
				SpinnerAdapter sadapter = new SimpleAdapter(reporte.this, jsonprovList1, R.layout.itemview, new String[]{"sdo_nombre"}, new int [] {R.id.spinnertxtview} );
				campo2.setAdapter(sadapter);

			}
			catch(JSONException e){
				Log.e("log_tag", "Error parsing data "+e.toString());
			}

		}

		
		seguir = (Button) findViewById(R.id.siguiente);
		seguir.setOnClickListener(new View.OnClickListener() {
			public void onClick(View v) {
				if(	campo3.getText().length()>5
						&& campo4.getText().length()>5){
					datos = getSharedPreferences("configuracion",MODE_PRIVATE);
					SharedPreferences.Editor editor = datos.edit();
					editor.putInt("tipo_conflicto", campoConflicto.getSelectedItemPosition()+1);
					editor.putString("sector_demandante",String.valueOf(campo1.getSelectedItemPosition()+1));
					editor.putString("sector_demandado",String.valueOf(campo2.getSelectedItemPosition()+1));
					editor.putString("descripcion",String.valueOf(campo3.getText()));
					editor.putString("medida_protesta",String.valueOf(campo4.getText()));


					editor.commit();

					Intent a = new Intent(reporte.this,Mapareporteconflictos.class);
					startActivity(a);
					reporte.this.finish();	
				}else{
					Toast.makeText(reporte.this, "Llenar todos los espacios por favor...", Toast.LENGTH_SHORT).show();
				}


			}


		});

  /* temp = (TextView) findViewById(R.id.titulo1);
   Typeface fuente = Typeface.createFromAsset(getAssets(), "fonts/b.ttf");
   temp.setTypeface(fuente);*/
   

	}

	/*@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.activity_main, menu);
		return true;
	}*/

}
