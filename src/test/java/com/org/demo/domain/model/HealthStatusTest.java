package com.org.demo.domain.model;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.NullAndEmptySource;
import org.junit.jupiter.params.provider.ValueSource;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Test unitario del value object HealthStatus.
 * Patrón AAA (Arrange / Act / Assert).
 */
class HealthStatusTest {

    @Test
    @DisplayName("factory up() crea un HealthStatus con status=UP")
    void up_createsStatusWithUpAndVersion() {
        // Arrange
        var version = "1.0.0";

        // Act
        var status = HealthStatus.up(version);

        // Assert
        assertAll(
                () -> assertEquals("UP", status.status()),
                () -> assertEquals(version, status.version())
        );
    }

    @ParameterizedTest
    @NullAndEmptySource
    @ValueSource(strings = {" ", "\t"})
    @DisplayName("constructor lanza excepción cuando status es nulo o vacío")
    void constructor_throwsWhenStatusIsBlank(String invalidStatus) {
        // Arrange / Act / Assert
        assertThrows(
                IllegalArgumentException.class,
                () -> new HealthStatus(invalidStatus, "1.0.0")
        );
    }

    @ParameterizedTest
    @NullAndEmptySource
    @ValueSource(strings = {" ", "\t"})
    @DisplayName("constructor lanza excepción cuando version es nula o vacía")
    void constructor_throwsWhenVersionIsBlank(String invalidVersion) {
        // Arrange / Act / Assert
        assertThrows(
                IllegalArgumentException.class,
                () -> new HealthStatus("UP", invalidVersion)
        );
    }
}
