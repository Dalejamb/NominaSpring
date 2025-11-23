package co.edu.udistrital.ApiNominaMunoz.repository;

import java.nio.file.Paths;
import java.util.List;

import org.springframework.stereotype.Repository;

import co.edu.udistrital.ApiNominaMunoz.model.NominaDTO;
import co.edu.udistrital.ApiNominaMunoz.util.StorageJSON;

@Repository
public class NominaRepository {

	private static final String FILE_PATH = Paths.get(System.getProperty("user.dir"), "data", "nominas.json")
			.toString();

	public NominaRepository() {
		System.out.println("Aqui FILE_PATH: " + NominaRepository.FILE_PATH);
	}

	public List<NominaDTO> findAll() {
		return StorageJSON.load(FILE_PATH, NominaDTO.class);
	}
	
	public void saveAll(List<NominaDTO> nominas) {
		StorageJSON.save(FILE_PATH, nominas);
	}

}
