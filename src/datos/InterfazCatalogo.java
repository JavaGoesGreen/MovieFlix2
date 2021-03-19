package datos;
import excepciones.CatalogoException;
import model.Pelicula;

public interface InterfazCatalogo {

	public boolean agregarPelicula (int codigo, Pelicula p) throws CatalogoException;
	public boolean eliminarPelicula(int codigo) throws CatalogoException;
	public boolean existeCodigo(int codigo);
	public boolean modificarPelicula(int codigo)throws CatalogoException; 
	public boolean listaPeliculas() throws CatalogoException;
	public void importarCatalogo(String fichero);
	public void exportarCatalogo(String fichero);
	public void peliculasDePrueba();
}
