<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Strict//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-strict.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<title>Random Flickring</title>
<link rel="icon" type="image/png" href="http://www.flickr.com/favicon.ico"/>
<meta name="author" content="Siddique Hameed"/>
<!--
	Last Updated: 12/12/2006
	Version 0.1
-->
<meta http-equiv="Content-Type" content="text/html; charset=utf-8"/>
<link rel="stylesheet" type="text/css" href="http://www.netvibes.com/api/0.3/style.css"/>
<style type="text/css">
#lightbox{
	position: absolute;
	top: 40px;
	left: 0;
	width: 100%;
	z-index: 100;
	text-align: center;
	line-height: 0;
	}

a:hover{
	border-bottom: none;
}

#lightbox a img{ border: none; }

#outerImageContainer{
	position: relative;
	background-color: #fff;
	width: 250px;
	height: 250px;
	margin: 0 auto;
	}

#imageContainer{
	padding: 10px;
	}

#loading{
	position: absolute;
	top: 40%;
	left: 0%;
	height: 25%;
	width: 100%;
	text-align: center;
	line-height: 0;
	}
#hoverNav{
	position: absolute;
	top: 0;
	left: 0;
	height: 100%;
	width: 100%;
	z-index: 10;
	}
#imageContainer>#hoverNav{ left: 0;}
#hoverNav a{ outline: none;}

#prevLink, #nextLink{
	width: 49%;
	height: 100%;
	background: transparent url(http://www.therandomhomepage.com/images/lightbox/blank.gif) no-repeat; /* Trick IE into showing hover */
	display: block;
	}
#prevLink { left: 0; float: left;}
#nextLink { right: 0; float: right;}
#prevLink:hover, #prevLink:visited:hover { background: url(http://www.therandomhomepage.com/images/lightbox/prevlabel.gif) left 15% no-repeat; }
#nextLink:hover, #nextLink:visited:hover { background: url(http://www.therandomhomepage.com/images/lightbox/nextlabel.gif) right 15% no-repeat; }


#imageDataContainer{
	font: 10px Verdana, Helvetica, sans-serif;
	background-color: #fff;
	margin: 0 auto;
	line-height: 1.4em;
	}

#imageData{
	padding:0 10px;
	}
#imageData #imageDetails{ width: 40%; float: left; text-align: left; }
#imageData #caption{ font-weight: bold;	}
#imageData #numberDisplay{ display: block; clear: left; padding-bottom: 1.0em;	}
#imageData #flashPlayer{ float: right; }
#imageData #slideshowLink{ width: 34px; float: right;  padding-bottom: 1.3em;position: relative; top: 5px}
#imageData #bottomNavClose{ width: 34px; float: right;  padding-bottom: 1.3em; position: relative; top: 5px}

#overlay{
	position: absolute;
	top: 0;
	left: 0;
	z-index: 90;
	width: 100%;
	height: 500px;
	background-color: #000;
	filter:alpha(opacity=60);
	-moz-opacity: 0.6;
	opacity: 0.6;
	}


.clearfix:after {
	content: ".";
	display: block;
	height: 0;
	clear: both;
	visibility: hidden;
	}

* html>body .clearfix {
	display: inline-block;
	width: 100%;
	}

* html .clearfix {
	/* Hides from IE-mac \*/
	height: 1%;
	/* End hide from IE-mac */
	}

        img {
			border-style: none;
			cursor: pointer;
		}

		#divRandomFlickrControl {
			cursor: pointer;
			color: darkblue;
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

<script type="text/javascript" src="http://www.netvibes.com/api/0.3/emulation.js"></script>

<!-- Netvibes doesn't support external scripts, so I copied this from http://www.google-analytics.com/urchin.js -->
<script type="text/javascript">
//-- Google Analytics Urchin Module
//-- Copyright 2005 Google, All Rights Reserved.

//-- Urchin On Demand Settings ONLY
var _uacct="";			// set up the Urchin Account
var _userv=1;			// service mode (0=local,1=remote,2=both)

//-- UTM User Settings
var _ufsc=1;			// set client info flag (1=on|0=off)
var _udn="auto";		// (auto|none|domain) set the domain name for cookies
var _uhash="on";		// (on|off) unique domain hash for cookies
var _utimeout="1800";   	// set the inactive session timeout in seconds
var _ugifpath="/__utm.gif";	// set the web path to the __utm.gif file
var _utsp="|";			// transaction field separator
var _uflash=1;			// set flash version detect option (1=on|0=off)
var _utitle=1;			// set the document title detect option (1=on|0=off)
var _ulink=0;			// enable linker functionality (1=on|0=off)
var _uanchor=0;			// enable use of anchors for campaign (1=on|0=off)
var _utcp="/";			// the cookie path for tracking
var _usample=100;		// The sampling % of visitors to track (1-100).

//-- UTM Campaign Tracking Settings
var _uctm=1;			// set campaign tracking module (1=on|0=off)
var _ucto="15768000";		// set timeout in seconds (6 month default)
var _uccn="utm_campaign";	// name
var _ucmd="utm_medium";		// medium (cpc|cpm|link|email|organic)
var _ucsr="utm_source";		// source
var _uctr="utm_term";		// term/keyword
var _ucct="utm_content";	// content
var _ucid="utm_id";		// id number
var _ucno="utm_nooverride";	// don't override

//-- Auto/Organic Sources and Keywords
var _uOsr=new Array();
var _uOkw=new Array();
_uOsr[0]="google";	_uOkw[0]="q";
_uOsr[1]="yahoo";	_uOkw[1]="p";
_uOsr[2]="msn";		_uOkw[2]="q";
_uOsr[3]="aol";		_uOkw[3]="query";
_uOsr[4]="aol";		_uOkw[4]="encquery";
_uOsr[5]="lycos";	_uOkw[5]="query";
_uOsr[6]="ask";		_uOkw[6]="q";
_uOsr[7]="altavista";	_uOkw[7]="q";
_uOsr[8]="search";	_uOkw[8]="q";
_uOsr[9]="netscape";	_uOkw[9]="s";
_uOsr[10]="cnn";	_uOkw[10]="query";
_uOsr[11]="looksmart";	_uOkw[11]="qt";
_uOsr[12]="about";	_uOkw[12]="terms";
_uOsr[13]="mamma";	_uOkw[13]="query";
_uOsr[14]="alltheweb";	_uOkw[14]="q";
_uOsr[15]="gigablast";	_uOkw[15]="q";
_uOsr[16]="voila";	_uOkw[16]="kw";
_uOsr[17]="virgilio";	_uOkw[17]="qs";
_uOsr[18]="live";	_uOkw[18]="q";
_uOsr[19]="baidu";	_uOkw[19]="wd";
_uOsr[20]="alice";	_uOkw[20]="qs";
_uOsr[21]="seznam";	_uOkw[21]="w";
_uOsr[22]="yandex";	_uOkw[22]="text";
_uOsr[23]="najdi";	_uOkw[23]="q";

//-- Auto/Organic Keywords to Ignore
var _uOno=new Array();
//_uOno[0]="urchin";
//_uOno[1]="urchin.com";
//_uOno[2]="www.urchin.com";

//-- Referral domains to Ignore
var _uRno=new Array();
//_uRno[0]=".urchin.com";

