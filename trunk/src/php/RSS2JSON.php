<?
$url = $_GET['url'];
require('magpie/rss_fetch.inc');  // From MagpieRSS
require('json/JSON.php');      // From JSON-PHP

// fetch the RSS feed
$rss = fetch_rss($url);

// new JSON object
$json = new services_JSON();

// encode the RSS feed
$output = $json->encode($rss->items);
print($output);
?>
