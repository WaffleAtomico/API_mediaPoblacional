package mx.iteso.clases;

public class DatosEntrada {

    public double mediaMuestral; // x̄
    public double mediaPoblacional; // μ₀
    public double desviacionEstandar; // σ o s
    public int muestra; // n
    public double significancia; // α
    public boolean conoceS;

    // getters and setters

    public double getMediaMuestral() {
        return mediaMuestral;
    }
    public void setMediaMuestral(double mediaMuestral) {
        this.mediaMuestral = mediaMuestral;
    }
    public double getMediaPoblacional() {
        return mediaPoblacional;
    }
    public void setMediaPoblacional(double mediaPoblacional) {
        this.mediaPoblacional = mediaPoblacional;
    }
    public double getDesviacionEstandar() {
        return desviacionEstandar;
    }
    public void setDesviacionEstandar(double desviacionEstandar) {
        this.desviacionEstandar = desviacionEstandar;
    }
    public int getMuestra() {
        return muestra;
    }
    public void setMuestra(int muestra) {
        this.muestra = muestra;
    }
    public double getSignificancia() {
        return significancia;
    }
    public void setSignificancia(double significancia) {
        this.significancia = significancia;
    }
    public boolean getConoceS() {
        return conoceS;
    }
    public void setConoceS(boolean conoceS) {
        this.conoceS = conoceS;
    }

}