//-- **** Don't modify below this point ***
var _uff,_udh,_udt,_ubl=0,_udo="",_uu,_ufns=0,_uns=0,_ur="-",_ufno=0,_ust=0,_ubd=document,_udl=_ubd.location,_udlh="",_uwv="1";
var _ugifpath2="http://www.google-analytics.com/__utm.gif";
if (_udl.hash) _udlh=_udl.href.substring(_udl.href.indexOf('#'));
if (_udl.protocol=="https:") _ugifpath2="https://ssl.google-analytics.com/__utm.gif";
if (!_utcp || _utcp=="") _utcp="/";
function urchinTracker(page) {
 if (_udl.protocol=="file:") return;
 if (_uff && (!page || page=="")) return;
 var a,b,c,xx,v,z,k,x="",s="",f=0;
 var nx=" expires=Sun, 18 Jan 2038 00:00:00 GMT;";
 var dc=_ubd.cookie;
 _udh=_uDomain();
 if (!_uVG()) return;
 _uu=Math.round(Math.random()*2147483647);
 _udt=new Date();
 _ust=Math.round(_udt.getTime()/1000);
 a=dc.indexOf("__utma="+_udh);
 b=dc.indexOf("__utmb="+_udh);
 c=dc.indexOf("__utmc="+_udh);
 if (_udn && _udn!="") { _udo=" domain="+_udn+";"; }
 if (_utimeout && _utimeout!="") {
  x=new Date(_udt.getTime()+(_utimeout*1000));
  x=" expires="+x.toGMTString()+";";
 }
 if (_ulink) {
  if (_uanchor && _udlh && _udlh!="") s=_udlh+"&";
  s+=_udl.search;
  if(s && s!="" && s.indexOf("__utma=")>=0) {
   if (!(_uIN(a=_uGC(s,"__utma=","&")))) a="-";
   if (!(_uIN(b=_uGC(s,"__utmb=","&")))) b="-";
   if (!(_uIN(c=_uGC(s,"__utmc=","&")))) c="-";
   v=_uGC(s,"__utmv=","&");
   z=_uGC(s,"__utmz=","&");
   k=_uGC(s,"__utmk=","&");
   xx=_uGC(s,"__utmx=","&");
   if ((k*1) != ((_uHash(a+b+c+xx+z+v)*1)+(_udh*1))) {_ubl=1;a="-";b="-";c="-";xx="-";z="-";v="-";}
   if (a!="-" && b!="-" && c!="-") f=1;
   else if(a!="-") f=2;
  }
 }
 if(f==1) {
  _ubd.cookie="__utma="+a+"; path="+_utcp+";"+nx+_udo;
  _ubd.cookie="__utmb="+b+"; path="+_utcp+";"+x+_udo;
  _ubd.cookie="__utmc="+c+"; path="+_utcp+";"+_udo;
 } else if (f==2) {
  a=_uFixA(s,"&",_ust);
  _ubd.cookie="__utma="+a+"; path="+_utcp+";"+nx+_udo;
  _ubd.cookie="__utmb="+_udh+"; path="+_utcp+";"+x+_udo;
  _ubd.cookie="__utmc="+_udh+"; path="+_utcp+";"+_udo;
  _ufns=1;
 } else if (a>=0 && b>=0 && c>=0) {
  _ubd.cookie="__utmb="+_udh+"; path="+_utcp+";"+x+_udo;
 } else {
  if (a>=0) a=_uFixA(_ubd.cookie,";",_ust);
  else a=_udh+"."+_uu+"."+_ust+"."+_ust+"."+_ust+".1";
  _ubd.cookie="__utma="+a+"; path="+_utcp+";"+nx+_udo;
  _ubd.cookie="__utmb="+_udh+"; path="+_utcp+";"+x+_udo;
  _ubd.cookie="__utmc="+_udh+"; path="+_utcp+";"+_udo;
  _ufns=1;
 }
 if (_ulink && xx && xx!="" && xx!="-") {
   xx=_uUES(xx);
   if (xx.indexOf(";")==-1) _ubd.cookie="__utmx="+xx+"; path="+_utcp+";"+nx+_udo;
 }
 if (_ulink && v && v!="" && v!="-") {
  v=_uUES(v);
  if (v.indexOf(";")==-1) _ubd.cookie="__utmv="+v+"; path="+_utcp+";"+nx+_udo;
 }
 _uInfo(page);
 _ufns=0;
 _ufno=0;
 _uff=1;
}
function _uInfo(page) {
 var p,s="",dm="",pg=_udl.pathname+_udl.search;
 if (page && page!="") pg=_uES(page,1);
 _ur=_ubd.referrer;
 if (!_ur || _ur=="") { _ur="-"; }
 else {
  dm=_ubd.domain;
  if(_utcp && _utcp!="/") dm+=_utcp;
  p=_ur.indexOf(dm);
  if ((p>=0) && (p<=8)) { _ur="0"; }
  if (_ur.indexOf("[")==0 && _ur.lastIndexOf("]")==(_ur.length-1)) { _ur="-"; }
 }
 s+="&utmn="+_uu;
 if (_ufsc) s+=_uBInfo();
 if (_uctm) s+=_uCInfo();
 if (_utitle && _ubd.title && _ubd.title!="") s+="&utmdt="+_uES(_ubd.title);
 if (_udl.hostname && _udl.hostname!="") s+="&utmhn="+_uES(_udl.hostname);
 s+="&utmr="+_ur;
 s+="&utmp="+pg;
 if ((_userv==0 || _userv==2) && _uSP()) {
  var i=new Image(1,1);
  i.src=_ugifpath+"?"+"utmwv="+_uwv+s;
  i.onload=function() {_uVoid();}
 }
 if ((_userv==1 || _userv==2) && _uSP()) {
  var i2=new Image(1,1);
  i2.src=_ugifpath2+"?"+"utmwv="+_uwv+s+"&utmac="+_uacct+"&utmcc="+_uGCS();
  i2.onload=function() { _uVoid(); }
 }
 return;
}
function _uVoid() { return; }
function _uCInfo() {
 if (!_ucto || _ucto=="") { _ucto="15768000"; }
 if (!_uVG()) return;
 var c="",t="-",t2="-",t3="-",o=0,cs=0,cn=0,i=0,z="-",s="";
 if (_uanchor && _udlh && _udlh!="") s=_udlh+"&";
 s+=_udl.search;
 var x=new Date(_udt.getTime()+(_ucto*1000));
 var dc=_ubd.cookie;
 x=" expires="+x.toGMTString()+";";
 if (_ulink && !_ubl) {
  z=_uUES(_uGC(s,"__utmz=","&"));
  if (z!="-" && z.indexOf(";")==-1) { _ubd.cookie="__utmz="+z+"; path="+_utcp+";"+x+_udo; return ""; }
 }
 z=dc.indexOf("__utmz="+_udh);
 if (z>-1) { z=_uGC(dc,"__utmz="+_udh,";"); }
 else { z="-"; }
 t=_uGC(s,_ucid+"=","&");
 t2=_uGC(s,_ucsr+"=","&");
 t3=_uGC(s,"gclid=","&");
 if ((t!="-" && t!="") || (t2!="-" && t2!="") || (t3!="-" && t3!="")) {
  if (t!="-" && t!="") c+="utmcid="+_uEC(t);
  if (t2!="-" && t2!="") { if (c != "") c+="|"; c+="utmcsr="+_uEC(t2); }
  if (t3!="-" && t3!="") { if (c != "") c+="|"; c+="utmgclid="+_uEC(t3); }
  t=_uGC(s,_uccn+"=","&");
  if (t!="-" && t!="") c+="|utmccn="+_uEC(t);
  else c+="|utmccn=(not+set)";
  t=_uGC(s,_ucmd+"=","&");
  if (t!="-" && t!="") c+="|utmcmd="+_uEC(t);
  else  c+="|utmcmd=(not+set)";
  t=_uGC(s,_uctr+"=","&");
  if (t!="-" && t!="") c+="|utmctr="+_uEC(t);
  else { t=_uOrg(1); if (t!="-" && t!="") c+="|utmctr="+_uEC(t); }
  t=_uGC(s,_ucct+"=","&");
  if (t!="-" && t!="") c+="|utmcct="+_uEC(t);
  t=_uGC(s,_ucno+"=","&");
  if (t=="1") o=1;
  if (z!="-" && o==1) return "";
 }
 if (c=="-" || c=="") { c=_uOrg(); if (z!="-" && _ufno==1)  return ""; }
 if (c=="-" || c=="") { if (_ufns==1)  c=_uRef(); if (z!="-" && _ufno==1)  return ""; }
 if (c=="-" || c=="") {
  if (z=="-" && _ufns==1) { c="utmccn=(direct)|utmcsr=(direct)|utmcmd=(none)"; }
  if (c=="-" || c=="") return "";
 }
 if (z!="-") {
  i=z.indexOf(".");
  if (i>-1) i=z.indexOf(".",i+1);
  if (i>-1) i=z.indexOf(".",i+1);
  if (i>-1) i=z.indexOf(".",i+1);
  t=z.substring(i+1,z.length);
  if (t.toLowerCase()==c.toLowerCase()) cs=1;
  t=z.substring(0,i);
  if ((i=t.lastIndexOf(".")) > -1) {
   t=t.substring(i+1,t.length);
   cn=(t*1);
  }
 }
 if (cs==0 || _ufns==1) {
  t=_uGC(dc,"__utma="+_udh,";");
  if ((i=t.lastIndexOf(".")) > 9) {
   _uns=t.substring(i+1,t.length);
   _uns=(_uns*1);
  }
  cn++;
  if (_uns==0) _uns=1;
  _ubd.cookie="__utmz="+_udh+"."+_ust+"."+_uns+"."+cn+"."+c+"; path="+_utcp+"; "+x+_udo;
 }
 if (cs==0 || _ufns==1) return "&utmcn=1";
 else return "&utmcr=1";
}
function _uRef() {
 if (_ur=="0" || _ur=="" || _ur=="-") return "";
 var i=0,h,k,n;
 if ((i=_ur.indexOf("://"))<0) return "";
 h=_ur.substring(i+3,_ur.length);
 if (h.indexOf("/") > -1) {
  k=h.substring(h.indexOf("/"),h.length);
  if (k.indexOf("?") > -1) k=k.substring(0,k.indexOf("?"));
  h=h.substring(0,h.indexOf("/"));
 }
 h=h.toLowerCase();
 n=h;
 if ((i=n.indexOf(":")) > -1) n=n.substring(0,i);
 for (var ii=0;ii<_uRno.length;ii++) {
  if ((i=n.indexOf(_uRno[ii].toLowerCase())) > -1 && n.length==(i+_uRno[ii].length)) { _ufno=1; break; }
 }
 if (h.indexOf("www.")==0) h=h.substring(4,h.length);
 return "utmccn=(referral)|utmcsr="+_uEC(h)+"|"+"utmcct="+_uEC(k)+"|utmcmd=referral";
}
function _uOrg(t) {
 if (_ur=="0" || _ur=="" || _ur=="-") return "";
 var i=0,h,k;
 if ((i=_ur.indexOf("://")) < 0) return "";
 h=_ur.substring(i+3,_ur.length);
 if (h.indexOf("/") > -1) {
  h=h.substring(0,h.indexOf("/"));
 }
 for (var ii=0;ii<_uOsr.length;ii++) {
  if (h.toLowerCase().indexOf(_uOsr[ii].toLowerCase()) > -1) {
   if ((i=_ur.indexOf("?"+_uOkw[ii]+"=")) > -1 || (i=_ur.indexOf("&"+_uOkw[ii]+"=")) > -1) {
    k=_ur.substring(i+_uOkw[ii].length+2,_ur.length);
    if ((i=k.indexOf("&")) > -1) k=k.substring(0,i);
    for (var yy=0;yy<_uOno.length;yy++) {
     if (_uOno[yy].toLowerCase()==k.toLowerCase()) { _ufno=1; break; }
    }
    if (t) return _uEC(k);
    else return "utmccn=(organic)|utmcsr="+_uEC(_uOsr[ii])+"|"+"utmctr="+_uEC(k)+"|utmcmd=organic";
   }
  }
 }
 return "";
}
function _uBInfo() {
 var sr="-",sc="-",ul="-",fl="-",cs="-",je=1;
 var n=navigator;
 if (self.screen) {
  sr=screen.width+"x"+screen.height;
  sc=screen.colorDepth+"-bit";
 } else if (self.java) {
  var j=java.awt.Toolkit.getDefaultToolkit();
  var s=j.getScreenSize();
  sr=s.width+"x"+s.height;
 }
 if (n.language) { ul=n.language.toLowerCase(); }
 else if (n.browserLanguage) { ul=n.browserLanguage.toLowerCase(); }
 je=n.javaEnabled()?1:0;
 if (_uflash) fl=_uFlash();
 if (_ubd.characterSet) cs=_uES(_ubd.characterSet);
 else if (_ubd.charset) cs=_uES(_ubd.charset);
 return "&utmcs="+cs+"&utmsr="+sr+"&utmsc="+sc+"&utmul="+ul+"&utmje="+je+"&utmfl="+fl;
}
function __utmSetTrans() {
 var e;
 if (_ubd.getElementById) e=_ubd.getElementById("utmtrans");
 else if (_ubd.utmform && _ubd.utmform.utmtrans) e=_ubd.utmform.utmtrans;
 if (!e) return;
 var l=e.value.split("UTM:");
 var i,i2,c;
 if (_userv==0 || _userv==2) i=new Array();
 if (_userv==1 || _userv==2) { i2=new Array(); c=_uGCS(); }

 for (var ii=0;ii<l.length;ii++) {
  l[ii]=_uTrim(l[ii]);
  if (l[ii].charAt(0)!='T' && l[ii].charAt(0)!='I') continue;
  var r=Math.round(Math.random()*2147483647);
  if (!_utsp || _utsp=="") _utsp="|";
  var f=l[ii].split(_utsp),s="";
  if (f[0].charAt(0)=='T') {
   s="&utmt=tran"+"&utmn="+r;
   f[1]=_uTrim(f[1]); if(f[1]&&f[1]!="") s+="&utmtid="+_uES(f[1]);
   f[2]=_uTrim(f[2]); if(f[2]&&f[2]!="") s+="&utmtst="+_uES(f[2]);
   f[3]=_uTrim(f[3]); if(f[3]&&f[3]!="") s+="&utmtto="+_uES(f[3]);
   f[4]=_uTrim(f[4]); if(f[4]&&f[4]!="") s+="&utmttx="+_uES(f[4]);
   f[5]=_uTrim(f[5]); if(f[5]&&f[5]!="") s+="&utmtsp="+_uES(f[5]);
   f[6]=_uTrim(f[6]); if(f[6]&&f[6]!="") s+="&utmtci="+_uES(f[6]);
   f[7]=_uTrim(f[7]); if(f[7]&&f[7]!="") s+="&utmtrg="+_uES(f[7]);
   f[8]=_uTrim(f[8]); if(f[8]&&f[8]!="") s+="&utmtco="+_uES(f[8]);
  } else {
   s="&utmt=item"+"&utmn="+r;
   f[1]=_uTrim(f[1]); if(f[1]&&f[1]!="") s+="&utmtid="+_uES(f[1]);
   f[2]=_uTrim(f[2]); if(f[2]&&f[2]!="") s+="&utmipc="+_uES(f[2]);
   f[3]=_uTrim(f[3]); if(f[3]&&f[3]!="") s+="&utmipn="+_uES(f[3]);
   f[4]=_uTrim(f[4]); if(f[4]&&f[4]!="") s+="&utmiva="+_uES(f[4]);
   f[5]=_uTrim(f[5]); if(f[5]&&f[5]!="") s+="&utmipr="+_uES(f[5]);
   f[6]=_uTrim(f[6]); if(f[6]&&f[6]!="") s+="&utmiqt="+_uES(f[6]);
  }
  if ((_userv==0 || _userv==2) && _uSP()) {
   i[ii]=new Image(1,1);
   i[ii].src=_ugifpath+"?"+"utmwv="+_uwv+s;
   i[ii].onload=function() { _uVoid(); }
  }
  if ((_userv==1 || _userv==2) && _uSP()) {
   i2[ii]=new Image(1,1);
   i2[ii].src=_ugifpath2+"?"+"utmwv="+_uwv+s+"&utmac="+_uacct+"&utmcc="+c;
   i2[ii].onload=function() { _uVoid(); }
  }
 }
 return;
}
function _uFlash() {
 var f="-",n=navigator;
 if (n.plugins && n.plugins.length) {
  for (var ii=0;ii<n.plugins.length;ii++) {
   if (n.plugins[ii].name.indexOf('Shockwave Flash')!=-1) {
    f=n.plugins[ii].description.split('Shockwave Flash ')[1];
    break;
   }
  }
 } else if (window.ActiveXObject) {
  for (var ii=10;ii>=2;ii--) {
   try {
    var fl=eval("new ActiveXObject('ShockwaveFlash.ShockwaveFlash."+ii+"');");
    if (fl) { f=ii + '.0'; break; }
   }
   catch(e) {}
  }
 }
 return f;
}
function __utmLinker(l,h) {
 if (!_ulink) return;
 var p,k,a="-",b="-",c="-",x="-",z="-",v="-";
 var dc=_ubd.cookie;
 if (!l || l=="") return;
 var iq = l.indexOf("?");
 var ih = l.indexOf("#");
 if (dc) {
  a=_uES(_uGC(dc,"__utma="+_udh,";"));
  b=_uES(_uGC(dc,"__utmb="+_udh,";"));
  c=_uES(_uGC(dc,"__utmc="+_udh,";"));
  x=_uES(_uGC(dc,"__utmx="+_udh,";"));
  z=_uES(_uGC(dc,"__utmz="+_udh,";"));
  v=_uES(_uGC(dc,"__utmv="+_udh,";"));
  k=(_uHash(a+b+c+x+z+v)*1)+(_udh*1);
  p="__utma="+a+"&__utmb="+b+"&__utmc="+c+"&__utmx="+x+"&__utmz="+z+"&__utmv="+v+"&__utmk="+k;
 }
 if (p) {
  if (h && ih>-1) return;
  if (h) { _udl.href=l+"#"+p; }
  else {
   if (iq==-1 && ih==-1) _udl.href=l+"?"+p;
   else if (ih==-1) _udl.href=l+"&"+p;
   else if (iq==-1) _udl.href=l.substring(0,ih-1)+"?"+p+l.substring(ih);
   else _udl.href=l.substring(0,ih-1)+"&"+p+l.substring(ih);
  }
 } else { _udl.href=l; }
}
function __utmLinkPost(f,h) {
 if (!_ulink) return;
 var p,k,a="-",b="-",c="-",x="-",z="-",v="-";
 var dc=_ubd.cookie;
 if (!f || !f.action) return;
 var iq = f.action.indexOf("?");
 var ih = f.action.indexOf("#");
 if (dc) {
  a=_uES(_uGC(dc,"__utma="+_udh,";"));
  b=_uES(_uGC(dc,"__utmb="+_udh,";"));
  c=_uES(_uGC(dc,"__utmc="+_udh,";"));
  x=_uES(_uGC(dc,"__utmx="+_udh,";"));
  z=_uES(_uGC(dc,"__utmz="+_udh,";"));
  v=_uES(_uGC(dc,"__utmv="+_udh,";"));
  k=(_uHash(a+b+c+x+z+v)*1)+(_udh*1);
  p="__utma="+a+"&__utmb="+b+"&__utmc="+c+"&__utmx="+x+"&__utmz="+z+"&__utmv="+v+"&__utmk="+k;
 }
 if (p) {
  if (h && ih>-1) return;
  if (h) { f.action+="#"+p; }
  else {
   if (iq==-1 && ih==-1) f.action+="?"+p;
   else if (ih==-1) f.action+="&"+p;
   else if (iq==-1) f.action=f.action.substring(0,ih-1)+"?"+p+f.action.substring(ih);
   else f.action=f.action.substring(0,ih-1)+"&"+p+f.action.substring(ih);
  }
 }
 return;
}
function __utmSetVar(v) {
 if (!v || v=="") return;
 if (!_udo || _udo == "") {
  _udh=_uDomain();
  if (_udn && _udn!="") { _udo=" domain="+_udn+";"; }
 }
 if (!_uVG()) return;
 var r=Math.round(Math.random() * 2147483647);
 _ubd.cookie="__utmv="+_udh+"."+_uES(v)+"; path="+_utcp+"; expires=Sun, 18 Jan 2038 00:00:00 GMT;"+_udo;
 var s="&utmt=var&utmn="+r;
 if ((_userv==0 || _userv==2) && _uSP()) {
  var i=new Image(1,1);
  i.src=_ugifpath+"?"+"utmwv="+_uwv+s;
  i.onload=function() { _uVoid(); }
 }
 if ((_userv==1 || _userv==2) && _uSP()) {
  var i2=new Image(1,1);
  i2.src=_ugifpath2+"?"+"utmwv="+_uwv+s+"&utmac="+_uacct+"&utmcc="+_uGCS();
  i2.onload=function() { _uVoid(); }
 }
}
function _uGCS() {
 var t,c="",dc=_ubd.cookie;
 if ((t=_uGC(dc,"__utma="+_udh,";"))!="-") c+=_uES("__utma="+t+";+");
 if ((t=_uGC(dc,"__utmb="+_udh,";"))!="-") c+=_uES("__utmb="+t+";+");
 if ((t=_uGC(dc,"__utmc="+_udh,";"))!="-") c+=_uES("__utmc="+t+";+");
 if ((t=_uGC(dc,"__utmx="+_udh,";"))!="-") c+=_uES("__utmx="+t+";+");
 if ((t=_uGC(dc,"__utmz="+_udh,";"))!="-") c+=_uES("__utmz="+t+";+");
 if ((t=_uGC(dc,"__utmv="+_udh,";"))!="-") c+=_uES("__utmv="+t+";");
 if (c.charAt(c.length-1)=="+") c=c.substring(0,c.length-1);
 return c;
}
function _uGC(l,n,s) {
 if (!l || l=="" || !n || n=="" || !s || s=="") return "-";
 var i,i2,i3,c="-";
 i=l.indexOf(n);
 i3=n.indexOf("=")+1;
 if (i > -1) {
  i2=l.indexOf(s,i); if (i2 < 0) { i2=l.length; }
  c=l.substring((i+i3),i2);
 }
 return c;
}
function _uDomain() {
 if (!_udn || _udn=="" || _udn=="none") { _udn=""; return 1; }
 if (_udn=="auto") {
  var d=_ubd.domain;
  if (d.substring(0,4)=="www.") {
   d=d.substring(4,d.length);
  }
  _udn=d;
 }
 if (_uhash=="off") return 1;
 return _uHash(_udn);
}
function _uHash(d) {
 if (!d || d=="") return 1;
 var h=0,g=0;
 for (var i=d.length-1;i>=0;i--) {
  var c=parseInt(d.charCodeAt(i));
  h=((h << 6) & 0xfffffff) + c + (c << 14);
  if ((g=h & 0xfe00000)!=0) h=(h ^ (g >> 21));
 }
 return h;
}
function _uFixA(c,s,t) {
 if (!c || c=="" || !s || s=="" || !t || t=="") return "-";
 var a=_uGC(c,"__utma="+_udh,s);
 var lt=0,i=0;
 if ((i=a.lastIndexOf(".")) > 9) {
  _uns=a.substring(i+1,a.length);
  _uns=(_uns*1)+1;
  a=a.substring(0,i);
  if ((i=a.lastIndexOf(".")) > 7) {
   lt=a.substring(i+1,a.length);
   a=a.substring(0,i);
  }
  if ((i=a.lastIndexOf(".")) > 5) {
   a=a.substring(0,i);
  }
  a+="."+lt+"."+t+"."+_uns;
 }
 return a;
}
function _uTrim(s) {
  if (!s || s=="") return "";
  while ((s.charAt(0)==' ') || (s.charAt(0)=='\n') || (s.charAt(0,1)=='\r')) s=s.substring(1,s.length);
  while ((s.charAt(s.length-1)==' ') || (s.charAt(s.length-1)=='\n') || (s.charAt(s.length-1)=='\r')) s=s.substring(0,s.length-1);
  return s;
}
function _uEC(s) {
  var n="";
  if (!s || s=="") return "";
  for (var i=0;i<s.length;i++) {if (s.charAt(i)==" ") n+="+"; else n+=s.charAt(i);}
  return n;
}
function __utmVisitorCode(f) {
 var r=0,t=0,i=0,i2=0,m=31;
 var a=_uGC(_ubd.cookie,"__utma="+_udh,";");
 if ((i=a.indexOf(".",0))<0) return;
 if ((i2=a.indexOf(".",i+1))>0) r=a.substring(i+1,i2); else return "";
 if ((i=a.indexOf(".",i2+1))>0) t=a.substring(i2+1,i); else return "";
 if (f) {
  return r;
 } else {
  var c=new Array('A','B','C','D','E','F','G','H','J','K','L','M','N','P','R','S','T','U','V','W','X','Y','Z','1','2','3','4','5','6','7','8','9');
  return c[r>>28&m]+c[r>>23&m]+c[r>>18&m]+c[r>>13&m]+"-"+c[r>>8&m]+c[r>>3&m]+c[((r&7)<<2)+(t>>30&3)]+c[t>>25&m]+c[t>>20&m]+"-"+c[t>>15&m]+c[t>>10&m]+c[t>>5&m]+c[t&m];
 }
}
function _uIN(n) {
 if (!n) return false;
 for (var i=0;i<n.length;i++) {
  var c=n.charAt(i);
  if ((c<"0" || c>"9") && (c!=".")) return false;
 }
 return true;
}
function _uES(s,u) {
 if (typeof(encodeURIComponent) == 'function') {
  if (u) return encodeURI(s);
  else return encodeURIComponent(s);
 } else {
  return escape(s);
 }
}
function _uUES(s) {
 if (typeof(decodeURIComponent) == 'function') {
  return decodeURIComponent(s);
 } else {
  return unescape(s);
 }
}
function _uVG() {
 if((_udn.indexOf("www.google.") == 0 || _udn.indexOf(".google.") == 0 || _udn.indexOf("google.") == 0) && _utcp=='/') {
  return false;
 }
 return true;
}
function _uSP() {
 var s=100;
 if (_usample) s=_usample;
 if(s>=100 || s<=0) return true;
 return ((__utmVisitorCode(1)%10000)<(s*100));
}
</script>

