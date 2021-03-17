/**
 * @name:Usuarios
 * @description: clase molde que contiene los datos para crear usuarios
 * @date: 17/03/2021
 * @version: v1
 * @author: Antonia Hidalgo
 * 
 */

package model;

public class Usuario {
	
	// Hola

	private String nombreUsuario;
	private int fechaNacimiento;
	private String ciudadResidencia;

	public Usuario() {
		super();

	}

	public Usuario(String nombreUsuario, int fechaNacimiento, String ciudadResidencia) {
		super();
		this.nombreUsuario = nombreUsuario;
		this.fechaNacimiento = fechaNacimiento;
		this.ciudadResidencia = ciudadResidencia;
	}

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

	@Override
	public String toString() {
		return "Usuario [nombreUsuario=" + nombreUsuario + ", fechaNacimiento=" + fechaNacimiento
				+ ", ciudadResidencia=" + ciudadResidencia + "]";
	}

}
