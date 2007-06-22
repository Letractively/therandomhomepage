<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.0 Transitional//EN">
<HTML>
<HEAD>
<TITLE>Random Flickring</TITLE>
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

	$tags = "colorful,travel";
	if(!empty($_GET['tags'])) {
		$tags = $_GET['tags'];
	}

	$transition_effect = -1;
	if(!empty($_GET['transition_effect'])) {
		$transition_effect = $_GET['transition_effect'];
	}

	$slideshow_delay = 0;
	if(!empty($_GET['slideshow_delay'])) {
		$slideshow_delay = $_GET['slideshow_delay'];
	}

?>

<center>
<IFRAME frameborder="0"
		src="http://gmodules.com/ig/ifr?url=http://www.therandomhomepage.com/google/gadgets/RandomFlickr/module.xml&amp;up_moduletitle=Random Wikipedia Article&amp;up_tags=<?php echo htmlspecialchars($tags) ?>&amp;up_transition_effect=<?php echo htmlspecialchars($transition_effect) ?>&amp;up_slideshow_delay=<?php echo htmlspecialchars($slideshow_delay) ?>&amp;synd=open&amp;w=<?php echo htmlspecialchars($width) ?>&amp;h=<?php echo htmlspecialchars($height) ?>&amp;title=&amp;lang=en&amp;country=ALL&amp;border=%23ffffff%7C3px%2C1px+solid+%23999999&amp;" style="display: block; margin-left: 5px; margin-right: 5px; width: <?php echo htmlspecialchars($width) ?>px; height: <?php echo htmlspecialchars($height) ?>px;"/>
</center>
 <script src="http://www.google-analytics.com/urchin.js" type="text/javascript">
</script>
<script type="text/javascript">
_uacct = "UA-941159-1";
urchinTracker();
</script>
</BODY>
</HTML>
