package mx.iteso.clases;

import mx.iteso.excepciones.*;

public class ZonaRechazo {

    public static String determinarZona(TipoHipotesis tipo, TipoPrueba prueba,
            double significancia, int muestra)
            throws NegativeNumberFoundException, MoreThanOneValueFoundException {

        double valorCritico;

        // Para pruebas Z (conocida o desconocida)
        if (prueba == TipoPrueba.Z_CONOCIDA || prueba == TipoPrueba.Z_DESCONOCIDA) {
            valorCritico = calcularValorCriticoZ(tipo, significancia);
            return construirTextoZonaZ(tipo, valorCritico);
        }

        // Para prueba t-Student
        if (prueba == TipoPrueba.T_STUDENT) {
            int gl = GradosLibertad.calcular(muestra);
            valorCritico = calcularValorCriticoT(tipo, significancia, gl);
            return construirTextoZonaT(tipo, valorCritico);
        }

        return "Tipo de prueba no reconocido";
    }

    private static double calcularValorCriticoZ(TipoHipotesis tipo, double alpha)
            throws NegativeNumberFoundException, MoreThanOneValueFoundException {

        if (tipo == TipoHipotesis.BILATERAL) {
            return NormalInversa.stdNormInv(1 - alpha / 2);
        }
        if (tipo == TipoHipotesis.UNILATERAL_DERECHA) {
            return NormalInversa.stdNormInv(1 - alpha);
        }
        if (tipo == TipoHipotesis.UNILATERAL_IZQUIERDA) {
            return NormalInversa.stdNormInv(alpha);
        }
        return 0;
    }

    private static double calcularValorCriticoT(TipoHipotesis tipo, double alpha, int gl)
            throws NegativeNumberFoundException, MoreThanOneValueFoundException {

        if (tipo == TipoHipotesis.BILATERAL) {
            return TInversa.tInv(1 - alpha / 2, gl);
        }
        if (tipo == TipoHipotesis.UNILATERAL_DERECHA) {
            return TInversa.tInv(1 - alpha, gl);
        }
        if (tipo == TipoHipotesis.UNILATERAL_IZQUIERDA) {
            return TInversa.tInv(alpha, gl);
        }
        return 0;
    }

    private static String construirTextoZonaZ(TipoHipotesis tipo, double zCritico) {
        if (tipo == TipoHipotesis.BILATERAL) {
            return String.format("Z < %.4f ó Z > %.4f", -zCritico, zCritico);
        }
        if (tipo == TipoHipotesis.UNILATERAL_DERECHA) {
            return String.format("Z > %.4f", zCritico);
        }
        if (tipo == TipoHipotesis.UNILATERAL_IZQUIERDA) {
            return String.format("Z < %.4f", zCritico);
        }
        return "";
    }

    private static String construirTextoZonaT(TipoHipotesis tipo, double tCritico) {
        if (tipo == TipoHipotesis.BILATERAL) {
            return String.format("t < %.4f ó t > %.4f", -tCritico, tCritico);
        }
        if (tipo == TipoHipotesis.UNILATERAL_DERECHA) {
            return String.format("t > %.4f", tCritico);
        }
        if (tipo == TipoHipotesis.UNILATERAL_IZQUIERDA) {
            return String.format("t < %.4f", tCritico);
        }
        return "";
    }
}
