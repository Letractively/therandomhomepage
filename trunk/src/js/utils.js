/*					utils.js
 *
 *  (c) 2005 Siddique Hameed <siddii@gmail.com>
 *
 *
 *	Last Updated :	12/12/2006
 *  For details, see web site: http://www.TheRandomHomepage.com
 *
/*--------------------------------------------------------------------------*/

function getRandomNo(upperBound){
  return Math.floor(Math.random() * upperBound);
}

function getChildNodeValueByNodeName(node,nodeNameStr){
	var nodeList = node.childNodes;
	 for (var j = 0; j < nodeList.length ; j++) {
		var node = nodeList.item(j);
		if (node.nodeName == nodeNameStr && node.firstChild)
		{
			return node.firstChild.nodeValue;
		}
	 }
}

function getChildNodeByNodeName(node,nodeNameStr){
	var nodeList = node.childNodes;
	 for (var j = 0; j < nodeList.length ; j++) {
		var node = nodeList.item(j);
		if (node.nodeName == nodeNameStr)
		{
			return node;
		}
	 }
}

function extractBetween(str,startsWith,endsWith) {
	var startIdx =  str.indexOf(startsWith);
	if (startIdx != -1)
	{
		var endIdx = str.indexOf(endsWith,startIdx);
		if (endIdx != -1)
		{
			return str.substring(startIdx,endIdx+1);
		}
	}
	return "";
}