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

package org.gwtwidgets.server.rpc;

import com.google.gwt.user.server.rpc.RemoteServiceServlet;
import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.context.ServletContextAware;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;


/**
 * Implementation of a GWT-Spring controller that forwards a request made
 * to the doPost method.
 * 
 * @author George Georgovassilis
 * @deprecated Use org.gwtwidgets.server.spring.RemoteServiceServlet from the gwt-widgets-server distribution
 */
public abstract class GWTSpringController extends RemoteServiceServlet implements Controller, ServletContextAware
{
    private ServletContext context;



    public ModelAndView handleRequest (HttpServletRequest request, HttpServletResponse response)
            throws Exception
    {
        doPost(request, response);
        return null;
    }

    public void setServletContext (ServletContext context)
    {
        this.context = context;
    }

    public ServletContext getServletContext ()
    {
        return context;
    }
}
