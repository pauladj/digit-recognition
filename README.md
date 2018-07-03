# digit-recognition
El objetivo de este problema será preprocesar los datos y clasificar instancias test.

*Pre-condiciones: archivos train y test en formato arff*

*Post-condiciones: se imprime por pantalla el porcentaje de aciertos del clasificador elegido.*

## Proceso
1. Preprocesado de datos train.arff aplicando filtros.
2. Optimización del modelo elegido *SMO*
3. Train vs. test con el modelo optimizado.

## Modo de Uso
`java -jar xxx.jar train.arff test.arff`

## Resultados
Se ha conseguido una precisión de un **94,15%**
