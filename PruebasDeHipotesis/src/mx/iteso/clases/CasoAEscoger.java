package mx.iteso.clases;

public class CasoAEscoger {

    public static TipoPrueba determinarTipoPrueba(DatosEntrada datos) {
        int n = datos.getMuestra();
        boolean conoceDesviacion = datos.getConoceS();

        // Si σ es CONOCIDA, siempre usar Z
        if (conoceDesviacion) {
            return TipoPrueba.Z_CONOCIDA;
        }

        // Si σ es DESCONOCIDA
        if (n >= 30) {
            return TipoPrueba.Z_DESCONOCIDA; // Muestra grande
        } else {
            return TipoPrueba.T_STUDENT; // Muestra pequeña
        }

    }


    public static CalculoEstadistico obtenerEstadistico(TipoPrueba tipo) {
        // Dependiendo del tipo de prueba retorna la función a ejecutar
        switch (tipo) {
            case Z_CONOCIDA:
                return new CalculoZConocida();
            case Z_DESCONOCIDA:
                return new CalculoZDesconocida();
            case T_STUDENT:
                return new CalculoTStudent();
            default:
                return new CalculoZDesconocida();
        }
    }
}
