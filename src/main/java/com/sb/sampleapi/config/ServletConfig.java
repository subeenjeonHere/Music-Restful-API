package com.sb.sampleapi.config;

import jakarta.servlet.*;
import org.springframework.boot.web.servlet.ServletContextInitializer;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.filter.CharacterEncodingFilter;

import java.util.EnumSet;

@Configuration
public class ServletConfig implements ServletContextInitializer {

    @Override
    public void onStartup(ServletContext servletContext) throws ServletException {
        servletContext.setSessionTimeout(30);
        servletContext.setInitParameter("resource", "classpath:resources/application.yml");

        FilterRegistration.Dynamic characterEncodingFilter = servletContext.addFilter("characterEncodingFilter", CharacterEncodingFilter.class);

        characterEncodingFilter.setInitParameter("encoding", "UFT-8");
        characterEncodingFilter.setInitParameter("forceEncoding", "true");
        characterEncodingFilter.addMappingForUrlPatterns(
                EnumSet.of(DispatcherType.REQUEST, DispatcherType.FORWARD, DispatcherType.INCLUDE, DispatcherType.ASYNC), // 디스패치타입
                false, // false = 전 작동 , true = 후 작동
                "/*"
        );

        characterEncodingFilter.setAsyncSupported(true);

        servletContext.addListener(new ServletContextListener() {
            @Override
            public void contextInitialized(ServletContextEvent sce) {
                System.out.println("내장 톰캣 기동");
            }

            @Override
            public void contextDestroyed(ServletContextEvent sce) {
                System.out.println("내장 톰캣 종료");
            }
        });
    }

}
