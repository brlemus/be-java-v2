package com.org.demo.domain.model;

/**
 * Value object que representa el estado de salud del sistema.
 * Inmutable por definición al ser un record.
 */
public record HealthStatus(String status, String version) {

    public HealthStatus {
        if (status == null || status.isBlank()) {
            throw new IllegalArgumentException("status no puede ser nulo ni vacío");
        }
        if (version == null || version.isBlank()) {
            throw new IllegalArgumentException("version no puede ser nula ni vacía");
        }
    }

    public static HealthStatus up(String version) {
        return new HealthStatus("UP", version);
    }
}
