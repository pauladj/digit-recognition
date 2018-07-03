package practica5;

import weka.classifiers.evaluation.Evaluation;
import weka.classifiers.functions.SMO;
import weka.core.Instances;

public class Optimizador {

	private static Optimizador miOptimizador;

	public static Optimizador getMiOptimizador() {
		if (miOptimizador==null) miOptimizador=new Optimizador();
		return miOptimizador;
	}

	/**
	 * Se realiza la optimización de parametros.
	 * @param train - input
	 * @param test - input
	 */
	public void optimizar(Instances train, Instances test) {
		
		Double[] valoresC = {3.0,5.5};
		Double[] valoresKernel = {2.0,3.0,5.0};
		
		double fMeasureOptimo = 0.0;
		SMO clasificadorOptimo = null;
		
		for(double unC : valoresC) {
			for(double unK : valoresKernel) {
				SMO clasificador = Clasificador.getMiClasificador().crearSMO(unC, unK);
				double fMeasure = Evaluador.getMiEvaluador().evaluarContraTest(train,test,clasificador);
				
				if (fMeasure > fMeasureOptimo) {
					fMeasureOptimo = fMeasure;
					clasificadorOptimo = clasificador;
				}
			}
		}
		
		//Ya se sabe cual es el óptimo
		Evaluador.getMiEvaluador().imprimirResultado(clasificadorOptimo, train, test);
	}
	
}
