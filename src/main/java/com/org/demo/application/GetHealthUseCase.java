package com.org.demo.application;

import com.org.demo.domain.model.HealthStatus;
import com.org.demo.domain.port.HealthRepository;

/**
 * Caso de uso: obtener el estado actual del servicio.
 * Orquesta únicamente a través del puerto; no conoce la implementación concreta.
 */
public class GetHealthUseCase {

    private final HealthRepository healthRepository;

    /** Inyección por constructor (sin anotaciones de framework en esta capa). */
    public GetHealthUseCase(HealthRepository healthRepository) {
        if (healthRepository == null) {
            throw new IllegalArgumentException("healthRepository es requerido");
        }
        this.healthRepository = healthRepository;
    }

    public HealthStatus execute() {
        return healthRepository.currentStatus();
    }
}
