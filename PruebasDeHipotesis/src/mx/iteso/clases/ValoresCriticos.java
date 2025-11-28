package mx.iteso.clases;

import mx.iteso.excepciones.*;

public class ValoresCriticos implements NormalInversa, CasoAEscoger, GradosLibertad {

    public static ResultadoPrueba ejecutarPrueba(DatosEntrada datos, TipoHipotesis tipoHipotesis)
            throws NegativeNumberFoundException, MoreThanOneValueFoundException {

        double significancia = datos.getSignificancia();
        int n = datos.getMuestra();

        if (significancia >= 1.0) {
            throw new MoreThanOneValueFoundException(significancia);
        } else if (significancia <= 0.0) {
            throw new NegativeNumberFoundException(significancia);
        }

        if (n <= 0.0) {
            throw new NegativeNumberFoundException(n);
        }

        // Paso 1: Decidir qué tipo de prueba usar (Z o t)
        TipoPrueba tipoPrueba = CasoAEscoger.determinarTipoPrueba(datos);

        // Paso 2: Calcular el estadístico (Z o t)
        CalculoEstadistico calculador = CasoAEscoger.obtenerEstadistico(tipoPrueba);
        double estadistico = calculador.calcularEstadistico(datos);

        // Paso 3: Obtener la zona de rechazo
        String zonaRechazo = ZonaRechazo.determinarZona(tipoHipotesis, tipoPrueba,
                datos.getSignificancia(), datos.getMuestra());

        // Paso 4: Calcular valores críticos
        double valorCriticoInf = 0;
        double valorCriticoSup = 0;

        if (tipoPrueba == TipoPrueba.T_STUDENT) {
            int gl = GradosLibertad.calcular(datos.getMuestra());

            if (tipoHipotesis == TipoHipotesis.BILATERAL) {
                double t = TInversa.tInv(1 - datos.getSignificancia() / 2, gl);
                valorCriticoInf = -t;
                valorCriticoSup = t;
            }
            if (tipoHipotesis == TipoHipotesis.UNILATERAL_DERECHA) {
                valorCriticoSup = TInversa.tInv(1 - datos.getSignificancia(), gl);
                valorCriticoInf = valorCriticoSup;
            }
            if (tipoHipotesis == TipoHipotesis.UNILATERAL_IZQUIERDA) {
                valorCriticoInf = TInversa.tInv(datos.getSignificancia(), gl);
                valorCriticoSup = valorCriticoInf;
            }
        }

        if (tipoPrueba == TipoPrueba.Z_CONOCIDA || tipoPrueba == TipoPrueba.Z_DESCONOCIDA) {
            if (tipoHipotesis == TipoHipotesis.BILATERAL) {
                double z = NormalInversa.stdNormInv(1 - datos.getSignificancia() / 2);
                valorCriticoInf = -z;
                valorCriticoSup = z;
            }
            if (tipoHipotesis == TipoHipotesis.UNILATERAL_DERECHA) {
                valorCriticoSup = NormalInversa.stdNormInv(1 - datos.getSignificancia());
                valorCriticoInf = valorCriticoSup;
            }
            if (tipoHipotesis == TipoHipotesis.UNILATERAL_IZQUIERDA) {
                valorCriticoInf = NormalInversa.stdNormInv(datos.getSignificancia());
                valorCriticoSup = valorCriticoInf;
            }
        }

        // Paso 5: Decidir si rechazamos H0
        boolean rechazarH0 = false;

        if (tipoHipotesis == TipoHipotesis.BILATERAL) {
            if (estadistico < valorCriticoInf || estadistico > valorCriticoSup) {
                rechazarH0 = true;
            }
        }
        if (tipoHipotesis == TipoHipotesis.UNILATERAL_DERECHA) {
            if (estadistico > valorCriticoSup) {
                rechazarH0 = true;
            }
        }
        if (tipoHipotesis == TipoHipotesis.UNILATERAL_IZQUIERDA) {
            if (estadistico < valorCriticoInf) {
                rechazarH0 = true;
            }
        }

        // Paso 6: Crear el resultado con todos los datos
        ResultadoPrueba resultado = new ResultadoPrueba();
        resultado.setEstadistico(estadistico);
        resultado.setValorCriticoInferior(valorCriticoInf);
        resultado.setValorCriticoSuperior(valorCriticoSup);
        resultado.setZonaRechazo(zonaRechazo);
        resultado.setRechazarH0(rechazarH0);
        resultado.setTipoPrueba(tipoPrueba);
        resultado.setTipoHipotesis(tipoHipotesis);

        if (tipoPrueba == TipoPrueba.T_STUDENT) {
            resultado.setGradosLibertad(GradosLibertad.calcular(datos.getMuestra()));
        }

        return resultado;
    }
}