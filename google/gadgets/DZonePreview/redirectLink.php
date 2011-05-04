<?php
require( "LinkExtractor.class.php" );

function readUrl( $url ) {
	if( @$fp = fopen( $url, "r" ) ) {
		$st = '';
		while( $text = fread( $fp, 8192 ) ) {
			$st .= $text;
		}
		fclose( $fp );
		return extractBetweenDelimeters( $st, '<div class="ldThumb">', '</div>');
	}
	return false;
}

function mystripos($str, $needle, $offset = 0) {
        return strpos(strtolower($str), strtolower($needle), $offset);
}


function extractBetweenDelimeters($inputstr,$delimeterLeft,$delimeterRight) {
   $posLeft  = mystripos($inputstr,$delimeterLeft)+strlen($delimeterLeft);
   $posRight = mystripos($inputstr,$delimeterRight,$posLeft+1);
   return  substr($inputstr,$posLeft,$posRight-$posLeft);
}

// EXAMPLE
//$url = "http://www.dzone.com/links/rss/setting_up_sqlite3_for_ruby_on_rails_development.html"; // site to parse

$url = $_GET["url"];

$result = &readUrl($url);
//echo $result;

$myLinks = &new LinkExtractor(); // create a LinkExtractor Object
$myLinks->parseString( $result ); // parse a string
for( $a = 0, $b = count( $fetchLinks = $myLinks->getLinks() ); $a < $b; $a++ ) {
	//echo $fetchLinks[$a];
	header( 'Location: '.$fetchLinks[$a] ) ;
}
?>