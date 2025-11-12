package mx.iteso.clases;

public class TInversa {

    /**
     * Calcula la inversa de la distribución t de Student (equivalente a INV.T de Excel)
     * p La probabilidad acumulada (0 < p < 1)
     * df Los grados de libertad (df > 0)
     * devuelve el valor t correspondiente
     */
    public static double tInv(double p, double df) {
        if (p <= 0.0 || p >= 1.0) {
            throw new IllegalArgumentException("La probabilidad debe estar entre 0 y 1");
        }
        if (df <= 0) {
            throw new IllegalArgumentException("Los grados de libertad deben ser mayores que 0");
        }

        // Determinar el signo basándose en qué cola estamos
        boolean lowerTail = p < 0.5;
        double prob = lowerTail ? p : (1.0 - p);

        // Aproximación de Hill (1970) - Simple y precisa
        double a = 1.0 / (df - 0.5);
        double b = 48.0 / (a * a);
        double c = ((20700.0 * a / b - 98.0) * a - 16.0) * a + 96.36;
        double d = ((94.5 / (b + c) - 3.0) / b + 1.0) * Math.sqrt(a * Math.PI * 0.5) * df;
        double x = d * prob;
        double y = Math.pow(x, 2.0 / df);

        if (y > 0.05 + a) {
            // Usar aproximación normal
            x = NormalInversa.stdNormInv(prob);
            y = x * x;
            if (df < 5) {
                c += 0.3 * (df - 4.5) * (x + 0.6);
            }
            c = (((0.05 * d * x - 5.0) * x - 7.0) * x - 2.0) * x + b + c;
            y = (((((0.4 * y + 6.3) * y + 36.0) * y + 94.5) / c - y - 3.0) / b + 1.0) * x;
            y = a * y * y;
            if (y > 0.002) {
                y = Math.exp(y) - 1.0;
            } else {
                y = 0.5 * y * y + y;
            }
        } else {
            y = ((1.0 / (((df + 6.0) / (df * y) - 0.089 * d - 0.822) * (df + 2.0) * 3.0) + 0.5 / (df + 4.0)) * y - 1.0) * (df + 1.0) / (df + 2.0) + 1.0 / y;
        }

        double result = Math.sqrt(df * y);

        // Aplicar el signo correcto
        return lowerTail ? -result : result;
    }
}