package mx.iteso.clases;

public class CasoAEscoger {

    public static TipoPrueba determinarTipoPrueba(DatosEntrada datos) {
        int n = datos.getMuestra();
        boolean conoceDesviacion = datos.getConoceS();

        if (n >= 30 && conoceDesviacion) {
            return TipoPrueba.Z_CONOCIDA;
        } else if(n >= 30 && !conoceDesviacion) {
            return TipoPrueba.Z_DESCONOCIDA;
        } else { // n < 30
            return TipoPrueba.T_STUDENT;
        }

    }


    public static CalculoEstadistico obtenerEstadistico(TipoPrueba tipo) {
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
