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

package org.gwtwidgets.client.wrap;

/**
 * <p>
 * Effect options parametrise a scriptaculous effect, for available effects and options please
 * consult the <a href="http://wiki.script.aculo.us/scriptaculous/tags/effects">scriptaculous wiki</a>.
 * </p>
 * <p>
 * You can also register callbacks which observe an effect's progress, for an example see {@link Effect}.
 * </p>
 * 
 * @author rhanson
 * @author george georgovassilis
 *
 */
public class EffectOption
{
    private String name;
    private Object value;

    
    public EffectOption (String name, String value)
    {
        this.name = name;
        this.value = value;
    }

    public EffectOption (String name, double value)
    {
        this.name = name;
        this.value = Double.toString(value);
    }

    public EffectOption (String name, Callback callback)
        {
            this.name = name;
            this.value = callback;
        }

    
    public String getName ()
    {
        return name;
    }

    public Object getValue ()
    {
        return value;
    }

}

