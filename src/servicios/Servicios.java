package servicios;

import datos.Catalogo;
import datos.InterfazCatalogo;
import datos.InterfazListaUsuarios;
import datos.ListaUsuario;
import excepciones.CatalogoException;
import excepciones.UsuarioException;
import model.Pelicula;
import model.Usuario;
import utilidades.LecturaDatos;
/**
 * <p><b> Nombre </b> Servicios</p>
 * 
 * <p><strong>Descripcion </strong>clase que contiene la capa intermedia entre Datos y Control</p>
 * 
 * @author	Dario Denche
 * @version	v3
 * 
 * @since	21/03/2021
 */

public class Servicios implements InterfazServicios {

	private InterfazCatalogo catalogo = new Catalogo();
	private InterfazListaUsuarios usuario = new ListaUsuario();

	public boolean agregarPelicula() throws CatalogoException {
		Pelicula p = new Pelicula();
		p.crearPelicula();
		return this.agregarPelicula(p);
	}

	public boolean agregarPelicula(Pelicula p) throws CatalogoException {
		// Para crear un codigo aleatorio
		return catalogo.agregarPelicula((int) (Math.random() * 100000), p);
	}

	public boolean eliminarPelicula() throws CatalogoException, Exception {
		int codigo = LecturaDatos.leerInt("Introduce el codigo de la pelicula que quieras eliminar: ");
		return eliminarPelicula(codigo);
	}

	@Override
	public boolean eliminarPelicula(int codigo) throws CatalogoException, Exception {

		if (catalogo.existeCodigo(codigo)) {
			catalogo.eliminarPelicula(codigo);
			System.out.println("La pelicula se ha eliminado");
			return true;
		} else {
			throw new CatalogoException("No hay esta pelicula en el catalogo", 3);

		}
	}

	@Override
	public boolean modificarPelicula() throws CatalogoException {
		int codigo = LecturaDatos.leerInt("Introduce el codigo de la pelicula que quieras modificar: ");
		return modificarPelicula(codigo);
	}

	@Override
	public boolean modificarPelicula(int codigo) throws CatalogoException {
		if (catalogo.existeCodigo(codigo)) {
			catalogo.modificarPelicula(codigo);
			System.out.println("La pelicula se ha modificado");
			return true;
		} else {
			throw new CatalogoException("No hay esta pelicula en el catalogo", 3);

		}
	}

	@Override
	public boolean listarPeliculas() throws CatalogoException {
		return catalogo.listaPeliculas();
	}
	
	public boolean darValoracion() {
		return catalogo.darValoracion();
	}
	
	public void ordenarPeores() {
		catalogo.ordenarPeores();
	}
	
	public void ordenarMejores() {
		catalogo.ordenarMejores();
	}
	
	public boolean darVisitas() {
		return catalogo.darVisitas();
	} 
	
	public void ordenarMasVistas() {
		catalogo.ordenarMasVistas();
	}
	
	public boolean listaPeliculasCat() throws CatalogoException{
		return catalogo.listaPeliculasCat();
	}
	
	public boolean listaVisualizacionesCategorias() throws CatalogoException {
		return catalogo.listaVisualizacionesCategorias();
	}
	
	public void ordenarPorEncimaMedia() throws CatalogoException{
		catalogo.ordenarPorEncimaMedia();
	}

	@Override
	public boolean verUsuarios() throws UsuarioException {
		return usuario.verUsuarios();
	}

	@Override
	public boolean agregarUsuario(Usuario user) throws UsuarioException {
		int codigo = (int) (Math.random() * 100000);
		return usuario.agregarUsuario(codigo, user);
	}

	@Override
	public boolean agregarUsuario() throws UsuarioException {
		String nombreUsuario = LecturaDatos.leerString("Ingresa nombre de usuario: ");
		int fecha = LecturaDatos.leerInt("Ingresa fecha de nacimiento: ");
		String ciudad = LecturaDatos.leerString("Ingresa ciudad: ");
		Usuario user = new Usuario(nombreUsuario, fecha, ciudad);
		return agregarUsuario(user);

	}

	@Override
	public boolean eliminarUsuario(int codigo) throws UsuarioException, Exception {
		if (usuario.comprobarUsuario(codigo)) {
			return usuario.eliminarUsuario(codigo);
		} else {
			throw new UsuarioException("El usuario no existe", 3);
		}

	}

	@Override
	public boolean eliminarUsuario() throws UsuarioException, Exception {
		int codigo = LecturaDatos.leerInt("Ingresa codigo de usuario: ");
		return eliminarUsuario(codigo);
	}

	@Override
	public boolean modificarUsuario(int codigo) throws UsuarioException, Exception {
		if (usuario.comprobarUsuario(codigo)) {
			return usuario.modificarUsuario(codigo);
		} else {
			throw new UsuarioException("El usuario no existe", 3);
		}
	}

	@Override
	public boolean modificarUsuario() throws UsuarioException,  Exception {
		int codigo = LecturaDatos.leerInt("Ingresa codigo de usuario: ");
		return modificarUsuario(codigo);
	}
	
	public void peliculasDePrueba() {
		catalogo.peliculasDePrueba();
	}

    public void exportarCatalogo() {
        //Este es un fichero para guardar lo que generemos en consola
        catalogo.exportarCatalogo("listado_peliculas.txt");
    }

    public void importarCatalogo() {
        //Esta es la lista de Antonio
        catalogo.importarCatalogo("peliculas_numCat.txt");
    }
    
	public void usuariosDePrueba() {
		usuario.usuariosDePrueba();
	}
    
    public void exportarUsuarios() {
        //Este es un fichero para guardar lo que generemos en consola
        usuario.exportarUsuarios("listado_usuarios.txt");
    }

    public void importarUsuarios() {
        //Esta es la lista de Antonio
        usuario.importarUsuarios("listado_usuarios.txt");
    }
	
	}


