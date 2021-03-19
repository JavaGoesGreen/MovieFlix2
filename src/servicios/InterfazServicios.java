package servicios;

import excepciones.CatalogoException;
import excepciones.UsuarioException;
import model.Pelicula;
import model.Usuario;

public interface InterfazServicios {

	public boolean agregarPelicula() throws CatalogoException;

	public boolean agregarPelicula(Pelicula p) throws CatalogoException;

	public boolean eliminarPelicula() throws CatalogoException, Exception;

	public boolean eliminarPelicula(int codigo) throws CatalogoException, Exception;

	public boolean modificarPelicula() throws CatalogoException;

	public boolean modificarPelicula(int codigo) throws CatalogoException;

	public boolean listarPeliculas() throws CatalogoException;

	public boolean verUsuarios() throws UsuarioException;

	public boolean agregarUsuario(Usuario usuario) throws UsuarioException;

	public boolean agregarUsuario() throws UsuarioException;

	public boolean eliminarUsuario(int codigo) throws UsuarioException, Exception;

	public boolean eliminarUsuario() throws UsuarioException, Exception;

	public boolean modificarUsuario(int codigo) throws UsuarioException, Exception;

	public boolean modificarUsuario() throws UsuarioException, Exception;

}
