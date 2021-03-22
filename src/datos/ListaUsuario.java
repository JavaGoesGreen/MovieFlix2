
package datos;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

import com.opencsv.CSVReader;
import com.opencsv.CSVWriter;

import excepciones.UsuarioException;
import model.Usuario;
import utilidades.LecturaDatos;

/**
 * <p><b> Nombre </b>  ListaUsuarios</p>
 * 
 * <p><strong>Descripcion </strong>clase que implementa la interfazListaUsuario y contiene los algoritmos de los metodos CRUD</p>
 * 
 * @author	Antonia Hidalgo
 * 
 * @version	v1
 * 
 * @since	17/03/2021
 */

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
	
	
	public void importarUsuarios(String fichero) {
		System.out.println("-- Importando");
		try {
			CSVReader csvReader = new CSVReader(new FileReader(fichero));
			String[] nextline;
			while ((nextline = csvReader.readNext()) != null) {
				if (nextline != null) {
					int codigo = (int) (Math.random() * 100000);
					String nombre = nextline[0];
					int fecha = Integer.parseInt(nextline[1]);
					String ciudad = nextline[2];
					Usuario usuario = new Usuario(nombre, fecha, ciudad);
					agregarUsuario(codigo, usuario);
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println(e);
		}
	}
	
	public void exportarUsuarios(String fichero) {
		System.out.println("-- Exportando");
		Integer codigo;
		CSVWriter writer = null;
		try {
			writer = new CSVWriter(new FileWriter(fichero), ',', CSVWriter.NO_QUOTE_CHARACTER,
					CSVWriter.DEFAULT_ESCAPE_CHARACTER, CSVWriter.DEFAULT_LINE_END);
			Iterator<Integer> usuarios = listaUsuarios.keySet().iterator();
			while (usuarios.hasNext()) {
				codigo = usuarios.next();
				Usuario u = listaUsuarios.get(codigo);
				String linea[] = { u.getNombreUsuario(), "" + u.getFechaNacimiento(), u.getCiudadResidencia() };
				try {
					writer.writeNext(linea);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		} catch (IOException e1) {
			e1.printStackTrace();
		} finally {
			try {
				writer.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
	
    public void usuariosDePrueba() {
        listaUsuarios.put(1, new Usuario("Maria", 1992, "Madrid"));
        listaUsuarios.put(2, new Usuario("Juan", 1997, "Barcelona"));
        listaUsuarios.put(3, new Usuario("Ramon", 1999, "Valencia"));
        listaUsuarios.put(4, new Usuario("Edgar", 1984, "Sevilla"));
        listaUsuarios.put(5, new Usuario("Lucia", 1971, "Bilbao"));
        listaUsuarios.put(6, new Usuario("Rebeca", 2002, "Caceres"));
    }

	// toString
	@Override
	public String toString() {
		return "ListaUsuario [listaUsuarios=" + listaUsuarios + "]";
	}

}
