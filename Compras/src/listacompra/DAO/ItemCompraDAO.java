package listacompra.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import listacompra.DB.DBConnection;
import listacompra.model.ItemCompra;

public class ItemCompraDAO {
	// Mapeo filas rs y las convierto en objetos PeliculasModel
	public static ItemCompra mapeo(ResultSet rs) throws SQLException {
		return new ItemCompra(rs.getInt("id"), rs.getString("producto"), rs.getInt("cantidad"),
				rs.getBoolean("comprado"));
	}

	// listas peliculas
	public ArrayList<ItemCompra> listarCompra() {
		String sql = "SELECT id, producto, cantidad, comprado FROM listacompra";
		ArrayList<ItemCompra> listacompra = new ArrayList<ItemCompra>();

		try (Connection con = DBConnection.getConnection();
				PreparedStatement ps = con.prepareStatement(sql);
				ResultSet rs = ps.executeQuery()) {

			while (rs.next()) {
				listacompra.add(ItemCompraDAO.mapeo(rs));

			}

		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}

		return listacompra;
	}

	public boolean insertarCompra(ItemCompra item) {

		String sql = "INSERT INTO Compras.listacompra (producto, cantidad, comprado) VALUES (?,?,?)";

		try (Connection cn = DBConnection.getConnection(); PreparedStatement ps = cn.prepareStatement(sql)) {

			ps.setString(1, item.getProducto());
			ps.setInt(2, item.getCantidad());
			ps.setBoolean(3, item.isComprado());

			return ps.executeUpdate() > 0;

		} catch (SQLException e) {
			System.out.println(e.getMessage());
			return false;
		}

	}

	public boolean borrarCompra(int id) {

		String sql = "DELETE FROM Compras.listacompra WHERE id = ?";

		try (Connection cn = DBConnection.getConnection(); PreparedStatement ps = cn.prepareStatement(sql)) {

			ps.setInt(1, id);
			return ps.executeUpdate() > 0;
		} catch (SQLException e) {
			System.out.println(e.getMessage());
			return false;
		}

	}

	public static boolean actualizarCompra(int id, String producto, int cantidad, boolean comprado) {

		String sql = "UPDATE Compras.listacompra SET producto=?, cantidad=?, comprado=? WHERE id=?";

		try (Connection cn = DBConnection.getConnection(); PreparedStatement ps = cn.prepareStatement(sql)) {

			ps.setString(1, producto);
			ps.setInt(2, cantidad);
			ps.setBoolean(3, comprado);
			ps.setInt(4, id);

			return ps.executeUpdate() == 1;

		} catch (SQLException e) {
			System.out.println(e.getMessage());
			return false;
		}

	}

}
