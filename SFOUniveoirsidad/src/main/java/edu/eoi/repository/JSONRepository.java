package edu.eoi.repository;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;

import edu.eoi.pojo.Persona;

public class JSONRepository {

	
	public static void escribirArchivo(List<Persona> personas, String clase) {
		Gson gson = new GsonBuilder().setPrettyPrinting().create();
		String json = gson.toJson("");
		if(personas != null) {
			json = gson.toJson(personas);
		}

		try {
			FileWriter fw = new FileWriter(clase.concat(".JSON"), false);
			fw.write(json);
			fw.flush();
			fw.close();
			System.out.println("Se ha escrito el archivo correctamente");
		} catch (IOException e) {
			System.out.println("No se pudo abrir el archivo.");
		}
	}
	
	public static List<Persona> leerArchivo(String clase) {
		List<Persona> listaPersonas = new ArrayList<Persona>();
		Gson gson = new GsonBuilder().setPrettyPrinting().create();
		String json = "";
		String line = null;
		try {
			FileReader fr = new FileReader(clase.concat(".JSON"));
			BufferedReader br = new BufferedReader(fr);
			do { 
				line = br.readLine();
				if(line != null) {
					json = json+line+"\n";
				}
			} while(line != null);
			fr.close();
			br.close();
		} catch (FileNotFoundException e) {
			System.out.println("No se encuentra el archivo especificado.");
			escribirArchivo(null, clase);
			leerArchivo(clase);
		} catch (IOException e) {
			System.out.println("No se pudo abrir el archivo.");
		}
		
		listaPersonas = gson.fromJson(json, new TypeToken<List<Persona>>(){}.getType());

		return listaPersonas;
	}

}