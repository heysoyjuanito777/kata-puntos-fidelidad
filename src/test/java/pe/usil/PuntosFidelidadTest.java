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

    @Test
    void compraMenorADiezSolesNoGeneraPuntos() {
        assertEquals(0, PuntosFidelidad.calcular(9.99, Categoria.CLASICA));
    }

    @Test
    void compraMinimaDiezSolesGeneraUnPunto() {
        assertEquals(1, PuntosFidelidad.calcular(10.00, Categoria.CLASICA));
    }

    @Test
    void casoControlClasicaSinBono() {
        assertEquals(12, PuntosFidelidad.calcular(125.50, Categoria.CLASICA));
    }

    @Test
    void categoriaOroDuplicaPuntosBase() {
        // Base: 100 / 10 = 10 puntos -> ORO: 10 * 2 = 20 puntos
        assertEquals(20, PuntosFidelidad.calcular(100.00, Categoria.ORO));
    }

    @Test
    void rechazaCategoriaNula() {
        assertThrows(IllegalArgumentException.class, () -> {
            PuntosFidelidad.calcular(100.00, null);
        });
    }
}