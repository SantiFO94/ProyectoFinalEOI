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

import edu.eoi.pojo.Alumno;
import edu.eoi.pojo.PAS;
import edu.eoi.pojo.Profesor;

public class JSONRepository {

	//guardar información en un archivo JSON
	public static void escribirArchivoAlumnos(List<Alumno> alumnos) {
		Gson gson = new GsonBuilder().setPrettyPrinting().create();
		String json = gson.toJson("");
		if (alumnos != null) {
			json = gson.toJson(alumnos);
		}

		try {
			FileWriter fw = new FileWriter("Alumnos.JSON", false);
			fw.write(json);
			fw.flush();
			fw.close();
			System.out.println("Se ha escrito el archivo correctamente");
		} catch (IOException e) {
			System.out.println("No se pudo abrir el archivo.");
		}
	}
	
	public static void escribirArchivoProfesores(List<Profesor> profesores) {
		Gson gson = new GsonBuilder().setPrettyPrinting().create();
		String json = gson.toJson("");
		if (profesores != null) {
			json = gson.toJson(profesores);
		}

		try {
			FileWriter fw = new FileWriter("Profesores.JSON", false);
			fw.write(json);
			fw.flush();
			fw.close();
			System.out.println("Se ha escrito el archivo correctamente");
		} catch (IOException e) {
			System.out.println("No se pudo abrir el archivo.");
		}
	}
	
	public static void escribirArchivoPas(List<PAS> listaPas) {
		Gson gson = new GsonBuilder().setPrettyPrinting().create();
		String json = gson.toJson("");
		if (listaPas != null) {
			json = gson.toJson(listaPas);
		}

		try {
			FileWriter fw = new FileWriter("PAS.JSON", false);
			fw.write(json);
			fw.flush();
			fw.close();
			System.out.println("Se ha escrito el archivo correctamente");
		} catch (IOException e) {
			System.out.println("No se pudo abrir el archivo.");
		}
	}
//recuperar la informacion de un archivo JSON a una Lista
	public static List<Alumno> leerArchivoAlumnos(String clase) {
		List<Alumno> listaPersonas = new ArrayList<Alumno>();
		Gson gson = new GsonBuilder().setPrettyPrinting().create();
		String json = "";
		String line = null;
		try {
			FileReader fr = new FileReader(clase.concat(".JSON"));
			BufferedReader br = new BufferedReader(fr);
			do {
				line = br.readLine();
				if (line != null) {
					json = json + line + "\n";
				}
			} while (line != null);
			fr.close();
			br.close();
		} catch (FileNotFoundException e) {
			System.out.println("No se encuentra el archivo especificado.");
			escribirArchivoAlumnos(null);
			listaPersonas = leerArchivoAlumnos(clase);
		} catch (IOException e) {
			System.out.println("No se pudo abrir el archivo.");
		}

		listaPersonas = gson.fromJson(json, new TypeToken<List<Alumno>>() {
		}.getType());

		return listaPersonas;
	}
	public static List<Profesor> leerArchivoProfesores(String clase) {
		List<Profesor> listaPersonas = new ArrayList<Profesor>();
		Gson gson = new GsonBuilder().setPrettyPrinting().create();
		String json = "";
		String line = null;
		try {
			FileReader fr = new FileReader(clase.concat(".JSON"));
			BufferedReader br = new BufferedReader(fr);
			do {
				line = br.readLine();
				if (line != null) {
					json = json + line + "\n";
				}
			} while (line != null);
			fr.close();
			br.close();
		} catch (FileNotFoundException e) {
			System.out.println("No se encuentra el archivo especificado.");
			escribirArchivoProfesores(null);
			listaPersonas = leerArchivoProfesores(clase);
		} catch (IOException e) {
			System.out.println("No se pudo abrir el archivo.");
		}

		listaPersonas = gson.fromJson(json, new TypeToken<List<Profesor>>() {}.getType());

		return listaPersonas;
	}
	public static List<PAS> leerArchivoPas(String clase) {
		List<PAS> listaPas = new ArrayList<PAS>();
		Gson gson = new GsonBuilder().setPrettyPrinting().create();
		String json = "";
		String line = null;
		try {
			FileReader fr = new FileReader(clase.concat(".JSON"));
			BufferedReader br = new BufferedReader(fr);
			do {
				line = br.readLine();
				if (line != null) {
					json = json + line + "\n";
				}
			} while (line != null);
			fr.close();
			br.close();
		} catch (FileNotFoundException e) {
			System.out.println("No se encuentra el archivo especificado.");
			escribirArchivoPas(null);
			listaPas = leerArchivoPas(clase);
		} catch (IOException e) {
			System.out.println("No se pudo abrir el archivo.");
		}

		listaPas = gson.fromJson(json, new TypeToken<List<PAS>>() {
		}.getType());

		return listaPas;
	}

}