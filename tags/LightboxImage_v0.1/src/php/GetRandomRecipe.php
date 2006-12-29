<?
require_once("configuration.php");

$conector = mysql_connect($db_host, $db_user, $db_password) or die(mysql_error());
mysql_select_db($db_instance) or die(mysql_error());

$sqlQuery = "SELECT url FROM ".$db_table_prefix."recipes ORDER BY RAND() LIMIT 1";

$result = mysql_query($sqlQuery) or die(mysql_error());

$row = mysql_fetch_row($result);
$redirectedURL = "RSS2JSON.php?url=".$row[0];
header( 'Location: '.$redirectedURL ) ;
?>