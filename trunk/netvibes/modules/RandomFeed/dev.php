<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Strict//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-strict.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<title>Random Feed</title>
<meta name="author" content="Siddique Hameed" />
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />

  <link rel="stylesheet" type="text/css" href="http://www.netvibes.com/api/0.3/style.css" />
  <script type="text/javascript" src="http://www.netvibes.com/api/0.3/emulation.js"></script>

<?php 
    $height = "400";
	if(!empty($_COOKIE['height'])) {
		$height = $_COOKIE['height'];
	}	
?>
<script type="text/javascript">	
	NV_ONLOAD = function()
    {
		 if (getValue("randomfeed_user") != "true")
		 {
			saveDefaultPreferenceValues();
		 }

		 setIFrameSource();
		 setTitle(); 	
		 configureTooltip();	
		 saveValue("randomfeed_user","true");
    }

	function setIFrameSource(){
		var iFrameURL = "http://www.therandomhomepage.com/google/gadget/index.html?";
		for(var i = 1; i <= 5; i++){
			var url = getValue("up_url"+i);
			if (!isEmpty(url))
			{
				iFrameURL += "up_url"+i +"="+escape(url)+"&"; 
			}		
		}

		if (getValue("up_autoplay") == "on")
		{
			iFrameURL +="up_autoplay=1&up_delay="+getValue("up_delay")+"?";
		}

		var d = new Date();
		iFrameURL += "rnd="+d.getTime();
		var iFrame = NV_CONTENT.getElementsByTagName('iframe');
	    iFrame[0].src = iFrameURL;
	}

	function setTitle() {
		if (!isEmpty(getValue("title")))
		{
			NV_TITLE.innerHTML = getValue("title");
		}		
	}

	function isEmpty(value){
		return value == "" || value == "undefined" || value == "null" || value == null;
	}

	function saveDefaultPreferenceValues(){
		saveValue("up_url1","http://news.google.com/?output=rss");
		saveValue("up_url2","http://rss.news.yahoo.com/rss/topstories");
		saveValue("up_url3","http://www.digg.com/rss/index.xml");
		saveValue("up_url4","http://rss.msnbc.msn.com/id/3032091/device/rss/rss.xml");
		saveValue("up_url5","http://www.npr.org/rss/rss.php?id=1001");
	}

	function configureTooltip(){
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
	}
</script>
</head>

<body>
<table cellspacing="0" style="width:100% !important;background:#FFFFFF !important;padding:0px !important;margin:0px !important;border:0px !important;border-collapse:collapse !important">
<tr><td style="padding:1px !important;margin:0px !important;border:0px !important;">
  <iframe id="contentFrame" scrolling="auto" frameborder="0" style="display:block !important;width:100% !important;height:<?php echo htmlspecialchars($height) ?>px !important;background:#FFFFFF !important;padding:0px !important;margin:0px !important;border:0px !important;">Your browser does not support frames or is currently configured not to display frames.</iframe>
</td></tr>
</table>


<form class="configuration" method="post" action="">

  <table border="0">
    <tr>
      <td><label>Title:</label></td>
      <td><input name="title" type="text" value="Random Feed" size="40"/></td>
    </tr>
    <tr>
      <td><label>Height:</label></td>
      <td><input name="height" type="text" value="400"/></td>
    </tr>
	<tr>
	<td colspan="2"> 	
	  <ul class="nv-feedList"><label>List of RSS/Atom Feeds...</label>
	  <li><label>Feed 1:</label> <input name="up_url1" type="text" size="40"/></li>
	  <li><label>Feed 2:</label> <input name="up_url2" type="text" size="40"/></li>
	  <li><label>Feed 3:</label> <input name="up_url3" type="text" size="40"/></li>
	  <li><label>Feed 4:</label> <input name="up_url4" type="text" size="40"/></li>
	  <li><label>Feed 5:</label> <input name="up_url5" type="text" size="40"/></li>
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