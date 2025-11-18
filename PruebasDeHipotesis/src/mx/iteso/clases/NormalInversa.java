package mx.iteso.clases;

/**
 * Clase para calcular la Inversa de la Distribución Normal Estándar.
 */
public class NormalInversa {

    /**
     * Calcula la inversa de la distribución normal estándar acumulativa (INV.NORM.ESTAND).
     * p La probabilidad (debe ser mayor que 0 y menor que 1).
     * El valor Z correspondiente.
     */
    public static double stdNormInv(double p) {
        // 👆👆👆 Se necesita la declaración del método y su llave de apertura {

        // Validaciones (Buena práctica)
        if (p <= 0.0 || p >= 1.0) {
            return 0;
        }

        // Declaración de arreglos y variables DENTRO del método (o como constantes estáticas)
        double a[] = {-3.969683028665376e+01, 2.209460984245205e+02, -2.759285104469687e+02,
                1.383577518672690e+02, -3.066479806614716e+01, 2.506628277459239e+00};
        double b[] = {-5.447609846245063e+01, 1.615858368580409e+02, -1.556989798598866e+02,
                6.680131188771972e+01, -1.328068155288572e+01};
        double c[] = {-7.784894002430293e-03, -3.223964580411365e-01, -2.400758277161838e+00,
                -2.549732539343734e+00, 4.374664141464968e+00, 2.938163982698783e+00};
        double d[] = {7.784695709041462e-03, 3.224671290700398e-01, 2.445134137142996e+00,
                3.754408661907416e+00};

        double q, r;

        if (p < 0.02425) {
            q = Math.sqrt(-2.0 * Math.log(p));
            r = (((((c[0] * q + c[1]) * q + c[2]) * q + c[3]) * q + c[4]) * q + c[5]) /
                    ((((d[0] * q + d[1]) * q + d[2]) * q + d[3]) * q + 1.0);
            return r;
        } else if (p > 0.97575) {
            q = Math.sqrt(-2.0 * Math.log(1.0 - p));
            r = (((((c[0] * q + c[1]) * q + c[2]) * q + c[3]) * q + c[4]) * q + c[5]) /
                    ((((d[0] * q + d[1]) * q + d[2]) * q + d[3]) * q + 1.0);
            return -r;
        } else {
            q = p - 0.5;
            r = q * q;
            double num = (((((a[0] * r + a[1]) * r + a[2]) * r + a[3]) * r + a[4]) * r + a[5]) * q;
            double den = (((((b[0] * r + b[1]) * r + b[2]) * r + b[3]) * r + b[4]) * r + 1.0);
            return num / den;
        }
    } // 👆 Cierre del método calcularNormalInversa
}
