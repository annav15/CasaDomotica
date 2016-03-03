package com.unisannio.casadomotica.test;





import com.unisannio.casadomotica.R;
import com.unisannio.casadomotica.view.Gestione;
import com.unisannio.casadomotica.view.MainActivity;
import com.unisannio.casadomotica.view.Scelta;

import android.app.Activity;
import android.app.Instrumentation.ActivityMonitor;
import android.test.ActivityInstrumentationTestCase2;
import android.widget.Button;
import android.widget.EditText;
import junit.framework.TestCase;

public class testMain extends ActivityInstrumentationTestCase2<MainActivity> {

	public testMain() {
		super(MainActivity.class);
	
	}MainActivity mainActivity;
	 EditText mUsername;
	 EditText mPassword;
	Button b1;
	
	protected void setUp() throws Exception {
		super.setUp();
	mainActivity = getActivity();
	 mUsername = (EditText) mainActivity.findViewById(R.id.editText1);
	 mPassword = (EditText) mainActivity.findViewById(R.id.editText2);
	
	mainActivity.runOnUiThread(new Runnable() {
	    public void run() {
	      mUsername.setText("anna");
	      mPassword.setText("pippo");
	     // b1.performClick();
	    
	    }
	  });
	  
	}
	
public void testUsername(){
	 ActivityMonitor activityMonitor = getInstrumentation().addMonitor(MainActivity.class.getName(), null, false);
	 Activity nextActivity = getInstrumentation().waitForMonitorWithTimeout(activityMonitor, 5000);
	  assertEquals("anna",mUsername.getText().toString());
	  
}
	
public void testPassword(){
	 ActivityMonitor activityMonitor = getInstrumentation().addMonitor(Scelta.class.getName(), null, false);
	 Activity nextActivity = getInstrumentation().waitForMonitorWithTimeout(activityMonitor, 5000);
	 assertEquals("pippo",mPassword.getText().toString());
	  
}

	
public void testLogincorretto() {
	  ActivityMonitor activityMonitor = getInstrumentation().addMonitor(Scelta.class.getName(), null, false);
	  b1=(Button)mainActivity.findViewById(R.id.button1);
	  mainActivity.runOnUiThread(new Runnable() {
	    @Override
	    public void run() {
	      b1.performClick();
	    }
	  });
	  Activity nextActivity = getInstrumentation().waitForMonitorWithTimeout(activityMonitor, 5000);
	  assertNotNull(nextActivity);
	  nextActivity .finish();
	}



}