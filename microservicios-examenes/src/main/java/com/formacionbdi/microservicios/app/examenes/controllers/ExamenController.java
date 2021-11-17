package com.formacionbdi.microservicios.app.examenes.controllers;


import java.util.Optional;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.formacionbdi.microservicios.app.examenes.models.entity.Examen;
import com.formacionbdi.microservicios.app.examenes.service.ExamenService;
import com.formacionbdi.microservicios.commons.controllers.CommonController;

@RestController
public class ExamenController extends CommonController<Examen, ExamenService>{

	@PutMapping("/{id}")
	public ResponseEntity<?> editar(@RequestBody Examen examen,@PathVariable Long id ){
		Optional <Examen> o = service.findById(id);
		
		if(!o.isPresent()) {
			return ResponseEntity.notFound().build();
		}
		
		Examen examenDb =o.get();
		examenDb.setNombre(examen.getNombre());
		

		examenDb.getPreguntas()
		.stream().filter(pdb -> !examen.getPreguntas().contains(pdb))
		.forEach(examenDb::removePregunta);
		
		examenDb.setPreguntas(examen.getPreguntas());
		return ResponseEntity.status(HttpStatus.CREATED).body(service.save(examenDb));
	}
}
