package edu.eoi.repository;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.Scanner;

public class ComandosRepository {

	private static final Scanner sctexto = new Scanner(System.in);

	public static Comando introducirComando() {
		
		Comando comando = null;
		String instruccion = null;
		try {
			System.out.println("¿En qué puedo ayudarle? \n"
					+ "(Si tiene dudas sobre qué puede pedirme escriba AYUDA)");
			LoguearRepository.loguear("ALEOIXA", "¿En qué puedo ayudarle? (Si tiene dudas sobre qué puede pedirme escriba AYUDA)");

			instruccion = sctexto.nextLine();
			LoguearRepository.loguear("USUARIO", instruccion);
			if(instruccion.matches("\\D+")) {
				for(Comando comandoTemporal : Comando.values()) {
					if (instruccion.equalsIgnoreCase(comandoTemporal.comando)) {
						comando = comandoTemporal;
					}
				}
			}else {
				System.out.println("El comando no puede contener números.\n");
				LoguearRepository.loguear("ALEOIXA", "El comando no puede contener números.\n");
				comando = introducirComando();
			}
			if(comando.equals(null)) {
				throw new Exception();
			}
			
		} catch (Exception e) {
			System.out.println("El comando ".concat(instruccion.toString()).concat(" no es válido.\n"));
			LoguearRepository.loguear("ALEOIXA", "El comando ".concat(instruccion.toString()).concat(" no es válido."));
			comando = introducirComando();
		}

		return comando;
	}
	//mostrar comandos disponibles
	public static void help() {

		System.out.println("Puedes pedirme cualquiera de estas cosas:\n");
		LoguearRepository.loguear("ALEOIXA", "Puedes pedirme cualquiera de estas cosas:");
		for (Comando comando : Comando.values()) {
			System.out.println(comando.comando);
			LoguearRepository.loguear("ALEOIXA", comando.comando);
		}
		System.out.println();
	}

	public static void decirFecha() {
		LocalDate hoy = LocalDate.now();
		DateTimeFormatter formato = DateTimeFormatter.ofPattern("dd/MM/yyyy");
		System.out.println(hoy.format(formato));
		LoguearRepository.loguear("ALEOIXA", hoy.format(formato));
		System.out.println();
	}

	public static void decirHora() {
		LocalTime ahora = LocalTime.now();
		DateTimeFormatter formato = DateTimeFormatter.ofPattern("HH:mm");
		System.out.println(ahora.format(formato));
		LoguearRepository.loguear("ALEOIXA", ahora.format(formato));
		System.out.println();
	}

	public static void contarChiste() {
		List<String> chistes = new ArrayList<String>();
		
		try {
			FileReader fr = new FileReader("resources/Chistes.txt");
			BufferedReader br = new BufferedReader(fr);
			String lectura = null;
			do{
				lectura = br.readLine();
				if (lectura != null) {
					chistes.add(lectura);
				}
				
			}while (lectura != null);
			
			fr.close();
			br.close();
			
			int random = new Random().nextInt(chistes.size());
			System.out.println(chistes.get(random));
			LoguearRepository.loguear("ALEOIXA", chistes.get(random));

		}catch(FileNotFoundException e){
			System.out.println("No se han encontrado los chistes, quizas son demasiado malos...");
			LoguearRepository.loguear("ALEOIXA", "No se han encontrado los chistes, quizas son demasiado malos...");
		}catch(IOException f) {
			System.out.println("Ha ocurrido un error");
			LoguearRepository.loguear("ALEOIXA", "Ha ocurrido un error");
		}

		System.out.println();
	}

