/**
 * @name: InterfazListaUsuarios
 * @description: Interfaz que contiene los metodos para gestionar usuarios
 * @date: 17/03/2021
 * @version: v1
 * @author: Antonia Hidalgo
 * 
 */
package datos;

import model.Usuario;

public interface InterfazListaUsuarios {

	public void verUsuarios();

	public void agregarUsuario(int codigo, Usuario usuario);

	public void eliminarUsuario(int codigo);

	public void modificarUsuario(int codigo);
	
	public boolean comprobarUsuario (int codigo);
	

}
