package practica5;

import weka.core.Instances;

public class Preprocesador {

	private static Preprocesador miPreprocesador;

	public static Preprocesador getMiPreprocesador() {
		if (miPreprocesador==null) miPreprocesador=new Preprocesador();
		return miPreprocesador;
	}

	public Instances preprocesar(Instances data) {
		
		return Filtrador.getMiFiltro().filtroResample(data);
	}
}
