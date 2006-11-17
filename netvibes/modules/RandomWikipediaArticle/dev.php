<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Strict//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-strict.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<title>Random Wikipedia Article</title>
<link rel="icon" type="image/png" href="http://en.wikipedia.org/favicon.ico"/>
<meta name="author" content="Siddique Hameed"/>
<!--
	Last Updated: 11/16/2006
-->
<meta http-equiv="Content-Type" content="text/html; charset=utf-8"/>
<link rel="stylesheet" type="text/css" href="http://www.netvibes.com/api/0.3/style.css"/>
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
        vertical-align: text-top;
        background-color: #F4F4F4;
        border: solid 1px #aaaaaa;
        padding: 8px;
    }

    div.divRandomWikipediaTitle {
        color: Black;
    }

    div.divArrow {
        font-weight: bold;
        color: darkblue;
        cursor: pointer;
    }
</style>

<script src="http://www.google-analytics.com/urchin.js" type="text/javascript">
</script>

<script type="text/javascript" src="http://www.netvibes.com/api/0.3/emulation.js"></script>

<?php
    $height = "400";
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
arrRandomWikipediaURL["pl"] = "http://pl.wikipedia.org/wiki/Specjalna:Random";
arrRandomWikipediaURL["de"] = "http://de.wikipedia.org/wiki/Spezial:Random";

var arrFooterLimit = new Array();
arrFooterLimit["en"] = 'Retrieved from "<a href="';
arrFooterLimit["fr"] = 'Récupérée de « <a href="';
arrFooterLimit["ja"] = ' "<a href="';
arrFooterLimit["it"] = 'Estratto da "<a href="';
arrFooterLimit["sv"] = 'Den här artikeln är hämtad från <a href="';
arrFooterLimit["es"] = 'Obtenido de "<a href="';
arrFooterLimit["pt"] = 'Retirado de "<a href="';
arrFooterLimit["pl"] = '?ród?o: "<a href="';
arrFooterLimit["de"] = 'Von „<a href="';

var randomWikipediaURL = "http://en.wikipedia.org/wiki/Special:Random";

NV_ONLOAD = function()
{
	if (isEmpty(getValue("language")))
	{
		//default language
		saveValue("language","en");
	}

	resize();
	getRandomArticleFromWikipedia();
    setTitle();
	_uacct = "UA-941159-1";
	urchinTracker();
}

function resize(){
	var width = getValue("width");
	if (!isEmpty(width))
	{
		var moduleElements = document.getElementsByClassName("module",document);
		if (moduleElements)
		{
			for(var i=0; i < moduleElements.length; i++){
				var divWikipediaContent = document.getElementsByClassName("divWikipediaContent",moduleElements[i])[0];
				if (divWikipediaContent)
				{
					var widthStyle = width+"px";
					Element.setStyle(moduleElements[i],{width:widthStyle});
					break;
				}
			}
		}
	}
}

function setTitle() {
    if (!isEmpty(getValue("title")))
    {
        NV_TITLE.innerHTML = getValue("title");
    }
}

function getRandomArticleFromWikipedia() {

	randomWikipediaURL = arrRandomWikipediaURL[getValue("language")];

    var url = "http://www.phonifier.com/phonify.php?i=1&m=0&l=0&u=" + randomWikipediaURL;

    if (!NV_XML_REQUEST_URL) {
        var NV_XML_REQUEST_URL = 'http://www.netvibes.com/ajaxProxy.php';
    }

    var requestParams = { method: 'get', onSuccess: ShowWikipediaArticle, onFailure: ShowFailure };
    var request = new Ajax.Request(NV_XML_REQUEST_URL + '?url=' + escape(url), requestParams);

    //setHTML("divRandomWikipediaTitle", "&nbsp;");
	//setHTML("divWikipediaContent", "<p style='align:center;display:block;width:100%'>Loading article from Wikipedia...</p>");
    var arrow = document.getElementsByClassName("divArrow", NV_CONTENT)[0];
    if (arrow)
    {
        Element.toggle(arrow);
    }
}

function ShowFailure(xhr)
{
    setHTML("divWikipediaContent", xhr.responseText);
}

