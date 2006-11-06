<?
$URL="http://www.phonifier.com/phonify.php?i=1&m=0&l=0&u=".$_GET["url"];
$ch = curl_init();
curl_setopt($ch, CURLOPT_VERBOSE, 1);
curl_setopt ($ch, CURLOPT_SSL_VERIFYPEER, FALSE);
curl_setopt ($ch, CURLOPT_URL, $URL);
curl_setopt ($ch, CURLOPT_TIMEOUT, 120);
$result = curl_exec ($ch);
curl_close ($ch);
?>