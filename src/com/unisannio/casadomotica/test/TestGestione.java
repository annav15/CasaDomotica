package com.unisannio.casadomotica.test;



import com.unisannio.casadomotica.R;
import com.unisannio.casadomotica.view.Gestione;
import com.unisannio.casadomotica.view.Scelta;




import android.app.Activity;
import android.app.Instrumentation.ActivityMonitor;
import android.test.ActivityInstrumentationTestCase2;
import android.widget.Button;
import android.widget.TextView;

public class TestGestione extends ActivityInstrumentationTestCase2<Gestione> {
	Gestione GestioneActivity ;
	public TestGestione() {
		super(Gestione.class);
	
	}
	Button accendiS1; 
	Button spegnis1;  
	Button accendis2; 
	Button spegnis2;  
	Button accendis3; 
	Button spegnis3;  
	Button accendiEST;
	Button spegniEST; 
	
	TextView valTemp1;
	TextView valTempEST;
	
	protected void setUp() throws Exception {
		super.setUp();
	GestioneActivity = getActivity(); 
	 valTemp1=(TextView)GestioneActivity.findViewById(R.id.tempINT1_value);
	 valTempEST=(TextView)GestioneActivity.findViewById(R.id.tempEST_value);
	 GestioneActivity.runOnUiThread(new Runnable() {
	
		    public void run() {
		    	valTemp1.setText("28");
		    	valTempEST.setText("29");
		    }
		  });
	}

	public void testAccendiLeds1() {
		  ActivityMonitor activityMonitor = getInstrumentation().addMonitor(Gestione.class.getName(), null, false);
		 
		 
		   accendiS1 = (Button) GestioneActivity.findViewById(R.id.accendi);
		
		   GestioneActivity.runOnUiThread(new Runnable() {
			    @Override
			    public void run() {
			    	accendiS1.performClick();
			    }
			  });		  
		  assertNotNull(GestioneActivity);
		  GestioneActivity.finish();
		}

	public void testSpegniLeds1() {
		  ActivityMonitor activityMonitor = getInstrumentation().addMonitor(Gestione.class.getName(), null, false);
		 
		 spegnis1 = (Button) GestioneActivity.findViewById(R.id.spegni);
		
		  GestioneActivity.runOnUiThread(new Runnable() {
			    @Override
			    public void run() {
			    	spegnis1.performClick();
			    }
			  });		  
		  assertNotNull(GestioneActivity);
		  GestioneActivity .finish();
		}

	public void testAccendiLeds2() {
		  ActivityMonitor activityMonitor = getInstrumentation().addMonitor(Gestione.class.getName(), null, false);
		 
		 
		  accendis2= (Button) GestioneActivity.findViewById(R.id.accendis2);
		
		  GestioneActivity.runOnUiThread(new Runnable() {
			    @Override
			    public void run() {
			    	accendis2.performClick();
			    }
			  });		  
		  assertNotNull(GestioneActivity);
		  GestioneActivity .finish();
		}

	public void testSpegniLeds2() {
		  ActivityMonitor activityMonitor = getInstrumentation().addMonitor(Gestione.class.getName(), null, false);
		 
	  spegnis2 = (Button) GestioneActivity.findViewById(R.id.spegnis2);
		
		  GestioneActivity.runOnUiThread(new Runnable() {
			    @Override
			    public void run() {
			    	spegnis2.performClick();
			    }
			  });		  
		  assertNotNull(GestioneActivity);
		  GestioneActivity .finish();
		}

	public void testAccendiLeds3() {
		  ActivityMonitor activityMonitor = getInstrumentation().addMonitor(Gestione.class.getName(), null, false);
		 
		accendis3= (Button) GestioneActivity.findViewById(R.id.accendis3);
		
		  GestioneActivity.runOnUiThread(new Runnable() {
			    @Override
			    public void run() {
			    	accendis3.performClick();
			    }
			  });		  
		  assertNotNull(GestioneActivity);
		  GestioneActivity .finish();
		}

	public void testSpegniLeds3() {
		  ActivityMonitor activityMonitor = getInstrumentation().addMonitor(Gestione.class.getName(), null, false);
		 
	  spegnis3 = (Button) GestioneActivity.findViewById(R.id.spegnis3);
		
		  GestioneActivity.runOnUiThread(new Runnable() {
			    @Override
			    public void run() {
			    	spegnis3.performClick();
			    }
			  });		  
		  assertNotNull(GestioneActivity);
		  GestioneActivity .finish();
		}

	public void testAccendiLedEst() {
		  ActivityMonitor activityMonitor = getInstrumentation().addMonitor(Gestione.class.getName(), null, false);
		 
		  accendiEST= (Button) 		  GestioneActivity.findViewById(R.id.accendiEST);
		
		  GestioneActivity.runOnUiThread(new Runnable() {
			    @Override
			    public void run() {
			    	accendiEST.performClick();
			    }
			  });		  
		  assertNotNull(GestioneActivity);
		  GestioneActivity .finish();
		}

	public void testSpegniLedEst() {
		  ActivityMonitor activityMonitor = getInstrumentation().addMonitor(Gestione.class.getName(), null, false);
		 
	  spegniEST = (Button) 		  GestioneActivity.findViewById(R.id.spegniEST);
		
		  GestioneActivity.runOnUiThread(new Runnable() {
			    @Override
			    public void run() {
			    	spegniEST.performClick();
			    }
			  });		  
		  assertNotNull(GestioneActivity);
		  GestioneActivity .finish();
		}

	public void testPreTemINT() {
		 ActivityMonitor activityMonitor = getInstrumentation().addMonitor(Gestione.class.getName(), null, false);
		 Activity nextActivity = getInstrumentation().waitForMonitorWithTimeout(activityMonitor, 5000);
		 	assertEquals("28", valTemp1.getText().toString());  
		}
	public void testPreTemEST() {
		 ActivityMonitor activityMonitor = getInstrumentation().addMonitor(Gestione.class.getName(), null, false);
		 Activity nextActivity = getInstrumentation().waitForMonitorWithTimeout(activityMonitor, 5000);
		 	assertEquals("29", valTempEST.getText().toString());  
		}
	
	
}
