package mx.iteso.clases;

public class ZonaRechazo {

    public static String determinarZona(TipoHipotesis tipo, TipoPrueba prueba, double significancia, int muestra) {
        double valorCritico;

        switch (prueba) {
            // se evita el uso del return debido a el calculo del valor crítico y del metodo toString es el mismo
            // para las Z
            case Z_CONOCIDA:
            case Z_DESCONOCIDA:
                valorCritico = calcularValorCriticoZ(tipo, significancia);
                return construirTextoZonaZ(tipo, valorCritico);

            case T_STUDENT:
                int gl = GradosLibertad.calcular(muestra);
                valorCritico = calcularValorCriticoT(tipo, significancia, gl);
                return construirTextoZonaT(tipo, valorCritico);

            default:
                return "Tipo de prueba no reconocido";
        }
    }

    private static double calcularValorCriticoZ(TipoHipotesis tipo, double alpha) {
        switch (tipo) {
            case BILATERAL:
                return NormalInversa.stdNormInv(1 - alpha / 2);
            case UNILATERAL_DERECHA:
                return NormalInversa.stdNormInv(1 - alpha);
            case UNILATERAL_IZQUIERDA:
                return NormalInversa.stdNormInv(alpha);
            default:
                throw new IllegalArgumentException("Tipo de hipótesis no válido");
                // hay que eliminar este default
        }
    }

    private static double calcularValorCriticoT(TipoHipotesis tipo, double alpha, int gl) {
        switch (tipo) {
            case BILATERAL:
                return TInversa.tInv(1 - alpha / 2, gl);
            case UNILATERAL_DERECHA:
                return TInversa.tInv(1 - alpha, gl);
            case UNILATERAL_IZQUIERDA:
                return TInversa.tInv(alpha, gl);
            default:
                throw new IllegalArgumentException("Tipo de hipótesis no válido");
                // y este tambien
        }
    }


    // Hay que ver si se puede convertir en un método toSting estos dos métodos siguientes

    private static String construirTextoZonaZ(TipoHipotesis tipo, double zCritico) {
        switch (tipo) {
            case BILATERAL:
                return String.format("Z < %.8f ó Z > %.8f", -zCritico, zCritico);
            case UNILATERAL_DERECHA:
                return String.format("Z > %.8f", zCritico);
            case UNILATERAL_IZQUIERDA:
                return String.format("Z < %.8f", zCritico);
            default:
                return "";
        }
    }

    private static String construirTextoZonaT(TipoHipotesis tipo, double tCritico) {
        switch (tipo) {
            case BILATERAL:
                return String.format("t < %.8f ó t > %.8f", -tCritico, tCritico);
            case UNILATERAL_DERECHA:
                return String.format("t > %.8f", tCritico);
            case UNILATERAL_IZQUIERDA:
                return String.format("t < %.8f", tCritico);
            default:
                return "";
        }
    }
}