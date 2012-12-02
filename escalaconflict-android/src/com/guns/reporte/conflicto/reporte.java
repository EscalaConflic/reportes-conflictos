package com.guns.reporte.conflicto;

import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;  
import android.view.View;
import android.widget.ArrayAdapter;    
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

public class reporte extends Activity{
	Spinner campoConflicto;
	Spinner tipoConflicto;
	Button seguir;
	EditText campo1;
	EditText campo2;
	SharedPreferences datos;
	private EditText campo3;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.admin);
		campoConflicto = (Spinner) findViewById(R.id.spinner1);
		 //seguir = (Button) findViewById(R.id.seguir);
		 campo1 = (EditText) findViewById(R.id.editText1);
		 campo2 = (EditText) findViewById(R.id.editText2); 
		 campo3 = (EditText) findViewById(R.id.editText3);
        
		 String[] listaCampo =new String[] {"Prestacion de servicios publicos","Medidas economicas","Laboral/Salarial","Seguridad Ciudadana",
	        		"Vivienda","Tierra","Gestion del espacio Urbano","Gestion Administrativa","Leyes/Medidas Legales","Cuestinomamiento","Incumplimiento de Convenios",
	        		"Limites Politico/ADministrativo","Ideologico/Politico","Recursos Naturales y Medio Ambiente","Derechos Humanos","Valores,Creencias,Identidad","Otro"};
	        
	        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,
	                    android.R.layout.simple_spinner_item, listaCampo);
	        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
	        campoConflicto.setAdapter(adapter);
		  seguir = (Button) findViewById(R.id.siguiente);
		  seguir.setOnClickListener(new View.OnClickListener() {
	            public void onClick(View v) {
	            	if(campo1.getText().length()>5 &&
	            			campo2.getText().length()>5 &&
	            			campo3.getText().length()>5){
	            		datos = getSharedPreferences("configuracion",MODE_PRIVATE);
		                SharedPreferences.Editor editor = datos.edit();
		        		editor.putInt("tipo_conflicto", campoConflicto.getId());
		        		editor.putString("sector_demandante",String.valueOf(campo1.getText()));
		        		editor.putString("sector_demandado",String.valueOf(campo2.getText()));
		        		editor.putString("descripcion",String.valueOf(campo3.getText()));
		        		
		        		
		        		
		        		editor.commit();
		            	
		            	Intent a = new Intent(reporte.this,Mapareporteconflictos.class);
		            	startActivity(a);
		            	reporte.this.finish();	
	            	}else{
	            		Toast.makeText(reporte.this, "Llena todo ctm!", Toast.LENGTH_SHORT).show();
	            	}
	            	
	            	
	            }
	            
				
			});
		
            
        
		
	}

	/*@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.activity_main, menu);
		return true;
	}*/

}

