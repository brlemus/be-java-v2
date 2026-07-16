package com.org.demo.application;

import com.org.demo.domain.model.HealthStatus;
import com.org.demo.domain.port.HealthRepository;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

/**
 * Test unitario del caso de uso GetHealthUseCase.
 * Patrón AAA (Arrange / Act / Assert).
 */
class GetHealthUseCaseTest {

    // ---------------------------------------------------------------
    // execute() — escenarios felices
    // ---------------------------------------------------------------

    @Test
    @DisplayName("execute() retorna el HealthStatus proporcionado por el repositorio")
    void execute_returnsStatusFromRepository() {
        // Arrange
        var expectedStatus = HealthStatus.up("2.0.0");
        HealthRepository repository = mock(HealthRepository.class);
        when(repository.currentStatus()).thenReturn(expectedStatus);

        var useCase = new GetHealthUseCase(repository);

        // Act
        var result = useCase.execute();

        // Assert
        assertAll(
                () -> assertEquals("UP", result.status()),
                () -> assertEquals("2.0.0", result.version())
        );
        verify(repository, times(1)).currentStatus();
    }

    // ---------------------------------------------------------------
    // Constructor — validaciones de invariantes
    // ---------------------------------------------------------------

    @Test
    @DisplayName("constructor lanza IllegalArgumentException cuando el repositorio es null")
    void constructor_throwsWhenRepositoryIsNull() {
        // Arrange / Act / Assert
        var ex = assertThrows(
                IllegalArgumentException.class,
                () -> new GetHealthUseCase(null)
        );
        assertEquals("healthRepository es requerido", ex.getMessage());
    }
}