<script type="text/javascript">
// -----------------------------------------------------------------------------------
//
//	Lightbox v2.02
//	by Lokesh Dhakar - http://www.huddletogether.com
//	3/31/06
//
//	For more information on this script, visit:
//	http://huddletogether.com/projects/lightbox2/
//
//	Licensed under the Creative Commons Attribution 2.5 License - http://creativecommons.org/licenses/by/2.5/
//
//	Credit also due to those who have helped, inspired, and made their code available to the public.
//	Including: Scott Upton(uptonic.com), Peter-Paul Koch(quirksmode.org), Thomas Fuchs(mir.aculo.us), and others.
//
//
// -----------------------------------------------------------------------------------
/*

History of changes by ahavriluk:
07/23/06 - fixed issue with background color being green in FireFox. Made music player appear and hide depending on
				   slideshow play mode.
07/21/06 - added color background support for music player. To change the skin look at createMusicPlayer function.
07/19/06 - added changeImageByTimer() function which helps to load the image while the entire page is loading.
07/17/06 - fixed a bug when slideshow doesn't start if navigation buttons (next/prev) were used first and slideshow=0 at start
	 - added code to remove dotted lines around images-links
	 - added code which suppose to help starting slideshow before a page is totaly loaded
*/

/*

	Table of Contents
	-----------------
	Configuration
	Global Variables

	Extending Built-in Objects
	- Object.extend(Element)
	- Array.prototype.removeDuplicates()
	- Array.prototype.empty()

	Lightbox Class Declaration
	- initialize()
	- start()
	- changeImage()
	- resizeImageContainer()
	- showImage()
	- updateDetails()
	- updateNav()
	- enableKeyboardNav()
	- disableKeyboardNav()
	- keyboardAction()
	- preloadNeighborImages()
	- end()

	Miscellaneous Functions
	- getPageScroll()
	- getPageSize()
	- getKey()
	- listenKey()
	- showSelectBoxes()
	- hideSelectBoxes()
	- pause()
	- initLightbox()

	Function Calls
	- addLoadEvent(initLightbox)

	Slideshow Functions
	- toggleSlideShow()
	- startSlideShow()
	- stopSlideShow()
	- showMusicPlayer()
	- playMusic()
	- stopMusic()



*/
// -----------------------------------------------------------------------------------

