package com.org.demo.interfaces.rest.dto;

/**
 * DTO de respuesta para el endpoint de health.
 * Record inmutable: solo existe en la capa de interfaces.
 */
public record HealthResponse(String status, String version) {}
