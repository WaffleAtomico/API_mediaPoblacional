package mx.iteso.clases;

public class CalculoZConocida implements CalculoEstadistico {

    @Override
    public double calcularEstadistico(DatosEntrada datos) {
        double x = datos.getMediaMuestral();
        double mu = datos.getMediaPoblacional();
        double sigma = datos.getDesviacionEstandar();
        int n = datos.getMuestra();

        double resultZC = (x - mu) / (sigma / Math.sqrt(n));

        return resultZC;
    }
}
