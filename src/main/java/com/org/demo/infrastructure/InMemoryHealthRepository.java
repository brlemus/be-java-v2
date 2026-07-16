package com.org.demo.infrastructure;

import com.org.demo.domain.model.HealthStatus;
import com.org.demo.domain.port.HealthRepository;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Repository;

/**
 * Adaptador de infraestructura que implementa el puerto {@link HealthRepository}.
 * Esta es la única capa que puede depender de Spring y de detalles técnicos.
 */
@Repository
public class InMemoryHealthRepository implements HealthRepository {

    private final String appVersion;

    public InMemoryHealthRepository(
            @Value("${app.version:1.0.0}") String appVersion) {
        this.appVersion = appVersion;
    }

    @Override
    public HealthStatus currentStatus() {
        return HealthStatus.up(appVersion);
    }
}
