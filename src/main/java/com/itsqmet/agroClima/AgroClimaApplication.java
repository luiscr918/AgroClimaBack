package com.itsqmet.agroClima;

import io.github.cdimascio.dotenv.Dotenv;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class AgroClimaApplication {

    public static void main(String[] args) {
        // Cargar el .env desde la raíz del proyecto
        Dotenv dotenv = Dotenv.configure()
                .ignoreIfMissing() // evita error si no existe el .env
                .load();

        // Configurar las propiedades de Spring Boot desde el .env
        setPropertyIfPresent("spring.application.name", dotenv.get("SPRING_APPLICATION_NAME"));
        setPropertyIfPresent("spring.datasource.url", dotenv.get("SPRING_DATASOURCE_URL"));
        setPropertyIfPresent("spring.datasource.username", dotenv.get("SPRING_DATASOURCE_USERNAME"));
        setPropertyIfPresent("spring.datasource.password", dotenv.get("SPRING_DATASOURCE_PASSWORD"));

        setPropertyIfPresent("spring.jpa.hibernate.ddl-auto", dotenv.get("SPRING_JPA_HIBERNATE_DDL_AUTO"));
        setPropertyIfPresent("spring.jpa.database-platform", dotenv.get("SPRING_JPA_DATABASE_PLATFORM"));

        setPropertyIfPresent("jwt.secret", dotenv.get("JWT_SECRET"));
        setPropertyIfPresent("jwt.expiration-ms", dotenv.get("JWT_EXPIRATION_MS"));
        // Agregar FRONTEND_URL para que Spring pueda inyectarlo
        setPropertyIfPresent("FRONTEND_URL", dotenv.get("FRONTEND_URL"));
        // Iniciar la aplicación
        SpringApplication.run(AgroClimaApplication.class, args);
    }

    // Helper para setear propiedades solo si existen en .env
    private static void setPropertyIfPresent(String key, String value) {
        if (value != null && !value.isEmpty()) {
            System.setProperty(key, value);
        }
    }
}
