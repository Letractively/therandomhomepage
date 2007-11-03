<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Strict//EN"
  "http://www.w3.org/TR/xhtml1/DTD/xhtml1-strict.dtd">
<html xmlns="http://www.w3.org/1999/xhtml"
  xmlns:widget="http://www.netvibes.com/ns/">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<meta http-equiv="Expires" content="" />
<meta name="author" content="Siddique Hameed" />
<meta name="description" content="Flip through random articles from Wikipedia in your favorite language. Supported in English, Deutsch, Español, Français, Italiano, 日本語, Polski, Português, Русский, Svenska, Norsk (bokmål), Suomi, 中文, العربية, Česky, Volapük and தமிழ" />
<meta name="keywords" content="Wikipedia, Random, Article, Random Wikipedia Article" />
<meta name="screenshot" content="http://www.therandomhomepage.com/netvibes/modules/RandomWikipediaArticle/screenshot.png" />
<meta name="thumbnail" content="http://www.therandomhomepage.com/netvibes/modules/RandomWikipediaArticle/thumbnail.png" />
<meta name="version" content="0.1" />
<meta name="apiVersion" content="1.0" />
<meta name="inline" content="true" />
<meta name="website" content="http://www.TheRandomHomepage.com" />
<meta name="debugMode" content="true" />
<title>Random Wikipedia Article</title>
<link rel="icon" type="image/png" href="http://en.wikipedia.org/favicon.ico"/>
<link rel="stylesheet" type="text/css"
	href="http://www.netvibes.com/themes/uwa/style.css" />
<script type="text/javascript"
  src="http://www.netvibes.com/js/UWA/load.js.php?env=Standalone"></script>
<script src="http://www.google-analytics.com/urchin.js" type="text/javascript">
</script>

<style type="text/css">
    img {
        border: none;
        vertical-align: middle;
    }

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
    }

    div.divWikipediaContent {
        vertical-align: top;
        background-color: #F4F4F4;
        border: solid 1px #aaaaaa;
        padding: 8px;
		display: block;
		height: 300px;
		overflow: auto;
    }

    div.divRandomWikipediaTitle {
        color: Black;
    }


    td.tdArrow {
        font-weight: bold;
        color: Black;
        cursor: pointer;
    }

</style>

<widget:preferences>
      <preference name="language" type="list" label="Language" defaultValue="en">
		<option value="en" label="English" />
        <option value="de" label="Deutsch"/>
        <option value="es" label="Español"/>
        <option value="fr" label="Français"/>
        <option value="it" label="Italiano"/>
        <option value="ja" label="日本語"/>
        <option value="pl" label="Polski"/>
        <option value="pt" label="Português"/>
        <option value="ru" label="Русский"/>
        <option value="sv" label="Svenska"/>
		<option value="no" label="Norsk (bokmål)"/>
		<option value="fi" label="Suomi"/>
		<option value="zh" label="中文"/>
		<option value="ar" label="العربية"/>
		<option value="cs" label="Česky"/>
		<option value="ta" label="தமி்ழ"/>
		<option value="vo" label="Volapük"/>
	  </preference>

</widget:preferences>

