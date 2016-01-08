package com.unisannio.casadomotica;

import java.io.IOException;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;


public class Preleva{
	String tempInterna,Valstato1,tempEsterna;
	Document doc;
	public Preleva(){

		try {
			doc = Jsoup.connect("http://arduino201.homepc.it/").get();
			Element ele =doc.getElementById("temperaturaint");
		     	Element stato1 =doc.getElementById("stato1");
			 Element est =doc.getElementById("temperaturaest");
			tempInterna=ele.val();
			Valstato1=stato1.val();
			tempEsterna=est.val();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			
		}




	}



	public String getStato1() {                                        
		return  Valstato1;         

	}

	public String getTempInterna() {                                        
		return  tempInterna;         

	}



	public String getTempEsterna() {
		// TODO Auto-generated method stub
		return tempEsterna;
	}
}