package peliculas;

import java.util.ArrayList;
import peliculas.DAO.DAO;
import peliculas.model.*;

public class Main {

	public static void main(String[] args) {

		// LISTAR TODAS
		ArrayList<PeliculasModel> peliculas = new ArrayList<PeliculasModel>();
		// peliculas = DAO.listarPeliculas();

		for (PeliculasModel p : peliculas) {
			System.out.println(p);
		}

		// PELICULAS DEL AÑO 1990
		ArrayList<PeliculasModel> peliculasAnno = new ArrayList<PeliculasModel>();
		// peliculasAnno = DAO.listarAnno(2001);

		for (PeliculasModel p : peliculasAnno) {
			System.out.println(p);
		}

		// BUSCAR PELICULA POR NOMBRE
		ArrayList<PeliculasModel> peliculasNombre = new ArrayList<PeliculasModel>();
		//peliculasNombre = DAO.buscarNombre("Star Wars");

		for (PeliculasModel p : peliculasNombre) {
			System.out.println(p);
		}
		
		// PELICULA ORDENADA POR AÑO
				ArrayList<PeliculasModel> peliculasOrden = new ArrayList<PeliculasModel>();
				peliculasOrden = DAO.peliculasOrden("DESC");

				for (PeliculasModel p : peliculasOrden) {
					System.out.println(p);
				}
	}

}
