package edu.eoi.repository;

import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

public class LoguearRepository {
	
	//Crear y escribir nuestro documento Log
	public static void loguear(String interlocutor, String mensaje) {
		try {
			FileWriter fw = new FileWriter("resources/log_aleoixa_".concat(LocalDate.now().toString()).concat(".txt"), true);
				
			fw.write(LocalTime.now().format(DateTimeFormatter.ofPattern("HH:mm:ss")).toString().concat(" - ").concat(interlocutor).concat(": ").concat(mensaje).concat("\n"));
				
			fw.close();
		} catch (IOException e) {
			System.out.println("Ha habido un problema modificando el archivo");
		}
	}
}
