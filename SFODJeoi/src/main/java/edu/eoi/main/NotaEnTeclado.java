package edu.eoi.main;

public enum NotaEnTeclado {
//blancas
	Q("q","Cw"),
	W("w","Dw"),
	E("e","Ew"),
	R("r","Fw"),
	T("t","Gw"),
	Y("y","Aw"),
	U("u","Bw"),
//negras	
	A("a","Ch"),
	S("s","Dh"),
	D("d","Eh"),
	F("f","Fh"),
	G("g","Gh"),
	H("h","Ah"),
	J("j","Bh"),
//corcheas	
	Z("z","Cq"),
	X("x","Dq"),
	C("c","Eq"),
	V("v","Fq"),
	B("b","Gq"),
	N("n","Aq"),
	M("m","Bq");
	
	public final String letra;
	public final String nota;
	
	private NotaEnTeclado(String letra, String nota) {
		this.letra = letra;
		this.nota = nota;
		
	}
}
