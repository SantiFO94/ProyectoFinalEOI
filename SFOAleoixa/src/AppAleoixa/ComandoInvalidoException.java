package AppAleoixa;

public class ComandoInvalidoException extends Exception {

	private static final long serialVersionUID = 1L;

	public ComandoInvalidoException(String message) {
		super(message);
		// TODO Auto-generated constructor stub
	}
	
	 void comprobarComando(String instruccion) throws ComandoInvalidoException{
			
		for (Comando comando : Comando.values()) {
			 
		}
		if(!instruccion.equals(Comando.AYUDA.comando)){
				throw new ComandoInvalidoException("Product Invalid");
		}
	 }

}
