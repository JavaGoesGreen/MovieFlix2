package datos;
import excepciones.CatalogoException;
import model.Pelicula;

public interface InterfazCatalogo {

	public boolean agregarPelicula (int codigo, Pelicula p) throws CatalogoException;
	public void eliminarPelicula(int codigo) throws CatalogoException;
	public boolean existeCodigo(int codigo);
	public boolean modificarPelicula(int codigo)throws CatalogoException; 
	public void listaPeliculas() throws CatalogoException;


}
