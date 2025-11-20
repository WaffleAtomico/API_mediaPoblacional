package mx.iteso.test;

import mx.iteso.clases.*;

public class MainTest {

    public static void main(String[] args) {
        System.out.println("====================================");
        System.out.println("API DE PRUEBA DE HIPÓTESIS");
        System.out.println("====================================\n");

        // Ejemplo 1: Prueba Z con σ conocida (n ≥ 30)

        System.out.println("EJEMPLO 1: Prueba Z con σ conocida");
        System.out.println("----------------------------------");

        // Crear datos de entrada
        DatosEntrada datos = new DatosEntrada();
        datos.setMediaMuestral(3250);      // x̄ = 90.48
        datos.setMediaPoblacional(3500);   // μ₀ = 90
        datos.setDesviacionEstandar(31.6227766);  // σ = 3
        datos.setMuestra(12);                // n = 12
        datos.setSignificancia(0.01);        // α = 0.05
        datos.setConoceS(true);              // σ conocida?

        TipoHipotesis tipoHipotesis = TipoHipotesis.BILATERAL;

        // Ejecutar prueba
        ResultadoPrueba resultado = ValoresCriticos.ejecutarPrueba(datos, tipoHipotesis);

        // Mostrar resultado
        System.out.println(resultado);

        System.out.println("\n====================================\n");

        // Ejemplo 1: Prueba Z con σ conocida (n ≥ 30)

        System.out.println("EJEMPLO 2: Prueba t con σ desconocida");
        System.out.println("----------------------------------");

        // Crear datos de entrada
        DatosEntrada datos2 = new DatosEntrada();
        datos2.setMediaMuestral(2259.916667);      // x̄ = 2259.916667
        datos2.setMediaPoblacional(2250);   // μ₀ = 2250
        datos2.setDesviacionEstandar(35.56928791);  // σ = 35.56928791
        datos2.setMuestra(12);                // n = 12
        datos2.setSignificancia(0.05);        // α = 0.05
        datos2.setConoceS(false);              // σ conocida?

        TipoHipotesis tipoHipotesis2 = TipoHipotesis.BILATERAL;

        // Ejecutar prueba
        ResultadoPrueba resultado2 = new ResultadoPrueba();

        resultado2 = ValoresCriticos.ejecutarPrueba(datos2, tipoHipotesis2);

        // Mostrar resultado
        System.out.println(resultado2);

        System.out.println("\n====================================\n");


    }


}