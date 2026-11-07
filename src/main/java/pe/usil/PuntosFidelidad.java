package pe.usil;

public class PuntosFidelidad {

    private static final double MONTO_POR_PUNTO = 10.0;
    private static final double UMBRAL_BONO = 500.0;
    private static final int PUNTOS_BONO = 50;
    private static final int MULTIPLICADOR_ORO = 2;

    public static int calcular(double monto, Categoria categoria) {
        validarParametros(monto, categoria);

        int puntosBase = calcularPuntosBase(monto, categoria);
        int bono = calcularBono(monto);

        return puntosBase + bono;
    }

    private static void validarParametros(double monto, Categoria categoria) {
        if (monto <= 0) {
            throw new IllegalArgumentException("El monto debe ser estrictamente mayor a 0.");
        }
        if (categoria == null) {
            throw new IllegalArgumentException("La categoría no puede ser nula.");
        }
    }

    private static int calcularPuntosBase(double monto, Categoria categoria) {
        int base = (int) (monto / MONTO_POR_PUNTO);
        return (categoria == Categoria.ORO) ? base * MULTIPLICADOR_ORO : base;
    }

    private static int calcularBono(double monto) {
        return (monto >= UMBRAL_BONO) ? PUNTOS_BONO : 0;
    }
}