<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.0 Transitional//EN">
<HTML>
<HEAD>
<TITLE>Random Wikipedia Article</TITLE>
</HEAD>
<BODY>
<?php
    $height = "350";
	if(!empty($_GET['height'])) {
		$height = $_GET['height'];
	}

    $width = "350";
	if(!empty($_GET['width'])) {
		$width = $_GET['width'];
	}

	$lang = "en";
	if(!empty($_GET['lang'])) {
		$lang = $_GET['lang'];
	}

	//$_SERVER["HTTP_ACCEPT_LANGUAGE"];
?>

<center>
<IFRAME frameborder="0"
		src="http://gmodules.com/ig/ifr?url=http://www.therandomhomepage.com/google/gadgets/randomwiki/RandomWikiModule.xml&amp;up_moduletitle=Random Wikipedia Article&amp;up_language=<?php echo htmlspecialchars($lang) ?>&amp;synd=open&amp;w=<?php echo htmlspecialchars($width) ?>&amp;h=<?php echo htmlspecialchars($height) ?>&amp;title=&amp;lang=en&amp;country=ALL&amp;border=%23ffffff%7C3px%2C1px+solid+%23999999&amp;" style="display: block; margin-left: 5px; margin-right: 5px; width: <?php echo htmlspecialchars($width) ?>px; height: <?php echo htmlspecialchars($height) ?>px;"/>
</center>
 <script src="http://www.google-analytics.com/urchin.js" type="text/javascript">
</script>
<script type="text/javascript">
_uacct = "UA-941159-1";
urchinTracker();
</script>
</BODY>
</HTML>
