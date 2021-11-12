package com.formacionbdi.microservicios.app.usuarios.controller;

import java.util.Optional;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.formacionbdi.microservicios.app.usuarios.models.entity.Alumno;
import com.formacionbdi.microservicios.app.usuarios.services.AlumnoService;

@RestController
public class AlumnoController {

	private AlumnoService service;

	@GetMapping("/listar")
	public ResponseEntity<?> listar() {
		return ResponseEntity.ok().body(service.findAll());

	}

	@GetMapping("/listar/{id}")
	public ResponseEntity<?> ver(@PathVariable Long id) {
		Optional<Alumno> o = service.findOne(id);
		if (o.isEmpty()) {
			return ResponseEntity.notFound().build();
		}
		return ResponseEntity.ok(o.get());
	}
	
	@PostMapping("/crear")
	public ResponseEntity<?> crear (@RequestBody Alumno alumno){
		Alumno alumnoDb = service.save(alumno);
		return ResponseEntity.status(HttpStatus.CREATED).body(alumnoDb);
	}
	
	@PutMapping("/editar")
	public ResponseEntity<?>  edita(@RequestBody Alumno alumno, @PathVariable Long id){
		Optional<Alumno> o = service.findOne(id);
		if (o.isEmpty()) {
			return ResponseEntity.notFound().build();
		}
		Alumno alumnoDb = o.get();
		alumnoDb.setNombre(alumno.getNombre());
		alumnoDb.setApellido(alumno.getApellido());
		alumnoDb.setEmail(alumno.getEmail());
		
		return ResponseEntity.status(HttpStatus.CREATED).body(service.save(alumnoDb));
	}
	
	@DeleteMapping("/eliminar/{id}")
	public  ResponseEntity<?>  eliminar(@PathVariable Long id) {
		service.delete(id);
		return  ResponseEntity.noContent().build();
	}
}
