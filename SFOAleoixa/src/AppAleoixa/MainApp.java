package AppAleoixa;

import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

import edu.eoi.repository.Comando;
import edu.eoi.repository.Repository;

public class MainApp {

	public static void main(String[] args) {
		
		Comando selection;
		do {
			selection = Repository.elegirComando();
			switch(selection) {
			
				case DIA:
					Repository.decirFecha();
					break;
					
				case HORA:
					Repository.decirHora();
					break;
					
				case CHISTE:
					Repository.contarChiste();
					break;
					
				case CALCULADORA:
					Repository.calcular();
					break;
					
				case TRADUCTOR:
					Repository.traducir();
					break;
					
				case AYUDA:
					Repository.help();
					break;
					
				case SALIR:
					System.out.println("¡Hasta pronto!");
					Repository.loguear("ALEOIXA", "¡Hasta pronto!");
					break;
			}
			
		}while (!selection.comando.equals("Salir"));

	}

}
