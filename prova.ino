//////////////////////      LIBRERIE      ////////////////////////

#include <Dhcp.h>
#include <Dns.h>
#include <Ethernet.h>
#include <EthernetClient.h>
#include <EthernetServer.h>
#include <EthernetUdp.h>

#include <SPI.h>

#include <String.h>


byte mac[] = { 0xDE, 0xAD, 0xBE, 0xEF, 0xFE, 0xED }; // mac address dell'arduino
byte ip[] = { 192,168,1,58};// indirizzo ip fisico di arduino 
byte gateway[] = { 192,168,1,1 }; // accesso ad internet via router 
byte subnet[] = { 255, 255, 255, 0 }; //subnet mask
EthernetServer server(80); // porta di comunicazione del server 

int luce1 = 2   //pin di connessione led di arduino 
boolean LEDON1=false; // dichiarazione di una variabile boolean per verificare l'accenzione o meno del led




void setup() {
  
  Ethernet.begin(mac,ip,gateway,subnet);  // inizializzazione dela comunicazione Ethernet   
  pinMode(luce1, OUTPUT);   // dichiarazione del pin 2 come uscita 

  Serial.begin(9600);  // inizializzazione della porta seriale di comunicazione 

}

void loop() {


  EthernetClient client = server.available();
if (client) {  boolean currentLineIsBlank = true; 
while (client.connected()) {
  if (client.available()) {
    char c = client.read(); 
    readString.concat(c); //memorizzo ogni carattere della stringa   
    //if HTTP request has ended  
    if (c == '\n' && currentLineIsBlank) {  
      Serial.print(readString); 
  
    }
}
