package com.guns.reporte.conflicto;

import java.util.ArrayList;
import java.util.List;

import org.apache.http.NameValuePair;
import org.apache.http.message.BasicNameValuePair;
import org.json.JSONArray;

import android.content.Context;
import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.telephony.TelephonyManager;
import android.view.MotionEvent;
import android.widget.Toast;

import com.google.android.maps.GeoPoint;
import com.google.android.maps.MapActivity;
import com.google.android.maps.MapController;
import com.google.android.maps.MapView;
import com.google.android.maps.Overlay;
import com.google.android.maps.OverlayItem;
import com.google.android.maps.Projection;

public class Mapareporteconflictos extends MapActivity {
	MapController mapControler;
	GeoPoint point;
	OverlayItem overlayitem;
	public MapView mapView;
	private static final String url ="http://www.ketanolab.com/mobil/mobilremotov2-21.php";
	@Override
	
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.mapa_layout);
		//enable zoom in.out functions
		mapView = (MapView) findViewById(R.id.mapview);
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
				 
				 
				 
	}
	@Override
	public boolean dispatchTouchEvent(MotionEvent ev) {
	    int actionType = ev.getAction();
	    switch (actionType) { 
	    case MotionEvent.ACTION_UP:
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
	            int tipoConflicto = in.getIntExtra("tipo_conflicto", 0);
	            String descripcion = in.getStringExtra("descripcion");
	            String demandante = in.getStringExtra("sector_demandante");
	            String demandado = in.getStringExtra("sector_demandado");
	           // array de datos a subir para el servicio de reporte de conflictos 	
	            ArrayList<NameValuePair> nameValuePairs = new ArrayList<NameValuePair>();
	            nameValuePairs.add(new BasicNameValuePair("con_latitud",latitude));
	            nameValuePairs.add(new BasicNameValuePair("con_longitud",longitude));
	            nameValuePairs.add(new BasicNameValuePair("tipo_conflicto",String.valueOf(tipoConflicto)));
	            nameValuePairs.add(new BasicNameValuePair("descripcion",descripcion));
	            nameValuePairs.add(new BasicNameValuePair("sector_demandante",demandante));
	            nameValuePairs.add(new BasicNameValuePair("sector_demandado",demandado));
				//create de json to parse objects
	            JsonParserp jParserp = new JsonParserp();
	            //send de json parser
	        	JSONArray jArray = jParserp.getJSONFromUrl(nameValuePairs, url);	            	

	            
	            String imei = obtenerImei();
	    }

	    return super.dispatchTouchEvent(ev);
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

}
