package icai.dtc.isw.domain;

import java.io.Serializable;
import java.util.ArrayList;

public class Usuario implements Serializable{

	private String nombre;
	private String correo;
	private String password;
	private String rol;

	public Usuario(String nombre, String correo, String password, String rol) {
		this.setNombre(nombre);
		this.setCorreo(correo);
		this.setPassword(password);
		this.setRol(rol);
	}

	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getCorreo() {
		return correo;
	}
	public void setCorreo(String id) {
		this.correo = id;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String name) {
		this.password = name;
	}
	public String getRol() {
		return rol;
	}
	public void setRol(String rol) {
		this.rol = rol;
	}

	public ArrayList<String> getDatos() {
		ArrayList<String> stats = new ArrayList<>();

		stats.add(nombre);
		stats.add(correo);
		stats.add(password);
		stats.add(rol);

		return stats;
	}
	
}
