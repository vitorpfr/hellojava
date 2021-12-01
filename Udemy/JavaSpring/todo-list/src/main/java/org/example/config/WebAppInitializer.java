package org.example.config;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.WebApplicationInitializer;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;
import org.springframework.web.servlet.DispatcherServlet;

import javax.servlet.ServletException;
import javax.servlet.ServletRegistration;

@Slf4j
public class WebAppInitializer implements WebApplicationInitializer {

    private static final String DISPATCH_SERVLET_NAME = "dispatcher";

    @Override
    public void onStartup(javax.servlet.ServletContext servletContext) throws ServletException {
        log.info("onStartup");

        // create the Spring application context (Spring container)
        // note: the servlet context is different from the Spring application context - they will be associated down further
        AnnotationConfigWebApplicationContext context = new AnnotationConfigWebApplicationContext();
        context.register(WebConfig.class); // for this to work, this class needs to have @Configuration annotation

        // create the dispatcher servlet
        DispatcherServlet dispatcherServlet = new DispatcherServlet(context);

        // register and configure the dispatcher servlet
        ServletRegistration.Dynamic registration = servletContext.addServlet(DISPATCH_SERVLET_NAME, dispatcherServlet);
        registration.setLoadOnStartup(1);
        registration.addMapping("/");

        // the dispatcher servlet is the Controller (C) of the MVC application
        // it maps requests to methods, in classes annotated with @Controller


    }
}
