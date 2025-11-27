package mx.iteso.clases;

public class CalculoZDesconocida implements CalculoEstadistico {

    @Override
    public double calcularEstadistico(DatosEntrada datos) {
        double x = datos.getMediaMuestral();
        double mu = datos.getMediaPoblacional();
        double s = datos.getDesviacionEstandar();
        int n = datos.getMuestra();

        double resultZD = (x - mu) / (s / Math.sqrt(n));

        return resultZD;
    }
}