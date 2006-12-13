<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Strict//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-strict.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<title>Random Flickring</title>
<link rel="icon" type="image/png" href="http://www.flickr.com/favicon.ico"/>
<meta name="author" content="Siddique Hameed"/>
<!--
	Last Updated: 12/13/2006
	Version 0.1
-->
<meta http-equiv="Content-Type" content="text/html; charset=utf-8"/>
<link rel="stylesheet" type="text/css" href="http://www.netvibes.com/api/0.3/style.css"/>
<script type="text/javascript" src="http://www.netvibes.com/api/0.3/emulation.js"></script>
<style type="text/css">
	img {
		border-style: none;
		cursor: pointer;
	}

	table {
		width: 100%;
		height: 300px;
	}

	#divRandomFlickrControl {
		cursor: pointer;
		color: darkblue;
		font-family: Arial, sans-serif;
		font-weight: bold;
	}

	#divRandomFlickrHeader {
		color: black;
		font-weight: bold;
		text-align: center;
	}
	#divRandomFlickrContent {
		text-align: center;
	}
</style>
<script type="text/javascript">
<?php include '../../../js/effects.js';?>

<?php include '../../../js/lightbox_s.js';?>

<?php include '../../../js/effectshelper.js';?>

<?php include '../../../js/utils.js';?>

<?php include '../../../js/urchin.js';?>
</script>

<script type="text/javascript">
var rssFeedArr = new Array();

var prevIdx = -1;

var tags = "art,colorful,travel";
var transitionEffect = 0;
var imageClickBehaviour = 0;
var slideshowDelay = 0;

var controlElement = null;

var shouldBeRunning = true;
var pe = null;

var RssFeed = Class.create();

	RssFeed.prototype = {

	   initialize: function(idx,title,link,desc,contentURL,thumbnailURL) {
			this.idx = idx;
			this.title = title;
			this.link = link;
			this.desc = desc;
			this.contentURL = contentURL;
			this.thumbnailURL = thumbnailURL;
	   },

	   getImage:function() {
		  var imgHTML =  "<a title='"+this.title+"' target='_new' id='lightboxAnc"+this.idx+"' style='display: none;' ";

		  if (imageClickBehaviour == 2) {
			imgHTML += " href='"+this.link+"' ";
		  }
		  else {
			imgHTML += " href='"+this.contentURL+"' ";
		  }

		  if (imageClickBehaviour == 0)
		  {
			imgHTML += " rel='lightbox["+tags+"]' ";
		  }

		  if (slideshowDelay > 0)
		  {
				imgHTML += " startslideshow='true' slideDuration='"+slideshowDelay+"' forever='true' ";
		  }
		  else {
			imgHTML += " startslideshow='false' ";
		  }
		  imgHTML += " >"+extractBetween(this.desc,"<img",">")+"</a>";
		  return imgHTML;
	   },

	   getTitle:function() {
		  return this.title;
	   }
	};

	function xmlResponseHandler(xhr) {
		var response = xhr.responseXML.documentElement
		var items = response.getElementsByTagName("item");
		var nodes = $A(items);
		var i = 0;

		nodes.each(function(itemNode){
				var title = getChildNodeValueByNodeName(itemNode,"title");
				var link = getChildNodeValueByNodeName(itemNode,"link");
				var desc = getChildNodeValueByNodeName(itemNode,"description");
				var content = getChildNodeByNodeName(itemNode,"media:content").getAttribute("url");
				var thumbnail = getChildNodeByNodeName(itemNode,"media:thumbnail").getAttribute("url");
				rssFeedArr[i] = new RssFeed(i,title,link,desc,content,thumbnail);
				i++;
	    });

		if (nodes.length > 0)
		{

			var lightboxHTML = "";
			rssFeedArr.each( function(rssFeed){
				lightboxHTML += rssFeed.getImage();
			});


			var divContent = $('divRandomFlickrContent');

			if (divContent)
			{
				Element.update(divContent,lightboxHTML);
			}

			try
			{
				if (imageClickBehaviour == 0)
				{
					var overlayElement = $('overlay');

					if (overlayElement)
					{
						Element.remove(overlayElement);
					}

					var lightboxElement = $('lightbox');

					if (lightboxElement)
					{
						Element.remove(lightboxElement);
					}
					initLightbox();

				}
				showRandomFlickrImage();
			}
			catch (e)
			{
				$('divRandomFlickrContent').innerHTML = "Error "+e;
			}

			controlElement = $('divRandomFlickrControl');



			if (slideshowDelay > 0)
			{
				pe = new PeriodicalExecuter(showRandomFlickrImage, slideshowDelay);

				Element.update(controlElement,"<img src='http://www.therandomhomepage.com/images/lightbox/stop.gif' title='Stop Slideshow'/>");
				controlElement.onclick = stopSlideShow;
				divContent.onclick = stopSlideShow;
			}
			else {
				Element.update(controlElement,"&gt;&gt;");
				$("divRandomFlickrHeader").title = "Click on the arrows (>>) for next random picture";
				controlElement.title = "Next Random Picture";
				controlElement.onclick = function() {
					showRandomFlickrImage();
				}
			}
		}
		else {
			$('divRandomFlickrContent').innerHTML = "<center><I>Error retrieving pictures from Flickr! <br/>Please verify the tag names and try again later.</I></center>";
		}
	}

	function showRandomFlickrImage(){
		if (shouldBeRunning)
		{
			if (prevIdx > -1)
			{
				var prevAnchorElement = $('lightboxAnc'+prevIdx);
				Element.hide(prevAnchorElement);
			}

			var randIdx = getRandomNo(rssFeedArr.length);

			var ancElem = $('lightboxAnc'+randIdx);
			if (ancElem)
			{
				$("divRandomFlickrHeader").innerHTML = rssFeedArr[randIdx].getTitle();
				Element.show(ancElem);
				applyEffect($("divRandomFlickrContent"),transitionEffect);
				prevIdx = randIdx;
			}
		}
	}


	function stopSlideShow(){
		if (shouldBeRunning)
		{
			Element.update(controlElement,"<img src='http://www.therandomhomepage.com/images/lightbox/start.gif' title='Start Slideshow'/>");
			controlElement.onclick = startSlideShow;
			shouldBeRunning = false;
		}
	}

	function startSlideShow(){
		if (!shouldBeRunning)
		{
			Element.update(controlElement,"<img src='http://www.therandomhomepage.com/images/lightbox/stop.gif' title='Stop Slideshow'/>");
			controlElement.onclick = stopSlideShow;
			shouldBeRunning = true;
		}
	}

	function initPreferenceValues() {
		if (!isEmpty(getValue(tags)))
		{
			tags = getValue("tags");
		}

		if (!isEmpty(getValue("transition_effect")))
		{
			transitionEffect = parseInt(getValue("transition_effect"));
		}

		if (!isEmpty(getValue("image_click_behaviour")))
		{
			imageClickBehaviour = parseInt(getValue("image_click_behaviour"));
		}

		if (!isEmpty(getValue("slideshow_delay")))
		{
			slideshowDelay = parseInt(getValue("slideshow_delay"));
		}
	}

	function randomFlickrLoad(){
		var flickrFeedURL = "http://www.flickr.com/services/feeds/photos_public.gne?tags="+tags+"&format=rss_200";
		if (!NV_XML_REQUEST_URL )
		{
			NV_XML_REQUEST_URL = "http://www.netvibes.com/xmlProxy.php";
		}
		var request = new Ajax.Request(NV_XML_REQUEST_URL + '?url=' + escape(flickrFeedURL), { method: 'get', onSuccess: xmlResponseHandler});
	}

	function applyLightboxStyleSheet() {
		if(document.createStyleSheet) {
			//alert("Creating stylesheet");
			document.createStyleSheet('http://www.therandomhomepage.com/css/lightbox.css');
		}
		else {
			var style = document.createElement('link');
			style.setAttribute('rel', 'stylesheet');
			style.setAttribute('type', 'text/css');
			style.setAttribute('media', 'screen');
			style.setAttribute('href', 'http://www.therandomhomepage.com/css/lightbox.css' );
			var head = document.getElementsByTagName('head').item(0);
			head.appendChild( style );
		}
	}

