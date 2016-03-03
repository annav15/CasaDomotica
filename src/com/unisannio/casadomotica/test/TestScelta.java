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

public class TestScelta extends ActivityInstrumentationTestCase2<Scelta> {

	public TestScelta() {
		super(Scelta.class);
	
	}
	Scelta SceltaActivity;

	Button b2;
	
	protected void setUp() throws Exception {
		super.setUp();
	SceltaActivity = getActivity();

	 
	}


	Button accendiS1;
	
public void testBottoneLogin() {
	  ActivityMonitor activityMonitor = getInstrumentation().addMonitor(Gestione.class.getName(), null, false);
	  b2=(Button)SceltaActivity.findViewById(R.id.gestioneM);
	  SceltaActivity.runOnUiThread(new Runnable() {
	    @Override
	    public void run() {
	      b2.performClick();
	    }
	  });
	  Activity nextActivity = getInstrumentation().waitForMonitorWithTimeout(activityMonitor, 10000);
	  ActivityMonitor activityMonitor1 = getInstrumentation().addMonitor(Scelta.class.getName(), null, false);
	    accendiS1 = (Button) nextActivity.findViewById(R.id.accendi);
	
	 	  nextActivity.runOnUiThread(new Runnable() {
		    @Override
		    public void run() {
		    	accendiS1.performClick();
		    }
		  });
	 
	  
	  assertNotNull(nextActivity);
	  nextActivity .finish();
	}

}