	public static void calcular() {

		System.out.println("Introduzca la operación que quiere realizar, "
				+ "separando con espacios cada elemento (número signo número):");
		LoguearRepository.loguear("ALEOIXA", "Introduzca la operación que quiere realizar, "
				+ "separando con espacios cada elemento (número signo número):");
		String operacionIntroducida = sctexto.nextLine();
		LoguearRepository.loguear("USUARIO", operacionIntroducida);
		String operacionProcesada[] = operacionIntroducida.split(" ");
		
		String operador = operacionProcesada[1];

		try {
			if (operador.equals("+")) {
				System.out.println(Double.parseDouble(operacionProcesada[0]) + Double.parseDouble(operacionProcesada[2]));
				LoguearRepository.loguear("ALEOIXA", Double.toString(Double.parseDouble(operacionProcesada[0]) + Double.parseDouble(operacionProcesada[2])));
			} else if (operador.equals("-")) {
				System.out.println(Double.parseDouble(operacionProcesada[0]) - Double.parseDouble(operacionProcesada[2]));
				LoguearRepository.loguear("ALEOIXA", Double.toString(Double.parseDouble(operacionProcesada[0]) - Double.parseDouble(operacionProcesada[2])));
			} else if (operador.equals("*") || operador.equals("x")) {
				System.out.println(Double.parseDouble(operacionProcesada[0]) * Double.parseDouble(operacionProcesada[2]));
				LoguearRepository.loguear("ALEOIXA", Double.toString(Double.parseDouble(operacionProcesada[0]) * Double.parseDouble(operacionProcesada[2])));
			} else if (operador.equals("/")) {
				System.out.println(Double.parseDouble(operacionProcesada[0]) / Double.parseDouble(operacionProcesada[2]));
				LoguearRepository.loguear("ALEOIXA", Double.toString(Double.parseDouble(operacionProcesada[0]) / Double.parseDouble(operacionProcesada[2])));
			} else {
				System.out.println("No le entiendo. Pruebe con los símbolos: + , - , * , /");
				LoguearRepository.loguear("ALEOIXA", "No le entiendo. Pruebe con los símbolos: + , - , * , /");
			}
		} catch (ArithmeticException e) {
			System.out.println("Operación inválida");
			LoguearRepository.loguear("ALEOIXA", "Operación invalida");
		}
		System.out.println();
	}

	public static void traducir() {

		Map<String, String> DiccionarioEspanyolIngles = new HashMap<String, String>();
		DiccionarioEspanyolIngles.put("Plátano", "Banana");
		DiccionarioEspanyolIngles.put("Manzana", "Apple");
		DiccionarioEspanyolIngles.put("Pera", "Pear");
		DiccionarioEspanyolIngles.put("Sandía", "Watermelon");
		DiccionarioEspanyolIngles.put("Cereza", "Cherry");
		DiccionarioEspanyolIngles.put("Melocotón", "Peach");
		DiccionarioEspanyolIngles.put("Ciruela", "Plum");
		DiccionarioEspanyolIngles.put("Melón", "Melon");
		DiccionarioEspanyolIngles.put("Uva", "Grape");
		DiccionarioEspanyolIngles.put("Mora", "Blackberry");

		System.out.println("¿Qué fruta desea traducir?");
		LoguearRepository.loguear("ALEOIXA", "¿Qué fruta desea traducir?");
		String fruta = sctexto.nextLine();
		LoguearRepository.loguear("USUARIO", fruta);
		boolean encontrado = false;
		//español-ingles
		//buscar palabra
		for (String palabra : DiccionarioEspanyolIngles.keySet()) {
			if (fruta.equalsIgnoreCase(palabra)) {
				System.out.println(DiccionarioEspanyolIngles.get(palabra));
				LoguearRepository.loguear("ALEOIXA", DiccionarioEspanyolIngles.get(palabra));
				encontrado = true;
			}
		}
		//ingles-español
		if(!encontrado) {
			//preparar diccionario invertido
			Map<String, String> DiccionarioInglesEspanyol = new HashMap<String, String>();
			for (String palabra : DiccionarioEspanyolIngles.keySet()) {
				DiccionarioInglesEspanyol.put(DiccionarioEspanyolIngles.get(palabra), palabra);
			}
			//buscar palabra
			for (String palabra : DiccionarioInglesEspanyol.keySet()) {
				if (fruta.equalsIgnoreCase(palabra)) {
					System.out.println(DiccionarioInglesEspanyol.get(palabra));
					LoguearRepository.loguear("ALEOIXA", DiccionarioInglesEspanyol.get(palabra));
					encontrado = true;
				}
			}
		}
		if(!encontrado) {
			System.out.println("Esa palabra no se encuentra en nuestro diccionario.");
			LoguearRepository.loguear("ALEOIXA", "Esa palabra no se encuentra en nuestro diccionario.");

		}
		
	}

	

}
