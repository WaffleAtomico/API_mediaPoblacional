package mx.iteso.clases;

public class CalculoTStudent implements CalculoEstadistico {

    @Override
    public double calcularEstadistico(DatosEntrada datos) {
        double x = datos.getMediaMuestral();
        double mu = datos.getMediaPoblacional();
        double s = datos.getDesviacionEstandar();
        int n = datos.getMuestra();

        double resultT = (x - mu) / (s / Math.sqrt(n));

        return resultT;
    }
}
