package co.edu.udistrital.ApiNominaMunoz.model;

import java.io.Serializable;

public class PersonaDTO implements Serializable {

	private static final long serialVersionUID = -6102998203045618159L;

	private int id_p;
	private String nombres;
	private String apellidos;
	
	public PersonaDTO() {
	
	}

	public PersonaDTO(int id_p, String nombres, String apellidos) {
	
		this.id_p = id_p;
		this.nombres = nombres;
		this.apellidos = apellidos;
	}

	public int getId_p() {
		return id_p;
	}

	public void setId_p(int id_p) {
		this.id_p = id_p;
	}

	public String getNombres() {
		return nombres;
	}

	public void setNombres(String nombres) {
		this.nombres = nombres;
	}

	public String getApellidos() {
		return apellidos;
	}

	public void setApellidos(String apellidos) {
		this.apellidos = apellidos;
	}
	
	
	
	
}



