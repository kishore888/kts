package com.hospitality.config;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRegistration;

import org.springframework.web.WebApplicationInitializer;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;
import org.springframework.web.servlet.DispatcherServlet;

public class WebServletConfiguration implements WebApplicationInitializer{

    public void onStartup(ServletContext context) throws ServletException {

        AnnotationConfigWebApplicationContext webcontext = new AnnotationConfigWebApplicationContext();

        webcontext.register(SpringConfig.class);

        webcontext.setServletContext(context);

        ServletRegistration.Dynamic servlet = context.addServlet("dispatcher", new DispatcherServlet(webcontext));

        servlet.setLoadOnStartup(1);

        servlet.addMapping("/");
        
//        session creation
//        super.onStartup(context);
        context.addListener(new SessionListener());

    }

}
