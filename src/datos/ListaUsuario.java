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

	// Métodos
	public void verUsuarios() {
		Integer clave;
		Iterator<Integer> usuarios = listaUsuarios.keySet().iterator();
		System.out.println("-- LISTADO DE USUARIOS --");
		while (usuarios.hasNext()) {
			clave = usuarios.next();
			System.out.println("[" + clave + "]: " + listaUsuarios.get(clave));
		}

	}
	public void agregarUsuario(int codigo, Usuario usuario) {
		if (listaUsuarios.containsKey(codigo)) {
			System.out.println("Este usuario ya existe");
		} else {
			listaUsuarios.put(codigo, usuario);
		}
	}
	public void eliminarUsuario(int codigo) {
		listaUsuarios.remove(codigo);
	}
	public void modificarUsuario(int codigo) {
		Usuario usuario = listaUsuarios.get(codigo);
		System.out.println(usuario);
		System.out.println("Qué quieres modificar?");
		int modificacion = LecturaDatos.leerInt("1- Nombre\n2- Fecha de nacimiento\n3- Ciudad de Residencia");
		switch (modificacion) {
		case 1:
			usuario.setNombreUsuario(LecturaDatos.leerString("Nuevo nombre: "));
		case 2:
			usuario.setFechaNacimiento(LecturaDatos.leerInt("Nueva fecha: "));
		case 3:
			usuario.setCiudadResidencia(LecturaDatos.leerString("Nueva ciudad: "));
		}
	}
	public boolean comprobarUsuario(int codigo) {
		return listaUsuarios.containsKey(codigo);
	}

	//toString
	@Override
	public String toString() {
		return "ListaUsuario [listaUsuarios=" + listaUsuarios + "]";
	}


}
