///////////////////////      LIBRERIE      ////////////////////////

#include <String.h>
#include<SPI.h>
#include <Ethernet.h>

#include <OneWire.h>    // librerie per il funzionamento dei sensori di temperatura 
#include <DallasTemperature.h>

#define temperaturaint A2  // dichiarazione dell'ingresso analogico A2 di arduino 


byte mac[] = { 0xDE, 0xAD, 0xBE, 0xEF, 0xFE, 0xED }; // mac address dell'arduino
byte ip[] = { 192, 168, 1, 58}; // indirizzo ip fisico di arduino
byte gateway[] = { 192, 168, 1, 1 }; // accesso ad internet via router
byte subnet[] = { 255, 255, 255, 0 }; //subnet mask
EthernetServer server(80); // porta di comunicazione del server

int luce1 = 2 ;   //pin di connessione led di arduino

int luce2 = 3;

String readString ;

boolean LEDON1 = false ; // dichiarazione di una variabile boolean per verificare l'accenzione o meno del led

boolean LEDON2 = false ;

float temp1;      // variabile temperatura da rilevare


OneWire ourWireint(temperaturaint);
DallasTemperature sensoreint(&ourWireint);

double valtemperaturaint;



void setup() {


  Ethernet.begin(mac, ip, gateway, subnet); // inizializzazione dela comunicazione Ethernet


  pinMode(luce1, OUTPUT);   // dichiarazione del pin 2 come uscita

  pinMode(luce2, OUTPUT);

  Serial.begin(9600);  // inizializzazione della porta seriale di comunicazione
  sensoreint.begin();
}

void loop() {

  sensoreint.requestTemperatures();

  valtemperaturaint = sensoreint.getTempCByIndex(0);

  Serial.println("LA TEMPERATURA INTERNA E' = ");

  Serial.println(valtemperaturaint);

  Serial.println("*C ");



  /////       INIZIO CLIENT     /////

  EthernetClient client = server.available();
  if (client) {
    boolean currentLineIsBlank = true;
    while (client.connected()) {
      if (client.available()) {
        char c = client.read();
        readString.concat(c); //memorizzo ogni carattere della stringa
        //if HTTP request has ended
        if (c == '\n' && currentLineIsBlank) {
          Serial.print(readString);

          //ACCENZIONE LED
          if (readString.indexOf("leds1ON") > 0 ) {
            LEDON1 = true;

          }
          else if (readString.indexOf("leds1OFF") > 0) {
            LEDON1 = false;
          }

          if (LEDON1 == true) {
            digitalWrite(luce1, HIGH);
          }
          if (LEDON1 == false) {
            digitalWrite(luce1, LOW);
          }


          if (readString.indexOf("leds2ON") > 0 ) {
            LEDON2 = true;

          }
          else if (readString.indexOf("leds2OFF") > 0) {
            LEDON2 = false;
          }

          if (LEDON2 == true) {
            digitalWrite(luce2, HIGH);
          }
          if (LEDON2 == false) {
            digitalWrite(luce2, LOW);
          }

          client.println("HTTP/1.1 200 OK.....");
          client.println("Content-Type: text/html");
          client.println();
          // inizializzo pagina (da togliere se uso ajax)
          client.print("<html><head><title>ARDUINO Controllo Led via WEB</title></head><body>");
          //iniza il body
          client.println("<div style='width:1280px; height:720px;'>");
          client.println("<h1>STATO SENSORE</h1><hr />");


          client.println("<p>Stato LED 1 = ");
          client.println("<input type=text id=stato1 value=");
          client.println(LEDON1);
          client.println(">");
          client.println("  <br /></p>");


          client.println("<p>Stato LED 2 = ");
          client.println("<input type=text id=stato1 value=");
          client.println(LEDON2);
          client.println(">");
          client.println("  <br /></p>");
          client.println("<p>Temperatura Interna = ");
          client.println("<input type=text id=temperaturaint value=");
          client.println(valtemperaturaint);
          client.println(">");
          client.println("  <br /></p>");
          client.println("</body></html>");
          readString = "";
          client.stop();

        } // Fine lettura Stream
      } //Fine attivazione
    } //Fine connessione

  } // Fine client
} //  Fine loop
