package servicios;

import excepciones.CatalogoException;

import model.Pelicula;

public interface InterfazServicios {
	public boolean agregarPelicula () throws CatalogoException;
	public boolean agregarPelicula (Pelicula p) throws CatalogoException;
	public boolean eliminarPelicula() throws CatalogoException, Exception;
	public boolean eliminarPelicula(int codigo) throws CatalogoException, Exception;
    public boolean modificarPelicula() throws CatalogoException;
    public boolean modificarPelicula(int codigo) throws CatalogoException;
    public void listarPeliculas() throws CatalogoException;

}
