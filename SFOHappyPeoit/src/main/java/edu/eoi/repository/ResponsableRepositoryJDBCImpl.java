package edu.eoi.repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import edu.eoi.entity.Responsable;
import edu.eoi.utils.DataUtilities;

public class ResponsableRepositoryJDBCImpl implements ResponsableRepository {
	private static Scanner sctexto = new Scanner(System.in);

	public void save(Responsable responsable) {
		Connection con=DataUtilities.openConnection();
		try {
			PreparedStatement pst = con.prepareStatement("INSERT INTO responsable (id, nombre, telefono) VALUES (?, ?, ?)");

			pst.setInt(1, responsable.getId());
			pst.setString(2, responsable.getNombre());
			pst.setInt(3, responsable.getTelefono());

			Integer filas = pst.executeUpdate();
			System.out.println("Filas introducidas: ".concat(filas.toString()));
			
		} catch (SQLException e) {
			System.out.println("Ha habido un problema con la base de datos.");
			e.printStackTrace();
		}
		
		DataUtilities.closeConnection(con);
	}

	public Responsable read(Integer id) {
		Connection con = DataUtilities.openConnection();
		Responsable responsable = new Responsable(null, null, null);

		try {

			PreparedStatement pst = con.prepareStatement("SELECT * FROM responsable WHERE id=?");
			pst.setInt(1, id);

			ResultSet rs = pst.executeQuery();

			while (rs.next()) {
				responsable = recuperarResponsable(rs);

			}

		} catch (SQLException e) {
			System.out.println("Ha habido un problema con la base de datos.");
			e.printStackTrace();
		}

		DataUtilities.closeConnection(con);
		return responsable;
	}

	public void delete(Responsable responsable) {
		Connection con=DataUtilities.openConnection();
		try {

			PreparedStatement pst = con.prepareStatement("DELETE * FROM responsable WHERE id=?");
			pst.setInt(1, responsable.getId());

			Integer filasAfectadas = pst.executeUpdate();
			System.out.println("Filas eliminadas: ".concat(filasAfectadas.toString()));


		} catch (SQLException e) {
			System.out.println("Ha habido un problema con la base de datos.");
			e.printStackTrace();
		}
		
		DataUtilities.closeConnection(con);
	}

	public Responsable update(Responsable responsable) {
		Connection con = DataUtilities.openConnection();
		try {
			String campoIntroducido = null;
			String valorActualizado = null;
			PreparedStatement pst = null;

			do {

				System.out.println("Indique el campo que quiere modificar:");
				System.out.println("(nombre, telefono)");
				System.out.println("Si quiere dejar de modificar escriba SALIR");
				campoIntroducido = sctexto.nextLine();
				System.out.println("Introduzca el nuevo valor:");
				valorActualizado = sctexto.nextLine();

				if (campoIntroducido.equalsIgnoreCase("nombre")) {
					pst = con.prepareStatement(
							"UPDATE responsable SET ".concat(campoIntroducido).concat("= ? ").concat(" WHERE id=?"));
					pst.setString(1, valorActualizado);
					pst.setInt(2, responsable.getId());

				} else if (campoIntroducido.equalsIgnoreCase("telefono")) {
					pst = con.prepareStatement(
							"UPDATE responsable SET ".concat(campoIntroducido).concat("= ? ").concat(" WHERE id=?"));
					pst.setString(1, valorActualizado);
					pst.setInt(2, responsable.getId());
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
		return responsable;
	}
	
	public List<Responsable> recuperarResponsables() {

		Connection con = DataUtilities.openConnection();
		List<Responsable> responsable = new ArrayList<Responsable>();
		try {

			PreparedStatement pst = null;
			
			pst = con.prepareStatement("SELECT * FROM responsable");

			ResultSet rs = pst.executeQuery();

			while (rs.next()) {
				responsable.add(recuperarResponsable(rs));
			}

		} catch (SQLException e) {
			System.out.println("Ha habido un problema con la base de datos.");
			e.printStackTrace();
		}

		DataUtilities.closeConnection(con);
		return responsable;
	}

	public static Responsable recuperarResponsable(ResultSet rs) throws SQLException {
		Responsable responsable = new Responsable(null, null, null);

		responsable.setId(rs.getInt("id"));
		responsable.setNombre(rs.getString("nombre"));
		responsable.setTelefono(rs.getInt("telefono"));

		return responsable;
	}
}
