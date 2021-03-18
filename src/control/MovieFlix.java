package control;

import servicios.InterfazServicios;
import servicios.Servicios;
import utilidades.LecturaDatos;
import excepciones.CatalogoException;
import gui.Menu;

public class MovieFlix {
	private InterfazServicios servicios = new Servicios();

	public void abrirMenuPeliculas() {
		boolean seguir = true;
		do {
			Menu.mostrarMenu();
			seguir = this.seleccionOpciones();
		} while (seguir);
		System.out.println("*** Fin de secci�n de consulta ***");
	}

	public boolean seleccionOpciones() {
		boolean continuar = true;

		try {
			switch (LecturaDatos.leerInt()) {
			case 1:
				// AGREGAR PELICULA
				servicios.agregarPelicula();
				break;
				//MODIFICAR PELICULA
			case 2:
				servicios.modificarPelicula();
				//ELIMINAR PELICULA
			case 3:
				servicios.eliminarPelicula();
				break;
				//LISTAR PELICULAS
			case 4:
				servicios.listarPeliculas();
			case 0:
				continuar = salir();
				break;
			}


		} catch (CatalogoException e) {
			System.out.println("error: " + e.toString());
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return continuar;
	}

	private boolean salir() throws Exception {
		String decidir = LecturaDatos.leerString(" �Quieres salir?(S/N");
		return (decidir.toUpperCase().charAt(0) != 'S');
	}
}
