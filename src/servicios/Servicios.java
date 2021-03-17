package servicios;

import datos.Catalogo;
import datos.InterfazCatalogo;
import excepciones.CatalogoException;
import model.Pelicula;
import utilidades.LecturaDatos;


public class Servicios implements InterfazServicios {
	
	private InterfazCatalogo catalogo= new Catalogo();


	public boolean agregarPelicula() throws CatalogoException {
		Pelicula p= new Pelicula();
		p.crearPelicula();
		return this.agregarPelicula(p);
	}
	
    public boolean agregarPelicula(Pelicula p) throws CatalogoException  {
        //Para crear un codigo aleatorio
        return catalogo.agregarPelicula((int) (Math.random() * 100000), p);
    }


	public boolean eliminarPelicula() throws CatalogoException, Exception{
		int codigo=LecturaDatos.leerInt("Introduce el codigo de la pelicula que quieras eliminar");
	   
		if(catalogo.existeCodigo(codigo)) {
			catalogo.eliminarPelicula(codigo);
			System.out.println("La pelicula se ha eliminado");
			return true;
		}
		else {
			throw new CatalogoException("No hay esta película en el catalogo",3);
					
		}
		
		
	}


	
	
}
