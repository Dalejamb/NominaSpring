package co.edu.udistrital.ApiNominaMunoz.controller;

import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import co.edu.udistrital.ApiNominaMunoz.model.NominaDTO;
import co.edu.udistrital.ApiNominaMunoz.service.NominaService;

@RestController
@RequestMapping("/nomina")
public class NominaController {

	@Autowired
	private NominaService service;
	
	@GetMapping
	public ResponseEntity<List<NominaDTO>> getAll(){
		
		return ResponseEntity.ok(service.listar());
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<NominaDTO> getById(@PathVariable int id){
		NominaDTO n = service.buscarId(id);
		if(n != null) {
			return ResponseEntity.ok(n);
		}else {
			return ResponseEntity.notFound().build();
		}
	}
	
	@PostMapping
	public ResponseEntity<NominaDTO> create(@RequestBody NominaDTO nuevo){
		service.agregar(nuevo);
		return ResponseEntity.status(201).body(nuevo);
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<NominaDTO> update(@PathVariable int id, @RequestBody NominaDTO actual){
		if(service.actualizar(id, actual)) {
			return ResponseEntity.ok(actual);
		}else {
			return ResponseEntity.notFound().build();
		}
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<Void> delete (@PathVariable int id){
		if(service.borrar(id)){
			return ResponseEntity.noContent().build();
		}else {
			return ResponseEntity.notFound().build();
		}
	}
	
	@GetMapping("/calcular/{id}")
	public ResponseEntity<HashMap<String,Object>> getCalById(@PathVariable int id){
		HashMap<String,Object> map = service.calPorId(id);
		if(map!=null) {
			return ResponseEntity.ok(map);
		}else {
			return ResponseEntity.notFound().build();
		}
	}
}
