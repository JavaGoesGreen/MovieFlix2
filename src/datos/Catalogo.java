package datos;

import java.util.HashMap;
import java.util.Map;

import java.util.Iterator;

import excepciones.CatalogoException;
import model.Pelicula;
import utilidades.LecturaDatos;

public class Catalogo implements InterfazCatalogo {
	
	// Atributo
	private Map<Integer, Pelicula> catalogo;
	
	// Constructores
	public Catalogo() {
		catalogo = new HashMap<>();
	}
	
	// Getter y setter
	public Map<Integer, Pelicula> getCatalogo(){
		return catalogo;
	}
	public void setCatalogo(Map<Integer, Pelicula> catalogo) {
		this.catalogo = catalogo;
	}
	
	// Métodos adicionales
	public boolean agregarPelicula(int codigo, Pelicula p) throws CatalogoException {
		if (catalogo.containsKey(codigo)) {
			//Necesario system out?
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
	public void eliminarPelicula(int codigo)throws CatalogoException {
		  catalogo.remove(codigo);
	}

	@Override
	public boolean modificarPelicula(int codigo) throws CatalogoException {
		Pelicula pelicula=catalogo.get(codigo);
		System.out.println(pelicula);
		
		System.out.println("Que pelicula quieres modificar");
		
		int modificacion=LecturaDatos.leerInt("1- Nombre\n2- Fecha de estreno\n3 Categoria");
		switch(modificacion) {
		case 1:
			pelicula.setNombre(LecturaDatos.leerString("Nuevo nombre de pelicula"));
		case 2:
			pelicula.setFechaEstreno(LecturaDatos.leerInt("Nueva fecha de estreno de pelicula"));
		case 3:
			pelicula.setCategoria(LecturaDatos.leerInt("Escoge la categoria de la pelicula"));
		}
		
		return true;
	}

	@Override
	public void listaPeliculas() throws CatalogoException {
		Integer codigo;
		Iterator<Integer>peliculas=catalogo.keySet().iterator();
		System.out.println("*** Listado de Peliculas ***");
		while(peliculas.hasNext()) {
			codigo=peliculas.next();
			System.out.println("*"+codigo+"*"+catalogo.get(codigo));
		}	
	}
	
	
}
