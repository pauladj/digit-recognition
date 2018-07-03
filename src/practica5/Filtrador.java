package practica5;

import weka.core.Instances;
import weka.filters.Filter;
import weka.filters.supervised.instance.Resample;

public class Filtrador {

	private static Filtrador miFiltrador;

	public static Filtrador getMiFiltro() {
		if (miFiltrador==null) miFiltrador=new Filtrador();
		return miFiltrador;
	}

	/**
	 *Se aplica un filtro con el que reducimos el número de instancias.
	 * @param data
	 * @return
	 */
	public Instances filtroResample(Instances data) {
		try {
			Resample filtro = new Resample();
			filtro.setBiasToUniformClass(1.0);
			filtro.setNoReplacement(true);
			filtro.setRandomSeed(2);
			filtro.setSampleSizePercent(88.0);

			filtro.setInputFormat(data);

			data = Filter.useFilter(data, filtro);
			
			
			return data;

		} catch (Exception e) {
			System.out.println("Se ha producido un error al filtrar Resample");
		}
		
		return null;
	}
}
