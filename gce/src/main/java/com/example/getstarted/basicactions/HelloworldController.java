/*
 * Copyright 2019 Google LLC
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.example.getstarted.basicactions;

import java.io.IOException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import org.fluentd.logger.FluentLogger;
import javax.servlet.http.HttpServletResponse;
import java.util.*;
import java.io.*;

@WebServlet(value = "/loginServlet")
public class HelloworldController extends HttpServlet {

	  private static FluentLogger ERRORS = FluentLogger.getLogger("myapp");

  @Override
  public void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException {
   try {
      throw new Exception("Test Gayatri Generic exception for testing Stackdriver");
    } catch (Exception e) {
      report(e);
    }
	  resp.getWriter().write("Hello world - GCE!");
    resp.setStatus(HttpServletResponse.SC_OK);
  }

public static void report(Throwable ex) {
    StringWriter exceptionWriter = new StringWriter();
    ex.printStackTrace(new PrintWriter(exceptionWriter));
    Map<String, Object> data = new HashMap<>();
    data.put("message", exceptionWriter.toString());
    Map<String, String> serviceContextData = new HashMap<>();
    serviceContextData.put("service", "myapp");
    data.put("serviceContext", serviceContextData);
    // ... add more metadata
    ERRORS.log("errors", data);
  }
protected void doPost(HttpServletRequest request,
            HttpServletResponse response) throws IOException {
         
        // read form fields
        String username = request.getParameter("username");
        String password = request.getParameter("password");
         
        System.out.println("username: " + username);
        System.out.println("password: " + password);
 
        // do some processing here...
         
        // get response writer
        PrintWriter writer = response.getWriter();
         
        // build HTML code
        String htmlRespone = "<html>";
        htmlRespone += "<h2>Your username is: " + username + "<br/>";      
        htmlRespone += "Your password is: " + password + "</h2>";    
        htmlRespone += "</html>";
         
        // return response
        writer.println(htmlRespone);
         
    }
}
