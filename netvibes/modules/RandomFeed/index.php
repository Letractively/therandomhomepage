<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Strict//EN"
  "http://www.w3.org/TR/xhtml1/DTD/xhtml1-strict.dtd">
<html xmlns="http://www.w3.org/1999/xhtml"
  xmlns:widget="http://www.netvibes.com/ns/">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<meta http-equiv="Expires" content="" />
<meta name="author" content="Siddique Hameed" />
<meta name="description" content="Random Feed" />
<meta name="apiVersion" content="1.0" />
<meta name="inline" content="true" />
<meta name="autoRefresh" content="20" />
<meta name="debugMode" content="true" />
<title>Random Feed</title>
<link rel="stylesheet" type="text/css"
	href="http://www.netvibes.com/themes/uwa/style.css" />
<script type="text/javascript"
  src="http://www.netvibes.com/js/UWA/load.js.php?env=Standalone"></script>

<widget:preferences>
      <preference name="title" type="text" label="Title:" defaultValue="Random Feed" onchange="refresh"/>
      <preference name="up_url1" type="text" label="RSS/Atom Feed 1:" defaultValue="http://news.google.com/?output=rss" onchange="refresh"/>
	  <preference name="up_url2" type="text" label="RSS/Atom Feed 2:" defaultValue="http://rss.news.yahoo.com/rss/topstories" onchange="refresh"/>
	  <preference name="up_url3" type="text" label="RSS/Atom Feed 3:" defaultValue="http://rss.msnbc.msn.com/id/3032091/device/rss/rss.xml" onchange="refresh"/>
	  <preference name="up_url4" type="text" label="RSS/Atom Feed 4:" defaultValue="http://www.digg.com/rss/index.xml" onchange="refresh"/>
	  <preference name="up_url5" type="text" label="RSS/Atom Feed 5:" defaultValue="http://www.npr.org/rss/rss.php?id=1001" onchange="refresh"/>
	  <preference name="up_autoplay" type="boolean" label="Autoplay?" defaultValue="true" onchange="refresh"/>
	  <preference name="up_delay" type="list" label="Delay in seconds:" defaultValue="5" onchange="refresh">
	    <option value="5" label="5" />
		<option value="10" label="10" />
        <option value="15" label="15" />
		<option value="20" label="20" />
		<option value="25" label="25" />
		<option value="30" label="30" />
		<option value="35" label="35" />
		<option value="40" label="40" />
		<option value="45" label="45" />
		<option value="50" label="50" />
		<option value="55" label="55" />
		<option value="60" label="60" />
	  </preference>
</widget:preferences>

<script type="text/javascript">
	widget.onLoad = function()
    {
		 if (widget.getValue("randomfeed_user") != "true")
		 {
			saveDefaultPreferenceValues();
		 }

		 setIFrameSource();
		 setTitle();
		 widget.setValue("randomfeed_user","true");
    }

	function setIFrameSource(){
		var iFrameURL = "http://www.therandomhomepage.com/google/gadget/index.html?";
		for(var i = 1; i <= 5; i++){
			var url = widget.getValue("up_url"+i);
			if (!isEmpty(url))
			{
				iFrameURL += "up_url"+i +"="+escape(url)+"&";
			}
		}


		if (widget.getValue("up_autoplay") == "true")
		{
			iFrameURL +="up_autoplay=1&up_delay="+widget.getValue("up_delay")+"?";
		}

		var d = new Date();
		iFrameURL += "rnd="+d.getTime();
		try
		{
			var iFrame = widget.body.getElementsByClassName('contentFrame');
			iFrame[0].src = iFrameURL;
		}
		catch (error)
		{
			alert("error = "+error);
		}
	}

	function setTitle() {
		if (!isEmpty(widget.getValue("title")))
		{
			widget.setTitle(widget.getValue("title"));
		}
	}

	function isEmpty(value){
		return value == "" || value == "undefined" || value == "null" || value == null;
	}

	function saveDefaultPreferenceValues(){
		widget.setValue("up_url1","http://news.google.com/?output=rss");
		widget.setValue("up_url2","http://rss.news.yahoo.com/rss/topstories");
		widget.setValue("up_url3","http://www.digg.com/rss/index.xml");
		widget.setValue("up_url4","http://rss.msnbc.msn.com/id/3032091/device/rss/rss.xml");
		widget.setValue("up_url5","http://www.npr.org/rss/rss.php?id=1001");
	}

</script>
</head>

<body>
<table cellspacing="0" style="!important;width:100% !important;height:300px  !important;background:#FFFFFF !important;padding:0px !important;margin:0px !important;border:0px !important;border-collapse:collapse !important">
<tr><td style="padding:1px !important;margin:0px !important;border:0px !important;">
  <iframe class="contentFrame" scrolling="auto" frameborder="0" style="display:block !important;width:100% !important;height:300px !important;background:#FFFFFF !important;padding:0px !important;margin:0px !important;border:0px !important;">Your browser does not support frames or is currently configured not to display frames.</iframe>
</td></tr>
</table>
</body>
</html>