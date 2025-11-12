package mx.iteso.clases;

public class DatosEntrada {

    public double mediaMuestral; //
    public double mediaPoblacional; //
    public double desviacionEstandar; //
    public int muestra; // n
    public double significancia; //
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
    public boolean isConoceS() {
        return conoceS;
    }
    public void setConoceS(boolean conoceS) {
        this.conoceS = conoceS;
    }




}
