package pe.usil;

public class PuntosFidelidad {

    public static int calcular(double monto, Categoria categoria) {
        if (monto <= 0) {
            throw new IllegalArgumentException("El monto debe ser estrictamente mayor a 0.");
        }
        if (categoria == null) {
            throw new IllegalArgumentException("La categoría no puede ser nula.");
        }

        int puntosBase = (int) (monto / 10.0);
        if (categoria == Categoria.ORO) {
            puntosBase *= 2;
        }

        int bono = (monto >= 500.0) ? 50 : 0;

        return puntosBase + bono;
    }
}