<?
$loadedIFrameId=$_GET["loadedIFrameId"];
$rightArrows=$_GET["rightArrows"];
if (!empty($loadedIFrameId) && $rightArrows == "true"){
?>
<TABLE align="center">
<TR><TD style="vertical-align:middle;" width="95%">
<?
}
$URL=$_GET["url"];
$ch = curl_init();
curl_setopt($ch, CURLOPT_VERBOSE, 1);
curl_setopt ($ch, CURLOPT_SSL_VERIFYPEER, FALSE);
curl_setopt ($ch, CURLOPT_URL, $URL);
curl_setopt ($ch, CURLOPT_TIMEOUT, 360);
$result = curl_exec ($ch);
curl_close ($ch);
?>
<?
if (!empty($loadedIFrameId) && $rightArrows == "true"){
?>
</TD>
<TD style="vertical-align:top;" width="5%">
<div onclick="window.parent.reloadIFrame('<?print $loadedIFrameId?>');" style="cursor:pointer;color:darkblue;font-weight:bold;font-family:Arial,sans-serif;font-size:16px">&gt;&gt;</div></TD></TR>
</TABLE>
<?
}
?>