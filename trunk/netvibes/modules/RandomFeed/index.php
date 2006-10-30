<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Strict//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-strict.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<?php if(empty($_COOKIE['title'])) { ?>
<title>Random Feed</title>
<meta name="author" content="Siddique Hameed" />
<?php } else { ?>
<title><?php echo htmlspecialchars($_COOKIE['title']) ?></title>
<?php } ?>

  <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />

  <link rel="stylesheet" type="text/css" href="http://www.netvibes.com/api/0.3/style.css" />
  <script type="text/javascript" src="http://www.netvibes.com/api/0.3/emulation.js"></script>

<?php 
    $height = "400";

	if(!empty($_COOKIE['height'])) {
		$height = $_COOKIE['height'];
	}	

	$iFrameURL = "http://www.therandomhomepage.com/google/gadget/index.html?";

	if(!empty($_COOKIE['up_url1'])) {
		$iFrameURL = $iFrameURL . "up_url1=". htmlspecialchars($_COOKIE['up_url1']). "&"; 
	}	

	if(!empty($_COOKIE['up_url2'])) {
		$iFrameURL = $iFrameURL . "up_url2=". htmlspecialchars($_COOKIE['up_url2']). "&"; 
	}	

	if(!empty($_COOKIE['up_url3'])) {
		$iFrameURL = $iFrameURL . "up_url3=". htmlspecialchars($_COOKIE['up_url3']). "&"; 
	}	

	if(!empty($_COOKIE['up_url4'])) {
		$iFrameURL = $iFrameURL . "up_url4=". htmlspecialchars($_COOKIE['up_url4']). "&"; 
	}	

	if(!empty($_COOKIE['up_url5'])) {
		$iFrameURL = $iFrameURL . "up_url5=". htmlspecialchars($_COOKIE['up_url5']). "&"; 
	}	

	if($_COOKIE['up_autoplay'] == "on") {
		$iFrameURL = $iFrameURL . "up_autoplay=1&up_delay=". $_COOKIE['up_delay'];
	}	

?>
<script type="text/javascript">	
	NV_ONLOAD = function()
    {
		 var tr = NV_CONTENT.getElementsByTagName('tr')[0];
		 if (tr)
		 {
			 tr.onmouseover = function()
			 {
				if (getValue("up_autoplay") != "on")
				{
					setToolTip(this, 'Click on the arrow (&gt;&gt;) to see next random item.');
				}
			 }
		 }

		 saveValue("randomfeed_user","true");
    }
</script>
</head>

<body>
<table cellspacing="0" style="width:100% !important;background:#FFFFFF !important;padding:0px !important;margin:0px !important;border:0px !important;border-collapse:collapse !important">
<tr><td style="padding:1px !important;margin:0px !important;border:0px !important;">
  <iframe id="contentFrame" src="<?php echo htmlspecialchars($iFrameURL) ?>" scrolling="auto" frameborder="0" style="display:block !important;width:100% !important;height:<?php echo htmlspecialchars($height) ?>px !important;background:#FFFFFF !important;padding:0px !important;margin:0px !important;border:0px !important;">Your browser does not support frames or is currently configured not to display frames.</iframe>
</td></tr>
</table>


<form name="frmConfiguration" class="configuration" method="post" action="">

  <table border="0">
    <tr>
      <td><label>Title:</label></td>
      <td><input name="title" type="text" value="Random Feed" size="40"/></td>
    </tr>
    <tr>
      <td><label>Height:</label></td>
      <td><input name="height" type="text" value="400" /></td>
    </tr>
	<tr>
	<td colspan="2"> 	
	  <ul class="nv-feedList"><label>List of RSS/Atom Feeds...</label>
	  <li><label>Feed 1:</label> <input name="up_url1" type="text" 
				<?php if(empty($_COOKIE['randomfeed_user'])) { ?>
					value="http://news.google.com/?output=rss"
				<?php } else {?>
					value="<?php echo htmlspecialchars($_COOKIE['up_url1']) ?>"
				<?php } ?>	
	  size="40"/></li>
	  <li><label>Feed 2:</label> <input name="up_url2" type="text" 
			<?php if(empty($_COOKIE['randomfeed_user'])) { ?>
					value="http://rss.news.yahoo.com/rss/topstories"
				<?php } else {?>
					value="<?php echo htmlspecialchars($_COOKIE['up_url2']) ?>"
				<?php } ?>	
	  size="40"/></li>
	  <li><label>Feed 3:</label> <input name="up_url3" type="text" 
			<?php if(empty($_COOKIE['randomfeed_user'])) { ?>
					value="http://www.digg.com/rss/index.xml"
				<?php } else {?>
					value="<?php echo htmlspecialchars($_COOKIE['up_url3']) ?>"
				<?php } ?>	
	  size="40"/></li>
	  <li><label>Feed 4:</label> <input name="up_url4" type="text" 
			<?php if(empty($_COOKIE['randomfeed_user'])) { ?>
					value="http://rss.msnbc.msn.com/id/3032091/device/rss/rss.xml"
				<?php } else {?>
					value="<?php echo htmlspecialchars($_COOKIE['up_url4']) ?>"
				<?php } ?>	
	  size="40"/></li>
	  <li><label>Feed 5:</label> <input name="up_url5" type="text" 
			<?php if(empty($_COOKIE['randomfeed_user'])) { ?>
					value="http://www.npr.org/rss/rss.php?id=1001"
				<?php } else {?>
					value="<?php echo htmlspecialchars($_COOKIE['up_url5']) ?>"
				<?php } ?>	
	  size="40"/></li>
	  </ul>
	</td>
	</tr>
	<tr>
	  <td colspan="2">
	  <label>Slideshow? :</label> <input name="up_autoplay" type="checkbox"    <?
					 // If checkbox was selected, or no value exists, set it to checked.
					 if ($_COOKIE['up_autoplay'] == "on") {
						 echo " checked=\"checked\"";
					 }
				 ?> />
	  </td>
	</tr>
	<tr>
	  <td colspan="2">
	  <label>Slideshow delay in seconds:</label> <select name="up_delay"><option value="5">5</option><option selected="selected" value="10">10</option><option value="15">15</option><option value="20">20</option><option value="25">25</option><option value="30">30</option><option value="35">35</option><option value="40">40</option><option value="45">45</option><option value="50">50</option><option value="55">55</option><option value="60">60</option>
	  </select>
	  </td>
	</tr>
  </table>
  <input type="submit" value="OK" />

</form>

</body>
</html>