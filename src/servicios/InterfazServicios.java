package servicios;

import excepciones.CatalogoException;

import model.Pelicula;

public interface InterfazServicios {
	public boolean agregarPelicula () throws CatalogoException;
	
	public boolean agregarPelicula (int codigo, Pelicula p) throws CatalogoException;
	
	public boolean eliminarPelicula() throws CatalogoException, Exception;
}
