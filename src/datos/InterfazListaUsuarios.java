/**
 * @name: InterfazListaUsuarios
 * @description: Interfaz que contiene los metodos para gestionar usuarios
 * @date: 17/03/2021
 * @version: v1
 * @author: Antonia Hidalgo
 * 
 */
package datos;

import excepciones.UsuarioException;
import model.Usuario;

public interface InterfazListaUsuarios {

	public boolean verUsuarios() throws UsuarioException; 

	public boolean agregarUsuario(int codigo, Usuario usuario) throws UsuarioException;

	public boolean eliminarUsuario(int codigo) throws UsuarioException, Exception;

	public boolean modificarUsuario(int codigo) throws UsuarioException;
	
	public boolean comprobarUsuario (int codigo) throws UsuarioException, Exception;
	
	public void usuariosDePrueba();
	
	public void importarUsuarios(String fichero);
	
	public void exportarUsuarios(String fichero);
	

}
