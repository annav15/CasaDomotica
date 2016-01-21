<?php
//questo funziona solo su altervista
include ('db_conn.php');
$user=$_GET['username'];
$pass=$_GET['password'];
$q=mysql_query("SELECT username  FROM users WHERE username='$user' and password='$pass' ");
//$q=mysql_query("SELECT * FROM users WHERE username='michele'");
$resrow = mysql_fetch_assoc($q);
$json=json_encode($resrow['username']);
if($json=="null")

{
echo $output[]="non trovato";

} 
else
{
echo $output[]="trovato";


} 

mysql_close();


?>