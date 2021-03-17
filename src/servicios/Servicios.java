package servicios;

import datos.Catalogo;
import datos.InterfazCatalogo;
import excepciones.CatalogoException;
import model.Pelicula;


public class Servicios implements InterfazServicios {
	
	private InterfazCatalogo catalogo= new Catalogo();

	@Override
	public boolean agregarPelicula(int codigo, Pelicula p) throws CatalogoException {
		return false;
	}

	@Override
	public boolean agregarPelicula() throws CatalogoException {
		Pelicula p= new Pelicula();
		p.crearPelicula();
		return this.agregarPelicula(p);
	}
	
    public boolean agregarPelicula(Pelicula p) throws CatalogoException  {
        //Habria que decidir un algoritmo de c�digos (una funciona Hash)
        return catalogo.agregarPelicula((int) (Math.random() * 100000), p);
    }

	@Override
	public boolean eliminarPelicula() throws CatalogoException {
		// TODO Auto-generated method stub
		return false;
	}

}
