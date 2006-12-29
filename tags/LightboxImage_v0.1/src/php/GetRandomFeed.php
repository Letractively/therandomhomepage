<?php
$redirectURL = "RSS2JSON.php?url=http://news.google.com/?output=rss";
if (count($_GET) > 0) {
	$randomKey = array_rand($_GET,1);
	$redirectURL =  "RSS2JSON.php?url=".$_GET[$randomKey];
}
header( 'Location: '.$redirectURL) ;
?>
