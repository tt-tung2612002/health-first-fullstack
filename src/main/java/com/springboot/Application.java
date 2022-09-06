package com.springboot;

// import com.vaadin.flow.component.page.AppShellConfigurator;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.web.servlet.error.ErrorMvcAutoConfiguration;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;

/**
 * The entry point of the Spring Boot application.
 * <p>
 * Use the @PWA annotation make the application installable on phones, tablets
 * and some desktop browsers.
 */
@SpringBootApplication(exclude = ErrorMvcAutoConfiguration.class)
// @PWA(name = "My Starter Project", shortName = "My Starter Project", iconPath
// = UIUtils.IMG_PATH + "logos/18.png", backgroundColor = "#233348", themeColor
// = "#233348")
public class Application extends SpringBootServletInitializer {
    // implements AppShellConfigurator

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }

}
