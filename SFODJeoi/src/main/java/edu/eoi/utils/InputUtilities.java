package edu.eoi.utils;

import java.util.Scanner;

import edu.eoi.repository.Comando;
import edu.eoi.repository.Guia;

public class InputUtilities {
	
	private static Scanner sctexto = new Scanner(System.in);
	
	public static Comando introducirComando() {
		String comandoIntroducido = sctexto.nextLine();		
		Comando comandoAceptado = null;
		
		try {
		for(Comando comando : Comando.values()) {
			if(comandoIntroducido.equalsIgnoreCase(comando.comando)||
				comandoIntroducido.equalsIgnoreCase(comando.comandoAcentuado)||
				comandoIntroducido.equalsIgnoreCase(comando.comandoCorto)) {
				comandoAceptado = comando;
			}
		}
		if(comandoAceptado.equals(null)) {
			throw new Exception();
		}
		}catch (Exception e) {
			System.out.println("Comando introducido incorrecto, vuelva a intentarlo");
			comandoAceptado = introducirComando();
		}
		return comandoAceptado;
	}
	
	
	public static Guia introducirGuia() {
		String guiaIntroducida = sctexto.nextLine();		
		Guia guiaAceptada = null;
		
		try {
		for(Guia guia : Guia.values()) {
			if(guiaIntroducida.equalsIgnoreCase(guia.guia)){
				guiaAceptada = guia;
			}
		}
		if(guiaAceptada.equals(null)) {
			throw new Exception();
		}
		}catch (Exception e) {
			System.out.println("Comando introducido incorrecto, vuelva a intentarlo");
			guiaAceptada = introducirGuia();
		}
		return guiaAceptada;
	}
	
	
}
