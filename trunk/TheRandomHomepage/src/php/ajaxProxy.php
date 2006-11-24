<?
$URL=$_GET["url"];
$ch = curl_init();
curl_setopt($ch, CURLOPT_VERBOSE, 1);
curl_setopt ($ch, CURLOPT_SSL_VERIFYPEER, FALSE);
curl_setopt ($ch, CURLOPT_URL, $URL);
//curl_setopt($ch, CURLOPT_RETURNTRANSFER, 1);
curl_setopt ($ch, CURLOPT_TIMEOUT, 360);
$result = curl_exec ($ch);
curl_close ($ch);
?>
<?
$width = $_GET["windowWidth"];

$loadedIFrameId=$_GET["loadedIFrameId"];
if (!empty($loadedIFrameId)) {
?>
<SCRIPT Language="Javascript1.2">
<!--
/*
Static menu script (By maXimus, maximus@nsimail.com, http://maximus.ravecore.com/)
Modified slightly/ permission granted to Dynamic Drive to feature script in archive
For full source, usage terms, and 100's more DHTML scripts, visit http://dynamicdrive.com
*/
//configure below variable for menu width, position on page

//var offsetleft=<?print $width?>- 25;
var offsetleft=0;
var offsettop=20;

var ns4=document.layers?1:0
var ie4=document.all?1:0
var ns6=document.getElementById&&!document.all?1:0

function makeStatic() {
if (ie4) {object1.style.pixelTop=document.body.scrollTop+offsettop}
else if (ns6) {document.getElementById("object1").style.top=window.pageYOffset+offsettop}
else if (ns4) {eval(document.object1.top=eval(window.pageYOffset+offsettop));}
setTimeout("makeStatic()",0);
}

if (ie4||ns6) {document.write('<span ALIGN="CENTER" ID="object1" STYLE="Position:absolute; Top:20; Left:'+offsetleft+'; Z-Index:5;cursor:hand;background-color:white;"><TABLE BORDER="0" CELLPADDING="0" CELLSPACING="0" bgcolor="white">')}
else if (ns4){ document.write('<LAYER top="20" name="object1" left="'+offsetleft+'"><TABLE BORDER="0" CELLPADDING="0" CELLSPACING="1"><TR><TD><TABLE BORDER="0" CELLPADDING="0" CELLSPACING="0">')}

if (ie4||ns6||ns4)
document.write('<TR><TD><div onclick="reloadIFrame(\'<?print $loadedIFrameId?>\');" style="cursor:pointer;color:darkblue;font-weight:bold;font-family:Arial,sans-serif;font-size:16px">&gt;&gt;</div></TR>')
if (ie4||ns6) {document.write('</TABLE></span>')}
else if (ns4){document.write('</TABLE></TD></TR></TABLE></LAYER>')}

function menu3(){
if (ns6||ie4||ns4)
makeStatic()
}
window.onload=menu3

function reloadIFrame(iframeID) {
	window.parent.reloadIFrame(iframeID);
}
//-->
</SCRIPT>
<?
}
?>