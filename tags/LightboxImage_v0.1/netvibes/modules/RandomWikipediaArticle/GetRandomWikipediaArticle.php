<?
$URL="http://www.phonifier.com/phonify.php?i=1&m=0&l=0&u=".$_GET["url"];
//$URL="http://www.therandomhomepage.com/netvibes/modules/RandomWikipediaArticle/phonifier/index.php?i=1&m=0&l=0&u=".$_GET["url"];
$ch = curl_init();
curl_setopt($ch, CURLOPT_VERBOSE, 1);
//curl_setopt ($ch, CURLOPT_PROXYTYPE, CURLPROXY_HTTP);
//curl_setopt ($ch, CURLOPT_PROXY,"http://64.202.165.130:3128");
curl_setopt ($ch, CURLOPT_SSL_VERIFYPEER, FALSE);
curl_setopt ($ch, CURLOPT_URL, $URL);
//curl_setopt($ch, CURLOPT_RETURNTRANSFER, 1);
curl_setopt ($ch, CURLOPT_TIMEOUT, 360);
$result = curl_exec ($ch);
curl_close ($ch);
?>