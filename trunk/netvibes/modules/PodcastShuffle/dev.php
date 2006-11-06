<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Strict//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-strict.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<title>Podcast Shuffle</title>
<meta name="author" content="Siddique Hameed" />
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<link rel="stylesheet" type="text/css" href="http://www.netvibes.com/api/0.3/style.css" />
<script type="text/javascript" src="http://www.netvibes.com/api/0.3/emulation.js"></script>
<script type="text/javascript" src="http://www.therandomhomepage.com/netvibes/modules/PodcastShuffle/json.js"></script>
<script type="text/javascript">	
	var urlArr = new Array();

	var playIdx = 0;
	var podcastArray = null;

	NV_ONLOAD = function()
    {
		 if (getValue("podcast_shuffle_user") != "true")
		 {
			saveDefaultPreferenceValues();
		 }


		var rss2JSONURL = "http://www.therandomhomepage.com/scripts/MultipleRSS2JSON.php?";
		for(var i = 1; i <= 5; i++){
			var url = getValue("up_url"+i);
			if (!isEmpty(url))
			{
				rss2JSONURL += "url"+i +"="+escape(url)+"&"; 
			}		
		}
		rss2JSONURL += "&shuffle=yes";

	   var requestParams = { method: 'get', onSuccess: AjaxShow, onFailure: AjaxFailure };
       var request = new Ajax.Request('/ajaxProxy.php?url=' + escape(rss2JSONURL), requestParams);	   
    }


	function AjaxShow(jsonResponse){		
		try
		{
			var jsonText = jsonResponse.responseText;
			if (!isEmpty(jsonText))
			{
				podcastArray = jsonResponse.responseText.parseJSON();			
				playPodcastObject(playIdx);
			}			
		}
		catch (e)
		{
			displayError(e);			
		}
	}

	function playPodcastObject(playIdx){
		try
		{
			alert("playIdx = "+playIdx);
			if ((podcastArray.length > 0) && (playIdx <= podcastArray.length))
			{
				var podcastObject = podcastArray[playIdx];
				NV_CONTENT.getElementsByTagName('div')[0].innerHTML = (playIdx > 0) ? "&lt;&lt;" : "&nbsp;"; // previous
				NV_CONTENT.getElementsByTagName('div')[1].innerHTML = podcastObject[0].title ; // title
				NV_CONTENT.getElementsByTagName('div')[2].innerHTML = (playIdx < podcastArray.length) ? "<input type='button' value='Next'/>" : "&nbsp;"; // next
				NV_CONTENT.getElementsByTagName('div')[3].innerHTML = podcastObject[0].description; // description
				playPodcast(podcastObject[0].guid,podcastObject[0].title );
				saveValue("podcast_shuffle_user","true");
			}
		}	
		catch (e)
		{
			displayError(e);			
		}
	}

	function AjaxFailure(xhr)
    {
        displayError(xhr.responseText);
    }

	function displayError(errorText){
		NV_CONTENT.getElementsByTagName('div')[0].innerHTML = errorText;
	}

    function playPodcast(url,title){
		if (!isEmpty(url) && !isEmpty(title))
		{
			PodcastPlayer.play(url, title);
		}		
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
		saveValue("up_url1","http://www.npr.org/rss/podcast.php?id=1090");
		saveValue("up_url2","http://www.npr.org/rss/podcast.php?id=500002");
		saveValue("up_url3","http://www.npr.org/rss/podcast.php?id=500003");
		saveValue("up_url4","http://www.npr.org/rss/podcast.php?id=500001");
		saveValue("up_url5","http://www.npr.org/rss/podcast.php?id=500004");
	}

</script>
</head>

<body>
<table>
	<tr><td width="5%"><div id="divPrevious"/></td><td width="80%"><div id="divTitle"/></td><td><td width="5%"><div id="divNext"/></td></td></tr>
	<tr><td colspan="3"><div id="divDescription" /></td></tr>
</table>
<form class="configuration" method="post" action="">
  <table border="0">
	<tr>
	<td colspan="2"> 	
	  <ul class="nv-feedList"><label>Podcasts...</label>
	  <li><label>Feed 1:</label> <input name="up_url1" type="text" size="40"/></li>
	  <li><label>Feed 2:</label> <input name="up_url2" type="text" size="40"/></li>
	  <li><label>Feed 3:</label> <input name="up_url3" type="text" size="40"/></li>
	  <li><label>Feed 4:</label> <input name="up_url4" type="text" size="40"/></li>
	  <li><label>Feed 5:</label> <input name="up_url5" type="text" size="40"/></li>
	  </ul>
	</td>
	</tr>
  </table>
  <input type="submit" value="OK" />
</form>
</body>
</html>