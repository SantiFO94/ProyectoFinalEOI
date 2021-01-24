package edu.eoi.repository;

import edu.eoi.entity.Gato;
import edu.eoi.entity.Mascota;
import edu.eoi.entity.Otro;
import edu.eoi.entity.Perro;
import edu.eoi.entity.TipoDeMascota;

public class TipoDeMascotaRepository {

	public static TipoDeMascota elegirTipo(String tipoIntroducido) {

		TipoDeMascota tipoDeMascota = null;

		for (TipoDeMascota tipoDeMascotaTemporal : TipoDeMascota.values()) {
			if (tipoIntroducido.equalsIgnoreCase(tipoDeMascotaTemporal.toString())) {
				tipoDeMascota = tipoDeMascotaTemporal;
			}
		}

		return tipoDeMascota;
	}

	public static Mascota instanciarMascota(TipoDeMascota tipoDeMascota) {
		Mascota mascota = null;
		switch (tipoDeMascota) {
		case PERRO:
			mascota = new Perro(null, null, null, null, null, null);
			break;
		case GATO:
			mascota = new Gato(null, null, null, null, null, null);
			break;
		default:
			mascota = new Otro(null, null, null, null, null, null);
			break;
		}
		return mascota;
	}
}
