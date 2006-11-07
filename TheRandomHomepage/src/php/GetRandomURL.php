<?php

$url = array();
$i = 0;
if ($_GET["url1"] != ''){
	$url[$i++] = $_GET["url1"];
}
if ($_GET["url2"] != ''){
	$url[$i++] = $_GET["url2"];
}
if ($_GET["url3"] != ''){
	$url[$i++] = $_GET["url3"];
}
if ($_GET["url4"] != ''){
	$url[$i++] = $_GET["url4"];
}
if ($_GET["url5"] != ''){
	$url[$i++] = $_GET["url5"];
}

$rand_key = array_rand($url);
print $url[$rand_key];
?>
