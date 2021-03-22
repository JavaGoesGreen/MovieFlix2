package model;

import utilidades.LecturaDatos;
/**
 * <p><b> Nombre </b> Usuario</p>
 * 
 * <p><strong>Descripcion </strong>clase molde que contiene los datos para crear usuarios</p>
 * 
 * @author	Antonia Hidalgo
 * @version	v1
 * 
 * @since	17/03/2021
 */

public class Usuario {

	// Atributos
	private String nombreUsuario;
	private int fechaNacimiento;
	private String ciudadResidencia;

	//Constructores
	public Usuario() {}
	public Usuario(String nombreUsuario, int fechaNacimiento, String ciudadResidencia) {
		this.nombreUsuario = nombreUsuario;
		this.fechaNacimiento = fechaNacimiento;
		this.ciudadResidencia = ciudadResidencia;
	}

	// Getter y setter
	public String getNombreUsuario() {
		return nombreUsuario;
	}
	public void setNombreUsuario(String nombreUsuario) {
		this.nombreUsuario = nombreUsuario;
	}
	public int getFechaNacimiento() {
		return fechaNacimiento;
	}
	public void setFechaNacimiento(int fechaNacimiento) {
		this.fechaNacimiento = fechaNacimiento;
	}
	public String getCiudadResidencia() {
		return ciudadResidencia;
	}
	public void setCiudadResidencia(String ciudadResidencia) {
		this.ciudadResidencia = ciudadResidencia;
	}
	
	// M�todos adicionales
	public void crearUsuario() {
		try {
			this.nombreUsuario=LecturaDatos.leerString("Introduce el nombre del usuario: ");
			this.ciudadResidencia=LecturaDatos.leerString("Introduce el nombre de la ciudad de residencia: ");
			this.fechaNacimiento=LecturaDatos.leerInt("Introduce la fecha de nacimiento: ");
		}catch(Exception e) {
			e.getStackTrace();
		}
	}

	// toString
	@Override
	public String toString() {
		return "\n > Nombre: " + nombreUsuario + "\n > Fecha de nacimiento: " + fechaNacimiento
				+ "\n > Ciudad de residencia: " + ciudadResidencia + "\n";
	}

}
