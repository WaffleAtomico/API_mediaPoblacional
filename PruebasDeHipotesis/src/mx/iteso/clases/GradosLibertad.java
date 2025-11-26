package mx.iteso.clases;

public interface GradosLibertad {

    public static int calcular(int muestra) {
        return muestra - 1;
    }

    public static int calcular(DatosEntrada datos) {
        return datos.getMuestra() - 1;
    }
}