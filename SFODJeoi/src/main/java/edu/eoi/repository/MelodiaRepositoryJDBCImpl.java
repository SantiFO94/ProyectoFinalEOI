package edu.eoi.repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import edu.eoi.controller.ValidarNombre;
import edu.eoi.entity.Melodia;
import edu.eoi.main.GestionMelodias;
import edu.eoi.utils.DataUtilities;
import edu.eoi.utils.InputMelodia;

public class MelodiaRepositoryJDBCImpl implements MelodiaRepository {

	private static Scanner sctexto = new Scanner(System.in);

	public void save(Melodia melodia) {
		Connection con = DataUtilities.openConnection();
		try {
			PreparedStatement pst = con.prepareStatement("INSERT INTO djeoi.melodia (nombre, secuenciaIntroducida) VALUES (?, ?)");

			pst.setString(1, melodia.getNombre());
			pst.setString(2, melodia.getSecuenciaIntroducida());

			Integer filasAfectadas = pst.executeUpdate();
			System.out.println("Filas introducidas: ".concat(filasAfectadas.toString()));

		} catch (SQLException e) {
			System.out.println("Ha habido un problema con la base de datos.");
			e.printStackTrace();
		}
		DataUtilities.closeConnection(con);
	}

	public Melodia read(String nombre) {
		Connection con = DataUtilities.openConnection();
		Melodia melodia = new Melodia(null, null);

		try {

			PreparedStatement pst = con.prepareStatement("SELECT * FROM djeoi.melodia WHERE nombre=?");
			pst.setString(1, nombre);

			ResultSet rs = pst.executeQuery();

			while (rs.next()) {

				melodia = recuperarMelodia(rs);

			}

		} catch (SQLException e) {
			System.out.println("Ha habido un problema con la base de datos.");
			e.printStackTrace();
		} catch (NullPointerException e1) {
			System.out.println("no se ha encontrado el nombre.");
		}

		DataUtilities.closeConnection(con);

		return melodia;
	}

	public void delete(Melodia melodia) {
		Connection con = DataUtilities.openConnection();
		try {

			PreparedStatement pst = con.prepareStatement("DELETE FROM djeoi.melodia WHERE nombre = ?");
			pst.setString(1, melodia.getNombre());

			Integer filasAfectadas = pst.executeUpdate();
			System.out.println("Filas eliminadas: ".concat(filasAfectadas.toString()));

		} catch (SQLException e) {
			System.out.println("Ha habido un problema con la base de datos.");
			e.printStackTrace();
		}

		DataUtilities.closeConnection(con);

	}

	public Melodia update(Melodia melodia) {
		Connection con = DataUtilities.openConnection();
		try {
			modificarMelodia(con, melodia);
			System.out.println("Ha terminado sus modificaciones.");
		} catch (SQLException e) {
			System.out.println("Ha habido un problema con la base de datos.");
			e.printStackTrace();
		}

		DataUtilities.closeConnection(con);

		melodia = read(melodia.getNombre());

		return melodia;
	}
	public static void modificarMelodia(Connection con, Melodia melodia) throws SQLException{
		String campoIntroducido = null;
		Integer filasAfectadas = 0;
		do {
			campoIntroducido = " ";
			String valorActualizado = " ";
			PreparedStatement pst = null;
			System.out.println("Introduzca el campo que quiere modificar:");
			System.out.println("(nombre, secuencia introducida)");
			System.out.println("Si quiere dejar de modificar escriba SALIR");
			campoIntroducido = sctexto.nextLine();
			
			if (campoIntroducido.equalsIgnoreCase("nombre")) {
				
				System.out.println("Introduzca el nuevo valor:");
				valorActualizado = sctexto.nextLine();
				if(!ValidarNombre.comprobarNombreExistente(valorActualizado)) {
					pst = con.prepareStatement("UPDATE djeoi.melodia SET nombre = ? WHERE nombre=? ");
					pst.setString(1, valorActualizado);
					pst.setString(2, melodia.getNombre());
				}else {
					System.out.println("Ese nombre ya existe, escoja otro por favor.\n");
				}
				
			} else if (campoIntroducido.equalsIgnoreCase("secuencia Introducida")) {
				
				valorActualizado = InputMelodia.introducirSecuencia();
				pst = con.prepareStatement("UPDATE djeoi.melodia SET secuenciaintroducida = ? WHERE nombre=? ");
				pst.setString(1, valorActualizado);
				pst.setString(2, melodia.getNombre());

			} else if (!campoIntroducido.equalsIgnoreCase("salir")) {
				System.out.println("Campo invalido");
			}
			
			filasAfectadas += pst.executeUpdate();

		} while (!campoIntroducido.equalsIgnoreCase("salir"));
		System.out.println("Filas actualizadas: ".concat(filasAfectadas.toString()));

	}
	public List<Melodia> recuperarMelodias() {
		Connection con = DataUtilities.openConnection();
		List<Melodia> melodias = new ArrayList<Melodia>();
		try {

			PreparedStatement pst = null;

			pst = con.prepareStatement("SELECT * FROM djeoi.melodia");

			ResultSet rs = pst.executeQuery();

			while (rs.next()) {

				melodias.add(recuperarMelodia(rs));
			}

		} catch (SQLException e) {
			System.out.println("Ha habido un problema con la base de datos.");
			e.printStackTrace();
		}

		DataUtilities.closeConnection(con);
		
		GestionMelodias.mostrarMelodias(melodias);
		
		return melodias;
	}

	public static Melodia recuperarMelodia(ResultSet rs) throws SQLException {
		Melodia melodia = new Melodia(null, null);

		melodia.setNombre(rs.getString("nombre"));
		melodia.setSecuenciaIntroducida(rs.getString("secuenciaintroducida"));

		return melodia;
	}
}
