package com.org.demo.infrastructure.config;

import com.org.demo.application.GetHealthUseCase;
import com.org.demo.domain.port.HealthRepository;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * Configuración de Spring que conecta puertos con casos de uso.
 * Mantiene a los casos de uso libres de anotaciones de framework.
 */
@Configuration
public class UseCaseConfig {

    @Bean
    public GetHealthUseCase getHealthUseCase(HealthRepository healthRepository) {
        return new GetHealthUseCase(healthRepository);
    }
}
