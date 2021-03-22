package control;

import servicios.InterfazServicios;
import servicios.Servicios;
import utilidades.LecturaDatos;
import excepciones.CatalogoException;
import gui.Menu;
import gui.SubmenuListadoPeliculas;
import gui.SubmenuPeliculas;
import gui.SubmenuUsuarios;
/**
 * <p><b> Nombre </b>  MovieFlix</p>
 * 
 * <p><strong>Descripcion </strong> ejecutador de menus GUI</p>
 * 
 * @author	Antonia Hidalgo
 * @author	Gintare Bartuseviciute
 * @author	Dario Denche
 * @author	Toni Blanche
 * @author	Yelder Da Silva
 * @version	v4
 * 
 * @since	21/03/2021
 */


public class MovieFlix {
	private InterfazServicios servicios = new Servicios();

	public void abrirMenu() {
		boolean seguir = true;
		do {
			Menu.mostrarMenu();
			seguir = seleccionOpciones();
		} while (seguir);
		System.out.println("*** Fin de seccion de consulta ***");
	}
	
	public void abrirMenuPeliculas() {
		boolean seguirPeliculas = true;
		do {
			SubmenuPeliculas.mostrarMenu();
			seguirPeliculas = seleccionOpcionesPeliculas();
		} while (seguirPeliculas);
		System.out.println("*** Volviendo al menú anterior ***");
	}
	
	public void abrirMenuListadoPeliculas() {
		boolean seguirPeliculas = true;
		do {
			SubmenuListadoPeliculas.mostrarMenu();
			seguirPeliculas = seleccionOpcionesListadoPeliculas();
		} while (seguirPeliculas);
		System.out.println("*** Volviendo al menú anterior ***");
	}
	
	public void abrirMenuUsuarios() {
		boolean seguirUsuarios = true;
		do {
			SubmenuUsuarios.mostrarMenu();
			seguirUsuarios = seleccionOpcionesUsuarios();
		} while (seguirUsuarios);
		System.out.println("*** Volviendo al menú anterior ***");
	}
	
	public boolean seleccionOpciones() {
		boolean continuar = true;

		try {
			switch (LecturaDatos.leerInt()) {
			case 1: // PELICULAS
				abrirMenuPeliculas();
				break; 
			case 2: // USUARIOS
				abrirMenuUsuarios();
				break;
			case 0:
				continuar = salir();
				break;
			}

		} catch (CatalogoException e) {
			System.out.println("error: " + e.toString());
		} catch (Exception e) {
			e.printStackTrace();
		}
		return continuar;
	}

	public boolean seleccionOpcionesPeliculas() {
		boolean continuarPeliculas = true;

		try {
			switch (LecturaDatos.leerInt()) {
			case 1: // AGREGAR PELICULA
				servicios.agregarPelicula();
				break; 
			case 2: // MODIFICAR PELICULA
				servicios.modificarPelicula();
				break;
			case 3: // ELIMINAR PELICULA
				servicios.eliminarPelicula();
				break;
			case 4: // AGREGAR PELICULAS DE PRUEBA
				servicios.peliculasDePrueba();
				break;
			case 5: // AGREGAR VALORACIÓN DE PRUEBA
				servicios.darValoracion();
				break;
			case 6: // AGREGAR VISITAS DE PRUEBA
				servicios.darVisitas();
				break;
			case 7: // IMPORTAR PELICULAS
				servicios.importarCatalogo();
				break;
			case 8: // EXPORTAR PELICULAS
				servicios.exportarCatalogo();
				break;
			case 9: // LISTAR PELICULAS
				abrirMenuListadoPeliculas();
				break;
			case 0:
				continuarPeliculas = false;
				break;
			}
		} catch (CatalogoException e) {
			System.out.println("error: " + e.toString());
		} catch (Exception e) {
			e.printStackTrace();
		}
		return continuarPeliculas;
	}
	
	public boolean seleccionOpcionesListadoPeliculas() {
		boolean continuarPeliculas = true;

		try {
			switch (LecturaDatos.leerInt()) {
			case 1: 
				servicios.listarPeliculas();
				break;
			case 2: 
				servicios.ordenarPeores();
				break;
			case 3: 
				servicios.ordenarMejores();
				break;
			case 4: 
				servicios.ordenarMasVistas();
				break;
			case 5: 
				servicios.listaPeliculasCat();
				break;
			case 6:
				servicios.listaVisualizacionesCategorias();
				break;
			case 7:
				servicios.ordenarPorEncimaMedia();
				break;
			case 0:
				continuarPeliculas = false;
				break;
			}
		} catch (CatalogoException e) {
			System.out.println("error: " + e.toString());
		} catch (Exception e) {
			e.printStackTrace();
		}
		return continuarPeliculas;
	}
	
	public boolean seleccionOpcionesUsuarios() {
		boolean continuarUsuarios = true;

		try {
			switch (LecturaDatos.leerInt()) {
			case 1: // AGREGAR USUARIO
				servicios.agregarUsuario();
				break;
			case 2: // MODIFICAR USUARIO
				servicios.modificarUsuario();
				break;
			case 3: // ELIMINAR USUARIO
				servicios.eliminarUsuario();
				break;
			case 4: // LISTAR USUARIOS
				servicios.verUsuarios();
				break;
			case 5: // AGREGAR USUARIOS DE PRUEBA
				servicios.usuariosDePrueba();;
				break;
			case 0:
				continuarUsuarios = false;
				break;
			}

		} catch (CatalogoException e) {
			System.out.println("error: " + e.toString());
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return continuarUsuarios;
	}

	private boolean salir() throws Exception {
		String decidir = LecturaDatos.leerString(" Quieres salir?(S/N) ");
		return (decidir.toUpperCase().charAt(0) != 'S');
	}
}
