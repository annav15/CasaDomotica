///////////////////////      LIBRERIE      ////////////////////////

#include <String.h>
#include<SPI.h>
#include <Ethernet.h>
#include <OneWire.h>    // librerie per il funzionamento dei sensori di temperatura 
#include <DallasTemperature.h>

#define temperaturaint A2  // dichiarazione dell'ingresso analogico di arduino per i sensori di temperatura
#define temperaturaest A3

#define fotoint A0   // ingressi analogici arduino per la fotoresistenza
#define fotoest A1


byte mac[] = { 0xDE, 0xAD, 0xBE, 0xEF, 0xFE, 0xED }; // mac address dell'arduino
byte ip[] = { 192, 168, 1, 58}; // indirizzo ip fisico di arduino
byte gateway[] = { 192, 168, 1, 1 }; // accesso ad internet via router
byte subnet[] = { 255, 255, 255, 0 }; //subnet mask
EthernetServer server(80); // porta di comunicazione del server

int luce1 = 2 ;   //pin di connessione led di arduino

int luce2 = 3;

int luce3 = 4;

int luceest = 5;

int caldaia = 6; // uscita led per il riscaldamento

int condizionatore = 7; // uscita led per il raffreddamento

String readString ;

boolean LEDON1 = false ; // dichiarazione di una variabile boolean per verificare l'accenzione o meno del led

boolean LEDON2 = false ;

boolean LEDON3 = false;

boolean LEDEST = false;

boolean CALDAIA = false;

boolean CONDIZIONATORE = false;


float temp1;      // variabile temperatura da rilevare
float temp2;

float tempregint = 25.0;
float tempregest = 25.0;


/// TEMPERATURA INTERNA///

OneWire ourWireint(temperaturaint);
DallasTemperature sensoreint(&ourWireint);

///TEMPERATURA ESTERNA///

OneWire ourWireest(temperaturaest);
DallasTemperature sensoreest(&ourWireint);

double valtemperaturaint; // variabile di lettura del valore di temperatira dei sensori
double valtemperaturaest;



void setup() {


  Ethernet.begin(mac, ip, gateway, subnet); // inizializzazione dela comunicazione Ethernet


  pinMode(luce1, OUTPUT);   // dichiarazione del pin 2 come uscita

  pinMode(luce2, OUTPUT);

  pinMode(luce3, OUTPUT);

  pinMode(luceest, OUTPUT);

  pinMode(caldaia, OUTPUT);

  pinMode(condizionatore, OUTPUT);

  Serial.begin(9600);  // inizializzazione della porta seriale di comunicazione

  sensoreint.begin();
  sensoreest.begin();
}

