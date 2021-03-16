package servicios;

import excepciones.CatalogoException;
import model.Pelicula;

public interface InterfazServicios {
	public boolean altaPelicula (int codigo, Pelicula p) throws CatalogoException;
}
