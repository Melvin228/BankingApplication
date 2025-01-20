package com.melvin.banking.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.thymeleaf.TemplateEngine;
import org.thymeleaf.templateresolver.FileTemplateResolver;

import java.io.IOException;

@Configuration
@Profile("local")
public class LocalTemplateConfig {

    public LocalTemplateConfig(final TemplateEngine templateEngine) throws IOException {
        final FileTemplateResolver fileTemplateResolver = new FileTemplateResolver();
        fileTemplateResolver.setPrefix("src/main/resources/templates/"); // Correct path
        fileTemplateResolver.setSuffix(".html"); // Add suffix for templates
        fileTemplateResolver.setTemplateMode("HTML");
        fileTemplateResolver.setCacheable(false); // Disable caching for local development
        templateEngine.setTemplateResolver(fileTemplateResolver);
    }

}
