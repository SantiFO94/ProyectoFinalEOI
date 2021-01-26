package edu.eoi.repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import edu.eoi.entity.Gato;
import edu.eoi.entity.Mascota;
import edu.eoi.entity.Perro;
import edu.eoi.entity.Responsable;
import edu.eoi.entity.TipoDeMascota;
import edu.eoi.main.ControlTipoDeMascota;
import edu.eoi.service.ResponsableService;
import edu.eoi.utils.DataUtilities;

public class MascotaRepositoryJDBCImpl implements MascotaRepository {

	static ResponsableService ResponsableService = new ResponsableService();
	private static Scanner sctexto = new Scanner(System.in);

	public void save(Mascota mascota) {

		Connection con = DataUtilities.openConnection();
		try {
			PreparedStatement pst = con.prepareStatement("INSERT INTO MASCOTA (imagen, nombre, ubicacion, descripcion, idResponsable, tipoDeMascota, edad) VALUES (?, ?, ?, ?, ?, ?, ?)");

			pst.setString(1, mascota.getImagen());
			pst.setString(2, mascota.getNombre());
			pst.setString(3, mascota.getUbicacion());
			pst.setString(4, mascota.getDescripcion());
			pst.setInt(5, mascota.getIdResponsable());
			pst.setString(6, mascota.getTipoDeMascota().toString());

			switch (mascota.getTipoDeMascota()) {
			case PERRO:
				pst.setString(7, ((Perro) mascota).getEdad());
				break;
			case GATO:
				pst.setString(7, ((Gato) mascota).getEdad());
				break;
			default:
				break;
			}

			Integer filasAfectadas = pst.executeUpdate();
			System.out.println("Filas introducidas: ".concat(filasAfectadas.toString()));

		} catch (SQLException e) {
			System.out.println("Ha habido un problema con la base de datos.");
			e.printStackTrace();
		}
		DataUtilities.closeConnection(con);
	}

	public Mascota read(Integer id) {
		Connection con = DataUtilities.openConnection();
		Mascota mascota = null;

		try {

			PreparedStatement pst = con.prepareStatement("SELECT * FROM mascota WHERE id=?");
			pst.setInt(1, id);

			ResultSet rs = pst.executeQuery();

			while (rs.next()) {

				mascota = recuperarMascota(rs);

			}

		} catch (SQLException e) {
			System.out.println("Ha habido un problema con la base de datos.");
			e.printStackTrace();
		}

		DataUtilities.closeConnection(con);

		return mascota;
	}

	public void delete(Mascota mascota) {
		Connection con = DataUtilities.openConnection();
		try {

			PreparedStatement pst = con.prepareStatement("DELETE FROM mascota WHERE id = ?");
			pst.setInt(1, mascota.getId());

			Integer filasAfectadas = pst.executeUpdate();
			System.out.println("Filas eliminadas: ".concat(filasAfectadas.toString()));

		} catch (SQLException e) {
			System.out.println("Ha habido un problema con la base de datos.");
			e.printStackTrace();
		}

		DataUtilities.closeConnection(con);

	}

	public Mascota update(Mascota mascota) {
		Connection con = DataUtilities.openConnection();
		try {
			String campoIntroducido = null;
			String valorActualizado = null;
			PreparedStatement pst = null;

			do {
				System.out.println("Introduzca el campo que quiere modificar:");
				System.out.println("(imagen, nombre, ubicacion, descripcion, responsable, tipo de mascota, edad)");
				System.out.println("Si quiere dejar de modificar escriba SALIR");
				campoIntroducido = sctexto.nextLine();
				if (!campoIntroducido.equalsIgnoreCase("salir")) {
					System.out.println("Introduzca el nuevo valor:");
					valorActualizado = sctexto.nextLine();
				}

				if (campoIntroducido.equalsIgnoreCase("responsable")) {
					Responsable responsable = ResponsableService.read(mascota.getIdResponsable());
					ResponsableService.update(responsable);

				} else if (campoIntroducido.equalsIgnoreCase("tipo de mascota")) {

					pst = con.prepareStatement(
							"UPDATE mascota SET ".concat(" tipoDeMascota = ? ").concat(" WHERE id=? "));
					pst.setString(1, valorActualizado);
					pst.setInt(2, mascota.getId());

				} else if (campoIntroducido.equalsIgnoreCase("imagen") || campoIntroducido.equalsIgnoreCase("nombre")
						|| campoIntroducido.equalsIgnoreCase("ubicacion")
						|| campoIntroducido.equalsIgnoreCase("descripcion")
						|| campoIntroducido.equalsIgnoreCase("edad")) {

					pst = con.prepareStatement(
							"UPDATE mascota SET ".concat(campoIntroducido).concat("= ? ").concat("WHERE id=? "));
					pst.setString(1, valorActualizado);
					pst.setInt(2, mascota.getId());

				} else if (!campoIntroducido.equalsIgnoreCase("salir")) {
					System.out.println("Campo invalido");
				}

				Integer filasAfectadas = pst.executeUpdate();
				System.out.println("Filas actualizadas: ".concat(filasAfectadas.toString()));

			} while (!campoIntroducido.equalsIgnoreCase("salir"));
			System.out.println("Ha terminado sus modificaciones.");
		} catch (SQLException e) {
			System.out.println("Ha habido un problema con la base de datos.");
			e.printStackTrace();
		}

		DataUtilities.closeConnection(con);

		mascota = read(mascota.getId());

		return mascota;
	}

	public List<Mascota> recuperarMascotas(TipoDeMascota tipoDeMascota) {

		Connection con = DataUtilities.openConnection();
		List<Mascota> mascotas = new ArrayList<Mascota>();
		try {
			PreparedStatement pst = null;
			try {
				pst = con.prepareStatement("SELECT * FROM mascota WHERE tipoDeMascota='".concat(tipoDeMascota.toString()).concat("'"));
			} catch (NullPointerException e) {
				pst = con.prepareStatement("SELECT * FROM mascota");
				System.out.println("Generando informes de todas las mascotas...\n");
			}

			ResultSet rs = pst.executeQuery();

			while (rs.next()) {
				mascotas.add(recuperarMascota(rs));
			}

		} catch (SQLException e) {
			System.out.println("Ha habido un problema con la base de datos.\n");
			e.printStackTrace();
		}

		DataUtilities.closeConnection(con);
		return mascotas;
	}

	public static Mascota recuperarMascota(ResultSet rs) throws SQLException {
		Mascota mascota = null;
		TipoDeMascota tipoDeMascota = null;

		tipoDeMascota = ControlTipoDeMascota.elegirTipo(rs.getString("tipoDeMascota"));

		mascota = ControlTipoDeMascota.instanciarMascota(tipoDeMascota);

		mascota.setId(rs.getInt("id"));
		mascota.setImagen(rs.getString("imagen"));
		mascota.setNombre(rs.getString("nombre"));
		mascota.setUbicacion(rs.getString("ubicacion"));
		mascota.setDescripcion(rs.getString("descripcion"));
		mascota.setIdResponsable(rs.getInt("idResponsable"));
		mascota.setEdad(rs.getString("edad"));
		
		return mascota;
	}

}
