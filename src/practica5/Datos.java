package practica5;

import java.io.File;
import java.io.IOException;

import weka.core.Instances;
import weka.core.converters.ArffSaver;
import weka.core.converters.ConverterUtils.DataSource;

public class Datos {

	private static Datos misDatos;

	public static Datos getMisDatos() {
		if (misDatos==null) misDatos=new Datos();
		return misDatos;
	}

	/**
	 * devuelve el dataset (instancias) contenidas en un fichero
	 * @param path
	 * @return
	 */
	public Instances cargarDatos(String path) {
		DataSource source;
		Instances data=null;
		try {
			//cargar datos
			// System.out.println("Cargando datos de "+path+"...");
			source = new DataSource(path);
			data = source.getDataSet();
			data.setClass(data.attribute("class"));
		} catch (Exception e) {
			//System.out.print(e.getLocalizedMessage());
			System.out.print("El fichero no existe."); 
		}
		return data;
	}

	/**
	 * Se guardan los datos "data" en "path"
	 * @param path
	 * @param data
	 */
	public void guardarDatos(String path, Instances data) {
		try {
			//guardar datos
			// System.out.println("Guardando datos en el fichero "+path+"...");
			File fi = new File(path);
			ArffSaver saver = new ArffSaver();
			saver.setInstances(data);
			saver.setFile(fi);
			saver.writeBatch();
		} catch (IOException e) {
			System.err.print("Error al guardar los datos en un fichero .arff.");
			//e.printStackTrace();
		}
	}
}
