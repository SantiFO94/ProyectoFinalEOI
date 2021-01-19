package AppAleoixa;

public enum Comando {

	DIA("�Qu� d�a es?"),
	HORA("�Qu� hora es?"),
	CHISTE("Cuentame un chiste"),
	CALCULADORA("Calcula"),
	TRADUCTOR("Traduce"),
	AYUDA("Help"),
	SALIR("Salir");
	
	public final String comando;
	
	private Comando(String comando) {
		this.comando = comando;
	}
	
}
