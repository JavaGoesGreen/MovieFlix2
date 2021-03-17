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

	public void verUsuarios() throws UsuarioException;

	public void agregarUsuario(int codigo, Usuario usuario) throws UsuarioException;

	public void eliminarUsuario(int codigo) throws UsuarioException;

	public void modificarUsuario(int codigo) throws UsuarioException;
	
	public boolean comprobarUsuario (int codigo);
	

}