//
//	Configuration
//
var musicPlayer = "http://www.therandomhomepage.com/js/playerMini.swf"
var fileLoadingImage = "http://www.therandomhomepage.com/images/lightbox/loading.gif";
var fileBottomNavCloseImage = "http://www.therandomhomepage.com/images/lightbox/close1.gif";
var resizeSpeed = 7;		// controls the speed of the image resizing (1=slowest and 10=fastest)
var borderSize = 10;		//if you adjust the padding in the CSS, you will need to update this variable

//--- Slideshow options
//var slideShowWidth = 600;	// -1 size slideshow window based on each image
//var slideShowHeight = 450;	// -1 size slideshow window based on each image
var slideShowWidth = -1;
var slideShowHeight = -1;
var SlideShowStartImage = "http://www.therandomhomepage.com/images/lightbox/start.gif";	// Slideshow toggle button
var SlideShowStopImage = "http://www.therandomhomepage.com/images/lightbox/stop.gif";
var slideshow = 1;   		// Set 0 if you want to disable slideshows by default
var foreverLoop = 0;		// Set 0 if want to stop on last image or Set 1 for Infinite loop feature
var loopInterval = 3000;	// image swap interval
var resize = 1;// Set 0 to disable auto-resizing
// -----------------------------------------------------------------------------------

