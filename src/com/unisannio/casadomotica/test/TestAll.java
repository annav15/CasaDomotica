package com.unisannio.casadomotica.test;

import android.annotation.SuppressLint;
import junit.framework.TestResult;
import junit.framework.TestSuite;

@SuppressLint("NewApi")
public class TestAll extends TestSuite{
	public TestAll(){
		super(TestAll.class);

	}

	public static TestSuite suite() {
		TestSuite suite= new TestSuite();
		suite.addTestSuite(testMain.class);
		suite.addTestSuite(TestScelta.class);
		suite.addTestSuite(TestGestione.class);
//	
		return suite;
		
		
		
	}
}