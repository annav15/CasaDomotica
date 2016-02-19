package com.unisannio.casadomotica.view;

import com.unisannio.casadomotica.R;
import com.unisannio.casadomotica.controller.Led;
import com.unisannio.casadomotica.controller.Preleva;

import android.support.v7.app.ActionBarActivity;
import android.view.View.OnClickListener;



import android.annotation.SuppressLint;
import android.annotation.TargetApi;
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
public class Gestione extends ActionBarActivity implements OnClickListener {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		StrictMode.ThreadPolicy policy = new StrictMode.
				ThreadPolicy.Builder().permitAll().build();
			     	StrictMode.setThreadPolicy(policy);
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_generale);
		Button accendiS1 = (Button) findViewById(R.id.accendi);
		 Button spegnis1 = (Button) findViewById(R.id.spegni);
		 Button accendis2 = (Button) findViewById(R.id.accendis2);
		 Button spegnis2 = (Button) findViewById(R.id.spegnis2);
		 Button accendis3 = (Button) findViewById(R.id.accendis3);
		 Button spegnis3 = (Button) findViewById(R.id.spegnis3);
		 Button accendiEST = (Button) findViewById(R.id.accendiEST);
		 Button spegniEST = (Button) findViewById(R.id.spegniEST);
		accendiS1.setOnClickListener(this);
		spegnis1.setOnClickListener(this);
		accendis2.setOnClickListener(this);
		spegnis2.setOnClickListener(this);
		accendis3.setOnClickListener(this);
		spegnis3.setOnClickListener(this);
		accendiEST.setOnClickListener(this);
		spegniEST.setOnClickListener(this);
		TextView valTemp1=(TextView)findViewById(R.id.tempINT1_value);
		Preleva pr=new Preleva();
		 String tempinterna=pr.getTempInterna();
		  valTemp1.setText(tempinterna);
		  TextView valTempEST=(TextView)findViewById(R.id.tempEST_value);
		 String tempEST=pr.getTempEsterna();
			    valTempEST.setText(tempEST);
	}
	@Override
	public void onClick(View v) {
		// TODO Auto-generated method stub
		switch(v.getId()){
	case R.id.accendi:		
		Led.accendiLed(1,1);
		Toast.makeText(getApplicationContext(), "led s1 acceso",Toast.LENGTH_LONG).show();
		break;
	case R.id.spegni:		
		Led.accendiLed(1,0);
		Toast.makeText(getApplicationContext(), "led s1 spento",Toast.LENGTH_LONG).show();
		break;
	case R.id.accendis2:		
		Led.accendiLed(2,1);
		Toast.makeText(getApplicationContext(), "led s2 acceso",Toast.LENGTH_LONG).show();
		break;
	case R.id.spegnis2:		
		Led.accendiLed(2,0);
		Toast.makeText(getApplicationContext(), "led s2 spento",Toast.LENGTH_LONG).show();
		break;
	case R.id.accendis3:		
		Led.accendiLed(3,1);
		Toast.makeText(getApplicationContext(), "led s3 acceso",Toast.LENGTH_LONG).show();
		break;
	case R.id.spegnis3:		
		Led.accendiLed(3,0);
		Toast.makeText(getApplicationContext(), "led s3 spento",Toast.LENGTH_LONG).show();
		break;
	case R.id.accendiEST:		
		Led.accendiLed(4,1);
		Toast.makeText(getApplicationContext(), "led esterno acceso",Toast.LENGTH_LONG).show();
		break;
	case R.id.spegniEST:		
		Led.accendiLed(4,0);
		Toast.makeText(getApplicationContext(), "led esterno spento",Toast.LENGTH_LONG).show();
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