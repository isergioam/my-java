package peliculas.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import peliculas.DB.DB;
import peliculas.model.PeliculasModel;

public class DAO {

	// Mapeo filas rs y las convierto en objetos PeliculasModel
	public static PeliculasModel mapeo(ResultSet rs) throws SQLException {
		return new PeliculasModel(rs.getInt("id"), rs.getString("titulo"), rs.getInt("anno_estreno"),
				rs.getInt("duracion"));
	}

	// listas peliculas
	public static ArrayList<PeliculasModel> listarPeliculas() {
		String sql = "SELECT id, titulo, anno_estreno, duracion FROM peliculas";
		ArrayList<PeliculasModel> peliculas = new ArrayList<PeliculasModel>();

		try (Connection con = DB.getConnection();
				PreparedStatement ps = con.prepareStatement(sql);
				ResultSet rs = ps.executeQuery()) {

			while (rs.next()) {
				peliculas.add(DAO.mapeo(rs));

			}

		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}

		return peliculas;
	}

	// Lista por año
	public static ArrayList<PeliculasModel> listarAnno(int anno) {
		String sql2 = "SELECT id, titulo, anno_estreno, duracion FROM peliculas WHERE anno_estreno = ?";
		ArrayList<PeliculasModel> peliculas = new ArrayList<PeliculasModel>();
		try (Connection con = DB.getConnection(); PreparedStatement ps = con.prepareStatement(sql2);) {

			ps.setInt(1, anno);

			try (ResultSet rs = ps.executeQuery()) {

				while (rs.next()) {
					peliculas.add(DAO.mapeo(rs));
				}
			}

		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
		return peliculas;
	}

	// Buscar pelicula por nombre
	public static ArrayList<PeliculasModel> buscarNombre(String titulo) {
		String sql3 = "SELECT id, titulo, anno_estreno, duracion FROM peliculas WHERE titulo LIKE ?";

		ArrayList<PeliculasModel> peliculas = new ArrayList<PeliculasModel>();
		try (Connection con = DB.getConnection(); PreparedStatement ps = con.prepareStatement(sql3);) {

			ps.setString(1, "%" + titulo + "%");

			try (ResultSet rs = ps.executeQuery()) {

				while (rs.next()) {
					peliculas.add(DAO.mapeo(rs));
				}
			}

		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
		return peliculas;

	}

	// Peliculas ordenadas por año
	public static ArrayList<PeliculasModel> peliculasOrden(String orden) {
		ArrayList<PeliculasModel> peliculas = new ArrayList<PeliculasModel>();

		if (!orden.equals("ASC") && !orden.equals("DESC")) {
			return peliculas;
		}

		String sql4 = "SELECT id, titulo, anno_estreno, duracion FROM peliculas WHERE titulo ORDER BY anno_estreno "
				+ orden;

		try (Connection con = DB.getConnection(); PreparedStatement ps = con.prepareStatement(sql4);) {

			ps.setString(1, orden);

			try (ResultSet rs = ps.executeQuery()) {

				while (rs.next()) {
					peliculas.add(DAO.mapeo(rs));
				}
			}

		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
		return peliculas;

	}

}
