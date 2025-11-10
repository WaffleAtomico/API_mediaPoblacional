# API de Pruebas de Hipótesis para la Media Poblacional en Java

Este proyecto implementa una API en Java para resolver y validar pruebas de hipótesis para la media poblacional (μ). Está diseñada para facilitar el análisis estadístico mediante pruebas de hipótesis basadas en muestras de datos reales.

## Descripción

Las pruebas de hipótesis son un método estadístico que permite determinar si existe evidencia suficiente en una muestra para aceptar o rechazar una suposición acerca de una población. En particular, esta API se enfoca en la prueba de hipótesis para la media poblacional (μ).

Dependiendo del tipo de datos y parámetros disponibles, la fórmula y el procedimiento para evaluar la hipótesis pueden variar. La API soporta los casos más comunes para realizar esta evaluación, siguiendo los principios estadísticos estándar.

## Casos implementados en la API

La API incluye métodos para validar y calcular la prueba de hipótesis en los siguientes escenarios (ejemplos):

- Población con varianza conocida, distribución normal.
- Población con varianza desconocida, distribución normal con muestra pequeña (t-Student).
- Muestra grande con varianza desconocida, aproximación normal.
- Contrastes de cola izquierda, cola derecha y dos colas.

> Nota: Las fórmulas específicas y condiciones usadas en cada caso se reflejan en la lógica de la API para garantizar precisión en los resultados.

## Características principales

- Validación de parámetros de entrada (media, varianza, tamaño de muestra, nivel de significancia, hipótesis nula y alternativa).
- Cálculo del estadístico de prueba adecuado según el escenario.
- Evaluación del valor p y comparación con el nivel de significancia para tomar la decisión.
- Respuesta clara sobre si se acepta o rechaza la hipótesis nula.
- Manejo de errores y mensajes informativos en caso de entradas inválidas o inconsistentes.

## Tecnologías

- Lenguaje: Java
- Herramientas de construcción: Maven/Gradle (según corresponda)

## Uso

1. Clonar el repositorio.
2. Configurar el proyecto con el gestor de dependencias.
3. Ejecutar la API localmente o desplegar en servidor.