//
//	Global Variables
//

var imageArray = new Array;
var activeImage;

if(resizeSpeed > 10){ resizeSpeed = 10;}
if(resizeSpeed < 1){ resizeSpeed = 1;}
resizeDuration = (11 - resizeSpeed) * 0.15;

var so = null;
var objSlideShowImage;
var objLightboxImage;
var objImageDataContainer;

var keyPressed = false;
var slideshowMusic = null;
var firstTime = 1;

var saveSlideshow;
var saveForeverLoop;
var saveLoopInterval;
var saveSlideShowWidth;
var saveSlideShowHeight;
// -----------------------------------------------------------------------------------

//
//	Additional methods for Element added by SU, Couloir
//	- further additions by Lokesh Dhakar (huddletogether.com)
//
Object.extend(Element, {
	getWidth: function(element) {
	   	element = $(element);
	   	return element.offsetWidth;
	},
	setWidth: function(element,w) {
	   	element = $(element);
    	element.style.width = w +"px";
	},
	setHeight: function(element,h) {
   		element = $(element);
    	element.style.height = h +"px";
	},
	setTop: function(element,t) {
	   	element = $(element);
    	element.style.top = t +"px";
	},
	setSrc: function(element,src) {
    	element = $(element);
    	element.src = src;
	},
	setHref: function(element,href) {
    	element = $(element);
    	element.href = href;
	},
	setInnerHTML: function(element,content) {
		element = $(element);
		element.innerHTML = content;
	}
});

// -----------------------------------------------------------------------------------

//
//	Extending built-in Array object
//	- array.removeDuplicates()
//	- array.empty()
//
Array.prototype.removeDuplicates = function () {
	for(i = 1; i < this.length; i++){
		if(this[i][0] == this[i-1][0]){
			this.splice(i,1);
		}
	}
}

// -----------------------------------------------------------------------------------

Array.prototype.empty = function () {
	for(i = 0; i <= this.length; i++){
		this.shift();
	}
}

// -----------------------------------------------------------------------------------

//
//	Lightbox Class Declaration
//	- initialize()
//	- start()
//	- changeImage()
//	- resizeImageContainer()
//	- showImage()
//	- updateDetails()
//	- updateNav()
//	- enableKeyboardNav()
//	- disableKeyboardNav()
//	- keyboardNavAction()
//	- preloadNeighborImages()
//	- end()
//
//	Structuring of code inspired by Scott Upton (http://www.uptonic.com/)
//
var Lightbox = Class.create();

