package com.org.demo.domain.port;

import com.org.demo.domain.model.HealthStatus;

/**
 * Puerto (interfaz) que abstrae la obtención del estado del sistema.
 * El dominio define el contrato; la infraestructura lo implementa.
 */
public interface HealthRepository {

    HealthStatus currentStatus();
}
