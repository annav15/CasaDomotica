package com.unisannio.casadomotica.view;

import android.support.v7.app.ActionBarActivity;
import android.util.Log;
import android.view.View.OnClickListener;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;




import com.unisannio.casadomotica.R;

import android.annotation.SuppressLint;
import android.annotation.TargetApi;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Build;
import android.os.Bundle;
import android.os.StrictMode;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
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
		
	
	Button buttonInviaDati = (Button) findViewById(R.id.button1);
	buttonInviaDati.setOnClickListener(this);
	}
public void decidi(String a)
{

	if(a.compareTo("trovato")>0){
		Intent openPage1 = new Intent(MainActivity.this,Scelta.class);  
//		// passo all'attivazione dell'activity page1.java  
		startActivity(openPage1);
		Toast toast = Toast.makeText(getApplicationContext(),"Benvenuto",3);
		toast.show();
			
	}else 
	{
		
		Toast toast = Toast.makeText(getApplicationContext(),"ATTENZIONE login errato",3);
		toast.show();
		
	}
		
}
@Override
public void onClick(View v) {
	// TODO Auto-generated method stub
	switch(v.getId()){
	case R.id.button1:
	//new Invia().execute();	
	Invia vb=new Invia();
	String a=vb.doInBackground();
	this.decidi(a);		
	break;
	}
}
private class Invia extends AsyncTask<String, String,String> {
	String result=null; 
	InputStream is; 
	StringBuilder sb;

	@Override
		protected String doInBackground(String... params) {
			final EditText username = (EditText) findViewById(R.id.editText1);
			final EditText password = (EditText) findViewById(R.id.editText2);
			HttpClient httpclient = new DefaultHttpClient();
	   		//String a = url+"?username="+user.getText().toString()+"&pass="+pass.getText().toString();
		HttpResponse resp;
		try {
			resp = httpclient.execute(new HttpGet("http://provadip.altervista.org/loginDaAndroid.php"+"?username="+username.getText().toString()+"&password="+password.getText().toString()));
			HttpEntity entity = resp.getEntity();
	    	is = entity.getContent();
	    	
	    	
	    	if (is!=null)
	    	{
	    		try{
	                BufferedReader reader = new BufferedReader(new InputStreamReader(is,"iso-8859-1"),8);
	                StringBuilder sb = new StringBuilder();
	                String line = null;
	                while((line = reader.readLine()) != null) {
	                        sb.append(line + "\n");
	                }
	                is.close();
	                result=sb.toString();
	               
	        }catch(Exception e){
	                Log.e("TEST", "Errore nel convertire il risultato "+e.toString());
	        }
	    	
	    	
	         
	            
	    	}
	    	
	    	
		}
		catch(Exception e){
	        Log.e("TEST","errore nella p... "+e.toString());
		}
		return result;
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
