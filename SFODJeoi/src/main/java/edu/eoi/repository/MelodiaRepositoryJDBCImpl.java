package edu.eoi.repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import edu.eoi.entity.Melodia;
import edu.eoi.utils.DataUtilities;
import edu.eoi.utils.InputMelodiaUtilities;

public class MelodiaRepositoryJDBCImpl implements MelodiaRepository {

	public void save(Melodia melodia) {
		Connection con = DataUtilities.openConnection();
		try {
			PreparedStatement pst = con.prepareStatement(
					"INSERT INTO djeoi.melodia (nombre, secuenciaIntroducida, secuenciaMusical) VALUES (?, ?, ?)");

			pst.setString(1, melodia.getNombre());
			pst.setString(2, melodia.getSecuenciaIntroducida());
			pst.setString(3, melodia.getSecuenciaMusical());

			Integer filasAfectadas = pst.executeUpdate();
			System.out.println("Filas introducidas: ".concat(filasAfectadas.toString()));

		} catch (SQLException e) {
			System.out.println("Ha habido un problema con la base de datos.");
			e.printStackTrace();
		}
		DataUtilities.closeConnection(con);
	}

	public Melodia read(Integer id) {
		Connection con = DataUtilities.openConnection();
		Melodia melodia = new Melodia(null, null);

		try {

			PreparedStatement pst = con.prepareStatement("SELECT * FROM djeoi.melodia WHERE id=?");
			pst.setInt(1, id);

			ResultSet rs = pst.executeQuery();

			while (rs.next()) {

				melodia = recuperarMelodia(rs);

			}

		} catch (SQLException e) {
			System.out.println("Ha habido un problema con la base de datos.");
			e.printStackTrace();
		}

		DataUtilities.closeConnection(con);

		return melodia;
	}

	public void delete(Melodia melodia) {
		Connection con = DataUtilities.openConnection();
		try {

			PreparedStatement pst = con.prepareStatement("DELETE FROM djeoi.melodia WHERE id = ?");
			pst.setInt(1, melodia.getId());

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
			InputMelodiaUtilities.modificarMelodia(con, melodia);
			System.out.println("Ha terminado sus modificaciones.");
		} catch (SQLException e) {
			System.out.println("Ha habido un problema con la base de datos.");
			e.printStackTrace();
		}

		DataUtilities.closeConnection(con);

		melodia = read(melodia.getId());

		return melodia;
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
		for(Melodia melodia : melodias) {
			System.out.println("Melodia: ".concat(melodia.getId().toString()).concat(" ").concat(melodia.getNombre())
					.concat("\n Secuencia introducida: ").concat(melodia.getSecuenciaIntroducida())
					.concat("\n Secuencia de notas: ").concat(melodia.getSecuenciaMusical()).concat("\n"));
		}
		return melodias;
	}

	public static Melodia recuperarMelodia(ResultSet rs) throws SQLException {
		Melodia melodia = new Melodia(null, null);

		melodia.setId(rs.getInt("id"));
		melodia.setNombre(rs.getString("nombre"));
		melodia.setSecuenciaIntroducida(rs.getString("secuenciaintroducida"));
		melodia.setSecuenciaMusical(rs.getString("secuenciamusical"));

		return melodia;
	}
}
