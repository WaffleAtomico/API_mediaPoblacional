package mx.iteso.test;

import mx.iteso.clases.*;
import mx.iteso.excepciones.*;

public class TestMain {

    public static void main(String[] args) throws NegativeNumberFoundException, MoreThanOneValueFoundException {
        System.out.println("====================================");
        System.out.println("API DE PRUEBA DE HIPÓTESIS");
        System.out.println("====================================\n");

        // Ejemplo 1: Prueba Z con σ conocida (n ≥ 30)

        System.out.println("EJEMPLO 1: Prueba Z con σ conocida");
        System.out.println("----------------------------------");

        // Crear datos de entrada
        DatosEntrada datos = new DatosEntrada();
        datos.setMediaMuestral(90.48); // x̄ = 90.48
        datos.setMediaPoblacional(90); // μ₀ = 90
        datos.setDesviacionEstandar(3); // σ = 3
        datos.setMuestra(12); // n = 12
        datos.setSignificancia(0.05); // α = 0.05
        datos.setConoceS(true); // σ conocida?

        TipoHipotesis tipoHipotesis = TipoHipotesis.UNILATERAL_DERECHA;

        // Ejecutar prueba
        ResultadoPrueba resultado = ValoresCriticos.ejecutarPrueba(datos, tipoHipotesis);

        // Mostrar resultado
        System.out.println(resultado);

        System.out.println("\n====================================\n");

        // Ejemplo 2: Prueba Z con σ desconocida (n ≥ 30) 8-32

        System.out.println("EJEMPLO 2: Prueba z con σ desconocida");
        System.out.println("----------------------------------");

        // Crear datos de entrada
        DatosEntrada datos2 = new DatosEntrada();
        datos2.setMediaMuestral(2259.916667); // x̄ = 2259.916667
        datos2.setMediaPoblacional(2250); // μ₀ = 2250
        datos2.setDesviacionEstandar(35.56928791); // s = 35.56928791
        datos2.setMuestra(12); // n = 12
        datos2.setSignificancia(0.05); // α = 0.05
        datos2.setConoceS(false); // σ conocida?

        TipoHipotesis tipoHipotesis2 = TipoHipotesis.BILATERAL; // ambas colas

        // Ejecutar prueba
        ResultadoPrueba resultado2 = new ResultadoPrueba();

        resultado2 = ValoresCriticos.ejecutarPrueba(datos2, tipoHipotesis2);

        // Mostrar resultado
        System.out.println(resultado2);

        System.out.println("\n====================================\n");

        // Ejemplo 3: Prueba T con σ desconocida (n ≥ 30) 8-34
        System.out.println("EJEMPLO 3: Prueba t con σ desconocida");
        System.out.println("----------------------------------");

        // Crear datos de entrada
        DatosEntrada datos3 = new DatosEntrada();
        datos3.setMediaMuestral(4.05); // x̄ = 4.05
        datos3.setMediaPoblacional(4.0); // μ₀ = 4.0
        datos3.setDesviacionEstandar(0.08); // s = 0.08
        datos3.setMuestra(25); // n = 25
        datos3.setSignificancia(0.05); // α = 0.05
        datos3.setConoceS(false); // σ conocida?

        TipoHipotesis tipoHipotesis3 = TipoHipotesis.UNILATERAL_DERECHA;

        // Ejecutar prueba
        ResultadoPrueba resultado3 = new ResultadoPrueba();

        resultado3 = ValoresCriticos.ejecutarPrueba(datos3, tipoHipotesis3);

        // Mostrar resultado
        System.out.println(resultado3);

        System.out.println("\n====================================\n");

        // Ejemplo 4: Significancia negativa
        System.out.println("EJEMPLO 4: Prueba con significancia inválida");
        System.out.println("----------------------------------");

        // Crear datos de entrada
        DatosEntrada datos4 = new DatosEntrada();
        datos4.setMediaMuestral(4.05); // x̄ = 4.05
        datos4.setMediaPoblacional(4.0); // μ₀ = 4.0
        datos4.setDesviacionEstandar(0.08); // s = 0.08
        datos4.setMuestra(25); // n = 25
        datos4.setSignificancia(1.5); // α = 1.5 no es válido
        datos4.setConoceS(false); // σ conocida?

        TipoHipotesis tipoHipotesis4 = TipoHipotesis.UNILATERAL_DERECHA;

        // Ejecutar prueba
        ResultadoPrueba resultado4 = new ResultadoPrueba();

        resultado3 = ValoresCriticos.ejecutarPrueba(datos4, tipoHipotesis4);

        // Mostrar resultado
        System.out.println(resultado4);

        System.out.println("\n====================================\n");

    }

}