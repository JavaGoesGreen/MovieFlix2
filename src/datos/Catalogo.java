package datos;

import java.util.HashMap;
import java.util.Map;
import java.util.Iterator;

import java.io.IOException;
import excepciones.CatalogoException;

import model.Categorias;
import model.Pelicula;
import utilidades.LecturaDatos;

import com.opencsv.CSVReader;
import com.opencsv.CSVWriter;
import java.io.FileReader;
import java.io.FileWriter;

public class Catalogo implements InterfazCatalogo {

	// Atributo
	private Map<Integer, Pelicula> catalogo;

	// Constructores
	public Catalogo() {
		catalogo = new HashMap<>();
	}

	// Getter y setter
	public Map<Integer, Pelicula> getCatalogo() {
		return catalogo;
	}

	public void setCatalogo(Map<Integer, Pelicula> catalogo) {
		this.catalogo = catalogo;
	}

	// M�todos adicionales
	public boolean agregarPelicula(int codigo, Pelicula p) throws CatalogoException {
		if (catalogo.containsKey(codigo)) {
			// Necesario system out?
			System.out.println(codigo + "ya fue agregada anteriormente.");
			throw new CatalogoException("No se puede dar de alta esta pelicula. El codigo es repetido.", 2);
		} else {
			catalogo.put(codigo, p);
			return true;
		}
	}

	public boolean existeCodigo(int cod) {
		return catalogo.containsKey(cod);
	}

	@Override
	public boolean eliminarPelicula(int codigo) throws CatalogoException {
		catalogo.remove(codigo);
		return true;
	}

	@Override
	public boolean modificarPelicula(int codigo) throws CatalogoException {
		Pelicula pelicula = catalogo.get(codigo);
		System.out.println(pelicula);

		System.out.println("Que pelicula quieres modificar: ");

		int modificacion = LecturaDatos.leerInt("1- Nombre\n2- Fecha de estreno\n3- Categoria\n > ");
		switch (modificacion) {
		case 1:
			pelicula.setNombre(LecturaDatos.leerString("Nuevo nombre de pelicula: "));
		case 2:
			pelicula.setFechaEstreno(LecturaDatos.leerInt("Nueva fecha de estreno de pelicula: "));
		case 3:
			pelicula.setCategoria(LecturaDatos.leerInt("Escoge la categoria de la pelicula: "));
		}

		return true;
	}

	@Override
	public boolean listaPeliculas() throws CatalogoException {
		Integer codigo;
		Iterator<Integer> peliculas = catalogo.keySet().iterator();
		System.out.println("*** Listado de Peliculas ***");
		while (peliculas.hasNext()) {
			codigo = peliculas.next();
			System.out.println(" > Codigo: " + codigo + catalogo.get(codigo));
		}
		return true;
	}

	public void importarCatalogo(String fichero) {
		System.out.println("-- Importando");
		try {
			CSVReader csvReader = new CSVReader(new FileReader(fichero));
			String[] nextline;
			while ((nextline = csvReader.readNext()) != null) {
				if (nextline != null) {
					int codigo = (int) (Math.random() * 100000);
					String nombre = nextline[0];
					int estreno = Integer.parseInt(nextline[1]);
					Categorias categoria = Categorias.dimeCategorias(Integer.parseInt(nextline[2]));
					Pelicula pelicula = new Pelicula(nombre, estreno, categoria);
					agregarPelicula(codigo, pelicula);
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println(e);
		}
	}

	public void exportarCatalogo(String fichero) {
		System.out.println("-- Exportando");
		Integer codigo;
		CSVWriter writer = null;
		try {
			writer = new CSVWriter(new FileWriter(fichero), ',', CSVWriter.NO_QUOTE_CHARACTER,
					CSVWriter.DEFAULT_ESCAPE_CHARACTER, CSVWriter.DEFAULT_LINE_END);
			Iterator<Integer> peliculas = catalogo.keySet().iterator();
			while (peliculas.hasNext()) {
				codigo = peliculas.next();
				Pelicula p = catalogo.get(codigo);
				String linea[] = { p.getNombre(), "" + p.getFechaEstreno(), "" + p.getCategoria().getCategoria() };
				try {
					writer.writeNext(linea);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		} catch (IOException e1) {
			e1.printStackTrace();
		} finally {
			try {
				writer.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}

	public void peliculasDePrueba() {
		catalogo.put(1, new Pelicula("La vida es bella", 1997, Categorias.romantica));
		catalogo.put(2, new Pelicula("Intocable", 2011, Categorias.comedia));
		catalogo.put(3, new Pelicula("El Rey Leon", 1994, Categorias.animacion));
		catalogo.put(4, new Pelicula("El caballero oscuro", 2008, Categorias.thriller));
		catalogo.put(5, new Pelicula("Interstellar", 2014, Categorias.aventuras));
		catalogo.put(6, new Pelicula("El caso Bourne", 2002, Categorias.policiaca));
	}
}
