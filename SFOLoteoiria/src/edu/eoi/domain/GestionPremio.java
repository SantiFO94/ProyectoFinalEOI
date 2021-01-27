package edu.eoi.domain;

import java.text.NumberFormat;
import java.util.List;
import java.util.Locale;
import java.util.Random;

import edu.eoi.entity.Premio;
import edu.eoi.enums.DineroGanado;

public class GestionPremio {

	public static final NumberFormat nf = NumberFormat.getInstance(new Locale("da","DK"));
	
	public static void crearPremiosPrincipales(List<Premio> premios) {
		
		for(int i=1 ; i <= 13 ; i++) {
			
			switch(i) {
			case 1:
				asignarPremioPrincipal(DineroGanado.primerPremio.dinero, premios);
				break;
			case 2:
				asignarPremioPrincipal(DineroGanado.segundoPremio.dinero, premios);
				break;
			case 3:
				asignarPremioPrincipal(DineroGanado.tercerPremio.dinero, premios);
				break;
			case 4:
			case 5:
				asignarPremioPrincipal(DineroGanado.cuartoPremio.dinero, premios);
				break;
			case 6:
			case 7:
			case 8:
			case 9:
			case 10:
			case 11:
			case 12:
			case 13:
				asignarPremioPrincipal(DineroGanado.quintoPremio.dinero, premios);
				break;				
			}
		}
	}
	
	public static void asignarPremioPrincipal(Integer dinero, List<Premio> premios) {
		
		Integer random = generarNumeroAleatorio(premios);
		
		Premio premio= new Premio(dinero, random);
		premios.add(premio);
		
	}
	
	public static Integer generarNumeroAleatorio(List<Premio> premios) {
		
		Integer random = null;
		boolean repetir = false;
		do {
			repetir = false;
			random = new Random().nextInt(99999);
			//evitar numeros repetidos
			for(Premio premioTemporal : premios) {
				if(premioTemporal.getNumeroPremiado() == random) {
					repetir = true;
				}
			}
		}while (repetir);
		return random;
	}

	public static void imprimirPremios() {
		System.out.println("PREMIOS:");
		System.out.println("1º\t\t2º\t\t3º\t\t4º\t\t5º");
		for(int i = 1 ; i <= 4 ; i++) {
			switch(i) {
			case 1:
				System.out.println(nf.format(DineroGanado.primerPremio.dinero).concat("\t")
						.concat(nf.format(DineroGanado.segundoPremio.dinero)).concat("\t")
						.concat(nf.format(DineroGanado.tercerPremio.dinero)).concat("\t\t")
						.concat(nf.format(DineroGanado.cuartoPremio.dinero)).concat("\t\t")
						.concat(nf.format(DineroGanado.quintoPremio.dinero)).concat(" ")
						.concat(nf.format(DineroGanado.quintoPremio.dinero)));
				break;
			case 2:
				System.out.println("\t\t\t\t\t\t"
						.concat(nf.format(DineroGanado.cuartoPremio.dinero)).concat("\t\t")
						.concat(nf.format(DineroGanado.quintoPremio.dinero)).concat(" ")
						.concat(nf.format(DineroGanado.quintoPremio.dinero)));
				break;
			case 3:
				System.out.println("\t\t\t\t\t\t\t\t"
						.concat(nf.format(DineroGanado.quintoPremio.dinero)).concat(" ")
						.concat(nf.format(DineroGanado.quintoPremio.dinero)));
				break;
			case 4:
				System.out.println("\t\t\t\t\t\t\t\t"
						.concat(nf.format(DineroGanado.quintoPremio.dinero)).concat(" ")
						.concat(nf.format(DineroGanado.quintoPremio.dinero)));
				break;
			}
		}
	}
	
	public static void imprimirTodosLosNumerosPremiados(List<Premio> premiosPrincipales) {
		System.out.println("NÚMEROS PREMIADOS:");
		System.out.println("1º\t\t2º\t\t3º\t\t4º\t\t5º"); 
		
		for(int i = 0 ; i < 13 ; i++) {
			
			switch(i) {
				case 4:
					i=5;
					Formato.imprimirNumeroPremiado(i, premiosPrincipales);
					break;
				case 7:
					System.out.print("\t\t\t\t\t\t");
					Formato.imprimirNumeroPremiadoSeparado(4, premiosPrincipales);
					Formato.imprimirNumeroPremiado(i, premiosPrincipales);
					break;
				case 9:
				case 11:
					System.out.print("\t\t\t\t\t\t\t\t");
					Formato.imprimirNumeroPremiado(i, premiosPrincipales);
					break;
				case 6:
				case 8:
				case 10:
					Formato.imprimirNumeroPremiadoSeparado(i, premiosPrincipales);
					System.out.println();
					break;
				default:
					Formato.imprimirNumeroPremiadoSeparado(i, premiosPrincipales);
			}
		}
		//salto de linea
		System.out.println();
	}
	
	public static void evaluarNumeroAceptado (Integer numeroAceptado, List<Premio> premiosPrincipales) {
		boolean ganador = false;
		for (Premio premioEvaluado : premiosPrincipales) {
			//premios principales
			if (numeroAceptado.equals(premioEvaluado.getNumeroPremiado())) {
				Ganador.mostrarPremioPrincipalGanado(premioEvaluado);
				ganador = true;
			//premios adyacentes
			} else if (numeroAceptado.equals((premioEvaluado.getNumeroPremiado()) + 1) ||
					numeroAceptado.equals((premioEvaluado.getNumeroPremiado()) - 1)) {
				Ganador.mostrarPremioAdyacenteGanado(premioEvaluado);
				ganador = true;
			//premios coincidentes
			} else if ((numeroAceptado%100) == (premioEvaluado.getNumeroPremiado()%100)) {
				Ganador.mostrarPremioCoincidenteGanado(premioEvaluado);
				ganador = true;
			}
		}
		if(!ganador) {
			System.out.println("Lo sentimos, su numero no ha resultado premiado.");

		}

	}
}