function ShowWikipediaArticle(xhr)
{
    try
    {

        var responseDocument = document.createElement("response");

        var retrievedFrmIdx = xhr.responseText.indexOf(arrFooterLimit[getValue("language")]);
		alert(" retrievedFrmIdx = "+retrievedFrmIdx);
        if (retrievedFrmIdx > -1)
        {

            var wikipediaBaseURL = randomWikipediaURL.substring(0, randomWikipediaURL.lastIndexOf("/"));

            var articleURLStartIdx = xhr.responseText.indexOf(wikipediaBaseURL, retrievedFrmIdx);

            var articleURLEndIdx = xhr.responseText.indexOf('</a>', articleURLStartIdx);


            var articleURL = xhr.responseText.substring(articleURLStartIdx, articleURLEndIdx);

            var articleTitle = grep(xhr.responseText, '<h1 class="firstHeading">', '</h1>');

			alert("Setting Title "+articleTitle);

            setHTML("divRandomWikipediaTitle", "<h3><a target='_new' href='" + articleURL + "'>" + articleTitle + "</a></h3>");

            var title = document.getElementsByClassName("divRandomWikipediaTitle", NV_CONTENT)[0];
            if (title)
            {
                setToolTip(title, "Click on the arrows(&gt;&gt;) to see next random article.");
            }

            var respText = xhr.responseText.substring(0, retrievedFrmIdx);
            var paraIdx = respText.indexOf("<p>");

            if (paraIdx > -1)
            {
                respText = respText.substring(paraIdx);
            }

			alert("generated respText "+respText);
            //responseDocument.innerHTML = respText;
			Element.update(responseDocument,respText);
        }
		else {
			//responseDocument.innerHTML = "There was some error reading content from Wikipedia !.<br/> Please try again later...";
			Element.update(responseDocument,"There was some error reading content from Wikipedia !.<br/> Please try again later...");
		}

		alert("removing form element ");

        removeElements(responseDocument, 'form');

        var links = $A(responseDocument.getElementsByTagName('a'));
        var localLinks = links.findAll(function(link) {
            var linkURL = link.href;
            if (linkURL.indexOf('phonify.php') != -1)
            {
                var idx = linkURL.indexOf("http%3A%2F%2F");
                linkURL = linkURL.substr(idx + 13);
                linkURL = "http://" + unescape(linkURL);
                link.href = linkURL;
                link.target = "_new";
            }
        });

        removeElementsWithIds(responseDocument, "h3", "siteSub");
        removeElementsWithIds(responseDocument, "ul", "f-list");
        removeElementsWithIds(responseDocument, "ul", "t-whatlinkshere");

		alert("setting divWikipediaContent "+responseDocument.innerHTML);

		var wikipediaContent = responseDocument.innerHTML;
        setHTML("divWikipediaContent", wikipediaContent);

        var arrow = document.getElementsByClassName("divArrow", NV_CONTENT)[0];
        if (arrow)
        {
            Element.toggle(arrow);
            arrow.onclick = function() {
                getRandomArticleFromWikipedia();
            }
        }

    }
    catch (e)
    {
        setHTML("divWikipediaContent", "Error reading content from Wikipedia.<br/>" + e);
    }
}

function removeElementsWithIds(parentDocument, tagName, idName) {
    var nodes = $A(parentDocument.getElementsByTagName(tagName));
    var foundNodes = nodes.findAll(function(node) {
        if (node.id == idName)
        {
            Element.remove(node);
        }
    });
}

function removeElements(baseElement, elementName) {
    var forms = $A(baseElement.getElementsByTagName(elementName));
    var localForms = forms.findAll(function(form) {
        Element.remove(form);
    });
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
    var foundElement = document.getElementsByClassName(className, NV_CONTENT)[0];
    if (foundElement)
    {
        //element.innerHTML = str;
		Element.update(foundElement,str);
    }
}

</script>
</head>

<body>
<table cellspacing="0"
       style="display:block !important;width:100% !important;height:<?php echo htmlspecialchars($height) ?>px !important;background:#FFFFFF !important;padding:0px !important;margin:0px !important;border:0px !important;overflow: auto;">
    <tr>
        <td align="left">
            <div class="divRandomWikipediaTitle"/>
        </td>
        <td align="right" valign="top">
            <div class="divArrow" title='Next Random Article'>&gt;&gt;&nbsp;</div>
        </td>
    </tr>
    <tr>
        <td colspan="2" valign="top" style="padding:1px !important;margin:0px !important;border:0px !important;">
            <div class="divWikipediaContent" scrolling="auto" frameborder="0">
                <p style="align:center;vertical">Loading article from Wikipedia...</p>
            </div>
        </td>
    </tr>
</table>
<form class="configuration" method="post" action="">
    <table border="0">
        <tr>
            <td><label>Title:</label></td>
            <td><input name="title" type="text" value="Random Wikipedia Article" size="40"/></td>
        </tr>
        <tr>
            <td><label>Height:</label></td>
            <td><input name="height" type="text" value="400" size="4"/></td>
        </tr>
        <tr>
            <td><label>Width:</label></td>
            <td><input name="width" type="text" size="4"/></td>
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
                    <option value="ja" lang="ja" xml:lang="ja">???</option>
                    <option value="pl" lang="pl" xml:lang="pl">Polski</option>
                    <option value="pt" lang="pt" xml:lang="pt">Português</option>
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