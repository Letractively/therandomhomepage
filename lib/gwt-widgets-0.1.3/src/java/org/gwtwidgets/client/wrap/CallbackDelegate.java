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
 * In GWT 1.0.21 JSNI insists on knowing the precise implementing class of the method being invoked,
 * which does not allow for interfaces. Thus we provide an internal wrapper around the interface which
 * in turn provides the 'precise implementation class' to JSNI.
 * @author george georgovassilis
 *
 */
class CallbackDelegate implements Callback
{
    private Callback callback;



    public CallbackDelegate (Callback callback)
    {
        this.callback = callback;
    }

    public void execute ()
    {
        callback.execute();
    }
}
