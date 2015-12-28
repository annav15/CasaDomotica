package com.unisannio.casadomotica;

import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;

public class Led {

		
		
		public static void accendiLed (int stanza,int stato){  //metodo accediLed
			
			if(stanza==1){
				if (stato==1){
					
					commandArduino("http://arduino201.homepc.it/?leds1ON");
					
					
				}
				else{
					commandArduino("http://arduino201.homepc.it/?leds1OFF");
				
					
				}
			
		}
		
}
		public static void commandArduino(String url){
		 	try {
		 		 
		 		 HttpClient httpclient = new DefaultHttpClient();
		 		httpclient.execute(new HttpGet(url));	
		   		
		   	
			    			    
			  } catch (Exception e) {
			  }
		}
}

