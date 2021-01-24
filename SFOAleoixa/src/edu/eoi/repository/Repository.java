package edu.eoi.repository;

import java.io.FileWriter;
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

public class Repository {

	private static final Scanner sctexto = new Scanner(System.in);

	public static Comando elegirComando() {
		
		Comando comando = null;
		String instruccion = null;
		try {
			System.out.println("¿En qué puedo ayudarle?");
			instruccion = sctexto.nextLine();
			loguear("USUARIO", instruccion);
			
			for(Comando comandoTemporal : Comando.values()) {
				if (instruccion.equalsIgnoreCase(comandoTemporal.toString())) {
					comando = comandoTemporal;
				}else {
					throw new Exception();
				}
			}
		} catch (Exception e) {
			System.out.println("El comando ".concat(instruccion).concat(" no es válido.\n"));
			loguear("ALEOIXA", "El comando ".concat(instruccion).concat(" no es válido."));
			elegirComando();
		}

		return comando;
	}
	
	public static void help() {

		System.out.println("Puedes pedirme cualquiera de estas cosas:\n");
		loguear("ALEOIXA", "Puedes pedirme cualquiera de estas cosas:");
		for (Comando comando : Comando.values()) {
			System.out.println(comando.comando);
			loguear("ALEOIXA", comando.comando);
		}
		System.out.println();
	}

	public static void decirFecha() {
		LocalDate hoy = LocalDate.now();
		DateTimeFormatter formato = DateTimeFormatter.ofPattern("dd/MM/yyyy");
		System.out.println(hoy.format(formato));
		loguear("ALEOIXA", hoy.format(formato));
		System.out.println();
	}

	public static void decirHora() {
		LocalTime ahora = LocalTime.now();
		DateTimeFormatter formato = DateTimeFormatter.ofPattern("HH:mm");
		System.out.println(ahora.format(formato));
		loguear("ALEOIXA", ahora.format(formato));
		System.out.println();
	}

	public static void contarChiste() {
		List<String> chistes = new ArrayList<String>();
		chistes.add("Van dos y se cae el de en medio.");
		chistes.add("Va una canica y vuelca.");
		chistes.add("Va un barco al muelle y rebota.");
		chistes.add("Tiraros a la mar... Y Mar quedó embarazada.");
		chistes.add("No es lo mismo dos tazas de té que dos tetazas.");
		chistes.add("No es lo mismo un metro de encaje negro que que un negro te encaje un metro.");
		chistes.add("¡Apilar los barriles! Y pilar murió aplastada.");

		int random = new Random().nextInt(chistes.size());
		System.out.println(chistes.get(random));
		loguear("ALEOIXA", chistes.get(random));

//		try {
//			FileReader fr = new FileReader("ChistesMal.txt");
//			BufferedReader br = new BufferedReader(fr);
//			String lectura = null;
//			do{
//				lectura = br.readLine();
//				if (lectura != null) {
//					System.out.println(lectura);
//					chistes.add(lectura);
//				}
//				
//			}while (lectura != null);
//			
//			fr.close();
//			br.close();
//			
//			int random = new Random().nextInt(chistes.size());
//			System.out.println(chistes.get(random));
//			
//		}catch(FileNotFoundException e){
//			System.out.println("No se han encontrado los chistes, quizas son demasiado malos...");
//		}catch(IOException f) {
//			System.out.println("Ha ocurrido un error");
//		}

		System.out.println();
	}

