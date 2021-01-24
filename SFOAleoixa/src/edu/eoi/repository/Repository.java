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
			System.out.println("�En qu� puedo ayudarle?");
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
			System.out.println("El comando ".concat(instruccion).concat(" no es v�lido.\n"));
			loguear("ALEOIXA", "El comando ".concat(instruccion).concat(" no es v�lido."));
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
		chistes.add("Tiraros a la mar... Y Mar qued� embarazada.");
		chistes.add("No es lo mismo dos tazas de t� que dos tetazas.");
		chistes.add("No es lo mismo un metro de encaje negro que que un negro te encaje un metro.");
		chistes.add("�Apilar los barriles! Y pilar muri� aplastada.");

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

		System.out.println("Introduzca la operaci�n que quiere realizar, "
				+ "separando con espacios cada elemento (\"n�mero signo n�mero\"):");
		loguear("ALEOIXA", "Introduzca la operaci�n que quiere realizar, "
				+ "separando con espacios cada elemento (\"n�mero signo n�mero\"):");
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
//					System.out.println("Operaci�n invalida");
//					loguear("ALEOIXA", "Operaci�n invalida");
//					
//				} else {
					System.out.println(Double.parseDouble(operacionProcesada[0]) / Double.parseDouble(operacionProcesada[2]));
					loguear("ALEOIXA", Double.toString(Double.parseDouble(operacionProcesada[0]) / Double.parseDouble(operacionProcesada[2])));
//				}

			}
		} catch (ArithmeticException e) {
			System.out.println("Operaci�n inv�lida");
			loguear("ALEOIXA", "Operaci�n invalida");
		}
		System.out.println();
	}

	public static void traducir() {

		Map<String, String> DiccionarioEspa�olIngles = new HashMap<String, String>();
		DiccionarioEspa�olIngles.put("Pl�tano", "Banana");
		DiccionarioEspa�olIngles.put("Manzana", "Apple");
		DiccionarioEspa�olIngles.put("Pera", "Pear");
		DiccionarioEspa�olIngles.put("Sand�a", "Watermelon");
		DiccionarioEspa�olIngles.put("Cereza", "Cherry");
		DiccionarioEspa�olIngles.put("Melocot�n", "Peach");
		DiccionarioEspa�olIngles.put("Ciruela", "Plum");
		DiccionarioEspa�olIngles.put("Mel�n", "Melon");
		DiccionarioEspa�olIngles.put("Uva", "Grape");
		DiccionarioEspa�olIngles.put("Mora", "Blackberry");

		Map<String, String> DiccionarioInglesEspa�ol = new HashMap<String, String>();
		DiccionarioEspa�olIngles.put("Banana", "Pl�tano");
		DiccionarioEspa�olIngles.put("Apple", "Manzana");
		DiccionarioEspa�olIngles.put("Pear", "Pera");
		DiccionarioEspa�olIngles.put("Watermelon", "Sand�a");
		DiccionarioEspa�olIngles.put("Cherry", "Cereza");
		DiccionarioEspa�olIngles.put("Peach", "Melocot�n");
		DiccionarioEspa�olIngles.put("Plum", "Ciruela");
		DiccionarioEspa�olIngles.put("Melon", "Mel�n");
		DiccionarioEspa�olIngles.put("Grape", "Uva");
		DiccionarioEspa�olIngles.put("Blackberry", "Mora");

		System.out.println("�Qu� fruta desea traducir?");
		loguear("ALEOIXA", "�Qu� fruta desea traducir?");
		String fruta = sctexto.nextLine();
		loguear("USUARIO", fruta);
		//espa�ol-ingles
		for (String palabra : DiccionarioEspa�olIngles.keySet()) {
			if (fruta.equalsIgnoreCase(palabra)) {
				System.out.println(DiccionarioEspa�olIngles.get(palabra));
				loguear("ALEOIXA", DiccionarioEspa�olIngles.get(palabra));
				break;
			}
		}
		//ingles-espa�ol
				for (String palabra : DiccionarioInglesEspa�ol.keySet()) {
			if (fruta.equalsIgnoreCase(palabra)) {
				System.out.println(DiccionarioInglesEspa�ol.get(palabra));
				loguear("ALEOIXA", DiccionarioInglesEspa�ol.get(palabra));
				break;
			}
		}
	}

	public static void loguear(String interlocutor, String mensaje) {
		try {
			//Generar el objeto que crear� y escribir� nuestro documento
			FileWriter fw = new FileWriter("log_aleoixa_".concat(LocalDate.now().toString()).concat(".txt"), true);
				
			fw.write(LocalTime.now().format(DateTimeFormatter.ofPattern("HH:mm:ss")).toString().concat(" - ").concat(interlocutor).concat(": ").concat(mensaje).concat("\n"));
				
			fw.close();
		} catch (IOException e) {
			System.out.println("Ha habido un problema modificando el archivo");;
		}
	}

}
