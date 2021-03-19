/**
 * @name: ListaUsuarios
 * @description: clase que implementa la interfaz homonima y contiene los algoritmos de los metodos CRUD
 * @date: 17/03/2021
 * @version: v1
 * @author: Antonia Hidalgo
 * 
 */

package datos;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

import excepciones.UsuarioException;
import model.Usuario;
import utilidades.LecturaDatos;

public class ListaUsuario implements InterfazListaUsuarios {

	// Atributo
	private Map<Integer, Usuario> listaUsuarios;

	// Constructores
	public ListaUsuario() {
		this.listaUsuarios = new HashMap<>();
	}

	public ListaUsuario(Map<Integer, Usuario> mapaUsuarios) {
		super();
		this.listaUsuarios = mapaUsuarios;
	}

	// Getter y setter
	public Map<Integer, Usuario> getMapaUsuarios() {
		return listaUsuarios;
	}

	public void setMapaUsuarios(Map<Integer, Usuario> mapaUsuarios) {
		this.listaUsuarios = mapaUsuarios;
	}

	// Metodos
	public boolean verUsuarios() throws UsuarioException {
		Integer clave;
		Iterator<Integer> usuarios = listaUsuarios.keySet().iterator();
		System.out.println("-- LISTADO DE USUARIOS --");
		while (usuarios.hasNext()) {
			clave = usuarios.next();
			System.out.println(" > Codigo: " + clave  + listaUsuarios.get(clave));
		}
		return true;
	}

	public boolean agregarUsuario(int codigo, Usuario usuario) throws UsuarioException {
		if (listaUsuarios.containsKey(codigo)) {
			System.out.println("¡Ojo! Este usuario ya existe");
		} else {
			listaUsuarios.put(codigo, usuario);
		}
		return true;
	}

	public boolean eliminarUsuario(int codigo) throws UsuarioException {
		listaUsuarios.remove(codigo);
		return true;
	}

	public boolean modificarUsuario(int codigo) throws UsuarioException {
		Usuario usuario = listaUsuarios.get(codigo);
		System.out.println(usuario);
		System.out.println("Que quieres modificar?");
		int modificacion = LecturaDatos.leerInt("1- Nombre\n2- Fecha de nacimiento\n3- Ciudad de Residencia\n >>");
		switch (modificacion) {
		case 1:
			usuario.setNombreUsuario(LecturaDatos.leerString("Nuevo nombre: "));
			break;
		case 2:
			usuario.setFechaNacimiento(LecturaDatos.leerInt("Nueva fecha: "));
			break;
		case 3:
			usuario.setCiudadResidencia(LecturaDatos.leerString("Nueva ciudad: "));
			break;
		}
		return true;
	}

	public boolean comprobarUsuario(int codigo) throws UsuarioException {
		return listaUsuarios.containsKey(codigo);
	}

	// toString
	@Override
	public String toString() {
		return "ListaUsuario [listaUsuarios=" + listaUsuarios + "]";
	}

}
