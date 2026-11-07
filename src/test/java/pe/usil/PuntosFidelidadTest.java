package pe.usil;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class PuntosFidelidadTest {

    @Test
    void rechazaMontoCeroONegativo() {
        assertThrows(IllegalArgumentException.class, () -> {
            PuntosFidelidad.calcular(0, Categoria.CLASICA);
        });
    }
}