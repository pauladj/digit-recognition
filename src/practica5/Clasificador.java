package practica5;

import weka.classifiers.functions.SMO;
import weka.classifiers.functions.supportVector.NormalizedPolyKernel;

public class Clasificador {

	private static Clasificador miClasificador;


	/**
	 * recoger la instancia unica de Cross-validation con k=10
	 * @return
	 */
	public static Clasificador getMiClasificador() {
		if(miClasificador==null)
			miClasificador = new Clasificador();
		return miClasificador;
	}
	
	/**
	 * Creamos el clasificador con el algoritmo SMO
	 * @param c - input
	 * @param k - input
	 * @return
	 */
	public SMO crearSMO(double c, double k) {
		SMO clasificador = new SMO();
		clasificador.setC(c);
		clasificador.setBuildCalibrationModels(false);
		
		NormalizedPolyKernel kernel = new NormalizedPolyKernel();
		kernel.setExponent(k);
		kernel.setUseLowerOrder(false);
		
		clasificador.setKernel(kernel);
		
		return clasificador;
	}
}
