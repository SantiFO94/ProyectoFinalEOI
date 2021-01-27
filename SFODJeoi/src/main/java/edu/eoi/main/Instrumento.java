package edu.eoi.main;

public enum Instrumento {

	PIANO("I[PIANO] "),
	XILOFONO("I[XYLOPHONE] "),
	TROMPETA("I[TRUMPET] "),
	CORO("I[CHOIR] "),
	GUITARRA("I[GUITAR] "),
	BAJO("I[ACOUSTIC_BASS] "),
	HARMONICA("I[HARMONICA] "),
	VIOLIN("I[VIOLIN] "),
	FLAUTA("I[FLUTE] "),
	SILBIDO("I[WHISTLE] "),
	GAITA("I[BAGPIPE] ");
	
	public final String codigoInstrumento;
	
	private Instrumento(String codigoInstrumento) {
		this.codigoInstrumento=codigoInstrumento;
	}
	
}
