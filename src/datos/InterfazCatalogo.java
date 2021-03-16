package datos;
import excepciones.CatalogoException;
import model.Pelicula;

public interface InterfazCatalogo {
	
	public boolean altaPelicula (int codigo, Pelicula p) throws CatalogoException;
	
}
