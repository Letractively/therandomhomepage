<?
	require_once('/magpie/rss_fetch.inc');
	$url = $_GET['url'];
	$rss = fetch_rss( $url );
	
	echo "Channel Title: " . $rss->channel['title'] . "<p>";
	echo "<ul>";
	foreach ($rss->items as $item) {
		$href = $item['link'];
		$title = $item['title'];
		echo "<li><a href=$href>$title</a></li>";
	}
	echo "</ul>";
?>
