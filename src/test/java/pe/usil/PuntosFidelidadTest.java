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


    @Test
    void montoJustoAntesDelBonoNoSumaCincuentaPuntos() {
        // Base: 499.99 / 10 = 49 puntos (sin bono)
        assertEquals(49, PuntosFidelidad.calcular(499.99, Categoria.CLASICA));
    }

    @Test
    void casoControlOroConBono() {
        // Base: 50 * 2 = 100 puntos. Bono: +50 = 150 puntos (el bono NO se duplica)
        assertEquals(150, PuntosFidelidad.calcular(500.00, Categoria.ORO));
    }

    @Test
    void montoMayorConBonoEnClasica() {
        // Base: 60 puntos. Bono: +50 = 110 puntos
        assertEquals(110, PuntosFidelidad.calcular(600.00, Categoria.CLASICA));
    }

}