package com.guns.reporte.conflicto;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.apache.http.NameValuePair;
import org.apache.http.message.BasicNameValuePair;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.telephony.TelephonyManager;
import android.util.Log;
import android.view.GestureDetector;
import android.view.GestureDetector.OnGestureListener;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.google.android.maps.GeoPoint;
import com.google.android.maps.MapActivity;
import com.google.android.maps.MapController;
import com.google.android.maps.MapView;
import com.google.android.maps.Overlay;
import com.google.android.maps.OverlayItem;
import com.google.android.maps.Projection;

public class Mapareporteconflictos extends MapActivity implements OnGestureListener  {
	MapController mapControler;
	GeoPoint point;
	OverlayItem overlayitem;
	float tiempoDown;
	Button reportar, gpsRe;
	public  MapView mapView;
	private boolean sw;
	GestureDetector gestureDetector;
	public final String urlreporte= "http://escalaconflict.esentialbc.net/escalaconflict/conflicto/saveConflict";

	private int contador;
	private static final String url ="http://www.ketanolab.com/escalaconflict/conflicto/getDemandante";
	@Override

	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.mapa_layout);
		sw=false;
		mapView = (MapView) findViewById(R.id.mapview);
		//enable zoom in.out functions
		mapView.setBuiltInZoomControls(true);
		mapControler = mapView.getController();
		//mapControler.animateTo(point);
		mapControler.setZoom(14); 
		//get a list of the overlays 
		List<Overlay> mapOverlays = mapView.getOverlays();
		Drawable drawable = this.getResources().getDrawable(R.drawable.fbicon);
		ContactItemizedOverlay itemizedoverlay = new ContactItemizedOverlay(drawable, this);
		// punto inicial kisimira, ketanolab, ifaro
		String coordinates[] = {"-16.507009", "-68.129657"};
		double lat = Double.parseDouble(coordinates[0]);
		double lng = Double.parseDouble(coordinates[1]);
		point = new GeoPoint((int) (lat * 1E6), 
				(int) (lng * 1E6));
		mapControler.animateTo(point);
		reportar = (Button) findViewById(R.id.reportBtn);
		gpsRe= (Button) findViewById(R.id.gpsBtn);
		reportar.setOnClickListener(new View.OnClickListener() {

			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				Toast.makeText(Mapareporteconflictos.this,"precione en la ubicación del conflicto" , Toast.LENGTH_LONG).show();
				mapView.setBuiltInZoomControls(false);
				sw=true;
			}
		});

		//declarar el location manager
		gpsRe.setOnClickListener(new View.OnClickListener() {

			private double latitude;
			private double longitude;

			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				Rastreador gps = new Rastreador(Mapareporteconflictos.this);

				// check if GPS enabled
				if(gps.canGetLocation()){

					latitude = gps.getLatitude();
					longitude = gps.getLongitude();
					while(latitude == 0.0 ){
						latitude = gps.getLatitude();
						longitude = gps.getLongitude();

					}
					Toast.makeText(Mapareporteconflictos.this, String.valueOf(latitude), Toast.LENGTH_LONG).show();
					//extraer los datos
					SharedPreferences	pref = Mapareporteconflictos.this.getSharedPreferences("update",MODE_PRIVATE);
					int tipoConflicto = pref.getInt("tipo_conflicto", 0);
					String descripcion = pref.getString("descripcion","null");
					String demandante = pref.getString("sector_demandante", "oposicion");
					String demandado = pref.getString("sector_demandado", "gobierno");
					String medida = pref.getString("medida_protesta", "marcha");
					String imei = obtenerImei();

					// array de datos a subir para el servicio de reporte de conflictos 	
					ArrayList<NameValuePair> nameValuePairs = new ArrayList<NameValuePair>();
					nameValuePairs.add(new BasicNameValuePair("con_latitud",String.valueOf(latitude)));
					nameValuePairs.add(new BasicNameValuePair("con_longitud",String.valueOf(longitude)));
					nameValuePairs.add(new BasicNameValuePair("tipo_conflicto",String.valueOf(tipoConflicto)));
					nameValuePairs.add(new BasicNameValuePair("descripcion",descripcion));
					nameValuePairs.add(new BasicNameValuePair("sector_demandante",String.valueOf(demandante)));
					nameValuePairs.add(new BasicNameValuePair("sector_demandado",String.valueOf(demandado)));
					nameValuePairs.add(new BasicNameValuePair("imei",imei));
					nameValuePairs.add(new BasicNameValuePair("medida_presion",medida));
					EnviarReporte(nameValuePairs,urlreporte);
					//create de json to parse objects
					JsonParserp jParserp = new JsonParserp();
					//send de json parser
					JSONArray jArray = jParserp.getJSONFromUrl(nameValuePairs, url);	            	 


				}


			}

			private void EnviarReporte(ArrayList<NameValuePair> nameValuePairs,
					String url) {
				// TODO Auto-generated method stub
				JsonParserp jParserp = new JsonParserp();
				//send de json parser
				JSONArray jArray = jParserp.getJSONFromUrl(nameValuePairs, url);	            	 
				if(jArray != null){
					try {
						for(int i = 0; i < jArray.length() ; i++){
							JSONObject json_provdata = jArray.getJSONObject(i);
							String estado = json_provdata.getString("estado");
							String nombre = json_provdata.getString("sde_nombre");
							if(estado.equalsIgnoreCase("0"))
								Toast.makeText(Mapareporteconflictos.this, "reporte añadido correctamente", Toast.LENGTH_LONG);
							else
								Toast.makeText(Mapareporteconflictos.this, "reporte correcto", Toast.LENGTH_LONG);

						}

					}
					catch(JSONException e){
						Log.e("log_tag", "Error parsing data "+e.toString());
					}

				}
			}
		});
	}




	@Override
	public boolean dispatchTouchEvent(MotionEvent ev) {
		int actionType = ev.getAction();
		//GestureDetector.SimpleOnGestureListener.onDoubleTapListener());
		switch (actionType) { 
		case MotionEvent.ACTION_DOWN:
			contador =1;

			Log.d("help", "no entro");
			break; 

		case MotionEvent.ACTION_UP:
			Log.d("help", String.valueOf(contador));
			if(sw){

				//  snipet para obtenerla ubicación en la que hara click en el mapa
				Projection proj = mapView.getProjection();
				GeoPoint loc = proj.fromPixels((int)ev.getX(), (int)ev.getY()); 
				String longitude = Double.toString(((double)loc.getLongitudeE6())/1000000);
				String latitude = Double.toString(((double)loc.getLatitudeE6())/1000000);

				Toast toast = Toast.makeText(getApplicationContext(), "Longitude: "+ longitude +" Latitude: "+ latitude , Toast.LENGTH_LONG);
				toast.show();
				//recibir los datos de la primera parte del diccionario
				Intent in = getIntent();

				//extraer los datos
				SharedPreferences	pref = this.getSharedPreferences("update",MODE_PRIVATE);
				int tipoConflicto = pref.getInt("tipo_conflicto", 0);
				String descripcion = pref.getString("descripcion","null");
				String demandante = pref.getString("sector_demandante", "oposicion");
				String demandado = pref.getString("sector_demandado", "gobierno");
				String medida = pref.getString("medida_protesta", "marcha");
				String imei = obtenerImei();

				// array de datos a subir para el servicio de reporte de conflictos 	
				ArrayList<NameValuePair> nameValuePairs = new ArrayList<NameValuePair>();
				nameValuePairs.add(new BasicNameValuePair("con_latitud",latitude));
				nameValuePairs.add(new BasicNameValuePair("con_longitud",longitude));
				nameValuePairs.add(new BasicNameValuePair("tipo_conflicto",String.valueOf(tipoConflicto)));
				nameValuePairs.add(new BasicNameValuePair("descripcion",descripcion));
				nameValuePairs.add(new BasicNameValuePair("sector_demandante",String.valueOf(demandante)));
				nameValuePairs.add(new BasicNameValuePair("sector_demandado",String.valueOf(demandado)));
				nameValuePairs.add(new BasicNameValuePair("imei",imei));
				EnviarReporte(nameValuePairs,urlreporte);
				//create de json to parse objects
				sw =false;
			} 
			break;

		case MotionEvent.ACTION_MOVE:
			contador =2;
			break;
		}

		return super.dispatchTouchEvent(ev);
	}
	private void EnviarReporte(ArrayList<NameValuePair> nameValuePairs,
			String urlreporte2) {
		// TODO Auto-generated method stub
			JsonParserp jParserp = new JsonParserp();
			//send de json parser
			JSONArray jArray = jParserp.getJSONFromUrl(nameValuePairs, urlreporte2);	            	 
			if(jArray != null){
				try {
					for(int i = 0; i < jArray.length() ; i++){
						JSONObject json_provdata = jArray.getJSONObject(i);
						String estado = json_provdata.getString("estado");
						String nombre = json_provdata.getString("sde_nombre");
						if(estado.equalsIgnoreCase("0"))
							Toast.makeText(Mapareporteconflictos.this, "reporte añadido correctamente", Toast.LENGTH_LONG);
						else
							Toast.makeText(Mapareporteconflictos.this, "reporte correcto", Toast.LENGTH_LONG);

					}

				}
				catch(JSONException e){
					Log.e("log_tag", "Error parsing data "+e.toString());
				}

			}
		
	

	}




	private String obtenerImei() {
		// TODO Auto-generated method stub
		TelephonyManager mTelephonyMgr =
				(TelephonyManager)this.getSystemService(Context.TELEPHONY_SERVICE);

		String imeiCelular = mTelephonyMgr.getDeviceId(); 
		Toast.makeText(Mapareporteconflictos.this, imeiCelular, Toast.LENGTH_LONG).show();
		return imeiCelular;

	}
	@Override
	protected boolean isRouteDisplayed() {
		// TODO Auto-generated method stub
		return false;
	}
	@Override
	public boolean onDown(MotionEvent e) {
		// TODO Auto-generated method stub
		return false;
	}
	@Override
	public boolean onFling(MotionEvent e1, MotionEvent e2, float velocityX,
			float velocityY) {
		// TODO Auto-generated method stub
		return false;
	}
	@Override
	public void onLongPress(MotionEvent e) {
		// TODO Auto-generated method stub

	}
	@Override
	public boolean onScroll(MotionEvent e1, MotionEvent e2, float distanceX,
			float distanceY) {
		// TODO Auto-generated method stub
		return false;
	}
	@Override
	public void onShowPress(MotionEvent e) {
		// TODO Auto-generated method stub

	}
	@Override
	public boolean onSingleTapUp(MotionEvent e) {
		// TODO Auto-generated method stub
		return false;
	}

}
