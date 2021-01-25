package edu.eoi.repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import edu.eoi.entity.Premio;

public class PremioRepository {

	public static void crearPremiosPrincipales(List<Premio> premios) {
		
		for(int i=1 ; i <= 13 ; i++) {
			
			switch(i) {
			case 1:
				asignarPremioPrincipal(4000000, premios);
				break;
			case 2:
				asignarPremioPrincipal(1250000, premios);
				break;
			case 3:
				asignarPremioPrincipal(500000, premios);
				break;
			case 4:
			case 5:
				asignarPremioPrincipal(200000, premios);
				break;
			case 6:
			case 7:
			case 8:
			case 9:
			case 10:
			case 11:
			case 12:
			case 13:
				asignarPremioPrincipal(60000, premios);
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

	public static void asignarPremiosAdyacentes(List<Premio> premios) {
		
		Premio premio = null;
		List<Premio> primerosPremios = obtenerTresPrimerosPremios(premios);
		
		for (Premio premioEvaluado : primerosPremios) {
			//1ºpremio
			if (premioEvaluado.getDinero() == 4000000) {
				//numero posterior
				premio = new Premio(20000, premioEvaluado.getNumeroPremiado() + 1);
				premios.add(premio);
				//numero anterior
				premio = new Premio(20000, premioEvaluado.getNumeroPremiado()-1);
				premios.add(premio);
			//2ºpremio
			} else if (premioEvaluado.getDinero() == 1250000) {
				//numero posterior
				premio = new Premio(12500, premioEvaluado.getNumeroPremiado() + 1);
				premios.add(premio);
				//numero anterior
				premio = new Premio(12500, premioEvaluado.getNumeroPremiado()-1);
				premios.add(premio);
			//3ºpremio
			} else if (premioEvaluado.getDinero() == 500000) {
				//numero posterior
				premio = new Premio(9600, premioEvaluado.getNumeroPremiado() + 1);
				premios.add(premio);
				//numero anterior
				premio = new Premio(9600, premioEvaluado.getNumeroPremiado()-1);
				premios.add(premio);
			}
		}
			
	}
	//no usado
	public static void asignarPremiosCoincidentes(List<Premio> premios) {
		
		List<Premio> primerosPremios = obtenerTresPrimerosPremios(premios);
		
		for(Premio premioEvaluado : primerosPremios) {
			Integer ultimasDosCifras = premioEvaluado.getNumeroPremiado()%100;
			premios.add(ultimasDosCifras, new Premio(ultimasDosCifras, 1000));
		}
	}
	//no usado
	public static List<Premio> obtenerTresPrimerosPremios(List<Premio> premios) {
		
		List<Premio> primerosPremios = new ArrayList<Premio>();
		for (Premio premioEvaluado : premios) {
			//1ºpremio
			if (premioEvaluado.getDinero() == 4000000) {
				primerosPremios.add(premioEvaluado);
			//2ºpremio
			} else if (premioEvaluado.getDinero() == 1250000) {
				primerosPremios.add(premioEvaluado);
			//3ºpremio
			} else if (premioEvaluado.getDinero() == 500000) {
				primerosPremios.add(premioEvaluado);
			}
		}
		return primerosPremios;

	}
	public static void imprimirPremios() {
		System.out.println("PREMIOS:");
		System.out.println("1º\t\t2º\t\t3º\t\t4º\t\t5º");
		for(int i = 1 ; i <= 4 ; i++) {
			switch(i) {
			case 1:
				System.out.println("4.000.000\t1.250.000\t500.000\t\t200.000\t\t60.000 60.000");
				break;
			case 2:
				System.out.println("\t\t\t\t\t\t200.000\t\t60.000 60.000");
				break;
			case 3:
				System.out.println("\t\t\t\t\t\t\t\t60.000 60.000");
				break;
			case 4:
				System.out.println("\t\t\t\t\t\t\t\t60.000 60.000");
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
					imprimirNumeroPremiado(i, premiosPrincipales);
					break;
				case 7:
					System.out.print("\t\t\t\t\t\t");
					imprimirNumeroPremiadoSeparado(4, premiosPrincipales);
					imprimirNumeroPremiado(i, premiosPrincipales);
					break;
				case 9:
				case 11:
					System.out.print("\t\t\t\t\t\t\t\t");
					imprimirNumeroPremiado(i, premiosPrincipales);
					break;
				case 6:
				case 8:
				case 10:
					imprimirNumeroPremiadoSeparado(i, premiosPrincipales);
					System.out.println();
					break;
				default:
					imprimirNumeroPremiadoSeparado(i, premiosPrincipales);
			}
			
		}
		//salto de linea
		System.out.println();
	}
	
	public static void imprimirNumeroPremiadoSeparado(int i, List<Premio> premiosPrincipales) {
		String numeroPremiado = null;
		//imprimir numero premiado
		numeroPremiado = premiosPrincipales.get(i).getNumeroPremiado().toString();
		addCeros(numeroPremiado);
		System.out.print(numeroPremiado.concat("\t\t"));
	}
	public static void imprimirNumeroPremiado(int i, List<Premio> premiosPrincipales) {
		String numeroPremiado = null;
		//imprimir numero premiado
		numeroPremiado = premiosPrincipales.get(i).getNumeroPremiado().toString();
		addCeros(numeroPremiado);
		System.out.print(numeroPremiado.concat(" "));
	}
	public static void addCeros(String numeroPremiado) {
		int length = numeroPremiado.length();
		switch(length) {
		case 1:
			System.out.print("0000");
			break;
		case 2:
			System.out.print("000");
			break;
		case 3:
			System.out.print("00");
			break;
		case 4:
			System.out.print("0");
			break;
		}
	}
	public static void evaluarNumeroAceptado (Integer numeroAceptado, List<Premio> premiosPrincipales) {
		boolean ganador = false;
		for (Premio premioEvaluado : premiosPrincipales) {
			if (numeroAceptado.equals(premioEvaluado.getNumeroPremiado())) {
				if (premioEvaluado.getDinero().equals(4000000)) {
					System.out.println("¡Enhorabuena! Has ganado el 1º Premio (".concat(premioEvaluado.getDinero().toString()).concat(")€."));
				//2ºpremio
				} else if (premioEvaluado.getDinero().equals(1250000)) {
					System.out.println("¡Enhorabuena! Has ganado el 2º Premio (".concat(premioEvaluado.getDinero().toString()).concat(")€."));
				//3ºpremio
				} else if (premioEvaluado.getDinero().equals(500000)) {
					System.out.println("¡Enhorabuena! Has ganado el 3º Premio (".concat(premioEvaluado.getDinero().toString()).concat(")€."));
				} else if (premioEvaluado.getDinero().equals(200000)) {
					System.out.println("¡Enhorabuena! Has ganado el 4º Premio (".concat(premioEvaluado.getDinero().toString()).concat(")€."));
				} else if (premioEvaluado.getDinero().equals(60000)) {
					System.out.println("¡Enhorabuena! Has ganado el 3º Premio (".concat(premioEvaluado.getDinero().toString()).concat(")€."));
				}
				ganador = true;
			} else if (numeroAceptado.equals((premioEvaluado.getNumeroPremiado()) + 1) ||
					numeroAceptado.equals((premioEvaluado.getNumeroPremiado()) - 1)) {
				if (premioEvaluado.getDinero().equals(4000000)) {
					System.out.println("¡Enhorabuena! Has ganado el premio adyacente al 1º Premio (20000€).");
				//2ºpremio
				} else if (premioEvaluado.getDinero().equals(1250000)) {
					System.out.println("¡Enhorabuena! Has ganado el premio adyacente al 2º Premio (12500€).");
				//3ºpremio
				} else if (premioEvaluado.getDinero().equals(500000)) {
					System.out.println("¡Enhorabuena! Has ganado el premio adyacente al 3º Premio (9600€).");
				}
				ganador = true;
			} else if ((numeroAceptado%100) == (premioEvaluado.getNumeroPremiado()%100)) {
				if (premioEvaluado.getDinero().equals(4000000) || premioEvaluado.getDinero().equals(1250000) || premioEvaluado.getDinero().equals(500000)) {
					System.out.println("¡Enhorabuena! Has ganado el premio de las últimas dos cifras (1000€).");
				}
				ganador = true;
			}
		}
		if(!ganador) {
			System.out.println("Lo sentimos, su numero no ha resultado premiado.");

		}

	}
}
