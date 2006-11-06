<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Strict//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-strict.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<title>Random Wikipedia Article</title>
<meta name="author" content="Siddique Hameed" />
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
  <link rel="stylesheet" type="text/css" href="http://www.netvibes.com/api/0.3/style.css" />
	<style type="text/css">
	a {
		text-decoration: none;
		color: #002bb8;
		background: none;
	}
	a:visited { color: #5a3696; }
	a:active { color: Orange; }
	a:hover { text-decoration: underline; }
	a.stub { color: #772233; }
	img {
		border: none;
		vertical-align: middle;
	}
	p {
		margin: 0.4em 0em 0.5em 0em;
		line-height: 1.5em;
	}
	p img { margin: 0; }
	hr {
		height: 1px;
		color: #aaaaaa;
		background-color: #aaaaaa;
		border: 0;
		margin: 0.2em 0 0.2em 0;
	}
	h1, h2, h3, h4, h5, h6 {
		color: Black;
		background: none;
		font-weight: normal;
		margin: 0;
		padding-top: 0.5em;
		padding-bottom: 0.17em;
		border-bottom: 1px solid #aaaaaa;
	}
	div.contentClass {
		vertical-align:middle;
		background-color:#F4F4F4; 
		border:solid 1px #aaaaaa;padding:8px; 
	}
	</style>

  <script type="text/javascript" src="http://www.netvibes.com/api/0.3/emulation.js"></script>

<?php
    $height = "400";
	if(!empty($_COOKIE['height'])) {
		$height = $_COOKIE['height'];
	}
	$lang = "en";
	if(!empty($_COOKIE['height'])) {
		$height = $_COOKIE['height'];
	}

?>
<script type="text/javascript">

	var arrRandomWikipediaURL = new Array();
	arrRandomWikipediaURL["en"] = "http://en.wikipedia.org/wiki/Special:Random";
	arrRandomWikipediaURL["fr"] = "http://fr.wikipedia.org/wiki/Special:Random";
	arrRandomWikipediaURL["ja"] = "http://ja.wikipedia.org/wiki/%E7%89%B9%E5%88%A5:Random";
	arrRandomWikipediaURL["it"] = "http://it.wikipedia.org/wiki/Speciale:Random";
	arrRandomWikipediaURL["sv"] = "http://sv.wikipedia.org/wiki/Special:Random";
	arrRandomWikipediaURL["es"] = "http://es.wikipedia.org/wiki/Especial:Random";
	arrRandomWikipediaURL["pt"] = "http://pt.wikipedia.org/wiki/Especial:Random";
	arrRandomWikipediaURL["nl"] = "http://nl.wikipedia.org/wiki/Speciaal:Random";
	arrRandomWikipediaURL["pl"] = "http://pl.wikipedia.org/wiki/Specjalna:Random";
	arrRandomWikipediaURL["de"] = "http://de.wikipedia.org/wiki/Spezial:Random";
	arrRandomWikipediaURL["ru"] = "http://ru.wikipedia.org/wiki/%D0%A1%D0%BB%D1%83%D0%B6%D0%B5%D0%B1%D0%BD%D0%B0%D1%8F:Random";

	NV_ONLOAD = function()
    {
		var randomWikipediaURL = arrRandomWikipediaURL["en"]; 
		//var url = "http://www.phonifier.com/phonify.php?i=1&m=0&l=0&u="+escape(randomWikipediaURL);
		var url = "http://www.therandomhomepage.com/netvibes/modules/RandomWikipediaArticle/GetRandomWikipediaArticle.php?url="+randomWikipediaURL;
		alert("url = "+url);
		var d = new Date();
		iFrameURL += "rnd="+d.getTime();
		var iFrame = NV_CONTENT.getElementsByTagName('iframe');
	    iFrame[0].src = url;
		//alert(" Links  = "+frames["wikiContentFrame"].document.links.length);

		if(!NV_XML_REQUEST_URL) {
			var NV_XML_REQUEST_URL = '/ajaxProxy.php';
		}

      var requestParams = { method: 'get', onSuccess: AjaxShow, onFailure: AjaxFailure };
	  alert("Submitting ajax request ");
      var request = new Ajax.Request(NV_XML_REQUEST_URL + '?url=' + escape(url), requestParams);
	}

	 function AjaxFailure(xhr)
     {
        alert('Error : ' + xhr.status + ' - ' + xhr.responseText);
     }

	function AjaxShow(xhr)
    {
		alert("Got response = "+xhr.responseText);
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

</script>
</head>

<body>
<table cellspacing="0" style="width:100% !important;background:#FFFFFF !important;padding:0px !important;margin:0px !important;border:0px !important;border-collapse:collapse !important">
<tr><td style="padding:1px !important;margin:0px !important;border:0px !important;">
  <iframe id="wikipediaContentFrame" name="wikiContentFrame" scrolling="auto" frameborder="0" style="display:block !important;width:100% !important;height:400px !important;background:#FFFFFF !important;padding:0px !important;margin:0px !important;border:0px !important;">Your browser does not support frames or is currently configured not to display frames.</iframe>
</td></tr>
</table>
<form class="configuration" method="post" action="">
  <table border="0">
    <tr>
      <td><label>Title:</label></td>
      <td><input name="title" type="text" value="Random Wikipedia Article" size="40"/></td>
    </tr>
    <tr>
      <td><label>Height:</label></td>
      <td><input name="height" type="text" value="400"/></td>
    </tr>
    <tr>
      <td><label>Language:</label></td>
      <td>
		<select name="language" style="vertical-align: top; padding: 0; margin: 0 0.4em;">
			<option value="de" lang="de" xml:lang="de">Deutsch</option>
			<option value="en" lang="en" xml:lang="en" selected="selected">English</option>
			<option value="es" lang="es" xml:lang="es">Español</option>
			<option value="fr" lang="fr" xml:lang="fr">Français</option>
			<option value="it" lang="it" xml:lang="it">Italiano</option>
			<option value="nl" lang="nl" xml:lang="nl">Nederlands</option>
			<option value="ja" lang="ja" xml:lang="ja">日本語</option>
			<option value="pl" lang="pl" xml:lang="pl">Polski</option>
			<option value="pt" lang="pt" xml:lang="pt">Português</option>
			<option value="ru" lang="ru" xml:lang="ru">Русский</option>
			<option value="sv" lang="sv" xml:lang="sv">Svenska</option>
		</select>
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