Lightbox.prototype = {

	// initialize()
	// Constructor runs on completion of the DOM loading. Loops through anchor tags looking for
	// 'lightbox' references and applies onclick events to appropriate links. The 2nd section of
	// the function inserts html at the bottom of the page which is used to display the shadow
	// overlay and the image container.
	//
	initialize: function() {
		if (!document.getElementsByTagName){ return; }
		var anchors = document.getElementsByTagName('a');

		alert("	anchors.length = "+anchors.length);
		// loop through all anchor tags
		for (var i=0; i<anchors.length; i++){
			var anchor = anchors[i];

			var relAttribute = String(anchor.getAttribute('rel'));

			// use the string.match() method to catch 'lightbox' references in the rel attribute
			if (anchor.getAttribute('href') && (relAttribute.toLowerCase().match('lightbox'))){
				alert("Adding onclick");
				anchor.onclick = function () {
					alert("Anchor Click");
					myLightbox.start(this);
					return false;
				}
			}
		}

		// The rest of this code inserts html at the bottom of the page that looks similar to this:
		//
		//	<div id="overlay"></div>
		//	<div id="lightbox">
		//		<div id="outerImageContainer">
		//			<div id="imageContainer">
		//				<img id="lightboxImage">
		//				<div style="" id="hoverNav">
		//					<a href="#" id="prevLink"></a>
		//					<a href="#" id="nextLink"></a>
		//				</div>
		//				<div id="loading">
		//					<a href="#" id="loadingLink">
		//						<img src="images/loading.gif">
		//					</a>
		//				</div>
		//			</div>
		//		</div>
		//		<div id="imageDataContainer">
		//			<div id="imageData">
		//				<div id="imageDetails">
		//					<span id="caption"></span>
		//					<span id="numberDisplay"></span>
		//				</div>
		//				<div id="bottomNav">
		//					<a href="#" id="bottomNavClose">
		//						<img src="images/close.gif">
		//					</a>
		//				</div>
		//			</div>
		//		</div>
		//	</div>


		var objBody = document.getElementsByTagName("body").item(0);

		try
		{
			var objOverlay = document.createElement("div");
			objOverlay.setAttribute('id','overlay');
			objOverlay.style.display = 'none';
			objOverlay.onclick = function() { myLightbox.end(); return false; }
			objBody.appendChild(objOverlay);
		}
		catch (e)
		{
			alert("Error while appending child to body = "+e);
		}

		var objLightbox = document.createElement("div");
		objLightbox.setAttribute('id','lightbox');
		objLightbox.style.display = 'none';
		objBody.appendChild(objLightbox);

		var objOuterImageContainer = document.createElement("div");
		objOuterImageContainer.setAttribute('id','outerImageContainer');
		objLightbox.appendChild(objOuterImageContainer);

		var objImageContainer = document.createElement("div");
		objImageContainer.setAttribute('id','imageContainer');
		objOuterImageContainer.appendChild(objImageContainer);

		objLightboxImage = document.createElement("img");
		objLightboxImage.setAttribute('id','lightboxImage');
		objLightboxImage.setAttribute('width',''); //needed for proper resizing
		objLightboxImage.setAttribute('height',''); //needed for proper resizing
		objImageContainer.appendChild(objLightboxImage);

		var objHoverNav = document.createElement("div");
		objHoverNav.setAttribute('id','hoverNav');
		objImageContainer.appendChild(objHoverNav);

		var objPrevLink = document.createElement("a");
		objPrevLink.setAttribute('id','prevLink');
		objPrevLink.setAttribute('href','#');
		objPrevLink.setAttribute('onFocus', 'if (this.blur) this.blur()');
		objHoverNav.appendChild(objPrevLink);

		var objNextLink = document.createElement("a");
		objNextLink.setAttribute('id','nextLink');
		objNextLink.setAttribute('href','#');
		objNextLink.setAttribute('onFocus', 'if (this.blur) this.blur()');
		objHoverNav.appendChild(objNextLink);

		var objLoading = document.createElement("div");
		objLoading.setAttribute('id','loading');
		objImageContainer.appendChild(objLoading);

		var objLoadingLink = document.createElement("a");
		objLoadingLink.setAttribute('id','loadingLink');
		objLoadingLink.setAttribute('href','#');
		objLoadingLink.setAttribute('onFocus', 'if (this.blur) this.blur()');
		objLoadingLink.onclick = function() { myLightbox.end(); return false; }
		objLoading.appendChild(objLoadingLink);

		var objLoadingImage = document.createElement("img");
		objLoadingImage.setAttribute('src', fileLoadingImage);
		objLoadingLink.appendChild(objLoadingImage);

		objImageDataContainer = document.createElement("div");
		objImageDataContainer.setAttribute('id','imageDataContainer');
		objImageDataContainer.className = 'clearfix';
		objLightbox.appendChild(objImageDataContainer);

		var objImageData = document.createElement("div");
		objImageData.setAttribute('id','imageData');
		objImageDataContainer.appendChild(objImageData);

		var objImageDetails = document.createElement("div");
		objImageDetails.setAttribute('id','imageDetails');
		objImageData.appendChild(objImageDetails);

		var objCaption = document.createElement("span");
		objCaption.setAttribute('id','caption');
		objImageDetails.appendChild(objCaption);

		var objNumberDisplay = document.createElement("span");
		objNumberDisplay.setAttribute('id','numberDisplay');
		objImageDetails.appendChild(objNumberDisplay);


		//Bottom Navigation
		var objBottomNav = document.createElement("div");
		objBottomNav.setAttribute('id','bottomNav');
		objImageData.appendChild(objBottomNav);


		var objBottomNavCloseLink = document.createElement("a");
		objBottomNavCloseLink.setAttribute('id','bottomNavClose');
		objBottomNavCloseLink.setAttribute('href','#');
		objBottomNavCloseLink.setAttribute('onFocus', 'if (this.blur) this.blur()');
		objBottomNavCloseLink.onclick = function() { myLightbox.end(); return false; }
		objBottomNav.appendChild(objBottomNavCloseLink);

		var objBottomNavCloseImage = document.createElement("img");
		objBottomNavCloseImage.setAttribute('src', fileBottomNavCloseImage);
		objBottomNavCloseLink.appendChild(objBottomNavCloseImage);

  			// slide show link
	 		var objSlideShowLink = document.createElement("a");
			objSlideShowLink.setAttribute('id','slideshowLink');
			objSlideShowLink.setAttribute('href','#');
			objSlideShowLink.setAttribute('onFocus', 'if (this.blur) this.blur()');
			objSlideShowLink.onclick = function() { myLightbox.toggleSlideShow(); return false; }
			objBottomNav.appendChild(objSlideShowLink);

			objSlideShowImage = document.createElement("img");
			objSlideShowImage.setAttribute('src', SlideShowStartImage);
			objSlideShowLink.appendChild(objSlideShowImage);

			//music player
			var objFlashPlayer = document.createElement("div");
			objFlashPlayer.setAttribute('id','flashPlayer');
			objBottomNav.appendChild(objFlashPlayer);
	},

	//
	//	start()
	//	Display overlay and lightbox. If image is part of a set, add siblings to imageArray.
	//
	start: function(imageLink) {
		firstTime = 1;
		saveSlideshow = slideshow;
		saveForeverLoop = foreverLoop;
		saveLoopInterval = loopInterval;

		saveSlideShowWidth = slideShowWidth;
		saveSlideShowHeight = slideShowHeight;

		hideSelectBoxes();

		// stretch overlay to fill page and fade in
		var arrayPageSize = getPageSize();
		Element.setHeight('overlay', arrayPageSize[1]);
		new Effect.Appear('overlay', { duration: 0.2, from: 0.0, to: 0.8 });

		imageArray = [];
		imageNum = 0;

		if (!document.getElementsByTagName){ return; }
		var anchors = document.getElementsByTagName('a');

		// if image is NOT part of a set..
		if((imageLink.getAttribute('rel') == 'lightbox')){
			// add single image to imageArray
			imageArray.push(new Array(imageLink.getAttribute('href'), imageLink.getAttribute('title')));
		} else {
		// if image is part of a set..

			// loop through anchors, find other images in set, and add them to imageArray
			for (var i=0; i<anchors.length; i++){
				var anchor = anchors[i];
				if (anchor.getAttribute('href') && (anchor.getAttribute('rel') == imageLink.getAttribute('rel'))){
					imageArray.push(new Array(anchor.getAttribute('href'), anchor.getAttribute('title')));

					if (imageArray.length == 1) {
					  slideshowMusic = anchor.getAttribute('music');
					  if (slideshowMusic == null) {
						  Element.hide('flashPlayer');
					  } else
						{ Element.show('flashPlayer');	}

					  var startSlideshow = anchor.getAttribute('startslideshow');
					  if (startSlideshow != null) {
						if (startSlideshow == "false") slideshow = 0;
					  }

					  var forever = anchor.getAttribute('forever');
					  if (forever != null) {
						if (forever == "true") foreverLoop = 1; else foreverLoop = 0;
					  }
					  var slideDuration = anchor.getAttribute('slideDuration');
					  if (slideDuration != null) {
						loopInterval = slideDuration * 1000;
					  }
					  var width = anchor.getAttribute('slideshowwidth');
					  if (width != null) {
						slideShowWidth = width *1;
					  }
					  var height = anchor.getAttribute('slideshowheight');
					  if (height != null) {
						slideShowHeight = height *1;
					  }
					}

				}
			}

			imageArray.removeDuplicates();
			while(imageArray[imageNum][0] != imageLink.getAttribute('href')) { imageNum++;}
		}

		this.changeImageByTimer(imageNum);
	},

	showLightBox: function() {
		    // calculate top offset for the lightbox and display
	            var arrayPageSize = getPageSize();
		    var arrayPageScroll = getPageScroll();
		    var lightboxTop = arrayPageScroll[1] + (arrayPageSize[3] / 15);

		    Element.setTop('lightbox', lightboxTop);
		    Element.show('lightbox');
	},

	// changeImageByTimer()
	// changes image using timer, which prevents the loading gif from spinning
	// until the entire page is loaded
    	changeImageByTimer: function(imageNum) {
    			activeImage = imageNum;
    			this.imageTimer = setTimeout(function() {
    			this.showLightBox();
    			this.changeImage(activeImage);
    		}.bind(this), 10);
   	 },

	//
	//	changeImage()
	//	Hide most elements and preload image in preparation for resizing image container.
	//
	changeImage: function(imageNum) {

		activeImage = imageNum;	// update global var

		// hide elements during transition
		Element.show('loading');
		Element.hide('lightboxImage');
		Element.hide('hoverNav');
		Element.hide('prevLink');
		Element.hide('nextLink');


		if (firstTime == 1) {
	  	  Element.hide('imageDataContainer');
		  Element.hide('numberDisplay');
		  Element.hide('slideshowLink');
		}

		imgPreloader = new Image();

		// once image is preloaded, resize image container
		imgPreloader.onload=function(){
			Element.setSrc('lightboxImage', imageArray[activeImage][0]);

			objLightboxImage.setAttribute('width', imgPreloader.width);
			objLightboxImage.setAttribute('height', imgPreloader.height);

			if ((imageArray.length > 1) && (slideShowWidth != -1 || slideShowHeight != -1)) {
			   if (	(slideShowWidth >= imgPreloader.width) &&
			        (slideShowHeight >= imgPreloader.height)
			      ) {
			  myLightbox.resizeImageContainer(slideShowWidth, slideShowHeight);
			} else {
				  myLightbox.resizeImageAndContainer(imgPreloader.width, imgPreloader.height);
			}

			} else {
			  myLightbox.resizeImageAndContainer(imgPreloader.width, imgPreloader.height);
			}
		}
		imgPreloader.src = imageArray[activeImage][0];
	},

	resizeImageAndContainer: function(imgWidth, imgHeight) {
		if(resize == 1) {//resize mod by magarnicle
			useableWidth = 0.9; // 90% of the window
			useableHeight = 0.8; // 80% of the window
			var arrayPageSize = getPageSize();
			windowWidth = arrayPageSize[2];
			windowHeight = arrayPageSize[3];
			scaleX = 1; scaleY = 1;
			if ( imgWidth > windowWidth * useableWidth ) scaleX = (windowWidth * useableWidth) / imgWidth;
			if ( imgHeight > windowHeight * useableHeight ) scaleY = (windowHeight * useableHeight) / imgHeight;
			scale = Math.min( scaleX, scaleY );
			imgWidth *= scale;
			imgHeight *= scale;

			 objLightboxImage.setAttribute('width', imgWidth);
			 objLightboxImage.setAttribute('height', imgHeight);
		}
		this.resizeImageContainer(imgWidth, imgHeight);
	},

	//
	//	resizeImageContainer()
	//
	resizeImageContainer: function( imgWidth, imgHeight) {

		// get current height and width
		this.wCur = Element.getWidth('outerImageContainer');
		this.hCur = Element.getHeight('outerImageContainer');

		// scalars based on change from old to new
		this.xScale = ((imgWidth  + (borderSize * 2)) / this.wCur) * 100;
		this.yScale = ((imgHeight  + (borderSize * 2)) / this.hCur) * 100;

		// calculate size difference between new and old image, and resize if necessary
		wDiff = (this.wCur - borderSize * 2) - imgWidth;
		hDiff = (this.hCur - borderSize * 2) - imgHeight;

		if(!( hDiff == 0)){ new Effect.Scale('outerImageContainer', this.yScale, {scaleX: false, duration: resizeDuration, queue: 'front'}); }
		if(!( wDiff == 0)){ new Effect.Scale('outerImageContainer', this.xScale, {scaleY: false, delay: resizeDuration, duration: resizeDuration}); }

		// if new and old image are same size and no scaling transition is necessary,
		// do a quick pause to prevent image flicker.
		if((hDiff == 0) && (wDiff == 0)){
			if (navigator.appVersion.indexOf("MSIE")!=-1){ pause(250); } else { pause(100);}
		}

		Element.setHeight('prevLink', imgHeight);
		Element.setHeight('nextLink', imgHeight);
		Element.setWidth( 'imageDataContainer', imgWidth + (borderSize * 2));

		this.showImage();
	},

	//
	//	showImage()
	//	Display image and begin preloading neighbors.
	//
	showImage: function(){
		Element.hide('loading');
		new Effect.Appear('lightboxImage', { duration: 0.5, queue: 'end', afterFinish: function(){ myLightbox.updateDetails(); } });
		this.preloadNeighborImages();
	},

	//
	//	updateDetails()
	//	Display caption, image number, and bottom nav.
	//
	updateDetails: function() {

		Element.show('caption');
		if (imageArray[activeImage][1] != '') {
			Element.setInnerHTML( 'caption', imageArray[activeImage][1]);
		} else {
			Element.setInnerHTML( 'caption', "&nbsp;");
		}

		// if image is part of set display 'Image x of x'
		if(imageArray.length > 1){
			Element.show('numberDisplay');
			Element.setInnerHTML( 'numberDisplay', "" + eval(activeImage + 1) + " of " + imageArray.length);
		}

		if (firstTime == 1) {
                  //firstTime = 0;
		  new Effect.Parallel(
			[ new Effect.SlideDown( 'imageDataContainer', { sync: true, duration: resizeDuration + 0.25, from: 0.0, to: 1.0 }),
			  new Effect.Appear('imageDataContainer', { sync: true, duration: 1.0 }) ],
		 	{ duration: 0.65, afterFinish: function() { myLightbox.updateNav();} }
		  );
		} else {
		  //this code was commented out because it causes the music player to restart in Firefox
//		  new Effect.Parallel(
//			[ new Effect.Appear('imageDataContainer', { sync: true, duration: 1.0 }) ],
//		 	{ duration: 0.65, afterFinish: function() { myLightbox.updateNav();} }
//		  );
		  myLightbox.updateNav();
		}


			if (imageArray.length > 1) {
			   Element.show('flashPlayer');
			   Element.show('slideshowLink');
			}else {
			   Element.hide('flashPlayer');
			   Element.hide('slideshowLink');
			}

   		       if (slideshow == 1) {
				this.startSlideShow();
			   }

	},

	//
	//	updateNav()
	//	Display appropriate previous and next hover navigation.
	//
	updateNav: function() {

		Element.show('hoverNav');

		// if not first image in set, display prev image button
		if(activeImage != 0){
			Element.show('prevLink');
			document.getElementById('prevLink').onclick = function() {
				if (slideshow == 1) keyPressed = true;
				myLightbox.changeImage(activeImage - 1); return false;
			}
		}

		// if not last image in set, display next image button
		if(activeImage != (imageArray.length - 1)){
			Element.show('nextLink');
			document.getElementById('nextLink').onclick = function() {
				if (slideshow == 1) keyPressed = true;
				myLightbox.changeImage(activeImage + 1); return false;
			}
		}

		this.enableKeyboardNav();

		if (firstTime == 1) {
		  firstTime = 0;
		  if (imageArray.length > 1 && slideshow == 1) this.showMusicPlayer();
		  if (slideshow == 1) this.playMusic();
		}
	},

	//
	//	enableKeyboardNav()
	//
	enableKeyboardNav: function() {
		document.onkeydown = this.keyboardAction;
	},

	//
	//	disableKeyboardNav()
	//
	disableKeyboardNav: function() {
		document.onkeydown = '';
	},

	//
	//	keyboardAction()
	//
	keyboardAction: function(e) {
		if (e == null) { // ie
			keycode = event.keyCode;
		} else { // mozilla
			keycode = e.which;
		}

		key = String.fromCharCode(keycode).toLowerCase();

		if((key == 'x') || (key == 'o') || (key == 'c')){	// close lightbox
			myLightbox.end();
		} else if((keycode == 188) || (key == 'p')){	// display previous image
			if(activeImage != 0){
				if (slideshow == 1) keyPressed = true;
				myLightbox.disableKeyboardNav();
				myLightbox.changeImage(activeImage - 1);
			}
		} else if((keycode == 190) || (key == 'n')){	// display next image
			if(activeImage != (imageArray.length - 1)){
				if (slideshow == 1) keyPressed = true;
				myLightbox.disableKeyboardNav();
				myLightbox.changeImage(activeImage + 1);
			}
		}


	},

	//
	//	preloadNeighborImages()
	//	Preload previous and next images.
	//
	preloadNeighborImages: function(){

		if((imageArray.length - 1) > activeImage){
			preloadNextImage = new Image();
			preloadNextImage.src = imageArray[activeImage + 1][0];
		}
		if(activeImage > 0){
			preloadPrevImage = new Image();
			preloadPrevImage.src = imageArray[activeImage - 1][0];
		}

	},


	//
	//	toggleSlideShow()
	//	startSlideShow()
	//	stopSlideShow()
	//	Slideshow Functions
	//

	createMusicPlayer: function() {
	      var color = Element.getStyle('imageDataContainer', 'background-color').parseColor();
	      obj = new SWFObject(musicPlayer, "mymovie", "75", "30", "7", color);
	      obj.addVariable("soundPath", slideshowMusic);
	      obj.addVariable("playerSkin", "5"); //skin 1-5
	      return obj;
	},

	showMusicPlayer: function() {
	   if (slideshowMusic != null) {
	      Element.show('flashPlayer');
	      so = this.createMusicPlayer();

	      so.addVariable("autoPlay", "no");
	      so.write("flashPlayer");
	   } else {
		Element.hide('flashPlayer');
		}
	},

	playMusic: function() {
	   if (slideshowMusic != null) {
		  so = this.createMusicPlayer();

	      so.addVariable("autoPlay", "yes");
	      so.write("flashPlayer");
	   }
	},

	stopMusic: function() {
	   if ((slideshowMusic != null) && (so != null)) {
		   so = this.createMusicPlayer();

	     so.addVariable("autoPlay", "no");
	     so.write("flashPlayer");
       }
	},

	toggleSlideShow: function() {
		if(slideshow == 1) this.stopSlideShow();
		else {
		   this.playMusic();
		   if(activeImage == (imageArray.length-1)) {
			slideshow = 1;
			this.changeImage(0);
		   } else {
		   	this.startSlideShow();
		   }
		}
	},

	startSlideShow: function() {
		slideshow = 1;
		objSlideShowImage.setAttribute('src', SlideShowStopImage);
		this.slideShowTimer = setTimeout(function() {
			if (keyPressed) {
 				keyPressed = false;
				return;
			}
			if(activeImage < (imageArray.length-1)) this.changeImage(activeImage + 1);
			else {
				if(foreverLoop) this.changeImage(0);
				else {
					this.stopMusic();
					slideshow = 0;
					objSlideShowImage.setAttribute('src', SlideShowStartImage);
				}
			     }
		}.bind(this), loopInterval);
	},

	stopSlideShow: function() {
		slideshow = 0;
		objSlideShowImage.setAttribute('src', SlideShowStartImage);
		this.stopMusic();
		if(this.slideShowTimer) {
			clearTimeout(this.slideShowTimer);
			this.slideShowTimer = null;
			Element.setInnerHTML('flashPlayer', '');
		}
	},

	//
	//	end()
	//
	end: function() {
		this.stopSlideShow();
		this.disableKeyboardNav();
		Element.hide('lightbox');
		new Effect.Fade('overlay', { duration: 0.2});
		showSelectBoxes();

		slideshow = saveSlideshow;
		foreverLoop = saveForeverLoop;
		loopInterval = saveLoopInterval;

		slideShowWidth = saveSlideShowWidth;
		slideShowHeight = saveSlideShowHeight;
	}
}

