package series.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import series.DB.DB;
import series.Modelo.Modelo;

public class DAO {
	// Mapeo filas rs y las convierto en objetos Modelo
	public static Modelo obtenerDATOS(ResultSet rs) throws SQLException {
		return new Modelo(rs.getInt("id"), rs.getString("titulo"), rs.getInt("capitulo"), rs.getInt("temporada"),
				rs.getInt("valoracion"));
	}

	// listas Series	
	public static ArrayList<Modelo> listarSeries() {
		String sql = "SELECT id, titulo, capitulo, temporada, valoracion FROM series";
		ArrayList<Modelo> series = new ArrayList<Modelo>();

		try (Connection con = DB.getConnection();
				PreparedStatement ps = con.prepareStatement(sql);
				ResultSet rs = ps.executeQuery()) {

			while (rs.next()) {
				series.add(DAO.obtenerDATOS(rs));

			}

		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}

		return series;
	}
	
	public static boolean insertar(Modelo item) {

		String sql = "INSERT INTO seriefilia.series (titulo, capitulo, temporada, valoracion) VALUES (?,?,?,?)";

		try (Connection cn = DB.getConnection(); PreparedStatement ps = cn.prepareStatement(sql)) {

			ps.setString(1, item.getTitulo());
			ps.setInt(2, item.getCapitulo());
			ps.setInt(3, item.getTemporada());
			ps.setInt(4, item.getValoracion());

			return ps.executeUpdate() > 0;

		} catch (SQLException e) {
			System.out.println(e.getMessage());
			return false;
		}

	}

	public boolean borrar(int id) {

		String sql = "DELETE FROM seriefilia.series WHERE id = ?";

		try (Connection cn = DB.getConnection(); PreparedStatement ps = cn.prepareStatement(sql)) {

			ps.setInt(1, id);
			return ps.executeUpdate() > 0;
		} catch (SQLException e) {
			System.out.println(e.getMessage());
			return false;
		}

	}

	public static boolean actualizar(Modelo item) {

		String sql = "UPDATE seriefilia.series SET titulo=?, capitulo=?, temporada=?, valoracion=? WHERE id=?";

		try (Connection cn = DB.getConnection(); PreparedStatement ps = cn.prepareStatement(sql)) {

			ps.setString(1, item.getTitulo());
			ps.setInt(2, item.getCapitulo());
			ps.setInt(3, item.getTemporada());
			ps.setInt(4, item.getValoracion());
			
			ps.setInt(5, item.getId());

			return ps.executeUpdate() == 1;

		} catch (SQLException e) {
			System.out.println(e.getMessage());
			return false;
		}

	}
	
	public static Modelo buscar(int id) {
        String sql = "SELECT id, titulo, capitulo, temporada, valoracion FROM seriefilia.series WHERE id = ?";

        try (
                Connection con = DB.getConnection();
                PreparedStatement ps = con.prepareStatement(sql)
        ) {
            ps.setInt(1, id);

            try (ResultSet rs = ps.executeQuery()) {
                if (rs.next()) {
                    return new Modelo(
                            rs.getInt("id"),
                            rs.getString("titulo"),
                            rs.getInt("capitulo"),
                            rs.getInt("temporada"),
                            rs.getInt("valoracion")
                    );
                }
            }

        } catch (SQLException e) {
            System.out.println("Error al buscar: " + e.getMessage());
        }

        return null;
	}
	
	
}
