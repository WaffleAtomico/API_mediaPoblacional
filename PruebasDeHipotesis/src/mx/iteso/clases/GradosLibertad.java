package mx.iteso.clases;

public class GradosLibertad {

    // calculo de los grados de libertad (v)
    public static int calcular(int muestra) {
        return muestra - 1;
    }

    public static int calcular(DatosEntrada datos) {
        return datos.getMuestra() - 1;
    }
}