package com.unisannio.casadomotica.controller;

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
			if(stanza==2){
				if (stato==1){
					
					commandArduino("http://arduino201.homepc.it/?leds2ON");
							
				}
				else{
					commandArduino("http://arduino201.homepc.it/?leds2OFF");
				
					
				}
			
		}
			if(stanza==3){
				if (stato==1){
					
					commandArduino("http://arduino201.homepc.it/?leds3ON");
							
				}
				else{
					commandArduino("http://arduino201.homepc.it/?leds3OFF");
				
					
				}
			
		}
			if(stanza==4){
				if (stato==1){
					
					commandArduino("http://arduino201.homepc.it/?ledestON");
							
				}
				else{
					commandArduino("http://arduino201.homepc.it/?ledestOFF");
				
					
				}
			
		}
			if(stanza==5){
				if (stato==1){
					
					commandArduino("http://arduino201.homepc.it/?automatico");
							
				}
				else{
					commandArduino("http://arduino201.homepc.it/?ledestOFF");
				
					
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