// -----------------------------------------------------------------------------------

//
// getPageScroll()
// Returns array with x,y page scroll values.
// Core code from - quirksmode.org
//
function getPageScroll(){

	var yScroll;

	if (self.pageYOffset) {
		yScroll = self.pageYOffset;
	} else if (document.documentElement && document.documentElement.scrollTop){	 // Explorer 6 Strict
		yScroll = document.documentElement.scrollTop;
	} else if (document.body) {// all other Explorers
		yScroll = document.body.scrollTop;
	}

	arrayPageScroll = new Array('',yScroll)
	return arrayPageScroll;
}

// -----------------------------------------------------------------------------------

//
// getPageSize()
// Returns array with page width, height and window width, height
// Core code from - quirksmode.org
// Edit for Firefox by pHaez
//
function getPageSize(){

	var xScroll, yScroll;

	if (window.innerHeight && window.scrollMaxY) {
		xScroll = document.body.scrollWidth;
		yScroll = window.innerHeight + window.scrollMaxY;
	} else if (document.body.scrollHeight > document.body.offsetHeight){ // all but Explorer Mac
		xScroll = document.body.scrollWidth;
		yScroll = document.body.scrollHeight;
	} else { // Explorer Mac...would also work in Explorer 6 Strict, Mozilla and Safari
		xScroll = document.body.offsetWidth;
		yScroll = document.body.offsetHeight;
	}

	var windowWidth, windowHeight;
	if (self.innerHeight) {	// all except Explorer
		windowWidth = self.innerWidth;
		windowHeight = self.innerHeight;
	} else if (document.documentElement && document.documentElement.clientHeight) { // Explorer 6 Strict Mode
		windowWidth = document.documentElement.clientWidth;
		windowHeight = document.documentElement.clientHeight;
	} else if (document.body) { // other Explorers
		windowWidth = document.body.clientWidth;
		windowHeight = document.body.clientHeight;
	}

	// for small pages with total height less then height of the viewport
	if(yScroll < windowHeight){
		pageHeight = windowHeight;
	} else {
		pageHeight = yScroll;
	}

	// for small pages with total width less then width of the viewport
	if(xScroll < windowWidth){
		pageWidth = windowWidth;
	} else {
		pageWidth = xScroll;
	}


	arrayPageSize = new Array(pageWidth,pageHeight,windowWidth,windowHeight)
	return arrayPageSize;
}

