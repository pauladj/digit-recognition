package practica5;

import weka.classifiers.functions.SMO;
import weka.core.Instances;

public class Main {

	public static void main(String[] args) {
		
		if(args.length == 0) error();
		else if(args.length == 2) {
			Instances train = Datos.getMisDatos().cargarDatos(args[0]);
			Instances test = Datos.getMisDatos().cargarDatos(args[1]);
			
			train = Preprocesador.getMiPreprocesador().preprocesar(train);
			
			Optimizador.getMiOptimizador().optimizar(train,test);
			
			
		}else {
			error();
		}

	}
	
	/**
	 * 
	 */
	private static void error() {
		System.out.println("El objetivo de este problema sera preprocesar los datos y clasificar\n"
				+ "instancias test.");
		System.out.println("Pre-condiciones: archivos train y test en formato arff");
		System.out.println("Post-condiciones: se imprime por pantalla el porcentaje de aciertos\n"
				+ "del clasificador elegido.");
		System.out.println();
		System.out.println("Modo de uso: java -jar equipoDreamTeam_P5.jar train.arff test.arff");
	}

}

