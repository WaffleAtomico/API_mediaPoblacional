package mx.iteso.clases;

public class ZonaRechazo {

    // Este método nos ayuda a saber que método construirTextoZona llama
    public static String determinarZona(TipoHipotesis tipo, TipoPrueba prueba,
                                        double significancia, int muestra) {
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

    // Este método llama a la clase NormalInversa con el parámetro correspondiente para el calculo
    private static double calcularValorCriticoZ(TipoHipotesis tipo, double alpha) {
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

    // Este método llama a la clase TInversa con el parámetro correspondiente para el calculo
    private static double calcularValorCriticoT(TipoHipotesis tipo, double alpha, int gl) {
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

    // los siguientes métodos devuelven un string con la zona de rechazo
    private static String construirTextoZonaZ(TipoHipotesis tipo, double zCritico) {
        if (tipo == TipoHipotesis.BILATERAL) {
            return String.format("Z < %.8f ó Z > %.8f", -zCritico, zCritico);
        }
        if (tipo == TipoHipotesis.UNILATERAL_DERECHA) {
            return String.format("Z > %.8f", zCritico);
        }
        if (tipo == TipoHipotesis.UNILATERAL_IZQUIERDA) {
            return String.format("Z < %.8f", zCritico);
        }
        return "";
    }

    private static String construirTextoZonaT(TipoHipotesis tipo, double tCritico) {
        if (tipo == TipoHipotesis.BILATERAL) {
            return String.format("t < %.8f ó t > %.8f", -tCritico, tCritico);
        }
        if (tipo == TipoHipotesis.UNILATERAL_DERECHA) {
            return String.format("t > %.8f", tCritico);
        }
        if (tipo == TipoHipotesis.UNILATERAL_IZQUIERDA) {
            return String.format("t < %.8f", tCritico);
        }
        return "";
    }
}