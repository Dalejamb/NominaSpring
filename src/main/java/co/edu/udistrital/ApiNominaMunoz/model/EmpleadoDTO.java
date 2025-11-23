package co.edu.udistrital.ApiNominaMunoz.model;

import java.io.Serializable;

public class EmpleadoDTO extends PersonaDTO implements Serializable {

	private static final long serialVersionUID = -2932050586507168542L;

	private double salario_b;
	private String cargo;

	public EmpleadoDTO() {
		super();
	}

	public EmpleadoDTO(double salario_b, String cargo) {
		super();
		this.salario_b = salario_b;
		this.cargo = cargo;
	}

	public EmpleadoDTO(int id_p, String nombres, String apellidos, double salario_b, String cargo) {
		super(id_p, nombres, apellidos);
		this.salario_b = salario_b;
		this.cargo = cargo;
		// TODO Auto-generated constructor stub
	}

	public double getSalario_b() {
		return salario_b;
	}

	public void setSalario_b(double salario_b) {
		this.salario_b = salario_b;
	}

	public String getCargo() {
		return cargo;
	}

	public void setCargo(String cargo) {
		this.cargo = cargo;
	}
	
	

}
