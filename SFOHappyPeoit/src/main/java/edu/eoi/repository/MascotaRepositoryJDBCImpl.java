package edu.eoi.repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import edu.eoi.entity.Mascota;
import edu.eoi.entity.Perro;
import edu.eoi.utils.DataUtilities;

public class MascotaRepositoryJDBCImpl implements MascotaRepository{

	public void save(Mascota mascota) {
		
		Connection con=DataUtilities.openConnection();
		try {
			PreparedStatement pst = null;
			switch(mascota.getTipoDeMascota()) {
				case PERRO:
					pst= con.prepareStatement("INSERT INTO perro (imagen, nombre, ubicacion, descripcion, nombreResponsable, telefonoResponsable, tipoDeMascota, edad) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?)");
					break;
				case GATO:
					pst = con.prepareStatement("INSERT INTO gato (imagen, nombre, ubicacion, descripcion, nombreResponsable, telefonoResponsable, tipoDeMascota, edad) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?)");
					break;
				case OTRO:
					 pst = con.prepareStatement("INSERT INTO otro (imagen, nombre, ubicacion, descripcion, nombreResponsable, telefonoResponsable, tipoDeMascota) VALUES (?, ?, ?, ?, ?, ?, ?, ?)");
					break;
			}
			pst.setString(1, mascota.getImagen());
			pst.setString(1, mascota.getNombre());
			pst.setString(1, mascota.getUbicacion());
			pst.setString(1, mascota.getDescripcion());
			pst.setString(1, mascota.getNombreResponsable());
			pst.setInt(1, mascota.getTelefonoResponsable());
			pst.setString(1, mascota.getTipoDeMascota().toString());
			
			switch(mascota.getTipoDeMascota()) {
				case PERRO:
				case GATO:
					pst.setInt(1, ((Perro) mascota).getEdad());
					break;
				default:
					break;
			}
		
		} catch (SQLException e) {		
			e.printStackTrace();
		}
		DataUtilities.closeConnection(con);
	}

	public Mascota read(Integer sf) {
		Mascota mascota = null;
		
		Connection con=DataUtilities.openConnection();
		try {
			PreparedStatement st = con.prepareStatement("SELECT u.id,u.username,u.password,u.name,u.surname,r.id,r.name,r.description FROM user u LEFT JOIN recipe r ON u.id=r.idUser WHERE u.username=?");
			st.setString(1, sf);
			
			ResultSet rs=st.executeQuery();			
			while(rs.next()) {
				
				mascota=new Mascota();
				mascota.setId(rs.getInt("u.id"));
				mascota.setUsername(rs.getString("u.username"));
				mascota.setPassword(rs.getString("u.password"));
				mascota.setName(rs.getString("u.name"));
				mascota.setSurname(rs.getString("u.surname"));

			}
		
		} catch (SQLException e) {		
			e.printStackTrace();
		}		
		return null;
	}

	public void delete(Mascota e) {
		// TODO Auto-generated method stub
		
	}

	public Mascota update(Mascota e) {
		// TODO Auto-generated method stub
		return null;
	}

}
