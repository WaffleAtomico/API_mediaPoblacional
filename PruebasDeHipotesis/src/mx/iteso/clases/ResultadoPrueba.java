package mx.iteso.clases;

public class ResultadoPrueba {
    private double estadistico;
    private double valorCriticoInferior;
    private double valorCriticoSuperior;
    private String zonaRechazo;
    private boolean rechazarH0;
    private TipoPrueba tipoPrueba;
    private TipoHipotesis tipoHipotesis;
    private int gradosLibertad = -1;

    // getters and setters

    public double getEstadistico() {
        return estadistico;
    }

    public void setEstadistico(double estadistico) {
        this.estadistico = estadistico;
    }

    public double getValorCriticoInferior() {
        return valorCriticoInferior;
    }

    public void setValorCriticoInferior(double valorCriticoInferior) {
        this.valorCriticoInferior = valorCriticoInferior;
    }

    public double getValorCriticoSuperior() {
        return valorCriticoSuperior;
    }

    public void setValorCriticoSuperior(double valorCriticoSuperior) {
        this.valorCriticoSuperior = valorCriticoSuperior;
    }

    public String getZonaRechazo() {
        return zonaRechazo;
    }

    public void setZonaRechazo(String zonaRechazo) {
        this.zonaRechazo = zonaRechazo;
    }

    public boolean getRechazarH0() {
        return rechazarH0;
    }

    public void setRechazarH0(boolean rechazarH0) {
        this.rechazarH0 = rechazarH0;
    }

    public TipoPrueba getTipoPrueba() {
        return tipoPrueba;
    }

    public void setTipoPrueba(TipoPrueba tipoPrueba) {
        this.tipoPrueba = tipoPrueba;
    }

    public TipoHipotesis getTipoHipotesis() {
        return tipoHipotesis;
    }

    public void setTipoHipotesis(TipoHipotesis tipoHipotesis) {
        this.tipoHipotesis = tipoHipotesis;
    }

    public int getGradosLibertad() {
        return gradosLibertad;
    }

    public void setGradosLibertad(int gradosLibertad) {
        this.gradosLibertad = gradosLibertad;
    }

    // Hay que escribir de otra forma este método toString

    @Override
    public String toString() {



        String msj = "=== RESULTADO DE LA PRUEBA DE HIPÓTESIS ===\n" +
                "Tipo de prueba: " + tipoPrueba + "\n" +
                "Tipo de Hipótesis: " + tipoHipotesis + "\n" +
                "";

        if (gradosLibertad > 0) {
            msj += "Grados de Libertad: " + gradosLibertad + "\n";
        }

        msj += "Estadístico Calculado: " + estadistico + "\n" +
                "Zona de Rechazo: " + zonaRechazo + "\n"+
                "Decisión: " + (rechazarH0 ? "RECHAZAR H₀" : "NO RECHAZAR H₀") + "\n";

        return msj;
    }
}