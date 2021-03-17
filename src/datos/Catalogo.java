package datos;

import java.util.HashMap;
import java.util.Map;
import excepciones.CatalogoException;
import model.Pelicula;

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
	
	// M�todos adicionales
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

	// toString
	@Override
	public boolean modificarPelicula(int codigo, Pelicula p) throws CatalogoException {
		if (catalogo.containsKey(codigo)) {
			catalogo.put(codigo, p);
		} else {
			throw new CatalogoException("Esta pelicula no existe todavia", 2);
		}
		return true;
	}
	
	
	
}
