<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Strict//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-strict.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<title>Random Wikipedia Article</title>
<link rel="icon" type="image/png" href="http://en.wikipedia.org/favicon.ico"/>
<meta name="author" content="Siddique Hameed"/>
<!--
	Last Updated: 11/28/2006
	Version 0.2
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
        vertical-align: top;
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
arrFooterLimit["fr"] = 'R�cup�r�e de � <a href="';
arrFooterLimit["ja"] = ' "<a href="';
arrFooterLimit["it"] = 'Estratto da "<a href="';
arrFooterLimit["sv"] = 'Den h�r artikeln �r h�mtad fr�n <a href="';
arrFooterLimit["es"] = 'Obtenido de "<a href="';
arrFooterLimit["pt"] = 'Retirado de "<a href="';
arrFooterLimit["pl"] = '?r�d?o: "<a href="';
arrFooterLimit["de"] = 'Von �<a href="';

var randomWikipediaURL = "http://en.wikipedia.org/wiki/Special:Random";

NV_ONLOAD = function()
{
	initLanguage();
	resize();
    getRandomArticleFromWikipedia();
    setTitle();
	_uacct = "UA-941159-1";
	urchinTracker();
}

function initLanguage() {
	if (isEmpty(getValue("language")))
	{
		//default language
		saveValue("language","en");
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
    var d = new Date();
    url += "&rnd=" + d.getTime();

    if (!NV_XML_REQUEST_URL) {
        var NV_XML_REQUEST_URL = 'http://www.netvibes.com/ajaxProxy.php';
    }

    var requestParams = { method: 'get', onSuccess: ShowWikipediaArticle, onFailure: ShowFailure };
    var request = new Ajax.Request(NV_XML_REQUEST_URL + '?url=' + escape(url), requestParams);

    setHTML("divRandomWikipediaTitle", "&nbsp;");
	setHTML("divWikipediaContent", "<p style='text-align:center;display:block;width:350px'>Loading article from Wikipedia...</p>");
	var arrow = document.getElementsByClassName("divArrow", NV_CONTENT)[0];
    if (arrow)
    {
        Element.toggle(arrow);
    }
}

function resize(){
	var moduleWidth = getValue("width");
	if (!isEmpty(moduleWidth))
	{
		var moduleElements = document.getElementsByClassName("module",document);
		if (moduleElements)
		{
			for(var i=0; i < moduleElements.length; i++){
				var divWikipediaContent = document.getElementsByClassName("divWikipediaContent",moduleElements[i])[0];
				if (divWikipediaContent)
				{
					Element.setStyle(moduleElements[i],{width: moduleWidth+"px"});
					break;
				}
			}
		}
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
		var respText = "";
		var tooltipText = "";

        var retrievedFrmIdx = xhr.responseText.indexOf(arrFooterLimit[getValue("language")]);
        if (retrievedFrmIdx > -1)
        {

            var wikipediaBaseURL = randomWikipediaURL.substring(0, randomWikipediaURL.lastIndexOf("/"));

            var articleURLStartIdx = xhr.responseText.indexOf(wikipediaBaseURL, retrievedFrmIdx);

            var articleURLEndIdx = xhr.responseText.indexOf('</a>', articleURLStartIdx);


            var articleURL = xhr.responseText.substring(articleURLStartIdx, articleURLEndIdx);

            var articleTitle = grep(xhr.responseText, '<h1 class="firstHeading">', '</h1>');

            setHTML("divRandomWikipediaTitle", "<h3><a target='_new' href='" + articleURL + "'>" + articleTitle + "</a></h3>");

            respText = xhr.responseText.substring(0, retrievedFrmIdx);
            var paraIdx = respText.indexOf("<p>");

            if (paraIdx > -1)
            {
                respText = respText.substring(paraIdx);
            }

            responseDocument.innerHTML = respText;
        }
		else {
			responseDocument.innerHTML = "There was some error reading content from Wikipedia !.<br/> Please try again later...";
		}

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

        setHTML("divWikipediaContent", responseDocument.innerHTML);

        var arrow = document.getElementsByClassName("divArrow", NV_CONTENT)[0];
        if (arrow)
        {
            Element.toggle(arrow);
            arrow.onclick = function() {
                getRandomArticleFromWikipedia();
            }
        }

		var tdArrow = document.getElementsByClassName('tdArrow',NV_CONTENT)[0];
	    tdArrow.onmouseover = function()
	    {
			setToolTip(this, "Click on the arrows (&gt;&gt;) for next random article.");
		}


		var divTitle = document.getElementsByClassName('divRandomWikipediaTitle',NV_CONTENT)[0];
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
    var element = document.getElementsByClassName(className, NV_CONTENT)[0];
    if (element)
    {
        element.innerHTML = str;
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
<form class="configuration" method="post" action="">
    <table border="0">
        <tr>
            <td><label>Title:</label></td>
            <td><input name="title" type="text" value="Random Wikipedia Article" size="40"/></td>
        </tr>
        <tr>
            <td><label>Height:</label></td>
            <td><input name="height" type="text" size="4" value="400"/></td>
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
                    <option value="es" lang="es" xml:lang="es">Espa�ol</option>
                    <option value="fr" lang="fr" xml:lang="fr">Fran�ais</option>
                    <option value="it" lang="it" xml:lang="it">Italiano</option>
                    <option value="ja" lang="ja" xml:lang="ja">???</option>
                    <option value="pl" lang="pl" xml:lang="pl">Polski</option>
                    <option value="pt" lang="pt" xml:lang="pt">Portugu�s</option>
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