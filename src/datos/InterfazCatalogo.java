package datos;
import excepciones.CatalogoException;
import model.Pelicula;

public interface InterfazCatalogo {
	
	public boolean agregarPelicula (int codigo, Pelicula p) throws CatalogoException;
	public void eliminarPelicula(int codigo) throws CatalogoException;
}
