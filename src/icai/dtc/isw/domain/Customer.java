package icai.dtc.isw.domain;

import java.io.Serializable;

public class Customer implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String correo;
	private String password;
	
	public Customer() {
		this.setCorreo(new String());
		this.setPassword(new String());
	}
	
	public Customer(String correo, String password) {
		this.setCorreo(correo);
		this.setPassword(password);
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
	
	
}
