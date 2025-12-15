package com.inventory.enterprise.inventory_manager_api.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class CorsConfig {

    @Bean
    public WebMvcConfigurer corsConfigurer() {
        return new WebMvcConfigurer() {
            @Override
            public void addCorsMappings(CorsRegistry registry) {
                registry.addMapping("/**") // Aplica a todas las URLs de tu API
                        .allowedOrigins("http://localhost:4200") // SOLO permite a tu Angular (puerto 4200)
                        .allowedMethods("GET", "POST", "PUT", "DELETE", "OPTIONS") // Qué acciones permites
                        .allowedHeaders("*") // Permite todas las cabeceras (necesario para JWT/Auth)
                        .allowCredentials(true); // Necesario si usas cookies o info de sesión
            }
        };
    }
}