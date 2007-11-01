<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Strict//EN"
  "http://www.w3.org/TR/xhtml1/DTD/xhtml1-strict.dtd">
<html xmlns="http://www.w3.org/1999/xhtml"
  xmlns:widget="http://www.netvibes.com/ns/">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<meta http-equiv="Expires" content="" />
<meta name="author" content="Siddique Hameed" />
<meta name="description" content="Random Wikipedia Article" />
<meta name="version" content="0.1" />
<meta name="apiVersion" content="1.0" />
<meta name="inline" content="0.1" />
<meta name="website" content="http://www.TheRandomHomepage.com" />
<meta name="debugMode" content="true" />
<title>Random Wikipedia Article</title>
<link rel="stylesheet" type="text/css"
	href="http://www.netvibes.com/themes/uwa/style.css" />
<script type="text/javascript"
  src="http://www.netvibes.com/js/UWA/load.js.php?env=Standalone"></script>

<widget:preferences>
      <preference name="language" type="list" label="Language" defaultValue="en">
		<option value="en" label="English" />
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
arrRandomWikipediaURL["cs"] = "http://cs.wikipedia.org/wiki/Speci%C3%A1ln%C3%AD:Random";

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
arrFooterLimit["cs"] = 'Citováno z „<a href="';

var randomWikipediaURL = "http://en.wikipedia.org/wiki/Special:Random";

var randomWikipediaArticleWidget = {}

randomWikipediaArticleWidget.loadModule = function() {
	randomWikipediaURL = arrRandomWikipediaURL["en"];
	getRandomArticleFromWikipedia();
}

function getRandomArticleFromWikipedia(){
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
	  alert("AJAX error = "+e);
  }

}

showContent = function(responseText) {

    try
    {
        var responseDocument = widget.createElement("response");
		var respText = "";
		var tooltipText = "";

        var retrievedFrmIdx = responseText.indexOf(arrFooterLimit["en"]);
        if (retrievedFrmIdx > -1)
        {

            var wikipediaBaseURL = randomWikipediaURL.substring(0, randomWikipediaURL.lastIndexOf("/"));

            var articleURLStartIdx = responseText.indexOf(wikipediaBaseURL, retrievedFrmIdx);

            var articleURLEndIdx = responseText.indexOf('</a>', articleURLStartIdx);


            var articleURL = responseText.substring(articleURLStartIdx, articleURLEndIdx);

            var articleTitle = grep(responseText, '<h1 class="firstHeading">', '</h1>');

            setHTML("divRandomWikipediaTitle", "<h3><a target='_new' href='" + articleURL + "'>" + articleTitle + "</a></h3>");

            respText = responseText.substring(0, retrievedFrmIdx);
            var paraIdx = respText.indexOf("<p>");

            if (paraIdx > -1)
            {
                respText = respText.substring(paraIdx);
            }

            responseDocument.setHTML(respText);
        }
		else {
			responseDocument.setHTML("There was some error reading content from Wikipedia !.<br/> Please try again later...");
		}

        removeElements(responseDocument, 'form');

        var links = $A(responseDocument.getElementsByTagName('a'));

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

        removeElementsWithIds(responseDocument, "h3", "siteSub");
        removeElementsWithIds(responseDocument, "ul", "f-list");
        removeElementsWithIds(responseDocument, "ul", "t-whatlinkshere");

		var editSections = responseDocument.getElementsByClassName("editsection");

		for(var i=0; i < editSections.length; i++){
			if (editSections[i])
			{
				responseDocument.remove(editSections[i]);
			}
		}


		setHTML("divWikipediaContent", responseDocument.innerHTML);

        var arrow = widget.body.getElementsByClassName("divArrow", widget.body)[0];
        if (arrow)
        {
            //widget.body.toggle();
            arrow.onclick = function() {
                getRandomArticleFromWikipedia();
            }
        }

		var tdArrow = widget.body.getElementsByClassName('tdArrow',widget.body)[0];
	    tdArrow.onmouseover = function()
	    {
			setToolTip(this, "Click on the arrows (&gt;&gt;) for next random article.");

		}


		var divTitle = widget.body.getElementsByClassName('divRandomWikipediaTitle',widget.body)[0];
	    divTitle.onmouseover = function()
	    {
			if (tooltipText == "")
			{
				respText = stripHTML(respText);
				if (respText.charAt(250) != -1)
				{
					tooltipText = respText.substring(0,250);
					tooltipText+="...";
				}
				else {
					tooltipText = respText;
				}
			}
			setToolTip(this, tooltipText);
		}

    }
    catch (e)
    {
        setHTML("divWikipediaContent", "Error reading content from Wikipedia.<br/>" + e);
    }
}

function setToolTip(element,text){
	UWA.Utils.setTooltip(element, text, 250);
}



widget.onLoad = function() {
  randomWikipediaArticleWidget.loadModule();
}


/*
	function getRandomArticleFromWikipedia() {
		try{
			var requestParams = { method: 'get', onSuccess: ShowWikipediaArticle, onFailure: ShowFailure };
			var request = UWA.Data.request(NV_XML_REQUEST_URL + '?url=' + escape(url), requestParams);

			setHTML("divRandomWikipediaTitle", "&nbsp;");
			setHTML("divWikipediaContent", "<p style='text-align:center;display:block;width:350px'>Loading article from Wikipedia...</p>");
			var arrow = widget.body.getElementsByClassName("divArrow", widget.body)[0];
			if (arrow)
			{
				Element.toggle(arrow);
			}
		}
		catch(e){
			alert("Error "+e);
		}
	}
*/

function ShowFailure(xhr)
{
    setHTML("divWikipediaContent", xhr.responseText);
}

function ShowWikipediaArticle(xhr)
{
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
		if (nodes[i].id == idName)
		{
			widget.body.remove(node);
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

</script>
</head>

<body>
<table cellspacing="0"
       style="display:block !important;width:100% !important;height:350px !important;background:#FFFFFF !important;padding:0px !important;margin:0px !important;border:0px !important;overflow: auto;">
    <tr>
        <td align="left">
            <div class="divRandomWikipediaTitle"/>
        </td>
        <td class="tdArrow" align="right" valign="top">
            <div class="divArrow" title='Next Random Article'>&gt;&gt;&nbsp;</div>
        </td>
    </tr>
    <tr>
        <td colspan="2" valign="top" style="padding:1px !important;margin:0px !important;border:0px !important;">
            <div class="divWikipediaContent" scrolling="auto" frameborder="0">
                <p style="text-align:center;display:block;width:350px">Loading article from Wikipedia...</p>
            </div>
        </td>
    </tr>
</table>
</body>
</html>