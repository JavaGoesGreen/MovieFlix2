package datos;

import excepciones.CatalogoException;
import model.Pelicula;
/**
 * <p><b> Nombre </b>  InterfazCatalogo</p>
 * 
 * <p><strong>Descripcion </strong>clase que contiene todo los metodos relacionados con peliculas</p>
 * 
 * @author	Antonia Hidalgo
 * @author	Gintare Bartuseviciute
 * @author	Dario Denche
 * @author	Toni Blanche
 * @author	Yelder Da Silva
 * @version	v4
 * 
 * @since	21/03/2021
 */

public interface InterfazCatalogo {

	public boolean agregarPelicula(int codigo, Pelicula p) throws CatalogoException;

	public boolean eliminarPelicula(int codigo) throws CatalogoException;

	public boolean existeCodigo(int codigo);

	public boolean modificarPelicula(int codigo) throws CatalogoException;

	public boolean listaPeliculas() throws CatalogoException;

	public void importarCatalogo(String fichero);

	public void exportarCatalogo(String fichero);

	public void peliculasDePrueba();

	public boolean darValoracion();
	
	public void ordenarPeores();
	
	public void ordenarMejores();
	
	public boolean darVisitas();
	
	public void ordenarMasVistas();
	
	public boolean listaPeliculasCat() throws CatalogoException;
	
	public boolean listaVisualizacionesCategorias() throws CatalogoException;
	
	public void ordenarPorEncimaMedia() throws CatalogoException;
}
