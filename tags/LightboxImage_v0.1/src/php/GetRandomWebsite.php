<?
require_once("configuration.php");
require_once("json/JSON.php");

$conector = mysql_connect($db_host, $db_user, $db_password) or die(mysql_error());
mysql_select_db($db_instance) or die(mysql_error());

$sqlQuery = "SELECT url FROM ".$db_table_prefix."websites ORDER BY RAND() LIMIT 1";

$result = mysql_query($sqlQuery) or die(mysql_error());

$row = mysql_fetch_row($result);

$value{"RandomWebsite"}{"URL"}=$row[0];

$json = new Services_JSON();
$output = $json->encode($value);
print($output);
?>