	public static void calcular() {

		System.out.println("Introduzca la operación que quiere realizar, "
				+ "separando con espacios cada elemento (\"número signo número\"):");
		loguear("ALEOIXA", "Introduzca la operación que quiere realizar, "
				+ "separando con espacios cada elemento (\"número signo número\"):");
		String operacionIntroducida = sctexto.nextLine();
		loguear("USUARIO", operacionIntroducida);
		String operacionProcesada[] = operacionIntroducida.split(" ");
		String operador = operacionProcesada[1];

		try {
			if (operador.equals("+")) {
				System.out.println(Double.parseDouble(operacionProcesada[0]) + Double.parseDouble(operacionProcesada[2]));
				loguear("ALEOIXA", Double.toString(Double.parseDouble(operacionProcesada[0]) + Double.parseDouble(operacionProcesada[2])));
			} else if (operador.equals("-")) {
				System.out.println(Double.parseDouble(operacionProcesada[0]) - Double.parseDouble(operacionProcesada[2]));
				loguear("ALEOIXA", Double.toString(Double.parseDouble(operacionProcesada[0]) - Double.parseDouble(operacionProcesada[2])));
			} else if (operador.equals("*")) {
				System.out.println(Double.parseDouble(operacionProcesada[0]) * Double.parseDouble(operacionProcesada[2]));
				loguear("ALEOIXA", Double.toString(Double.parseDouble(operacionProcesada[0]) * Double.parseDouble(operacionProcesada[2])));
			} else if (operador.equals("/")) {
//				if (Double.parseDouble(operacionProcesada[0]) == 0.0 || Double.parseDouble(operacionProcesada[2]) == 0.0) {
//					System.out.println("Operación invalida");
//					loguear("ALEOIXA", "Operación invalida");
//					
//				} else {
					System.out.println(Double.parseDouble(operacionProcesada[0]) / Double.parseDouble(operacionProcesada[2]));
					loguear("ALEOIXA", Double.toString(Double.parseDouble(operacionProcesada[0]) / Double.parseDouble(operacionProcesada[2])));
//				}

			}
		} catch (ArithmeticException e) {
			System.out.println("Operación inválida");
			loguear("ALEOIXA", "Operación invalida");
		}
		System.out.println();
	}

	public static void traducir() {

		Map<String, String> DiccionarioEspañolIngles = new HashMap<String, String>();
		DiccionarioEspañolIngles.put("Plátano", "Banana");
		DiccionarioEspañolIngles.put("Manzana", "Apple");
		DiccionarioEspañolIngles.put("Pera", "Pear");
		DiccionarioEspañolIngles.put("Sandía", "Watermelon");
		DiccionarioEspañolIngles.put("Cereza", "Cherry");
		DiccionarioEspañolIngles.put("Melocotón", "Peach");
		DiccionarioEspañolIngles.put("Ciruela", "Plum");
		DiccionarioEspañolIngles.put("Melón", "Melon");
		DiccionarioEspañolIngles.put("Uva", "Grape");
		DiccionarioEspañolIngles.put("Mora", "Blackberry");

		Map<String, String> DiccionarioInglesEspañol = new HashMap<String, String>();
		DiccionarioEspañolIngles.put("Banana", "Plátano");
		DiccionarioEspañolIngles.put("Apple", "Manzana");
		DiccionarioEspañolIngles.put("Pear", "Pera");
		DiccionarioEspañolIngles.put("Watermelon", "Sandía");
		DiccionarioEspañolIngles.put("Cherry", "Cereza");
		DiccionarioEspañolIngles.put("Peach", "Melocotón");
		DiccionarioEspañolIngles.put("Plum", "Ciruela");
		DiccionarioEspañolIngles.put("Melon", "Melón");
		DiccionarioEspañolIngles.put("Grape", "Uva");
		DiccionarioEspañolIngles.put("Blackberry", "Mora");

		System.out.println("¿Qué fruta desea traducir?");
		loguear("ALEOIXA", "¿Qué fruta desea traducir?");
		String fruta = sctexto.nextLine();
		loguear("USUARIO", fruta);
		//español-ingles
		for (String palabra : DiccionarioEspañolIngles.keySet()) {
			if (fruta.equalsIgnoreCase(palabra)) {
				System.out.println(DiccionarioEspañolIngles.get(palabra));
				loguear("ALEOIXA", DiccionarioEspañolIngles.get(palabra));
				break;
			}
		}
		//ingles-español
				for (String palabra : DiccionarioInglesEspañol.keySet()) {
			if (fruta.equalsIgnoreCase(palabra)) {
				System.out.println(DiccionarioInglesEspañol.get(palabra));
				loguear("ALEOIXA", DiccionarioInglesEspañol.get(palabra));
				break;
			}
		}
	}

	public static void loguear(String interlocutor, String mensaje) {
		try {
			//Generar el objeto que creará y escribirá nuestro documento
			FileWriter fw = new FileWriter("log_aleoixa_".concat(LocalDate.now().toString()).concat(".txt"), true);
				
			fw.write(LocalTime.now().format(DateTimeFormatter.ofPattern("HH:mm:ss")).toString().concat(" - ").concat(interlocutor).concat(": ").concat(mensaje).concat("\n"));
				
			fw.close();
		} catch (IOException e) {
			System.out.println("Ha habido un problema modificando el archivo");;
		}
	}

}
