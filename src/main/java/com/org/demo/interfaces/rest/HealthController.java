package com.org.demo.interfaces.rest;

import com.org.demo.application.GetHealthUseCase;
import com.org.demo.interfaces.rest.dto.HealthResponse;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Controller REST de health check.
 * Traduce el resultado del caso de uso a un DTO HTTP.
 */
@RestController
@RequestMapping("/api/v1/health")
public class HealthController {

    private final GetHealthUseCase getHealthUseCase;

    public HealthController(GetHealthUseCase getHealthUseCase) {
        this.getHealthUseCase = getHealthUseCase;
    }

    @GetMapping
    public ResponseEntity<HealthResponse> health() {
        var status = getHealthUseCase.execute();
        return ResponseEntity.ok(new HealthResponse(status.status(), status.version()));
    }
}
