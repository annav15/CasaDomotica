package com.unisannio.casadomotica;

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
public class MainActivity extends ActionBarActivity implements OnClickListener {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		StrictMode.ThreadPolicy policy = new StrictMode.
				ThreadPolicy.Builder().permitAll().build();
				StrictMode.setThreadPolicy(policy);
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		Button accendiS1 = (Button) findViewById(R.id.accendi);
		 Button spegnis1 = (Button) findViewById(R.id.spegni);
		
		accendiS1.setOnClickListener(this);
		spegnis1.setOnClickListener(this);
		TextView valTemp1=(TextView)findViewById(R.id.tempINT1_value);
		Preleva pr=new Preleva();
		 String tempinterna=pr.getTempInterna();
		  valTemp1.setText(tempinterna);
	}
	@Override
	public void onClick(View v) {
		// TODO Auto-generated method stub
		switch(v.getId()){
	case R.id.accendi:		
		Led.accendiLed(1,1);
		Toast.makeText(getApplicationContext(), "led cucina acceso",Toast.LENGTH_LONG).show();
		break;
	case R.id.spegni:		
		Led.accendiLed(1,0);
		Toast.makeText(getApplicationContext(), "led cucina spento",Toast.LENGTH_LONG).show();
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