function setTitle() {
    if (!isEmpty(getValue("title")))
    {
        NV_TITLE.innerHTML = getValue("title");
    }
}


NV_ONLOAD = function()
{
	applyLightboxStyleSheet();
	setTitle();
	initPreferenceValues();
	randomFlickrLoad();
	_uacct = "UA-941159-1";
	urchinTracker();
}
</script>
</head>

<body>
<table><tr><td><div id="divRandomFlickrHeader"></div></td><td align="right" valign="top"><div id="divRandomFlickrControl"></div></td></tr>
<tr colspan="2"><td><div id="divRandomFlickrContent" /></td></tr>
</table>
<form class="configuration" method="post" action="">
    <table border="0">
        <tr>
            <td><label>Title:</label></td>
            <td><input name="title" type="text" value="Random Flickring" size="20"/></td>
        </tr>
        <tr>
            <td><label>Tags(comma separated):</label></td>
            <td><input name="tags" type="text" value="art,colorful,travel" size="30"/></td>
        </tr>
        <tr>
            <td><label>Transition effect:</label></td>
            <td>
                <select name="transition_effect" style="vertical-align: top; padding: 0; margin: 0 0.4em;">
                    <option value="-1">None</option>
                    <option value="0" selected="selected">Random</option>
                    <option value="1">BlindDown</option>
                    <option value="2">Highlight</option>
                    <option value="3">Shake</option>
                    <option value="4">Pulsate</option>
                    <option value="5">Grow</option>
                    <option value="6">Slidedown</option>
                </select>
            </td>
        </tr>
        <tr>
          <td colspan="2">
          <label>Slideshow delay in seconds:</label> <select name="slideshow_delay"><option selected="selected" value="0">No slideshow</option><option value="5">5</option><option value="10">10</option><option value="15">15</option><option value="20">20</option><option value="25">25</option><option value="30">30</option><option value="35">35</option><option value="40">40</option><option value="45">45</option><option value="50">50</option><option value="55">55</option><option value="60">60</option>
          </select>
          </td>
        </tr>
        <tr>
          <td colspan="2">
          <label>On Image Click:</label> <select name="image_click_behaviour"><option selected="selected" value="0">Lightbox Effect</option><option value="1">Open Original Image</option><option value="2">Open Flickr Link</option></select>
          </td>
        </tr>
        <tr>
            <td colspan="2">
                <input type="submit" value="OK"/>
            </td>
        </tr>
    </table>
</form>
</body>
</html>