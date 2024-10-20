package com.example.cars.Config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import java.io.File;

@Configuration
public class WebConfig implements WebMvcConfigurer {

    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        // Map the /Car/** URL to the local directory where images are stored
        registry.addResourceHandler("/Car/**")
                .addResourceLocations("file:" + System.getProperty("user.dir") + File.separator + "Car" + File.separator);
    }
}