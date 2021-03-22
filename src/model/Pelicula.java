package model;

import java.io.Serializable;

import utilidades.LecturaDatos;
/**
 * <p><b> Nombre </b> Pelicula</p>
 * 
 * <p><strong>Descripcion </strong> clase molde que contiene los datos para crear peliculas</p>
 * 
 * @author	Yelder Da Silva
 * @version	v1
 * 
 * @since	20/03/2021
 */

public class Pelicula implements Serializable {

	// Atributos
	private static final long serialVersionUID = 1L;
	private String nombre;
	private int fechaEstreno;
	private int valoracion;
	private int visualizaciones;
	private Categorias categoria;

	// Constructores
	public Pelicula() {
		super();
	}

	public Pelicula(String nombre, int fechaEstreno, Categorias categoria) {
		super();
		this.nombre = nombre;
		this.fechaEstreno = fechaEstreno;
		this.categoria = categoria;
	}

	// Getter y setter
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public int getFechaEstreno() {
		return fechaEstreno;
	}

	public void setFechaEstreno(int fechaEstreno) {
		this.fechaEstreno = fechaEstreno;
	}

	public int getValoracion() {
		return valoracion;
	}

	public void setValoracion(int valoracion) {
		this.valoracion = valoracion;
	}

	public int getVisualizaciones() {
		return visualizaciones;
	}

	public void setVisualizaciones(int visualizaciones) {
		this.visualizaciones = visualizaciones;
	}

	public Categorias getCategoria() {
		return categoria;
	}

	public void setCategoria(Categorias categoria) {
		this.categoria = categoria;
	}
	
	public void setCategoria(int categoria) {
		this.categoria =  Categorias.dimeCategorias(categoria);
	}

	
	// Metodos adicionales
	public void crearPelicula() {
		//Se introduce las visualizaciones y la valoracion?
		try {
			this.nombre=LecturaDatos.leerString("Introduce el nombre de la pelicula: ");
			System.out.println("Categorias disponibles:\n >  1.Policiaca \n >  2.Romantica \n >  3.Aventuras \n >  4.Comedia \n >  5.Animacion \n >  6.Thriller ");
			this.categoria=Categorias.dimeCategorias(LecturaDatos.leerInt("Introduce el numero de categoria: "));
			this.fechaEstreno=LecturaDatos.leerInt("Introduce la fecha de la pelicula: ");
		}catch(Exception e) {
			e.getStackTrace();
		}
	}

	// toString
	@Override
	public String toString() {
		return "\n > Nombre: " + nombre + "\n > Fecha de estreno: " + fechaEstreno + "\n > Valoracion media: " + valoracion
				+ "\n > Numero de visualizaciones: " + visualizaciones + "\n > Categoria: " + categoria + "\n";
	}

}