// -----------------------------------------------------------------------------------

//
// getKey(key)
// Gets keycode. If 'x' is pressed then it hides the lightbox.
//
function getKey(e){
	if (e == null) { // ie
		keycode = event.keyCode;
	} else { // mozilla
		keycode = e.which;
	}
	key = String.fromCharCode(keycode).toLowerCase();

	if(key == 'x'){
	}
}

// -----------------------------------------------------------------------------------

//
// listenKey()
//
function listenKey () {	document.onkeypress = getKey; }

// ---------------------------------------------------

function showSelectBoxes(){
	selects = document.getElementsByTagName("select");
	for (i = 0; i != selects.length; i++) {
		selects[i].style.visibility = "visible";
	}
}

// ---------------------------------------------------

function hideSelectBoxes(){
	selects = document.getElementsByTagName("select");
	for (i = 0; i != selects.length; i++) {
		selects[i].style.visibility = "hidden";
	}
}

// ---------------------------------------------------

//
// pause(numberMillis)
// Pauses code execution for specified time. Uses busy code, not good.
// Code from http://www.faqts.com/knowledge_base/view.phtml/aid/1602
//
function pause(numberMillis) {
	var now = new Date();
	var exitTime = now.getTime() + numberMillis;
	while (true) {
		now = new Date();
		if (now.getTime() > exitTime)
			return;
	}
}

// ---------------------------------------------------



function initLightbox() { myLightbox = new Lightbox(); }
//Event.observe(window, 'load', initLightbox, false);



//the code below suppose to help starting slideshow before a page is totaly loaded
function init() {
    // quit if this function has already been called
    if (arguments.callee.done) return;

    // flag this function so we don't do the same thing twice
    arguments.callee.done = true;

    // kill the timer
    if (_timer) {
        clearInterval(_timer);
        _timer = null;
    }

    // do onload stuff
    initLightbox();

};



/* for Mozilla */

if (document.addEventListener) {
    document.addEventListener("DOMContentLoaded", init, false);

}

/* for other browsers */
//window.onload = init;

</script>

<script type="text/javascript">

/*					effectshelper.js
 *
 *  (c) 2005 Siddique Hameed <siddii@gmail.com>
 *
 *
 *	Last Updated :	12/12/2006
 *  For details, see web site: http://www.TheRandomHomepage.com
 *
/*--------------------------------------------------------------------------*/

var TRANSITION_EFFECT_NONE   = -1;
var TRANSITION_EFFECT_RANDOM =  0;
var TRANSITION_EFFECT_BLINDOWN = 1;
var TRANSITION_EFFECT_HIGHLIGHT = 2;
var TRANSITION_EFFECT_SHAKE = 3;
var TRANSITION_EFFECT_PULSATE = 4;
var TRANSITION_EFFECT_GROW = 5;
var TRANSITION_EFFECT_SLIDEDOWN = 6;


function callBackOnFinish(obj){
		try
		{
		   for(var i in obj.effects){
			 if (!Element.visible(obj.effects[i]['element']))
			 {
				new Effect.Appear(obj.effects[i]['element']);
			 }
		   }
		}
		catch (e)
		{
		}
    }

function applyEffect(element, effectsConstant){
	switch(effectsConstant){
		case TRANSITION_EFFECT_RANDOM:
			applyEffect(element,getRandomNo(TRANSITION_EFFECT_SLIDEDOWN));
			break;
		case TRANSITION_EFFECT_BLINDOWN:
			new Effect.BlindDown(element,{afterFinish: callBackOnFinish});
			break;
		case TRANSITION_EFFECT_HIGHLIGHT:
			new Effect.Highlight(element,{afterFinish: callBackOnFinish});
			break;
		case TRANSITION_EFFECT_SHAKE:
			new Effect.Shake(element,{afterFinish: callBackOnFinish});
			break;
		case TRANSITION_EFFECT_PULSATE:
			new Effect.Pulsate(element,{afterFinish: callBackOnFinish});
			break;
		case TRANSITION_EFFECT_GROW:
			new Effect.Grow(element,{afterFinish: callBackOnFinish});
			break;
		case TRANSITION_EFFECT_SLIDEDOWN:
			new Effect.SlideDown(element,{afterFinish: callBackOnFinish});
			break;
	}
}

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


var rssFeedArr = new Array();

var prevIdx = -1;

var tags = "";
var transitionEffect = 0;
var imageClickBehaviour = 0;
var slideshowDelay = 0;

var controlElement = null;

var shouldBeRunning = true;

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
				alert(" lightboxHTML = "+lightboxHTML);
				Element.update(divContent,lightboxHTML);
				alert("After update ");
			}
			else {
				alert("No DIV CONTENT ");
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
					else {
						alert("No overlay element found ");
					}

					var lightboxElement = $('lightbox');

					if (lightboxElement)
					{
						Element.remove(lightboxElement);
					}
					else {
						alert("No lightbox element found ");
					}
					initLightbox();
				}
				showRandomFlickrImage();
			}
			catch (e)
			{
				alert("Error "+e);
			}



			controlElement = $('divRandomFlickrControl');
			if (slideshowDelay > 0)
			{
				new PeriodicalExecuter(showRandomFlickrImage, slideshowDelay);
				Element.update(controlElement,"<img src='http://www.therandomhomepage.com/images/lightbox/stop.gif' onclick='stopSlideShow();' title='Stop Slideshow'/>");

				$(divRandomFlickrContent).onclick = stopSlideShow;
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
			alert("showRandomFlickrImage ");
			if (prevIdx > -1)
			{
				var prevAnchorElement = $('lightboxAnc'+prevIdx);
				Element.hide(prevAnchorElement);
			}

			var randIdx = getRandomNo(rssFeedArr.length);

			alert("randIdx "+randIdx);

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
			Element.update(controlElement,"<img src='http://www.therandomhomepage.com/images/lightbox/start.gif' onclick='startSlideShow();' title='Start Slideshow'/>");
			shouldBeRunning = false;
		}
	}

	function startSlideShow(){
		if (!shouldBeRunning)
		{
			Element.update(controlElement,"<img src='http://www.therandomhomepage.com/images/lightbox/stop.gif' onclick='stopSlideShow();' title='Stop Slideshow'/>");
			shouldBeRunning = true;
		}
	}

	function randomFlickrLoad(){
		tags = getValue("tags") != "undefined" ? getValue("tags") : "art,colorful,travel";
		transitionEffect = getValue("transition_effect") != "undefined" ? getValue("transition_effect") : 0;
		imageClickBehaviour = getValue("image_click_behaviour") != "undefined" ? getValue("image_click_behaviour") : 0;
		slideshowDelay = getValue("slideshow_delay") != "undefined" ? getValue("slideshow_delay") : 0;
		var flickrFeedURL = "http://www.flickr.com/services/feeds/photos_public.gne?tags="+tags+"&format=rss_200";
		//_IG_FetchXmlContent(flickrFeedURL,xmlResponseHandler);
		if (!NV_XML_REQUEST_URL )
		{
			NV_XML_REQUEST_URL = "http://www.netvibes.com/xmlProxy.php";
		}
		alert("Submitting request ");
		var request = new Ajax.Request(NV_XML_REQUEST_URL + '?url=' + escape(flickrFeedURL), { method: 'get', onSuccess: xmlResponseHandler});
	}

NV_ONLOAD = function()
{
    randomFlickrLoad();
	_uacct = "UA-941159-1";
	urchinTracker();
}
</script>
</head>

<body>
<table width="100%"><tr><td><div id="divRandomFlickrHeader"></div></td><td align="right" valign="top"><div id="divRandomFlickrControl"></div></td></tr>
<tr colspan="2"><td><div id="divRandomFlickrContent"><center><I>Loading...</I></center></div></td></tr>
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