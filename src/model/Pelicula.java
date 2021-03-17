package model;

import utilidades.LecturaDatos;

public class Pelicula {

	private String nombre;
	private int fechaEstreno;
	private int valoracion;
	private int visualizaciones;
	private Categorias categoria;

	public Pelicula() {
		super();
	}

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
	
	public void crearPelicula() {
		//Se introduce las visualizaciones y la valoracion?
		try {
			this.nombre=LecturaDatos.leerString("Introduce el nombre de la pelicula");
			this.categoria=Categorias.dimeUnaCategoria(LecturaDatos.leerInt());
			this.fechaEstreno=LecturaDatos.leerInt("Introduce la fecha de la pelicula");
		}catch(Exception e) {
			e.getStackTrace();
		}
	}

	@Override
	public String toString() {
		return "Pelicula [nombre=" + nombre + ", fechaEstreno=" + fechaEstreno + ", valoracion=" + valoracion
				+ ", visualizaciones=" + visualizaciones + ", categoria=" + categoria + "]";
	}

}
