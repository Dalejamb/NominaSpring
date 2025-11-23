package co.edu.udistrital.ApiNominaMunoz.service;

import java.util.HashMap;
import java.util.List;

import org.springframework.stereotype.Service;

import co.edu.udistrital.ApiNominaMunoz.model.NominaDTO;
import co.edu.udistrital.ApiNominaMunoz.repository.NominaRepository;

@Service
public class NominaService {

	private final NominaRepository repo = new NominaRepository();

	
	public List<NominaDTO> listar(){
			return repo.findAll();
	}
	
	public NominaDTO buscarId(int id) {
		for(NominaDTO n : repo.findAll()) {
			if(n.getEmpleadoDTO().getId_p()==id) {
				System.out.println("Encontrado");
				return n;
			}
		}
		System.out.println("No existe");
		return null;
	}
	
	public void agregar(NominaDTO nuevo) {
		if(nuevo != null) {
			List<NominaDTO> lista = repo.findAll();
			lista.add(nuevo);
			repo.saveAll(lista);
			System.out.println("Nuevo es agregado");
		}else {
			System.out.println("Nuevo es null no se agrega");
		}
	}
	
	public boolean actualizar(int id, NominaDTO actual) {
		List<NominaDTO> lista = repo.findAll();
		for(int i=0; i<lista.size(); i++) {
			if(lista.get(i).getEmpleadoDTO().getId_p()==id) {
				lista.set(i, actual);
				repo.saveAll(lista);
				return true;
			}
		}
		return false;
	}
	
	public boolean borrar(int id) {
		List<NominaDTO> lista = repo.findAll();
		if(lista.removeIf(n->n.getEmpleadoDTO().getId_p()==id)) {
			repo.saveAll(lista);
			return true;
		}
		return false;
	}
	
	//Entregar los resultados de calcular la nomina
	
	public HashMap<String, Object> calPorId(int id){
		List<NominaDTO> lista = repo.findAll();
		HashMap<String , Object> map = new HashMap<String, Object>();
		for(NominaDTO n:lista) {
			if(n.getEmpleadoDTO().getId_p()==id) {
				System.out.println("R Encontrado");
				map.put("Nomina", n);
				map.put("desSalud", n.descSalud());
				map.put("desPension", n.descPension());
				map.put("salMes", n.calSalarioMes());
				map.put("subTransp", n.subsidioTransp());
				map.put("netoPagar", (n.calSalarioMes()-n.descSalud()-n.descPension()+n.subsidioTransp()));
				return map;
			}
		}
		System.out.println("No existe");
		return null;
	}
}
