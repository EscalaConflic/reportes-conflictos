package com.guns.reporte.conflicto;

import java.util.List;

import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.os.Bundle;


import com.google.android.maps.GeoPoint;
import com.google.android.maps.MapActivity;
import com.google.android.maps.MapController;
import com.google.android.maps.MapView;
import com.google.android.maps.Overlay;
import com.google.android.maps.OverlayItem;



public class mapapuntasos extends MapActivity {
	MapController mapControler;
	public final String poscondition = "ciudadelegida";
	GeoPoint point;
	GeoPoint point1;
	GeoPoint point2;
	GeoPoint point3;
	GeoPoint point4;
	GeoPoint point5;
	GeoPoint point6;
	GeoPoint point7;
	GeoPoint point8;
	GeoPoint point9;
	OverlayItem overlayitem;
	OverlayItem overlayitem1;
	OverlayItem overlayitem2;
	OverlayItem overlayitem3;
	OverlayItem overlayitem4;
	OverlayItem overlayitem5;
	OverlayItem overlayitem6;
	OverlayItem overlayitem7;
	OverlayItem overlayitem8;
	OverlayItem overlayitem9;
	String ciudad;
	
	//radio de la tierra para el algoritmo de Haversine usado para calcular la distancia exacta entre 2 puntos del globo
	public static double radious = 6371.00;
	/** Called when the activity is first created. */
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.mapapuntos);
		//enable zoom in.out functions
		MapView mapView = (MapView) findViewById(R.id.mapview);
		Intent in =  getIntent();
		 ciudad = in.getStringExtra(poscondition);
		
		mapView.setBuiltInZoomControls(true);
		
		//get a list of the overlays 
		List<Overlay> mapOverlays = mapView.getOverlays();
		Drawable drawable = this.getResources().getDrawable(R.drawable.mano);
		Drawable drawable1 = this.getResources().getDrawable(R.drawable.mano);
		
		ContactItemizedOverlay itemizedoverlay = new ContactItemizedOverlay(drawable, this);
		ContactItemizedOverlay itemizedoverlay1 = new ContactItemizedOverlay(drawable1, this);
		
		//coordinates to draw
		//first point of location
				//oficina soltux
				String coordinates[] = {"-16.507009", "-68.129657"};
				//prado cerca a las gradas
				String coordinates1[] ={"-16.50120505", "-68.13334501"};
				//calle murillo y oruro
				String coordinates2[] ={"-16.499546","-68.136138"};
				//san miguel
				String coordinates3[] ={"-16.539538","-68.078308"};
				//el alto
				String coordinates4[] ={"-16.505836","-68.164078"};
				//Cocyhambamba el prado
				String coordinates5[] ={"-17.382986","-66.159412"};
				//Cochabamba las americas
				String coordinates6[] ={"-17.372931","-66.156408"};
				//santa cruz Rene Morenoajeros
				String coordinates7[] ={"-17.786352","-63.181065"};
				//Santa Cruz tercer Anillo
				String coordinates8[] ={"-17.762542","-63.163580"};
				//Oruro
				String coordinates9[] ={"-17.970393","-67.115128"};
				
				
				double lat = Double.parseDouble(coordinates[0]);
				double lng = Double.parseDouble(coordinates[1]);
				double lat1 = Double.parseDouble(coordinates1[0]);
				double lng1 = Double.parseDouble(coordinates1[1]);
				double lat2 = Double.parseDouble(coordinates2[0]);
				double lng2 = Double.parseDouble(coordinates2[1]);
				double lat3 = Double.parseDouble(coordinates3[0]);
				double lng3 = Double.parseDouble(coordinates3[1]); 
				double lat4 = Double.parseDouble(coordinates4[0]);
				double lng4 = Double.parseDouble(coordinates4[1]); 
				double lat5 = Double.parseDouble(coordinates5[0]);
				double lng5 = Double.parseDouble(coordinates5[1]); 
				double lat6 = Double.parseDouble(coordinates6[0]);
				double lng6 = Double.parseDouble(coordinates6[1]); 
				double lat7 = Double.parseDouble(coordinates7[0]);
				double lng7 = Double.parseDouble(coordinates7[1]); 
				double lat8 = Double.parseDouble(coordinates8[0]);
				double lng8 = Double.parseDouble(coordinates8[1]); 
				double lat9 = Double.parseDouble(coordinates9[0]);
				double lng9 = Double.parseDouble(coordinates9[1]); 
				 point = new GeoPoint((int) (lat * 1E6), 
						(int) (lng * 1E6));
				 point1 = new GeoPoint((int) (lat1 * 1E6), 
						(int) (lng1 * 1E6));
				 point2 = new GeoPoint((int) (lat2 * 1E6), 
						(int) (lng2 * 1E6));
				 point3 = new GeoPoint((int) (lat3 * 1E6), 
						(int) (lng3 * 1E6));
				 point4 = new GeoPoint((int) (lat4 * 1E6), 
						(int) (lng4 * 1E6));
				 point5 = new GeoPoint((int) (lat5 * 1E6), 
						(int) (lng5 * 1E6));
				 point6 = new GeoPoint((int) (lat6 * 1E6), 
						(int) (lng6 * 1E6));
				 point7 = new GeoPoint((int) (lat7 * 1E6), 
						(int) (lng7 * 1E6));
				 point8 = new GeoPoint((int) (lat8 * 1E6), 
						(int) (lng8 * 1E6));
				 point9 = new GeoPoint((int) (lat9 * 1E6), 
						(int) (lng9 * 1E6));
				
				 overlayitem = new OverlayItem(point, "Conflicto", "Marcha");
				 overlayitem1 = new OverlayItem(point1, "Conflicto", "protesta");
				 overlayitem2 = new OverlayItem(point2, "Conflicto", "bloqueo");
				 overlayitem3 = new OverlayItem(point3, "Conflicto", "huelga");
				 overlayitem4 = new OverlayItem(point4, "Conflicto", "marcha");
				 overlayitem5 = new OverlayItem(point5, "Conflicto", "protesta");
				 overlayitem6 = new OverlayItem(point6, "Conflicto", "bloqueo");
				 overlayitem7 = new OverlayItem(point7, "Conflicto", "bloqueo");
				 overlayitem8 = new OverlayItem(point8, "Conflicto", "marcha");
				 overlayitem9 = new OverlayItem(point9, "Conflicto", "protesta");
				 
					
				 itemizedoverlay1.addOverlay(overlayitem);
					itemizedoverlay1.addOverlay(overlayitem1);
					itemizedoverlay.addOverlay(overlayitem2);
					itemizedoverlay1.addOverlay(overlayitem3);
					itemizedoverlay.addOverlay(overlayitem4);
					itemizedoverlay1.addOverlay(overlayitem5);
					itemizedoverlay.addOverlay(overlayitem6);
					itemizedoverlay1.addOverlay(overlayitem7);
					itemizedoverlay.addOverlay(overlayitem8);
					itemizedoverlay.addOverlay(overlayitem9);
					//add the itemized overlay to the list of itemized overlays
					mapOverlays.add(itemizedoverlay);
					mapOverlays.add(itemizedoverlay1);
					mapControler = mapView.getController();
					//mapControler.animateTo(point);
					mapControler.setZoom(16); 
				// select city to draw itemized Overlay
		
					
		
		
		 
		
			mapControler.animateTo(point); 
		
		
	
		// MyLocationOverlay mLocationOverlay = new MyLocationOverlay(getBaseContext(), mapView);
		// mapControler.animateTo(mLocationOverlay.getMyLocation());

	}

	@Override
	protected boolean isRouteDisplayed() {
		// TODO Auto-generated method stub
		return false;
	}
}