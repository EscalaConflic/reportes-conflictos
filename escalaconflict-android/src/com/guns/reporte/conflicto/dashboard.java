package com.guns.reporte.conflicto;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

public class dashboard extends Activity implements View.OnClickListener {
	Button tPicture, aGaleria, dHistorieta, vHistorieta, fbBtn, twtBtn;
	ImageView logoComicFactori;
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub

		super.onCreate(savedInstanceState);
		setContentView(R.layout.dashboard);
		inicializaBotones();
	}

	private void inicializaBotones() {
		// TODO initialize the  objects variables, and add the onclick method to them
		tPicture = (Button) findViewById(R.id.reporteBtn);
		aGaleria = (Button) findViewById(R.id.mapaconflictosBtn);
		dHistorieta = (Button) findViewById(R.id.tortasBtn);
		vHistorieta = (Button) findViewById(R.id.aboutBtn);
		fbBtn = (Button) findViewById(R.id.fbBtn);
		twtBtn = (Button) findViewById(R.id.twtBtn);
		tPicture.setOnClickListener(this);
		aGaleria.setOnClickListener(this);
		dHistorieta.setOnClickListener(this);
		vHistorieta.setOnClickListener(this);
		twtBtn.setOnClickListener(this);
		fbBtn.setOnClickListener(this);

	}

	@Override
	public void onClick(View view) {
		// TODO Auto-generated method stub
		switch(view.getId()){
		case R.id.reporteBtn:
			Intent reportarIntent = new Intent(dashboard.this, ConflictoDetallado.class);
			startActivity(reportarIntent);
			break;
		case R.id.tortasBtn:
			Intent verTortasIntent = new Intent(dashboard.this, ConflictoDetallado.class);
			startActivity(verTortasIntent);
			break;
		case R.id.mapaconflictosBtn:
			Intent verMapaConflictosIntent = new Intent(dashboard.this, MapaConflictos.class);
			startActivity(verMapaConflictosIntent);
			break;
		case R.id.aboutBtn:
			Intent aboutIntent = new Intent(dashboard.this, About.class);
			startActivity(aboutIntent);
			break;
		case R.id.fbBtn:
			startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse("http://www.facebook.com/KetanoLab") ) );
			break;
		case R.id.twtBtn:
			startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse("https://twitter.com/#!/KetanoLab") ) );
			break;
		}
	}
}
