package edu.eoi.utils;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

import edu.eoi.entity.Melodia;
import edu.eoi.repository.Instrumento;
import edu.eoi.repository.MusicaRepository;
import edu.eoi.service.MelodiaService;

public class InputMelodiaUtilities {

	private static Scanner sctexto = new Scanner(System.in);
	private static MelodiaService MelodiaService = new MelodiaService();
	public Melodia introducirDatosMelodia() {

		Melodia melodia = new Melodia(null, null);
		System.out.println("CREACIÓN DE MELODÍA");
		System.out.println("Introduzca el nombre de la melodía:");
		melodia.setNombre(sctexto.nextLine());
		melodia.setSecuenciaIntroducida(introducirSecuencia());
		melodia.setSecuenciaMusical(MelodiaService.traducirSecuencia(melodia.getSecuenciaIntroducida()));

		return melodia;
	}
	
	public static void modificarMelodia(Connection con, Melodia melodia) throws SQLException{
		String campoIntroducido = null;
		String valorActualizado = null;
		PreparedStatement pst = null;

		do {
			System.out.println("Introduzca el campo que quiere modificar:");
			System.out.println("(nombre, secuencia introducida)");
			System.out.println("Si quiere dejar de modificar escriba SALIR");
			campoIntroducido = sctexto.nextLine();
			
			if (campoIntroducido.equalsIgnoreCase("nombre")) {
				
				System.out.println("Introduzca el nuevo valor:");
				valorActualizado = sctexto.nextLine();
				
				pst = con.prepareStatement("UPDATE djeoi.melodia SET nombre = ? WHERE id=? ");
				pst.setString(1, valorActualizado);
				pst.setInt(2, melodia.getId());

			} else if (campoIntroducido.equalsIgnoreCase("secuencia Introducida")) {
				
				valorActualizado = introducirSecuencia();
				pst = con.prepareStatement("UPDATE djeoi.melodia SET secuenciaintroducida = ? SET secuenciamusical = ? WHERE id=? ");
				pst.setString(1, valorActualizado);
				pst.setString(2, MelodiaService.traducirSecuencia(valorActualizado));
				pst.setInt(3, melodia.getId());

			} else if (!campoIntroducido.equalsIgnoreCase("salir")) {
				System.out.println("Campo invalido");
			}

			Integer filasAfectadas = pst.executeUpdate();
			System.out.println("Filas actualizadas: ".concat(filasAfectadas.toString()));

		} while (!campoIntroducido.equalsIgnoreCase("salir"));
	}
	
	public static String introducirSecuencia(){
		System.out.println("Introduzca la secuencia de letras:");
		String secuenciaIntroducida = sctexto.nextLine();
		if(secuenciaIntroducida.length()<150) {
			
		}else {
			System.out.println("Su secuencia es demasiado larga\n"
					+ " solo puede tener 150 caracteres. \n"
					+ "Introduzca una secuencia más corta, por favor.");
			secuenciaIntroducida = introducirSecuencia();
		}
		
		return secuenciaIntroducida;
	}
	public static String introducirInstrumento(){
		
		System.out.println("¿Quiere elegir instrumento? SI/NO");
		String eleccion = sctexto.nextLine();
		String instrumentoElegido = " ";
		if(eleccion.equalsIgnoreCase("si")) {
			System.out.println("¿Qué instrumento quiere?");
			for(Instrumento instrumento : Instrumento.values()) {
				System.out.print(instrumento.toString().concat(" "));
			}
			String instrumentoIntroducido = sctexto.nextLine();
			instrumentoElegido = MelodiaService.elegirInstrumento(instrumentoIntroducido);
		}
		
		return instrumentoElegido;
	}
	
//	public Integer introducirId() {
//		System.out.println("Introduzca el ID de la melodía:");
//		Integer id = scnumero.nextInt();
//		return id;
//	}
	
}
