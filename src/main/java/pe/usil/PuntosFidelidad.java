package pe.usil;

public class PuntosFidelidad {

    public static int calcular(double monto, Categoria categoria) {
        if (monto <= 0) {
            throw new IllegalArgumentException("El monto debe ser estrictamente mayor a 0.");
        }
        return (int) (monto / 10.0);
    }
}