void loop() {

  /// LETTURA VALORI DI LUMINOSITA ///

  int luminositaint = analogRead(fotoint);
  int luminositaest = analogRead(fotoest);



  /// CONTROLLO AUTOMATICO LUMINOSITA INTERNA ///



  if ((luminositaint < 250) && (readString.indexOf("automatico") > 0))

  {

    digitalWrite(luce1, HIGH);
    digitalWrite(luce2, HIGH);
    digitalWrite(luce3, HIGH);
    delay (1000);


  }

  else {

    digitalWrite(luce1, LOW);
    digitalWrite(luce2, LOW);
    digitalWrite(luce3, LOW);
    delay (1000);


  }



  /// CONTROLLO AUTOMATICO LUMINOSITA ESTERNA ///

  if ((luminositaest < 650) && (readString.indexOf("automatico") > 0))

  {

    digitalWrite(luceest, HIGH);

    delay (1000);


  }

  else {

    digitalWrite(luceest, LOW);

    delay (1000);


  }



  /// CALCOLO VALORE DELLA TEMPERATURA INTERNA ///

  sensoreint.requestTemperatures();

  valtemperaturaint = sensoreint.getTempCByIndex(0);

  Serial.println("LA TEMPERATURA INTERNA E' = ");

  Serial.println(valtemperaturaint);

  Serial.println("*C ");

  /// CONTROLLO TEMPERATURA INTERNA PER ACCENSIONE CONDIZIONAMENTO

  if (valtemperaturaint >= 27)

    digitalWrite(condizionatore, HIGH);
  else
    digitalWrite(condizionatore, LOW);

  /// CONTROLLO TEMPERATURA INTERNA PER ACCENSIONE CALDAIA

  if (valtemperaturaint <= 18)
    digitalWrite(caldaia, HIGH);
  else
    digitalWrite(caldaia, LOW);




  // CALCOLO VALORE DELLA TEMPERATURA ESTERNA ///

  sensoreest.requestTemperatures();

  valtemperaturaest = sensoreest.getTempCByIndex(0);

  Serial.println("LA TEMPERATURA ESTERNA E' = ");

  Serial.println(valtemperaturaest);

  Serial.println("*C ");



  /// CONTROLLO AUTOMATICO CONDIZIONAMENTO ///

  if ((valtemperaturaint < tempregint - 5) && (readString.indexOf("automatico") > 0))
  {

    digitalWrite(caldaia, HIGH);
    digitalWrite(condizionatore, LOW);
  }
  if ((valtemperaturaint > tempregint + 5) && (readString.indexOf("automatico") > 0))
  {
    digitalWrite(condizionatore, HIGH);
    digitalWrite(caldaia, HIGH);

  }

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


          //// COMANDI ACCENDI E SPEGNI TUTTO INTERNO

          if (readString.indexOf("accendituttointerno") > 0 ) {

            LEDON1 = true;
            LEDON2 = true;
            LEDON3 = true;

            digitalWrite(luce1, HIGH);
            digitalWrite(luce2, HIGH);
            digitalWrite(luce3, HIGH);
          }

          if (readString.indexOf("spegnituttointerno") > 0 ) {
            LEDON1 = false;
            LEDON2 = false;
            LEDON3 = false;

            digitalWrite(luce1, LOW);
            digitalWrite(luce2, LOW);
            digitalWrite(luce3, LOW);



          }



          //ACCENZIONE LED1

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

          //ACCENZIONE LED2

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

          //ACCENZIONE LED3

          if (readString.indexOf("leds3ON") > 0 ) {
            LEDON3 = true;

          }
          else if (readString.indexOf("leds3OFF") > 0) {
            LEDON3 = false;
          }

          if (LEDON3 == true) {
            digitalWrite(luce3, HIGH);
          }
          if (LEDON3 == false) {
            digitalWrite(luce3, LOW);
          }

          //ACCENZIONE LEDEST

          if (readString.indexOf("ledestON") > 0 ) {
            LEDEST = true;

          }
          else if (readString.indexOf("ledestOFF") > 0) {
            LEDEST = false;
          }

          if (LEDEST == true) {
            digitalWrite(luceest, HIGH);
          }
          if (LEDEST == false) {
            digitalWrite(luceest, LOW);
          }

          /// PAGINA WEB

          client.println("HTTP/1.1 200 OK.....");
          client.println("Content-Type: text/html");
          client.println();
          // inizializzo pagina (da togliere se uso ajax)
          client.print("<html><head><title>ARDUINO Controllo Led e Temperatura via WEB</title></head><body>");
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


          client.println("<p>Stato LED 3 = ");
          client.println("<input type=text id=stato1 value=");
          client.println(LEDON3);
          client.println(">");
          client.println("  <br /></p>");


          client.println("<p>Stato LED ESTERNO = ");
          client.println("<input type=text id=stato1 value=");
          client.println(LEDEST);
          client.println(">");
          client.println("  <br /></p>");


          client.println("<p>Temperatura Interna = ");
          client.println("<input type=text id=temperaturaint value=");
          client.println(valtemperaturaint);
          client.println(">");
          client.println("  <br /></p>");


          client.println("<p>Temperatura esterna = ");
          client.println("<input type=text id=temperaturaest value=");
          client.println(valtemperaturaest);
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
