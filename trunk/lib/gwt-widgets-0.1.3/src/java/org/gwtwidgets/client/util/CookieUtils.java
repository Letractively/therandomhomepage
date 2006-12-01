/*
 * Copyright 2006 Robert Hanson <iamroberthanson AT gmail.com>
 * 
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 * 
 *    http://www.apache.org/licenses/LICENSE-2.0
 * 
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.gwtwidgets.client.util;

import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/**
 * Class that is responsible for reading and writing cookies.
 * 
 * @author Brian Glick
 * @author rhanson
 */
public class CookieUtils {

    /**
     * Creates, sets, and returns the Cookie object
     * @param name
     * @param value
     * @param expires
     * @param path
     * @return the Cookie created or reset
     */
    public static Cookie write (String name, String value, Date expires, String path)
    {
        boolean useExp = false;
        int year = -1, month = -1, day = -1;
        if (expires != null) {
            useExp = true;
            year = expires.getYear() + 1900;
            month = expires.getMonth();
            day = expires.getDate();
        }
        writeNative(name, value, useExp, year, month, day, path);
        return new Cookie(name, value);
    }

    public static Cookie write (String name, String value, Date expires)
    {
        return write(name, value, expires, "/");
    }

    
    private static void writeNative(String name, String value, boolean useExpires, int year, int month, int day)
    {
        writeNative(name, value, useExpires, year, month, day, "/");
    }

    private static native void writeNative(String name, String value, boolean useExpires, int year, int month, int day, String path) /*-{
        var expStr = (useExpires) ? "; expires=" + new Date(year, month, day).toGMTString() : "";
        $doc.cookie = name + "=" + escape(value) + expStr + "; path=" + path;
    }-*/;
    
    /**
     * Erases cookie with given name.
     * @param name
     */
    public static void erase (String name)
    {
        writeNative(name, "", true, 1970, 1, 1);
    }

    /**
     * Gets the value of the cookie with the given name.
     * @param name Name of cookie whose value should be retrieved
     * @return Cookie value or null if cookie is not found
     */
    public static String readValue (String name)
    {
        Cookie c = read(name);
        return c == null ? null : c.getValue();
    }
    
    /**
     * Gets the cookie with the given name.
     * @param name Name of cookie to get.
     * @return Cookie or null if the cookie is not found.
     */
    public static Cookie read (String name)
    {
        String val = getValue(name);
        return (val == null) ? null : new Cookie(name, val);
    }

    /**
     * Tries to load the cookie, but only sets fields if they are found
     * @param name
     * @param c
     */
    private static native String getValue (String name) /*-{
   	    var start = $doc.cookie.indexOf(name + '=');
        var len = start + name.length + 1;
        if ((!start) && (name != $doc.cookie.substring(0,name.length))) {
            return null;
        }
        if (start == -1) {
            return null;
        }
        var end = document.cookie.indexOf(';',len);
        if (end == -1) {
            end = $doc.cookie.length;
        }
        return unescape($doc.cookie.substring(len,end));
    }-*/;
    
    /**
     * Erase the given cookie
     * @param c
     */
    public static void erase (Cookie c)
    {
        erase(c.getName());
    }
    
    /**
     * Write the given cookie
     * @param c
     */
    public static void write (Cookie c, Date expires)
    {
        write(c.getName(), c.getValue(), expires);
    }

    public static Cookie[] getAll ()
    {
        Map cookies = getCookieMap();
        Cookie[] rVal = new Cookie[cookies.size()];
        int counter = 0;
        for (Iterator i = cookies.keySet().iterator(); i.hasNext(); counter++) {
            String name = (String) i.next();
            rVal[counter] = new Cookie(name, (String) cookies.get(name));
        }
        return rVal;
    }

    private static Map getCookieMap ()
    {
        Map jar = new HashMap();
        fillCookieJar(jar);
        return jar;
    }
    
    private static native void fillCookieJar (Map jar) /*-{
        var cookies = $doc.cookie;
        if (cookies && cookies != '') {
            var cl = cookies.split('; ');
            for (var i = 0; i < cl.length; ++i) {
                var parts = cl[i].split('=');
                jar.@java.util.Map::put(Ljava/lang/Object;Ljava/lang/Object;)(parts[0], unescape(parts[1]));
            }
        }
    }-*/;

}
