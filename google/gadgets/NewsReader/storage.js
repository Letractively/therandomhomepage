/*


*/

var DEFAULT_CACHE_INTERVAL = 1000 * 60 * 15; //15 min 
var KEY_NAME_SEPARATOR = "||";

var CacheTime = function(key,time) {
   this.key = key;
   this.time = time;
}

function Storage (name,cacheInterval) {
    this.name = name;
    this.cacheInterval = !cacheInterval ? DEFAULT_CACHE_INTERVAL : cacheInterval;
    
    this.keyName = function (keyName) {
      return this.name + KEY_NAME_SEPARATOR + keyName;
    };
    
    this.putValue= function(key, value) {
       if (typeof localStorage != "undefined") {
         localStorage[this.keyName(key)] = value;
       }       
    };
    
    this.getValue = function(key, defaultValue) {
       if ((typeof localStorage != "undefined") && (localStorage[this.keyName(key)] != null)) {
         return localStorage[this.keyName(key)];
       }     
       if (typeof defaultValue != "undefined") {
         return defaultValue;
       }
       return ""; 
    };      
    
    this.putCache = function(key, value) {
      this.putValue(key,value);
    };
    
    this.getCache = function(key, defaultValue) { 
    };          
} 


   
   
  function getCacheTime(url) {
    if (localStorage["cacheTimes"] != null && localStorage["cacheTimes"] != "") {
      var cacheTimes = JSON.parse(localStorage["cacheTimes"]);
      console.log("getCacheTime() cacheTimes = "+cacheTimes);
      for(var i=0; i < cacheTimes.length; i++) {
        console.log("cacheTimes["+i+"].url = "+cacheTimes[i].url+", "+cacheTimes[i].time);
        if (cacheTimes[i].url == url) {
          return cacheTimes[i].time;
        }
      }
    }
    return null; 
  } 
 
  function setCacheTime(url) {
    var cacheTimes = new Array();
    if (localStorage["cacheTimes"] != null && localStorage["cacheTimes"] != "") {
      cacheTimes = JSON.parse(localStorage["cacheTimes"]);
    }
    var date = new Date();
    var timeSet = false;
    for(var i=0; i < cacheTimes.length; i++) {
      if (cacheTimes[i].url == url) {
        cacheTimes[i].time = date.getTime();
        timeSet = true;
        break;         
      }
    }    
    if (!timeSet) {
      cacheTimes.push(new CacheTime(url,date.getTime()));      
    }    
    localStorage["cacheTimes"] = JSON.stringify(cacheTimes);
  }
  
  function cacheValid(url) {    
    var cacheTime = getCacheTime(url);
    var date = new Date();
    console.log("Checking cache time for url - "+url+", cacheTime = "+cacheTime+", currentTime = "+date.getTime());
    return cacheTime != null && ((date.getTime() - cacheTime) < CACHE_INTERVAL);
  }
 
  function getPreference(prefName,defaultValue) {
    console.log("  getPreference - prefName = "+prefName+" defaultValue = "+defaultValue+"  localStorage = "+localStorage+" "+typeof localStorage[prefName]);
    if ((typeof localStorage != "undefined") && (localStorage[prefName] != null)) {
        console.log("returning - "+localStorage[prefName]);
        return localStorage[prefName];
    }
    
    if (typeof defaultValue != "undefined") {
      console.log("returning defaultValue - "+defaultValue);
      return defaultValue;
    }
    return "";
  } 
  
  function setPreference(prefName, prefValue) {
  }
  

