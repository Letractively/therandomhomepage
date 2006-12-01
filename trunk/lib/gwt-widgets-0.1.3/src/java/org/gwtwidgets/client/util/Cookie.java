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


/**
 * Immutable object representing a single browser cookie. 
 * 
 * @author Brian Glick
 */
public class Cookie
{
    private String name;
    private String value;



    Cookie (String name, String value)
    {
        super();
        this.name = name;
        this.value = value;
    }

    /**
     * Gets the name of the cookie
     * @return
     */
    public String getName ()
    {
        return name;
    }

    /**
     * Get's the cookie's value
     * @return
     */
    public String getValue ()
    {
        return value;
    }

    public void write (Date expires)
    {
        CookieUtils.write(this, expires);
    }
}