<script type="text/javascript">

	var arrRandomWikipediaURL = new Array();
	arrRandomWikipediaURL["en"] = "http://en.wikipedia.org/wiki/Special:Random";
	arrRandomWikipediaURL["fr"] = "http://fr.wikipedia.org/wiki/Special:Random";
	arrRandomWikipediaURL["ja"] = "http://ja.wikipedia.org/wiki/%E7%89%B9%E5%88%A5:Random";
	arrRandomWikipediaURL["it"] = "http://it.wikipedia.org/wiki/Speciale:Random";
	arrRandomWikipediaURL["sv"] = "http://sv.wikipedia.org/wiki/Special:Random";
	arrRandomWikipediaURL["es"] = "http://es.wikipedia.org/wiki/Especial:Random";
	arrRandomWikipediaURL["pt"] = "http://pt.wikipedia.org/wiki/Especial:Random";
	arrRandomWikipediaURL["pl"] = "http://pl.wikipedia.org/wiki/Specjalna:Random";
	arrRandomWikipediaURL["de"] = "http://de.wikipedia.org/wiki/Spezial:Random";
	arrRandomWikipediaURL["ru"] = "http://ru.wikipedia.org/wiki/%D0%A1%D0%BB%D1%83%D0%B6%D0%B5%D0%B1%D0%BD%D0%B0%D1%8F:Random";
	arrRandomWikipediaURL["no"] = "http://no.wikipedia.org/wiki/Spesial:Tilfeldig_side";
	arrRandomWikipediaURL["fi"] = "http://fi.wikipedia.org/wiki/Toiminnot:Satunnainen_sivu";
	arrRandomWikipediaURL["zh"] = "http://zh.wikipedia.org/wiki/Special:Random";
	arrRandomWikipediaURL["ar"] = "http://ar.wikipedia.org/wiki/%D8%AE%D8%A7%D8%B5:%D8%B9%D8%B4%D9%88%D8%A7%D8%A6%D9%8A";
	arrRandomWikipediaURL["cs"] = "http://cs.wikipedia.org/wiki/Speci%C3%A1ln%C3%AD:Random";
	arrRandomWikipediaURL["ta"] = "http://ta.wikipedia.org/wiki/%E0%AE%9A%E0%AE%BF%E0%AE%B1%E0%AE%AA%E0%AF%8D%E0%AE%AA%E0%AF%81:Random";
	arrRandomWikipediaURL["vo"] = "http://vo.wikipedia.org/wiki/Patikos:Random";


	var arrFooterLimit = new Array();
	arrFooterLimit["en"] = 'Retrieved from "<a href="';
	arrFooterLimit["fr"] = 'Récupérée de « <a href="';
	arrFooterLimit["ja"] = ' "<a href="';
	arrFooterLimit["it"] = 'Estratto da "<a href="';
	arrFooterLimit["sv"] = 'Den här artikeln är hämtad från <a href="';
	arrFooterLimit["es"] = 'Obtenido de "<a href="';
	arrFooterLimit["pt"] = 'Retirado de "<a href="';
	arrFooterLimit["pl"] = 'Źródło: "<a href="';
	arrFooterLimit["de"] = 'Von „<a href="';
	arrFooterLimit["ru"] = 'Получено с "<a href="';
	arrFooterLimit["no"] = 'Hentet fra «<a href="';
	arrFooterLimit["fi"] = 'Haettu osoitteesta <a href="';
	arrFooterLimit["zh"] = '来自“<a href="';
	arrFooterLimit["ar"] = 'تم الاسترجاع من "<a href="';
	arrFooterLimit["cs"] = 'Citováno z „<a href="';
	arrFooterLimit["ta"] = '"<a href="';
	arrFooterLimit["vo"] = 'Pekopiedon se "<a href="';

var randomWikipediaURL = "http://en.wikipedia.org/wiki/Special:Random";

var randomWikipediaArticleWidget = {}

var lang = "en";

var divBody = null;
var divWikipediaContent = null;

randomWikipediaArticleWidget.loadModule = function() {
	_uacct = "UA-941159-1";
	urchinTracker("/RandomWikipediaArticleNetvibesModule");
	lang = widget.getValue("language");
	randomWikipediaURL = arrRandomWikipediaURL[lang];
	getRandomArticleFromWikipedia();
}

function getRandomArticleFromWikipedia(){
	if (divWikipediaContent != null)
	{
		divWikipediaContent.innerHTML = "Loading random article from Wikipedia...";
	}
	var url = "http://www.therandomhomepage.com/php/phonifier/index.php?i=1&m=0&l=0&u=" + randomWikipediaURL;
	var d = new Date();
	url += "&rnd=" + d.getTime();

  try
  {
	  UWA.Data.request(
		url,
		 {
		 method: 'get',
		 proxy: 'ajax',
		 type: 'text',
		 onComplete: showContent
		 }
	  );
  }
  catch (e)
  {
	  showError(e);
  }

}

showContent = function(responseText) {

    try
    {

        var retrievedFrmIdx = responseText.indexOf(arrFooterLimit[lang]);

        if (retrievedFrmIdx > -1)
        {

			displayWikipediaContent(responseText,retrievedFrmIdx);
			cleanupWikipediaContent();

			divWikipediaContent.className = "divWikipediaContent";
			divBody.appendChild(divWikipediaContent);
			widget.setBody(divBody);

        }
		else {
			showError("There was some error reading content from Wikipedia !.<br/> Please try again later...");
		}

    }
    catch (e)
    {
		showError(e);
    }
}

