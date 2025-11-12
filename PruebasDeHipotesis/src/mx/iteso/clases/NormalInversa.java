package mx.iteso.clases;

public class NormalInversa {

    /**
     * Calcula la inversa de la distribución normal estándar acumulativa (INV.NORM.ESTAND).
     * p La probabilidad (debe ser mayor que 0 y menor que 1).
     * devuelve el valor Z correspondiente.
     */
    public static double stdNormInv(double p) {
        if (p <= 0.0 || p >= 1.0) {
            throw new IllegalArgumentException("La probabilidad debe estar entre 0 y 1.");
        }

        // Constantes para la aproximación racional (Algoritmo de Peter Acklam)
        // Coeficientes para la región central
        double a[] = {
                -3.969683028665376e+01,
                2.209460984245205e+02,
                -2.759285104469687e+02,
                1.383577518672690e+02,
                -3.066479806614716e+01,
                2.506628277459239e+00
        };
        double b[] = {

                -5.447609846245063e+01,
                1.615858368580409e+02,
                -1.556989798598866e+02,
                6.680131188771972e+01,
                -1.328068155288572e+01
        };

        // Coeficientes para las colas
        double c[] = {
                -7.784894002430293e-03,
                -3.223964580411365e-01,
                -2.400758277161838e+00,
                -2.549732539343734e+00,
                4.374664141464968e+00,
                2.938163982698783e+00
        };
        double d[] = {
                7.784695709041462e-03,
                3.224671290700398e-01,
                2.445134137142996e+00,
                3.754408661907416e+00
        };

        double q, r;

        // Se utilizan diferentes aproximaciones dependiendo del rango de p
        if (p < 0.02425) {
            // Región de la cola izquierda
            q = Math.sqrt(-2.0 * Math.log(p));
            r = (((((c[0] * q + c[1]) * q + c[2]) * q + c[3]) * q + c[4]) * q + c[5]) /
                    ((((d[0] * q + d[1]) * q + d[2]) * q + d[3]) * q + 1.0);
            return r;
        } else if (p > 0.97575) {
            // Región de la cola derecha
            q = Math.sqrt(-2.0 * Math.log(1.0 - p));
            r = (((((c[0] * q + c[1]) * q + c[2]) * q + c[3]) * q + c[4]) * q + c[5]) /
                    ((((d[0] * q + d[1]) * q + d[2]) * q + d[3]) * q + 1.0);
            return -r;
        } else {
            // Región central
            q = p - 0.5;
            r = q * q;
            double numerator = (((((a[0] * r + a[1]) * r + a[2]) * r + a[3]) * r + a[4]) * r + a[5]) * q;
            double denominator = (((((b[0] * r + b[1]) * r + b[2]) * r + b[3]) * r + b[4]) * r + 1.0);
            return numerator / denominator;
        }
    }
}
