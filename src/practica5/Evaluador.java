package practica5;

import weka.classifiers.evaluation.Evaluation;
import weka.classifiers.functions.SMO;
import weka.classifiers.functions.supportVector.NormalizedPolyKernel;
import weka.core.Instances;
import weka.core.Utils;
import weka.core.converters.ConverterUtils.DataSource;


public class Evaluador {

	private static Evaluador miEvaluador;

	public static Evaluador getMiEvaluador() {
		if (miEvaluador==null) miEvaluador= new Evaluador();
		return miEvaluador;
	}

	/**
	 * Se realiza un entrenamiento con train y una evaluación contra test.
	 * @param train
	 * @param test
	 * @param clasificador
	 * @return
	 */
	public double evaluarContraTest(Instances train, Instances test, SMO clasificador) {

		Evaluation evaluator;
		try {
			clasificador.buildClassifier(train);

			//evaluacion del modelo
			evaluator = new Evaluation(train);
			evaluator.evaluateModel(clasificador, test);

			double fMeasure=evaluator.weightedFMeasure();

			// precision and recall are both zero, the F1-score is undefined (NaN)
			if(Double.isNaN(fMeasure)) fMeasure = 0;

			return fMeasure;
		}catch(Exception e){
			System.out.println("Problema al evaluar");
		}
		return 0.0;
	}

	/**
	 * Imprime los resultados que se obtienen del analisis de un test.
	 * @param clasificador
	 * @param train
	 * @param test
	 */
	public void imprimirResultado(SMO clasificador, Instances train, Instances test) {
		try {
			long trainTimeStart = 0, trainTimeElapsed = 0;
			long testTimeStart = 0, testTimeElapsed = 0;

			trainTimeStart = System.currentTimeMillis();
			clasificador.buildClassifier(train);
			trainTimeElapsed = System.currentTimeMillis() - trainTimeStart;

			String tiempoModelo = Utils.doubleToString(trainTimeElapsed / 1000.0, 2);

			System.out.println(tiempoModelo + " segundos en entrenar el modelo optimo.");

			//evaluacion del modelo
			Evaluation evaluator = new Evaluation(train);

			testTimeStart = System.currentTimeMillis();
			evaluator.evaluateModel(clasificador, test);
			testTimeElapsed = System.currentTimeMillis() - testTimeStart;
			
			String tiempoClasificacion = Utils.doubleToString(testTimeElapsed / 1000.0, 2);
			
			System.out.println(tiempoClasificacion + " segundos en clasificar test.");

			long tiempoTotal = trainTimeElapsed + testTimeElapsed;
			String tiempoTotal2 = Utils.doubleToString(tiempoTotal / 1000.0, 2);

			System.out.println(tiempoTotal2 + " segundos en total.");

			System.out.println(evaluator.toSummaryString());
			System.out.println(evaluator.toMatrixString());
			System.out.println(evaluator.toClassDetailsString());
		} catch (Exception e) {
			System.out.println("Error al imprimir resultados.");
		}

	}

}