function cleanupWikipediaContent(){
			removeElements(divWikipediaContent, 'form');

			var links = $A(divWikipediaContent.getElementsByTagName('a'));

			for(var i=0; i < links.length || i < 10; i++) {
				var link = links[i];
				if (link)
				{
					var linkURL = link.href;
					if (linkURL.indexOf('&u=') != -1)
					{
						var idx = linkURL.indexOf("&u=");
						linkURL = linkURL.substr(idx + 3);
						linkURL = unescape(linkURL);
						link.href = linkURL;
						link.target = "_new";
					}
				}
			}

			removeElementsWithIds(divWikipediaContent, "h3", "siteSub");
			removeElementsWithIds(divWikipediaContent, "ul", "f-list");
			removeElementsWithIds(divWikipediaContent, "ul", "t-whatlinkshere");

			var editSections = divWikipediaContent.getElementsByClassName("editsection");

			for(var i=0; i < editSections.length; i++){
				if (editSections[i])
				{
					divWikipediaContent.remove(editSections[i]);
				}
			}


}

function displayWikipediaContent(responseText,retrievedFrmIdx){

		var respText = "";
		var tooltipText = "";

		divBody = widget.createElement('div');

		var wikipediaBaseURL = randomWikipediaURL.substring(0, randomWikipediaURL.lastIndexOf("/"));

		var articleURLStartIdx = responseText.indexOf(wikipediaBaseURL, retrievedFrmIdx);

		var articleURLEndIdx = responseText.indexOf('</a>', articleURLStartIdx);


		var articleURL = responseText.substring(articleURLStartIdx, articleURLEndIdx);

		var articleTitle = grep(responseText, '<h1 class="firstHeading">', '</h1>');

		var divTitle = widget.createElement("div");
		divTitle.innerHTML = "<table><tr><td><h5><a target='_blank' href='"+articleURL+"'>"+articleTitle+"</a></h5></td><td class='tdArrow'>&nbsp;&nbsp;&gt;&gt;</td></tr></table>";
		divBody.appendChild(divTitle);

		respText = responseText.substring(0, retrievedFrmIdx);
		var paraIdx = respText.indexOf("<p>");

		if (paraIdx > -1)
		{
			respText = respText.substring(paraIdx);
		}

		divWikipediaContent = widget.createElement('div');
		divWikipediaContent.innerHTML = respText;

		var arrow = divTitle.getElementsByClassName("tdArrow")[0];

		if (arrow)
		{
			arrow.onclick = function() {
					getRandomArticleFromWikipedia();
			}
		}

}

function setToolTip(element,text){
	UWA.Utils.setTooltip(element, text, 250);
}

widget.onLoad = function() {
  randomWikipediaArticleWidget.loadModule();
}

function stripHTML(str){
	try
	{
		var re= /<\S[^><]*>/g
		var returnStr = str.replace(re, "");
		return returnStr;
	}
	catch (e)
	{
		//do nothing
	}
	return str;
}


function removeElementsWithIds(parentDocument, tagName, idName) {
    var nodes = $A(parentDocument.getElementsByTagName(tagName));

	for(var i=0; i < nodes.length; i++){
		if (nodes[i] && nodes[i].id == idName)
		{
			widget.body.remove(nodes[i]);
		}
	}
}

function removeElements(baseElement, elementName) {
    var forms = $A(baseElement.getElementsByTagName(elementName));
	for(var i=0; i < forms.length; i++) {
		if (forms[i])
		{
			widget.body.remove(forms[i]);
		}
	}
}


function isEmpty(value) {
    return value == "" || value == "undefined" || value == "null" || value == null;
}

function grep(wholeStr, startsWith, endsWith)
{
    var grepStr = "";
    var iFrom = wholeStr.indexOf(startsWith);
    var iTo = wholeStr.indexOf(endsWith);
    iFrom += startsWith.length;
    if (iTo > iFrom) {
        grepStr = wholeStr.substring(iFrom, iTo);
    }
    return grepStr;
}

function setHTML(className, str)
{
    var element = widget.body.getElementsByClassName(className)[0];
    if (element)
    {
        element.setHTML(str);
    }
}

function showError(e){
	var error = widget.createElement("div");
	error.innerHTML = "Error reading content from Wikipedia !<br/>"+e;
	widget.setBody(error);
}

</script>
</head>

<body>
<p>Loading ...</p>
</body>
</html>