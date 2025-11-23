package co.edu.udistrital.ApiNominaMunoz.model;

import java.io.Serializable;

public class NominaDTO implements Serializable {

	private static final long serialVersionUID = -6734018612638754590L;

	private EmpleadoDTO empleadoDTO;
	private String mes;
	private int dias_t;

	public static final double SALR_MINIMO = 1423500.0;
	public static final double SUB_TRANSP = 200000.0;

	public NominaDTO() {
		super();
	}

	public NominaDTO(EmpleadoDTO empleadoDTO, String mes, int dias_t) {
		super();
		this.empleadoDTO = empleadoDTO;
		this.mes = mes;
		this.dias_t = dias_t;
	}

	public EmpleadoDTO getEmpleadoDTO() {
		return empleadoDTO;
	}

	public void setEmpleadoDTO(EmpleadoDTO empleadoDTO) {
		this.empleadoDTO = empleadoDTO;
	}

	public String getMes() {
		return mes;
	}

	public void setMes(String mes) {
		this.mes = mes;
	}

	public int getDias_t() {
		return dias_t;
	}

	public void setDias_t(int dias_t) {
		this.dias_t = dias_t;
	}

	public static double getSalrMinimo() {
		return SALR_MINIMO;
	}

	public static double getSubTransp() {
		return SUB_TRANSP;
	}

	public double calSalarioMes() {
		return (empleadoDTO.getSalario_b() / 30) * dias_t;
	}

	public double subsidioTransp() {
		double valor = SUB_TRANSP;
		if (empleadoDTO.getSalario_b() > 0 
				&& empleadoDTO.getSalario_b() <= (SALR_MINIMO * 2)) {

			return (valor / 30) * dias_t;
		} else
			return 0;
	}
	
	public double descSalud() {
		double salud = calSalarioMes() * 0.04;
		if(salud>=(SALR_MINIMO * 0.04)) {
			return salud;
		}
		return (SALR_MINIMO * 0.04);
	}
	
	public double descPension() {
		double pension = calSalarioMes() * 0.04;
		if(pension>=(SALR_MINIMO * 0.04)) {
			return pension;
		}
		return (SALR_MINIMO * 0.04);
	}

}
