package com.unisannio.casadomotica.view;

import com.unisannio.casadomotica.R;
import com.unisannio.casadomotica.controller.Led;

import android.support.v7.app.ActionBarActivity;
import android.view.View.OnClickListener;



import android.annotation.SuppressLint;
import android.annotation.TargetApi;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.os.StrictMode;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

@TargetApi(Build.VERSION_CODES.GINGERBREAD)
@SuppressLint("NewApi")
public class Scelta extends ActionBarActivity implements OnClickListener {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		StrictMode.ThreadPolicy policy = new StrictMode.
				ThreadPolicy.Builder().permitAll().build();
			     	StrictMode.setThreadPolicy(policy);
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_scelta);
		Button gestioneA = (Button) findViewById(R.id.gestioneA);
		 Button gestioneM = (Button) findViewById(R.id.gestioneM);

		 gestioneA.setOnClickListener(this);
		 gestioneM.setOnClickListener(this);
		
	}
	@Override
	public void onClick(View v) {
		// TODO Auto-generated method stub
		switch(v.getId()){
	case R.id.gestioneA:	
		Led.accendiLed(5,1);
		Toast toast = Toast.makeText(getApplicationContext(),"Gestione Automatica avviata",3);
		toast.show();
		break;
	case R.id.gestioneM:		
		Intent gestioneM = new Intent(this,Gestione.class);  
		startActivity(gestioneM);
		break;
	
	}
	}
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		                        return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		// Handle action bar item clicks here. The action bar will
		// automatically handle clicks on the Home/Up button, so long
		// as you specify a parent activity in AndroidManifest.xml.
		int id = item.getItemId();
		if (id == R.id.action_settings) {
			return true;
		}
		return super.onOptionsItemSelected(item);
	}
}